package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab dependency.
 *
 * @param name the name
 * @param version the version
 * @param packageManager the package manager
 * @param dependencyFilePath the dependency file path
 * @param vulnerabilities the vulnerabilities
 * @param licenses the licenses
 * @param malware the malware
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDependency")
public record GitLabDependency(
        @Nullable String name,
        @Nullable String version,
        @Nullable String packageManager,
        @Nullable String dependencyFilePath,
        @Nullable GitLabDependencyEntityVulnerabilityEntity vulnerabilities,
        @Nullable GitLabDependencyEntityLicenseEntity licenses,
        @Nullable Boolean malware) {}
