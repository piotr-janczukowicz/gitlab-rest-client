package io.github.piotr_janczukowicz.gitlab.api.keys;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UsersUserIdKeys}.
 *
 * @param key the key
 * @param title the title
 * @param expiresAt the expires at
 * @param usageType the usage type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UsersUserIdKeys/requestBody")
public record GitLabKeysCreateUsersKeyPayload(
        @Nullable String key,
        @Nullable String title,
        @Nullable Instant expiresAt,
        @Nullable GitLabKeysCreateUsersKeyUsageType usageType) {}
