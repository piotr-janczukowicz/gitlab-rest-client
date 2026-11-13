package io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AdminCiVariables}.
 *
 * @param key the key
 * @param description the description
 * @param value the value
 * @param protectedValue the protected
 * @param masked the masked
 * @param raw the raw
 * @param variableType the variable type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AdminCiVariables/requestBody")
public record GitLabInstanceLevelCICDVariablesCreatePayload(
        @Nullable String key,
        @Nullable String description,
        @Nullable String value,
        @Nullable @JsonProperty("protected") Boolean protectedValue,
        @Nullable Boolean masked,
        @Nullable Boolean raw,
        @Nullable GitLabInstanceLevelCICDVariablesCreateVariableType variableType) {}
