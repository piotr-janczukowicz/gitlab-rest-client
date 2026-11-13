package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflowsIdEvents}.
 *
 * @param eventType the event type
 * @param message the message
 * @param correlationId the correlation id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdEvents/requestBody")
public record GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload(
        GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType eventType,
        @Nullable String message,
        @Nullable String correlationId) {
    public GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload {
        requireNonNull(eventType, "eventType");
    }
}
