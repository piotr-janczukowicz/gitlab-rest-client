package io.github.piotr_janczukowicz.gitlab.api.iterations;

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
 * Optional query parameters of the operation {@code getApiV4ProjectsIdIterations}, without paging.
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
@CatalogSchema("operations/getApiV4ProjectsIdIterations/parameters")
public record GitLabProjectIterationsListFilter(
        @Nullable GitLabProjectIterationsListState state,
        @Nullable String search,
        @Nullable @JsonProperty("in") List<GitLabProjectIterationsListIn> inValue,
        @Nullable Boolean includeAncestors,
        @Nullable Boolean includeDescendants,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter) {
    public GitLabProjectIterationsListFilter {
        if (inValue != null) {
            inValue = List.copyOf(inValue);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectIterationsListFilter empty() {
        return GitLabProjectIterationsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("state", state, GitLabProjectIterationsListState::wireValue)
                .text("search", search)
                .wireList("in", inValue, GitLabProjectIterationsListIn::wireValue)
                .value("include_ancestors", includeAncestors)
                .value("include_descendants", includeDescendants)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .build();
    }
}
