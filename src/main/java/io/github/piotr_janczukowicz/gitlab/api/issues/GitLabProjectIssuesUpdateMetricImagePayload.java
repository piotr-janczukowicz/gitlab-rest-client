package io.github.piotr_janczukowicz.gitlab.api.issues;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIssuesIssueIidMetricImagesMetricImageId}.
 *
 * @param url the url
 * @param urlText the url text
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIssuesIssueIidMetricImagesMetricImageId/requestBody")
public record GitLabProjectIssuesUpdateMetricImagePayload(
        @Nullable String url, @Nullable String urlText) {}
