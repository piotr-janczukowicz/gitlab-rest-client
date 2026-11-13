package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsChecksumTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsChecksummedCount())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsChecksumFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsSyncedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsSyncedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsRegistryCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsRegistryCount())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerifiedCount())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsOldestUnsyncedTime())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesChecksumTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesChecksummedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesChecksumFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesSyncedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesRegistryCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesVerificationTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesVerifiedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesVerificationFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsSyncedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsRegistryCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsSyncedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsRegistryCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesChecksumTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesChecksummedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesChecksumFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesSyncedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesRegistryCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesVerificationTotalCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesVerifiedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesVerificationFailedCount(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsSyncedInPercentage())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectImportExportRelationExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesSyncedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectRepositoriesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectTopicUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesSyncedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusProjectBuilder builder = GitLabGeoSiteStatusProjectBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusProject())
                .projectWikiRepositoriesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusProject value = GeositesCatalogFixtures.geoSiteStatusProject();

        assertSoftly(softly -> {
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsChecksumTotalCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_checksum_total_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsChecksummedCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_checksummed_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsChecksumFailedCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_checksum_failed_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsSyncedCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_synced_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsFailedCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_failed_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsRegistryCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_registry_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsVerificationTotalCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_verification_total_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsVerifiedCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_verified_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsVerificationFailedCount())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_verification_failed_count");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsOldestUnsyncedTime())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_oldest_unsynced_time");
            softly.assertThat(value.projectRepositoriesCount()).isEqualTo("project_repositories_count");
            softly.assertThat(value.projectRepositoriesChecksumTotalCount())
                    .isEqualTo("project_repositories_checksum_total_count");
            softly.assertThat(value.projectRepositoriesChecksummedCount())
                    .isEqualTo("project_repositories_checksummed_count");
            softly.assertThat(value.projectRepositoriesChecksumFailedCount())
                    .isEqualTo("project_repositories_checksum_failed_count");
            softly.assertThat(value.projectRepositoriesSyncedCount()).isEqualTo("project_repositories_synced_count");
            softly.assertThat(value.projectRepositoriesFailedCount()).isEqualTo("project_repositories_failed_count");
            softly.assertThat(value.projectRepositoriesRegistryCount())
                    .isEqualTo("project_repositories_registry_count");
            softly.assertThat(value.projectRepositoriesVerificationTotalCount())
                    .isEqualTo("project_repositories_verification_total_count");
            softly.assertThat(value.projectRepositoriesVerifiedCount())
                    .isEqualTo("project_repositories_verified_count");
            softly.assertThat(value.projectRepositoriesVerificationFailedCount())
                    .isEqualTo("project_repositories_verification_failed_count");
            softly.assertThat(value.projectRepositoriesOldestUnsyncedTime())
                    .isEqualTo("project_repositories_oldest_unsynced_time");
            softly.assertThat(value.projectTopicUploadsCount()).isEqualTo("project_topic_uploads_count");
            softly.assertThat(value.projectTopicUploadsChecksumTotalCount())
                    .isEqualTo("project_topic_uploads_checksum_total_count");
            softly.assertThat(value.projectTopicUploadsChecksummedCount())
                    .isEqualTo("project_topic_uploads_checksummed_count");
            softly.assertThat(value.projectTopicUploadsChecksumFailedCount())
                    .isEqualTo("project_topic_uploads_checksum_failed_count");
            softly.assertThat(value.projectTopicUploadsSyncedCount()).isEqualTo("project_topic_uploads_synced_count");
            softly.assertThat(value.projectTopicUploadsFailedCount()).isEqualTo("project_topic_uploads_failed_count");
            softly.assertThat(value.projectTopicUploadsRegistryCount())
                    .isEqualTo("project_topic_uploads_registry_count");
            softly.assertThat(value.projectTopicUploadsVerificationTotalCount())
                    .isEqualTo("project_topic_uploads_verification_total_count");
            softly.assertThat(value.projectTopicUploadsVerifiedCount())
                    .isEqualTo("project_topic_uploads_verified_count");
            softly.assertThat(value.projectTopicUploadsVerificationFailedCount())
                    .isEqualTo("project_topic_uploads_verification_failed_count");
            softly.assertThat(value.projectTopicUploadsOldestUnsyncedTime())
                    .isEqualTo("project_topic_uploads_oldest_unsynced_time");
            softly.assertThat(value.projectUploadsCount()).isEqualTo("project_uploads_count");
            softly.assertThat(value.projectUploadsChecksumTotalCount())
                    .isEqualTo("project_uploads_checksum_total_count");
            softly.assertThat(value.projectUploadsChecksummedCount()).isEqualTo("project_uploads_checksummed_count");
            softly.assertThat(value.projectUploadsChecksumFailedCount())
                    .isEqualTo("project_uploads_checksum_failed_count");
            softly.assertThat(value.projectUploadsSyncedCount()).isEqualTo("project_uploads_synced_count");
            softly.assertThat(value.projectUploadsFailedCount()).isEqualTo("project_uploads_failed_count");
            softly.assertThat(value.projectUploadsRegistryCount()).isEqualTo("project_uploads_registry_count");
            softly.assertThat(value.projectUploadsVerificationTotalCount())
                    .isEqualTo("project_uploads_verification_total_count");
            softly.assertThat(value.projectUploadsVerifiedCount()).isEqualTo("project_uploads_verified_count");
            softly.assertThat(value.projectUploadsVerificationFailedCount())
                    .isEqualTo("project_uploads_verification_failed_count");
            softly.assertThat(value.projectUploadsOldestUnsyncedTime())
                    .isEqualTo("project_uploads_oldest_unsynced_time");
            softly.assertThat(value.projectWikiRepositoriesCount()).isEqualTo("project_wiki_repositories_count");
            softly.assertThat(value.projectWikiRepositoriesChecksumTotalCount())
                    .isEqualTo("project_wiki_repositories_checksum_total_count");
            softly.assertThat(value.projectWikiRepositoriesChecksummedCount())
                    .isEqualTo("project_wiki_repositories_checksummed_count");
            softly.assertThat(value.projectWikiRepositoriesChecksumFailedCount())
                    .isEqualTo("project_wiki_repositories_checksum_failed_count");
            softly.assertThat(value.projectWikiRepositoriesSyncedCount())
                    .isEqualTo("project_wiki_repositories_synced_count");
            softly.assertThat(value.projectWikiRepositoriesFailedCount())
                    .isEqualTo("project_wiki_repositories_failed_count");
            softly.assertThat(value.projectWikiRepositoriesRegistryCount())
                    .isEqualTo("project_wiki_repositories_registry_count");
            softly.assertThat(value.projectWikiRepositoriesVerificationTotalCount())
                    .isEqualTo("project_wiki_repositories_verification_total_count");
            softly.assertThat(value.projectWikiRepositoriesVerifiedCount())
                    .isEqualTo("project_wiki_repositories_verified_count");
            softly.assertThat(value.projectWikiRepositoriesVerificationFailedCount())
                    .isEqualTo("project_wiki_repositories_verification_failed_count");
            softly.assertThat(value.projectWikiRepositoriesOldestUnsyncedTime())
                    .isEqualTo("project_wiki_repositories_oldest_unsynced_time");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsSyncedInPercentage())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_synced_in_percentage");
            softly.assertThat(value.projectImportExportRelationExportUploadUploadsVerifiedInPercentage())
                    .isEqualTo("project_import_export_relation_export_upload_uploads_verified_in_percentage");
            softly.assertThat(value.projectRepositoriesSyncedInPercentage())
                    .isEqualTo("project_repositories_synced_in_percentage");
            softly.assertThat(value.projectRepositoriesVerifiedInPercentage())
                    .isEqualTo("project_repositories_verified_in_percentage");
            softly.assertThat(value.projectTopicUploadsSyncedInPercentage())
                    .isEqualTo("project_topic_uploads_synced_in_percentage");
            softly.assertThat(value.projectTopicUploadsVerifiedInPercentage())
                    .isEqualTo("project_topic_uploads_verified_in_percentage");
            softly.assertThat(value.projectUploadsSyncedInPercentage())
                    .isEqualTo("project_uploads_synced_in_percentage");
            softly.assertThat(value.projectUploadsVerifiedInPercentage())
                    .isEqualTo("project_uploads_verified_in_percentage");
            softly.assertThat(value.projectWikiRepositoriesSyncedInPercentage())
                    .isEqualTo("project_wiki_repositories_synced_in_percentage");
            softly.assertThat(value.projectWikiRepositoriesVerifiedInPercentage())
                    .isEqualTo("project_wiki_repositories_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusProject original = GeositesCatalogFixtures.geoSiteStatusProject();

        final GitLabGeoSiteStatusProject rebuilt =
                GitLabGeoSiteStatusProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectImportExportRelationExportUploadUploadsCount",
                        "projectImportExportRelationExportUploadUploadsChecksumTotalCount",
                        "projectImportExportRelationExportUploadUploadsChecksummedCount",
                        "projectImportExportRelationExportUploadUploadsChecksumFailedCount",
                        "projectImportExportRelationExportUploadUploadsSyncedCount",
                        "projectImportExportRelationExportUploadUploadsFailedCount",
                        "projectImportExportRelationExportUploadUploadsRegistryCount",
                        "projectImportExportRelationExportUploadUploadsVerificationTotalCount",
                        "projectImportExportRelationExportUploadUploadsVerifiedCount",
                        "projectImportExportRelationExportUploadUploadsVerificationFailedCount",
                        "projectImportExportRelationExportUploadUploadsOldestUnsyncedTime",
                        "projectRepositoriesCount",
                        "projectRepositoriesChecksumTotalCount",
                        "projectRepositoriesChecksummedCount",
                        "projectRepositoriesChecksumFailedCount",
                        "projectRepositoriesSyncedCount",
                        "projectRepositoriesFailedCount",
                        "projectRepositoriesRegistryCount",
                        "projectRepositoriesVerificationTotalCount",
                        "projectRepositoriesVerifiedCount",
                        "projectRepositoriesVerificationFailedCount",
                        "projectRepositoriesOldestUnsyncedTime",
                        "projectTopicUploadsCount",
                        "projectTopicUploadsChecksumTotalCount",
                        "projectTopicUploadsChecksummedCount",
                        "projectTopicUploadsChecksumFailedCount",
                        "projectTopicUploadsSyncedCount",
                        "projectTopicUploadsFailedCount",
                        "projectTopicUploadsRegistryCount",
                        "projectTopicUploadsVerificationTotalCount",
                        "projectTopicUploadsVerifiedCount",
                        "projectTopicUploadsVerificationFailedCount",
                        "projectTopicUploadsOldestUnsyncedTime",
                        "projectUploadsCount",
                        "projectUploadsChecksumTotalCount",
                        "projectUploadsChecksummedCount",
                        "projectUploadsChecksumFailedCount",
                        "projectUploadsSyncedCount",
                        "projectUploadsFailedCount",
                        "projectUploadsRegistryCount",
                        "projectUploadsVerificationTotalCount",
                        "projectUploadsVerifiedCount",
                        "projectUploadsVerificationFailedCount",
                        "projectUploadsOldestUnsyncedTime",
                        "projectWikiRepositoriesCount",
                        "projectWikiRepositoriesChecksumTotalCount",
                        "projectWikiRepositoriesChecksummedCount",
                        "projectWikiRepositoriesChecksumFailedCount",
                        "projectWikiRepositoriesSyncedCount",
                        "projectWikiRepositoriesFailedCount",
                        "projectWikiRepositoriesRegistryCount",
                        "projectWikiRepositoriesVerificationTotalCount",
                        "projectWikiRepositoriesVerifiedCount",
                        "projectWikiRepositoriesVerificationFailedCount",
                        "projectWikiRepositoriesOldestUnsyncedTime",
                        "projectImportExportRelationExportUploadUploadsSyncedInPercentage",
                        "projectImportExportRelationExportUploadUploadsVerifiedInPercentage",
                        "projectRepositoriesSyncedInPercentage",
                        "projectRepositoriesVerifiedInPercentage",
                        "projectTopicUploadsSyncedInPercentage",
                        "projectTopicUploadsVerifiedInPercentage",
                        "projectUploadsSyncedInPercentage",
                        "projectUploadsVerifiedInPercentage",
                        "projectWikiRepositoriesSyncedInPercentage",
                        "projectWikiRepositoriesVerifiedInPercentage");
    }
}
