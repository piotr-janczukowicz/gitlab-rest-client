package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsAsana}.
 *
 * @param apiKey the api key
 * @param restrictToBranch the restrict to branch
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsAsana/requestBody")
public record GitLabGroupGroupIntegrationsAsanaPayload(
        @Nullable String apiKey,
        @Nullable String restrictToBranch,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {}
