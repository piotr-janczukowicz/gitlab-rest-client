package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdProjectsShared}, without paging.
 *
 * @param archived the archived
 * @param visibility the visibility
 * @param search the search
 * @param orderBy the order by
 * @param sort the sort
 * @param simple the simple
 * @param starred the starred
 * @param withIssuesEnabled the with issues enabled
 * @param withMergeRequestsEnabled the with merge requests enabled
 * @param minAccessLevel the min access level
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdProjectsShared/parameters")
public record GitLabGroupGroupsListProjectsSharedFilter(
        @Nullable Boolean archived,
        @Nullable GitLabGroupGroupsListProjectsSharedVisibility visibility,
        @Nullable String search,
        @Nullable GitLabGroupGroupsListProjectsSharedOrderBy orderBy,
        @Nullable GitLabGroupGroupsListProjectsSharedSort sort,
        @Nullable Boolean simple,
        @Nullable Boolean starred,
        @Nullable Boolean withIssuesEnabled,
        @Nullable Boolean withMergeRequestsEnabled,
        @Nullable GitLabGroupGroupsListProjectsSharedMinAccessLevel minAccessLevel,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes) {
    public GitLabGroupGroupsListProjectsSharedFilter {
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListProjectsSharedFilter empty() {
        return GitLabGroupGroupsListProjectsSharedFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("archived", archived)
                .wire("visibility", visibility, GitLabGroupGroupsListProjectsSharedVisibility::wireValue)
                .text("search", search)
                .wire("order_by", orderBy, GitLabGroupGroupsListProjectsSharedOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupGroupsListProjectsSharedSort::wireValue)
                .value("simple", simple)
                .value("starred", starred)
                .value("with_issues_enabled", withIssuesEnabled)
                .value("with_merge_requests_enabled", withMergeRequestsEnabled)
                .wire("min_access_level", minAccessLevel, GitLabGroupGroupsListProjectsSharedMinAccessLevel::wireValue)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .build();
    }
}
