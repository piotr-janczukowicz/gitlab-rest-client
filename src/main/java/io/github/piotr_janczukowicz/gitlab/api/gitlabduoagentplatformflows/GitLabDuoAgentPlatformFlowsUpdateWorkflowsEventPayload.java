package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code putApiV4AiDuoWorkflowsWorkflowsIdEventsEventId}.
 *
 * @param eventStatus the event status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AiDuoWorkflowsWorkflowsIdEventsEventId/requestBody")
public record GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload(
        GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus eventStatus) {
    public GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload {
        requireNonNull(eventStatus, "eventStatus");
    }
}
