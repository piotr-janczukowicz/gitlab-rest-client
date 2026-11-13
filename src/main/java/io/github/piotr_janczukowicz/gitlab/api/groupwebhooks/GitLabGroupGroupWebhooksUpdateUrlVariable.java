package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group group webhooks update url variable of a GitLab resource.
 *
 * @param key the key
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdHooksHookId/requestBody/properties/url_variables/items")
public record GitLabGroupGroupWebhooksUpdateUrlVariable(
        @Nullable String key, @Nullable String value) {}
