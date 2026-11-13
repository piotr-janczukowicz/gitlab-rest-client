package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdAiAgentAuditEvents}.
 *
 * @param sessionId the session id
 * @param events the events
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdAiAgentAuditEvents/requestBody")
public record GitLabProjectProjectsCreateAiAgentAuditEventPayload(
        @Nullable Long sessionId, @Nullable List<GitLabProjectProjectsCreateAiAgentAuditEventEvent> events) {
    public GitLabProjectProjectsCreateAiAgentAuditEventPayload {
        if (events != null) {
            events = List.copyOf(events);
        }
    }
}
