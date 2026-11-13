package io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSnippetRepositoryStorageMove;
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
class GitLabSnippetRepositoryStorageMovesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/snippet_repository_storage_moves",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabSnippetRepositoryStorageMove.class,
                                        "snippet-repository-storage-move.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/snippet_repository_storage_moves?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")
                        + "]"));

        final List<GitLabSnippetRepositoryStorageMove> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabSnippetRepositoryStorageMovesApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.snippetRepositoryStorageMove(),
                        CommonCatalogFixtures.snippetRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/snippet_repository_storage_moves", 2);
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/snippet_repository_storage_moves", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSnippetRepositoryStorageMovesApi(GitLabCaller.of(client))
                    .create(SnippetrepositorystoragemovesCatalogFixtures.snippetRepositoryStorageMovesCreatePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/snippet_repository_storage_moves");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/snippet_repository_storage_moves", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSnippetRepositoryStorageMovesApi api =
                    new GitLabSnippetRepositoryStorageMovesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    SnippetrepositorystoragemovesCatalogFixtures.snippetRepositoryStorageMovesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/snippet_repository_storage_moves");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/snippet_repository_storage_moves/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSnippetRepositoryStorageMove.class, "snippet-repository-storage-move.json")));

        final Optional<GitLabSnippetRepositoryStorageMove> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSnippetRepositoryStorageMovesApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.snippetRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/snippet_repository_storage_moves/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/snippet_repository_storage_moves/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabSnippetRepositoryStorageMovesApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/snippet_repository_storage_moves/1");
    }
}
