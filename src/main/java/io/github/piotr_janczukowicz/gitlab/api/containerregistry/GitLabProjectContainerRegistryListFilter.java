package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRegistryRepositories}, without paging.
 *
 * @param tags the tags
 * @param tagsCount the tags count
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRegistryRepositories/parameters")
public record GitLabProjectContainerRegistryListFilter(
        @Nullable Boolean tags, @Nullable Boolean tagsCount) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectContainerRegistryListFilter empty() {
        return GitLabProjectContainerRegistryListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("tags", tags)
                .value("tags_count", tagsCount)
                .build();
    }
}
