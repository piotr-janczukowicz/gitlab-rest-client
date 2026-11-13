package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusAppearanceTest {

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsSyncedCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsFailedCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsRegistryCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusAppearanceBuilder builder = GitLabGeoNodeStatusAppearanceBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusAppearance())
                .appearanceUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusAppearance value = CommonCatalogFixtures.geoNodeStatusAppearance();

        assertSoftly(softly -> {
            softly.assertThat(value.appearanceUploadsCount()).isEqualTo("appearance_uploads_count");
            softly.assertThat(value.appearanceUploadsChecksumTotalCount())
                    .isEqualTo("appearance_uploads_checksum_total_count");
            softly.assertThat(value.appearanceUploadsChecksummedCount())
                    .isEqualTo("appearance_uploads_checksummed_count");
            softly.assertThat(value.appearanceUploadsChecksumFailedCount())
                    .isEqualTo("appearance_uploads_checksum_failed_count");
            softly.assertThat(value.appearanceUploadsSyncedCount()).isEqualTo("appearance_uploads_synced_count");
            softly.assertThat(value.appearanceUploadsFailedCount()).isEqualTo("appearance_uploads_failed_count");
            softly.assertThat(value.appearanceUploadsRegistryCount()).isEqualTo("appearance_uploads_registry_count");
            softly.assertThat(value.appearanceUploadsVerificationTotalCount())
                    .isEqualTo("appearance_uploads_verification_total_count");
            softly.assertThat(value.appearanceUploadsVerifiedCount()).isEqualTo("appearance_uploads_verified_count");
            softly.assertThat(value.appearanceUploadsVerificationFailedCount())
                    .isEqualTo("appearance_uploads_verification_failed_count");
            softly.assertThat(value.appearanceUploadsOldestUnsyncedTime())
                    .isEqualTo("appearance_uploads_oldest_unsynced_time");
            softly.assertThat(value.appearanceUploadsSyncedInPercentage())
                    .isEqualTo("appearance_uploads_synced_in_percentage");
            softly.assertThat(value.appearanceUploadsVerifiedInPercentage())
                    .isEqualTo("appearance_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusAppearance original = CommonCatalogFixtures.geoNodeStatusAppearance();

        final GitLabGeoNodeStatusAppearance rebuilt =
                GitLabGeoNodeStatusAppearanceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusAppearance.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "appearanceUploadsCount",
                        "appearanceUploadsChecksumTotalCount",
                        "appearanceUploadsChecksummedCount",
                        "appearanceUploadsChecksumFailedCount",
                        "appearanceUploadsSyncedCount",
                        "appearanceUploadsFailedCount",
                        "appearanceUploadsRegistryCount",
                        "appearanceUploadsVerificationTotalCount",
                        "appearanceUploadsVerifiedCount",
                        "appearanceUploadsVerificationFailedCount",
                        "appearanceUploadsOldestUnsyncedTime",
                        "appearanceUploadsSyncedInPercentage",
                        "appearanceUploadsVerifiedInPercentage");
    }
}
