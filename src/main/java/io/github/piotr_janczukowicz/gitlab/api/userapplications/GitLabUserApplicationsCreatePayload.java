package io.github.piotr_janczukowicz.gitlab.api.userapplications;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UserApplications}.
 *
 * @param name the name
 * @param redirectUri the redirect uri
 * @param scopes the scopes
 * @param confidential the confidential
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UserApplications/requestBody")
public record GitLabUserApplicationsCreatePayload(
        @Nullable String name,
        @Nullable String redirectUri,
        @Nullable String scopes,
        @Nullable Boolean confidential) {}
