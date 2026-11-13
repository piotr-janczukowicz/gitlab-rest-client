package io.github.piotr_janczukowicz.gitlab.api.usertokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UsersUserIdPersonalAccessTokens}.
 *
 * @param name the name
 * @param description the description
 * @param expiresAt the expires at
 * @param scopes the scopes
 * @param granularScopes the granular scopes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UsersUserIdPersonalAccessTokens/requestBody")
public record GitLabUserTokensCreatePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable LocalDate expiresAt,
        @Nullable List<GitLabUserTokensCreateScopes> scopes,
        @Nullable List<GitLabUserTokensCreateGranularScope> granularScopes) {
    public GitLabUserTokensCreatePayload {
        if (scopes != null) {
            scopes = List.copyOf(scopes);
        }
        if (granularScopes != null) {
            granularScopes = List.copyOf(granularScopes);
        }
    }
}
