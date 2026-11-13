package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusSupplyTest {

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsChecksumTotalCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsChecksummedCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsChecksumFailedCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsSyncedCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsFailedCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsFailedCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsRegistryCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsVerificationTotalCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsVerifiedCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsVerificationFailedCount(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsSyncedInPercentage(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusSupplyBuilder builder = GitLabGeoNodeStatusSupplyBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSupply())
                .supplyChainAttestationsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusSupply value = CommonCatalogFixtures.geoNodeStatusSupply();

        assertSoftly(softly -> {
            softly.assertThat(value.supplyChainAttestationsCount()).isEqualTo("supply_chain_attestations_count");
            softly.assertThat(value.supplyChainAttestationsChecksumTotalCount())
                    .isEqualTo("supply_chain_attestations_checksum_total_count");
            softly.assertThat(value.supplyChainAttestationsChecksummedCount())
                    .isEqualTo("supply_chain_attestations_checksummed_count");
            softly.assertThat(value.supplyChainAttestationsChecksumFailedCount())
                    .isEqualTo("supply_chain_attestations_checksum_failed_count");
            softly.assertThat(value.supplyChainAttestationsSyncedCount())
                    .isEqualTo("supply_chain_attestations_synced_count");
            softly.assertThat(value.supplyChainAttestationsFailedCount())
                    .isEqualTo("supply_chain_attestations_failed_count");
            softly.assertThat(value.supplyChainAttestationsRegistryCount())
                    .isEqualTo("supply_chain_attestations_registry_count");
            softly.assertThat(value.supplyChainAttestationsVerificationTotalCount())
                    .isEqualTo("supply_chain_attestations_verification_total_count");
            softly.assertThat(value.supplyChainAttestationsVerifiedCount())
                    .isEqualTo("supply_chain_attestations_verified_count");
            softly.assertThat(value.supplyChainAttestationsVerificationFailedCount())
                    .isEqualTo("supply_chain_attestations_verification_failed_count");
            softly.assertThat(value.supplyChainAttestationsOldestUnsyncedTime())
                    .isEqualTo("supply_chain_attestations_oldest_unsynced_time");
            softly.assertThat(value.supplyChainAttestationsSyncedInPercentage())
                    .isEqualTo("supply_chain_attestations_synced_in_percentage");
            softly.assertThat(value.supplyChainAttestationsVerifiedInPercentage())
                    .isEqualTo("supply_chain_attestations_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusSupply original = CommonCatalogFixtures.geoNodeStatusSupply();

        final GitLabGeoNodeStatusSupply rebuilt =
                GitLabGeoNodeStatusSupplyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusSupply.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "supplyChainAttestationsCount",
                        "supplyChainAttestationsChecksumTotalCount",
                        "supplyChainAttestationsChecksummedCount",
                        "supplyChainAttestationsChecksumFailedCount",
                        "supplyChainAttestationsSyncedCount",
                        "supplyChainAttestationsFailedCount",
                        "supplyChainAttestationsRegistryCount",
                        "supplyChainAttestationsVerificationTotalCount",
                        "supplyChainAttestationsVerifiedCount",
                        "supplyChainAttestationsVerificationFailedCount",
                        "supplyChainAttestationsOldestUnsyncedTime",
                        "supplyChainAttestationsSyncedInPercentage",
                        "supplyChainAttestationsVerifiedInPercentage");
    }
}
