package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusAiTest {

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsSyncedCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsFailedCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsRegistryCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusAiBuilder builder = GitLabGeoNodeStatusAiBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAi())
                .aiVectorizableFileUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusAi value = CommonCatalogFixtures.geoNodeStatusAi();

        assertSoftly(softly -> {
            softly.assertThat(value.aiVectorizableFileUploadsCount()).isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsChecksumTotalCount())
                    .isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsChecksumFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsFailedCount()).isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsVerificationTotalCount())
                    .isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsVerificationFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsOldestUnsyncedTime())
                    .isEqualTo(1);
            softly.assertThat(value.aiVectorizableFileUploadsSyncedInPercentage())
                    .isEqualTo("0.00%");
            softly.assertThat(value.aiVectorizableFileUploadsVerifiedInPercentage())
                    .isEqualTo("0.00%");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusAi original = CommonCatalogFixtures.geoNodeStatusAi();

        final GitLabGeoNodeStatusAi rebuilt =
                GitLabGeoNodeStatusAiBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusAi.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "aiVectorizableFileUploadsCount",
                        "aiVectorizableFileUploadsChecksumTotalCount",
                        "aiVectorizableFileUploadsChecksummedCount",
                        "aiVectorizableFileUploadsChecksumFailedCount",
                        "aiVectorizableFileUploadsSyncedCount",
                        "aiVectorizableFileUploadsFailedCount",
                        "aiVectorizableFileUploadsRegistryCount",
                        "aiVectorizableFileUploadsVerificationTotalCount",
                        "aiVectorizableFileUploadsVerifiedCount",
                        "aiVectorizableFileUploadsVerificationFailedCount",
                        "aiVectorizableFileUploadsOldestUnsyncedTime",
                        "aiVectorizableFileUploadsSyncedInPercentage",
                        "aiVectorizableFileUploadsVerifiedInPercentage");
    }
}
