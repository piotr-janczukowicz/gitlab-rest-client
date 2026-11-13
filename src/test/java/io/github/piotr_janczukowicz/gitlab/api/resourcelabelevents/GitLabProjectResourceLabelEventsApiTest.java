package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

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
class GitLabProjectResourceLabelEventsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectResourceLabelEventsApi api() {
        return new GitLabProjectResourceLabelEventsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectResourceLabelEventsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listIssuesResourceLabelEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json") + "]"));

        final GitLabPage<GitLabResourceLabelEvent> page =
                api().listIssuesResourceLabelEvents("group/sub/project", "eventable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_label_events");
        });
    }

    @Test
    void listIssuesResourceLabelEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json") + "]"));

        final GitLabPage<GitLabResourceLabelEvent> page =
                api().listIssuesResourceLabelEvents("group/sub/project", "eventable_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_label_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getIssuesResourceLabelEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json")));

        final Optional<GitLabResourceLabelEvent> result =
                api().getIssuesResourceLabelEvents("group/sub/project", "eventable_id", "event_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_label_events/event_id");
        });
    }

    @Test
    void getIssuesResourceLabelEvents_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabResourceLabelEvent> result =
                api().getIssuesResourceLabelEvents("group/sub/project", "eventable_id", "event_id");

        assertThat(result).isEmpty();
    }

    @Test
    void listRequestsResourceLabelEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json") + "]"));

        final GitLabPage<GitLabResourceLabelEvent> page =
                api().listRequestsResourceLabelEvents("group/sub/project", "eventable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_label_events");
        });
    }

    @Test
    void listRequestsResourceLabelEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json") + "]"));

        final GitLabPage<GitLabResourceLabelEvent> page =
                api().listRequestsResourceLabelEvents("group/sub/project", "eventable_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_label_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getRequestsResourceLabelEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json")));

        final Optional<GitLabResourceLabelEvent> result =
                api().getRequestsResourceLabelEvents("group/sub/project", "eventable_id", "event_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_label_events/event_id");
        });
    }

    @Test
    void getRequestsResourceLabelEvents_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabResourceLabelEvent> result =
                api().getRequestsResourceLabelEvents("group/sub/project", "eventable_id", "event_id");

        assertThat(result).isEmpty();
    }
}
