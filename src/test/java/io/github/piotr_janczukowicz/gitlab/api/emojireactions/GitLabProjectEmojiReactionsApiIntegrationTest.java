package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
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
class GitLabProjectEmojiReactionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listIssuesAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .listIssuesAwardEmoji("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji", 2);
    }

    @Test
    void createIssuesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .createIssuesAwardEmoji(
                            "group/sub/project",
                            1L,
                            EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji");
    }

    @Test
    void createIssuesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIssuesAwardEmoji(
                    "group/sub/project",
                    1L,
                    EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji");
    }

    @Test
    void getIssuesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getIssuesAwardEmoji("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1");
    }

    @Test
    void getIssuesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getIssuesAwardEmoji("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1");
    }

    @Test
    void deleteIssuesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .deleteIssuesAwardEmoji("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1");
    }

    @Test
    void deleteIssuesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteIssuesAwardEmoji("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/award_emoji/1");
    }

    @Test
    void listIssuesNotesAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .listIssuesNotesAwardEmoji("group/sub/project", 1L, 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji", 2);
    }

    @Test
    void createIssuesNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .createIssuesNotesAwardEmoji(
                            "group/sub/project",
                            1L,
                            1L,
                            EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji");
    }

    @Test
    void createIssuesNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIssuesNotesAwardEmoji(
                    "group/sub/project",
                    1L,
                    1L,
                    EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji");
    }

    @Test
    void getIssuesNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1");
    }

    @Test
    void getIssuesNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteIssuesNotesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .deleteIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteIssuesNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteIssuesNotesAwardEmoji("group/sub/project", 1L, 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1/award_emoji/1");
    }

    @Test
    void listRequestsAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .listRequestsAwardEmoji("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji", 2);
    }

    @Test
    void createRequestsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .createRequestsAwardEmoji(
                            "group/sub/project",
                            1L,
                            EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji");
    }

    @Test
    void createRequestsAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRequestsAwardEmoji(
                    "group/sub/project",
                    1L,
                    EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji");
    }

    @Test
    void getRequestsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getRequestsAwardEmoji("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1");
    }

    @Test
    void getRequestsAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getRequestsAwardEmoji("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1");
    }

    @Test
    void deleteRequestsAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .deleteRequestsAwardEmoji("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1");
    }

    @Test
    void deleteRequestsAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteRequestsAwardEmoji("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/award_emoji/1");
    }

    @Test
    void listRequestsNotesAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .listRequestsNotesAwardEmoji("group/sub/project", 1L, 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji", 2);
    }

    @Test
    void createRequestsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .createRequestsNotesAwardEmoji(
                            "group/sub/project",
                            1L,
                            1L,
                            EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji");
    }

    @Test
    void createRequestsNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRequestsNotesAwardEmoji(
                    "group/sub/project",
                    1L,
                    1L,
                    EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji");
    }

    @Test
    void getRequestsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1");
    }

    @Test
    void getRequestsNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteRequestsNotesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .deleteRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteRequestsNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteRequestsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1/award_emoji/1");
    }

    @Test
    void listSnippetsAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .listSnippetsAwardEmoji("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji", 2);
    }

    @Test
    void createSnippetsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .createSnippetsAwardEmoji(
                            "group/sub/project",
                            1L,
                            EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji");
    }

    @Test
    void createSnippetsAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSnippetsAwardEmoji(
                    "group/sub/project",
                    1L,
                    EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji");
    }

    @Test
    void getSnippetsAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getSnippetsAwardEmoji("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1");
    }

    @Test
    void getSnippetsAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getSnippetsAwardEmoji("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1");
    }

    @Test
    void deleteSnippetsAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .deleteSnippetsAwardEmoji("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1");
    }

    @Test
    void deleteSnippetsAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSnippetsAwardEmoji("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/award_emoji/1");
    }

    @Test
    void listSnippetsNotesAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .listSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji", 2);
    }

    @Test
    void createSnippetsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .createSnippetsNotesAwardEmoji(
                            "group/sub/project",
                            1L,
                            1L,
                            EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji");
    }

    @Test
    void createSnippetsNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSnippetsNotesAwardEmoji(
                    "group/sub/project",
                    1L,
                    1L,
                    EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji");
    }

    @Test
    void getSnippetsNotesAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1");
    }

    @Test
    void getSnippetsNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .getSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteSnippetsNotesAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client))
                    .deleteSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteSnippetsNotesAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEmojiReactionsApi api = new GitLabProjectEmojiReactionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSnippetsNotesAwardEmoji("group/sub/project", 1L, 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1/award_emoji/1");
    }
}
