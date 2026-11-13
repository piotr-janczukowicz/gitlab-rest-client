package io.github.piotr_janczukowicz.gitlab.api.debianpackages;

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
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectDebianPackagesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectDebianPackagesApi api() {
        return new GitLabProjectDebianPackagesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectDebianPackagesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callDistsReleaseGpg_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsReleaseGpg("group/sub/project", "distribution");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release.gpg");
    }

    @Test
    void callDistsReleaseGpg_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsReleaseGpg("group/sub/project", "distribution"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsRelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsRelease("group/sub/project", "distribution");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release");
    }

    @Test
    void callDistsRelease_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsRelease("group/sub/project", "distribution"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsInrelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsInrelease("group/sub/project", "distribution");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/InRelease");
    }

    @Test
    void callDistsInrelease_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsInrelease("group/sub/project", "distribution"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsDebianInstallerBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsDebianInstallerBinaryArchitecturePackages(
                        "group/sub/project", "distribution", "component", "architecture");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages");
    }

    @Test
    void callDistsDebianInstallerBinaryArchitecturePackages_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsDebianInstallerBinaryArchitecturePackages(
                        "group/sub/project", "distribution", "component", "architecture"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsDebianInstallerBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsDebianInstallerBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsDebianInstallerBinaryArchitectureByHashSha256_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsDebianInstallerBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsSourceSources_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsSourceSources("group/sub/project", "distribution", "component");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/Sources");
    }

    @Test
    void callDistsSourceSources_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callDistsSourceSources("group/sub/project", "distribution", "component"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsSourceByHashSha256_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsSourceByHashSha256("group/sub/project", "distribution", "component", "file_sha256");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsSourceByHashSha256_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().callDistsSourceByHashSha256("group/sub/project", "distribution", "component", "file_sha256"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsBinaryArchitecturePackages("group/sub/project", "distribution", "component", "architecture");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/Packages");
    }

    @Test
    void callDistsBinaryArchitecturePackages_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsBinaryArchitecturePackages(
                        "group/sub/project", "distribution", "component", "architecture"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDistsBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDistsBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsBinaryArchitectureByHashSha256_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callDistsBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPool_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getPool(
                        "group/sub/project",
                        "distribution",
                        "letter",
                        "package_name",
                        "package_version",
                        "file_name",
                        out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getPool_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getPool(
                        "group/sub/project",
                        "distribution",
                        "letter",
                        "package_name",
                        "package_version",
                        "file_name",
                        target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().update(
                        "group/sub/project",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name");
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorize(
                        "group/sub/project",
                        "file_name",
                        DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name/authorize");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"distribution\":");
        });
    }

    @Test
    void authorize_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorize(
                        "group/sub/project",
                        "file_name",
                        DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
