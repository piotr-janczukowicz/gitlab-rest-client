package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryCommitsShaStatuses}, without paging.
 *
 * @param ref the ref
 * @param stage the stage
 * @param name the name
 * @param pipelineId the pipeline id
 * @param all the all
 * @param orderBy the order by
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryCommitsShaStatuses/parameters")
public record GitLabProjectCommitsListStatusesFilter(
        @Nullable String ref,
        @Nullable String stage,
        @Nullable String name,
        @Nullable Long pipelineId,
        @Nullable Boolean all,
        @Nullable GitLabProjectCommitsListStatusesOrderBy orderBy,
        @Nullable GitLabProjectCommitsListStatusesSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectCommitsListStatusesFilter empty() {
        return GitLabProjectCommitsListStatusesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("ref", ref)
                .text("stage", stage)
                .text("name", name)
                .value("pipeline_id", pipelineId)
                .value("all", all)
                .wire("order_by", orderBy, GitLabProjectCommitsListStatusesOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectCommitsListStatusesSort::wireValue)
                .build();
    }
}
