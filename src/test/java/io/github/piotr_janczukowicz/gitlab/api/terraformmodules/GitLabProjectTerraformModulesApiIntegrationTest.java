package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectTerraformModulesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .call("group/sub/project", "module_name", "module_system");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformModulesApi api = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call("group/sub/project", "module_name", "module_system"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system");
    }

    @Test
    void callByModuleVersion_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .callByModuleVersion("group/sub/project", "module_name", "module_system", "module_version");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version");
    }

    @Test
    void callByModuleVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformModulesApi api = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.callByModuleVersion("group/sub/project", "module_name", "module_system", "module_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version");
    }

    @Test
    void authorizeFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .authorizeFile("group/sub/project", "module_name", "module_system", "module_version");
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file/authorize");
    }

    @Test
    void authorizeFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformModulesApi api = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.authorizeFile("group/sub/project", "module_name", "module_system", "module_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file/authorize");
    }

    @Test
    void file_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .file(
                            "group/sub/project",
                            "module_name",
                            "module_system",
                            "module_version",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file");
    }

    @Test
    void file_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformModulesApi api = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.file(
                    "group/sub/project",
                    "module_name",
                    "module_system",
                    "module_version",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file");
    }

    @Test
    void listV1Versions_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/versions",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabTerraformModuleVersions.class, "terraform-module-versions.json")
                        + "]"));

        final List<GitLabTerraformModuleVersions> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .listV1Versions("module_namespace", "module_name", "module_system");
        }

        assertThat(result).containsExactly(TerraformmodulesCatalogFixtures.terraformModuleVersions());
        HTTP.verifyRequested(
                GET, "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/versions");
    }

    @Test
    void getV1Download_shouldReturnTheLocation_whenResponseIsARedirect() throws Exception {
        HTTP.stubRedirect(
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/download",
                "https://gitlab.example.test/files/1",
                302);

        final URI location;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            location = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1Download("module_namespace", "module_name", "module_system");
        }

        assertThat(location).hasToString("https://gitlab.example.test/files/1");
    }

    @Test
    void getV1_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabTerraformModuleVersion.class, "terraform-module-version.json")));

        final Optional<GitLabTerraformModuleVersion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1("module_namespace", "module_name", "module_system");
        }

        assertThat(result).contains(TerraformmodulesCatalogFixtures.terraformModuleVersion());
        HTTP.verifyRequested(GET, "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system");
    }

    @Test
    void getV1_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1("module_namespace", "module_name", "module_system")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system");
    }

    @Test
    void callV1Download_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/download",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .callV1Download("module_namespace", "module_name", "module_system", "module_version");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/download");
    }

    @Test
    void callV1Download_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/download",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformModulesApi api = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callV1Download("module_namespace", "module_name", "module_system", "module_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/download");
    }

    @Test
    void getV1File_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/file",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1File("module_namespace", "module_name", "module_system", "module_version", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getV1File_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/file",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1File("module_namespace", "module_name", "module_system", "module_version", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void getV1ByModuleVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabTerraformModuleVersion.class, "terraform-module-version.json")));

        final Optional<GitLabTerraformModuleVersion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1ByModuleVersion("module_namespace", "module_name", "module_system", "module_version");
        }

        assertThat(result).contains(TerraformmodulesCatalogFixtures.terraformModuleVersion());
        HTTP.verifyRequested(
                GET, "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version");
    }

    @Test
    void getV1ByModuleVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectTerraformModulesApi(GitLabCaller.of(client))
                    .getV1ByModuleVersion("module_namespace", "module_name", "module_system", "module_version")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version");
    }
}
