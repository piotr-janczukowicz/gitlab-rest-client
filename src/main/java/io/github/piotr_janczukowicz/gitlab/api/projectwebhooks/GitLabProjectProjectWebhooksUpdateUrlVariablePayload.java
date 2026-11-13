package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdHooksHookIdUrlVariablesKey}.
 *
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdHooksHookIdUrlVariablesKey/requestBody")
public record GitLabProjectProjectWebhooksUpdateUrlVariablePayload(
        @Nullable String value) {}
