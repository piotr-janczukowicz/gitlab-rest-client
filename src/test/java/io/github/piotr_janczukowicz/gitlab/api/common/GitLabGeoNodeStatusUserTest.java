package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusUserTest {

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsSyncedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsFailedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsRegistryCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsSyncedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsFailedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsRegistryCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userPermissionExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusUserBuilder builder = GitLabGeoNodeStatusUserBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusUser())
                .userUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusUser built = builder.build();

        assertThat(built.userUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusUser value = CommonCatalogFixtures.geoNodeStatusUser();

        assertSoftly(softly -> {
            softly.assertThat(value.userPermissionExportUploadUploadsCount())
                    .isEqualTo("user_permission_export_upload_uploads_count");
            softly.assertThat(value.userPermissionExportUploadUploadsChecksumTotalCount())
                    .isEqualTo("user_permission_export_upload_uploads_checksum_total_count");
            softly.assertThat(value.userPermissionExportUploadUploadsChecksummedCount())
                    .isEqualTo("user_permission_export_upload_uploads_checksummed_count");
            softly.assertThat(value.userPermissionExportUploadUploadsChecksumFailedCount())
                    .isEqualTo("user_permission_export_upload_uploads_checksum_failed_count");
            softly.assertThat(value.userPermissionExportUploadUploadsSyncedCount())
                    .isEqualTo("user_permission_export_upload_uploads_synced_count");
            softly.assertThat(value.userPermissionExportUploadUploadsFailedCount())
                    .isEqualTo("user_permission_export_upload_uploads_failed_count");
            softly.assertThat(value.userPermissionExportUploadUploadsRegistryCount())
                    .isEqualTo("user_permission_export_upload_uploads_registry_count");
            softly.assertThat(value.userPermissionExportUploadUploadsVerificationTotalCount())
                    .isEqualTo("user_permission_export_upload_uploads_verification_total_count");
            softly.assertThat(value.userPermissionExportUploadUploadsVerifiedCount())
                    .isEqualTo("user_permission_export_upload_uploads_verified_count");
            softly.assertThat(value.userPermissionExportUploadUploadsVerificationFailedCount())
                    .isEqualTo("user_permission_export_upload_uploads_verification_failed_count");
            softly.assertThat(value.userPermissionExportUploadUploadsOldestUnsyncedTime())
                    .isEqualTo("user_permission_export_upload_uploads_oldest_unsynced_time");
            softly.assertThat(value.userUploadsCount()).isEqualTo("user_uploads_count");
            softly.assertThat(value.userUploadsChecksumTotalCount()).isEqualTo("user_uploads_checksum_total_count");
            softly.assertThat(value.userUploadsChecksummedCount()).isEqualTo("user_uploads_checksummed_count");
            softly.assertThat(value.userUploadsChecksumFailedCount()).isEqualTo("user_uploads_checksum_failed_count");
            softly.assertThat(value.userUploadsSyncedCount()).isEqualTo("user_uploads_synced_count");
            softly.assertThat(value.userUploadsFailedCount()).isEqualTo("user_uploads_failed_count");
            softly.assertThat(value.userUploadsRegistryCount()).isEqualTo("user_uploads_registry_count");
            softly.assertThat(value.userUploadsVerificationTotalCount())
                    .isEqualTo("user_uploads_verification_total_count");
            softly.assertThat(value.userUploadsVerifiedCount()).isEqualTo("user_uploads_verified_count");
            softly.assertThat(value.userUploadsVerificationFailedCount())
                    .isEqualTo("user_uploads_verification_failed_count");
            softly.assertThat(value.userUploadsOldestUnsyncedTime()).isEqualTo("user_uploads_oldest_unsynced_time");
            softly.assertThat(value.userPermissionExportUploadUploadsSyncedInPercentage())
                    .isEqualTo("user_permission_export_upload_uploads_synced_in_percentage");
            softly.assertThat(value.userPermissionExportUploadUploadsVerifiedInPercentage())
                    .isEqualTo("user_permission_export_upload_uploads_verified_in_percentage");
            softly.assertThat(value.userUploadsSyncedInPercentage()).isEqualTo("user_uploads_synced_in_percentage");
            softly.assertThat(value.userUploadsVerifiedInPercentage()).isEqualTo("user_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusUser original = CommonCatalogFixtures.geoNodeStatusUser();

        final GitLabGeoNodeStatusUser rebuilt =
                GitLabGeoNodeStatusUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusUser.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "userPermissionExportUploadUploadsCount",
                        "userPermissionExportUploadUploadsChecksumTotalCount",
                        "userPermissionExportUploadUploadsChecksummedCount",
                        "userPermissionExportUploadUploadsChecksumFailedCount",
                        "userPermissionExportUploadUploadsSyncedCount",
                        "userPermissionExportUploadUploadsFailedCount",
                        "userPermissionExportUploadUploadsRegistryCount",
                        "userPermissionExportUploadUploadsVerificationTotalCount",
                        "userPermissionExportUploadUploadsVerifiedCount",
                        "userPermissionExportUploadUploadsVerificationFailedCount",
                        "userPermissionExportUploadUploadsOldestUnsyncedTime",
                        "userUploadsCount",
                        "userUploadsChecksumTotalCount",
                        "userUploadsChecksummedCount",
                        "userUploadsChecksumFailedCount",
                        "userUploadsSyncedCount",
                        "userUploadsFailedCount",
                        "userUploadsRegistryCount",
                        "userUploadsVerificationTotalCount",
                        "userUploadsVerifiedCount",
                        "userUploadsVerificationFailedCount",
                        "userUploadsOldestUnsyncedTime",
                        "userPermissionExportUploadUploadsSyncedInPercentage",
                        "userPermissionExportUploadUploadsVerifiedInPercentage",
                        "userUploadsSyncedInPercentage",
                        "userUploadsVerifiedInPercentage");
    }
}
