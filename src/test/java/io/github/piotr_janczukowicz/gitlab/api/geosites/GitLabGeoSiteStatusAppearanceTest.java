package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusAppearanceTest {

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsSyncedCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsFailedCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsRegistryCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppearanceUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAppearanceBuilder builder = GitLabGeoSiteStatusAppearanceBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAppearance())
                .appearanceUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusAppearance built = builder.build();

        assertThat(built.appearanceUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusAppearance value = GeositesCatalogFixtures.geoSiteStatusAppearance();

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
        final GitLabGeoSiteStatusAppearance original = GeositesCatalogFixtures.geoSiteStatusAppearance();

        final GitLabGeoSiteStatusAppearance rebuilt =
                GitLabGeoSiteStatusAppearanceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusAppearance.class.getRecordComponents())
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
