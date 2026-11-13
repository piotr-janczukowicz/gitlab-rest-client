package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusLfsTest {

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsChecksumTotalCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsChecksummedCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsChecksumFailedCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsSyncedCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsFailedCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsFailedCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsRegistryCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsVerificationTotalCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsVerifiedCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsVerificationFailedCount(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsSyncedInPercentage(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusLfsBuilder builder = GitLabGeoSiteStatusLfsBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLfs())
                .lfsObjectsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusLfs built = builder.build();

        assertThat(built.lfsObjectsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusLfs value = GeositesCatalogFixtures.geoSiteStatusLfs();

        assertSoftly(softly -> {
            softly.assertThat(value.lfsObjectsCount()).isEqualTo("lfs_objects_count");
            softly.assertThat(value.lfsObjectsChecksumTotalCount()).isEqualTo("lfs_objects_checksum_total_count");
            softly.assertThat(value.lfsObjectsChecksummedCount()).isEqualTo("lfs_objects_checksummed_count");
            softly.assertThat(value.lfsObjectsChecksumFailedCount()).isEqualTo("lfs_objects_checksum_failed_count");
            softly.assertThat(value.lfsObjectsSyncedCount()).isEqualTo("lfs_objects_synced_count");
            softly.assertThat(value.lfsObjectsFailedCount()).isEqualTo("lfs_objects_failed_count");
            softly.assertThat(value.lfsObjectsRegistryCount()).isEqualTo("lfs_objects_registry_count");
            softly.assertThat(value.lfsObjectsVerificationTotalCount())
                    .isEqualTo("lfs_objects_verification_total_count");
            softly.assertThat(value.lfsObjectsVerifiedCount()).isEqualTo("lfs_objects_verified_count");
            softly.assertThat(value.lfsObjectsVerificationFailedCount())
                    .isEqualTo("lfs_objects_verification_failed_count");
            softly.assertThat(value.lfsObjectsOldestUnsyncedTime()).isEqualTo("lfs_objects_oldest_unsynced_time");
            softly.assertThat(value.lfsObjectsSyncedInPercentage()).isEqualTo("lfs_objects_synced_in_percentage");
            softly.assertThat(value.lfsObjectsVerifiedInPercentage()).isEqualTo("lfs_objects_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusLfs original = GeositesCatalogFixtures.geoSiteStatusLfs();

        final GitLabGeoSiteStatusLfs rebuilt =
                GitLabGeoSiteStatusLfsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusLfs.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "lfsObjectsCount",
                        "lfsObjectsChecksumTotalCount",
                        "lfsObjectsChecksummedCount",
                        "lfsObjectsChecksumFailedCount",
                        "lfsObjectsSyncedCount",
                        "lfsObjectsFailedCount",
                        "lfsObjectsRegistryCount",
                        "lfsObjectsVerificationTotalCount",
                        "lfsObjectsVerifiedCount",
                        "lfsObjectsVerificationFailedCount",
                        "lfsObjectsOldestUnsyncedTime",
                        "lfsObjectsSyncedInPercentage",
                        "lfsObjectsVerifiedInPercentage");
    }
}
