package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab authn token exchange.
 *
 * @param accessToken the access token
 * @param issuedTokenType the issued token type
 * @param tokenType the token type
 * @param expiresIn the expires in
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAuthnTokenExchange")
public record GitLabAuthnTokenExchange(
        @Nullable String accessToken,
        @Nullable String issuedTokenType,
        @Nullable String tokenType,
        @Nullable Integer expiresIn,
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code accessToken}, {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabAuthnTokenExchange[" + "accessToken=<redacted>" + ", issuedTokenType=" + issuedTokenType
                + ", tokenType=" + tokenType + ", expiresIn=" + expiresIn + ", token=<redacted>" + "]";
    }
}
