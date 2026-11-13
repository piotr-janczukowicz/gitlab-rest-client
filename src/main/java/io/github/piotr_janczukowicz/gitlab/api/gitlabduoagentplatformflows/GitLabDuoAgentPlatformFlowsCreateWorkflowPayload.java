package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflows}.
 *
 * @param projectId the project id
 * @param namespaceId the namespace id
 * @param aiCatalogItemConsumerId the ai catalog item consumer id
 * @param startWorkflow the start workflow
 * @param goal the goal
 * @param agentPrivileges the agent privileges
 * @param preApprovedAgentPrivileges the pre approved agent privileges
 * @param workflowDefinition the workflow definition
 * @param allowAgentToRequestUser the allow agent to request user
 * @param image the image
 * @param sourceBranch the source branch
 * @param environment the environment
 * @param aiCatalogItemVersionId the ai catalog item version id
 * @param additionalContext the additional context
 * @param issueId the issue id
 * @param mergeRequestId the merge request id
 * @param source the source
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflows/requestBody")
public record GitLabDuoAgentPlatformFlowsCreateWorkflowPayload(
        @Nullable String projectId,
        @Nullable String namespaceId,
        @Nullable Long aiCatalogItemConsumerId,
        @Nullable Boolean startWorkflow,
        @Nullable String goal,
        @Nullable List<Integer> agentPrivileges,
        @Nullable List<Integer> preApprovedAgentPrivileges,
        @Nullable String workflowDefinition,
        @Nullable Boolean allowAgentToRequestUser,
        @Nullable String image,
        @Nullable String sourceBranch,
        @Nullable GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment environment,
        @Nullable Long aiCatalogItemVersionId,
        @Nullable List<GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext> additionalContext,
        @Nullable Long issueId,
        @Nullable Long mergeRequestId,
        @Nullable GitLabDuoAgentPlatformFlowsCreateWorkflowSource source) {
    public GitLabDuoAgentPlatformFlowsCreateWorkflowPayload {
        if (agentPrivileges != null) {
            agentPrivileges = List.copyOf(agentPrivileges);
        }
        if (preApprovedAgentPrivileges != null) {
            preApprovedAgentPrivileges = List.copyOf(preApprovedAgentPrivileges);
        }
        if (additionalContext != null) {
            additionalContext = List.copyOf(additionalContext);
        }
    }
}
