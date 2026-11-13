package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabGroupDebianDistributionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callPackagesDebianDistsReleaseGpg_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release.gpg",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsReleaseGpg("group/sub/project", "distribution");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release.gpg");
    }

    @Test
    void callPackagesDebianDistsReleaseGpg_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release.gpg",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsReleaseGpg("group/sub/project", "distribution"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release.gpg");
    }

    @Test
    void callPackagesDebianDistsRelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsRelease("group/sub/project", "distribution");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release");
    }

    @Test
    void callPackagesDebianDistsRelease_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsRelease("group/sub/project", "distribution"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/Release");
    }

    @Test
    void callPackagesDebianDistsInrelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/InRelease",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsInrelease("group/sub/project", "distribution");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/InRelease");
    }

    @Test
    void callPackagesDebianDistsInrelease_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/InRelease",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsInrelease("group/sub/project", "distribution"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/InRelease");
    }

    @Test
    void callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages(
                            "group/sub/project", "distribution", "component", "architecture");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages");
    }

    @Test
    void callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages(
                    "group/sub/project", "distribution", "component", "architecture"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages");
    }

    @Test
    void
            callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256(
                            "group/sub/project", "distribution", "component", "architecture", "file_sha256");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void
            callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256_shouldAnswerNotFound_whenResponseIsNotFound()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256(
                    "group/sub/project", "distribution", "component", "architecture", "file_sha256"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callPackagesDebianDistsSourceSources_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/Sources",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsSourceSources("group/sub/project", "distribution", "component");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/Sources");
    }

    @Test
    void callPackagesDebianDistsSourceSources_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/Sources",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callPackagesDebianDistsSourceSources("group/sub/project", "distribution", "component"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/Sources");
    }

    @Test
    void callPackagesDebianDistsSourceByHashSha256_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsSourceByHashSha256(
                            "group/sub/project", "distribution", "component", "file_sha256");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256");
    }

    @Test
    void callPackagesDebianDistsSourceByHashSha256_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsSourceByHashSha256(
                    "group/sub/project", "distribution", "component", "file_sha256"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256");
    }

    @Test
    void callPackagesDebianDistsBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/Packages",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsBinaryArchitecturePackages(
                            "group/sub/project", "distribution", "component", "architecture");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/Packages");
    }

    @Test
    void callPackagesDebianDistsBinaryArchitecturePackages_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/Packages",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsBinaryArchitecturePackages(
                    "group/sub/project", "distribution", "component", "architecture"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/Packages");
    }

    @Test
    void callPackagesDebianDistsBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .callPackagesDebianDistsBinaryArchitectureByHashSha256(
                            "group/sub/project", "distribution", "component", "architecture", "file_sha256");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callPackagesDebianDistsBinaryArchitectureByHashSha256_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDebianDistributionsApi api =
                    new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesDebianDistsBinaryArchitectureByHashSha256(
                    "group/sub/project", "distribution", "component", "architecture", "file_sha256"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void getPackagesDebianPool_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/pool/distribution/1/letter/package_name/package_version/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .getPackagesDebianPool(
                            "group/sub/project",
                            "distribution",
                            1L,
                            "letter",
                            "package_name",
                            "package_version",
                            "file_name",
                            out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getPackagesDebianPool_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/debian/pool/distribution/1/letter/package_name/package_version/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabGroupDebianDistributionsApi(GitLabCaller.of(client))
                    .getPackagesDebianPool(
                            "group/sub/project",
                            "distribution",
                            1L,
                            "letter",
                            "package_name",
                            "package_version",
                            "file_name",
                            target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }
}
