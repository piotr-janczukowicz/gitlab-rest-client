package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusMergeTest {

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsChecksumTotalCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsChecksummedCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsChecksumFailedCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsSyncedCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsSyncedCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsFailedCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsFailedCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsRegistryCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsRegistryCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsVerificationTotalCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsVerifiedCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsVerificationFailedCount(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsSyncedInPercentage(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffsVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusMergeBuilder builder = GitLabGeoNodeStatusMergeBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusMerge())
                .mergeRequestDiffsVerifiedInPercentage(null);

        final GitLabGeoNodeStatusMerge built = builder.build();

        assertThat(built.mergeRequestDiffsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusMerge value = CommonCatalogFixtures.geoNodeStatusMerge();

        assertSoftly(softly -> {
            softly.assertThat(value.mergeRequestDiffsCount()).isEqualTo("merge_request_diffs_count");
            softly.assertThat(value.mergeRequestDiffsChecksumTotalCount())
                    .isEqualTo("merge_request_diffs_checksum_total_count");
            softly.assertThat(value.mergeRequestDiffsChecksummedCount())
                    .isEqualTo("merge_request_diffs_checksummed_count");
            softly.assertThat(value.mergeRequestDiffsChecksumFailedCount())
                    .isEqualTo("merge_request_diffs_checksum_failed_count");
            softly.assertThat(value.mergeRequestDiffsSyncedCount()).isEqualTo("merge_request_diffs_synced_count");
            softly.assertThat(value.mergeRequestDiffsFailedCount()).isEqualTo("merge_request_diffs_failed_count");
            softly.assertThat(value.mergeRequestDiffsRegistryCount()).isEqualTo("merge_request_diffs_registry_count");
            softly.assertThat(value.mergeRequestDiffsVerificationTotalCount())
                    .isEqualTo("merge_request_diffs_verification_total_count");
            softly.assertThat(value.mergeRequestDiffsVerifiedCount()).isEqualTo("merge_request_diffs_verified_count");
            softly.assertThat(value.mergeRequestDiffsVerificationFailedCount())
                    .isEqualTo("merge_request_diffs_verification_failed_count");
            softly.assertThat(value.mergeRequestDiffsOldestUnsyncedTime())
                    .isEqualTo("merge_request_diffs_oldest_unsynced_time");
            softly.assertThat(value.mergeRequestDiffsSyncedInPercentage())
                    .isEqualTo("merge_request_diffs_synced_in_percentage");
            softly.assertThat(value.mergeRequestDiffsVerifiedInPercentage())
                    .isEqualTo("merge_request_diffs_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusMerge original = CommonCatalogFixtures.geoNodeStatusMerge();

        final GitLabGeoNodeStatusMerge rebuilt =
                GitLabGeoNodeStatusMergeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusMerge.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "mergeRequestDiffsCount",
                        "mergeRequestDiffsChecksumTotalCount",
                        "mergeRequestDiffsChecksummedCount",
                        "mergeRequestDiffsChecksumFailedCount",
                        "mergeRequestDiffsSyncedCount",
                        "mergeRequestDiffsFailedCount",
                        "mergeRequestDiffsRegistryCount",
                        "mergeRequestDiffsVerificationTotalCount",
                        "mergeRequestDiffsVerifiedCount",
                        "mergeRequestDiffsVerificationFailedCount",
                        "mergeRequestDiffsOldestUnsyncedTime",
                        "mergeRequestDiffsSyncedInPercentage",
                        "mergeRequestDiffsVerifiedInPercentage");
    }
}
