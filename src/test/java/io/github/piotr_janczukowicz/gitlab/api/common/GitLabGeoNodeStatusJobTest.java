package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusJobTest {

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsChecksumTotalCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsChecksummedCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsChecksumFailedCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsSyncedCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsFailedCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsFailedCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsRegistryCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsVerificationTotalCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsVerifiedCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsVerificationFailedCount(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsSyncedInPercentage(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusJobBuilder builder = GitLabGeoNodeStatusJobBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusJob())
                .jobArtifactsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusJob built = builder.build();

        assertThat(built.jobArtifactsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusJob value = CommonCatalogFixtures.geoNodeStatusJob();

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
        final GitLabGeoNodeStatusJob original = CommonCatalogFixtures.geoNodeStatusJob();

        final GitLabGeoNodeStatusJob rebuilt =
                GitLabGeoNodeStatusJobBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusJob.class.getRecordComponents())
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
