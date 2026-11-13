package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4DeployKeys}.
 *
 * @param key the key
 * @param title the title
 * @param expiresAt the expires at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4DeployKeys/requestBody")
public record GitLabInstanceDeployKeysCreatePayload(
        @Nullable String key,
        @Nullable String title,
        @Nullable Instant expiresAt) {}
