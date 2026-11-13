package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/dora/metrics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(GitLabCaller.of(client))
                    .call(
                            "group/sub/project",
                            GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/dora/metrics");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/dora/metrics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi api =
                    new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call(
                    "group/sub/project",
                    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/dora/metrics");
    }
}
