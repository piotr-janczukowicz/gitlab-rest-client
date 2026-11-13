package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsDelete},
 * without paging.
 *
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsDelete/parameters")
public record GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter(
        @Nullable String name) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter empty() {
        return GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("name", name).build();
    }
}
