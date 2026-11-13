package io.github.piotr_janczukowicz.gitlab.api.codesearch;

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
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSearchApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabCodeSearchApi api() {
        return new GitLabCodeSearchApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabCodeSearchApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void indexProject_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSearchZoektProjectIndexSuccess.class,
                                "search-zoekt-project-index-success.json")));

        final GitLabSearchZoektProjectIndexSuccess result = api().indexProject(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektProjectIndexSuccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/admin/zoekt/projects/1/index");
        });
    }

    @Test
    void indexProject_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().indexProject(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSearchZoektIndexedNamespace.class, "search-zoekt-indexed-namespace.json")));

        final GitLabSearchZoektIndexedNamespace result = api().updateNamespace(
                        "group/sub/project", CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektIndexedNamespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/admin/zoekt/namespaces/group%2Fsub%2Fproject");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"number_of_replicas_override\":");
        });
    }

    @Test
    void updateNamespace_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateNamespace(
                        "group/sub/project", CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getShards_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSearchZoektNode.class, "search-zoekt-node.json")));

        final GitLabSearchZoektNode result = api().getShards();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektNode());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/admin/zoekt/shards");
        });
    }

    @Test
    void getShards_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getShards());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getShardsIndexedNamespaces_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSearchZoektIndexedNamespace.class, "search-zoekt-indexed-namespace.json")));

        final Optional<GitLabSearchZoektIndexedNamespace> result = api().getShardsIndexedNamespaces(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CodesearchCatalogFixtures.searchZoektIndexedNamespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/zoekt/shards/1/indexed_namespaces");
        });
    }

    @Test
    void getShardsIndexedNamespaces_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSearchZoektIndexedNamespace> result = api().getShardsIndexedNamespaces(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateShardsIndexedNamespace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSearchZoektIndexedNamespace.class, "search-zoekt-indexed-namespace.json")));

        final GitLabSearchZoektIndexedNamespace result = api().updateShardsIndexedNamespace(
                        1L, 1L, CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CodesearchCatalogFixtures.searchZoektIndexedNamespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/zoekt/shards/1/indexed_namespaces/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"search\":");
        });
    }

    @Test
    void updateShardsIndexedNamespace_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateShardsIndexedNamespace(
                        1L, 1L, CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteShardsIndexedNamespace_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteShardsIndexedNamespace(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/admin/zoekt/shards/1/indexed_namespaces/1");
    }

    @Test
    void deleteShardsIndexedNamespace_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteShardsIndexedNamespace(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
