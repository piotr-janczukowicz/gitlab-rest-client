package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdPipelines},
 * without paging.
 *
 * @param scope the scope
 * @param status the status
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 * @param createdBefore the created before
 * @param createdAfter the created after
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdPipelines/parameters")
public record GitLabProjectPipelineSchedulesListPipelinesFilter(
        @Nullable GitLabProjectPipelineSchedulesListPipelinesScope scope,
        @Nullable GitLabProjectPipelineSchedulesListPipelinesStatus status,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant createdBefore,
        @Nullable Instant createdAfter,
        @Nullable GitLabProjectPipelineSchedulesListPipelinesSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectPipelineSchedulesListPipelinesFilter empty() {
        return GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("scope", scope, GitLabProjectPipelineSchedulesListPipelinesScope::wireValue)
                .wire("status", status, GitLabProjectPipelineSchedulesListPipelinesStatus::wireValue)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .value("created_before", createdBefore)
                .value("created_after", createdAfter)
                .wire("sort", sort, GitLabProjectPipelineSchedulesListPipelinesSort::wireValue)
                .build();
    }
}
