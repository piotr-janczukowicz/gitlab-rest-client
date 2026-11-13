package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

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
class GitLabProjectResourceStateEventsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectResourceStateEventsApi api() {
        return new GitLabProjectResourceStateEventsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectResourceStateEventsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listIssuesResourceStateEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json") + "]"));

        final GitLabPage<GitLabResourceStateEvent> page = api().listIssuesResourceStateEvents("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcestateeventsCatalogFixtures.resourceStateEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events");
        });
    }

    @Test
    void listIssuesResourceStateEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json") + "]"));

        final GitLabPage<GitLabResourceStateEvent> page =
                api().listIssuesResourceStateEvents("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcestateeventsCatalogFixtures.resourceStateEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getIssuesResourceStateEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json")));

        final Optional<GitLabResourceStateEvent> result =
                api().getIssuesResourceStateEvents("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcestateeventsCatalogFixtures.resourceStateEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events/1");
        });
    }

    @Test
    void getIssuesResourceStateEvents_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabResourceStateEvent> result =
                api().getIssuesResourceStateEvents("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listRequestsResourceStateEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json") + "]"));

        final GitLabPage<GitLabResourceStateEvent> page =
                api().listRequestsResourceStateEvents("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcestateeventsCatalogFixtures.resourceStateEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events");
        });
    }

    @Test
    void listRequestsResourceStateEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json") + "]"));

        final GitLabPage<GitLabResourceStateEvent> page =
                api().listRequestsResourceStateEvents("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcestateeventsCatalogFixtures.resourceStateEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getRequestsResourceStateEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json")));

        final Optional<GitLabResourceStateEvent> result =
                api().getRequestsResourceStateEvents("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcestateeventsCatalogFixtures.resourceStateEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events/1");
        });
    }

    @Test
    void getRequestsResourceStateEvents_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabResourceStateEvent> result =
                api().getRequestsResourceStateEvents("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }
}
