package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdMlMlflowApi20MlflowModelVersionsUpdate}.
 *
 * @param name the name
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdMlMlflowApi20MlflowModelVersionsUpdate/requestBody")
public record GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload(
        @Nullable String name, @Nullable String description) {}
