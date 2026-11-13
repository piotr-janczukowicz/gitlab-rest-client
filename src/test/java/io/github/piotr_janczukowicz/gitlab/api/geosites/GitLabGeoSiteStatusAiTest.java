package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusAiTest {

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsSyncedCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsFailedCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsRegistryCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiVectorizableFileUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAiBuilder builder = GitLabGeoSiteStatusAiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAi())
                .aiVectorizableFileUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusAi built = builder.build();

        assertThat(built.aiVectorizableFileUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusAi value = GeositesCatalogFixtures.geoSiteStatusAi();

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
        final GitLabGeoSiteStatusAi original = GeositesCatalogFixtures.geoSiteStatusAi();

        final GitLabGeoSiteStatusAi rebuilt =
                GitLabGeoSiteStatusAiBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusAi.class.getRecordComponents())
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
