package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusPackagesTest {

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesChecksumTotalCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesChecksumTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesChecksummedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesChecksumFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesChecksumFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesSyncedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesRegistryCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesVerificationTotalCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesVerifiedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesVerificationFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesOldestUnsyncedTime())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesChecksumTotalCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesChecksummedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesChecksumFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesSyncedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesRegistryCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesVerificationTotalCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesVerifiedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesVerificationFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsChecksumTotalCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsChecksummedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsChecksumFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsSyncedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsRegistryCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsVerificationTotalCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsVerifiedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsVerificationFailedCount(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesSyncedInPercentage(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesSyncedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesDebianProjectComponentFilesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesDebianProjectComponentFilesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesDebianProjectComponentFilesVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesSyncedInPercentage(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesHelmMetadataCachesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesHelmMetadataCachesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesHelmMetadataCachesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsSyncedInPercentage(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusPackagesBuilder builder = GitLabGeoNodeStatusPackagesBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusPackages())
                .packagesNugetSymbolsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusPackages built = builder.build();

        assertThat(built.packagesNugetSymbolsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusPackages value = CommonCatalogFixtures.geoNodeStatusPackages();

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
        final GitLabGeoNodeStatusPackages original = CommonCatalogFixtures.geoNodeStatusPackages();

        final GitLabGeoNodeStatusPackages rebuilt =
                GitLabGeoNodeStatusPackagesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusPackages.class.getRecordComponents())
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
