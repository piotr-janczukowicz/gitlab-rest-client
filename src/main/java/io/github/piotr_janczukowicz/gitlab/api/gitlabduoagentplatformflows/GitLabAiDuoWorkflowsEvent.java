package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai duo workflows event.
 *
 * @param id the id
 * @param correlationId the correlation id
 * @param eventType the event type
 * @param eventStatus the event status
 * @param message the message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiDuoWorkflowsEvent")
public record GitLabAiDuoWorkflowsEvent(
        @Nullable Long id,
        @Nullable String correlationId,
        @Nullable String eventType,
        @Nullable String eventStatus,
        @Nullable String message) {}
