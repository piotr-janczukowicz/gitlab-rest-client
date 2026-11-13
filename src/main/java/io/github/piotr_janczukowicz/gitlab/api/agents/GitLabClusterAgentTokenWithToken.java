package io.github.piotr_janczukowicz.gitlab.api.agents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab cluster agent token with token.
 *
 * @param id the id
 * @param name the name
 * @param description the description
 * @param agentId the agent id
 * @param status the status
 * @param createdAt the created at
 * @param createdByUserId the created by user id
 * @param lastUsedAt the last used at
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesClustersAgentTokenWithToken")
public record GitLabClusterAgentTokenWithToken(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String description,
        @Nullable Long agentId,
        @Nullable String status,
        @Nullable Instant createdAt,
        @Nullable Long createdByUserId,
        @Nullable Instant lastUsedAt,
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabClusterAgentTokenWithToken[" + "id=" + id + ", name=" + name + ", description=" + description
                + ", agentId=" + agentId + ", status=" + status + ", createdAt=" + createdAt + ", createdByUserId="
                + createdByUserId + ", lastUsedAt=" + lastUsedAt + ", token=<redacted>" + "]";
    }
}
