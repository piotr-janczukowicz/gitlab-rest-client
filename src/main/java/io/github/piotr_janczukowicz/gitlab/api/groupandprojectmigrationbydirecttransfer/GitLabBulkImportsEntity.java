package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

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
 * A GitLab bulk imports entity.
 *
 * @param id the id
 * @param bulkImportId the bulk import id
 * @param status the status
 * @param entityType the entity type
 * @param sourceFullPath the source full path
 * @param destinationFullPath the destination full path
 * @param destinationName the destination name
 * @param destinationSlug the destination slug
 * @param destinationNamespace the destination namespace
 * @param parentId the parent id
 * @param namespaceId the namespace id
 * @param projectId the project id
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param failures the failures
 * @param migrateProjects the migrate projects
 * @param migrateMemberships the migrate memberships
 * @param hasFailures the has failures
 * @param stats the stats
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBulkImportsEntity")
public record GitLabBulkImportsEntity(
        @Nullable Long id,
        @Nullable Long bulkImportId,
        @Nullable GitLabBulkImportsEntityStatus status,
        @Nullable GitLabBulkImportsEntityType entityType,
        @Nullable String sourceFullPath,
        @Nullable String destinationFullPath,
        @Nullable String destinationName,
        @Nullable String destinationSlug,
        @Nullable String destinationNamespace,
        @Nullable Long parentId,
        @Nullable Long namespaceId,
        @Nullable Long projectId,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable List<GitLabBulkImportsEntityFailure> failures,
        @Nullable Boolean migrateProjects,
        @Nullable Boolean migrateMemberships,
        @Nullable Boolean hasFailures,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> stats) {}
