package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMergeRequestsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupMergeRequestsApi api() {
        return new GitLabGroupMergeRequestsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupMergeRequestsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
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
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/merge_requests");
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
                        GitLabGroupMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabGroupMergeRequestsListState.OPENED)
                                .orderBy(GitLabGroupMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabGroupMergeRequestsListView.SIMPLE)
                                .scope(GitLabGroupMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabGroupMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/merge_requests");
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
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/merge_requests");
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
                        GitLabGroupMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabGroupMergeRequestsListState.OPENED)
                                .orderBy(GitLabGroupMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabGroupMergeRequestsListView.SIMPLE)
                                .scope(GitLabGroupMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabGroupMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("author_id", "1");
        });
    }
}
