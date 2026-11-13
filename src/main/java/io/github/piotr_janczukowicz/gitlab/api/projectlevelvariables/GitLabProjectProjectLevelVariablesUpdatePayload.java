package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdVariablesKey}.
 *
 * @param value the value
 * @param protectedValue the protected
 * @param masked the masked
 * @param environmentScope the environment scope
 * @param raw the raw
 * @param variableType the variable type
 * @param filter the filter
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdVariablesKey/requestBody")
public record GitLabProjectProjectLevelVariablesUpdatePayload(
        @Nullable String value,
        @Nullable @JsonProperty("protected") Boolean protectedValue,
        @Nullable Boolean masked,
        @Nullable String environmentScope,
        @Nullable Boolean raw,
        @Nullable GitLabProjectProjectLevelVariablesUpdateVariableType variableType,
        @Nullable GitLabProjectProjectLevelVariablesUpdateFilter filter,
        @Nullable String description) {}
