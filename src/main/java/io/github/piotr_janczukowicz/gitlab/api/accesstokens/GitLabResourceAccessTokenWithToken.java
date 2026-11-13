package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGranularScope;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab resource access token with token.
 *
 * @param id the id
 * @param name the name
 * @param revoked the revoked
 * @param createdAt the created at
 * @param description the description
 * @param scopes the scopes
 * @param userId the user id
 * @param lastUsedAt the last used at
 * @param lastUsedIps the last used ips
 * @param granularScopes the granular scopes
 * @param active the active
 * @param granular the granular
 * @param expiresAt the expires at
 * @param accessLevel the access level
 * @param resourceType the resource type
 * @param resourceId the resource id
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesResourceAccessTokenWithToken")
public record GitLabResourceAccessTokenWithToken(
        @Nullable Long id,
        @Nullable String name,
        @Nullable Boolean revoked,
        @Nullable Instant createdAt,
        @Nullable String description,
        @Nullable List<String> scopes,
        @Nullable Long userId,
        @Nullable Instant lastUsedAt,
        @Nullable List<String> lastUsedIps,
        @Nullable List<GitLabGranularScope> granularScopes,
        @Nullable Boolean active,
        @Nullable Boolean granular,
        @Nullable Instant expiresAt,
        @Nullable GitLabResourceAccessTokenWithTokenAccessLevel accessLevel,
        @Nullable GitLabResourceAccessTokenWithTokenResourceType resourceType,
        @Nullable Long resourceId,
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabResourceAccessTokenWithToken[" + "id=" + id + ", name=" + name + ", revoked=" + revoked
                + ", createdAt=" + createdAt + ", description=" + description + ", scopes=" + scopes + ", userId="
                + userId + ", lastUsedAt=" + lastUsedAt + ", lastUsedIps=" + lastUsedIps + ", granularScopes="
                + granularScopes + ", active=" + active + ", granular=" + granular + ", expiresAt=" + expiresAt
                + ", accessLevel=" + accessLevel + ", resourceType=" + resourceType + ", resourceId=" + resourceId
                + ", token=<redacted>" + "]";
    }
}
