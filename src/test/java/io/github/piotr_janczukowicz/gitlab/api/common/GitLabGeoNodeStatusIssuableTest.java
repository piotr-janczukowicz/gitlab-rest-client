package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusIssuableTest {

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsSyncedCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsFailedCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsRegistryCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableMetricImageUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusIssuableBuilder builder = GitLabGeoNodeStatusIssuableBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusIssuable())
                .issuableMetricImageUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusIssuable built = builder.build();

        assertThat(built.issuableMetricImageUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusIssuable value = CommonCatalogFixtures.geoNodeStatusIssuable();

        assertSoftly(softly -> {
            softly.assertThat(value.issuableMetricImageUploadsCount()).isEqualTo("issuable_metric_image_uploads_count");
            softly.assertThat(value.issuableMetricImageUploadsChecksumTotalCount())
                    .isEqualTo("issuable_metric_image_uploads_checksum_total_count");
            softly.assertThat(value.issuableMetricImageUploadsChecksummedCount())
                    .isEqualTo("issuable_metric_image_uploads_checksummed_count");
            softly.assertThat(value.issuableMetricImageUploadsChecksumFailedCount())
                    .isEqualTo("issuable_metric_image_uploads_checksum_failed_count");
            softly.assertThat(value.issuableMetricImageUploadsSyncedCount())
                    .isEqualTo("issuable_metric_image_uploads_synced_count");
            softly.assertThat(value.issuableMetricImageUploadsFailedCount())
                    .isEqualTo("issuable_metric_image_uploads_failed_count");
            softly.assertThat(value.issuableMetricImageUploadsRegistryCount())
                    .isEqualTo("issuable_metric_image_uploads_registry_count");
            softly.assertThat(value.issuableMetricImageUploadsVerificationTotalCount())
                    .isEqualTo("issuable_metric_image_uploads_verification_total_count");
            softly.assertThat(value.issuableMetricImageUploadsVerifiedCount())
                    .isEqualTo("issuable_metric_image_uploads_verified_count");
            softly.assertThat(value.issuableMetricImageUploadsVerificationFailedCount())
                    .isEqualTo("issuable_metric_image_uploads_verification_failed_count");
            softly.assertThat(value.issuableMetricImageUploadsOldestUnsyncedTime())
                    .isEqualTo("issuable_metric_image_uploads_oldest_unsynced_time");
            softly.assertThat(value.issuableMetricImageUploadsSyncedInPercentage())
                    .isEqualTo("issuable_metric_image_uploads_synced_in_percentage");
            softly.assertThat(value.issuableMetricImageUploadsVerifiedInPercentage())
                    .isEqualTo("issuable_metric_image_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusIssuable original = CommonCatalogFixtures.geoNodeStatusIssuable();

        final GitLabGeoNodeStatusIssuable rebuilt =
                GitLabGeoNodeStatusIssuableBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusIssuable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "issuableMetricImageUploadsCount",
                        "issuableMetricImageUploadsChecksumTotalCount",
                        "issuableMetricImageUploadsChecksummedCount",
                        "issuableMetricImageUploadsChecksumFailedCount",
                        "issuableMetricImageUploadsSyncedCount",
                        "issuableMetricImageUploadsFailedCount",
                        "issuableMetricImageUploadsRegistryCount",
                        "issuableMetricImageUploadsVerificationTotalCount",
                        "issuableMetricImageUploadsVerifiedCount",
                        "issuableMetricImageUploadsVerificationFailedCount",
                        "issuableMetricImageUploadsOldestUnsyncedTime",
                        "issuableMetricImageUploadsSyncedInPercentage",
                        "issuableMetricImageUploadsVerifiedInPercentage");
    }
}
