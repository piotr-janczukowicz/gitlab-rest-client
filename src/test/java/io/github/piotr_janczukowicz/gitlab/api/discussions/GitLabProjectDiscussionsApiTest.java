package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectDiscussionsApi api() {
        return new GitLabProjectDiscussionsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectDiscussionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listIssuesDiscussions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page = api().listIssuesDiscussions("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions");
        });
    }

    @Test
    void listIssuesDiscussions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page =
                api().listIssuesDiscussions("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createIssuesDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result = api().createIssuesDiscussions(
                        "group/sub/project",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createIssuesDiscussions_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIssuesDiscussions(
                        "group/sub/project",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getIssuesDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result = api().getIssuesDiscussions("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id");
        });
    }

    @Test
    void getIssuesDiscussions_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabDiscussion> result = api().getIssuesDiscussions("group/sub/project", 1L, "discussion_id");

        assertThat(result).isEmpty();
    }

    @Test
    void updateIssuesDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result = api().updateIssuesDiscussions(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"resolved\":");
        });
    }

    @Test
    void updateIssuesDiscussions_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateIssuesDiscussions(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listSnippetsDiscussions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page = api().listSnippetsDiscussions("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions");
        });
    }

    @Test
    void listSnippetsDiscussions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page =
                api().listSnippetsDiscussions("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createSnippetsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result = api().createSnippetsDiscussions(
                        "group/sub/project",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createSnippetsDiscussions_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSnippetsDiscussions(
                        "group/sub/project",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSnippetsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result =
                api().getSnippetsDiscussions("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id");
        });
    }

    @Test
    void getSnippetsDiscussions_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabDiscussion> result =
                api().getSnippetsDiscussions("group/sub/project", 1L, "discussion_id");

        assertThat(result).isEmpty();
    }

    @Test
    void listRequestsDiscussions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page = api().listRequestsDiscussions("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions");
        });
    }

    @Test
    void listRequestsDiscussions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page =
                api().listRequestsDiscussions("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRequestsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result = api().createRequestsDiscussions(
                        "group/sub/project",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createRequestsDiscussions_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRequestsDiscussions(
                        "group/sub/project",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRequestsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result =
                api().getRequestsDiscussions("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id");
        });
    }

    @Test
    void getRequestsDiscussions_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabDiscussion> result =
                api().getRequestsDiscussions("group/sub/project", 1L, "discussion_id");

        assertThat(result).isEmpty();
    }

    @Test
    void updateRequestsDiscussions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result = api().updateRequestsDiscussions(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"resolved\":");
        });
    }

    @Test
    void updateRequestsDiscussions_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRequestsDiscussions(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRepositoryCommitsDiscussions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page =
                api().listRepositoryCommitsDiscussions("group/sub/project", "noteable_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions");
        });
    }

    @Test
    void listRepositoryCommitsDiscussions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final GitLabPage<GitLabDiscussion> page =
                api().listRepositoryCommitsDiscussions("group/sub/project", "noteable_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRepositoryCommitsDiscussion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result = api().createRepositoryCommitsDiscussion(
                        "group/sub/project",
                        "noteable_id",
                        DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createRepositoryCommitsDiscussion_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRepositoryCommitsDiscussion(
                        "group/sub/project",
                        "noteable_id",
                        DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRepositoryCommitsDiscussion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result =
                api().getRepositoryCommitsDiscussion("group/sub/project", "noteable_id", "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id");
        });
    }

    @Test
    void getRepositoryCommitsDiscussion_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabDiscussion> result =
                api().getRepositoryCommitsDiscussion("group/sub/project", "noteable_id", "discussion_id");

        assertThat(result).isEmpty();
    }

    @Test
    void listRepositoryCommitsDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result =
                api().listRepositoryCommitsDiscussionsNotes("group/sub/project", "noteable_id", "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes");
        });
    }

    @Test
    void createRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createRepositoryCommitsDiscussionsNote(
                        "group/sub/project",
                        "noteable_id",
                        "discussion_id",
                        DiscussionsCatalogFixtures.projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createRepositoryCommitsDiscussionsNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRepositoryCommitsDiscussionsNote(
                        "group/sub/project",
                        "noteable_id",
                        "discussion_id",
                        DiscussionsCatalogFixtures.projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().getRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void getRepositoryCommitsDiscussionsNote_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result =
                api().getRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateRepositoryCommitsDiscussionsNote(
                        "group/sub/project",
                        "noteable_id",
                        "discussion_id",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateRepositoryCommitsDiscussionsNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRepositoryCommitsDiscussionsNote(
                        "group/sub/project",
                        "noteable_id",
                        "discussion_id",
                        1L,
                        DiscussionsCatalogFixtures.projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteRepositoryCommitsDiscussionsNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().deleteRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "DELETE /api/v4/projects/group%2Fsub%2Fproject/repository/commits/noteable_id/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void deleteRepositoryCommitsDiscussionsNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().deleteRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteRepositoryCommitsDiscussionsNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result =
                api().deleteRepositoryCommitsDiscussionsNote("group/sub/project", "noteable_id", "discussion_id", 1L);

        assertThat(result).isEmpty();
    }
}
