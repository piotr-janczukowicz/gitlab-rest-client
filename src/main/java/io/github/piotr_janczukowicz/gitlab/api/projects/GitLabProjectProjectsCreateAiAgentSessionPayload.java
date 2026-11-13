package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdAiAgentSessions}.
 *
 * @param agentType the agent type
 * @param agentIdentityId the agent identity id
 * @param syncType the sync type
 * @param goal the goal
 * @param startedAt the started at
 * @param idempotencyKey the idempotency key
 * @param workflowDefinition the workflow definition
 * @param glabVersion the glab version
 * @param agentVersion the agent version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdAiAgentSessions/requestBody")
public record GitLabProjectProjectsCreateAiAgentSessionPayload(
        GitLabProjectProjectsCreateAiAgentSessionAgentType agentType,
        @Nullable Long agentIdentityId,
        GitLabProjectProjectsCreateAiAgentSessionSyncType syncType,
        @Nullable String goal,
        @Nullable Instant startedAt,
        @Nullable String idempotencyKey,
        @Nullable String workflowDefinition,
        @Nullable String glabVersion,
        @Nullable String agentVersion) {
    public GitLabProjectProjectsCreateAiAgentSessionPayload {
        requireNonNull(agentType, "agentType");
        requireNonNull(syncType, "syncType");
        requireMaxLengthIfPresent(idempotencyKey, 255, "idempotencyKey");
        requireMaxLengthIfPresent(glabVersion, 255, "glabVersion");
        requireMaxLengthIfPresent(agentVersion, 255, "agentVersion");
    }
}
