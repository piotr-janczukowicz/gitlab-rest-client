package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdMergeTrains}, without paging.
 *
 * @param scope the scope
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdMergeTrains/parameters")
public record GitLabProjectMergeTrainsListFilter(
        @Nullable GitLabProjectMergeTrainsListScope scope,
        @Nullable GitLabProjectMergeTrainsListSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectMergeTrainsListFilter empty() {
        return GitLabProjectMergeTrainsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("scope", scope, GitLabProjectMergeTrainsListScope::wireValue)
                .wire("sort", sort, GitLabProjectMergeTrainsListSort::wireValue)
                .build();
    }
}
