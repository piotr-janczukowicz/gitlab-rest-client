package io.github.piotr_janczukowicz.gitlab.api.deployments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDeployments}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param updatedAfter the updated after
 * @param updatedBefore the updated before
 * @param finishedAfter the finished after
 * @param finishedBefore the finished before
 * @param environment the environment
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDeployments/parameters")
public record GitLabProjectDeploymentsListFilter(
        @Nullable GitLabProjectDeploymentsListOrderBy orderBy,
        @Nullable GitLabProjectDeploymentsListSort sort,
        @Nullable Instant updatedAfter,
        @Nullable Instant updatedBefore,
        @Nullable Instant finishedAfter,
        @Nullable Instant finishedBefore,
        @Nullable String environment,
        @Nullable GitLabProjectDeploymentsListStatus status) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectDeploymentsListFilter empty() {
        return GitLabProjectDeploymentsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabProjectDeploymentsListOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectDeploymentsListSort::wireValue)
                .value("updated_after", updatedAfter)
                .value("updated_before", updatedBefore)
                .value("finished_after", finishedAfter)
                .value("finished_before", finishedBefore)
                .text("environment", environment)
                .wire("status", status, GitLabProjectDeploymentsListStatus::wireValue)
                .build();
    }
}
