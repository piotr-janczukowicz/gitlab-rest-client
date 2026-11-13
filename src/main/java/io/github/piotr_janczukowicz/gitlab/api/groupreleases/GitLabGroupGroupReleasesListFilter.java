package io.github.piotr_janczukowicz.gitlab.api.groupreleases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdReleases}, without paging.
 *
 * @param sort the sort
 * @param simple the simple
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdReleases/parameters")
public record GitLabGroupGroupReleasesListFilter(
        @Nullable GitLabGroupGroupReleasesListSort sort,
        @Nullable Boolean simple) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupReleasesListFilter empty() {
        return GitLabGroupGroupReleasesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("sort", sort, GitLabGroupGroupReleasesListSort::wireValue)
                .value("simple", simple)
                .build();
    }
}
