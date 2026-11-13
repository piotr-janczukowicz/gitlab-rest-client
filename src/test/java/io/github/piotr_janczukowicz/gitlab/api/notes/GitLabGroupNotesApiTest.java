package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
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
class GitLabGroupNotesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupNotesApi api() {
        return new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupNotesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listEpicsNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listEpicsNotes("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listEpicsNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listEpicsNotes("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listEpicsNotes_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listEpicsNotes("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
        });
    }

    @Test
    void listEpicsNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listEpicsNotes(
                        "group/sub/project",
                        1L,
                        GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listEpicsNotes_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listEpicsNotes("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listEpicsNotes_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listEpicsNotes(
                        "group/sub/project",
                        1L,
                        GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createEpicsNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createEpicsNotes(
                "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateEpicsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createEpicsNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createEpicsNotes(
                "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateEpicsNotesPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createEpicsNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateEpicsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createEpicsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createEpicsNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateEpicsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getEpicsNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getEpicsNotes("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getEpicsNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getEpicsNotes("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getEpicsNotes("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
        });
    }

    @Test
    void getEpicsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getEpicsNotes("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateEpicsNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateEpicsNotes(
                "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateEpicsNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateEpicsNotes(
                "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateEpicsNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateEpicsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateEpicsNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteEpicsNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteEpicsNotes("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteEpicsNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteEpicsNotes("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteEpicsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().deleteEpicsNotes("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1");
        });
    }

    @Test
    void deleteEpicsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteEpicsNotes("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteEpicsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result = api().deleteEpicsNotes("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listWikiPagesNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listWikiPagesNotes("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listWikiPagesNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listWikiPagesNotes("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listWikiPagesNotes_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listWikiPagesNotes("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
        });
    }

    @Test
    void listWikiPagesNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listWikiPagesNotes(
                        "group/sub/project",
                        1L,
                        GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listWikiPagesNotes_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page =
                api().listWikiPagesNotes("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listWikiPagesNotes_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listWikiPagesNotes(
                        "group/sub/project",
                        1L,
                        GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createWikiPagesNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createWikiPagesNote(
                "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createWikiPagesNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createWikiPagesNote(
                "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createWikiPagesNote(
                        "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createWikiPagesNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWikiPagesNote(
                        "group/sub/project", 1L, NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getWikiPagesNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getWikiPagesNote("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getWikiPagesNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getWikiPagesNote("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getWikiPagesNote("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
        });
    }

    @Test
    void getWikiPagesNote_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getWikiPagesNote("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateWikiPagesNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateWikiPagesNote(
                "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateWikiPagesNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateWikiPagesNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateWikiPagesNote(
                "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateWikiPagesNotePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateWikiPagesNote(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateWikiPagesNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateWikiPagesNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateWikiPagesNote(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesUpdateWikiPagesNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteWikiPagesNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteWikiPagesNote("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteWikiPagesNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteWikiPagesNote("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().deleteWikiPagesNote("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
        });
    }

    @Test
    void deleteWikiPagesNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteWikiPagesNote("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteWikiPagesNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result = api().deleteWikiPagesNote("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result = api().listDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes");
        });
    }

    @Test
    void createDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void getDiscussionsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().deleteDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void deleteDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteDiscussionsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result = api().deleteDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAwardEmoji("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji");
        });
    }

    @Test
    void listAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listAwardEmoji("group/sub/project", 1L, 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAwardEmoji(
                "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAwardEmoji(
                "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createAwardEmoji(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAwardEmoji(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAwardEmoji("group/sub/project", 1L, 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAwardEmoji("group/sub/project", 1L, 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getAwardEmoji("group/sub/project", 1L, 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1");
        });
    }

    @Test
    void getAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getAwardEmoji("group/sub/project", 1L, 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteAwardEmoji("group/sub/project", 1L, 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupNotesApi lowTier =
                new GitLabGroupNotesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteAwardEmoji("group/sub/project", 1L, 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteAwardEmoji("group/sub/project", 1L, 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/epics/1/notes/1/award_emoji/1");
    }

    @Test
    void deleteAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteAwardEmoji("group/sub/project", 1L, 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
