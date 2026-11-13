package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdMilestones}, without paging.
 *
 * @param state the state
 * @param iids the iids
 * @param title the title
 * @param search the search
 * @param searchTitle the search title
 * @param includeParentMilestones the include parent milestones
 * @param includeAncestors the include ancestors
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 * @param containingDate the containing date
 * @param startDate the start date
 * @param endDate the end date
 * @param sort the sort
 * @param includeDescendants the include descendants
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdMilestones/parameters")
public record GitLabGroupGroupMilestonesListFilter(
        @Nullable GitLabGroupGroupMilestonesListState state,
        @Nullable List<Integer> iids,
        @Nullable String title,
        @Nullable String search,
        @Nullable String searchTitle,
        @Nullable Boolean includeParentMilestones,
        @Nullable Boolean includeAncestors,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant containingDate,
        @Nullable Instant startDate,
        @Nullable Instant endDate,
        @Nullable GitLabGroupGroupMilestonesListSort sort,
        @Nullable Boolean includeDescendants) {
    public GitLabGroupGroupMilestonesListFilter {
        if (iids != null) {
            iids = List.copyOf(iids);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupMilestonesListFilter empty() {
        return GitLabGroupGroupMilestonesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("state", state, GitLabGroupGroupMilestonesListState::wireValue)
                .list("iids", iids)
                .text("title", title)
                .text("search", search)
                .text("search_title", searchTitle)
                .value("include_parent_milestones", includeParentMilestones)
                .value("include_ancestors", includeAncestors)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .value("containing_date", containingDate)
                .value("start_date", startDate)
                .value("end_date", endDate)
                .wire("sort", sort, GitLabGroupGroupMilestonesListSort::wireValue)
                .value("include_descendants", includeDescendants)
                .build();
    }
}
