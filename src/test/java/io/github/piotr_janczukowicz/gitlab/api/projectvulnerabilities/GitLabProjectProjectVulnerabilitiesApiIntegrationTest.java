package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabVulnerability;
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
class GitLabProjectProjectVulnerabilitiesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabVulnerability.class, "vulnerability.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabVulnerability.class, "vulnerability.json") + "]"));

        final List<GitLabVulnerability> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.vulnerability(), CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectVulnerabilitiesApi api =
                    new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities");
    }

    @Test
    void listNotes_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNote.class, "note.json") + "]"));

        final List<GitLabNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .listNotes("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.note(), CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes", 2);
    }

    @Test
    void createNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .createNote(
                            "group/sub/project",
                            1L,
                            ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
    }

    @Test
    void createNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectVulnerabilitiesApi api =
                    new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createNote(
                    "group/sub/project",
                    1L,
                    ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes");
    }

    @Test
    void getNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }

    @Test
    void getNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getNote("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }

    @Test
    void updateNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final GitLabNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .updateNote(
                            "group/sub/project",
                            1L,
                            1L,
                            ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.note());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }

    @Test
    void updateNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectVulnerabilitiesApi api =
                    new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateNote(
                    "group/sub/project",
                    1L,
                    1L,
                    ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }

    @Test
    void deleteNote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNote.class, "note.json")));

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .deleteNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.note());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }

    @Test
    void deleteNote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectVulnerabilitiesApi api =
                    new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteNote("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }

    @Test
    void deleteNote_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .deleteNote("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/vulnerabilities/1/notes/1");
    }
}
