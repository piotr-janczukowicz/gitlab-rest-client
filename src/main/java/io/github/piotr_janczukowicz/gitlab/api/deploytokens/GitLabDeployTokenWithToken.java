package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deploy token with token.
 *
 * @param id the id
 * @param name the name
 * @param username the username
 * @param expiresAt the expires at
 * @param scopes the scopes
 * @param revoked the revoked
 * @param expired the expired
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeployTokenWithToken")
public record GitLabDeployTokenWithToken(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String username,
        @Nullable Instant expiresAt,
        @Nullable List<String> scopes,
        @Nullable Boolean revoked,
        @Nullable Boolean expired,
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabDeployTokenWithToken[" + "id=" + id + ", name=" + name + ", username=" + username + ", expiresAt="
                + expiresAt + ", scopes=" + scopes + ", revoked=" + revoked + ", expired=" + expired
                + ", token=<redacted>" + "]";
    }
}
