package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusJobTest {

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsChecksumTotalCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsChecksummedCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsChecksumFailedCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsSyncedCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsFailedCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsFailedCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsRegistryCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsVerificationTotalCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsVerifiedCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsVerificationFailedCount(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsSyncedInPercentage(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusJobBuilder builder = GitLabGeoSiteStatusJobBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusJob())
                .jobArtifactsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusJob value = GeositesCatalogFixtures.geoSiteStatusJob();

        assertSoftly(softly -> {
            softly.assertThat(value.jobArtifactsCount()).isEqualTo("job_artifacts_count");
            softly.assertThat(value.jobArtifactsChecksumTotalCount()).isEqualTo("job_artifacts_checksum_total_count");
            softly.assertThat(value.jobArtifactsChecksummedCount()).isEqualTo("job_artifacts_checksummed_count");
            softly.assertThat(value.jobArtifactsChecksumFailedCount()).isEqualTo("job_artifacts_checksum_failed_count");
            softly.assertThat(value.jobArtifactsSyncedCount()).isEqualTo("job_artifacts_synced_count");
            softly.assertThat(value.jobArtifactsFailedCount()).isEqualTo("job_artifacts_failed_count");
            softly.assertThat(value.jobArtifactsRegistryCount()).isEqualTo("job_artifacts_registry_count");
            softly.assertThat(value.jobArtifactsVerificationTotalCount())
                    .isEqualTo("job_artifacts_verification_total_count");
            softly.assertThat(value.jobArtifactsVerifiedCount()).isEqualTo("job_artifacts_verified_count");
            softly.assertThat(value.jobArtifactsVerificationFailedCount())
                    .isEqualTo("job_artifacts_verification_failed_count");
            softly.assertThat(value.jobArtifactsOldestUnsyncedTime()).isEqualTo("job_artifacts_oldest_unsynced_time");
            softly.assertThat(value.jobArtifactsSyncedInPercentage()).isEqualTo("job_artifacts_synced_in_percentage");
            softly.assertThat(value.jobArtifactsVerifiedInPercentage())
                    .isEqualTo("job_artifacts_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusJob original = GeositesCatalogFixtures.geoSiteStatusJob();

        final GitLabGeoSiteStatusJob rebuilt =
                GitLabGeoSiteStatusJobBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusJob.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "jobArtifactsCount",
                        "jobArtifactsChecksumTotalCount",
                        "jobArtifactsChecksummedCount",
                        "jobArtifactsChecksumFailedCount",
                        "jobArtifactsSyncedCount",
                        "jobArtifactsFailedCount",
                        "jobArtifactsRegistryCount",
                        "jobArtifactsVerificationTotalCount",
                        "jobArtifactsVerifiedCount",
                        "jobArtifactsVerificationFailedCount",
                        "jobArtifactsOldestUnsyncedTime",
                        "jobArtifactsSyncedInPercentage",
                        "jobArtifactsVerifiedInPercentage");
    }
}
