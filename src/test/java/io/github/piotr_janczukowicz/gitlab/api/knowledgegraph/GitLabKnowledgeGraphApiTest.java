package io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabKnowledgeGraphApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabKnowledgeGraphApi api() {
        return new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabKnowledgeGraphApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getNamespaces_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabKnowledgeGraphApi lowTier =
                new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getNamespaces());

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getNamespaces_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabKnowledgeGraphApi lowTier =
                new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getNamespaces());

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getNamespaces_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAnalyticsKnowledgeGraphEnabledNamespace.class,
                                "analytics-knowledge-graph-enabled-namespace.json")));

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace result = api().getNamespaces();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/knowledge_graph/namespaces");
        });
    }

    @Test
    void getNamespaces_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getNamespaces());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateNamespace_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabKnowledgeGraphApi lowTier =
                new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateNamespace("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateNamespace_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabKnowledgeGraphApi lowTier =
                new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateNamespace("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAnalyticsKnowledgeGraphEnabledNamespace.class,
                                "analytics-knowledge-graph-enabled-namespace.json")));

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace result = api().updateNamespace("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject");
        });
    }

    @Test
    void updateNamespace_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateNamespace("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteNamespace_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabKnowledgeGraphApi lowTier =
                new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteNamespace("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteNamespace_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabKnowledgeGraphApi lowTier =
                new GitLabKnowledgeGraphApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteNamespace("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteNamespace_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteNamespace("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void deleteNamespace_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteNamespace("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
