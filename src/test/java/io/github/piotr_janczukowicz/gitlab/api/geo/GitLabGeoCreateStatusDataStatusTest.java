package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoCreateStatusDataStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .projectsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.projectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesReplicationEnabledIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesReplicationEnabled(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesReplicationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .lfsObjectsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.lfsObjectsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .mergeRequestDiffsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.mergeRequestDiffsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageFilesVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packageFilesVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packageFilesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesNugetSymbolsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .packagesNugetSymbolsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.packagesNugetSymbolsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .terraformStateVersionsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.terraformStateVersionsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .snippetRepositoriesVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.snippetRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .groupWikiRepositoriesVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.groupWikiRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pipelineArtifactsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pipelineArtifactsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .pagesDeploymentsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.pagesDeploymentsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .uploadsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.uploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .jobArtifactsVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.jobArtifactsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .ciSecureFilesVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.ciSecureFilesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesChecksumTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesChecksummedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesChecksumFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesSyncedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesSyncedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesRegistryCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesRegistryCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesVerificationTotalCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesVerifiedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .containerRepositoriesVerificationFailedCount(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.containerRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitFetchEventCountWeeklyIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .gitFetchEventCountWeekly(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.gitFetchEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitPushEventCountWeeklyIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .gitPushEventCountWeekly(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.gitPushEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProxyRemoteRequestsEventCountWeeklyIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .proxyRemoteRequestsEventCountWeekly(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.proxyRemoteRequestsEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProxyLocalRequestsEventCountWeeklyIsNullable() {
        final GitLabGeoCreateStatusDataStatusBuilder builder = GitLabGeoCreateStatusDataStatusBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusDataStatus())
                .proxyLocalRequestsEventCountWeekly(null);

        final GitLabGeoCreateStatusDataStatus built = builder.build();

        assertThat(built.proxyLocalRequestsEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoCreateStatusDataStatus value = GeoCatalogFixtures.geoCreateStatusDataStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.projectsCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesReplicationEnabled()).isEqualTo(true);
            softly.assertThat(value.lfsObjectsCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsFailedCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.lfsObjectsVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsFailedCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestDiffsVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesSyncedCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesFailedCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesRegistryCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.packageFilesVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsFailedCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsVerificationTotalCount())
                    .isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.packagesNugetSymbolsVerificationFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsFailedCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsVerificationTotalCount())
                    .isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.terraformStateVersionsVerificationFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesSyncedCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesFailedCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesRegistryCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.snippetRepositoriesVerificationFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesSyncedCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesFailedCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesRegistryCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesVerificationTotalCount())
                    .isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.groupWikiRepositoriesVerificationFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsFailedCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.pipelineArtifactsVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsFailedCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.pagesDeploymentsVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.uploadsCount()).isEqualTo(1);
            softly.assertThat(value.uploadsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.uploadsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.uploadsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.uploadsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.uploadsFailedCount()).isEqualTo(1);
            softly.assertThat(value.uploadsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.uploadsVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.uploadsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.uploadsVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsSyncedCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsFailedCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsRegistryCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.jobArtifactsVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesSyncedCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesFailedCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesRegistryCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesVerificationTotalCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.ciSecureFilesVerificationFailedCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesChecksumTotalCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesChecksummedCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesChecksumFailedCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesSyncedCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesFailedCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesRegistryCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesVerificationTotalCount())
                    .isEqualTo(1);
            softly.assertThat(value.containerRepositoriesVerifiedCount()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesVerificationFailedCount())
                    .isEqualTo(1);
            softly.assertThat(value.gitFetchEventCountWeekly()).isEqualTo(1);
            softly.assertThat(value.gitPushEventCountWeekly()).isEqualTo(1);
            softly.assertThat(value.proxyRemoteRequestsEventCountWeekly()).isEqualTo(1);
            softly.assertThat(value.proxyLocalRequestsEventCountWeekly()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoCreateStatusDataStatus original = GeoCatalogFixtures.geoCreateStatusDataStatus();

        final GitLabGeoCreateStatusDataStatus rebuilt =
                GitLabGeoCreateStatusDataStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoCreateStatusDataStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectsCount",
                        "containerRepositoriesReplicationEnabled",
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
                        "mergeRequestDiffsCount",
                        "mergeRequestDiffsChecksumTotalCount",
                        "mergeRequestDiffsChecksummedCount",
                        "mergeRequestDiffsChecksumFailedCount",
                        "mergeRequestDiffsSyncedCount",
                        "mergeRequestDiffsFailedCount",
                        "mergeRequestDiffsRegistryCount",
                        "mergeRequestDiffsVerificationTotalCount",
                        "mergeRequestDiffsVerifiedCount",
                        "mergeRequestDiffsVerificationFailedCount",
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
                        "terraformStateVersionsCount",
                        "terraformStateVersionsChecksumTotalCount",
                        "terraformStateVersionsChecksummedCount",
                        "terraformStateVersionsChecksumFailedCount",
                        "terraformStateVersionsSyncedCount",
                        "terraformStateVersionsFailedCount",
                        "terraformStateVersionsRegistryCount",
                        "terraformStateVersionsVerificationTotalCount",
                        "terraformStateVersionsVerifiedCount",
                        "terraformStateVersionsVerificationFailedCount",
                        "snippetRepositoriesCount",
                        "snippetRepositoriesChecksumTotalCount",
                        "snippetRepositoriesChecksummedCount",
                        "snippetRepositoriesChecksumFailedCount",
                        "snippetRepositoriesSyncedCount",
                        "snippetRepositoriesFailedCount",
                        "snippetRepositoriesRegistryCount",
                        "snippetRepositoriesVerificationTotalCount",
                        "snippetRepositoriesVerifiedCount",
                        "snippetRepositoriesVerificationFailedCount",
                        "groupWikiRepositoriesCount",
                        "groupWikiRepositoriesChecksumTotalCount",
                        "groupWikiRepositoriesChecksummedCount",
                        "groupWikiRepositoriesChecksumFailedCount",
                        "groupWikiRepositoriesSyncedCount",
                        "groupWikiRepositoriesFailedCount",
                        "groupWikiRepositoriesRegistryCount",
                        "groupWikiRepositoriesVerificationTotalCount",
                        "groupWikiRepositoriesVerifiedCount",
                        "groupWikiRepositoriesVerificationFailedCount",
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
                        "pagesDeploymentsCount",
                        "pagesDeploymentsChecksumTotalCount",
                        "pagesDeploymentsChecksummedCount",
                        "pagesDeploymentsChecksumFailedCount",
                        "pagesDeploymentsSyncedCount",
                        "pagesDeploymentsFailedCount",
                        "pagesDeploymentsRegistryCount",
                        "pagesDeploymentsVerificationTotalCount",
                        "pagesDeploymentsVerifiedCount",
                        "pagesDeploymentsVerificationFailedCount",
                        "uploadsCount",
                        "uploadsChecksumTotalCount",
                        "uploadsChecksummedCount",
                        "uploadsChecksumFailedCount",
                        "uploadsSyncedCount",
                        "uploadsFailedCount",
                        "uploadsRegistryCount",
                        "uploadsVerificationTotalCount",
                        "uploadsVerifiedCount",
                        "uploadsVerificationFailedCount",
                        "jobArtifactsCount",
                        "jobArtifactsChecksumTotalCount",
                        "jobArtifactsChecksummedCount",
                        "jobArtifactsChecksumFailedCount",
                        "jobArtifactsSyncedCount",
                        "jobArtifactsFailedCount",
                        "jobArtifactsRegistryCount",
                        "jobArtifactsVerificationTotalCount",
                        "jobArtifactsVerifiedCount",
                        "jobArtifactsVerificationFailedCount",
                        "ciSecureFilesCount",
                        "ciSecureFilesChecksumTotalCount",
                        "ciSecureFilesChecksummedCount",
                        "ciSecureFilesChecksumFailedCount",
                        "ciSecureFilesSyncedCount",
                        "ciSecureFilesFailedCount",
                        "ciSecureFilesRegistryCount",
                        "ciSecureFilesVerificationTotalCount",
                        "ciSecureFilesVerifiedCount",
                        "ciSecureFilesVerificationFailedCount",
                        "containerRepositoriesCount",
                        "containerRepositoriesChecksumTotalCount",
                        "containerRepositoriesChecksummedCount",
                        "containerRepositoriesChecksumFailedCount",
                        "containerRepositoriesSyncedCount",
                        "containerRepositoriesFailedCount",
                        "containerRepositoriesRegistryCount",
                        "containerRepositoriesVerificationTotalCount",
                        "containerRepositoriesVerifiedCount",
                        "containerRepositoriesVerificationFailedCount",
                        "gitFetchEventCountWeekly",
                        "gitPushEventCountWeekly",
                        "proxyRemoteRequestsEventCountWeekly",
                        "proxyLocalRequestsEventCountWeekly");
    }
}
