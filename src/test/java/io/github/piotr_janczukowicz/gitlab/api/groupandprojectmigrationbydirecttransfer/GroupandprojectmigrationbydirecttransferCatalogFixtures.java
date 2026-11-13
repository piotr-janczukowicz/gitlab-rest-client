package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class GroupandprojectmigrationbydirecttransferCatalogFixtures {

    private GroupandprojectmigrationbydirecttransferCatalogFixtures() {}

    public static GitLabBulkImportsEntity bulkImportsEntity() {
        return GitLabBulkImportsEntityBuilder.builder()
                .id(1L)
                .bulkImportId(1L)
                .status(GitLabBulkImportsEntityStatus.CREATED)
                .entityType(GitLabBulkImportsEntityType.GROUP)
                .sourceFullPath("source_group")
                .destinationFullPath("some_group/source_project")
                .destinationName("destination_slug")
                .destinationSlug("destination_slug")
                .destinationNamespace("destination_path")
                .parentId(1L)
                .namespaceId(1L)
                .projectId(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .failures(List.of(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure()))
                .migrateProjects(true)
                .migrateMemberships(true)
                .hasFailures(true)
                .stats(Map.of("key", "value"))
                .build();
    }

    public static GitLabBulkImportsEntityFailure bulkImportsEntityFailure() {
        return GitLabBulkImportsEntityFailureBuilder.builder()
                .relation("label")
                .exceptionMessage("error message")
                .exceptionClass("Exception")
                .correlationIdValue("dfcf583058ed4508e4c7c617bd7f0edd")
                .sourceUrl("https://source.gitlab.com/group/-/epics/1")
                .sourceTitle("title")
                .build();
    }

    public static GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration
            groupAndProjectMigrationByDirectTransferCreateConfiguration() {
        return GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationBuilder.builder()
                .url("url")
                .accessToken("access_token")
                .build();
    }

    public static GitLabGroupAndProjectMigrationByDirectTransferCreateEntity
            groupAndProjectMigrationByDirectTransferCreateEntity() {
        return GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder()
                .sourceType(GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType.GROUP_ENTITY)
                .sourceFullPath("'source/full/path' not 'https://example.com/source/full/path'")
                .destinationNamespace("'destination_namespace' or 'destination/namespace'")
                .destinationSlug("'destination_slug' not 'destination/slug'")
                .destinationName("'destination_slug' not 'destination/slug'")
                .migrateProjects(true)
                .migrateMemberships(true)
                .build();
    }

    public static GitLabGroupAndProjectMigrationByDirectTransferCreatePayload
            groupAndProjectMigrationByDirectTransferCreatePayload() {
        return GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder.builder()
                .configuration(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures
                                .groupAndProjectMigrationByDirectTransferCreateConfiguration())
                .entities(List.of(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures
                                .groupAndProjectMigrationByDirectTransferCreateEntity()))
                .build();
    }
}
