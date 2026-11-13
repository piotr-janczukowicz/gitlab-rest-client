package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployment;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
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
class GitLabProjectDeploymentsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectDeploymentsApi api() {
        return new GitLabProjectDeploymentsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectDeploymentsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDeployment.class, "deployment.json") + "]"));

        final GitLabPage<GitLabDeployment> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.deployment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDeployment.class, "deployment.json") + "]"));

        final GitLabPage<GitLabDeployment> page = api().list(
                        "group/sub/project",
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.deployment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDeployment.class, "deployment.json") + "]"));

        final GitLabPage<GitLabDeployment> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.deployment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDeployment.class, "deployment.json") + "]"));

        final GitLabPage<GitLabDeployment> page = api().list(
                        "group/sub/project",
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.deployment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabDeploymentExtended.class, "deployment-extended.json")));

        final GitLabDeploymentExtended result =
                api().create("group/sub/project", DeploymentsCatalogFixtures.projectDeploymentsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DeploymentsCatalogFixtures.deploymentExtended());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/deployments");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"environment\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create("group/sub/project", DeploymentsCatalogFixtures.projectDeploymentsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabDeploymentExtended.class, "deployment-extended.json")));

        final Optional<GitLabDeploymentExtended> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DeploymentsCatalogFixtures.deploymentExtended());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabDeploymentExtended> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabDeploymentExtended.class, "deployment-extended.json")));

        final GitLabDeploymentExtended result =
                api().update("group/sub/project", 1L, DeploymentsCatalogFixtures.projectDeploymentsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DeploymentsCatalogFixtures.deploymentExtended());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/deployments/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().update("group/sub/project", 1L, DeploymentsCatalogFixtures.projectDeploymentsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/deployments/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().listMergeRequests("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments/1/merge_requests");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().listMergeRequests(
                        "group/sub/project",
                        1L,
                        GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments/1/merge_requests");
            softly.assertThat(request.uri()).hasParameter("author_id", "1");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page =
                api().listMergeRequests("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments/1/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().listMergeRequests(
                        "group/sub/project",
                        1L,
                        GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/deployments/1/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("author_id", "1");
        });
    }

    @Test
    void approval_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectDeploymentsApi lowTier =
                new GitLabProjectDeploymentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.approval(
                "group/sub/project", 1L, DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void approval_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectDeploymentsApi lowTier =
                new GitLabProjectDeploymentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.approval(
                "group/sub/project", 1L, DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void approval_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabDeploymentApproval.class, "deployment-approval.json")));

        final GitLabDeploymentApproval result =
                api().approval("group/sub/project", 1L, DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DeploymentsCatalogFixtures.deploymentApproval());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/deployments/1/approval");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void approval_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().approval(
                        "group/sub/project", 1L, DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
