package io.github.piotr_janczukowicz.gitlab.api.releases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdReleases}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param includeHtmlDescription the include html description
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdReleases/parameters")
public record GitLabProjectReleasesListFilter(
        @Nullable GitLabProjectReleasesListOrderBy orderBy,
        @Nullable GitLabProjectReleasesListSort sort,
        @Nullable Boolean includeHtmlDescription,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectReleasesListFilter empty() {
        return GitLabProjectReleasesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabProjectReleasesListOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectReleasesListSort::wireValue)
                .value("include_html_description", includeHtmlDescription)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .build();
    }
}
