package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai duo workflows workflow.
 *
 * @param id the id
 * @param webUrl the web url
 * @param projectId the project id
 * @param namespaceId the namespace id
 * @param agentPrivileges the agent privileges
 * @param agentPrivilegesNames the agent privileges names
 * @param preApprovedAgentPrivileges the pre approved agent privileges
 * @param preApprovedAgentPrivilegesNames the pre approved agent privileges names
 * @param workflowDefinition the workflow definition
 * @param status the status
 * @param summary the summary
 * @param title the title
 * @param allowAgentToRequestUser the allow agent to request user
 * @param image the image
 * @param environment the environment
 * @param aiCatalogItemVersionId the ai catalog item version id
 * @param workload the workload
 * @param mcpEnabled the mcp enabled
 * @param incrementalCheckpointsEnabled the incremental checkpoints enabled
 * @param gitlabUrl the gitlab url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiDuoWorkflowsWorkflow")
public record GitLabAiDuoWorkflowsWorkflow(
        @Nullable Long id,
        @Nullable String webUrl,
        @Nullable Long projectId,
        @Nullable Long namespaceId,
        @Nullable List<Integer> agentPrivileges,
        @Nullable List<String> agentPrivilegesNames,
        @Nullable List<Integer> preApprovedAgentPrivileges,
        @Nullable List<String> preApprovedAgentPrivilegesNames,
        @Nullable String workflowDefinition,
        @Nullable String status,
        @Nullable String summary,
        @Nullable String title,
        @Nullable Boolean allowAgentToRequestUser,
        @Nullable String image,
        @Nullable String environment,
        @Nullable Long aiCatalogItemVersionId,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> workload,

        @Nullable Boolean mcpEnabled,
        @Nullable Boolean incrementalCheckpointsEnabled,
        @Nullable String gitlabUrl) {}
