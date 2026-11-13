package io.github.piotr_janczukowicz.gitlab.api.tags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryTags}, without paging.
 *
 * @param sort the sort
 * @param orderBy the order by
 * @param search the search
 * @param pageToken the page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryTags/parameters")
public record GitLabProjectTagsListFilter(
        @Nullable GitLabProjectTagsListSort sort,
        @Nullable GitLabProjectTagsListOrderBy orderBy,
        @Nullable String search,
        @Nullable String pageToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code pageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectTagsListFilter[" + "sort=" + sort + ", orderBy=" + orderBy + ", search=" + search
                + ", pageToken=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectTagsListFilter empty() {
        return GitLabProjectTagsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("sort", sort, GitLabProjectTagsListSort::wireValue)
                .wire("order_by", orderBy, GitLabProjectTagsListOrderBy::wireValue)
                .text("search", search)
                .text("page_token", pageToken)
                .build();
    }
}
