package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminActiveContextConnectionsDeactivate}.
 *
 * @param connectionId the connection id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminActiveContextConnectionsDeactivate/requestBody")
public record GitLabActiveContextDeactivateConnectionPayload(
        @Nullable Long connectionId) {}
