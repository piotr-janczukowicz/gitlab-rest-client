package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4UserStatus}.
 *
 * @param emoji the emoji
 * @param message the message
 * @param availability the availability
 * @param clearStatusAfter the clear status after
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4UserStatus/requestBody")
public record GitLabUsersPatchStatusPayload(
        @Nullable String emoji,
        @Nullable String message,
        @Nullable String availability,
        @Nullable GitLabUsersPatchStatusClearStatusAfter clearStatusAfter) {}
