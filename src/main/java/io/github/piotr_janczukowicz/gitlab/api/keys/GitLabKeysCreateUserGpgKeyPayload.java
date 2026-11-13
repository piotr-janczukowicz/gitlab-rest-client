package io.github.piotr_janczukowicz.gitlab.api.keys;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UserGpgKeys}.
 *
 * @param key the key
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UserGpgKeys/requestBody")
public record GitLabKeysCreateUserGpgKeyPayload(@Nullable String key) {}
