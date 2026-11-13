package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab dependency entity license entity.
 *
 * @param spdxIdentifier the spdx identifier
 * @param name the name
 * @param url the url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/DependencyEntityLicenseEntity")
public record GitLabDependencyEntityLicenseEntity(
        @Nullable String spdxIdentifier,
        @Nullable String name,
        @Nullable String url) {}
