package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSnippetRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabCodeSnippetsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listRepositoryStorageMoves_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabSnippetRepositoryStorageMove.class,
                                        "snippet-repository-storage-move.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")
                        + "]"));

        final List<GitLabSnippetRepositoryStorageMove> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .listRepositoryStorageMoves("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.snippetRepositoryStorageMove(),
                        CommonCatalogFixtures.snippetRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves", 2);
    }

    @Test
    void createRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")));

        final GitLabSnippetRepositoryStorageMove result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .createRepositoryStorageMove(
                            "group/sub/project",
                            CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.snippetRepositoryStorageMove());
        HTTP.verifyRequested(POST, "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves");
    }

    @Test
    void createRepositoryStorageMove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSnippetsApi api = new GitLabCodeSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRepositoryStorageMove(
                    "group/sub/project", CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves");
    }

    @Test
    void getRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")));

        final Optional<GitLabSnippetRepositoryStorageMove> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .getRepositoryStorageMove("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.snippetRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves/1");
    }

    @Test
    void getRepositoryStorageMove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .getRepositoryStorageMove("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/snippets/group%2Fsub%2Fproject/repository_storage_moves/1");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/snippets",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]")
                        .header("Link", "<" + base + "/api/v4/snippets?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final List<GitLabSnippet> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(CodesnippetsCatalogFixtures.snippet(), CodesnippetsCatalogFixtures.snippet());
        HTTP.verifyRequested(GET, "/api/v4/snippets", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/snippets",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final GitLabPersonalSnippet result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .create(CodesnippetsCatalogFixtures.codeSnippetsCreatePayload());
        }

        assertThat(result).isEqualTo(CodesnippetsCatalogFixtures.personalSnippet());
        HTTP.verifyRequested(POST, "/api/v4/snippets");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/snippets", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSnippetsApi api = new GitLabCodeSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(CodesnippetsCatalogFixtures.codeSnippetsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/snippets");
    }

    @Test
    void listPublic_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/snippets/public",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json") + "]")
                        .header("Link", "<" + base + "/api/v4/snippets/public?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json") + "]"));

        final List<GitLabPersonalSnippet> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .listPublic()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CodesnippetsCatalogFixtures.personalSnippet(), CodesnippetsCatalogFixtures.personalSnippet());
        HTTP.verifyRequested(GET, "/api/v4/snippets/public", 2);
    }

    @Test
    void listAll_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/snippets/all",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]")
                        .header("Link", "<" + base + "/api/v4/snippets/all?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSnippet.class, "snippet.json") + "]"));

        final List<GitLabSnippet> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).listAll().all();
        }

        assertThat(items).containsExactly(CodesnippetsCatalogFixtures.snippet(), CodesnippetsCatalogFixtures.snippet());
        HTTP.verifyRequested(GET, "/api/v4/snippets/all", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/snippets/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final Optional<GitLabPersonalSnippet> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CodesnippetsCatalogFixtures.personalSnippet());
        HTTP.verifyRequested(GET, "/api/v4/snippets/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/snippets/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/snippets/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/snippets/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final GitLabPersonalSnippet result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .update(1L, CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload());
        }

        assertThat(result).isEqualTo(CodesnippetsCatalogFixtures.personalSnippet());
        HTTP.verifyRequested(PUT, "/api/v4/snippets/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/snippets/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSnippetsApi api = new GitLabCodeSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(1L, CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/snippets/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/snippets/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPersonalSnippet.class, "personal-snippet.json")));

        final Optional<GitLabPersonalSnippet> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(CodesnippetsCatalogFixtures.personalSnippet());
        HTTP.verifyRequested(DELETE, "/api/v4/snippets/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/snippets/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSnippetsApi api = new GitLabCodeSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/snippets/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/snippets/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabPersonalSnippet> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/snippets/1");
    }

    @Test
    void callRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/snippets/1/raw", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSnippetsApi(GitLabCaller.of(client)).callRaw(1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/snippets/1/raw");
    }

    @Test
    void callRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/snippets/1/raw", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSnippetsApi api = new GitLabCodeSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callRaw(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/snippets/1/raw");
    }

    @Test
    void callFilesRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/snippets/group%2Fsub%2Fproject/files/ref/file_path/raw",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSnippetsApi(GitLabCaller.of(client)).callFilesRaw("group/sub/project", "ref", "file_path");
        }

        HTTP.verifyRequested(GET, "/api/v4/snippets/group%2Fsub%2Fproject/files/ref/file_path/raw");
    }

    @Test
    void callFilesRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/snippets/group%2Fsub%2Fproject/files/ref/file_path/raw", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSnippetsApi api = new GitLabCodeSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callFilesRaw("group/sub/project", "ref", "file_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/snippets/group%2Fsub%2Fproject/files/ref/file_path/raw");
    }

    @Test
    void getUserAgentDetail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/snippets/1/user_agent_detail",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabUserAgentDetail.class, "user-agent-detail.json")));

        final Optional<GitLabUserAgentDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabCodeSnippetsApi(GitLabCaller.of(client)).getUserAgentDetail(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.userAgentDetail());
        HTTP.verifyRequested(GET, "/api/v4/snippets/1/user_agent_detail");
    }

    @Test
    void getUserAgentDetail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/snippets/1/user_agent_detail", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabCodeSnippetsApi(GitLabCaller.of(client))
                    .getUserAgentDetail(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/snippets/1/user_agent_detail");
    }
}
