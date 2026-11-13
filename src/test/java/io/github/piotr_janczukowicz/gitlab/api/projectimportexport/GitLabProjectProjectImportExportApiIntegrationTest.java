package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportStatus;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectProjectImportExportApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/import/authorize", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectImportExportApi(GitLabCaller.of(client)).authorize();
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/import/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/import/authorize", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectImportExportApi api =
                    new GitLabProjectProjectImportExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/import/authorize");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/import",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectImportExportApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
        HTTP.verifyRequested(POST, "/api/v4/projects/import");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/import", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectImportExportApi api =
                    new GitLabProjectProjectImportExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/import");
    }

    @Test
    void getImport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/import",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectImportExportApi(GitLabCaller.of(client)).getImport("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/import");
    }

    @Test
    void getImport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/import", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectImportExportApi api =
                    new GitLabProjectProjectImportExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getImport("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/import");
    }

    @Test
    void git_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/import/git",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectImportExportApi(GitLabCaller.of(client))
                    .git(
                            "group/sub/project",
                            ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/import/git");
    }

    @Test
    void git_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/import/git", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectImportExportApi api =
                    new GitLabProjectProjectImportExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.git(
                    "group/sub/project", ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/import/git");
    }

    @Test
    void getExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/export",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectExportStatus.class, "project-export-status.json")));

        final GitLabProjectExportStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectImportExportApi(GitLabCaller.of(client)).getExport("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectimportexportCatalogFixtures.projectExportStatus());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/export");
    }

    @Test
    void getExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/export", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectImportExportApi api =
                    new GitLabProjectProjectImportExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getExport("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/export");
    }

    @Test
    void createProject_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/export", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectImportExportApi(GitLabCaller.of(client))
                    .createProject(
                            "group/sub/project",
                            ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/export");
    }

    @Test
    void createProject_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/export", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectImportExportApi api =
                    new GitLabProjectProjectImportExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createProject(
                    "group/sub/project",
                    ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/export");
    }

    @Test
    void getDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/export/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectImportExportApi(GitLabCaller.of(client)).getDownload("group/sub/project", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/export/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectProjectImportExportApi(GitLabCaller.of(client))
                    .getDownload("group/sub/project", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }
}
