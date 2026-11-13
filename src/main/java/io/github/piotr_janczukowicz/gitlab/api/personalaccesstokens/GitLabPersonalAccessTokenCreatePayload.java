package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UserPersonalAccessTokens}.
 *
 * @param name the name
 * @param description the description
 * @param expiresAt the expires at
 * @param granularScopes the granular scopes
 * @param scopes the scopes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UserPersonalAccessTokens/requestBody")
public record GitLabPersonalAccessTokenCreatePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable LocalDate expiresAt,
        @Nullable List<GitLabPersonalAccessTokenCreateGranularScope> granularScopes,
        @Nullable List<GitLabPersonalAccessTokenCreateScopes> scopes) {
    public GitLabPersonalAccessTokenCreatePayload {
        if (granularScopes != null) {
            granularScopes = List.copyOf(granularScopes);
        }
        if (scopes != null) {
            scopes = List.copyOf(scopes);
        }
    }
}
