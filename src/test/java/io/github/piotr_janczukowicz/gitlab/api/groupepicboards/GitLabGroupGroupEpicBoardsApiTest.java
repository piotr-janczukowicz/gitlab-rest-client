package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
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
class GitLabGroupGroupEpicBoardsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupGroupEpicBoardsApi api() {
        return new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupGroupEpicBoardsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpicBoard.class, "epic-board.json") + "]"));

        final GitLabPage<GitLabEpicBoard> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupepicboardsCatalogFixtures.epicBoard());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epic_boards");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpicBoard.class, "epic-board.json") + "]"));

        final GitLabPage<GitLabEpicBoard> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupepicboardsCatalogFixtures.epicBoard());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epic_boards");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabEpicBoard.class, "epic-board.json")));

        final Optional<GitLabEpicBoard> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GroupepicboardsCatalogFixtures.epicBoard());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epic_boards/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabEpicBoard> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listLists_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listLists("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listLists_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listLists("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listLists_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabEpicBoardsList.class, "epic-boards-list.json") + "]"));

        final GitLabPage<GitLabEpicBoardsList> page = api().listLists("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupepicboardsCatalogFixtures.epicBoardsList());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists");
        });
    }

    @Test
    void listLists_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabEpicBoardsList.class, "epic-boards-list.json") + "]"));

        final GitLabPage<GitLabEpicBoardsList> page =
                api().listLists("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupepicboardsCatalogFixtures.epicBoardsList());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getList_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getList("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getList_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupEpicBoardsApi lowTier =
                new GitLabGroupGroupEpicBoardsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getList("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabEpicBoardsList.class, "epic-boards-list.json")));

        final Optional<GitLabEpicBoardsList> result = api().getList("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GroupepicboardsCatalogFixtures.epicBoardsList());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epic_boards/1/lists/1");
        });
    }

    @Test
    void getList_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabEpicBoardsList> result = api().getList("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }
}
