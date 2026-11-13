package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project import status.
 *
 * @param id the id
 * @param description the description
 * @param name the name
 * @param nameWithNamespace the name with namespace
 * @param path the path
 * @param pathWithNamespace the path with namespace
 * @param createdAt the created at
 * @param importStatus the import status
 * @param importType the import type
 * @param correlationId the correlation id
 * @param failedRelations the failed relations
 * @param importError the import error
 * @param stats the stats
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectImportStatus")
public record GitLabProjectImportStatus(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String name,
        @Nullable String nameWithNamespace,
        @Nullable String path,
        @Nullable String pathWithNamespace,
        @Nullable Instant createdAt,
        @Nullable String importStatus,
        @Nullable String importType,
        @Nullable String correlationId,
        @Nullable List<GitLabProjectImportFailedRelation> failedRelations,
        @Nullable String importError,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> stats) {}
