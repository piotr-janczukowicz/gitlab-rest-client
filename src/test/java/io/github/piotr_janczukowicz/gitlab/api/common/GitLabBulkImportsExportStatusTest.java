package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBulkImportsExportStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .relation(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.relation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .status(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .error(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.error()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .updatedAt(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBatchedIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .batched(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.batched()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBatchesCountIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .batchesCount(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.batchesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalObjectsCountIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .totalObjectsCount(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.totalObjectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBatchesIsNullable() {
        final GitLabBulkImportsExportStatusBuilder builder = GitLabBulkImportsExportStatusBuilder.builder(
                        CommonCatalogFixtures.bulkImportsExportStatus())
                .batches(null);

        final GitLabBulkImportsExportStatus built = builder.build();

        assertThat(built.batches()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBulkImportsExportStatus value = CommonCatalogFixtures.bulkImportsExportStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.relation()).isEqualTo("issues");
            softly.assertThat(value.status()).isEqualTo(GitLabBulkImportsExportStatusStatus.PENDING);
            softly.assertThat(value.error()).isEqualTo("Error message");
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.batched()).isEqualTo(true);
            softly.assertThat(value.batchesCount()).isEqualTo(1);
            softly.assertThat(value.totalObjectsCount()).isEqualTo(1);
            softly.assertThat(value.batches()).isEqualTo(List.of(CommonCatalogFixtures.bulkImportsExportBatchStatus()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBulkImportsExportStatus original = CommonCatalogFixtures.bulkImportsExportStatus();

        final GitLabBulkImportsExportStatus rebuilt =
                GitLabBulkImportsExportStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBulkImportsExportStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "relation",
                        "status",
                        "error",
                        "updatedAt",
                        "batched",
                        "batchesCount",
                        "totalObjectsCount",
                        "batches");
    }
}
