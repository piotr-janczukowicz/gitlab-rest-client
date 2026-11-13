package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflowsWorkflowIdExecute}.
 *
 * @param projectId the project id
 * @param namespaceId the namespace id
 * @param rootNamespaceId the root namespace id
 * @param aiCatalogItemVersionId the ai catalog item version id
 * @param clientType the client type
 * @param userSelectedModelIdentifier the user selected model identifier
 * @param detached the detached
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsWorkflowIdExecute/requestBody")
public record GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload(
        @Nullable String projectId,
        @Nullable String namespaceId,
        @Nullable String rootNamespaceId,
        @Nullable Long aiCatalogItemVersionId,
        @Nullable String clientType,
        @Nullable String userSelectedModelIdentifier,
        @Nullable Boolean detached) {
    public GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload {
        requireMaxLengthIfPresent(projectId, 255, "projectId");
        requireMaxLengthIfPresent(namespaceId, 255, "namespaceId");
        requireMaxLengthIfPresent(rootNamespaceId, 255, "rootNamespaceId");
        requireMaxLengthIfPresent(clientType, 255, "clientType");
        requireMaxLengthIfPresent(userSelectedModelIdentifier, 255, "userSelectedModelIdentifier");
    }
}
