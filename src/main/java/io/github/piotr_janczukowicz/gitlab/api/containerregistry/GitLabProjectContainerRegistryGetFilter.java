package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4RegistryRepositoriesId}, without paging.
 *
 * @param tags the tags
 * @param tagsCount the tags count
 * @param size the size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4RegistryRepositoriesId/parameters")
public record GitLabProjectContainerRegistryGetFilter(
        @Nullable Boolean tags,
        @Nullable Boolean tagsCount,
        @Nullable Boolean size) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectContainerRegistryGetFilter empty() {
        return GitLabProjectContainerRegistryGetFilterBuilder.builder().build();
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
                .value("size", size)
                .build();
    }
}
