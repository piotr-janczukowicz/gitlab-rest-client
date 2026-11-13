package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner controller token with token.
 *
 * @param id the id
 * @param runnerControllerId the runner controller id
 * @param description the description
 * @param lastUsedAt the last used at
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerControllerTokenWithToken")
public record GitLabCiRunnerControllerTokenWithToken(
        @Nullable Long id,
        @Nullable Long runnerControllerId,
        @Nullable String description,
        @Nullable Instant lastUsedAt,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabCiRunnerControllerTokenWithToken[" + "id=" + id + ", runnerControllerId=" + runnerControllerId
                + ", description=" + description + ", lastUsedAt=" + lastUsedAt + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", token=<redacted>" + "]";
    }
}
