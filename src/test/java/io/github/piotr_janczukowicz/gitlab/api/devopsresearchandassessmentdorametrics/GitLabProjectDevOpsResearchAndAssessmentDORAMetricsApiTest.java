package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi api() {
        return new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void call_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi lowTier =
                new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(
                        GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.call(
                "group/sub/project",
                GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void call_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi lowTier =
                new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(
                        GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.call(
                "group/sub/project",
                GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/dora/metrics");
            softly.assertThat(request.uri()).hasParameter("metric", "deployment_frequency");
        });
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call(
                        "group/sub/project",
                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.DEPLOYMENT_FREQUENCY,
                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                                .startDate(LocalDate.parse("2026-01-01"))
                                .endDate(LocalDate.parse("2026-01-01"))
                                .interval(GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                                .environmentTiers(List.of(
                                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers
                                                .PRODUCTION))
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("start_date", "2026-01-01");
    }
}
