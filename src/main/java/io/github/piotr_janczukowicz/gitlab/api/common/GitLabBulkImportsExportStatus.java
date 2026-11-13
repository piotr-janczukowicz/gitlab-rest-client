package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab bulk imports export status.
 *
 * @param relation the relation
 * @param status the status
 * @param error the error
 * @param updatedAt the updated at
 * @param batched the batched
 * @param batchesCount the batches count
 * @param totalObjectsCount the total objects count
 * @param batches the batches
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBulkImportsExportStatus")
public record GitLabBulkImportsExportStatus(
        @Nullable String relation,
        @Nullable GitLabBulkImportsExportStatusStatus status,
        @Nullable String error,
        @Nullable Instant updatedAt,
        @Nullable Boolean batched,
        @Nullable Integer batchesCount,
        @Nullable Integer totalObjectsCount,
        @Nullable List<GitLabBulkImportsExportBatchStatus> batches) {}
