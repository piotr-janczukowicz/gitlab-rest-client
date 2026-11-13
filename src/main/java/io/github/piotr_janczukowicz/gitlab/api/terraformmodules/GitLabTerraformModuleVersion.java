package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab terraform module version.
 *
 * @param name the name
 * @param provider the provider
 * @param providers the providers
 * @param root the root
 * @param source the source
 * @param submodules the submodules
 * @param version the version
 * @param versions the versions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTerraformModuleVersion")
public record GitLabTerraformModuleVersion(
        @Nullable String name,
        @Nullable String provider,
        @Nullable String providers,
        @Nullable String root,
        @Nullable String source,
        @Nullable String submodules,
        @Nullable String version,
        @Nullable String versions) {}
