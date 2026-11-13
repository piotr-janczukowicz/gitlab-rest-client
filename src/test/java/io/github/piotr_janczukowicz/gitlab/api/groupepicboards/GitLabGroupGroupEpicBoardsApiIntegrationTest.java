package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGroupGroupEpicBoardsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epic_boards",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpicBoard.class, "epic-board.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/epic_boards?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabEpicBoard.class, "epic-board.json") + "]"));

        final List<GitLabEpicBoard> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupEpicBoardsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        GroupepicboardsCatalogFixtures.epicBoard(), GroupepicboardsCatalogFixtures.epicBoard());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpicBoard.class, "epic-board.json")));

        final Optional<GitLabEpicBoard> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupEpicBoardsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(GroupepicboardsCatalogFixtures.epicBoard());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupEpicBoardsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1");
    }

    @Test
    void listLists_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabEpicBoardsList.class, "epic-boards-list.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabEpicBoardsList.class, "epic-boards-list.json") + "]"));

        final List<GitLabEpicBoardsList> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupEpicBoardsApi(GitLabCaller.of(client))
                    .listLists("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        GroupepicboardsCatalogFixtures.epicBoardsList(),
                        GroupepicboardsCatalogFixtures.epicBoardsList());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists", 2);
    }

    @Test
    void getList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpicBoardsList.class, "epic-boards-list.json")));

        final Optional<GitLabEpicBoardsList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupEpicBoardsApi(GitLabCaller.of(client)).getList("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(GroupepicboardsCatalogFixtures.epicBoardsList());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists/1");
    }

    @Test
    void getList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupEpicBoardsApi(GitLabCaller.of(client))
                    .getList("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists/1");
    }
}
