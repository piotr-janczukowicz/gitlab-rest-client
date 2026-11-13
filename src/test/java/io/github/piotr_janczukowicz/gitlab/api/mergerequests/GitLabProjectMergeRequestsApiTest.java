package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssuableTimeStats;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssueBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequest;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestApprovals;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectMergeRequestsApi api() {
        return new GitLabProjectMergeRequestsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectMergeRequestsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listBlocks_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]"));

        final GitLabPage<GitLabMergeRequestDependency> page = api().listBlocks("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergerequestsCatalogFixtures.mergeRequestDependency());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks");
        });
    }

    @Test
    void listBlocks_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]"));

        final GitLabPage<GitLabMergeRequestDependency> page =
                api().listBlocks("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergerequestsCatalogFixtures.mergeRequestDependency());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createBlock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createBlock(
                        "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"blocking_merge_request_id\":");
        });
    }

    @Test
    void createBlock_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createBlock(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callBlock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callBlock("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1");
    }

    @Test
    void callBlock_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callBlock("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteBlock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteBlock("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1");
    }

    @Test
    void deleteBlock_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteBlock("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listBlockees_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]"));

        final GitLabPage<GitLabMergeRequestDependency> page = api().listBlockees("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergerequestsCatalogFixtures.mergeRequestDependency());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blockees");
        });
    }

    @Test
    void listBlockees_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]"));

        final GitLabPage<GitLabMergeRequestDependency> page =
                api().listBlockees("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergerequestsCatalogFixtures.mergeRequestDependency());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blockees");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createStatusCheckResponse_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestsApi lowTier =
                new GitLabProjectMergeRequestsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createStatusCheckResponse(
                "group/sub/project",
                1L,
                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createStatusCheckResponse_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestsApi lowTier =
                new GitLabProjectMergeRequestsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createStatusCheckResponse(
                "group/sub/project",
                1L,
                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createStatusCheckResponse_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestsStatusCheckResponse.class,
                                "merge-requests-status-check-response.json")));

        final GitLabMergeRequestsStatusCheckResponse result = api().createStatusCheckResponse(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_check_responses");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"external_status_check_id\":");
        });
    }

    @Test
    void createStatusCheckResponse_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createStatusCheckResponse(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSuggestedReviewer_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabAiSuggestedReviewer.class, "ai-suggested-reviewer.json")
                                + "]"));

        final List<GitLabAiSuggestedReviewer> result = api().createSuggestedReviewer(
                        "group/sub/project", 1L, MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(MergerequestsCatalogFixtures.aiSuggestedReviewer());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/suggested_reviewers");
        });
    }

    @Test
    void todo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabTodo.class, "todo.json")));

        final GitLabTodo result = api().todo("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.todo());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/todo");
        });
    }

    @Test
    void todo_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().todo("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void subscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result = api().subscribe("group/sub/project", "subscribable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/subscribe");
        });
    }

    @Test
    void subscribe_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().subscribe("group/sub/project", "subscribable_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unsubscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result = api().unsubscribe("group/sub/project", "subscribable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/unsubscribe");
        });
    }

    @Test
    void unsubscribe_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unsubscribe("group/sub/project", "subscribable_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listVersions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestDiff.class, "merge-request-diff.json") + "]"));

        final GitLabPage<GitLabMergeRequestDiff> page = api().listVersions("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergerequestsCatalogFixtures.mergeRequestDiff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions");
        });
    }

    @Test
    void listVersions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestDiff.class, "merge-request-diff.json") + "]"));

        final GitLabPage<GitLabMergeRequestDiff> page =
                api().listVersions("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergerequestsCatalogFixtures.mergeRequestDiff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestDiffFull.class, "merge-request-diff-full.json")));

        final Optional<GitLabMergeRequestDiffFull> result = api().getVersion("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(MergerequestsCatalogFixtures.mergeRequestDiffFull());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions/1");
        });
    }

    @Test
    void getVersion_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeRequestDiffFull> result = api().getVersion("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getVersion_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestDiffFull.class, "merge-request-diff-full.json")));

        api().getVersion(
                        "group/sub/project",
                        1L,
                        1L,
                        GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                                .unidiff(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("unidiff", "true");
    }

    @Test
    void approve_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestApprovals.class, "merge-request-approvals.json")));

        final GitLabMergeRequestApprovals result = api().approve(
                        "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequestApprovals());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approve");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"sha\":");
        });
    }

    @Test
    void approve_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().approve(
                        "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unapprove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestApprovals.class, "merge-request-approvals.json")));

        final GitLabMergeRequestApprovals result = api().unapprove("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequestApprovals());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/unapprove");
        });
    }

    @Test
    void unapprove_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unapprove("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateResetApproval_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateResetApproval("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_approvals");
    }

    @Test
    void updateResetApproval_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateResetApproval("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getApprovalState_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestsApi lowTier =
                new GitLabProjectMergeRequestsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovalState("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getApprovalState_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestsApi lowTier =
                new GitLabProjectMergeRequestsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovalState("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getApprovalState_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestApprovalState.class, "merge-request-approval-state.json")));

        final Optional<GitLabMergeRequestApprovalState> result = api().getApprovalState("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(MergerequestsCatalogFixtures.mergeRequestApprovalState());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_state");
        });
    }

    @Test
    void getApprovalState_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeRequestApprovalState> result = api().getApprovalState("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void timeEstimate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result = api().timeEstimate(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_estimate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"duration\":");
        });
    }

    @Test
    void timeEstimate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().timeEstimate(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void resetTimeEstimate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result = api().resetTimeEstimate("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_time_estimate");
        });
    }

    @Test
    void resetTimeEstimate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resetTimeEstimate("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void addSpentTime_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result = api().addSpentTime(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/add_spent_time");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"duration\":");
        });
    }

    @Test
    void addSpentTime_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().addSpentTime(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void resetSpentTime_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result = api().resetSpentTime("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_spent_time");
        });
    }

    @Test
    void resetSpentTime_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resetSpentTime("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getTimeStats_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final Optional<GitLabIssuableTimeStats> result = api().getTimeStats("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_stats");
        });
    }

    @Test
    void getTimeStats_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIssuableTimeStats> result = api().getTimeStats("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().list(
                        "group/sub/project",
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests");
            softly.assertThat(request.uri()).hasParameter("author_id", "1");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().list(
                        "group/sub/project",
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("author_id", "1");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result =
                api().create("group/sub/project", MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"title\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create("group/sub/project", MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final Optional<GitLabMergeRequest> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeRequest> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        api().get(
                        "group/sub/project",
                        1L,
                        GitLabProjectMergeRequestsGetFilterBuilder.builder()
                                .renderHtml(true)
                                .includeDivergedCommitsCount(true)
                                .includeRebaseInProgress(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("render_html", "true");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result =
                api().update("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"title\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listParticipants_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> result = api().listParticipants("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/participants");
        });
    }

    @Test
    void listReviewers_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestReviewer.class, "merge-request-reviewer.json")
                                + "]"));

        final List<GitLabMergeRequestReviewer> result = api().listReviewers("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(MergerequestsCatalogFixtures.mergeRequestReviewer());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reviewers");
        });
    }

    @Test
    void listCommits_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final GitLabPage<GitLabCommit> page = api().listCommits("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/commits");
        });
    }

    @Test
    void listCommits_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final GitLabPage<GitLabCommit> page = api().listCommits("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/commits");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getChanges_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestChanges.class, "merge-request-changes.json")));

        final Optional<GitLabMergeRequestChanges> result = api().getChanges("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(MergerequestsCatalogFixtures.mergeRequestChanges());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/changes");
        });
    }

    @Test
    void getChanges_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeRequestChanges> result = api().getChanges("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getChanges_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestChanges.class, "merge-request-changes.json")));

        api().getChanges(
                        "group/sub/project",
                        1L,
                        GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                                .unidiff(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("unidiff", "true");
    }

    @Test
    void listDiffs_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiffs("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs");
        });
    }

    @Test
    void listDiffs_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiffs(
                        "group/sub/project",
                        1L,
                        GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                                .unidiff(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs");
            softly.assertThat(request.uri()).hasParameter("unidiff", "true");
        });
    }

    @Test
    void listDiffs_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiffs("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listDiffs_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiffs(
                        "group/sub/project",
                        1L,
                        GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                                .unidiff(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("unidiff", "true");
        });
    }

    @Test
    void callRawDiffs_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callRawDiffs("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/raw_diffs");
    }

    @Test
    void callRawDiffs_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callRawDiffs("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listPipelines_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final List<GitLabCiPipelineBasic> result = api().listPipelines("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines");
        });
    }

    @Test
    void createPipeline_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result = api().createPipeline(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"async\":");
        });
    }

    @Test
    void createPipeline_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createPipeline(
                        "group/sub/project",
                        1L,
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void merge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result =
                api().merge("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsMergePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"merge_commit_message\":");
        });
    }

    @Test
    void merge_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().merge("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsMergePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callMergeRef_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMergeRef("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge_ref");
    }

    @Test
    void callMergeRef_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callMergeRef("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createCancelMergeWhenPipelineSucceed_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createCancelMergeWhenPipelineSucceed("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_merge_when_pipeline_succeeds");
    }

    @Test
    void createCancelMergeWhenPipelineSucceed_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createCancelMergeWhenPipelineSucceed("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void cancelAutoMerge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result = api().cancelAutoMerge("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_auto_merge");
        });
    }

    @Test
    void cancelAutoMerge_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().cancelAutoMerge("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rebase_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().rebase("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/rebase");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"skip_ci\":");
        });
    }

    @Test
    void rebase_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().rebase(
                        "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listClosesIssues_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabIssueBasic.class, "issue-basic.json") + "]"));

        final GitLabPage<GitLabIssueBasic> page = api().listClosesIssues("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.issueBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/closes_issues");
        });
    }

    @Test
    void listClosesIssues_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabIssueBasic.class, "issue-basic.json") + "]"));

        final GitLabPage<GitLabIssueBasic> page =
                api().listClosesIssues("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.issueBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/closes_issues");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void callRelatedIssues_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callRelatedIssues("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/related_issues");
    }

    @Test
    void callRelatedIssues_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callRelatedIssues("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
