package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusPipelineTest {

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsChecksumTotalCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsChecksummedCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsChecksumFailedCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsSyncedCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsFailedCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsFailedCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsRegistryCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsVerificationTotalCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsVerifiedCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsVerificationFailedCount(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsSyncedInPercentage(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPipelineBuilder builder = GitLabGeoSiteStatusPipelineBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPipeline())
                .pipelineArtifactsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusPipeline value = GeositesCatalogFixtures.geoSiteStatusPipeline();

        assertSoftly(softly -> {
            softly.assertThat(value.pipelineArtifactsCount()).isEqualTo("pipeline_artifacts_count");
            softly.assertThat(value.pipelineArtifactsChecksumTotalCount())
                    .isEqualTo("pipeline_artifacts_checksum_total_count");
            softly.assertThat(value.pipelineArtifactsChecksummedCount())
                    .isEqualTo("pipeline_artifacts_checksummed_count");
            softly.assertThat(value.pipelineArtifactsChecksumFailedCount())
                    .isEqualTo("pipeline_artifacts_checksum_failed_count");
            softly.assertThat(value.pipelineArtifactsSyncedCount()).isEqualTo("pipeline_artifacts_synced_count");
            softly.assertThat(value.pipelineArtifactsFailedCount()).isEqualTo("pipeline_artifacts_failed_count");
            softly.assertThat(value.pipelineArtifactsRegistryCount()).isEqualTo("pipeline_artifacts_registry_count");
            softly.assertThat(value.pipelineArtifactsVerificationTotalCount())
                    .isEqualTo("pipeline_artifacts_verification_total_count");
            softly.assertThat(value.pipelineArtifactsVerifiedCount()).isEqualTo("pipeline_artifacts_verified_count");
            softly.assertThat(value.pipelineArtifactsVerificationFailedCount())
                    .isEqualTo("pipeline_artifacts_verification_failed_count");
            softly.assertThat(value.pipelineArtifactsOldestUnsyncedTime())
                    .isEqualTo("pipeline_artifacts_oldest_unsynced_time");
            softly.assertThat(value.pipelineArtifactsSyncedInPercentage())
                    .isEqualTo("pipeline_artifacts_synced_in_percentage");
            softly.assertThat(value.pipelineArtifactsVerifiedInPercentage())
                    .isEqualTo("pipeline_artifacts_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusPipeline original = GeositesCatalogFixtures.geoSiteStatusPipeline();

        final GitLabGeoSiteStatusPipeline rebuilt =
                GitLabGeoSiteStatusPipelineBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusPipeline.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "pipelineArtifactsCount",
                        "pipelineArtifactsChecksumTotalCount",
                        "pipelineArtifactsChecksummedCount",
                        "pipelineArtifactsChecksumFailedCount",
                        "pipelineArtifactsSyncedCount",
                        "pipelineArtifactsFailedCount",
                        "pipelineArtifactsRegistryCount",
                        "pipelineArtifactsVerificationTotalCount",
                        "pipelineArtifactsVerifiedCount",
                        "pipelineArtifactsVerificationFailedCount",
                        "pipelineArtifactsOldestUnsyncedTime",
                        "pipelineArtifactsSyncedInPercentage",
                        "pipelineArtifactsVerifiedInPercentage");
    }
}
