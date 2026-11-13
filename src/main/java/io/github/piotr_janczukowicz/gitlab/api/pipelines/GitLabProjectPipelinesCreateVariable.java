package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project pipelines create variable of a GitLab resource.
 *
 * @param key the key
 * @param value the value
 * @param variableType the variable type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdPipeline/requestBody/properties/variables/items")
public record GitLabProjectPipelinesCreateVariable(
        @Nullable String key,
        @Nullable String value,
        @Nullable GitLabProjectPipelinesCreateVariableType variableType) {}
