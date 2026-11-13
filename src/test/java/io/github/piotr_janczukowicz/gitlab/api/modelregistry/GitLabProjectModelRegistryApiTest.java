package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectModelRegistryApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectModelRegistryApi api() {
        return new GitLabProjectModelRegistryApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectModelRegistryApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void authorizeFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeFile(
                        "group/sub/project",
                        "model_version_id",
                        "file_name",
                        ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name/authorize");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void authorizeFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeFile(
                        "group/sub/project",
                        "model_version_id",
                        "file_name",
                        ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeFileByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeFileByPath(
                        "group/sub/project",
                        "model_version_id",
                        "path",
                        "file_name",
                        ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name/authorize");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void authorizeFileByPath_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeFileByPath(
                        "group/sub/project",
                        "model_version_id",
                        "path",
                        "file_name",
                        ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callFile("group/sub/project", "model_version_id", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name");
    }

    @Test
    void callFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callFile("group/sub/project", "model_version_id", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callFile_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callFile(
                        "group/sub/project",
                        "model_version_id",
                        "file_name",
                        GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                                .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("status", "default");
    }

    @Test
    void updateFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateFile(
                        "group/sub/project",
                        "model_version_id",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/file_name");
    }

    @Test
    void updateFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateFile(
                        "group/sub/project",
                        "model_version_id",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callFileByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callFileByPath("group/sub/project", "model_version_id", "path", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name");
    }

    @Test
    void callFileByPath_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callFileByPath("group/sub/project", "model_version_id", "path", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callFileByPath_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callFileByPath(
                        "group/sub/project",
                        "model_version_id",
                        "path",
                        "file_name",
                        GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                                .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("status", "default");
    }

    @Test
    void updateFileByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateFileByPath(
                        "group/sub/project",
                        "model_version_id",
                        "path",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/ml_models/model_version_id/files/path/file_name");
    }

    @Test
    void updateFileByPath_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateFileByPath(
                        "group/sub/project",
                        "model_version_id",
                        "path",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
