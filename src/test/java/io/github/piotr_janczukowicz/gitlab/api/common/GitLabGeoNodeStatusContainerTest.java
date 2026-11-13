package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusContainerTest {

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesReplicationEnabledIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesReplicationEnabled(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesReplicationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesChecksumTotalCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesChecksummedCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesChecksumFailedCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesSyncedCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesFailedCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesFailedCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesRegistryCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesVerificationTotalCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesVerifiedCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesVerificationFailedCount(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesSyncedInPercentage(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusContainerBuilder builder = GitLabGeoNodeStatusContainerBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusContainer())
                .containerRepositoriesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusContainer built = builder.build();

        assertThat(built.containerRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusContainer value = CommonCatalogFixtures.geoNodeStatusContainer();

        assertSoftly(softly -> {
            softly.assertThat(value.containerRepositoriesReplicationEnabled())
                    .isEqualTo("container_repositories_replication_enabled");
            softly.assertThat(value.containerRepositoriesCount()).isEqualTo("container_repositories_count");
            softly.assertThat(value.containerRepositoriesChecksumTotalCount())
                    .isEqualTo("container_repositories_checksum_total_count");
            softly.assertThat(value.containerRepositoriesChecksummedCount())
                    .isEqualTo("container_repositories_checksummed_count");
            softly.assertThat(value.containerRepositoriesChecksumFailedCount())
                    .isEqualTo("container_repositories_checksum_failed_count");
            softly.assertThat(value.containerRepositoriesSyncedCount())
                    .isEqualTo("container_repositories_synced_count");
            softly.assertThat(value.containerRepositoriesFailedCount())
                    .isEqualTo("container_repositories_failed_count");
            softly.assertThat(value.containerRepositoriesRegistryCount())
                    .isEqualTo("container_repositories_registry_count");
            softly.assertThat(value.containerRepositoriesVerificationTotalCount())
                    .isEqualTo("container_repositories_verification_total_count");
            softly.assertThat(value.containerRepositoriesVerifiedCount())
                    .isEqualTo("container_repositories_verified_count");
            softly.assertThat(value.containerRepositoriesVerificationFailedCount())
                    .isEqualTo("container_repositories_verification_failed_count");
            softly.assertThat(value.containerRepositoriesOldestUnsyncedTime())
                    .isEqualTo("container_repositories_oldest_unsynced_time");
            softly.assertThat(value.containerRepositoriesSyncedInPercentage())
                    .isEqualTo("container_repositories_synced_in_percentage");
            softly.assertThat(value.containerRepositoriesVerifiedInPercentage())
                    .isEqualTo("container_repositories_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusContainer original = CommonCatalogFixtures.geoNodeStatusContainer();

        final GitLabGeoNodeStatusContainer rebuilt =
                GitLabGeoNodeStatusContainerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusContainer.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "containerRepositoriesReplicationEnabled",
                        "containerRepositoriesCount",
                        "containerRepositoriesChecksumTotalCount",
                        "containerRepositoriesChecksummedCount",
                        "containerRepositoriesChecksumFailedCount",
                        "containerRepositoriesSyncedCount",
                        "containerRepositoriesFailedCount",
                        "containerRepositoriesRegistryCount",
                        "containerRepositoriesVerificationTotalCount",
                        "containerRepositoriesVerifiedCount",
                        "containerRepositoriesVerificationFailedCount",
                        "containerRepositoriesOldestUnsyncedTime",
                        "containerRepositoriesSyncedInPercentage",
                        "containerRepositoriesVerifiedInPercentage");
    }
}
