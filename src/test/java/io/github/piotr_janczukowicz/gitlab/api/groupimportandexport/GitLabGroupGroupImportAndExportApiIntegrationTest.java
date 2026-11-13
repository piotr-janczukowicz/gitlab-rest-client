package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImportsExportStatus;
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
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabGroupGroupImportAndExportApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/import/authorize", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client)).authorize();
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/import/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/import/authorize", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupImportAndExportApi api =
                    new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/import/authorize");
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/import", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/import");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/import", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupImportAndExportApi api =
                    new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/import");
    }

    @Test
    void getDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/export/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client)).getDownload("group/sub/project", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/export/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client))
                    .getDownload("group/sub/project", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void createGroup_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/export", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client)).createGroup("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/export");
    }

    @Test
    void createGroup_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/export", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupImportAndExportApi api =
                    new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createGroup("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/export");
    }

    @Test
    void createExportRelation_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/export_relations", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client))
                    .createExportRelation(
                            "group/sub/project",
                            GroupimportandexportCatalogFixtures.groupGroupImportAndExportCreateExportRelationPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/export_relations");
    }

    @Test
    void createExportRelation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/export_relations", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupImportAndExportApi api =
                    new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createExportRelation(
                    "group/sub/project",
                    GroupimportandexportCatalogFixtures.groupGroupImportAndExportCreateExportRelationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/export_relations");
    }

    @Test
    void getExportRelationsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/export_relations/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client))
                    .getExportRelationsDownload("group/sub/project", "relation", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getExportRelationsDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/export_relations/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client))
                    .getExportRelationsDownload("group/sub/project", "relation", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void listExportRelationsStatus_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/export_relations/status",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabBulkImportsExportStatus.class, "bulk-imports-export-status.json")
                        + "]"));

        final List<GitLabBulkImportsExportStatus> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupImportAndExportApi(GitLabCaller.of(client))
                    .listExportRelationsStatus("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.bulkImportsExportStatus());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/export_relations/status");
    }
}
