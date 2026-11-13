package io.github.piotr_janczukowicz.gitlab.api.rubygems;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabProjectRubyGemsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/specs.4.8.gz",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabProjectRubyGemsGetFileName.SPECS_4_8_GZ, out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void get_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/specs.4.8.gz",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabProjectRubyGemsGetFileName.SPECS_4_8_GZ, target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void getQuickMarshal48_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/quick/Marshal.4.8/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .getQuickMarshal48("group/sub/project", "file_name", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getQuickMarshal48_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/quick/Marshal.4.8/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .getQuickMarshal48("group/sub/project", "file_name", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void getGem_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/gems/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRubyGemsApi(GitLabCaller.of(client)).getGem("group/sub/project", "file_name", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getGem_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/gems/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .getGem("group/sub/project", "file_name", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void authorizeApiV1Gem_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRubyGemsApi(GitLabCaller.of(client)).authorizeApiV1Gem("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems/authorize");
    }

    @Test
    void authorizeApiV1Gem_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRubyGemsApi api = new GitLabProjectRubyGemsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeApiV1Gem("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems/authorize");
    }

    @Test
    void createApiV1Gem_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .createApiV1Gem(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems");
    }

    @Test
    void createApiV1Gem_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRubyGemsApi api = new GitLabProjectRubyGemsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createApiV1Gem(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/gems");
    }

    @Test
    void getApiV1Dependencies_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/dependencies",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRubyGemsApi(GitLabCaller.of(client)).getApiV1Dependencies("group/sub/project", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getApiV1Dependencies_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rubygems/api/v1/dependencies",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectRubyGemsApi(GitLabCaller.of(client))
                    .getApiV1Dependencies("group/sub/project", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }
}
