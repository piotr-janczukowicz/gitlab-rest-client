package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdRegistryProtectionRepositoryRulesProtectionRuleId}.
 *
 * @param repositoryPathPattern the repository path pattern
 * @param minimumAccessLevelForPush the minimum access level for push
 * @param minimumAccessLevelForDelete the minimum access level for delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdRegistryProtectionRepositoryRulesProtectionRuleId/requestBody")
public record GitLabContainerRegistryRuleUpdatePayload(
        @Nullable String repositoryPathPattern,
        @Nullable GitLabContainerRegistryRuleUpdateMinimumAccessLevelForPush minimumAccessLevelForPush,
        @Nullable GitLabContainerRegistryRuleUpdateMinimumAccessLevelForDelete minimumAccessLevelForDelete) {}
