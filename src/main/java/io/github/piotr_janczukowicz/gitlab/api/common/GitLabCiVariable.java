package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci variable.
 *
 * @param variableType the variable type
 * @param key the key
 * @param value the value
 * @param hidden the hidden
 * @param protectedValue the protected
 * @param masked the masked
 * @param raw the raw
 * @param environmentScope the environment scope
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiVariable")
public record GitLabCiVariable(
        @Nullable String variableType,
        @Nullable String key,
        @Nullable String value,
        @Nullable Boolean hidden,
        @Nullable @JsonProperty("protected") Boolean protectedValue,
        @Nullable Boolean masked,
        @Nullable Boolean raw,
        @Nullable String environmentScope,
        @Nullable String description) {}
