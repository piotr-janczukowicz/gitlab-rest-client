package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdGroupsShared}, without paging.
 *
 * @param skipGroups the skip groups
 * @param visibility the visibility
 * @param search the search
 * @param minAccessLevel the min access level
 * @param orderBy the order by
 * @param sort the sort
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdGroupsShared/parameters")
public record GitLabGroupGroupsListSharedFilter(
        @Nullable List<Integer> skipGroups,
        @Nullable GitLabGroupGroupsListSharedVisibility visibility,
        @Nullable String search,
        @Nullable GitLabGroupGroupsListSharedMinAccessLevel minAccessLevel,
        @Nullable GitLabGroupGroupsListSharedOrderBy orderBy,
        @Nullable GitLabGroupGroupsListSharedSort sort,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes) {
    public GitLabGroupGroupsListSharedFilter {
        if (skipGroups != null) {
            skipGroups = List.copyOf(skipGroups);
        }
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListSharedFilter empty() {
        return GitLabGroupGroupsListSharedFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .list("skip_groups", skipGroups)
                .wire("visibility", visibility, GitLabGroupGroupsListSharedVisibility::wireValue)
                .text("search", search)
                .wire("min_access_level", minAccessLevel, GitLabGroupGroupsListSharedMinAccessLevel::wireValue)
                .wire("order_by", orderBy, GitLabGroupGroupsListSharedOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupGroupsListSharedSort::wireValue)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .build();
    }
}
