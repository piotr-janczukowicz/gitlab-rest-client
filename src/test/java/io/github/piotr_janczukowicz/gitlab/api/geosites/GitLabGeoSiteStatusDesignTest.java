package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusDesignTest {

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsSyncedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsFailedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsRegistryCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesChecksumTotalCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesChecksummedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesChecksumFailedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesSyncedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesFailedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesFailedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesRegistryCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesVerificationTotalCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesVerifiedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesVerificationFailedCount(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementActionUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementActionUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementActionUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesSyncedInPercentage(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDesignManagementRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusDesignBuilder builder = GitLabGeoSiteStatusDesignBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusDesign())
                .designManagementRepositoriesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusDesign built = builder.build();

        assertThat(built.designManagementRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusDesign value = GeositesCatalogFixtures.geoSiteStatusDesign();

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
        final GitLabGeoSiteStatusDesign original = GeositesCatalogFixtures.geoSiteStatusDesign();

        final GitLabGeoSiteStatusDesign rebuilt =
                GitLabGeoSiteStatusDesignBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusDesign.class.getRecordComponents())
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
