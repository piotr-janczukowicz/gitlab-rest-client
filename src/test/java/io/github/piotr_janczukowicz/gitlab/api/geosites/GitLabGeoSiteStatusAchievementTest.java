package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusAchievementTest {

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsSyncedCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsFailedCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsRegistryCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAchievementUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusAchievementBuilder builder = GitLabGeoSiteStatusAchievementBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusAchievement())
                .achievementUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusAchievement built = builder.build();

        assertThat(built.achievementUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusAchievement value = GeositesCatalogFixtures.geoSiteStatusAchievement();

        assertSoftly(softly -> {
            softly.assertThat(value.achievementUploadsCount()).isEqualTo("achievement_uploads_count");
            softly.assertThat(value.achievementUploadsChecksumTotalCount())
                    .isEqualTo("achievement_uploads_checksum_total_count");
            softly.assertThat(value.achievementUploadsChecksummedCount())
                    .isEqualTo("achievement_uploads_checksummed_count");
            softly.assertThat(value.achievementUploadsChecksumFailedCount())
                    .isEqualTo("achievement_uploads_checksum_failed_count");
            softly.assertThat(value.achievementUploadsSyncedCount()).isEqualTo("achievement_uploads_synced_count");
            softly.assertThat(value.achievementUploadsFailedCount()).isEqualTo("achievement_uploads_failed_count");
            softly.assertThat(value.achievementUploadsRegistryCount()).isEqualTo("achievement_uploads_registry_count");
            softly.assertThat(value.achievementUploadsVerificationTotalCount())
                    .isEqualTo("achievement_uploads_verification_total_count");
            softly.assertThat(value.achievementUploadsVerifiedCount()).isEqualTo("achievement_uploads_verified_count");
            softly.assertThat(value.achievementUploadsVerificationFailedCount())
                    .isEqualTo("achievement_uploads_verification_failed_count");
            softly.assertThat(value.achievementUploadsOldestUnsyncedTime())
                    .isEqualTo("achievement_uploads_oldest_unsynced_time");
            softly.assertThat(value.achievementUploadsSyncedInPercentage())
                    .isEqualTo("achievement_uploads_synced_in_percentage");
            softly.assertThat(value.achievementUploadsVerifiedInPercentage())
                    .isEqualTo("achievement_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusAchievement original = GeositesCatalogFixtures.geoSiteStatusAchievement();

        final GitLabGeoSiteStatusAchievement rebuilt =
                GitLabGeoSiteStatusAchievementBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusAchievement.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "achievementUploadsCount",
                        "achievementUploadsChecksumTotalCount",
                        "achievementUploadsChecksummedCount",
                        "achievementUploadsChecksumFailedCount",
                        "achievementUploadsSyncedCount",
                        "achievementUploadsFailedCount",
                        "achievementUploadsRegistryCount",
                        "achievementUploadsVerificationTotalCount",
                        "achievementUploadsVerifiedCount",
                        "achievementUploadsVerificationFailedCount",
                        "achievementUploadsOldestUnsyncedTime",
                        "achievementUploadsSyncedInPercentage",
                        "achievementUploadsVerifiedInPercentage");
    }
}
