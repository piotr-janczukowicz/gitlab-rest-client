package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab batched background migration.
 *
 * @param id the id
 * @param jobClassName the job class name
 * @param tableName the table name
 * @param columnName the column name
 * @param status the status
 * @param progress the progress
 * @param createdAt the created at
 * @param estimatedTimeRemaining the estimated time remaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBatchedBackgroundMigration")
public record GitLabBatchedBackgroundMigration(
        @Nullable String id,
        @Nullable String jobClassName,
        @Nullable String tableName,
        @Nullable String columnName,
        @Nullable String status,
        @Nullable Double progress,
        @Nullable Instant createdAt,
        @Nullable String estimatedTimeRemaining) {}
