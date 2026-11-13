package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBoard;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabList;
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
class GitLabProjectIssueBoardsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/boards",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabBoard.class, "board.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/boards?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabBoard.class, "board.json") + "]"));

        final List<GitLabBoard> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.board(), CommonCatalogFixtures.board());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/boards",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBoard.class, "board.json")));

        final GitLabBoard result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .create("group/sub/project", IssueboardsCatalogFixtures.projectIssueBoardsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.board());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/boards");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/boards", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueBoardsApi api = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", IssueboardsCatalogFixtures.projectIssueBoardsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/boards");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBoard.class, "board.json")));

        final Optional<GitLabBoard> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.board());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBoard.class, "board.json")));

        final GitLabBoard result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.board());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/boards/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueBoardsApi api = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.update("group/sub/project", 1L, IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBoard.class, "board.json")));

        final Optional<GitLabBoard> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.board());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueBoardsApi api = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabBoard> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1");
    }

    @Test
    void listLists_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabList.class, "list.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabList.class, "list.json") + "]"));

        final List<GitLabList> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .listLists("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.list(), CommonCatalogFixtures.list());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists", 2);
    }

    @Test
    void createList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabList.class, "list.json")));

        final GitLabList result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .createList(
                            "group/sub/project", 1L, IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.list());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists");
    }

    @Test
    void createList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueBoardsApi api = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createList(
                    "group/sub/project", 1L, IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists");
    }

    @Test
    void getList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabList.class, "list.json")));

        final Optional<GitLabList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client)).getList("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.list());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }

    @Test
    void getList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .getList("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }

    @Test
    void updateList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabList.class, "list.json")));

        final GitLabList result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client))
                    .updateList(
                            "group/sub/project",
                            1L,
                            1L,
                            IssueboardsCatalogFixtures.projectIssueBoardsUpdateListPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.list());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }

    @Test
    void updateList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueBoardsApi api = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateList(
                    "group/sub/project", 1L, 1L, IssueboardsCatalogFixtures.projectIssueBoardsUpdateListPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }

    @Test
    void deleteList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabList.class, "list.json")));

        final Optional<GitLabList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client)).deleteList("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.list());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }

    @Test
    void deleteList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueBoardsApi api = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteList("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }

    @Test
    void deleteList_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueBoardsApi(GitLabCaller.of(client)).deleteList("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/boards/1/lists/1");
    }
}
