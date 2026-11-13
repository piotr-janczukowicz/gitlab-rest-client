package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusSupplyTest {

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsChecksumTotalCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsChecksummedCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsChecksumFailedCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsSyncedCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsFailedCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsFailedCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsRegistryCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsVerificationTotalCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsVerifiedCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsVerificationFailedCount(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsSyncedInPercentage(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSupplyChainAttestationsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusSupplyBuilder builder = GitLabGeoSiteStatusSupplyBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSupply())
                .supplyChainAttestationsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusSupply built = builder.build();

        assertThat(built.supplyChainAttestationsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusSupply value = GeositesCatalogFixtures.geoSiteStatusSupply();

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
        final GitLabGeoSiteStatusSupply original = GeositesCatalogFixtures.geoSiteStatusSupply();

        final GitLabGeoSiteStatusSupply rebuilt =
                GitLabGeoSiteStatusSupplyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusSupply.class.getRecordComponents())
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
