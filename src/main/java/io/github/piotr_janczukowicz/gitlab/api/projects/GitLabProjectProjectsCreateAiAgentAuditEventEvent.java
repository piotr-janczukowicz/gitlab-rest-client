package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project projects create ai agent audit event event of a GitLab resource.
 *
 * @param eventName the event name
 * @param cloudEventId the cloud event id
 * @param occurredAt the occurred at
 * @param details the details
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdAiAgentAuditEvents/requestBody/properties/events/items")
public record GitLabProjectProjectsCreateAiAgentAuditEventEvent(
        @Nullable String eventName,
        @Nullable String cloudEventId,
        @Nullable Instant occurredAt,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> details) {
    public GitLabProjectProjectsCreateAiAgentAuditEventEvent {
        if (details != null) {
            details = Map.copyOf(details);
        }
    }
}
