package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab bulk imports export batch status.
 *
 * @param status the status
 * @param batchNumber the batch number
 * @param objectsCount the objects count
 * @param error the error
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBulkImportsExportBatchStatus")
public record GitLabBulkImportsExportBatchStatus(
        @Nullable GitLabBulkImportsExportBatchStatusStatus status,
        @Nullable Integer batchNumber,
        @Nullable Integer objectsCount,
        @Nullable String error,
        @Nullable Instant updatedAt) {}
