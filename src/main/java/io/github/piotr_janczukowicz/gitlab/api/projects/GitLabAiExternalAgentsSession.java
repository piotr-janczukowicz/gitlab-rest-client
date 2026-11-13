package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai external agents session.
 *
 * @param id the id
 * @param agentType the agent type
 * @param userId the user id
 * @param status the status
 * @param flowType the flow type
 * @param glabVersion the glab version
 * @param agentVersion the agent version
 * @param syncType the sync type
 * @param externalXid the external xid
 * @param sessionStartedAt the session started at
 * @param sessionFinishedAt the session finished at
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiExternalAgentsSession")
public record GitLabAiExternalAgentsSession(
        @Nullable Long id,
        @Nullable String agentType,
        @Nullable Long userId,
        @Nullable String status,
        @Nullable String flowType,
        @Nullable String glabVersion,
        @Nullable String agentVersion,
        @Nullable String syncType,
        @Nullable String externalXid,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (session_started_at)")
        Instant sessionStartedAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (session_finished_at)")
        Instant sessionFinishedAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (updated_at)")
        Instant updatedAt) {}
