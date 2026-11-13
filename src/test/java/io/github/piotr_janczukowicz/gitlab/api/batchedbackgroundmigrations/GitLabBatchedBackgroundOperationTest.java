package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedBackgroundOperationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .id(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPartitionIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .partition(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.partition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobClassNameIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .jobClassName(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.jobClassName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTableNameIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .tableName(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.tableName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColumnNameIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .columnName(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.columnName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .status(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .createdAt(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .startedAt(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .finishedAt(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnHoldUntilIsNullable() {
        final GitLabBatchedBackgroundOperationBuilder builder = GitLabBatchedBackgroundOperationBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation())
                .onHoldUntil(null);

        final GitLabBatchedBackgroundOperation built = builder.build();

        assertThat(built.onHoldUntil()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedBackgroundOperation value =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("<cluster>:<partition_id>:<id/uuid>");
            softly.assertThat(value.partition()).isEqualTo(1);
            softly.assertThat(value.jobClassName()).isEqualTo("UsersDeleteUnconfirmedSecondaryEmails");
            softly.assertThat(value.tableName()).isEqualTo("users");
            softly.assertThat(value.columnName()).isEqualTo("id");
            softly.assertThat(value.status()).isEqualTo("active");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.onHoldUntil()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedBackgroundOperation original =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation();

        final GitLabBatchedBackgroundOperation rebuilt =
                GitLabBatchedBackgroundOperationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedBackgroundOperation.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "partition",
                        "jobClassName",
                        "tableName",
                        "columnName",
                        "status",
                        "createdAt",
                        "startedAt",
                        "finishedAt",
                        "onHoldUntil");
    }
}
