package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectTerraformModulesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectTerraformModulesApi api() {
        return new GitLabProjectTerraformModulesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectTerraformModulesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project", "module_name", "module_system");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call("group/sub/project", "module_name", "module_system"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        "module_name",
                        "module_system",
                        GitLabProjectTerraformModulesCallFilterBuilder.builder()
                                .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("terraform-get", "1");
    }

    @Test
    void callByModuleVersion_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callByModuleVersion("group/sub/project", "module_name", "module_system", "module_version");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version");
    }

    @Test
    void callByModuleVersion_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callByModuleVersion("group/sub/project", "module_name", "module_system", "module_version"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callByModuleVersion_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callByModuleVersion(
                        "group/sub/project",
                        "module_name",
                        "module_system",
                        "module_version",
                        GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                                .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("terraform-get", "1");
    }

    @Test
    void authorizeFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeFile("group/sub/project", "module_name", "module_system", "module_version");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file/authorize");
    }

    @Test
    void authorizeFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().authorizeFile("group/sub/project", "module_name", "module_system", "module_version"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void file_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().file(
                        "group/sub/project",
                        "module_name",
                        "module_system",
                        "module_version",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/terraform/modules/module_name/module_system/module_version/file");
    }

    @Test
    void file_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().file(
                        "group/sub/project",
                        "module_name",
                        "module_system",
                        "module_version",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listV1Versions_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabTerraformModuleVersions.class, "terraform-module-versions.json")
                                + "]"));

        final List<GitLabTerraformModuleVersions> result =
                api().listV1Versions("module_namespace", "module_name", "module_system");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(TerraformmodulesCatalogFixtures.terraformModuleVersions());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/versions");
        });
    }

    @Test
    void getV1Download_shouldReturnTheLocation_whenResponseIsARedirect() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(302, null, "Location", "https://gitlab.example.test/files/1"));

        final URI location = api().getV1Download("module_namespace", "module_name", "module_system");

        assertThat(location).hasToString("https://gitlab.example.test/files/1");
    }

    @Test
    void getV1_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabTerraformModuleVersion.class, "terraform-module-version.json")));

        final Optional<GitLabTerraformModuleVersion> result =
                api().getV1("module_namespace", "module_name", "module_system");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(TerraformmodulesCatalogFixtures.terraformModuleVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system");
        });
    }

    @Test
    void getV1_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabTerraformModuleVersion> result =
                api().getV1("module_namespace", "module_name", "module_system");

        assertThat(result).isEmpty();
    }

    @Test
    void callV1Download_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1Download("module_namespace", "module_name", "module_system", "module_version");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version/download");
    }

    @Test
    void callV1Download_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callV1Download("module_namespace", "module_name", "module_system", "module_version"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV1File_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getV1File("module_namespace", "module_name", "module_system", "module_version", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getV1File_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written =
                api().getV1File("module_namespace", "module_name", "module_system", "module_version", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void getV1ByModuleVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabTerraformModuleVersion.class, "terraform-module-version.json")));

        final Optional<GitLabTerraformModuleVersion> result =
                api().getV1ByModuleVersion("module_namespace", "module_name", "module_system", "module_version");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(TerraformmodulesCatalogFixtures.terraformModuleVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/terraform/modules/v1/module_namespace/module_name/module_system/module_version");
        });
    }

    @Test
    void getV1ByModuleVersion_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabTerraformModuleVersion> result =
                api().getV1ByModuleVersion("module_namespace", "module_name", "module_system", "module_version");

        assertThat(result).isEmpty();
    }
}
