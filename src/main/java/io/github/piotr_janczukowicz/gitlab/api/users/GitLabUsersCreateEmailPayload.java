package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UsersIdEmails}.
 *
 * @param email the email
 * @param skipConfirmation the skip confirmation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UsersIdEmails/requestBody")
public record GitLabUsersCreateEmailPayload(
        @Nullable String email, @Nullable Boolean skipConfirmation) {}
