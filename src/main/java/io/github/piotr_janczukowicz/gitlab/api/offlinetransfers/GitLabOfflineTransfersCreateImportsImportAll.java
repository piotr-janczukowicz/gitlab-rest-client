package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create imports import all of a GitLab resource.
 *
 * @param destinationNamespace the destination namespace
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineImports/requestBody/properties/import_all")
public record GitLabOfflineTransfersCreateImportsImportAll(
        @Nullable String destinationNamespace) {}
