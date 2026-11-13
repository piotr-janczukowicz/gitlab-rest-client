package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab package links of a GitLab resource.
 *
 * @param webPath the web path
 * @param deleteApiPath the delete api path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackage/properties/_links")
public record GitLabPackageLinks(
        @Nullable String webPath, @Nullable String deleteApiPath) {}
