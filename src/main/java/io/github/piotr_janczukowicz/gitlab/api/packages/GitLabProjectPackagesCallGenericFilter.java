package io.github.piotr_janczukowicz.gitlab.api.packages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation
 * {@code getApiV4ProjectsIdPackagesGenericPackageNamePackageVersionFileName}, without paging.
 *
 * @param downloadMode the download mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPackagesGenericPackageNamePackageVersionFileName/parameters")
public record GitLabProjectPackagesCallGenericFilter(
        @Nullable GitLabProjectPackagesCallGenericDownloadMode downloadMode) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectPackagesCallGenericFilter empty() {
        return GitLabProjectPackagesCallGenericFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("download_mode", downloadMode, GitLabProjectPackagesCallGenericDownloadMode::wireValue)
                .build();
    }
}
