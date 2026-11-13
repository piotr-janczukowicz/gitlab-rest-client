package io.github.piotr_janczukowicz.gitlab.api.rubygems;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPackagesRubygemsApiV1Dependencies}, without
 * paging.
 *
 * @param gems the gems
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPackagesRubygemsApiV1Dependencies/parameters")
public record GitLabProjectRubyGemsGetApiV1DependenciesFilter(
        @Nullable List<String> gems) {
    public GitLabProjectRubyGemsGetApiV1DependenciesFilter {
        if (gems != null) {
            gems = List.copyOf(gems);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRubyGemsGetApiV1DependenciesFilter empty() {
        return GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().list("gems", gems).build();
    }
}
