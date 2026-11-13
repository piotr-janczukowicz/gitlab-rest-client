package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabVulnerability;
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
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectVulnerabilitiesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProjectVulnerabilitiesApi api() {
        return new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProjectVulnerabilitiesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabVulnerability.class, "vulnerability.json") + "]"));

        final GitLabPage<GitLabVulnerability> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabVulnerability.class, "vulnerability.json") + "]"));

        final GitLabPage<GitLabVulnerability> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(
                "group/sub/project",
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(
                "group/sub/project",
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result = api().create(
                        "group/sub/project",
                        ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"finding_id\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        "group/sub/project",
                        ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listNotes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listNotes("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listNotes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listNotes("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listNotes_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listNotes("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
        });
    }

    @Test
    void listNotes_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                                .activityFilter(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listNotes_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listNotes("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listNotes_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final GitLabPage<GitLabNote> page = api().listNotes(
                        "group/sub/project",
                        1L,
                        GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                                .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                                .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                                .activityFilter(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void createNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createNote(
                "group/sub/project",
                1L,
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createNote(
                "group/sub/project",
                1L,
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().createNote(
                        "group/sub/project",
                        1L,
                        ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void createNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createNote(
                        "group/sub/project",
                        1L,
                        ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getNote("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getNote("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().getNote("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
        });
    }

    @Test
    void getNote_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNote> result = api().getNote("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateNote(
                "group/sub/project",
                1L,
                1L,
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateNote(
                "group/sub/project",
                1L,
                1L,
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result = api().updateNote(
                        "group/sub/project",
                        1L,
                        1L,
                        ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"body\":");
        });
    }

    @Test
    void updateNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateNote(
                        "group/sub/project",
                        1L,
                        1L,
                        ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteNote_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteNote("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteNote_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectVulnerabilitiesApi lowTier =
                new GitLabProjectProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteNote("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result = api().deleteNote("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.note());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
        });
    }

    @Test
    void deleteNote_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteNote("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabNote> result = api().deleteNote("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }
}
