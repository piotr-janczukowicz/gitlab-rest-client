package io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectGoogleCloudIntegrationApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getIntegrationsSh_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/google_cloud/setup/integrations.sh",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabProjectGoogleCloudIntegrationApi(GitLabCaller.of(client))
                    .getIntegrationsSh("group/sub/project");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/google_cloud/setup/integrations.sh");
    }

    @Test
    void getRunnerDeploymentProjectSh_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/google_cloud/setup/runner_deployment_project.sh",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabProjectGoogleCloudIntegrationApi(GitLabCaller.of(client))
                    .getRunnerDeploymentProjectSh("group/sub/project", "my-project-123");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/google_cloud/setup/runner_deployment_project.sh");
    }
}
