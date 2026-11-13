package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project container registry protection rule.
 *
 * @param id the id
 * @param projectId the project id
 * @param repositoryPathPattern the repository path pattern
 * @param minimumAccessLevelForPush the minimum access level for push
 * @param minimumAccessLevelForDelete the minimum access level for delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectsContainerRegistryProtectionRule")
public record GitLabProjectContainerRegistryProtectionRule(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable String repositoryPathPattern,
        @Nullable String minimumAccessLevelForPush,
        @Nullable String minimumAccessLevelForDelete) {}
