package io.github.piotr_janczukowicz.gitlab.api.userapplications;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4UserApplicationsId}.
 *
 * @param name the name
 * @param scopes the scopes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4UserApplicationsId/requestBody")
public record GitLabUserApplicationsUpdatePayload(
        @Nullable String name, @Nullable String scopes) {}
