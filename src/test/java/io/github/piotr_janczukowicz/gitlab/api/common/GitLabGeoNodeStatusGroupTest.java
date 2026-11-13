package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsChecksumTotalCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsChecksummedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsChecksumFailedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsSyncedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsFailedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsFailedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsRegistryCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsVerificationTotalCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsVerifiedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsVerificationFailedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesChecksumTotalCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesChecksummedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesChecksumFailedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesSyncedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesFailedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesFailedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesRegistryCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesVerificationTotalCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesVerifiedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesVerificationFailedCount(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsSyncedInPercentage(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupUploadsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesSyncedInPercentage(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusGroupBuilder builder = GitLabGeoNodeStatusGroupBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusGroup())
                .groupWikiRepositoriesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusGroup value = CommonCatalogFixtures.geoNodeStatusGroup();

        assertSoftly(softly -> {
            softly.assertThat(value.groupUploadsCount()).isEqualTo("group_uploads_count");
            softly.assertThat(value.groupUploadsChecksumTotalCount()).isEqualTo("group_uploads_checksum_total_count");
            softly.assertThat(value.groupUploadsChecksummedCount()).isEqualTo("group_uploads_checksummed_count");
            softly.assertThat(value.groupUploadsChecksumFailedCount()).isEqualTo("group_uploads_checksum_failed_count");
            softly.assertThat(value.groupUploadsSyncedCount()).isEqualTo("group_uploads_synced_count");
            softly.assertThat(value.groupUploadsFailedCount()).isEqualTo("group_uploads_failed_count");
            softly.assertThat(value.groupUploadsRegistryCount()).isEqualTo("group_uploads_registry_count");
            softly.assertThat(value.groupUploadsVerificationTotalCount())
                    .isEqualTo("group_uploads_verification_total_count");
            softly.assertThat(value.groupUploadsVerifiedCount()).isEqualTo("group_uploads_verified_count");
            softly.assertThat(value.groupUploadsVerificationFailedCount())
                    .isEqualTo("group_uploads_verification_failed_count");
            softly.assertThat(value.groupUploadsOldestUnsyncedTime()).isEqualTo("group_uploads_oldest_unsynced_time");
            softly.assertThat(value.groupWikiRepositoriesCount()).isEqualTo("group_wiki_repositories_count");
            softly.assertThat(value.groupWikiRepositoriesChecksumTotalCount())
                    .isEqualTo("group_wiki_repositories_checksum_total_count");
            softly.assertThat(value.groupWikiRepositoriesChecksummedCount())
                    .isEqualTo("group_wiki_repositories_checksummed_count");
            softly.assertThat(value.groupWikiRepositoriesChecksumFailedCount())
                    .isEqualTo("group_wiki_repositories_checksum_failed_count");
            softly.assertThat(value.groupWikiRepositoriesSyncedCount())
                    .isEqualTo("group_wiki_repositories_synced_count");
            softly.assertThat(value.groupWikiRepositoriesFailedCount())
                    .isEqualTo("group_wiki_repositories_failed_count");
            softly.assertThat(value.groupWikiRepositoriesRegistryCount())
                    .isEqualTo("group_wiki_repositories_registry_count");
            softly.assertThat(value.groupWikiRepositoriesVerificationTotalCount())
                    .isEqualTo("group_wiki_repositories_verification_total_count");
            softly.assertThat(value.groupWikiRepositoriesVerifiedCount())
                    .isEqualTo("group_wiki_repositories_verified_count");
            softly.assertThat(value.groupWikiRepositoriesVerificationFailedCount())
                    .isEqualTo("group_wiki_repositories_verification_failed_count");
            softly.assertThat(value.groupWikiRepositoriesOldestUnsyncedTime())
                    .isEqualTo("group_wiki_repositories_oldest_unsynced_time");
            softly.assertThat(value.groupUploadsSyncedInPercentage()).isEqualTo("group_uploads_synced_in_percentage");
            softly.assertThat(value.groupUploadsVerifiedInPercentage())
                    .isEqualTo("group_uploads_verified_in_percentage");
            softly.assertThat(value.groupWikiRepositoriesSyncedInPercentage())
                    .isEqualTo("group_wiki_repositories_synced_in_percentage");
            softly.assertThat(value.groupWikiRepositoriesVerifiedInPercentage())
                    .isEqualTo("group_wiki_repositories_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusGroup original = CommonCatalogFixtures.geoNodeStatusGroup();

        final GitLabGeoNodeStatusGroup rebuilt =
                GitLabGeoNodeStatusGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "groupUploadsCount",
                        "groupUploadsChecksumTotalCount",
                        "groupUploadsChecksummedCount",
                        "groupUploadsChecksumFailedCount",
                        "groupUploadsSyncedCount",
                        "groupUploadsFailedCount",
                        "groupUploadsRegistryCount",
                        "groupUploadsVerificationTotalCount",
                        "groupUploadsVerifiedCount",
                        "groupUploadsVerificationFailedCount",
                        "groupUploadsOldestUnsyncedTime",
                        "groupWikiRepositoriesCount",
                        "groupWikiRepositoriesChecksumTotalCount",
                        "groupWikiRepositoriesChecksummedCount",
                        "groupWikiRepositoriesChecksumFailedCount",
                        "groupWikiRepositoriesSyncedCount",
                        "groupWikiRepositoriesFailedCount",
                        "groupWikiRepositoriesRegistryCount",
                        "groupWikiRepositoriesVerificationTotalCount",
                        "groupWikiRepositoriesVerifiedCount",
                        "groupWikiRepositoriesVerificationFailedCount",
                        "groupWikiRepositoriesOldestUnsyncedTime",
                        "groupUploadsSyncedInPercentage",
                        "groupUploadsVerifiedInPercentage",
                        "groupWikiRepositoriesSyncedInPercentage",
                        "groupWikiRepositoriesVerifiedInPercentage");
    }
}
