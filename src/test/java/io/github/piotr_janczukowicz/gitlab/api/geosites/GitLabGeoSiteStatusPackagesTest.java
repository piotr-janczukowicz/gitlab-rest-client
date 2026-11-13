package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusPackagesTest {

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesChecksumTotalCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesChecksumTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesChecksummedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesChecksumFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesChecksumFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesSyncedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesRegistryCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesVerificationTotalCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesVerifiedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesVerificationFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesOldestUnsyncedTime())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesChecksumTotalCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesChecksummedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesChecksumFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesSyncedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesRegistryCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesVerificationTotalCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesVerifiedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesVerificationFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsChecksumTotalCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsChecksummedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsChecksumFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsSyncedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsRegistryCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsVerificationTotalCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsVerifiedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsVerificationFailedCount(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesSyncedInPercentage(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesSyncedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesDebianProjectComponentFilesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesSyncedInPercentage(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesHelmMetadataCachesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsSyncedInPercentage(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPackagesBuilder builder = GitLabGeoSiteStatusPackagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPackages())
                .packagesNugetSymbolsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusPackages value = GeositesCatalogFixtures.geoSiteStatusPackages();

        assertSoftly(softly -> {
            softly.assertThat(value.packagesDebianProjectComponentFilesCount())
                    .isEqualTo("packages_debian_project_component_files_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesChecksumTotalCount())
                    .isEqualTo("packages_debian_project_component_files_checksum_total_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesChecksummedCount())
                    .isEqualTo("packages_debian_project_component_files_checksummed_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesChecksumFailedCount())
                    .isEqualTo("packages_debian_project_component_files_checksum_failed_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesSyncedCount())
                    .isEqualTo("packages_debian_project_component_files_synced_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesFailedCount())
                    .isEqualTo("packages_debian_project_component_files_failed_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesRegistryCount())
                    .isEqualTo("packages_debian_project_component_files_registry_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesVerificationTotalCount())
                    .isEqualTo("packages_debian_project_component_files_verification_total_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesVerifiedCount())
                    .isEqualTo("packages_debian_project_component_files_verified_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesVerificationFailedCount())
                    .isEqualTo("packages_debian_project_component_files_verification_failed_count");
            softly.assertThat(value.packagesDebianProjectComponentFilesOldestUnsyncedTime())
                    .isEqualTo("packages_debian_project_component_files_oldest_unsynced_time");
            softly.assertThat(value.packagesHelmMetadataCachesCount()).isEqualTo("packages_helm_metadata_caches_count");
            softly.assertThat(value.packagesHelmMetadataCachesChecksumTotalCount())
                    .isEqualTo("packages_helm_metadata_caches_checksum_total_count");
            softly.assertThat(value.packagesHelmMetadataCachesChecksummedCount())
                    .isEqualTo("packages_helm_metadata_caches_checksummed_count");
            softly.assertThat(value.packagesHelmMetadataCachesChecksumFailedCount())
                    .isEqualTo("packages_helm_metadata_caches_checksum_failed_count");
            softly.assertThat(value.packagesHelmMetadataCachesSyncedCount())
                    .isEqualTo("packages_helm_metadata_caches_synced_count");
            softly.assertThat(value.packagesHelmMetadataCachesFailedCount())
                    .isEqualTo("packages_helm_metadata_caches_failed_count");
            softly.assertThat(value.packagesHelmMetadataCachesRegistryCount())
                    .isEqualTo("packages_helm_metadata_caches_registry_count");
            softly.assertThat(value.packagesHelmMetadataCachesVerificationTotalCount())
                    .isEqualTo("packages_helm_metadata_caches_verification_total_count");
            softly.assertThat(value.packagesHelmMetadataCachesVerifiedCount())
                    .isEqualTo("packages_helm_metadata_caches_verified_count");
            softly.assertThat(value.packagesHelmMetadataCachesVerificationFailedCount())
                    .isEqualTo("packages_helm_metadata_caches_verification_failed_count");
            softly.assertThat(value.packagesHelmMetadataCachesOldestUnsyncedTime())
                    .isEqualTo("packages_helm_metadata_caches_oldest_unsynced_time");
            softly.assertThat(value.packagesNugetSymbolsCount()).isEqualTo("packages_nuget_symbols_count");
            softly.assertThat(value.packagesNugetSymbolsChecksumTotalCount())
                    .isEqualTo("packages_nuget_symbols_checksum_total_count");
            softly.assertThat(value.packagesNugetSymbolsChecksummedCount())
                    .isEqualTo("packages_nuget_symbols_checksummed_count");
            softly.assertThat(value.packagesNugetSymbolsChecksumFailedCount())
                    .isEqualTo("packages_nuget_symbols_checksum_failed_count");
            softly.assertThat(value.packagesNugetSymbolsSyncedCount()).isEqualTo("packages_nuget_symbols_synced_count");
            softly.assertThat(value.packagesNugetSymbolsFailedCount()).isEqualTo("packages_nuget_symbols_failed_count");
            softly.assertThat(value.packagesNugetSymbolsRegistryCount())
                    .isEqualTo("packages_nuget_symbols_registry_count");
            softly.assertThat(value.packagesNugetSymbolsVerificationTotalCount())
                    .isEqualTo("packages_nuget_symbols_verification_total_count");
            softly.assertThat(value.packagesNugetSymbolsVerifiedCount())
                    .isEqualTo("packages_nuget_symbols_verified_count");
            softly.assertThat(value.packagesNugetSymbolsVerificationFailedCount())
                    .isEqualTo("packages_nuget_symbols_verification_failed_count");
            softly.assertThat(value.packagesNugetSymbolsOldestUnsyncedTime())
                    .isEqualTo("packages_nuget_symbols_oldest_unsynced_time");
            softly.assertThat(value.packagesDebianProjectComponentFilesSyncedInPercentage())
                    .isEqualTo("packages_debian_project_component_files_synced_in_percentage");
            softly.assertThat(value.packagesDebianProjectComponentFilesVerifiedInPercentage())
                    .isEqualTo("packages_debian_project_component_files_verified_in_percentage");
            softly.assertThat(value.packagesHelmMetadataCachesSyncedInPercentage())
                    .isEqualTo("packages_helm_metadata_caches_synced_in_percentage");
            softly.assertThat(value.packagesHelmMetadataCachesVerifiedInPercentage())
                    .isEqualTo("packages_helm_metadata_caches_verified_in_percentage");
            softly.assertThat(value.packagesNugetSymbolsSyncedInPercentage())
                    .isEqualTo("packages_nuget_symbols_synced_in_percentage");
            softly.assertThat(value.packagesNugetSymbolsVerifiedInPercentage())
                    .isEqualTo("packages_nuget_symbols_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusPackages original = GeositesCatalogFixtures.geoSiteStatusPackages();

        final GitLabGeoSiteStatusPackages rebuilt =
                GitLabGeoSiteStatusPackagesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusPackages.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "packagesDebianProjectComponentFilesCount",
                        "packagesDebianProjectComponentFilesChecksumTotalCount",
                        "packagesDebianProjectComponentFilesChecksummedCount",
                        "packagesDebianProjectComponentFilesChecksumFailedCount",
                        "packagesDebianProjectComponentFilesSyncedCount",
                        "packagesDebianProjectComponentFilesFailedCount",
                        "packagesDebianProjectComponentFilesRegistryCount",
                        "packagesDebianProjectComponentFilesVerificationTotalCount",
                        "packagesDebianProjectComponentFilesVerifiedCount",
                        "packagesDebianProjectComponentFilesVerificationFailedCount",
                        "packagesDebianProjectComponentFilesOldestUnsyncedTime",
                        "packagesHelmMetadataCachesCount",
                        "packagesHelmMetadataCachesChecksumTotalCount",
                        "packagesHelmMetadataCachesChecksummedCount",
                        "packagesHelmMetadataCachesChecksumFailedCount",
                        "packagesHelmMetadataCachesSyncedCount",
                        "packagesHelmMetadataCachesFailedCount",
                        "packagesHelmMetadataCachesRegistryCount",
                        "packagesHelmMetadataCachesVerificationTotalCount",
                        "packagesHelmMetadataCachesVerifiedCount",
                        "packagesHelmMetadataCachesVerificationFailedCount",
                        "packagesHelmMetadataCachesOldestUnsyncedTime",
                        "packagesNugetSymbolsCount",
                        "packagesNugetSymbolsChecksumTotalCount",
                        "packagesNugetSymbolsChecksummedCount",
                        "packagesNugetSymbolsChecksumFailedCount",
                        "packagesNugetSymbolsSyncedCount",
                        "packagesNugetSymbolsFailedCount",
                        "packagesNugetSymbolsRegistryCount",
                        "packagesNugetSymbolsVerificationTotalCount",
                        "packagesNugetSymbolsVerifiedCount",
                        "packagesNugetSymbolsVerificationFailedCount",
                        "packagesNugetSymbolsOldestUnsyncedTime",
                        "packagesDebianProjectComponentFilesSyncedInPercentage",
                        "packagesDebianProjectComponentFilesVerifiedInPercentage",
                        "packagesHelmMetadataCachesSyncedInPercentage",
                        "packagesHelmMetadataCachesVerifiedInPercentage",
                        "packagesNugetSymbolsSyncedInPercentage",
                        "packagesNugetSymbolsVerifiedInPercentage");
    }
}
