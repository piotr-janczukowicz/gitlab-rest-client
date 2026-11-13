package io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabKnowledgeGraphApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getNamespaces_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/knowledge_graph/namespaces",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAnalyticsKnowledgeGraphEnabledNamespace.class,
                        "analytics-knowledge-graph-enabled-namespace.json")));

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKnowledgeGraphApi(GitLabCaller.of(client)).getNamespaces();
        }

        assertThat(result).isEqualTo(KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace());
        HTTP.verifyRequested(GET, "/api/v4/admin/knowledge_graph/namespaces");
    }

    @Test
    void getNamespaces_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/knowledge_graph/namespaces", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKnowledgeGraphApi api = new GitLabKnowledgeGraphApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getNamespaces());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/admin/knowledge_graph/namespaces");
    }

    @Test
    void updateNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAnalyticsKnowledgeGraphEnabledNamespace.class,
                        "analytics-knowledge-graph-enabled-namespace.json")));

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKnowledgeGraphApi(GitLabCaller.of(client)).updateNamespace("group/sub/project");
        }

        assertThat(result).isEqualTo(KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace());
        HTTP.verifyRequested(PUT, "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void updateNamespace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKnowledgeGraphApi api = new GitLabKnowledgeGraphApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateNamespace("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void deleteNamespace_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabKnowledgeGraphApi(GitLabCaller.of(client)).deleteNamespace("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void deleteNamespace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKnowledgeGraphApi api = new GitLabKnowledgeGraphApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteNamespace("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin/knowledge_graph/namespaces/group%2Fsub%2Fproject");
    }
}
