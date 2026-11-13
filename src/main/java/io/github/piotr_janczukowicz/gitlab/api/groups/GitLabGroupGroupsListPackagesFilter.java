package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdPackages}, without paging.
 *
 * @param excludeSubgroups the exclude subgroups
 * @param orderBy the order by
 * @param sort the sort
 * @param packageType the package type
 * @param packageName the package name
 * @param packageVersion the package version
 * @param includeVersionless the include versionless
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdPackages/parameters")
public record GitLabGroupGroupsListPackagesFilter(
        @Nullable Boolean excludeSubgroups,
        @Nullable GitLabGroupGroupsListPackagesOrderBy orderBy,
        @Nullable GitLabGroupGroupsListPackagesSort sort,
        @Nullable GitLabGroupGroupsListPackagesPackageType packageType,
        @Nullable String packageName,
        @Nullable String packageVersion,
        @Nullable Boolean includeVersionless,
        @Nullable GitLabGroupGroupsListPackagesStatus status) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListPackagesFilter empty() {
        return GitLabGroupGroupsListPackagesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("exclude_subgroups", excludeSubgroups)
                .wire("order_by", orderBy, GitLabGroupGroupsListPackagesOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupGroupsListPackagesSort::wireValue)
                .wire("package_type", packageType, GitLabGroupGroupsListPackagesPackageType::wireValue)
                .text("package_name", packageName)
                .text("package_version", packageVersion)
                .value("include_versionless", includeVersionless)
                .wire("status", status, GitLabGroupGroupsListPackagesStatus::wireValue)
                .build();
    }
}
