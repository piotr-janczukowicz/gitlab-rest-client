package io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesStatisticsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectIssuesStatisticsApi api() {
        return new GitLabProjectIssuesStatisticsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectIssuesStatisticsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues_statistics");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        GitLabProjectIssuesStatisticsCallFilterBuilder.builder()
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesStatisticsCallMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesStatisticsCallNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesStatisticsCallScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesStatisticsCallHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("labels", "labels");
    }
}
