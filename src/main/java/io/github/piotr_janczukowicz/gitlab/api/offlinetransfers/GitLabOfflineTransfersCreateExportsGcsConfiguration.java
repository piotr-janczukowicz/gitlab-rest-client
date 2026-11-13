package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create exports gcs configuration of a GitLab resource.
 *
 * @param googleProject the google project
 * @param googleJsonKeyString the google json key string
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineExports/requestBody/properties/gcs_configuration")
public record GitLabOfflineTransfersCreateExportsGcsConfiguration(
        @Nullable String googleProject, @Nullable String googleJsonKeyString) {}
