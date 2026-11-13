package io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectGoogleCloudIntegrationApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectGoogleCloudIntegrationApi api() {
        return new GitLabProjectGoogleCloudIntegrationApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectGoogleCloudIntegrationApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getIntegrationsSh_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getIntegrationsSh("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/google_cloud/setup/integrations.sh");
        });
    }

    @Test
    void getRunnerDeploymentProjectSh_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getRunnerDeploymentProjectSh("group/sub/project", "my-project-123");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/google_cloud/setup/runner_deployment_project.sh");
        });
    }
}
