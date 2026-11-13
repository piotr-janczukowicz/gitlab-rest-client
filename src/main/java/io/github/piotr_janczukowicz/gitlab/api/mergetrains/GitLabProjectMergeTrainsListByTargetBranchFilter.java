package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdMergeTrainsTargetBranch}, without paging.
 *
 * @param scope the scope
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdMergeTrainsTargetBranch/parameters")
public record GitLabProjectMergeTrainsListByTargetBranchFilter(
        @Nullable GitLabProjectMergeTrainsListByTargetBranchScope scope,
        @Nullable GitLabProjectMergeTrainsListByTargetBranchSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectMergeTrainsListByTargetBranchFilter empty() {
        return GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("scope", scope, GitLabProjectMergeTrainsListByTargetBranchScope::wireValue)
                .wire("sort", sort, GitLabProjectMergeTrainsListByTargetBranchSort::wireValue)
                .build();
    }
}
