package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBulkImportsEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .id(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportIdIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .bulkImportId(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.bulkImportId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .status(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntityTypeIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .entityType(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.entityType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceFullPathIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .sourceFullPath(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.sourceFullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationFullPathIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .destinationFullPath(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.destinationFullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationNameIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .destinationName(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.destinationName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationSlugIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .destinationSlug(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.destinationSlug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationNamespaceIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .destinationNamespace(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.destinationNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .parentId(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .namespaceId(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .projectId(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .createdAt(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .updatedAt(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailuresIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .failures(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.failures()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMigrateProjectsIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .migrateProjects(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.migrateProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMigrateMembershipsIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .migrateMemberships(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.migrateMemberships()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasFailuresIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .hasFailures(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.hasFailures()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatsIsNullable() {
        final GitLabBulkImportsEntityBuilder builder = GitLabBulkImportsEntityBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity())
                .stats(null);

        final GitLabBulkImportsEntity built = builder.build();

        assertThat(built.stats()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBulkImportsEntity value =
                GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.bulkImportId()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo(GitLabBulkImportsEntityStatus.CREATED);
            softly.assertThat(value.entityType()).isEqualTo(GitLabBulkImportsEntityType.GROUP);
            softly.assertThat(value.sourceFullPath()).isEqualTo("source_group");
            softly.assertThat(value.destinationFullPath()).isEqualTo("some_group/source_project");
            softly.assertThat(value.destinationName()).isEqualTo("destination_slug");
            softly.assertThat(value.destinationSlug()).isEqualTo("destination_slug");
            softly.assertThat(value.destinationNamespace()).isEqualTo("destination_path");
            softly.assertThat(value.parentId()).isEqualTo(1L);
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.failures())
                    .isEqualTo(List.of(
                            GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure()));
            softly.assertThat(value.migrateProjects()).isEqualTo(true);
            softly.assertThat(value.migrateMemberships()).isEqualTo(true);
            softly.assertThat(value.hasFailures()).isEqualTo(true);
            softly.assertThat(value.stats()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBulkImportsEntity original =
                GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity();

        final GitLabBulkImportsEntity rebuilt =
                GitLabBulkImportsEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBulkImportsEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "bulkImportId",
                        "status",
                        "entityType",
                        "sourceFullPath",
                        "destinationFullPath",
                        "destinationName",
                        "destinationSlug",
                        "destinationNamespace",
                        "parentId",
                        "namespaceId",
                        "projectId",
                        "createdAt",
                        "updatedAt",
                        "failures",
                        "migrateProjects",
                        "migrateMemberships",
                        "hasFailures",
                        "stats");
    }
}
