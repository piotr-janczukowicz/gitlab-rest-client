package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusOrganizationTest {

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsSyncedCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsFailedCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsRegistryCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationDetailUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusOrganizationBuilder builder = GitLabGeoSiteStatusOrganizationBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOrganization())
                .organizationDetailUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusOrganization built = builder.build();

        assertThat(built.organizationDetailUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusOrganization value = GeositesCatalogFixtures.geoSiteStatusOrganization();

        assertSoftly(softly -> {
            softly.assertThat(value.organizationDetailUploadsCount()).isEqualTo("organization_detail_uploads_count");
            softly.assertThat(value.organizationDetailUploadsChecksumTotalCount())
                    .isEqualTo("organization_detail_uploads_checksum_total_count");
            softly.assertThat(value.organizationDetailUploadsChecksummedCount())
                    .isEqualTo("organization_detail_uploads_checksummed_count");
            softly.assertThat(value.organizationDetailUploadsChecksumFailedCount())
                    .isEqualTo("organization_detail_uploads_checksum_failed_count");
            softly.assertThat(value.organizationDetailUploadsSyncedCount())
                    .isEqualTo("organization_detail_uploads_synced_count");
            softly.assertThat(value.organizationDetailUploadsFailedCount())
                    .isEqualTo("organization_detail_uploads_failed_count");
            softly.assertThat(value.organizationDetailUploadsRegistryCount())
                    .isEqualTo("organization_detail_uploads_registry_count");
            softly.assertThat(value.organizationDetailUploadsVerificationTotalCount())
                    .isEqualTo("organization_detail_uploads_verification_total_count");
            softly.assertThat(value.organizationDetailUploadsVerifiedCount())
                    .isEqualTo("organization_detail_uploads_verified_count");
            softly.assertThat(value.organizationDetailUploadsVerificationFailedCount())
                    .isEqualTo("organization_detail_uploads_verification_failed_count");
            softly.assertThat(value.organizationDetailUploadsOldestUnsyncedTime())
                    .isEqualTo("organization_detail_uploads_oldest_unsynced_time");
            softly.assertThat(value.organizationDetailUploadsSyncedInPercentage())
                    .isEqualTo("organization_detail_uploads_synced_in_percentage");
            softly.assertThat(value.organizationDetailUploadsVerifiedInPercentage())
                    .isEqualTo("organization_detail_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusOrganization original = GeositesCatalogFixtures.geoSiteStatusOrganization();

        final GitLabGeoSiteStatusOrganization rebuilt =
                GitLabGeoSiteStatusOrganizationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusOrganization.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "organizationDetailUploadsCount",
                        "organizationDetailUploadsChecksumTotalCount",
                        "organizationDetailUploadsChecksummedCount",
                        "organizationDetailUploadsChecksumFailedCount",
                        "organizationDetailUploadsSyncedCount",
                        "organizationDetailUploadsFailedCount",
                        "organizationDetailUploadsRegistryCount",
                        "organizationDetailUploadsVerificationTotalCount",
                        "organizationDetailUploadsVerifiedCount",
                        "organizationDetailUploadsVerificationFailedCount",
                        "organizationDetailUploadsOldestUnsyncedTime",
                        "organizationDetailUploadsSyncedInPercentage",
                        "organizationDetailUploadsVerifiedInPercentage");
    }
}
