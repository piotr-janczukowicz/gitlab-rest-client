package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdDeployTokens}.
 *
 * @param name the name
 * @param scopes the scopes
 * @param expiresAt the expires at
 * @param username the username
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdDeployTokens/requestBody")
public record GitLabProjectDeployTokensCreatePayload(
        @Nullable String name,
        List<GitLabProjectDeployTokensCreateScopes> scopes,
        @Nullable Instant expiresAt,
        @Nullable String username) {
    public GitLabProjectDeployTokensCreatePayload {
        requireNonNull(scopes, "scopes");
        scopes = List.copyOf(scopes);
    }
}
