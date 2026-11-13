package io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectResourceMilestoneEventsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectResourceMilestoneEventsApi api() {
        return new GitLabProjectResourceMilestoneEventsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectResourceMilestoneEventsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listIssuesResourceMilestoneEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]"));

        final GitLabPage<GitLabResourceMilestoneEvent> page =
                api().listIssuesResourceMilestoneEvents("group/sub/project", "eventable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events");
        });
    }

    @Test
    void listIssuesResourceMilestoneEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]"));

        final GitLabPage<GitLabResourceMilestoneEvent> page =
                api().listIssuesResourceMilestoneEvents("group/sub/project", "eventable_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getIssuesResourceMilestoneEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")));

        final Optional<GitLabResourceMilestoneEvent> result =
                api().getIssuesResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events/event_id");
        });
    }

    @Test
    void getIssuesResourceMilestoneEvents_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabResourceMilestoneEvent> result =
                api().getIssuesResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id");

        assertThat(result).isEmpty();
    }

    @Test
    void listRequestsResourceMilestoneEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]"));

        final GitLabPage<GitLabResourceMilestoneEvent> page =
                api().listRequestsResourceMilestoneEvents("group/sub/project", "eventable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events");
        });
    }

    @Test
    void listRequestsResourceMilestoneEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]"));

        final GitLabPage<GitLabResourceMilestoneEvent> page = api().listRequestsResourceMilestoneEvents(
                        "group/sub/project", "eventable_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getRequestsResourceMilestoneEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")));

        final Optional<GitLabResourceMilestoneEvent> result =
                api().getRequestsResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events/event_id");
        });
    }

    @Test
    void getRequestsResourceMilestoneEvents_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabResourceMilestoneEvent> result =
                api().getRequestsResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id");

        assertThat(result).isEmpty();
    }
}
