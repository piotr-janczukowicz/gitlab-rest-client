package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create exports entity of a GitLab resource.
 *
 * @param fullPath the full path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineExports/requestBody/properties/entities/items")
public record GitLabOfflineTransfersCreateExportsEntity(
        @Nullable String fullPath) {}
