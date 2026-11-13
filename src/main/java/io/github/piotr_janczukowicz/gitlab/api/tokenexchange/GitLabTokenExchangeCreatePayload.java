package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4TokenExchange}.
 *
 * @param audience the audience
 * @param expiresIn the expires in
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4TokenExchange/requestBody")
public record GitLabTokenExchangeCreatePayload(
        GitLabTokenExchangeCreateAudience audience,
        @Nullable Integer expiresIn) {
    public GitLabTokenExchangeCreatePayload {
        requireNonNull(audience, "audience");
        requireBetweenIfPresent(expiresIn, 1, 43_200, "expiresIn");
    }
}
