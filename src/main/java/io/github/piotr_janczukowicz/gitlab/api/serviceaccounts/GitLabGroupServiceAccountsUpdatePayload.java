package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4GroupsIdServiceAccountsUserId}.
 *
 * @param name the name
 * @param username the username
 * @param email the email
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4GroupsIdServiceAccountsUserId/requestBody")
public record GitLabGroupServiceAccountsUpdatePayload(
        @Nullable String name,
        @Nullable String username,
        @Nullable String email) {}
