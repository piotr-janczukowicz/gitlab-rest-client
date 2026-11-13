package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
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
class GitLabProjectDiscussionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listIssuesDiscussions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final List<GitLabDiscussion> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .listIssuesDiscussions("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(DiscussionsCatalogFixtures.discussion(), DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions", 2);
    }

    @Test
    void createIssuesDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .createIssuesDiscussions(
                            "group/sub/project",
                            1L,
                            DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions");
    }

    @Test
    void createIssuesDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIssuesDiscussions(
                    "group/sub/project",
                    1L,
                    DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions");
    }

    @Test
    void getIssuesDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getIssuesDiscussions("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id");
    }

    @Test
    void getIssuesDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getIssuesDiscussions("group/sub/project", 1L, "discussion_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id");
    }

    @Test
    void updateIssuesDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .updateIssuesDiscussions(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id");
    }

    @Test
    void updateIssuesDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateIssuesDiscussions(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id");
    }

    @Test
    void listSnippetsDiscussions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final List<GitLabDiscussion> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .listSnippetsDiscussions("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(DiscussionsCatalogFixtures.discussion(), DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions", 2);
    }

    @Test
    void createSnippetsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .createSnippetsDiscussions(
                            "group/sub/project",
                            1L,
                            DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions");
    }

    @Test
    void createSnippetsDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSnippetsDiscussions(
                    "group/sub/project",
                    1L,
                    DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions");
    }

    @Test
    void getSnippetsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getSnippetsDiscussions("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id");
    }

    @Test
    void getSnippetsDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getSnippetsDiscussions("group/sub/project", 1L, "discussion_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id");
    }

    @Test
    void listRequestsDiscussions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final List<GitLabDiscussion> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .listRequestsDiscussions("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(DiscussionsCatalogFixtures.discussion(), DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions", 2);
    }

    @Test
    void createRequestsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .createRequestsDiscussions(
                            "group/sub/project",
                            1L,
                            DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions");
    }

    @Test
    void createRequestsDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRequestsDiscussions(
                    "group/sub/project",
                    1L,
                    DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions");
    }

    @Test
    void getRequestsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getRequestsDiscussions("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id");
    }

    @Test
    void getRequestsDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getRequestsDiscussions("group/sub/project", 1L, "discussion_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id");
    }

    @Test
    void updateRequestsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .updateRequestsDiscussions(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id");
    }

    @Test
    void updateRequestsDiscussions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRequestsDiscussions(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id");
    }

    @Test
    void listRepositoryCommitsDiscussions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final List<GitLabDiscussion> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .listRepositoryCommitsDiscussions("group/sub/project", "noteable_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(DiscussionsCatalogFixtures.discussion(), DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions", 2);
    }

    @Test
    void createRepositoryCommitsDiscussion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .createRepositoryCommitsDiscussion(
                            "group/sub/project",
                            "noteable_id",
                            DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions");
    }

    @Test
    void createRepositoryCommitsDiscussion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRepositoryCommitsDiscussion(
                    "group/sub/project",
                    "noteable_id",
                    DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions");
    }

    @Test
    void getRepositoryCommitsDiscussion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getRepositoryCommitsDiscussion("group/sub/project", "noteable_id", "discussion_id");
        }

        assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id");
    }

    @Test
    void getRepositoryCommitsDiscussion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getRepositoryCommitsDiscussion("group/sub/project", "noteable_id", "discussion_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id");
    }

    @Test
    void listRepositoryCommitsDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .listRepositoryCommitsDiscussionsNotes("group/sub/project", "noteable_id", "discussion_id");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes");
    }

    @Test
    void createRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .createRepositoryCommitsDiscussionsNote(
                            "group/sub/project",
                            "noteable_id",
                            "discussion_id",
                            DiscussionsCatalogFixtures
                                    .projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes");
    }

    @Test
    void createRepositoryCommitsDiscussionsNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRepositoryCommitsDiscussionsNote(
                    "group/sub/project",
                    "noteable_id",
                    "discussion_id",
                    DiscussionsCatalogFixtures.projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes");
    }

    @Test
    void getRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }

    @Test
    void getRepositoryCommitsDiscussionsNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .getRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }

    @Test
    void updateRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .updateRepositoryCommitsDiscussionsNote(
                            "group/sub/project",
                            "noteable_id",
                            "discussion_id",
                            1L,
                            DiscussionsCatalogFixtures
                                    .projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }

    @Test
    void updateRepositoryCommitsDiscussionsNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRepositoryCommitsDiscussionsNote(
                    "group/sub/project",
                    "noteable_id",
                    "discussion_id",
                    1L,
                    DiscussionsCatalogFixtures.projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .deleteRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteRepositoryCommitsDiscussionsNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDiscussionsApi api = new GitLabProjectDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteRepositoryCommitsDiscussionsNote(
                    "group/sub/project", "noteable_id", "discussion_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteRepositoryCommitsDiscussionsNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDiscussionsApi(GitLabCaller.of(client))
                    .deleteRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
    }
}
