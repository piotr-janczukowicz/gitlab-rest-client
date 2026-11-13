package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsCreate}.
 *
 * @param name the name
 * @param description the description
 * @param tags the tags
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsCreate/requestBody")
public record GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable List<Map<String, Object>> tags) {
    public GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload {
        if (tags != null) {
            tags = List.copyOf(tags);
        }
    }
}
