package io.github.piotr_janczukowicz.gitlab.api.branches;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryBranches}, without paging.
 *
 * @param search the search
 * @param regex the regex
 * @param sort the sort
 * @param pageToken the page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryBranches/parameters")
public record GitLabProjectBranchesListFilter(
        @Nullable String search,
        @Nullable String regex,
        @Nullable GitLabProjectBranchesListSort sort,
        @Nullable String pageToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code pageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectBranchesListFilter[" + "search=" + search + ", regex=" + regex + ", sort=" + sort
                + ", pageToken=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectBranchesListFilter empty() {
        return GitLabProjectBranchesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("search", search)
                .text("regex", regex)
                .wire("sort", sort, GitLabProjectBranchesListSort::wireValue)
                .text("page_token", pageToken)
                .build();
    }
}
