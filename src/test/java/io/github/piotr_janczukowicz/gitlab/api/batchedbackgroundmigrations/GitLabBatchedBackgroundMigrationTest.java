package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedBackgroundMigrationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .id(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobClassNameIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .jobClassName(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.jobClassName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTableNameIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .tableName(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.tableName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColumnNameIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .columnName(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.columnName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .status(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProgressIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .progress(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.progress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .createdAt(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEstimatedTimeRemainingIsNullable() {
        final GitLabBatchedBackgroundMigrationBuilder builder = GitLabBatchedBackgroundMigrationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration())
                .estimatedTimeRemaining(null);

        final GitLabBatchedBackgroundMigration built = builder.build();

        assertThat(built.estimatedTimeRemaining()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedBackgroundMigration value =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("1234");
            softly.assertThat(value.jobClassName()).isEqualTo("CopyColumnUsingBackgroundMigrationJob");
            softly.assertThat(value.tableName()).isEqualTo("events");
            softly.assertThat(value.columnName()).isEqualTo("id");
            softly.assertThat(value.status()).isEqualTo("active");
            softly.assertThat(value.progress()).isEqualTo(1.5);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.estimatedTimeRemaining()).isEqualTo("1 day");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedBackgroundMigration original =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration();

        final GitLabBatchedBackgroundMigration rebuilt =
                GitLabBatchedBackgroundMigrationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedBackgroundMigration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "jobClassName",
                        "tableName",
                        "columnName",
                        "status",
                        "progress",
                        "createdAt",
                        "estimatedTimeRemaining");
    }
}
