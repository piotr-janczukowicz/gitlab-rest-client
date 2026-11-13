package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project feature flags update strategy scope of a GitLab resource.
 *
 * @param id the id
 * @param environmentScope the environment scope
 * @param destroy the destroy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/putApiV4ProjectsIdFeatureFlagsFeatureFlagName/requestBody/properties/strategies/items/properties/scopes/items")
public record GitLabProjectFeatureFlagsUpdateStrategyScope(
        @Nullable Long id,
        @Nullable String environmentScope,
        @Nullable @JsonProperty("_destroy") Boolean destroy) {}
