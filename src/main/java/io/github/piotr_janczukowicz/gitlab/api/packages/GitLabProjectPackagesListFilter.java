package io.github.piotr_janczukowicz.gitlab.api.packages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPackages}, without paging.
 *
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
@CatalogSchema("operations/getApiV4ProjectsIdPackages/parameters")
public record GitLabProjectPackagesListFilter(
        @Nullable GitLabProjectPackagesListOrderBy orderBy,
        @Nullable GitLabProjectPackagesListSort sort,
        @Nullable GitLabProjectPackagesListPackageType packageType,
        @Nullable String packageName,
        @Nullable String packageVersion,
        @Nullable Boolean includeVersionless,
        @Nullable GitLabProjectPackagesListStatus status) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectPackagesListFilter empty() {
        return GitLabProjectPackagesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabProjectPackagesListOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectPackagesListSort::wireValue)
                .wire("package_type", packageType, GitLabProjectPackagesListPackageType::wireValue)
                .text("package_name", packageName)
                .text("package_version", packageVersion)
                .value("include_versionless", includeVersionless)
                .wire("status", status, GitLabProjectPackagesListStatus::wireValue)
                .build();
    }
}
