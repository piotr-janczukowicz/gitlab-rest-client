package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusDependencyTest {

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsSyncedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsRegistryCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsSyncedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsRegistryCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsChecksumTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsChecksummedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsChecksumFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsSyncedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsRegistryCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsVerificationTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsVerifiedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsVerificationFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsChecksumTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsChecksummedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsChecksumFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsSyncedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsRegistryCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsVerificationTotalCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsVerifiedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsVerificationFailedCount(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportPartUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportPartUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportPartUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyListExportUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyListExportUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyListExportUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsSyncedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyBlobsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyBlobsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyBlobsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsSyncedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxyManifestsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDependencyBuilder builder = GitLabGeoSiteStatusDependencyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDependency())
                .dependencyProxyManifestsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusDependency built = builder.build();

        assertThat(built.dependencyProxyManifestsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusDependency value = GeositesCatalogFixtures.geoSiteStatusDependency();

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
        final GitLabGeoSiteStatusDependency original = GeositesCatalogFixtures.geoSiteStatusDependency();

        final GitLabGeoSiteStatusDependency rebuilt =
                GitLabGeoSiteStatusDependencyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusDependency.class.getRecordComponents())
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
