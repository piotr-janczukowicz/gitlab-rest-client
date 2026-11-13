package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminActiveContextConnectionsActivate}.
 *
 * @param connectionId the connection id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminActiveContextConnectionsActivate/requestBody")
public record GitLabActiveContextActivateConnectionPayload(
        @Nullable Long connectionId) {}
