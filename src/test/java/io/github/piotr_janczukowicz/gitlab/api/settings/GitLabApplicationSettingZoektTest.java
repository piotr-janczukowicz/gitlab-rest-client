package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingZoektTest {

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingEnabledIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektIndexingEnabled(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektIndexingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektSearchEnabledIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektSearchEnabled(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektSearchEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingPausedIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektIndexingPaused(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektIndexingPaused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektAutoIndexRootNamespaceIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektAutoIndexRootNamespace(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektAutoIndexRootNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektCacheResponseIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektCacheResponse(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektCacheResponse()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektCpuToTasksRatioIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektCpuToTasksRatio(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektCpuToTasksRatio()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektForceReindexingPercentageIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektForceReindexingPercentage(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektForceReindexingPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingParallelismIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektIndexingParallelism(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektIndexingParallelism()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektRolloutBatchSizeIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektRolloutBatchSize(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektRolloutBatchSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektLostNodeThresholdIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektLostNodeThreshold(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektLostNodeThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingTimeoutIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektIndexingTimeout(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektIndexingTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektMaximumFilesIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektMaximumFiles(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektMaximumFiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexedFileSizeLimitIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektIndexedFileSizeLimit(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektIndexedFileSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektTrigramMaxIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektTrigramMax(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektTrigramMax()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektRolloutRetryIntervalIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektRolloutRetryInterval(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektRolloutRetryInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektDefaultNumberOfReplicasIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektDefaultNumberOfReplicas(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektDefaultNumberOfReplicas()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektMaxProjectsForLegacySearchIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektMaxProjectsForLegacySearch(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektMaxProjectsForLegacySearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektMaxRestarts15mIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektMaxRestarts15m(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektMaxRestarts15m()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektInitialIndexingLimitIsNullable() {
        final GitLabApplicationSettingZoektBuilder builder = GitLabApplicationSettingZoektBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingZoekt())
                .zoektInitialIndexingLimit(null);

        final GitLabApplicationSettingZoekt built = builder.build();

        assertThat(built.zoektInitialIndexingLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingZoekt value = SettingsCatalogFixtures.applicationSettingZoekt();

        assertSoftly(softly -> {
            softly.assertThat(value.zoektIndexingEnabled()).isEqualTo("zoekt_indexing_enabled");
            softly.assertThat(value.zoektSearchEnabled()).isEqualTo("zoekt_search_enabled");
            softly.assertThat(value.zoektIndexingPaused()).isEqualTo("zoekt_indexing_paused");
            softly.assertThat(value.zoektAutoIndexRootNamespace()).isEqualTo("zoekt_auto_index_root_namespace");
            softly.assertThat(value.zoektCacheResponse()).isEqualTo("zoekt_cache_response");
            softly.assertThat(value.zoektCpuToTasksRatio()).isEqualTo("zoekt_cpu_to_tasks_ratio");
            softly.assertThat(value.zoektForceReindexingPercentage()).isEqualTo("zoekt_force_reindexing_percentage");
            softly.assertThat(value.zoektIndexingParallelism()).isEqualTo("zoekt_indexing_parallelism");
            softly.assertThat(value.zoektRolloutBatchSize()).isEqualTo("zoekt_rollout_batch_size");
            softly.assertThat(value.zoektLostNodeThreshold()).isEqualTo("zoekt_lost_node_threshold");
            softly.assertThat(value.zoektIndexingTimeout()).isEqualTo("zoekt_indexing_timeout");
            softly.assertThat(value.zoektMaximumFiles()).isEqualTo("zoekt_maximum_files");
            softly.assertThat(value.zoektIndexedFileSizeLimit()).isEqualTo("zoekt_indexed_file_size_limit");
            softly.assertThat(value.zoektTrigramMax()).isEqualTo("zoekt_trigram_max");
            softly.assertThat(value.zoektRolloutRetryInterval()).isEqualTo("zoekt_rollout_retry_interval");
            softly.assertThat(value.zoektDefaultNumberOfReplicas()).isEqualTo("zoekt_default_number_of_replicas");
            softly.assertThat(value.zoektMaxProjectsForLegacySearch())
                    .isEqualTo("zoekt_max_projects_for_legacy_search");
            softly.assertThat(value.zoektMaxRestarts15m()).isEqualTo("zoekt_max_restarts_15m");
            softly.assertThat(value.zoektInitialIndexingLimit()).isEqualTo("zoekt_initial_indexing_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingZoekt original = SettingsCatalogFixtures.applicationSettingZoekt();

        final GitLabApplicationSettingZoekt rebuilt =
                GitLabApplicationSettingZoektBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingZoekt.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "zoektIndexingEnabled",
                        "zoektSearchEnabled",
                        "zoektIndexingPaused",
                        "zoektAutoIndexRootNamespace",
                        "zoektCacheResponse",
                        "zoektCpuToTasksRatio",
                        "zoektForceReindexingPercentage",
                        "zoektIndexingParallelism",
                        "zoektRolloutBatchSize",
                        "zoektLostNodeThreshold",
                        "zoektIndexingTimeout",
                        "zoektMaximumFiles",
                        "zoektIndexedFileSizeLimit",
                        "zoektTrigramMax",
                        "zoektRolloutRetryInterval",
                        "zoektDefaultNumberOfReplicas",
                        "zoektMaxProjectsForLegacySearch",
                        "zoektMaxRestarts15m",
                        "zoektInitialIndexingLimit");
    }
}
