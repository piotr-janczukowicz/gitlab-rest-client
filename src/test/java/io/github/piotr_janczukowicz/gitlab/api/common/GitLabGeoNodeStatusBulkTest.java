package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusBulkTest {

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsSyncedCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsFailedCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsRegistryCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusBulkBuilder builder = GitLabGeoNodeStatusBulkBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusBulk())
                .bulkImportExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusBulk built = builder.build();

        assertThat(built.bulkImportExportUploadUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusBulk value = CommonCatalogFixtures.geoNodeStatusBulk();

        assertSoftly(softly -> {
            softly.assertThat(value.bulkImportExportUploadUploadsCount())
                    .isEqualTo("bulk_import_export_upload_uploads_count");
            softly.assertThat(value.bulkImportExportUploadUploadsChecksumTotalCount())
                    .isEqualTo("bulk_import_export_upload_uploads_checksum_total_count");
            softly.assertThat(value.bulkImportExportUploadUploadsChecksummedCount())
                    .isEqualTo("bulk_import_export_upload_uploads_checksummed_count");
            softly.assertThat(value.bulkImportExportUploadUploadsChecksumFailedCount())
                    .isEqualTo("bulk_import_export_upload_uploads_checksum_failed_count");
            softly.assertThat(value.bulkImportExportUploadUploadsSyncedCount())
                    .isEqualTo("bulk_import_export_upload_uploads_synced_count");
            softly.assertThat(value.bulkImportExportUploadUploadsFailedCount())
                    .isEqualTo("bulk_import_export_upload_uploads_failed_count");
            softly.assertThat(value.bulkImportExportUploadUploadsRegistryCount())
                    .isEqualTo("bulk_import_export_upload_uploads_registry_count");
            softly.assertThat(value.bulkImportExportUploadUploadsVerificationTotalCount())
                    .isEqualTo("bulk_import_export_upload_uploads_verification_total_count");
            softly.assertThat(value.bulkImportExportUploadUploadsVerifiedCount())
                    .isEqualTo("bulk_import_export_upload_uploads_verified_count");
            softly.assertThat(value.bulkImportExportUploadUploadsVerificationFailedCount())
                    .isEqualTo("bulk_import_export_upload_uploads_verification_failed_count");
            softly.assertThat(value.bulkImportExportUploadUploadsOldestUnsyncedTime())
                    .isEqualTo("bulk_import_export_upload_uploads_oldest_unsynced_time");
            softly.assertThat(value.bulkImportExportUploadUploadsSyncedInPercentage())
                    .isEqualTo("bulk_import_export_upload_uploads_synced_in_percentage");
            softly.assertThat(value.bulkImportExportUploadUploadsVerifiedInPercentage())
                    .isEqualTo("bulk_import_export_upload_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusBulk original = CommonCatalogFixtures.geoNodeStatusBulk();

        final GitLabGeoNodeStatusBulk rebuilt =
                GitLabGeoNodeStatusBulkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusBulk.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "bulkImportExportUploadUploadsCount",
                        "bulkImportExportUploadUploadsChecksumTotalCount",
                        "bulkImportExportUploadUploadsChecksummedCount",
                        "bulkImportExportUploadUploadsChecksumFailedCount",
                        "bulkImportExportUploadUploadsSyncedCount",
                        "bulkImportExportUploadUploadsFailedCount",
                        "bulkImportExportUploadUploadsRegistryCount",
                        "bulkImportExportUploadUploadsVerificationTotalCount",
                        "bulkImportExportUploadUploadsVerifiedCount",
                        "bulkImportExportUploadUploadsVerificationFailedCount",
                        "bulkImportExportUploadUploadsOldestUnsyncedTime",
                        "bulkImportExportUploadUploadsSyncedInPercentage",
                        "bulkImportExportUploadUploadsVerifiedInPercentage");
    }
}
