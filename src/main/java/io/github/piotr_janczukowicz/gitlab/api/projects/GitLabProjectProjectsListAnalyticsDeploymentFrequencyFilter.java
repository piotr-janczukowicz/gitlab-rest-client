package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdAnalyticsDeploymentFrequency}, without paging.
 *
 * @param to the to
 * @param interval the interval
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdAnalyticsDeploymentFrequency/parameters")
public record GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter(
        @Nullable Instant to, @Nullable GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval interval) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter empty() {
        return GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("to", to)
                .wire("interval", interval, GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval::wireValue)
                .build();
    }
}
