package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPackagesNugetQuery}, without paging.
 *
 * @param q the q
 * @param skip the skip
 * @param take the take
 * @param prerelease the prerelease
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPackagesNugetQuery/parameters")
public record GitLabProjectNuGetPackagesGetQueryFilter(
        @Nullable String q,
        @Nullable Integer skip,
        @Nullable Integer take,
        @Nullable Boolean prerelease) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectNuGetPackagesGetQueryFilter empty() {
        return GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("q", q)
                .value("skip", skip)
                .value("take", take)
                .value("prerelease", prerelease)
                .build();
    }
}
