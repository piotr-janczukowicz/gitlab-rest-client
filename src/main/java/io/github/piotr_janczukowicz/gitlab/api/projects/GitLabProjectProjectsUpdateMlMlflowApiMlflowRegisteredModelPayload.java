package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsUpdate}.
 *
 * @param name the name
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsUpdate/requestBody")
public record GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload(
        @Nullable String name, @Nullable String description) {}
