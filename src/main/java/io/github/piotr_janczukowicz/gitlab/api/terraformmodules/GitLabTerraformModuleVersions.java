package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab terraform module versions.
 *
 * @param modules the modules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTerraformModuleVersions")
public record GitLabTerraformModuleVersions(@Nullable String modules) {}
