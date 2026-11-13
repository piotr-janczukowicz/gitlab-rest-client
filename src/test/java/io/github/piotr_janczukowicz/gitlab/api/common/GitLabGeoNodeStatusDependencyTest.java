package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusDependencyTest {

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsSyncedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsRegistryCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsSyncedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsRegistryCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsChecksumTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsChecksummedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsChecksumFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsSyncedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsRegistryCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsVerificationTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsVerifiedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsVerificationFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsChecksumTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsChecksummedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsChecksumFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsSyncedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsRegistryCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsVerificationTotalCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsVerifiedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsVerificationFailedCount(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportPartUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyListExportUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsSyncedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyBlobsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsSyncedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDependencyBuilder builder = GitLabGeoNodeStatusDependencyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDependency())
                .dependencyProxyManifestsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusDependency value = CommonCatalogFixtures.geoNodeStatusDependency();

        assertSoftly(softly -> {
            softly.assertThat(value.dependencyListExportPartUploadsCount())
                    .isEqualTo("dependency_list_export_part_uploads_count");
            softly.assertThat(value.dependencyListExportPartUploadsChecksumTotalCount())
                    .isEqualTo("dependency_list_export_part_uploads_checksum_total_count");
            softly.assertThat(value.dependencyListExportPartUploadsChecksummedCount())
                    .isEqualTo("dependency_list_export_part_uploads_checksummed_count");
            softly.assertThat(value.dependencyListExportPartUploadsChecksumFailedCount())
                    .isEqualTo("dependency_list_export_part_uploads_checksum_failed_count");
            softly.assertThat(value.dependencyListExportPartUploadsSyncedCount())
                    .isEqualTo("dependency_list_export_part_uploads_synced_count");
            softly.assertThat(value.dependencyListExportPartUploadsFailedCount())
                    .isEqualTo("dependency_list_export_part_uploads_failed_count");
            softly.assertThat(value.dependencyListExportPartUploadsRegistryCount())
                    .isEqualTo("dependency_list_export_part_uploads_registry_count");
            softly.assertThat(value.dependencyListExportPartUploadsVerificationTotalCount())
                    .isEqualTo("dependency_list_export_part_uploads_verification_total_count");
            softly.assertThat(value.dependencyListExportPartUploadsVerifiedCount())
                    .isEqualTo("dependency_list_export_part_uploads_verified_count");
            softly.assertThat(value.dependencyListExportPartUploadsVerificationFailedCount())
                    .isEqualTo("dependency_list_export_part_uploads_verification_failed_count");
            softly.assertThat(value.dependencyListExportPartUploadsOldestUnsyncedTime())
                    .isEqualTo("dependency_list_export_part_uploads_oldest_unsynced_time");
            softly.assertThat(value.dependencyListExportUploadsCount())
                    .isEqualTo("dependency_list_export_uploads_count");
            softly.assertThat(value.dependencyListExportUploadsChecksumTotalCount())
                    .isEqualTo("dependency_list_export_uploads_checksum_total_count");
            softly.assertThat(value.dependencyListExportUploadsChecksummedCount())
                    .isEqualTo("dependency_list_export_uploads_checksummed_count");
            softly.assertThat(value.dependencyListExportUploadsChecksumFailedCount())
                    .isEqualTo("dependency_list_export_uploads_checksum_failed_count");
            softly.assertThat(value.dependencyListExportUploadsSyncedCount())
                    .isEqualTo("dependency_list_export_uploads_synced_count");
            softly.assertThat(value.dependencyListExportUploadsFailedCount())
                    .isEqualTo("dependency_list_export_uploads_failed_count");
            softly.assertThat(value.dependencyListExportUploadsRegistryCount())
                    .isEqualTo("dependency_list_export_uploads_registry_count");
            softly.assertThat(value.dependencyListExportUploadsVerificationTotalCount())
                    .isEqualTo("dependency_list_export_uploads_verification_total_count");
            softly.assertThat(value.dependencyListExportUploadsVerifiedCount())
                    .isEqualTo("dependency_list_export_uploads_verified_count");
            softly.assertThat(value.dependencyListExportUploadsVerificationFailedCount())
                    .isEqualTo("dependency_list_export_uploads_verification_failed_count");
            softly.assertThat(value.dependencyListExportUploadsOldestUnsyncedTime())
                    .isEqualTo("dependency_list_export_uploads_oldest_unsynced_time");
            softly.assertThat(value.dependencyProxyBlobsCount()).isEqualTo("dependency_proxy_blobs_count");
            softly.assertThat(value.dependencyProxyBlobsChecksumTotalCount())
                    .isEqualTo("dependency_proxy_blobs_checksum_total_count");
            softly.assertThat(value.dependencyProxyBlobsChecksummedCount())
                    .isEqualTo("dependency_proxy_blobs_checksummed_count");
            softly.assertThat(value.dependencyProxyBlobsChecksumFailedCount())
                    .isEqualTo("dependency_proxy_blobs_checksum_failed_count");
            softly.assertThat(value.dependencyProxyBlobsSyncedCount()).isEqualTo("dependency_proxy_blobs_synced_count");
            softly.assertThat(value.dependencyProxyBlobsFailedCount()).isEqualTo("dependency_proxy_blobs_failed_count");
            softly.assertThat(value.dependencyProxyBlobsRegistryCount())
                    .isEqualTo("dependency_proxy_blobs_registry_count");
            softly.assertThat(value.dependencyProxyBlobsVerificationTotalCount())
                    .isEqualTo("dependency_proxy_blobs_verification_total_count");
            softly.assertThat(value.dependencyProxyBlobsVerifiedCount())
                    .isEqualTo("dependency_proxy_blobs_verified_count");
            softly.assertThat(value.dependencyProxyBlobsVerificationFailedCount())
                    .isEqualTo("dependency_proxy_blobs_verification_failed_count");
            softly.assertThat(value.dependencyProxyBlobsOldestUnsyncedTime())
                    .isEqualTo("dependency_proxy_blobs_oldest_unsynced_time");
            softly.assertThat(value.dependencyProxyManifestsCount()).isEqualTo("dependency_proxy_manifests_count");
            softly.assertThat(value.dependencyProxyManifestsChecksumTotalCount())
                    .isEqualTo("dependency_proxy_manifests_checksum_total_count");
            softly.assertThat(value.dependencyProxyManifestsChecksummedCount())
                    .isEqualTo("dependency_proxy_manifests_checksummed_count");
            softly.assertThat(value.dependencyProxyManifestsChecksumFailedCount())
                    .isEqualTo("dependency_proxy_manifests_checksum_failed_count");
            softly.assertThat(value.dependencyProxyManifestsSyncedCount())
                    .isEqualTo("dependency_proxy_manifests_synced_count");
            softly.assertThat(value.dependencyProxyManifestsFailedCount())
                    .isEqualTo("dependency_proxy_manifests_failed_count");
            softly.assertThat(value.dependencyProxyManifestsRegistryCount())
                    .isEqualTo("dependency_proxy_manifests_registry_count");
            softly.assertThat(value.dependencyProxyManifestsVerificationTotalCount())
                    .isEqualTo("dependency_proxy_manifests_verification_total_count");
            softly.assertThat(value.dependencyProxyManifestsVerifiedCount())
                    .isEqualTo("dependency_proxy_manifests_verified_count");
            softly.assertThat(value.dependencyProxyManifestsVerificationFailedCount())
                    .isEqualTo("dependency_proxy_manifests_verification_failed_count");
            softly.assertThat(value.dependencyProxyManifestsOldestUnsyncedTime())
                    .isEqualTo("dependency_proxy_manifests_oldest_unsynced_time");
            softly.assertThat(value.dependencyListExportPartUploadsSyncedInPercentage())
                    .isEqualTo("dependency_list_export_part_uploads_synced_in_percentage");
            softly.assertThat(value.dependencyListExportPartUploadsVerifiedInPercentage())
                    .isEqualTo("dependency_list_export_part_uploads_verified_in_percentage");
            softly.assertThat(value.dependencyListExportUploadsSyncedInPercentage())
                    .isEqualTo("dependency_list_export_uploads_synced_in_percentage");
            softly.assertThat(value.dependencyListExportUploadsVerifiedInPercentage())
                    .isEqualTo("dependency_list_export_uploads_verified_in_percentage");
            softly.assertThat(value.dependencyProxyBlobsSyncedInPercentage())
                    .isEqualTo("dependency_proxy_blobs_synced_in_percentage");
            softly.assertThat(value.dependencyProxyBlobsVerifiedInPercentage())
                    .isEqualTo("dependency_proxy_blobs_verified_in_percentage");
            softly.assertThat(value.dependencyProxyManifestsSyncedInPercentage())
                    .isEqualTo("dependency_proxy_manifests_synced_in_percentage");
            softly.assertThat(value.dependencyProxyManifestsVerifiedInPercentage())
                    .isEqualTo("dependency_proxy_manifests_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusDependency original = CommonCatalogFixtures.geoNodeStatusDependency();

        final GitLabGeoNodeStatusDependency rebuilt =
                GitLabGeoNodeStatusDependencyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusDependency.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "dependencyListExportPartUploadsCount",
                        "dependencyListExportPartUploadsChecksumTotalCount",
                        "dependencyListExportPartUploadsChecksummedCount",
                        "dependencyListExportPartUploadsChecksumFailedCount",
                        "dependencyListExportPartUploadsSyncedCount",
                        "dependencyListExportPartUploadsFailedCount",
                        "dependencyListExportPartUploadsRegistryCount",
                        "dependencyListExportPartUploadsVerificationTotalCount",
                        "dependencyListExportPartUploadsVerifiedCount",
                        "dependencyListExportPartUploadsVerificationFailedCount",
                        "dependencyListExportPartUploadsOldestUnsyncedTime",
                        "dependencyListExportUploadsCount",
                        "dependencyListExportUploadsChecksumTotalCount",
                        "dependencyListExportUploadsChecksummedCount",
                        "dependencyListExportUploadsChecksumFailedCount",
                        "dependencyListExportUploadsSyncedCount",
                        "dependencyListExportUploadsFailedCount",
                        "dependencyListExportUploadsRegistryCount",
                        "dependencyListExportUploadsVerificationTotalCount",
                        "dependencyListExportUploadsVerifiedCount",
                        "dependencyListExportUploadsVerificationFailedCount",
                        "dependencyListExportUploadsOldestUnsyncedTime",
                        "dependencyProxyBlobsCount",
                        "dependencyProxyBlobsChecksumTotalCount",
                        "dependencyProxyBlobsChecksummedCount",
                        "dependencyProxyBlobsChecksumFailedCount",
                        "dependencyProxyBlobsSyncedCount",
                        "dependencyProxyBlobsFailedCount",
                        "dependencyProxyBlobsRegistryCount",
                        "dependencyProxyBlobsVerificationTotalCount",
                        "dependencyProxyBlobsVerifiedCount",
                        "dependencyProxyBlobsVerificationFailedCount",
                        "dependencyProxyBlobsOldestUnsyncedTime",
                        "dependencyProxyManifestsCount",
                        "dependencyProxyManifestsChecksumTotalCount",
                        "dependencyProxyManifestsChecksummedCount",
                        "dependencyProxyManifestsChecksumFailedCount",
                        "dependencyProxyManifestsSyncedCount",
                        "dependencyProxyManifestsFailedCount",
                        "dependencyProxyManifestsRegistryCount",
                        "dependencyProxyManifestsVerificationTotalCount",
                        "dependencyProxyManifestsVerifiedCount",
                        "dependencyProxyManifestsVerificationFailedCount",
                        "dependencyProxyManifestsOldestUnsyncedTime",
                        "dependencyListExportPartUploadsSyncedInPercentage",
                        "dependencyListExportPartUploadsVerifiedInPercentage",
                        "dependencyListExportUploadsSyncedInPercentage",
                        "dependencyListExportUploadsVerifiedInPercentage",
                        "dependencyProxyBlobsSyncedInPercentage",
                        "dependencyProxyBlobsVerifiedInPercentage",
                        "dependencyProxyManifestsSyncedInPercentage",
                        "dependencyProxyManifestsVerifiedInPercentage");
    }
}
