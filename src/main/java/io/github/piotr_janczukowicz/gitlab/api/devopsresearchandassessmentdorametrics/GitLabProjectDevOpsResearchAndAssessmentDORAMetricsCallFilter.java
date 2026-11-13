package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDoraMetrics}, without paging.
 *
 * @param startDate the start date
 * @param endDate the end date
 * @param interval the interval
 * @param environmentTiers the environment tiers
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDoraMetrics/parameters")
public record GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilter(
        @Nullable LocalDate startDate,
        @Nullable LocalDate endDate,
        @Nullable GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallInterval interval,
        @Nullable List<GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers> environmentTiers) {
    public GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilter {
        if (environmentTiers != null) {
            environmentTiers = List.copyOf(environmentTiers);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilter empty() {
        return GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("start_date", startDate)
                .value("end_date", endDate)
                .wire("interval", interval, GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallInterval::wireValue)
                .wireList(
                        "environment_tiers",
                        environmentTiers,
                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers::wireValue)
                .build();
    }
}
