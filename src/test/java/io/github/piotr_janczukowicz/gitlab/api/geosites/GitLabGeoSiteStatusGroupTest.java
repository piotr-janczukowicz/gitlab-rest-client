package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsSyncedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsFailedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsRegistryCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesChecksumTotalCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesChecksummedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesChecksumFailedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesSyncedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesFailedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesFailedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesRegistryCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesVerificationTotalCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesVerifiedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesVerificationFailedCount(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesSyncedInPercentage(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupWikiRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusGroupBuilder builder = GitLabGeoSiteStatusGroupBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusGroup())
                .groupWikiRepositoriesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusGroup built = builder.build();

        assertThat(built.groupWikiRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusGroup value = GeositesCatalogFixtures.geoSiteStatusGroup();

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
        final GitLabGeoSiteStatusGroup original = GeositesCatalogFixtures.geoSiteStatusGroup();

        final GitLabGeoSiteStatusGroup rebuilt =
                GitLabGeoSiteStatusGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusGroup.class.getRecordComponents())
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
