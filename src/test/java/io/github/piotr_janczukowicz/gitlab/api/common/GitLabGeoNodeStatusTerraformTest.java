package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusTerraformTest {

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsChecksumTotalCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsChecksummedCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsChecksumFailedCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsSyncedCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsFailedCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsFailedCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsRegistryCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsVerificationTotalCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsVerifiedCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsVerificationFailedCount(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsSyncedInPercentage(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateVersionsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusTerraformBuilder builder = GitLabGeoNodeStatusTerraformBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusTerraform())
                .terraformStateVersionsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusTerraform built = builder.build();

        assertThat(built.terraformStateVersionsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusTerraform value = CommonCatalogFixtures.geoNodeStatusTerraform();

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
        final GitLabGeoNodeStatusTerraform original = CommonCatalogFixtures.geoNodeStatusTerraform();

        final GitLabGeoNodeStatusTerraform rebuilt =
                GitLabGeoNodeStatusTerraformBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusTerraform.class.getRecordComponents())
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
