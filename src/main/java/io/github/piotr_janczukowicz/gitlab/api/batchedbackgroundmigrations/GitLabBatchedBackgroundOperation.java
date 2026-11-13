package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab batched background operation.
 *
 * @param id the id
 * @param partition the partition
 * @param jobClassName the job class name
 * @param tableName the table name
 * @param columnName the column name
 * @param status the status
 * @param createdAt the created at
 * @param startedAt the started at
 * @param finishedAt the finished at
 * @param onHoldUntil the on hold until
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBatchedBackgroundOperation")
public record GitLabBatchedBackgroundOperation(
        @Nullable String id,
        @Nullable Integer partition,
        @Nullable String jobClassName,
        @Nullable String tableName,
        @Nullable String columnName,
        @Nullable String status,
        @Nullable Instant createdAt,
        @Nullable Instant startedAt,
        @Nullable Instant finishedAt,
        @Nullable Instant onHoldUntil) {}
