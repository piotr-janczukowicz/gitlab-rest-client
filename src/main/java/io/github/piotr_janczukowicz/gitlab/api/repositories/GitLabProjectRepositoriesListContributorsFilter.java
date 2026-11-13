package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryContributors}, without paging.
 *
 * @param ref the ref
 * @param orderBy the order by
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryContributors/parameters")
public record GitLabProjectRepositoriesListContributorsFilter(
        @Nullable String ref,
        @Nullable GitLabProjectRepositoriesListContributorsOrderBy orderBy,
        @Nullable GitLabProjectRepositoriesListContributorsSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoriesListContributorsFilter empty() {
        return GitLabProjectRepositoriesListContributorsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("ref", ref)
                .wire("order_by", orderBy, GitLabProjectRepositoriesListContributorsOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectRepositoriesListContributorsSort::wireValue)
                .build();
    }
}
