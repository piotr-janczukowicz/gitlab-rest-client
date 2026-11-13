package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project container registry protection tag rule.
 *
 * @param id the id
 * @param projectId the project id
 * @param tagNamePattern the tag name pattern
 * @param minimumAccessLevelForPush the minimum access level for push
 * @param minimumAccessLevelForDelete the minimum access level for delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectsContainerRegistryProtectionTagRule")
public record GitLabProjectContainerRegistryProtectionTagRule(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable String tagNamePattern,
        @Nullable String minimumAccessLevelForPush,
        @Nullable String minimumAccessLevelForDelete) {}
