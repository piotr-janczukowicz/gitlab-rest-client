package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusImportTest {

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsSyncedCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsFailedCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsRegistryCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusImportBuilder builder = GitLabGeoNodeStatusImportBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusImport())
                .importExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusImport value = CommonCatalogFixtures.geoNodeStatusImport();

        assertSoftly(softly -> {
            softly.assertThat(value.importExportUploadUploadsCount()).isEqualTo("import_export_upload_uploads_count");
            softly.assertThat(value.importExportUploadUploadsChecksumTotalCount())
                    .isEqualTo("import_export_upload_uploads_checksum_total_count");
            softly.assertThat(value.importExportUploadUploadsChecksummedCount())
                    .isEqualTo("import_export_upload_uploads_checksummed_count");
            softly.assertThat(value.importExportUploadUploadsChecksumFailedCount())
                    .isEqualTo("import_export_upload_uploads_checksum_failed_count");
            softly.assertThat(value.importExportUploadUploadsSyncedCount())
                    .isEqualTo("import_export_upload_uploads_synced_count");
            softly.assertThat(value.importExportUploadUploadsFailedCount())
                    .isEqualTo("import_export_upload_uploads_failed_count");
            softly.assertThat(value.importExportUploadUploadsRegistryCount())
                    .isEqualTo("import_export_upload_uploads_registry_count");
            softly.assertThat(value.importExportUploadUploadsVerificationTotalCount())
                    .isEqualTo("import_export_upload_uploads_verification_total_count");
            softly.assertThat(value.importExportUploadUploadsVerifiedCount())
                    .isEqualTo("import_export_upload_uploads_verified_count");
            softly.assertThat(value.importExportUploadUploadsVerificationFailedCount())
                    .isEqualTo("import_export_upload_uploads_verification_failed_count");
            softly.assertThat(value.importExportUploadUploadsOldestUnsyncedTime())
                    .isEqualTo("import_export_upload_uploads_oldest_unsynced_time");
            softly.assertThat(value.importExportUploadUploadsSyncedInPercentage())
                    .isEqualTo("import_export_upload_uploads_synced_in_percentage");
            softly.assertThat(value.importExportUploadUploadsVerifiedInPercentage())
                    .isEqualTo("import_export_upload_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusImport original = CommonCatalogFixtures.geoNodeStatusImport();

        final GitLabGeoNodeStatusImport rebuilt =
                GitLabGeoNodeStatusImportBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusImport.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "importExportUploadUploadsCount",
                        "importExportUploadUploadsChecksumTotalCount",
                        "importExportUploadUploadsChecksummedCount",
                        "importExportUploadUploadsChecksumFailedCount",
                        "importExportUploadUploadsSyncedCount",
                        "importExportUploadUploadsFailedCount",
                        "importExportUploadUploadsRegistryCount",
                        "importExportUploadUploadsVerificationTotalCount",
                        "importExportUploadUploadsVerifiedCount",
                        "importExportUploadUploadsVerificationFailedCount",
                        "importExportUploadUploadsOldestUnsyncedTime",
                        "importExportUploadUploadsSyncedInPercentage",
                        "importExportUploadUploadsVerifiedInPercentage");
    }
}
