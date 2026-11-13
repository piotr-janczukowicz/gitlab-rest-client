package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRegistryProtectionRepositoryRules}.
 *
 * @param repositoryPathPattern the repository path pattern
 * @param minimumAccessLevelForPush the minimum access level for push
 * @param minimumAccessLevelForDelete the minimum access level for delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRegistryProtectionRepositoryRules/requestBody")
public record GitLabContainerRegistryRuleCreatePayload(
        @Nullable String repositoryPathPattern,
        @Nullable GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush minimumAccessLevelForPush,
        @Nullable GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete minimumAccessLevelForDelete) {}
