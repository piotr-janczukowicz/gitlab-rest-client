package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
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
class GitLabGroupNotesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listEpicsNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .listEpicsNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes", 2);
    }

    @Test
    void createEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .createEpicsNotes(
                            "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateEpicsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
    }

    @Test
    void createEpicsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createEpicsNotes(
                    "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateEpicsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
    }

    @Test
    void getEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).getEpicsNotes("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void getEpicsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .getEpicsNotes("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void updateEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .updateEpicsNotes(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void updateEpicsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateEpicsNotes(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void deleteEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).deleteEpicsNotes("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void deleteEpicsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteEpicsNotes("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void deleteEpicsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).deleteEpicsNotes("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
    }

    @Test
    void listWikiPagesNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .listWikiPagesNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes", 2);
    }

    @Test
    void createWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .createWikiPagesNote(
                            "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
    }

    @Test
    void createWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWikiPagesNote(
                    "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
    }

    @Test
    void getWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).getWikiPagesNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void getWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .getWikiPagesNote("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void updateWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .updateWikiPagesNote(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateWikiPagesNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void updateWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateWikiPagesNote(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateWikiPagesNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void deleteWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).deleteWikiPagesNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void deleteWikiPagesNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteWikiPagesNote("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void deleteWikiPagesNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).deleteWikiPagesNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
    }

    @Test
    void listDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .listDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes");
    }

    @Test
    void createDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .createDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes");
    }

    @Test
    void createDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes");
    }

    @Test
    void getDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .getDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void getDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .getDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .updateDiscussionsNotes(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            1L,
                            NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void updateDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateDiscussionsNotes(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    1L,
                    NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .deleteDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteDiscussionsNotes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteDiscussionsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .deleteDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
    }

    @Test
    void listAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .listAwardEmoji("group/sub/project", 1L, 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji", 2);
    }

    @Test
    void createAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .createAwardEmoji(
                            "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji");
    }

    @Test
    void createAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAwardEmoji(
                    "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji");
    }

    @Test
    void getAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupNotesApi(GitLabCaller.of(client)).getAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1");
    }

    @Test
    void getAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupNotesApi(GitLabCaller.of(client))
                    .getAwardEmoji("group/sub/project", 1L, 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupNotesApi(GitLabCaller.of(client)).deleteAwardEmoji("group/sub/project", 1L, 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupNotesApi api = new GitLabGroupNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteAwardEmoji("group/sub/project", 1L, 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1");
    }
}
