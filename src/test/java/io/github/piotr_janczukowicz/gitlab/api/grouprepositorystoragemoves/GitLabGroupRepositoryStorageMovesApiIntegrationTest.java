package io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupRepositoryStorageMove;
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
class GitLabGroupRepositoryStorageMovesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/group_repository_storage_moves",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/group_repository_storage_moves?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")
                        + "]"));

        final List<GitLabGroupRepositoryStorageMove> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupRepositoryStorageMovesApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.groupRepositoryStorageMove(),
                        CommonCatalogFixtures.groupRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/group_repository_storage_moves", 2);
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/group_repository_storage_moves", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupRepositoryStorageMovesApi(GitLabCaller.of(client))
                    .create(GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/group_repository_storage_moves");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/group_repository_storage_moves", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupRepositoryStorageMovesApi api =
                    new GitLabGroupRepositoryStorageMovesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create(GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/group_repository_storage_moves");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group_repository_storage_moves/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")));

        final Optional<GitLabGroupRepositoryStorageMove> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupRepositoryStorageMovesApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.groupRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/group_repository_storage_moves/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/group_repository_storage_moves/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupRepositoryStorageMovesApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/group_repository_storage_moves/1");
    }
}
