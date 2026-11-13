package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project project webhooks create url variable of a GitLab resource.
 *
 * @param key the key
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdHooks/requestBody/properties/url_variables/items")
public record GitLabProjectProjectWebhooksCreateUrlVariable(
        @Nullable String key, @Nullable String value) {}
