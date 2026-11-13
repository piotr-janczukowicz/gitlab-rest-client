package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPipelinesPipelineIdJobs}, without paging.
 *
 * @param includeRetried the include retried
 * @param scope the scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPipelinesPipelineIdJobs/parameters")
public record GitLabProjectJobsListPipelinesJobsFilter(
        @Nullable Boolean includeRetried,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_ARRAY)
        List<String> scope) {
    public GitLabProjectJobsListPipelinesJobsFilter {
        if (scope != null) {
            scope = List.copyOf(scope);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsListPipelinesJobsFilter empty() {
        return GitLabProjectJobsListPipelinesJobsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("include_retried", includeRetried)
                .list("scope", scope)
                .build();
    }
}
