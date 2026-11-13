package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusUploadsTest {

    @Test
    void constructor_shouldAcceptNull_whenUploadsCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsChecksummedCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsSyncedCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsFailedCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsRegistryCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsVerifiedCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusUploadsBuilder builder = GitLabGeoSiteStatusUploadsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUploads())
                .uploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusUploads built = builder.build();

        assertThat(built.uploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusUploads value = GeositesCatalogFixtures.geoSiteStatusUploads();

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
        final GitLabGeoSiteStatusUploads original = GeositesCatalogFixtures.geoSiteStatusUploads();

        final GitLabGeoSiteStatusUploads rebuilt =
                GitLabGeoSiteStatusUploadsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusUploads.class.getRecordComponents())
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
