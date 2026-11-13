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
 * Optional query parameters of the operation {@code getApiV4GroupsIdProjects}, without paging.
 *
 * @param active the active
 * @param archived the archived
 * @param visibility the visibility
 * @param search the search
 * @param orderBy the order by
 * @param sort the sort
 * @param simple the simple
 * @param owned the owned
 * @param starred the starred
 * @param withIssuesEnabled the with issues enabled
 * @param withMergeRequestsEnabled the with merge requests enabled
 * @param withShared the with shared
 * @param includeSubgroups the include subgroups
 * @param includeAncestorGroups the include ancestor groups
 * @param minAccessLevel the min access level
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 * @param withSecurityReports the with security reports
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdProjects/parameters")
public record GitLabGroupGroupsListProjectsFilter(
        @Nullable Boolean active,
        @Nullable Boolean archived,
        @Nullable GitLabGroupGroupsListProjectsVisibility visibility,
        @Nullable String search,
        @Nullable GitLabGroupGroupsListProjectsOrderBy orderBy,
        @Nullable GitLabGroupGroupsListProjectsSort sort,
        @Nullable Boolean simple,
        @Nullable Boolean owned,
        @Nullable Boolean starred,
        @Nullable Boolean withIssuesEnabled,
        @Nullable Boolean withMergeRequestsEnabled,
        @Nullable Boolean withShared,
        @Nullable Boolean includeSubgroups,
        @Nullable Boolean includeAncestorGroups,
        @Nullable GitLabGroupGroupsListProjectsMinAccessLevel minAccessLevel,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes,

        @Nullable Boolean withSecurityReports) {
    public GitLabGroupGroupsListProjectsFilter {
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListProjectsFilter empty() {
        return GitLabGroupGroupsListProjectsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("active", active)
                .value("archived", archived)
                .wire("visibility", visibility, GitLabGroupGroupsListProjectsVisibility::wireValue)
                .text("search", search)
                .wire("order_by", orderBy, GitLabGroupGroupsListProjectsOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupGroupsListProjectsSort::wireValue)
                .value("simple", simple)
                .value("owned", owned)
                .value("starred", starred)
                .value("with_issues_enabled", withIssuesEnabled)
                .value("with_merge_requests_enabled", withMergeRequestsEnabled)
                .value("with_shared", withShared)
                .value("include_subgroups", includeSubgroups)
                .value("include_ancestor_groups", includeAncestorGroups)
                .wire("min_access_level", minAccessLevel, GitLabGroupGroupsListProjectsMinAccessLevel::wireValue)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .value("with_security_reports", withSecurityReports)
                .build();
    }
}
