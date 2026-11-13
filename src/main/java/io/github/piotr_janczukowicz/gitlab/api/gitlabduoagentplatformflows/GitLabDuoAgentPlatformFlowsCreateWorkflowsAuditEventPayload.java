package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflowsIdAuditEvents}.
 *
 * @param events the events
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdAuditEvents/requestBody")
public record GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload(
        @Nullable List<GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent> events) {
    public GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload {
        if (events != null) {
            events = List.copyOf(events);
        }
    }
}
