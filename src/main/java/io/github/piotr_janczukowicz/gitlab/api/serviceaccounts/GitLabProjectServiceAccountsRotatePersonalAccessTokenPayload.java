package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdServiceAccountsUserIdPersonalAccessTokensTokenIdRotate}.
 *
 * @param expiresAt the expires at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdServiceAccountsUserIdPersonalAccessTokensTokenIdRotate/requestBody")
public record GitLabProjectServiceAccountsRotatePersonalAccessTokenPayload(
        @Nullable LocalDate expiresAt) {}
