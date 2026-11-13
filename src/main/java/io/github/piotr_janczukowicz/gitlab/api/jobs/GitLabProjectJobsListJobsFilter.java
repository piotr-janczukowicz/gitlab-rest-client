package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdJobs}, without paging.
 *
 * @param scope the scope
 * @param ref the ref
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdJobs/parameters")
public record GitLabProjectJobsListJobsFilter(
        @Nullable List<GitLabProjectJobsListJobsScope> scope,
        @Nullable String ref) {
    public GitLabProjectJobsListJobsFilter {
        if (scope != null) {
            scope = List.copyOf(scope);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsListJobsFilter empty() {
        return GitLabProjectJobsListJobsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wireList("scope", scope, GitLabProjectJobsListJobsScope::wireValue)
                .text("ref", ref)
                .build();
    }
}
