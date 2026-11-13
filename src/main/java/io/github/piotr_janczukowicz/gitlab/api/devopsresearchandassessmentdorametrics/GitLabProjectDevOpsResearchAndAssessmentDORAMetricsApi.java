package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of project dev ops research and assessment dorametrics. */
public final class GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi extends GitLabResourceApi {
    private static final PathTemplate CALL = PathTemplate.of("/projects/{id}/dora/metrics");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /projects/{id}/dora/metrics}).
     *
     * @param id the id
     * @param metric the metric
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code metric} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void call(final String id, final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric metric)
            throws IOException {
        call(id, metric, GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilter.empty());
    }

    /**
     * Call ({@code GET /projects/{id}/dora/metrics}).
     *
     * @param id the id
     * @param metric the metric
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code metric} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void call(
            final String id,
            final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric metric,
            final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdDoraMetrics");
        requireNotBlank(id, "id");
        requireNonNull(metric, "metric");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .wire("metric", metric, GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric::wireValue)
                .build();
        caller.send(get(CALL, id).withQuery(queryParameters));
    }
}
