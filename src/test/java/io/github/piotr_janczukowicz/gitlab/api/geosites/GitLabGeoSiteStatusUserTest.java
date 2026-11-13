package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusUserTest {

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsSyncedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsFailedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsRegistryCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerificationTotalCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerificationFailedCount())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsSyncedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsFailedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsRegistryCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserPermissionExportUploadUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userPermissionExportUploadUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userPermissionExportUploadUploadsVerifiedInPercentage())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusUserBuilder builder = GitLabGeoSiteStatusUserBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusUser())
                .userUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusUser built = builder.build();

        assertThat(built.userUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusUser value = GeositesCatalogFixtures.geoSiteStatusUser();

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
        final GitLabGeoSiteStatusUser original = GeositesCatalogFixtures.geoSiteStatusUser();

        final GitLabGeoSiteStatusUser rebuilt =
                GitLabGeoSiteStatusUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusUser.class.getRecordComponents())
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
