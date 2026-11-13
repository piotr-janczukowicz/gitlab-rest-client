package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai settings.
 *
 * @param duoAgentPlatformEnabled the duo agent platform enabled
 * @param duoWorkflowMcpEnabled the duo workflow mcp enabled
 * @param foundationalAgentsDefaultEnabled the foundational agents default enabled
 * @param aiCatalogRestrictedToGroupHierarchy the ai catalog restricted to group hierarchy
 * @param aiUsageDataCollectionEnabled the ai usage data collection enabled
 * @param promptInjectionProtectionLevel the prompt injection protection level
 * @param webSearchEnabled the web search enabled
 * @param includeRecommendedAllowed the include recommended allowed
 * @param allowAllUnixSockets the allow all unix sockets
 * @param allowProjectExtension the allow project extension
 * @param requireSandbox the require sandbox
 * @param minimumAccessLevelExecute the minimum access level execute
 * @param minimumAccessLevelExecuteAsync the minimum access level execute async
 * @param minimumAccessLevelManage the minimum access level manage
 * @param minimumAccessLevelEnableOnProjects the minimum access level enable on projects
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiSettings")
public record GitLabAiSettings(
        @Nullable Boolean duoAgentPlatformEnabled,
        @Nullable Boolean duoWorkflowMcpEnabled,
        @Nullable Boolean foundationalAgentsDefaultEnabled,
        @Nullable Boolean aiCatalogRestrictedToGroupHierarchy,
        @Nullable Boolean aiUsageDataCollectionEnabled,
        @Nullable String promptInjectionProtectionLevel,
        @Nullable Boolean webSearchEnabled,
        @Nullable Boolean includeRecommendedAllowed,
        @Nullable Boolean allowAllUnixSockets,
        @Nullable Boolean allowProjectExtension,
        @Nullable Boolean requireSandbox,
        @Nullable String minimumAccessLevelExecute,
        @Nullable String minimumAccessLevelExecuteAsync,
        @Nullable String minimumAccessLevelManage,
        @Nullable String minimumAccessLevelEnableOnProjects) {}
