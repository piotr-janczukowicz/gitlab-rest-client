package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group and project migration by direct transfer create entity of a GitLab resource.
 *
 * @param sourceType the source type
 * @param sourceFullPath the source full path
 * @param destinationNamespace the destination namespace
 * @param destinationSlug the destination slug
 * @param destinationName the destination name
 * @param migrateProjects the migrate projects
 * @param migrateMemberships the migrate memberships
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4BulkImports/requestBody/properties/entities/items")
public record GitLabGroupAndProjectMigrationByDirectTransferCreateEntity(
        GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType sourceType,
        @Nullable String sourceFullPath,
        @Nullable String destinationNamespace,
        @Nullable String destinationSlug,
        @Nullable String destinationName,
        @Nullable Boolean migrateProjects,
        @Nullable Boolean migrateMemberships) {
    public GitLabGroupAndProjectMigrationByDirectTransferCreateEntity {
        requireNonNull(sourceType, "sourceType");
    }
}
