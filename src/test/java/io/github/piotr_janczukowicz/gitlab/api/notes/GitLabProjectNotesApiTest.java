package io.github.piotr_janczukowicz.gitlab.api.notes;

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
class GitLabProjectNotesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectNotesApi api() {
        return new GitLabProjectNotesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectNotesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listIssuesNotes_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listIssuesNotes("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
        });
    }

    @Test
    void listIssuesNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listIssuesNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListIssuesNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListIssuesNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListIssuesNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListIssuesNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listIssuesNotes_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listIssuesNotes("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listIssuesNotes_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listIssuesNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListIssuesNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListIssuesNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListIssuesNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListIssuesNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createIssuesNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createIssuesNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createIssuesNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIssuesNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getIssuesNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getIssuesNotes("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
        });
    }

    @Test
    void getIssuesNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getIssuesNotes("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateIssuesNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateIssuesNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateIssuesNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateIssuesNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateIssuesNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateIssuesNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteIssuesNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteIssuesNotes("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/issues/1/notes/1");
    }

    @Test
    void deleteIssuesNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteIssuesNotes("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRequestsNotes_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listRequestsNotes("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
        });
    }

    @Test
    void listRequestsNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listRequestsNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListRequestsNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListRequestsNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListRequestsNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListRequestsNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listRequestsNotes_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listRequestsNotes("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listRequestsNotes_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listRequestsNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListRequestsNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListRequestsNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListRequestsNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListRequestsNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createRequestsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createRequestsNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createRequestsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRequestsNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRequestsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getRequestsNotes("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
        });
    }

    @Test
    void getRequestsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getRequestsNotes("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateRequestsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateRequestsNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateRequestsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRequestsNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteRequestsNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteRequestsNotes("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/notes/1");
    }

    @Test
    void deleteRequestsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteRequestsNotes("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listSnippetsNotes_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listSnippetsNotes("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
        });
    }

    @Test
    void listSnippetsNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listSnippetsNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listSnippetsNotes_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listSnippetsNotes("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listSnippetsNotes_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listSnippetsNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createSnippetsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createSnippetsNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createSnippetsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSnippetsNotes(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSnippetsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getSnippetsNotes("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
        });
    }

    @Test
    void getSnippetsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getSnippetsNotes("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateSnippetsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateSnippetsNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateSnippetsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateSnippetsNotes(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSnippetsNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteSnippetsNotes("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/snippets/1/notes/1");
    }

    @Test
    void deleteSnippetsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteSnippetsNotes("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
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
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
        });
    }

    @Test
    void listWikiPagesNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listWikiPagesNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
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
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
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
                        GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                                .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createWikiPagesNote(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateWikiPagesNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createWikiPagesNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWikiPagesNote(
                        "group/sub/project", 1L, NotesCatalogFixtures.projectNotesCreateWikiPagesNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getWikiPagesNote("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
        });
    }

    @Test
    void getWikiPagesNote_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getWikiPagesNote("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateWikiPagesNote(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateWikiPagesNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateWikiPagesNote(
                        "group/sub/project", 1L, 1L, NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteWikiPagesNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().deleteWikiPagesNote("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/wiki_pages/1/notes/1");
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
    void listIssuesDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result = api().listIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes");
        });
    }

    @Test
    void createIssuesDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createIssuesDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.projectNotesCreateIssuesDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createIssuesDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIssuesDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.projectNotesCreateIssuesDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getIssuesDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().getIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void getIssuesDiscussionsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result =
                api().getIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateIssuesDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateIssuesDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateIssuesDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateIssuesDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteIssuesDiscussionsNotes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/issues/1/discussions/discussion_id/notes/1");
    }

    @Test
    void deleteIssuesDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteIssuesDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listSnippetsDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result = api().listSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes");
        });
    }

    @Test
    void createSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createSnippetsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createSnippetsDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSnippetsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().getSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void getSnippetsDiscussionsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result =
                api().getSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateSnippetsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateSnippetsDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateSnippetsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSnippetsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().deleteSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "DELETE /api/v4/projects/group%2Fsub%2Fproject/snippets/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void deleteSnippetsDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().deleteSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSnippetsDiscussionsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result =
                api().deleteSnippetsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listRequestsDiscussionsNotes_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> result = api().listRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes");
        });
    }

    @Test
    void createRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createRequestsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.projectNotesCreateRequestsDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createRequestsDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRequestsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        NotesCatalogFixtures.projectNotesCreateRequestsDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().getRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void getRequestsDiscussionsNotes_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result =
                api().getRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateRequestsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateRequestsDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRequestsDiscussionsNotes(
                        "group/sub/project",
                        1L,
                        "discussion_id",
                        1L,
                        NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteRequestsDiscussionsNotes_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result =
                api().deleteRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/discussions/discussion_id/notes/1");
        });
    }

    @Test
    void deleteRequestsDiscussionsNotes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().deleteRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteRequestsDiscussionsNotes_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result =
                api().deleteRequestsDiscussionsNotes("group/sub/project", 1L, "discussion_id", 1L);

        assertThat(result).isEmpty();
    }
}
