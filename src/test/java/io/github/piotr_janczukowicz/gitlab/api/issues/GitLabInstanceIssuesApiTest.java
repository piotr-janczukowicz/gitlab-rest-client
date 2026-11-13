package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
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
class GitLabInstanceIssuesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceIssuesApi api() {
        return new GitLabInstanceIssuesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceIssuesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callIssuesStatistics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callIssuesStatistics();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/issues_statistics");
    }

    @Test
    void callIssuesStatistics_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callIssuesStatistics());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callIssuesStatistics_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callIssuesStatistics(GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("labels", "labels");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]"));

        final GitLabPage<GitLabIssue> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(IssuesCatalogFixtures.issue());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/issues");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]"));

        final GitLabPage<GitLabIssue> page = api().list(GitLabInstanceIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabInstanceIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabInstanceIssuesListOrderBy.CREATED_AT)
                .sort(GitLabInstanceIssuesListSort.ASC)
                .dueDate(GitLabInstanceIssuesListDueDate.EMPTY)
                .issueType(GitLabInstanceIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabInstanceIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabInstanceIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabInstanceIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabInstanceIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(IssuesCatalogFixtures.issue());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/issues");
            softly.assertThat(request.uri()).hasParameter("with_labels_details", "true");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]"));

        final GitLabPage<GitLabIssue> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(IssuesCatalogFixtures.issue());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/issues");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]"));

        final GitLabPage<GitLabIssue> page = api().list(
                        GitLabInstanceIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabInstanceIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabInstanceIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceIssuesListSort.ASC)
                                .dueDate(GitLabInstanceIssuesListDueDate.EMPTY)
                                .issueType(GitLabInstanceIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabInstanceIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabInstanceIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabInstanceIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabInstanceIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(IssuesCatalogFixtures.issue());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/issues");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("with_labels_details", "true");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabIssue.class, "issue.json")));

        final Optional<GitLabIssue> result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(IssuesCatalogFixtures.issue());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/issues/group%2Fsub%2Fproject");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIssue> result = api().get("group/sub/project");

        assertThat(result).isEmpty();
    }
}
