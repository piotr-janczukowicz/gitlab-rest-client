package io.github.piotr_janczukowicz.gitlab.api.useremailaddresses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UserEmails}.
 *
 * @param email the email
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UserEmails/requestBody")
public record GitLabUserEmailAddressesCreatePayload(
        @Nullable String email) {}
