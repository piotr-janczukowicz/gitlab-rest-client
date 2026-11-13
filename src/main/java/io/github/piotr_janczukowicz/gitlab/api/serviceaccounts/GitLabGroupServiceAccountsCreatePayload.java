package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdServiceAccounts}.
 *
 * @param name the name
 * @param username the username
 * @param email the email
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdServiceAccounts/requestBody")
public record GitLabGroupServiceAccountsCreatePayload(
        @Nullable String name,
        @Nullable String username,
        @Nullable String email) {}
