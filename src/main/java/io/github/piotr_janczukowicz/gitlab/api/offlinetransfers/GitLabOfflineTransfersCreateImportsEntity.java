package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create imports entity of a GitLab resource.
 *
 * @param sourceType the source type
 * @param sourceFullPath the source full path
 * @param destinationNamespace the destination namespace
 * @param destinationSlug the destination slug
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineImports/requestBody/properties/entities/items")
public record GitLabOfflineTransfersCreateImportsEntity(
        GitLabOfflineTransfersCreateImportsEntitySourceType sourceType,
        @Nullable String sourceFullPath,
        @Nullable String destinationNamespace,
        @Nullable String destinationSlug) {
    public GitLabOfflineTransfersCreateImportsEntity {
        requireNonNull(sourceType, "sourceType");
    }
}
