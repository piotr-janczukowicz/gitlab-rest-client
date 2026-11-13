package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
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
class GitLabProjectEmojiReactionsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectEmojiReactionsApi api() {
        return new GitLabProjectEmojiReactionsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectEmojiReactionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listIssuesAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listIssuesAwardEmoji("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji");
        });
    }

    @Test
    void listIssuesAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listIssuesAwardEmoji("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createIssuesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createIssuesAwardEmoji(
                        "group/sub/project",
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createIssuesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIssuesAwardEmoji(
                        "group/sub/project",
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getIssuesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getIssuesAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1");
        });
    }

    @Test
    void getIssuesAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getIssuesAwardEmoji("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteIssuesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteIssuesAwardEmoji("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1");
    }

    @Test
    void deleteIssuesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteIssuesAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listIssuesNotesAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listIssuesNotesAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji");
        });
    }

    @Test
    void listIssuesNotesAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createIssuesNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createIssuesNotesAwardEmoji(
                        "group/sub/project",
                        1L,
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createIssuesNotesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIssuesNotesAwardEmoji(
                        "group/sub/project",
                        1L,
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getIssuesNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1");
        });
    }

    @Test
    void getIssuesNotesAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteIssuesNotesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteIssuesNotesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRequestsAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listRequestsAwardEmoji("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji");
        });
    }

    @Test
    void listRequestsAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listRequestsAwardEmoji("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRequestsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createRequestsAwardEmoji(
                        "group/sub/project",
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createRequestsAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRequestsAwardEmoji(
                        "group/sub/project",
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRequestsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getRequestsAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1");
        });
    }

    @Test
    void getRequestsAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getRequestsAwardEmoji("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteRequestsAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteRequestsAwardEmoji("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1");
    }

    @Test
    void deleteRequestsAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteRequestsAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRequestsNotesAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listRequestsNotesAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji");
        });
    }

    @Test
    void listRequestsNotesAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRequestsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createRequestsNotesAwardEmoji(
                        "group/sub/project",
                        1L,
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createRequestsNotesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRequestsNotesAwardEmoji(
                        "group/sub/project",
                        1L,
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRequestsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1");
        });
    }

    @Test
    void getRequestsNotesAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteRequestsNotesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteRequestsNotesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listSnippetsAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listSnippetsAwardEmoji("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji");
        });
    }

    @Test
    void listSnippetsAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listSnippetsAwardEmoji("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createSnippetsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createSnippetsAwardEmoji(
                        "group/sub/project",
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createSnippetsAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSnippetsAwardEmoji(
                        "group/sub/project",
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSnippetsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getSnippetsAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1");
        });
    }

    @Test
    void getSnippetsAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getSnippetsAwardEmoji("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteSnippetsAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteSnippetsAwardEmoji("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1");
    }

    @Test
    void deleteSnippetsAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteSnippetsAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listSnippetsNotesAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji");
        });
    }

    @Test
    void listSnippetsNotesAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createSnippetsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createSnippetsNotesAwardEmoji(
                        "group/sub/project",
                        1L,
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createSnippetsNotesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSnippetsNotesAwardEmoji(
                        "group/sub/project",
                        1L,
                        1L,
                        EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSnippetsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1");
        });
    }

    @Test
    void getSnippetsNotesAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteSnippetsNotesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteSnippetsNotesAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
