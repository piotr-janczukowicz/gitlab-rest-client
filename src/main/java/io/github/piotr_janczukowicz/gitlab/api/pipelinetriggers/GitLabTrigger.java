package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab trigger.
 *
 * @param id the id
 * @param token the token
 * @param description the description
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param lastUsed the last used
 * @param expiresAt the expires at
 * @param owner the owner
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTrigger")
public record GitLabTrigger(
        @Nullable Long id,
        @Nullable String token,
        @Nullable String description,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Instant lastUsed,
        @Nullable Instant expiresAt,
        @Nullable GitLabUserBasic owner) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabTrigger[" + "id=" + id + ", token=<redacted>" + ", description=" + description + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", lastUsed=" + lastUsed + ", expiresAt=" + expiresAt
                + ", owner=" + owner + "]";
    }
}
