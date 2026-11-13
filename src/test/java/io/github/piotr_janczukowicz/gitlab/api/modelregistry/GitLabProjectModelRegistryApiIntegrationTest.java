package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectModelRegistryApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void authorizeFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectModelRegistryApi(GitLabCaller.of(client))
                    .authorizeFile(
                            "group/sub/project",
                            "model_version_id",
                            "file_name",
                            ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name/authorize");
    }

    @Test
    void authorizeFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectModelRegistryApi api = new GitLabProjectModelRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeFile(
                    "group/sub/project",
                    "model_version_id",
                    "file_name",
                    ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name/authorize");
    }

    @Test
    void authorizeFileByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectModelRegistryApi(GitLabCaller.of(client))
                    .authorizeFileByPath(
                            "group/sub/project",
                            "model_version_id",
                            "path",
                            "file_name",
                            ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name/authorize");
    }

    @Test
    void authorizeFileByPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectModelRegistryApi api = new GitLabProjectModelRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeFileByPath(
                    "group/sub/project",
                    "model_version_id",
                    "path",
                    "file_name",
                    ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name/authorize");
    }

    @Test
    void callFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectModelRegistryApi(GitLabCaller.of(client))
                    .callFile("group/sub/project", "model_version_id", "file_name");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name");
    }

    @Test
    void callFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectModelRegistryApi api = new GitLabProjectModelRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callFile("group/sub/project", "model_version_id", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name");
    }

    @Test
    void updateFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectModelRegistryApi(GitLabCaller.of(client))
                    .updateFile(
                            "group/sub/project",
                            "model_version_id",
                            "file_name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name");
    }

    @Test
    void updateFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectModelRegistryApi api = new GitLabProjectModelRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateFile(
                    "group/sub/project",
                    "model_version_id",
                    "file_name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name");
    }

    @Test
    void callFileByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectModelRegistryApi(GitLabCaller.of(client))
                    .callFileByPath("group/sub/project", "model_version_id", "path", "file_name");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name");
    }

    @Test
    void callFileByPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectModelRegistryApi api = new GitLabProjectModelRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callFileByPath("group/sub/project", "model_version_id", "path", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name");
    }

    @Test
    void updateFileByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectModelRegistryApi(GitLabCaller.of(client))
                    .updateFileByPath(
                            "group/sub/project",
                            "model_version_id",
                            "path",
                            "file_name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name");
    }

    @Test
    void updateFileByPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectModelRegistryApi api = new GitLabProjectModelRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateFileByPath(
                    "group/sub/project",
                    "model_version_id",
                    "path",
                    "file_name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name");
    }
}
