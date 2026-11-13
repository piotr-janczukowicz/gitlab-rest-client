package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabActiveContextApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getConnections_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/active_context/connections",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiActiveContextConnection.class, "ai-active-context-connection.json")));

        final GitLabAiActiveContextConnection result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabActiveContextApi(GitLabCaller.of(client)).getConnections();
        }

        assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextConnection());
        HTTP.verifyRequested(GET, "/api/v4/admin/active_context/connections");
    }

    @Test
    void getConnections_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/active_context/connections", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getConnections());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/admin/active_context/connections");
    }

    @Test
    void activateConnection_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/active_context/connections/activate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiActiveContextConnection.class, "ai-active-context-connection.json")));

        final GitLabAiActiveContextConnection result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabActiveContextApi(GitLabCaller.of(client))
                    .activateConnection(ActivecontextCatalogFixtures.activeContextActivateConnectionPayload());
        }

        assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextConnection());
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/connections/activate");
    }

    @Test
    void activateConnection_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/active_context/connections/activate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.activateConnection(ActivecontextCatalogFixtures.activeContextActivateConnectionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/connections/activate");
    }

    @Test
    void deactivateConnection_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/active_context/connections/deactivate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiActiveContextConnection.class, "ai-active-context-connection.json")));

        final GitLabAiActiveContextConnection result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabActiveContextApi(GitLabCaller.of(client))
                    .deactivateConnection(ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload());
        }

        assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextConnection());
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/connections/deactivate");
    }

    @Test
    void deactivateConnection_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/active_context/connections/deactivate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.deactivateConnection(ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/connections/deactivate");
    }

    @Test
    void updateCollection_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/active_context/collections/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiActiveContextCollection.class, "ai-active-context-collection.json")));

        final GitLabAiActiveContextCollection result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabActiveContextApi(GitLabCaller.of(client))
                    .updateCollection(
                            "group/sub/project", ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload());
        }

        assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextCollection());
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/collections/group%2Fsub%2Fproject");
    }

    @Test
    void updateCollection_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/admin/active_context/collections/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateCollection(
                    "group/sub/project", ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/collections/group%2Fsub%2Fproject");
    }

    @Test
    void deleteDeadQueue_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/active_context/dead_queue", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabActiveContextApi(GitLabCaller.of(client)).deleteDeadQueue();
        }

        HTTP.verifyRequested(DELETE, "/api/v4/admin/active_context/dead_queue");
    }

    @Test
    void deleteDeadQueue_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/active_context/dead_queue", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteDeadQueue());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin/active_context/dead_queue");
    }

    @Test
    void replayDeadQueue_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/admin/active_context/dead_queue/replay", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabActiveContextApi(GitLabCaller.of(client))
                    .replayDeadQueue(ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/admin/active_context/dead_queue/replay");
    }

    @Test
    void replayDeadQueue_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/admin/active_context/dead_queue/replay", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.replayDeadQueue(ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/admin/active_context/dead_queue/replay");
    }

    @Test
    void updateCodeEnabledNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/active_context/code/enabled_namespaces",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiActiveContextCodeEnabledNamespace.class,
                        "ai-active-context-code-enabled-namespace.json")));

        final GitLabAiActiveContextCodeEnabledNamespace result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabActiveContextApi(GitLabCaller.of(client))
                    .updateCodeEnabledNamespace(
                            ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload());
        }

        assertThat(result).isEqualTo(ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace());
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/code/enabled_namespaces");
    }

    @Test
    void updateCodeEnabledNamespace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/active_context/code/enabled_namespaces", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabActiveContextApi api = new GitLabActiveContextApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateCodeEnabledNamespace(
                    ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/active_context/code/enabled_namespaces");
    }
}
