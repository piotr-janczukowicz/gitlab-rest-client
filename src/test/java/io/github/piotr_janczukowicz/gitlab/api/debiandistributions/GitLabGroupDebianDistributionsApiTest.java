package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

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
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabGroupDebianDistributionsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupDebianDistributionsApi api() {
        return new GitLabGroupDebianDistributionsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupDebianDistributionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callPackagesDebianDistsReleaseGpg_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsReleaseGpg("group/sub/project", "distribution");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release.gpg");
    }

    @Test
    void callPackagesDebianDistsReleaseGpg_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesDebianDistsReleaseGpg("group/sub/project", "distribution"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsRelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsRelease("group/sub/project", "distribution");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release");
    }

    @Test
    void callPackagesDebianDistsRelease_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesDebianDistsRelease("group/sub/project", "distribution"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsInrelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsInrelease("group/sub/project", "distribution");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/InRelease");
    }

    @Test
    void callPackagesDebianDistsInrelease_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesDebianDistsInrelease("group/sub/project", "distribution"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages(
                        "group/sub/project", "distribution", "component", "architecture");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages");
    }

    @Test
    void callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages(
                                "group/sub/project", "distribution", "component", "architecture"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void
            callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void
            callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256_shouldThrowNotFound_whenResponseIsNotFound()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256(
                                "group/sub/project", "distribution", "component", "architecture", "file_sha256"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsSourceSources_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsSourceSources("group/sub/project", "distribution", "component");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/Sources");
    }

    @Test
    void callPackagesDebianDistsSourceSources_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callPackagesDebianDistsSourceSources("group/sub/project", "distribution", "component"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsSourceByHashSha256_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsSourceByHashSha256(
                        "group/sub/project", "distribution", "component", "file_sha256");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256");
    }

    @Test
    void callPackagesDebianDistsSourceByHashSha256_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPackagesDebianDistsSourceByHashSha256(
                        "group/sub/project", "distribution", "component", "file_sha256"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsBinaryArchitecturePackages(
                        "group/sub/project", "distribution", "component", "architecture");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/Packages");
    }

    @Test
    void callPackagesDebianDistsBinaryArchitecturePackages_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPackagesDebianDistsBinaryArchitecturePackages(
                        "group/sub/project", "distribution", "component", "architecture"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesDebianDistsBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesDebianDistsBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callPackagesDebianDistsBinaryArchitectureByHashSha256_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPackagesDebianDistsBinaryArchitectureByHashSha256(
                        "group/sub/project", "distribution", "component", "architecture", "file_sha256"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPackagesDebianPool_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getPackagesDebianPool(
                        "group/sub/project",
                        "distribution",
                        1L,
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
    void getPackagesDebianPool_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getPackagesDebianPool(
                        "group/sub/project",
                        "distribution",
                        1L,
                        "letter",
                        "package_name",
                        "package_version",
                        "file_name",
                        target);

        assertThat(written).hasContent("abc");
    }
}
