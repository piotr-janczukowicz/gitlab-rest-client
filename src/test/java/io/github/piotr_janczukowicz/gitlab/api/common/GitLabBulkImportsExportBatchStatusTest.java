package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBulkImportsExportBatchStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBulkImportsExportBatchStatusBuilder builder = GitLabBulkImportsExportBatchStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportBatchStatus())
                .status(null);

        final GitLabBulkImportsExportBatchStatus built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBatchNumberIsNullable() {
        final GitLabBulkImportsExportBatchStatusBuilder builder = GitLabBulkImportsExportBatchStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportBatchStatus())
                .batchNumber(null);

        final GitLabBulkImportsExportBatchStatus built = builder.build();

        assertThat(built.batchNumber()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenObjectsCountIsNullable() {
        final GitLabBulkImportsExportBatchStatusBuilder builder = GitLabBulkImportsExportBatchStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportBatchStatus())
                .objectsCount(null);

        final GitLabBulkImportsExportBatchStatus built = builder.build();

        assertThat(built.objectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorIsNullable() {
        final GitLabBulkImportsExportBatchStatusBuilder builder = GitLabBulkImportsExportBatchStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportBatchStatus())
                .error(null);

        final GitLabBulkImportsExportBatchStatus built = builder.build();

        assertThat(built.error()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabBulkImportsExportBatchStatusBuilder builder = GitLabBulkImportsExportBatchStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportBatchStatus())
                .updatedAt(null);

        final GitLabBulkImportsExportBatchStatus built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBulkImportsExportBatchStatus value = CommonCatalogFixtures.bulkImportsExportBatchStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.status()).isEqualTo(GitLabBulkImportsExportBatchStatusStatus.STARTED);
            softly.assertThat(value.batchNumber()).isEqualTo(1);
            softly.assertThat(value.objectsCount()).isEqualTo(1);
            softly.assertThat(value.error()).isEqualTo("Error message");
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBulkImportsExportBatchStatus original = CommonCatalogFixtures.bulkImportsExportBatchStatus();

        final GitLabBulkImportsExportBatchStatus rebuilt =
                GitLabBulkImportsExportBatchStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBulkImportsExportBatchStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status", "batchNumber", "objectsCount", "error", "updatedAt");
    }
}
