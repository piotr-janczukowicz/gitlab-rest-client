package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdAccessTokens}.
 *
 * @param name the name
 * @param description the description
 * @param expiresAt the expires at
 * @param scopes the scopes
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdAccessTokens/requestBody")
public record GitLabProjectAccessTokensCreatePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable LocalDate expiresAt,
        List<GitLabProjectAccessTokensCreateScopes> scopes,
        @Nullable GitLabProjectAccessTokensCreateAccessLevel accessLevel) {
    public GitLabProjectAccessTokensCreatePayload {
        requireNonNull(scopes, "scopes");
        scopes = List.copyOf(scopes);
    }
}
