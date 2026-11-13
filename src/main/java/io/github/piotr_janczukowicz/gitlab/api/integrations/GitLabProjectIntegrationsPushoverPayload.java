package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsPushover}.
 *
 * @param apiKey the api key
 * @param userKey the user key
 * @param device the device
 * @param priority the priority
 * @param sound the sound
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsPushover/requestBody")
public record GitLabProjectIntegrationsPushoverPayload(
        @Nullable String apiKey,
        @Nullable String userKey,
        @Nullable String device,
        @Nullable String priority,
        @Nullable String sound,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {}
