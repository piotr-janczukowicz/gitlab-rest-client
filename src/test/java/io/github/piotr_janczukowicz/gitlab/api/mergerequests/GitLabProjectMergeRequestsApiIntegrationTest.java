package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectMergeRequestsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listBlocks_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]"));

        final List<GitLabMergeRequestDependency> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listBlocks("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        MergerequestsCatalogFixtures.mergeRequestDependency(),
                        MergerequestsCatalogFixtures.mergeRequestDependency());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks", 2);
    }

    @Test
    void createBlock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .createBlock(
                            "group/sub/project",
                            1L,
                            MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks");
    }

    @Test
    void createBlock_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createBlock(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks");
    }

    @Test
    void callBlock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).callBlock("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1");
    }

    @Test
    void callBlock_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callBlock("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1");
    }

    @Test
    void deleteBlock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).deleteBlock("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1");
    }

    @Test
    void deleteBlock_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteBlock("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blocks/1");
    }

    @Test
    void listBlockees_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blockees",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blockees?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestDependency.class, "merge-request-dependency.json")
                                + "]"));

        final List<GitLabMergeRequestDependency> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listBlockees("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        MergerequestsCatalogFixtures.mergeRequestDependency(),
                        MergerequestsCatalogFixtures.mergeRequestDependency());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/blockees", 2);
    }

    @Test
    void createStatusCheckResponse_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_check_responses",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMergeRequestsStatusCheckResponse.class, "merge-requests-status-check-response.json")));

        final GitLabMergeRequestsStatusCheckResponse result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .createStatusCheckResponse(
                            "group/sub/project",
                            1L,
                            MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload());
        }

        assertThat(result).isEqualTo(MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_check_responses");
    }

    @Test
    void createStatusCheckResponse_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_check_responses",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createStatusCheckResponse(
                    "group/sub/project",
                    1L,
                    MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_check_responses");
    }

    @Test
    void createSuggestedReviewer_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/suggested_reviewers",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabAiSuggestedReviewer.class, "ai-suggested-reviewer.json") + "]"));

        final List<GitLabAiSuggestedReviewer> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .createSuggestedReviewer(
                            "group/sub/project",
                            1L,
                            MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload());
        }

        assertThat(result).containsExactly(MergerequestsCatalogFixtures.aiSuggestedReviewer());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/suggested_reviewers");
    }

    @Test
    void todo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/todo",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTodo.class, "todo.json")));

        final GitLabTodo result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).todo("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.todo());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/todo");
    }

    @Test
    void todo_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/todo", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.todo("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/todo");
    }

    @Test
    void subscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/subscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .subscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/subscribe");
    }

    @Test
    void subscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/subscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.subscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/subscribe");
    }

    @Test
    void unsubscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/unsubscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .unsubscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/unsubscribe");
    }

    @Test
    void unsubscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/unsubscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unsubscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/subscribable_id/unsubscribe");
    }

    @Test
    void listVersions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabMergeRequestDiff.class, "merge-request-diff.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestDiff.class, "merge-request-diff.json") + "]"));

        final List<GitLabMergeRequestDiff> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listVersions("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        MergerequestsCatalogFixtures.mergeRequestDiff(),
                        MergerequestsCatalogFixtures.mergeRequestDiff());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions", 2);
    }

    @Test
    void getVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMergeRequestDiffFull.class, "merge-request-diff-full.json")));

        final Optional<GitLabMergeRequestDiffFull> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).getVersion("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(MergerequestsCatalogFixtures.mergeRequestDiffFull());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions/1");
    }

    @Test
    void getVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .getVersion("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/versions/1");
    }

    @Test
    void approve_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approve",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMergeRequestApprovals.class, "merge-request-approvals.json")));

        final GitLabMergeRequestApprovals result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .approve(
                            "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequestApprovals());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approve");
    }

    @Test
    void approve_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approve",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.approve(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approve");
    }

    @Test
    void unapprove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/unapprove",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMergeRequestApprovals.class, "merge-request-approvals.json")));

        final GitLabMergeRequestApprovals result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).unapprove("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequestApprovals());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/unapprove");
    }

    @Test
    void unapprove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/unapprove",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unapprove("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/unapprove");
    }

    @Test
    void updateResetApproval_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_approvals",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).updateResetApproval("group/sub/project", 1L);
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_approvals");
    }

    @Test
    void updateResetApproval_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_approvals",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateResetApproval("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_approvals");
    }

    @Test
    void getApprovalState_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_state",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMergeRequestApprovalState.class, "merge-request-approval-state.json")));

        final Optional<GitLabMergeRequestApprovalState> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .getApprovalState("group/sub/project", 1L);
        }

        assertThat(result).contains(MergerequestsCatalogFixtures.mergeRequestApprovalState());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_state");
    }

    @Test
    void getApprovalState_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_state",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .getApprovalState("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_state");
    }

    @Test
    void timeEstimate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_estimate",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .timeEstimate(
                            "group/sub/project",
                            1L,
                            MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_estimate");
    }

    @Test
    void timeEstimate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_estimate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.timeEstimate(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_estimate");
    }

    @Test
    void resetTimeEstimate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_time_estimate",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .resetTimeEstimate("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_time_estimate");
    }

    @Test
    void resetTimeEstimate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_time_estimate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetTimeEstimate("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_time_estimate");
    }

    @Test
    void addSpentTime_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/add_spent_time",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .addSpentTime(
                            "group/sub/project",
                            1L,
                            MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/add_spent_time");
    }

    @Test
    void addSpentTime_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/add_spent_time",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.addSpentTime(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/add_spent_time");
    }

    @Test
    void resetSpentTime_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_spent_time",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).resetSpentTime("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_spent_time");
    }

    @Test
    void resetSpentTime_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_spent_time",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetSpentTime("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reset_spent_time");
    }

    @Test
    void getTimeStats_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_stats",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final Optional<GitLabIssuableTimeStats> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).getTimeStats("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_stats");
    }

    @Test
    void getTimeStats_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_stats",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .getTimeStats("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/time_stats");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final List<GitLabMergeRequestBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.mergeRequestBasic(), CommonCatalogFixtures.mergeRequestBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .create("group/sub/project", MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final Optional<GitLabMergeRequest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1");
    }

    @Test
    void listParticipants_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/participants",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listParticipants("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/participants");
    }

    @Test
    void listReviewers_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reviewers",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabMergeRequestReviewer.class, "merge-request-reviewer.json") + "]"));

        final List<GitLabMergeRequestReviewer> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).listReviewers("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(MergerequestsCatalogFixtures.mergeRequestReviewer());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/reviewers");
    }

    @Test
    void listCommits_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/commits",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/commits?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final List<GitLabCommit> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listCommits("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.commit(), CommonCatalogFixtures.commit());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/commits", 2);
    }

    @Test
    void getChanges_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/changes",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMergeRequestChanges.class, "merge-request-changes.json")));

        final Optional<GitLabMergeRequestChanges> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).getChanges("group/sub/project", 1L);
        }

        assertThat(result).contains(MergerequestsCatalogFixtures.mergeRequestChanges());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/changes");
    }

    @Test
    void getChanges_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/changes",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .getChanges("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/changes");
    }

    @Test
    void listDiffs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final List<GitLabDiff> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listDiffs("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.diff(), CommonCatalogFixtures.diff());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/diffs", 2);
    }

    @Test
    void callRawDiffs_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/raw_diffs",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).callRawDiffs("group/sub/project", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/raw_diffs");
    }

    @Test
    void callRawDiffs_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/raw_diffs",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callRawDiffs("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/raw_diffs");
    }

    @Test
    void listPipelines_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final List<GitLabCiPipelineBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).listPipelines("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines");
    }

    @Test
    void createPipeline_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .createPipeline(
                            "group/sub/project",
                            1L,
                            MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines");
    }

    @Test
    void createPipeline_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createPipeline(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/pipelines");
    }

    @Test
    void merge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .merge("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsMergePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge");
    }

    @Test
    void merge_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.merge(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsMergePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge");
    }

    @Test
    void callMergeRef_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge_ref",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).callMergeRef("group/sub/project", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge_ref");
    }

    @Test
    void callMergeRef_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge_ref",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callMergeRef("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/merge_ref");
    }

    @Test
    void createCancelMergeWhenPipelineSucceed_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_merge_when_pipeline_succeeds",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .createCancelMergeWhenPipelineSucceed("group/sub/project", 1L);
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_merge_when_pipeline_succeeds");
    }

    @Test
    void createCancelMergeWhenPipelineSucceed_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_merge_when_pipeline_succeeds",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createCancelMergeWhenPipelineSucceed("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_merge_when_pipeline_succeeds");
    }

    @Test
    void cancelAutoMerge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_auto_merge",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).cancelAutoMerge("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_auto_merge");
    }

    @Test
    void cancelAutoMerge_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_auto_merge",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.cancelAutoMerge("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/cancel_auto_merge");
    }

    @Test
    void rebase_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/rebase",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .rebase("group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/rebase");
    }

    @Test
    void rebase_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/rebase", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rebase(
                    "group/sub/project", 1L, MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/rebase");
    }

    @Test
    void listClosesIssues_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/closes_issues",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabIssueBasic.class, "issue-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/closes_issues?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabIssueBasic.class, "issue-basic.json") + "]"));

        final List<GitLabIssueBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client))
                    .listClosesIssues("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.issueBasic(), CommonCatalogFixtures.issueBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/closes_issues", 2);
    }

    @Test
    void callRelatedIssues_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/related_issues",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestsApi(GitLabCaller.of(client)).callRelatedIssues("group/sub/project", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/related_issues");
    }

    @Test
    void callRelatedIssues_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/related_issues",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestsApi api = new GitLabProjectMergeRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callRelatedIssues("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/related_issues");
    }
}
