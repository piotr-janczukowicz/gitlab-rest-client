package io.github.piotr_janczukowicz.gitlab.api.unleash;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4FeatureFlagsUnleashProjectIdClientRegister}.
 *
 * @param instanceId the instance id
 * @param appName the app name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4FeatureFlagsUnleashProjectIdClientRegister/requestBody")
public record GitLabUnleashRegisterClientPayload(
        @Nullable String instanceId, @Nullable String appName) {}
