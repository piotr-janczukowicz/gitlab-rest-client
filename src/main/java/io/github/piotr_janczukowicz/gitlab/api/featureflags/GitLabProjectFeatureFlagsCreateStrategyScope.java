package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project feature flags create strategy scope of a GitLab resource.
 *
 * @param environmentScope the environment scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/postApiV4ProjectsIdFeatureFlags/requestBody/properties/strategies/items/properties/scopes/items")
public record GitLabProjectFeatureFlagsCreateStrategyScope(
        @Nullable String environmentScope) {}
