package io.github.piotr_janczukowicz.gitlab.api.debianpackages;

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
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectDebianPackagesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callDistsReleaseGpg_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release.gpg",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsReleaseGpg("group/sub/project", "distribution");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release.gpg");
    }

    @Test
    void callDistsReleaseGpg_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release.gpg",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsReleaseGpg("group/sub/project", "distribution"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release.gpg");
    }

    @Test
    void callDistsRelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsRelease("group/sub/project", "distribution");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release");
    }

    @Test
    void callDistsRelease_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsRelease("group/sub/project", "distribution"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/Release");
    }

    @Test
    void callDistsInrelease_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/InRelease",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsInrelease("group/sub/project", "distribution");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/InRelease");
    }

    @Test
    void callDistsInrelease_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/InRelease",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsInrelease("group/sub/project", "distribution"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/InRelease");
    }

    @Test
    void callDistsDebianInstallerBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsDebianInstallerBinaryArchitecturePackages(
                            "group/sub/project", "distribution", "component", "architecture");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages");
    }

    @Test
    void callDistsDebianInstallerBinaryArchitecturePackages_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsDebianInstallerBinaryArchitecturePackages(
                    "group/sub/project", "distribution", "component", "architecture"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/Packages");
    }

    @Test
    void callDistsDebianInstallerBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsDebianInstallerBinaryArchitectureByHashSha256(
                            "group/sub/project", "distribution", "component", "architecture", "file_sha256");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsDebianInstallerBinaryArchitectureByHashSha256_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsDebianInstallerBinaryArchitectureByHashSha256(
                    "group/sub/project", "distribution", "component", "architecture", "file_sha256"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/debian-installer/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsSourceSources_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/Sources",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsSourceSources("group/sub/project", "distribution", "component");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/Sources");
    }

    @Test
    void callDistsSourceSources_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/Sources",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsSourceSources("group/sub/project", "distribution", "component"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/Sources");
    }

    @Test
    void callDistsSourceByHashSha256_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsSourceByHashSha256("group/sub/project", "distribution", "component", "file_sha256");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsSourceByHashSha256_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.callDistsSourceByHashSha256("group/sub/project", "distribution", "component", "file_sha256"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/source/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsBinaryArchitecturePackages_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/Packages",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsBinaryArchitecturePackages(
                            "group/sub/project", "distribution", "component", "architecture");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/Packages");
    }

    @Test
    void callDistsBinaryArchitecturePackages_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/Packages",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsBinaryArchitecturePackages(
                    "group/sub/project", "distribution", "component", "architecture"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/Packages");
    }

    @Test
    void callDistsBinaryArchitectureByHashSha256_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .callDistsBinaryArchitectureByHashSha256(
                            "group/sub/project", "distribution", "component", "architecture", "file_sha256");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void callDistsBinaryArchitectureByHashSha256_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDistsBinaryArchitectureByHashSha256(
                    "group/sub/project", "distribution", "component", "architecture", "file_sha256"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/dists/distribution/component/binary-architecture/by-hash/SHA256/file_sha256");
    }

    @Test
    void getPool_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/pool/distribution/letter/package_name/package_version/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .getPool(
                            "group/sub/project",
                            "distribution",
                            "letter",
                            "package_name",
                            "package_version",
                            "file_name",
                            out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getPool_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/pool/distribution/letter/package_name/package_version/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .getPool(
                            "group/sub/project",
                            "distribution",
                            "letter",
                            "package_name",
                            "package_version",
                            "file_name",
                            target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "file_name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "file_name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name");
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianPackagesApi(GitLabCaller.of(client))
                    .authorize(
                            "group/sub/project",
                            "file_name",
                            DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianPackagesApi api = new GitLabProjectDebianPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize(
                    "group/sub/project",
                    "file_name",
                    DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/debian/file_name/authorize");
    }
}
