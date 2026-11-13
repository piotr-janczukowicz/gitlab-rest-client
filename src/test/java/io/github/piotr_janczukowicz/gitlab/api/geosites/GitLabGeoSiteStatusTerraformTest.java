package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusTerraformTest {

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsChecksumTotalCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsChecksummedCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsChecksumFailedCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsSyncedCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsFailedCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsFailedCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsRegistryCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsVerificationTotalCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsVerifiedCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsVerificationFailedCount(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsSyncedInPercentage(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusTerraformBuilder builder = GitLabGeoSiteStatusTerraformBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusTerraform())
                .terraformStateVersionsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusTerraform value = GeositesCatalogFixtures.geoSiteStatusTerraform();

        assertSoftly(softly -> {
            softly.assertThat(value.terraformStateVersionsCount()).isEqualTo("terraform_state_versions_count");
            softly.assertThat(value.terraformStateVersionsChecksumTotalCount())
                    .isEqualTo("terraform_state_versions_checksum_total_count");
            softly.assertThat(value.terraformStateVersionsChecksummedCount())
                    .isEqualTo("terraform_state_versions_checksummed_count");
            softly.assertThat(value.terraformStateVersionsChecksumFailedCount())
                    .isEqualTo("terraform_state_versions_checksum_failed_count");
            softly.assertThat(value.terraformStateVersionsSyncedCount())
                    .isEqualTo("terraform_state_versions_synced_count");
            softly.assertThat(value.terraformStateVersionsFailedCount())
                    .isEqualTo("terraform_state_versions_failed_count");
            softly.assertThat(value.terraformStateVersionsRegistryCount())
                    .isEqualTo("terraform_state_versions_registry_count");
            softly.assertThat(value.terraformStateVersionsVerificationTotalCount())
                    .isEqualTo("terraform_state_versions_verification_total_count");
            softly.assertThat(value.terraformStateVersionsVerifiedCount())
                    .isEqualTo("terraform_state_versions_verified_count");
            softly.assertThat(value.terraformStateVersionsVerificationFailedCount())
                    .isEqualTo("terraform_state_versions_verification_failed_count");
            softly.assertThat(value.terraformStateVersionsOldestUnsyncedTime())
                    .isEqualTo("terraform_state_versions_oldest_unsynced_time");
            softly.assertThat(value.terraformStateVersionsSyncedInPercentage())
                    .isEqualTo("terraform_state_versions_synced_in_percentage");
            softly.assertThat(value.terraformStateVersionsVerifiedInPercentage())
                    .isEqualTo("terraform_state_versions_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusTerraform original = GeositesCatalogFixtures.geoSiteStatusTerraform();

        final GitLabGeoSiteStatusTerraform rebuilt =
                GitLabGeoSiteStatusTerraformBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusTerraform.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "terraformStateVersionsCount",
                        "terraformStateVersionsChecksumTotalCount",
                        "terraformStateVersionsChecksummedCount",
                        "terraformStateVersionsChecksumFailedCount",
                        "terraformStateVersionsSyncedCount",
                        "terraformStateVersionsFailedCount",
                        "terraformStateVersionsRegistryCount",
                        "terraformStateVersionsVerificationTotalCount",
                        "terraformStateVersionsVerifiedCount",
                        "terraformStateVersionsVerificationFailedCount",
                        "terraformStateVersionsOldestUnsyncedTime",
                        "terraformStateVersionsSyncedInPercentage",
                        "terraformStateVersionsVerifiedInPercentage");
    }
}
