package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateZoektTest {

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingEnabledIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektIndexingEnabled(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektIndexingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektSearchEnabledIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektSearchEnabled(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektSearchEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingPausedIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektIndexingPaused(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektIndexingPaused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektAutoIndexRootNamespaceIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektAutoIndexRootNamespace(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektAutoIndexRootNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektCacheResponseIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektCacheResponse(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektCacheResponse()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektCpuToTasksRatioIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektCpuToTasksRatio(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektCpuToTasksRatio()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektForceReindexingPercentageIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektForceReindexingPercentage(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektForceReindexingPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingParallelismIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektIndexingParallelism(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektIndexingParallelism()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektRolloutBatchSizeIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektRolloutBatchSize(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektRolloutBatchSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektLostNodeThresholdIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektLostNodeThreshold(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektLostNodeThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexingTimeoutIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektIndexingTimeout(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektIndexingTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektMaximumFilesIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektMaximumFiles(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektMaximumFiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIndexedFileSizeLimitIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektIndexedFileSizeLimit(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektIndexedFileSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektTrigramMaxIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektTrigramMax(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektTrigramMax()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektRolloutRetryIntervalIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektRolloutRetryInterval(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektRolloutRetryInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektDefaultNumberOfReplicasIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektDefaultNumberOfReplicas(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektDefaultNumberOfReplicas()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektMaxProjectsForLegacySearchIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektMaxProjectsForLegacySearch(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektMaxProjectsForLegacySearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektMaxRestarts15mIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektMaxRestarts15m(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektMaxRestarts15m()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektInitialIndexingLimitIsNullable() {
        final GitLabSettingsUpdateZoektBuilder builder = GitLabSettingsUpdateZoektBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateZoekt())
                .zoektInitialIndexingLimit(null);

        final GitLabSettingsUpdateZoekt built = builder.build();

        assertThat(built.zoektInitialIndexingLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateZoekt value = SettingsCatalogFixtures.settingsUpdateZoekt();

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
        final GitLabSettingsUpdateZoekt original = SettingsCatalogFixtures.settingsUpdateZoekt();

        final GitLabSettingsUpdateZoekt rebuilt =
                GitLabSettingsUpdateZoektBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateZoekt.class.getRecordComponents())
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
