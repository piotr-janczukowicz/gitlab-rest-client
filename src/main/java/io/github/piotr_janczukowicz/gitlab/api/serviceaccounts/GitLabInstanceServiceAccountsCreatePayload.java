package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ServiceAccounts}.
 *
 * @param name the name
 * @param username the username
 * @param email the email
 * @param external the external
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ServiceAccounts/requestBody")
public record GitLabInstanceServiceAccountsCreatePayload(
        @Nullable String name,
        @Nullable String username,
        @Nullable String email,
        @Nullable Boolean external) {}
