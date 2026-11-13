package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSnippetRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSnippetsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabCodeSnippetsApi api() {
        return new GitLabCodeSnippetsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabCodeSnippetsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listRepositoryStorageMoves_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabSnippetRepositoryStorageMove.class,
                                        "snippet-repository-storage-move.json")
                                + "]"));

        final GitLabPage<GitLabSnippetRepositoryStorageMove> page =
                api().listRepositoryStorageMoves("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.snippetRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves");
        });
    }

    @Test
    void listRepositoryStorageMoves_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabSnippetRepositoryStorageMove.class,
                                        "snippet-repository-storage-move.json")
                                + "]"));

        final GitLabPage<GitLabSnippetRepositoryStorageMove> page =
                api().listRepositoryStorageMoves("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.snippetRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")));

        final GitLabSnippetRepositoryStorageMove result = api().createRepositoryStorageMove(
                        "group/sub/project",
                        CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.snippetRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"destination_storage_name\":");
        });
    }

    @Test
    void createRepositoryStorageMove_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRepositoryStorageMove(
                        "group/sub/project",
                        CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")));

        final Optional<GitLabSnippetRepositoryStorageMove> result =
                api().getRepositoryStorageMove("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.snippetRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves/1");
        });
    }

    @Test
    void getRepositoryStorageMove_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSnippetRepositoryStorageMove> result =
                api().getRepositoryStorageMove("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().list(GitLabCodeSnippetsListFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().list(
                        GitLabCodeSnippetsListFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final GitLabPersonalSnippet result = api().create(CodesnippetsCatalogFixtures.codeSnippetsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/snippets");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"title\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create(CodesnippetsCatalogFixtures.codeSnippetsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listPublic_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json") + "]"));

        final GitLabPage<GitLabPersonalSnippet> page = api().listPublic();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/public");
        });
    }

    @Test
    void listPublic_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json") + "]"));

        final GitLabPage<GitLabPersonalSnippet> page = api().listPublic(
                        GitLabCodeSnippetsListPublicFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/public");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listPublic_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json") + "]"));

        final GitLabPage<GitLabPersonalSnippet> page = api().listPublic(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/public");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listPublic_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json") + "]"));

        final GitLabPage<GitLabPersonalSnippet> page = api().listPublic(
                        GitLabCodeSnippetsListPublicFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/public");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().listAll();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/all");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().listAll(GitLabCodeSnippetsListAllFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .repositoryStorage("repository_storage")
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/all");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().listAll(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/all");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final GitLabPage<GitLabSnippet> page = api().listAll(
                        GitLabCodeSnippetsListAllFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CodesnippetsCatalogFixtures.snippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/all");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final Optional<GitLabPersonalSnippet> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPersonalSnippet> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final GitLabPersonalSnippet result = api().update(1L, CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/snippets/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"content\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().update(1L, CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final Optional<GitLabPersonalSnippet> result = api().delete(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CodesnippetsCatalogFixtures.personalSnippet());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/snippets/1");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabPersonalSnippet> result = api().delete(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void callRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callRaw(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/1/raw");
    }

    @Test
    void callRaw_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callRaw(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callFilesRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callFilesRaw("group/sub/project", "ref", "file_path");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/snippets/group%2Fsub%2Fproject/files/ref/file_path/raw");
    }

    @Test
    void callFilesRaw_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callFilesRaw("group/sub/project", "ref", "file_path"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUserAgentDetail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserAgentDetail.class, "user-agent-detail.json")));

        final Optional<GitLabUserAgentDetail> result = api().getUserAgentDetail(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.userAgentDetail());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/snippets/1/user_agent_detail");
        });
    }

    @Test
    void getUserAgentDetail_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabUserAgentDetail> result = api().getUserAgentDetail(1L);

        assertThat(result).isEmpty();
    }
}
