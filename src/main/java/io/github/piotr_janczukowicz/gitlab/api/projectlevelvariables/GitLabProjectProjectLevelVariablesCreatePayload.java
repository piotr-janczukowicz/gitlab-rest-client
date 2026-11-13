package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdVariables}.
 *
 * @param key the key
 * @param value the value
 * @param protectedValue the protected
 * @param masked the masked
 * @param maskedAndHidden the masked and hidden
 * @param raw the raw
 * @param variableType the variable type
 * @param environmentScope the environment scope
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdVariables/requestBody")
public record GitLabProjectProjectLevelVariablesCreatePayload(
        @Nullable String key,
        @Nullable String value,
        @Nullable @JsonProperty("protected") Boolean protectedValue,
        @Nullable Boolean masked,
        @Nullable Boolean maskedAndHidden,
        @Nullable Boolean raw,
        @Nullable GitLabProjectProjectLevelVariablesCreateVariableType variableType,
        @Nullable String environmentScope,
        @Nullable String description) {}
