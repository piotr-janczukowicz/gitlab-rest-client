package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusPackageTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesChecksumTotalCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesChecksummedCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesChecksumFailedCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesSyncedCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesFailedCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesRegistryCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesVerificationTotalCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesVerifiedCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesVerificationFailedCount(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesSyncedInPercentage(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackageBuilder builder = GitLabGeoSiteStatusPackageBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackage())
                .packageFilesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPackage built = builder.build();

        assertThat(built.packageFilesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusPackage value = GeositesCatalogFixtures.geoSiteStatusPackage();

        assertSoftly(softly -> {
            softly.assertThat(value.packageFilesCount()).isEqualTo("package_files_count");
            softly.assertThat(value.packageFilesChecksumTotalCount()).isEqualTo("package_files_checksum_total_count");
            softly.assertThat(value.packageFilesChecksummedCount()).isEqualTo("package_files_checksummed_count");
            softly.assertThat(value.packageFilesChecksumFailedCount()).isEqualTo("package_files_checksum_failed_count");
            softly.assertThat(value.packageFilesSyncedCount()).isEqualTo("package_files_synced_count");
            softly.assertThat(value.packageFilesFailedCount()).isEqualTo("package_files_failed_count");
            softly.assertThat(value.packageFilesRegistryCount()).isEqualTo("package_files_registry_count");
            softly.assertThat(value.packageFilesVerificationTotalCount())
                    .isEqualTo("package_files_verification_total_count");
            softly.assertThat(value.packageFilesVerifiedCount()).isEqualTo("package_files_verified_count");
            softly.assertThat(value.packageFilesVerificationFailedCount())
                    .isEqualTo("package_files_verification_failed_count");
            softly.assertThat(value.packageFilesOldestUnsyncedTime()).isEqualTo("package_files_oldest_unsynced_time");
            softly.assertThat(value.packageFilesSyncedInPercentage()).isEqualTo("package_files_synced_in_percentage");
            softly.assertThat(value.packageFilesVerifiedInPercentage())
                    .isEqualTo("package_files_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusPackage original = GeositesCatalogFixtures.geoSiteStatusPackage();

        final GitLabGeoSiteStatusPackage rebuilt =
                GitLabGeoSiteStatusPackageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusPackage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "packageFilesCount",
                        "packageFilesChecksumTotalCount",
                        "packageFilesChecksummedCount",
                        "packageFilesChecksumFailedCount",
                        "packageFilesSyncedCount",
                        "packageFilesFailedCount",
                        "packageFilesRegistryCount",
                        "packageFilesVerificationTotalCount",
                        "packageFilesVerifiedCount",
                        "packageFilesVerificationFailedCount",
                        "packageFilesOldestUnsyncedTime",
                        "packageFilesSyncedInPercentage",
                        "packageFilesVerifiedInPercentage");
    }
}
