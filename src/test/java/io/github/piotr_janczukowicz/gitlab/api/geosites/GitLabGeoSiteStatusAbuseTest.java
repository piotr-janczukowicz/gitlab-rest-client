package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusAbuseTest {

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsSyncedCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsFailedCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsRegistryCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAbuseBuilder builder = GitLabGeoSiteStatusAbuseBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAbuse())
                .abuseReportUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusAbuse value = GeositesCatalogFixtures.geoSiteStatusAbuse();

        assertSoftly(softly -> {
            softly.assertThat(value.abuseReportUploadsCount()).isEqualTo("abuse_report_uploads_count");
            softly.assertThat(value.abuseReportUploadsChecksumTotalCount())
                    .isEqualTo("abuse_report_uploads_checksum_total_count");
            softly.assertThat(value.abuseReportUploadsChecksummedCount())
                    .isEqualTo("abuse_report_uploads_checksummed_count");
            softly.assertThat(value.abuseReportUploadsChecksumFailedCount())
                    .isEqualTo("abuse_report_uploads_checksum_failed_count");
            softly.assertThat(value.abuseReportUploadsSyncedCount()).isEqualTo("abuse_report_uploads_synced_count");
            softly.assertThat(value.abuseReportUploadsFailedCount()).isEqualTo("abuse_report_uploads_failed_count");
            softly.assertThat(value.abuseReportUploadsRegistryCount()).isEqualTo("abuse_report_uploads_registry_count");
            softly.assertThat(value.abuseReportUploadsVerificationTotalCount())
                    .isEqualTo("abuse_report_uploads_verification_total_count");
            softly.assertThat(value.abuseReportUploadsVerifiedCount()).isEqualTo("abuse_report_uploads_verified_count");
            softly.assertThat(value.abuseReportUploadsVerificationFailedCount())
                    .isEqualTo("abuse_report_uploads_verification_failed_count");
            softly.assertThat(value.abuseReportUploadsOldestUnsyncedTime())
                    .isEqualTo("abuse_report_uploads_oldest_unsynced_time");
            softly.assertThat(value.abuseReportUploadsSyncedInPercentage())
                    .isEqualTo("abuse_report_uploads_synced_in_percentage");
            softly.assertThat(value.abuseReportUploadsVerifiedInPercentage())
                    .isEqualTo("abuse_report_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusAbuse original = GeositesCatalogFixtures.geoSiteStatusAbuse();

        final GitLabGeoSiteStatusAbuse rebuilt =
                GitLabGeoSiteStatusAbuseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusAbuse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "abuseReportUploadsCount",
                        "abuseReportUploadsChecksumTotalCount",
                        "abuseReportUploadsChecksummedCount",
                        "abuseReportUploadsChecksumFailedCount",
                        "abuseReportUploadsSyncedCount",
                        "abuseReportUploadsFailedCount",
                        "abuseReportUploadsRegistryCount",
                        "abuseReportUploadsVerificationTotalCount",
                        "abuseReportUploadsVerifiedCount",
                        "abuseReportUploadsVerificationFailedCount",
                        "abuseReportUploadsOldestUnsyncedTime",
                        "abuseReportUploadsSyncedInPercentage",
                        "abuseReportUploadsVerifiedInPercentage");
    }
}
