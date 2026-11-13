package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDependencies}, without paging.
 *
 * @param packageManager the package manager
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDependencies/parameters")
public record GitLabProjectDependenciesListFilter(
        @Nullable List<GitLabProjectDependenciesListPackageManager> packageManager) {
    public GitLabProjectDependenciesListFilter {
        if (packageManager != null) {
            packageManager = List.copyOf(packageManager);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectDependenciesListFilter empty() {
        return GitLabProjectDependenciesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wireList("package_manager", packageManager, GitLabProjectDependenciesListPackageManager::wireValue)
                .build();
    }
}
