package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsChecksumTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsChecksummedCount())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsChecksumFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsSyncedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsSyncedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsRegistryCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsRegistryCount())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerifiedCount())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsOldestUnsyncedTime())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesChecksumTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesChecksummedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesChecksumFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesSyncedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesRegistryCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesVerificationTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesVerifiedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesVerificationFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsSyncedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsRegistryCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsSyncedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsRegistryCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesChecksumTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesChecksummedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesChecksumFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesSyncedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesRegistryCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesVerificationTotalCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesVerifiedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesVerificationFailedCount(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsSyncedInPercentage())
                .isNull();
    }

    @Test
    void
            constructor_shouldAcceptNull_whenProjectImportExportRelationExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectImportExportRelationExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectImportExportRelationExportUploadUploadsVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesSyncedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectRepositoriesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectTopicUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectTopicUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectTopicUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesSyncedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectWikiRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusProjectBuilder builder = GitLabGeoNodeStatusProjectBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusProject())
                .projectWikiRepositoriesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusProject built = builder.build();

        assertThat(built.projectWikiRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusProject value = CommonCatalogFixtures.geoNodeStatusProject();

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
        final GitLabGeoNodeStatusProject original = CommonCatalogFixtures.geoNodeStatusProject();

        final GitLabGeoNodeStatusProject rebuilt =
                GitLabGeoNodeStatusProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusProject.class.getRecordComponents())
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
