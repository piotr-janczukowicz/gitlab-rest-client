package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusAlertTest {

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsSyncedCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsFailedCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsRegistryCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertManagementMetricImageUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAlertBuilder builder = GitLabGeoSiteStatusAlertBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAlert())
                .alertManagementMetricImageUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusAlert built = builder.build();

        assertThat(built.alertManagementMetricImageUploadsVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusAlert value = GeositesCatalogFixtures.geoSiteStatusAlert();

        assertSoftly(softly -> {
            softly.assertThat(value.alertManagementMetricImageUploadsCount())
                    .isEqualTo("alert_management_metric_image_uploads_count");
            softly.assertThat(value.alertManagementMetricImageUploadsChecksumTotalCount())
                    .isEqualTo("alert_management_metric_image_uploads_checksum_total_count");
            softly.assertThat(value.alertManagementMetricImageUploadsChecksummedCount())
                    .isEqualTo("alert_management_metric_image_uploads_checksummed_count");
            softly.assertThat(value.alertManagementMetricImageUploadsChecksumFailedCount())
                    .isEqualTo("alert_management_metric_image_uploads_checksum_failed_count");
            softly.assertThat(value.alertManagementMetricImageUploadsSyncedCount())
                    .isEqualTo("alert_management_metric_image_uploads_synced_count");
            softly.assertThat(value.alertManagementMetricImageUploadsFailedCount())
                    .isEqualTo("alert_management_metric_image_uploads_failed_count");
            softly.assertThat(value.alertManagementMetricImageUploadsRegistryCount())
                    .isEqualTo("alert_management_metric_image_uploads_registry_count");
            softly.assertThat(value.alertManagementMetricImageUploadsVerificationTotalCount())
                    .isEqualTo("alert_management_metric_image_uploads_verification_total_count");
            softly.assertThat(value.alertManagementMetricImageUploadsVerifiedCount())
                    .isEqualTo("alert_management_metric_image_uploads_verified_count");
            softly.assertThat(value.alertManagementMetricImageUploadsVerificationFailedCount())
                    .isEqualTo("alert_management_metric_image_uploads_verification_failed_count");
            softly.assertThat(value.alertManagementMetricImageUploadsOldestUnsyncedTime())
                    .isEqualTo("alert_management_metric_image_uploads_oldest_unsynced_time");
            softly.assertThat(value.alertManagementMetricImageUploadsSyncedInPercentage())
                    .isEqualTo("alert_management_metric_image_uploads_synced_in_percentage");
            softly.assertThat(value.alertManagementMetricImageUploadsVerifiedInPercentage())
                    .isEqualTo("alert_management_metric_image_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusAlert original = GeositesCatalogFixtures.geoSiteStatusAlert();

        final GitLabGeoSiteStatusAlert rebuilt =
                GitLabGeoSiteStatusAlertBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusAlert.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "alertManagementMetricImageUploadsCount",
                        "alertManagementMetricImageUploadsChecksumTotalCount",
                        "alertManagementMetricImageUploadsChecksummedCount",
                        "alertManagementMetricImageUploadsChecksumFailedCount",
                        "alertManagementMetricImageUploadsSyncedCount",
                        "alertManagementMetricImageUploadsFailedCount",
                        "alertManagementMetricImageUploadsRegistryCount",
                        "alertManagementMetricImageUploadsVerificationTotalCount",
                        "alertManagementMetricImageUploadsVerifiedCount",
                        "alertManagementMetricImageUploadsVerificationFailedCount",
                        "alertManagementMetricImageUploadsOldestUnsyncedTime",
                        "alertManagementMetricImageUploadsSyncedInPercentage",
                        "alertManagementMetricImageUploadsVerifiedInPercentage");
    }
}
