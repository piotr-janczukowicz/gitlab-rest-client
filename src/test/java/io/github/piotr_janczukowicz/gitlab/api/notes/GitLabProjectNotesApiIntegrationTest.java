package io.github.piotr_janczukowicz.gitlab.api.notes;

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
class GitLabProjectNotesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listIssuesNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listIssuesNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes", 2);
    }

    @Test
    void createIssuesNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createIssuesNotes(
                            "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
    }

    @Test
    void createIssuesNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIssuesNotes(
                    "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
    }

    @Test
    void getIssuesNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client)).getIssuesNotes("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void getIssuesNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getIssuesNotes("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void updateIssuesNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateIssuesNotes(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateIssuesNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void updateIssuesNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateIssuesNotes(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateIssuesNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void deleteIssuesNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNotesApi(GitLabCaller.of(client)).deleteIssuesNotes("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void deleteIssuesNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteIssuesNotes("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void listRequestsNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listRequestsNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes", 2);
    }

    @Test
    void createRequestsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createRequestsNotes(
                            "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
    }

    @Test
    void createRequestsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRequestsNotes(
                    "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
    }

    @Test
    void getRequestsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client)).getRequestsNotes("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void getRequestsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getRequestsNotes("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void updateRequestsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateRequestsNotes(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void updateRequestsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRequestsNotes(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void deleteRequestsNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNotesApi(GitLabCaller.of(client)).deleteRequestsNotes("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void deleteRequestsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteRequestsNotes("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void listSnippetsNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listSnippetsNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes", 2);
    }

    @Test
    void createSnippetsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createSnippetsNotes(
                            "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
    }

    @Test
    void createSnippetsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSnippetsNotes(
                    "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
    }

    @Test
    void getSnippetsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client)).getSnippetsNotes("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void getSnippetsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getSnippetsNotes("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void updateSnippetsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateSnippetsNotes(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void updateSnippetsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateSnippetsNotes(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void deleteSnippetsNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNotesApi(GitLabCaller.of(client)).deleteSnippetsNotes("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void deleteSnippetsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSnippetsNotes("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void listWikiPagesNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listWikiPagesNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes", 2);
    }

    @Test
    void createWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createWikiPagesNote(
                            "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateWikiPagesNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
    }

    @Test
    void createWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWikiPagesNote(
                    "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateWikiPagesNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
    }

    @Test
    void getWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client)).getWikiPagesNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void getWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getWikiPagesNote("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void updateWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateWikiPagesNote(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void updateWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateWikiPagesNote(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void deleteWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabProjectNotesApi(GitLabCaller.of(client)).deleteWikiPagesNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void deleteWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteWikiPagesNote("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void deleteWikiPagesNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabProjectNotesApi(GitLabCaller.of(client)).deleteWikiPagesNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void listIssuesDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes");
    }

    @Test
    void createIssuesDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createIssuesDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            NotesCatalogFixtures.projectNotesCreateIssuesDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes");
    }

    @Test
    void createIssuesDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIssuesDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    NotesCatalogFixtures.projectNotesCreateIssuesDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes");
    }

    @Test
    void getIssuesDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void getIssuesDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateIssuesDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateIssuesDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            1L,
                            NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateIssuesDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateIssuesDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    1L,
                    NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteIssuesDiscussionsNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .deleteIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteIssuesDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.deleteIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void listSnippetsDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes");
    }

    @Test
    void createSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createSnippetsDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes");
    }

    @Test
    void createSnippetsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSnippetsDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes");
    }

    @Test
    void getSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void getSnippetsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateSnippetsDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            1L,
                            NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateSnippetsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateSnippetsDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    1L,
                    NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .deleteSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteSnippetsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.deleteSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteSnippetsDiscussionsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .deleteSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
    }

    @Test
    void listRequestsDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .listRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes");
    }

    @Test
    void createRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .createRequestsDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            NotesCatalogFixtures.projectNotesCreateRequestsDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes");
    }

    @Test
    void createRequestsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRequestsDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    NotesCatalogFixtures.projectNotesCreateRequestsDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes");
    }

    @Test
    void getRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }

    @Test
    void getRequestsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .getRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .updateRequestsDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            1L,
                            NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateRequestsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRequestsDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    1L,
                    NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .deleteRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteRequestsDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotesApi api = new GitLabProjectNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.deleteRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteRequestsDiscussionsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotesApi(GitLabCaller.of(client))
                    .deleteRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
    }
}
