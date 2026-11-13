package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab bulk import.
 *
 * @param id the id
 * @param status the status
 * @param sourceType the source type
 * @param sourceUrl the source url
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param hasFailures the has failures
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBulkImport")
public record GitLabBulkImport(
        @Nullable Long id,
        @Nullable GitLabBulkImportStatus status,
        @Nullable String sourceType,
        @Nullable String sourceUrl,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Boolean hasFailures) {}
