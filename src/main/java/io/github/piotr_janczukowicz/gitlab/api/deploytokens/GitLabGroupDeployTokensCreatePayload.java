package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdDeployTokens}.
 *
 * @param name the name
 * @param scopes the scopes
 * @param expiresAt the expires at
 * @param username the username
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdDeployTokens/requestBody")
public record GitLabGroupDeployTokensCreatePayload(
        @Nullable String name,
        List<GitLabGroupDeployTokensCreateScopes> scopes,
        @Nullable Instant expiresAt,
        @Nullable String username) {
    public GitLabGroupDeployTokensCreatePayload {
        requireNonNull(scopes, "scopes");
        scopes = List.copyOf(scopes);
    }
}
