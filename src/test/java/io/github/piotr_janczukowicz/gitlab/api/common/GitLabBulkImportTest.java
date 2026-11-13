package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBulkImportTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .id(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .status(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceTypeIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .sourceType(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.sourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceUrlIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .sourceUrl(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.sourceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .createdAt(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .updatedAt(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasFailuresIsNullable() {
        final GitLabBulkImportBuilder builder = GitLabBulkImportBuilder.builder(CommonCatalogFixtures.bulkImport())
                .hasFailures(null);

        final GitLabBulkImport built = builder.build();

        assertThat(built.hasFailures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBulkImport value = CommonCatalogFixtures.bulkImport();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo(GitLabBulkImportStatus.CREATED);
            softly.assertThat(value.sourceType()).isEqualTo("gitlab");
            softly.assertThat(value.sourceUrl()).isEqualTo("https://source.gitlab.com/");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.hasFailures()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBulkImport original = CommonCatalogFixtures.bulkImport();

        final GitLabBulkImport rebuilt =
                GitLabBulkImportBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBulkImport.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "status", "sourceType", "sourceUrl", "createdAt", "updatedAt", "hasFailures");
    }
}
