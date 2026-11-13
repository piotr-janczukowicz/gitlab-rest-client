package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project project level variables update filter of a GitLab resource.
 *
 * @param environmentScope the environment scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdVariablesKey/requestBody/properties/filter")
public record GitLabProjectProjectLevelVariablesUpdateFilter(
        @Nullable String environmentScope) {}
