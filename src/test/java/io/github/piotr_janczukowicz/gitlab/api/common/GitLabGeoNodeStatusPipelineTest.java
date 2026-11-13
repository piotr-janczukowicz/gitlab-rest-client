package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusPipelineTest {

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsChecksumTotalCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsChecksummedCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsChecksumFailedCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsSyncedCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsFailedCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsFailedCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsRegistryCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsVerificationTotalCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsVerifiedCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsVerificationFailedCount(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsSyncedInPercentage(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPipelineBuilder builder = GitLabGeoNodeStatusPipelineBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPipeline())
                .pipelineArtifactsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusPipeline built = builder.build();

        assertThat(built.pipelineArtifactsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusPipeline value = CommonCatalogFixtures.geoNodeStatusPipeline();

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
        final GitLabGeoNodeStatusPipeline original = CommonCatalogFixtures.geoNodeStatusPipeline();

        final GitLabGeoNodeStatusPipeline rebuilt =
                GitLabGeoNodeStatusPipelineBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusPipeline.class.getRecordComponents())
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
