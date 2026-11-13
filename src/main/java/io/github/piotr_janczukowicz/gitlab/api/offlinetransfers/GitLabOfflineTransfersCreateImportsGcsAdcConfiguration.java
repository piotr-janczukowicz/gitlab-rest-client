package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create imports gcs adc configuration of a GitLab resource.
 *
 * @param googleProject the google project
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineImports/requestBody/properties/gcs_adc_configuration")
public record GitLabOfflineTransfersCreateImportsGcsAdcConfiguration(
        @Nullable String googleProject) {}
