package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusPagesTest {

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsChecksumTotalCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsChecksummedCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsChecksumFailedCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsSyncedCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsFailedCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsFailedCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsRegistryCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsVerificationTotalCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsVerifiedCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsVerificationFailedCount(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsSyncedInPercentage(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPagesBuilder builder = GitLabGeoSiteStatusPagesBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPages())
                .pagesDeploymentsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPages built = builder.build();

        assertThat(built.pagesDeploymentsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusPages value = GeositesCatalogFixtures.geoSiteStatusPages();

        assertSoftly(softly -> {
            softly.assertThat(value.pagesDeploymentsCount()).isEqualTo("pages_deployments_count");
            softly.assertThat(value.pagesDeploymentsChecksumTotalCount())
                    .isEqualTo("pages_deployments_checksum_total_count");
            softly.assertThat(value.pagesDeploymentsChecksummedCount())
                    .isEqualTo("pages_deployments_checksummed_count");
            softly.assertThat(value.pagesDeploymentsChecksumFailedCount())
                    .isEqualTo("pages_deployments_checksum_failed_count");
            softly.assertThat(value.pagesDeploymentsSyncedCount()).isEqualTo("pages_deployments_synced_count");
            softly.assertThat(value.pagesDeploymentsFailedCount()).isEqualTo("pages_deployments_failed_count");
            softly.assertThat(value.pagesDeploymentsRegistryCount()).isEqualTo("pages_deployments_registry_count");
            softly.assertThat(value.pagesDeploymentsVerificationTotalCount())
                    .isEqualTo("pages_deployments_verification_total_count");
            softly.assertThat(value.pagesDeploymentsVerifiedCount()).isEqualTo("pages_deployments_verified_count");
            softly.assertThat(value.pagesDeploymentsVerificationFailedCount())
                    .isEqualTo("pages_deployments_verification_failed_count");
            softly.assertThat(value.pagesDeploymentsOldestUnsyncedTime())
                    .isEqualTo("pages_deployments_oldest_unsynced_time");
            softly.assertThat(value.pagesDeploymentsSyncedInPercentage())
                    .isEqualTo("pages_deployments_synced_in_percentage");
            softly.assertThat(value.pagesDeploymentsVerifiedInPercentage())
                    .isEqualTo("pages_deployments_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusPages original = GeositesCatalogFixtures.geoSiteStatusPages();

        final GitLabGeoSiteStatusPages rebuilt =
                GitLabGeoSiteStatusPagesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusPages.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
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
                        "pagesDeploymentsOldestUnsyncedTime",
                        "pagesDeploymentsSyncedInPercentage",
                        "pagesDeploymentsVerifiedInPercentage");
    }
}
