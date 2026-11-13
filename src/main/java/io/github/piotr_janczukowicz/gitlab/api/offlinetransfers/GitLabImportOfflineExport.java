package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab import offline export.
 *
 * @param id the id
 * @param status the status
 * @param sourceHostname the source hostname
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param hasFailures the has failures
 * @param bucket the bucket
 * @param exportPrefix the export prefix
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesImportOfflineExport")
public record GitLabImportOfflineExport(
        @Nullable Long id,
        @Nullable GitLabImportOfflineExportStatus status,
        @Nullable String sourceHostname,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Boolean hasFailures,
        @Nullable String bucket,
        @Nullable String exportPrefix) {}
