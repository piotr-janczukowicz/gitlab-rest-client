package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusDesignTest {

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsSyncedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsFailedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsRegistryCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesChecksumTotalCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesChecksummedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesChecksumFailedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesSyncedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesFailedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesFailedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesRegistryCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesVerificationTotalCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesVerifiedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesVerificationFailedCount(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementActionUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesSyncedInPercentage(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusDesignBuilder builder = GitLabGeoNodeStatusDesignBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusDesign())
                .designManagementRepositoriesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusDesign value = CommonCatalogFixtures.geoNodeStatusDesign();

        assertSoftly(softly -> {
            softly.assertThat(value.designManagementActionUploadsCount())
                    .isEqualTo("design_management_action_uploads_count");
            softly.assertThat(value.designManagementActionUploadsChecksumTotalCount())
                    .isEqualTo("design_management_action_uploads_checksum_total_count");
            softly.assertThat(value.designManagementActionUploadsChecksummedCount())
                    .isEqualTo("design_management_action_uploads_checksummed_count");
            softly.assertThat(value.designManagementActionUploadsChecksumFailedCount())
                    .isEqualTo("design_management_action_uploads_checksum_failed_count");
            softly.assertThat(value.designManagementActionUploadsSyncedCount())
                    .isEqualTo("design_management_action_uploads_synced_count");
            softly.assertThat(value.designManagementActionUploadsFailedCount())
                    .isEqualTo("design_management_action_uploads_failed_count");
            softly.assertThat(value.designManagementActionUploadsRegistryCount())
                    .isEqualTo("design_management_action_uploads_registry_count");
            softly.assertThat(value.designManagementActionUploadsVerificationTotalCount())
                    .isEqualTo("design_management_action_uploads_verification_total_count");
            softly.assertThat(value.designManagementActionUploadsVerifiedCount())
                    .isEqualTo("design_management_action_uploads_verified_count");
            softly.assertThat(value.designManagementActionUploadsVerificationFailedCount())
                    .isEqualTo("design_management_action_uploads_verification_failed_count");
            softly.assertThat(value.designManagementActionUploadsOldestUnsyncedTime())
                    .isEqualTo("design_management_action_uploads_oldest_unsynced_time");
            softly.assertThat(value.designManagementRepositoriesCount())
                    .isEqualTo("design_management_repositories_count");
            softly.assertThat(value.designManagementRepositoriesChecksumTotalCount())
                    .isEqualTo("design_management_repositories_checksum_total_count");
            softly.assertThat(value.designManagementRepositoriesChecksummedCount())
                    .isEqualTo("design_management_repositories_checksummed_count");
            softly.assertThat(value.designManagementRepositoriesChecksumFailedCount())
                    .isEqualTo("design_management_repositories_checksum_failed_count");
            softly.assertThat(value.designManagementRepositoriesSyncedCount())
                    .isEqualTo("design_management_repositories_synced_count");
            softly.assertThat(value.designManagementRepositoriesFailedCount())
                    .isEqualTo("design_management_repositories_failed_count");
            softly.assertThat(value.designManagementRepositoriesRegistryCount())
                    .isEqualTo("design_management_repositories_registry_count");
            softly.assertThat(value.designManagementRepositoriesVerificationTotalCount())
                    .isEqualTo("design_management_repositories_verification_total_count");
            softly.assertThat(value.designManagementRepositoriesVerifiedCount())
                    .isEqualTo("design_management_repositories_verified_count");
            softly.assertThat(value.designManagementRepositoriesVerificationFailedCount())
                    .isEqualTo("design_management_repositories_verification_failed_count");
            softly.assertThat(value.designManagementRepositoriesOldestUnsyncedTime())
                    .isEqualTo("design_management_repositories_oldest_unsynced_time");
            softly.assertThat(value.designManagementActionUploadsSyncedInPercentage())
                    .isEqualTo("design_management_action_uploads_synced_in_percentage");
            softly.assertThat(value.designManagementActionUploadsVerifiedInPercentage())
                    .isEqualTo("design_management_action_uploads_verified_in_percentage");
            softly.assertThat(value.designManagementRepositoriesSyncedInPercentage())
                    .isEqualTo("design_management_repositories_synced_in_percentage");
            softly.assertThat(value.designManagementRepositoriesVerifiedInPercentage())
                    .isEqualTo("design_management_repositories_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusDesign original = CommonCatalogFixtures.geoNodeStatusDesign();

        final GitLabGeoNodeStatusDesign rebuilt =
                GitLabGeoNodeStatusDesignBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusDesign.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "designManagementActionUploadsCount",
                        "designManagementActionUploadsChecksumTotalCount",
                        "designManagementActionUploadsChecksummedCount",
                        "designManagementActionUploadsChecksumFailedCount",
                        "designManagementActionUploadsSyncedCount",
                        "designManagementActionUploadsFailedCount",
                        "designManagementActionUploadsRegistryCount",
                        "designManagementActionUploadsVerificationTotalCount",
                        "designManagementActionUploadsVerifiedCount",
                        "designManagementActionUploadsVerificationFailedCount",
                        "designManagementActionUploadsOldestUnsyncedTime",
                        "designManagementRepositoriesCount",
                        "designManagementRepositoriesChecksumTotalCount",
                        "designManagementRepositoriesChecksummedCount",
                        "designManagementRepositoriesChecksumFailedCount",
                        "designManagementRepositoriesSyncedCount",
                        "designManagementRepositoriesFailedCount",
                        "designManagementRepositoriesRegistryCount",
                        "designManagementRepositoriesVerificationTotalCount",
                        "designManagementRepositoriesVerifiedCount",
                        "designManagementRepositoriesVerificationFailedCount",
                        "designManagementRepositoriesOldestUnsyncedTime",
                        "designManagementActionUploadsSyncedInPercentage",
                        "designManagementActionUploadsVerifiedInPercentage",
                        "designManagementRepositoriesSyncedInPercentage",
                        "designManagementRepositoriesVerifiedInPercentage");
    }
}
