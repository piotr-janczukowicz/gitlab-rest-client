package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab instance jobs request session of a GitLab resource.
 *
 * @param url the url
 * @param certificate the certificate
 * @param authorization the authorization
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4JobsRequest/requestBody/properties/session")
public record GitLabInstanceJobsRequestSession(
        @Nullable String url,
        @Nullable String certificate,
        @Nullable String authorization) {}
