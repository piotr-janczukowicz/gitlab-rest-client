package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusAbuseTest {

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsSyncedCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsFailedCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsRegistryCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseReportUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusAbuseBuilder builder = GitLabGeoNodeStatusAbuseBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAbuse())
                .abuseReportUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusAbuse built = builder.build();

        assertThat(built.abuseReportUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusAbuse value = CommonCatalogFixtures.geoNodeStatusAbuse();

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
        final GitLabGeoNodeStatusAbuse original = CommonCatalogFixtures.geoNodeStatusAbuse();

        final GitLabGeoNodeStatusAbuse rebuilt =
                GitLabGeoNodeStatusAbuseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusAbuse.class.getRecordComponents())
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
