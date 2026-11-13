package io.github.piotr_janczukowicz.gitlab.api.pypipackages;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectPyPIPackagesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/files/sha256/file_identifier",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client))
                    .callFile("group/sub/project", "sha256", "file_identifier");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/files/sha256/file_identifier");
    }

    @Test
    void callFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/files/sha256/file_identifier",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPyPIPackagesApi api = new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callFile("group/sub/project", "sha256", "file_identifier"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/files/sha256/file_identifier");
    }

    @Test
    void callSimple_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client)).callSimple("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple");
    }

    @Test
    void callSimple_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPyPIPackagesApi api = new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callSimple("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple");
    }

    @Test
    void callSimpleByPackageName_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple/package_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client))
                    .callSimpleByPackageName("group/sub/project", "package_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple/package_name");
    }

    @Test
    void callSimpleByPackageName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple/package_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPyPIPackagesApi api = new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callSimpleByPackageName("group/sub/project", "package_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/simple/package_name");
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPyPIPackagesApi api = new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi");
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client)).authorize("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPyPIPackagesApi api = new GitLabProjectPyPIPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/pypi/authorize");
    }
}
