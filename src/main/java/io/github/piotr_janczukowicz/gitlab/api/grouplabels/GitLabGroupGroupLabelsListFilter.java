package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdLabels}, without paging.
 *
 * @param withCounts the with counts
 * @param includeAncestorGroups the include ancestor groups
 * @param includeDescendantGroups the include descendant groups
 * @param onlyGroupLabels the only group labels
 * @param search the search
 * @param archived the archived
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdLabels/parameters")
public record GitLabGroupGroupLabelsListFilter(
        @Nullable Boolean withCounts,
        @Nullable Boolean includeAncestorGroups,
        @Nullable Boolean includeDescendantGroups,
        @Nullable Boolean onlyGroupLabels,
        @Nullable String search,
        @Nullable Boolean archived) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupLabelsListFilter empty() {
        return GitLabGroupGroupLabelsListFilterBuilder.builder().build();
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
                .value("include_descendant_groups", includeDescendantGroups)
                .value("only_group_labels", onlyGroupLabels)
                .text("search", search)
                .value("archived", archived)
                .build();
    }
}
