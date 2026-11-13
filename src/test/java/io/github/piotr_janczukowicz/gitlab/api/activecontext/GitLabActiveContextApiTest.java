package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabActiveContextApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabActiveContextApi api() {
        return new GitLabActiveContextApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabActiveContextApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getConnections_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiActiveContextConnection.class, "ai-active-context-connection.json")));

        final GitLabAiActiveContextConnection result = api().getConnections();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextConnection());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/active_context/connections");
        });
    }

    @Test
    void getConnections_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getConnections());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void activateConnection_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiActiveContextConnection.class, "ai-active-context-connection.json")));

        final GitLabAiActiveContextConnection result =
                api().activateConnection(ActivecontextCatalogFixtures.activeContextActivateConnectionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextConnection());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/active_context/connections/activate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"connection_id\":");
        });
    }

    @Test
    void activateConnection_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().activateConnection(ActivecontextCatalogFixtures.activeContextActivateConnectionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deactivateConnection_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiActiveContextConnection.class, "ai-active-context-connection.json")));

        final GitLabAiActiveContextConnection result =
                api().deactivateConnection(ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextConnection());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/active_context/connections/deactivate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"connection_id\":");
        });
    }

    @Test
    void deactivateConnection_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().deactivateConnection(ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateCollection_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiActiveContextCollection.class, "ai-active-context-collection.json")));

        final GitLabAiActiveContextCollection result = api().updateCollection(
                        "group/sub/project", ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextCollection());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/active_context/collections/group%2Fsub%2Fproject");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"queue_shard_count\":");
        });
    }

    @Test
    void updateCollection_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateCollection(
                        "group/sub/project", ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteDeadQueue_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteDeadQueue();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/admin/active_context/dead_queue");
    }

    @Test
    void deleteDeadQueue_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteDeadQueue());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void replayDeadQueue_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().replayDeadQueue(ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/admin/active_context/dead_queue/replay");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"queue\":");
        });
    }

    @Test
    void replayDeadQueue_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().replayDeadQueue(ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateCodeEnabledNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiActiveContextCodeEnabledNamespace.class,
                                "ai-active-context-code-enabled-namespace.json")));

        final GitLabAiActiveContextCodeEnabledNamespace result = api().updateCodeEnabledNamespace(
                        ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/active_context/code/enabled_namespaces");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"namespace_id\":");
        });
    }

    @Test
    void updateCodeEnabledNamespace_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateCodeEnabledNamespace(
                        ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
