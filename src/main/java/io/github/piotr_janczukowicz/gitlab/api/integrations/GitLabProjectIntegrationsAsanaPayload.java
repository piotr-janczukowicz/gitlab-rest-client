package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsAsana}.
 *
 * @param apiKey the api key
 * @param restrictToBranch the restrict to branch
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsAsana/requestBody")
public record GitLabProjectIntegrationsAsanaPayload(
        @Nullable String apiKey,
        @Nullable String restrictToBranch,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {}
