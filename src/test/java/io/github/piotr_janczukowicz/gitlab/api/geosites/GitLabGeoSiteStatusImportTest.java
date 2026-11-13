package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusImportTest {

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsSyncedCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsFailedCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsRegistryCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusImportBuilder builder = GitLabGeoSiteStatusImportBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusImport())
                .importExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusImport built = builder.build();

        assertThat(built.importExportUploadUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusImport value = GeositesCatalogFixtures.geoSiteStatusImport();

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
        final GitLabGeoSiteStatusImport original = GeositesCatalogFixtures.geoSiteStatusImport();

        final GitLabGeoSiteStatusImport rebuilt =
                GitLabGeoSiteStatusImportBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusImport.class.getRecordComponents())
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
