package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsDirectAccess}.
 *
 * @param workflowDefinition the workflow definition
 * @param rootNamespaceId the root namespace id
 * @param projectId the project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsDirectAccess/requestBody")
public record GitLabDuoAgentPlatformFlowsDirectAccessPayload(
        @Nullable String workflowDefinition,
        @Nullable String rootNamespaceId,
        @Nullable String projectId) {}
