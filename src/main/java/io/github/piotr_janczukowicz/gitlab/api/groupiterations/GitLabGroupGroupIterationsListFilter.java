package io.github.piotr_janczukowicz.gitlab.api.groupiterations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdIterations}, without paging.
 *
 * @param state the state
 * @param search the search
 * @param inValue the in
 * @param includeAncestors the include ancestors
 * @param includeDescendants the include descendants
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdIterations/parameters")
public record GitLabGroupGroupIterationsListFilter(
        @Nullable GitLabGroupGroupIterationsListState state,
        @Nullable String search,
        @Nullable @JsonProperty("in") List<GitLabGroupGroupIterationsListIn> inValue,
        @Nullable Boolean includeAncestors,
        @Nullable Boolean includeDescendants,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter) {
    public GitLabGroupGroupIterationsListFilter {
        if (inValue != null) {
            inValue = List.copyOf(inValue);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupIterationsListFilter empty() {
        return GitLabGroupGroupIterationsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("state", state, GitLabGroupGroupIterationsListState::wireValue)
                .text("search", search)
                .wireList("in", inValue, GitLabGroupGroupIterationsListIn::wireValue)
                .value("include_ancestors", includeAncestors)
                .value("include_descendants", includeDescendants)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .build();
    }
}
