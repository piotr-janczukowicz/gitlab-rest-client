package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project packages protection rule.
 *
 * @param id the id
 * @param projectId the project id
 * @param packageNamePattern the package name pattern
 * @param packageType the package type
 * @param minimumAccessLevelForDelete the minimum access level for delete
 * @param minimumAccessLevelForPush the minimum access level for push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectsPackagesProtectionRule")
public record GitLabProjectPackagesProtectionRule(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable String packageNamePattern,
        @Nullable String packageType,
        @Nullable String minimumAccessLevelForDelete,
        @Nullable String minimumAccessLevelForPush) {}
