package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesMockCi}.
 *
 * @param enableSslVerification the enable ssl verification
 * @param mockServiceUrl the mock service url
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesMockCi/requestBody")
public record GitLabProjectIntegrationsMockCiServicePayload(
        @Nullable Boolean enableSslVerification,
        @Nullable String mockServiceUrl,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {}
