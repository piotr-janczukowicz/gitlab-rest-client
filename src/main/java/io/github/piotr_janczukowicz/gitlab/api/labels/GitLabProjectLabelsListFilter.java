package io.github.piotr_janczukowicz.gitlab.api.labels;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdLabels}, without paging.
 *
 * @param withCounts the with counts
 * @param includeAncestorGroups the include ancestor groups
 * @param search the search
 * @param archived the archived
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdLabels/parameters")
public record GitLabProjectLabelsListFilter(
        @Nullable Boolean withCounts,
        @Nullable Boolean includeAncestorGroups,
        @Nullable String search,
        @Nullable Boolean archived) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectLabelsListFilter empty() {
        return GitLabProjectLabelsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("with_counts", withCounts)
                .value("include_ancestor_groups", includeAncestorGroups)
                .text("search", search)
                .value("archived", archived)
                .build();
    }
}
