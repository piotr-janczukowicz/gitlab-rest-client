package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabImportOfflineExportTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .id(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .status(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceHostnameIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .sourceHostname(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.sourceHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .createdAt(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .updatedAt(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasFailuresIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .hasFailures(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.hasFailures()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBucketIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .bucket(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.bucket()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExportPrefixIsNullable() {
        final GitLabImportOfflineExportBuilder builder = GitLabImportOfflineExportBuilder.builder(
                        OfflinetransfersCatalogFixtures.importOfflineExport())
                .exportPrefix(null);

        final GitLabImportOfflineExport built = builder.build();

        assertThat(built.exportPrefix()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImportOfflineExport value = OfflinetransfersCatalogFixtures.importOfflineExport();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo(GitLabImportOfflineExportStatus.CREATED);
            softly.assertThat(value.sourceHostname()).isEqualTo("https://source.example.com/");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.hasFailures()).isEqualTo(true);
            softly.assertThat(value.bucket()).isEqualTo("gitlab-exports");
            softly.assertThat(value.exportPrefix()).isEqualTo("2012-05-28_04-42-42_export_ab12cd34");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImportOfflineExport original = OfflinetransfersCatalogFixtures.importOfflineExport();

        final GitLabImportOfflineExport rebuilt =
                GitLabImportOfflineExportBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabImportOfflineExport.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "status",
                        "sourceHostname",
                        "createdAt",
                        "updatedAt",
                        "hasFailures",
                        "bucket",
                        "exportPrefix");
    }
}
