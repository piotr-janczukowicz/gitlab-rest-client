package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusUploadsTest {

    @Test
    void constructor_shouldAcceptNull_whenUploadsCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsChecksummedCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsSyncedCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsFailedCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsRegistryCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsVerifiedCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusUploadsBuilder builder = GitLabGeoNodeStatusUploadsBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUploads())
                .uploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusUploads built = builder.build();

        assertThat(built.uploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusUploads value = CommonCatalogFixtures.geoNodeStatusUploads();

        assertSoftly(softly -> {
            softly.assertThat(value.uploadsCount()).isEqualTo("uploads_count");
            softly.assertThat(value.uploadsChecksumTotalCount()).isEqualTo("uploads_checksum_total_count");
            softly.assertThat(value.uploadsChecksummedCount()).isEqualTo("uploads_checksummed_count");
            softly.assertThat(value.uploadsChecksumFailedCount()).isEqualTo("uploads_checksum_failed_count");
            softly.assertThat(value.uploadsSyncedCount()).isEqualTo("uploads_synced_count");
            softly.assertThat(value.uploadsFailedCount()).isEqualTo("uploads_failed_count");
            softly.assertThat(value.uploadsRegistryCount()).isEqualTo("uploads_registry_count");
            softly.assertThat(value.uploadsVerificationTotalCount()).isEqualTo("uploads_verification_total_count");
            softly.assertThat(value.uploadsVerifiedCount()).isEqualTo("uploads_verified_count");
            softly.assertThat(value.uploadsVerificationFailedCount()).isEqualTo("uploads_verification_failed_count");
            softly.assertThat(value.uploadsOldestUnsyncedTime()).isEqualTo("uploads_oldest_unsynced_time");
            softly.assertThat(value.uploadsSyncedInPercentage()).isEqualTo("uploads_synced_in_percentage");
            softly.assertThat(value.uploadsVerifiedInPercentage()).isEqualTo("uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusUploads original = CommonCatalogFixtures.geoNodeStatusUploads();

        final GitLabGeoNodeStatusUploads rebuilt =
                GitLabGeoNodeStatusUploadsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusUploads.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "uploadsCount",
                        "uploadsChecksumTotalCount",
                        "uploadsChecksummedCount",
                        "uploadsChecksumFailedCount",
                        "uploadsSyncedCount",
                        "uploadsFailedCount",
                        "uploadsRegistryCount",
                        "uploadsVerificationTotalCount",
                        "uploadsVerifiedCount",
                        "uploadsVerificationFailedCount",
                        "uploadsOldestUnsyncedTime",
                        "uploadsSyncedInPercentage",
                        "uploadsVerifiedInPercentage");
    }
}
