package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsConfluence}.
 *
 * @param confluenceUrl the confluence url
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsConfluence/requestBody")
public record GitLabGroupGroupIntegrationsConfluencePayload(
        @Nullable String confluenceUrl, @Nullable Boolean useInheritedSettings) {}
