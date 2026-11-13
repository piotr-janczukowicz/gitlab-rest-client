package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsAgentWorkflows}.
 *
 * @param projectId the project id
 * @param namespaceId the namespace id
 * @param aiCatalogItemConsumerId the ai catalog item consumer id
 * @param startWorkflow the start workflow
 * @param goal the goal
 * @param workflowDefinition the workflow definition
 * @param allowAgentToRequestUser the allow agent to request user
 * @param image the image
 * @param sourceBranch the source branch
 * @param environment the environment
 * @param aiCatalogItemVersionId the ai catalog item version id
 * @param additionalContext the additional context
 * @param issueId the issue id
 * @param mergeRequestId the merge request id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsAgentWorkflows/requestBody")
public record GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload(
        @Nullable String projectId,
        @Nullable String namespaceId,
        @Nullable Long aiCatalogItemConsumerId,
        @Nullable Boolean startWorkflow,
        @Nullable String goal,
        @Nullable String workflowDefinition,
        @Nullable Boolean allowAgentToRequestUser,
        @Nullable String image,
        @Nullable String sourceBranch,
        @Nullable GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment environment,
        @Nullable Long aiCatalogItemVersionId,
        @Nullable List<GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext> additionalContext,
        @Nullable Long issueId,
        @Nullable Long mergeRequestId) {
    public GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload {
        if (additionalContext != null) {
            additionalContext = List.copyOf(additionalContext);
        }
    }
}
