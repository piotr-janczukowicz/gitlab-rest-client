package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabCodeSearchApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void indexProject_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/zoekt/projects/1/index",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSearchZoektProjectIndexSuccess.class, "search-zoekt-project-index-success.json")));

        final GitLabSearchZoektProjectIndexSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSearchApi(GitLabCaller.of(client)).indexProject(1L);
        }

        assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektProjectIndexSuccess());
        HTTP.verifyRequested(PUT, "/api/v4/admin/zoekt/projects/1/index");
    }

    @Test
    void indexProject_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/zoekt/projects/1/index", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSearchApi api = new GitLabCodeSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.indexProject(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/zoekt/projects/1/index");
    }

    @Test
    void updateNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/admin/zoekt/namespaces/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSearchZoektIndexedNamespace.class, "search-zoekt-indexed-namespace.json")));

        final GitLabSearchZoektIndexedNamespace result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSearchApi(GitLabCaller.of(client))
                    .updateNamespace("group/sub/project", CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload());
        }

        assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektIndexedNamespace());
        HTTP.verifyRequested(PATCH, "/api/v4/admin/zoekt/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void updateNamespace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/admin/zoekt/namespaces/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSearchApi api = new GitLabCodeSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateNamespace(
                    "group/sub/project", CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/admin/zoekt/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void getShards_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/zoekt/shards",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSearchZoektNode.class, "search-zoekt-node.json")));

        final GitLabSearchZoektNode result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSearchApi(GitLabCaller.of(client)).getShards();
        }

        assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektNode());
        HTTP.verifyRequested(GET, "/api/v4/admin/zoekt/shards");
    }

    @Test
    void getShards_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/zoekt/shards", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSearchApi api = new GitLabCodeSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getShards());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/admin/zoekt/shards");
    }

    @Test
    void getShardsIndexedNamespaces_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/zoekt/shards/1/indexed_namespaces",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSearchZoektIndexedNamespace.class, "search-zoekt-indexed-namespace.json")));

        final Optional<GitLabSearchZoektIndexedNamespace> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSearchApi(GitLabCaller.of(client)).getShardsIndexedNamespaces(1L);
        }

        assertThat(result).contains(CodesearchCatalogFixtures.searchZoektIndexedNamespace());
        HTTP.verifyRequested(GET, "/api/v4/admin/zoekt/shards/1/indexed_namespaces");
    }

    @Test
    void getShardsIndexedNamespaces_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/zoekt/shards/1/indexed_namespaces", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabCodeSearchApi(GitLabCaller.of(client))
                    .getShardsIndexedNamespaces(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/zoekt/shards/1/indexed_namespaces");
    }

    @Test
    void updateShardsIndexedNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSearchZoektIndexedNamespace.class, "search-zoekt-indexed-namespace.json")));

        final GitLabSearchZoektIndexedNamespace result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSearchApi(GitLabCaller.of(client))
                    .updateShardsIndexedNamespace(
                            1L, 1L, CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload());
        }

        assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektIndexedNamespace());
        HTTP.verifyRequested(PUT, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1");
    }

    @Test
    void updateShardsIndexedNamespace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSearchApi api = new GitLabCodeSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateShardsIndexedNamespace(
                    1L, 1L, CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1");
    }

    @Test
    void deleteShardsIndexedNamespace_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSearchApi(GitLabCaller.of(client)).deleteShardsIndexedNamespace(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1");
    }

    @Test
    void deleteShardsIndexedNamespace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSearchApi api = new GitLabCodeSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteShardsIndexedNamespace(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin/zoekt/shards/1/indexed_namespaces/1");
    }
}
