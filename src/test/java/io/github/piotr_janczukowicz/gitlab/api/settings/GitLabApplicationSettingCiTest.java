package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingCiTest {

    @Test
    void constructor_shouldAcceptNull_whenCiDeletePipelinesInSecondsLimitHumanReadableIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciDeletePipelinesInSecondsLimitHumanReadable(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciDeletePipelinesInSecondsLimitHumanReadable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobLiveTraceEnabledIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciJobLiveTraceEnabled(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciJobLiveTraceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTraceUpdateIntervalIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciJobTraceUpdateInterval(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciJobTraceUpdateInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTraceUpdateIntervalWhenBeingWatchedIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciJobTraceUpdateIntervalWhenBeingWatched(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciJobTraceUpdateIntervalWhenBeingWatched()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiLintApiRequireAuthenticationIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciLintApiRequireAuthentication(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciLintApiRequireAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPartitionsInSecondsLimitHumanReadableIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciPartitionsInSecondsLimitHumanReadable(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciPartitionsInSecondsLimitHumanReadable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiLintLimitPerUserIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciLintLimitPerUser(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciLintLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxIncludesIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciMaxIncludes(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciMaxIncludes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxCachesPerJobIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciMaxCachesPerJob(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciMaxCachesPerJob()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxRunnerManagersPerRunnerIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciMaxRunnerManagersPerRunner(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciMaxRunnerManagersPerRunner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRunnerManagerCapDeletionsPerRunIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciRunnerManagerCapDeletionsPerRun(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciRunnerManagerCapDeletionsPerRun()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRunnerManagerCapCleanupBacklogLimitIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciRunnerManagerCapCleanupBacklogLimit(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciRunnerManagerCapCleanupBacklogLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRunnerManagerCreationCeilingIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciRunnerManagerCreationCeiling(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciRunnerManagerCreationCeiling()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxTotalYamlSizeBytesIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciMaxTotalYamlSizeBytes(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciMaxTotalYamlSizeBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiCdCatalogProjectsAllowlistIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciCdCatalogProjectsAllowlist(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciCdCatalogProjectsAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiCdCatalogProjectsAllowlistRawIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciCdCatalogProjectsAllowlistRaw(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciCdCatalogProjectsAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiTelemetryOtelEndpointIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciTelemetryOtelEndpoint(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciTelemetryOtelEndpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTelemetrySamplingRateIsNullable() {
        final GitLabApplicationSettingCiBuilder builder = GitLabApplicationSettingCiBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingCi())
                .ciJobTelemetrySamplingRate(null);

        final GitLabApplicationSettingCi built = builder.build();

        assertThat(built.ciJobTelemetrySamplingRate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingCi value = SettingsCatalogFixtures.applicationSettingCi();

        assertSoftly(softly -> {
            softly.assertThat(value.ciDeletePipelinesInSecondsLimitHumanReadable())
                    .isEqualTo("ci_delete_pipelines_in_seconds_limit_human_readable");
            softly.assertThat(value.ciJobLiveTraceEnabled()).isEqualTo("ci_job_live_trace_enabled");
            softly.assertThat(value.ciJobTraceUpdateInterval()).isEqualTo(1);
            softly.assertThat(value.ciJobTraceUpdateIntervalWhenBeingWatched()).isEqualTo(1);
            softly.assertThat(value.ciLintApiRequireAuthentication()).isEqualTo("ci_lint_api_require_authentication");
            softly.assertThat(value.ciPartitionsInSecondsLimitHumanReadable())
                    .isEqualTo("ci_partitions_in_seconds_limit_human_readable");
            softly.assertThat(value.ciLintLimitPerUser()).isEqualTo("ci_lint_limit_per_user");
            softly.assertThat(value.ciMaxIncludes()).isEqualTo("ci_max_includes");
            softly.assertThat(value.ciMaxCachesPerJob()).isEqualTo("ci_max_caches_per_job");
            softly.assertThat(value.ciMaxRunnerManagersPerRunner()).isEqualTo("ci_max_runner_managers_per_runner");
            softly.assertThat(value.ciRunnerManagerCapDeletionsPerRun())
                    .isEqualTo("ci_runner_manager_cap_deletions_per_run");
            softly.assertThat(value.ciRunnerManagerCapCleanupBacklogLimit())
                    .isEqualTo("ci_runner_manager_cap_cleanup_backlog_limit");
            softly.assertThat(value.ciRunnerManagerCreationCeiling()).isEqualTo("ci_runner_manager_creation_ceiling");
            softly.assertThat(value.ciMaxTotalYamlSizeBytes()).isEqualTo("ci_max_total_yaml_size_bytes");
            softly.assertThat(value.ciCdCatalogProjectsAllowlist()).isEqualTo("ci_cd_catalog_projects_allowlist");
            softly.assertThat(value.ciCdCatalogProjectsAllowlistRaw())
                    .isEqualTo("ci_cd_catalog_projects_allowlist_raw");
            softly.assertThat(value.ciTelemetryOtelEndpoint()).isEqualTo("ci_telemetry_otel_endpoint");
            softly.assertThat(value.ciJobTelemetrySamplingRate()).isEqualTo("ci_job_telemetry_sampling_rate");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingCi original = SettingsCatalogFixtures.applicationSettingCi();

        final GitLabApplicationSettingCi rebuilt =
                GitLabApplicationSettingCiBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingCi.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "ciDeletePipelinesInSecondsLimitHumanReadable",
                        "ciJobLiveTraceEnabled",
                        "ciJobTraceUpdateInterval",
                        "ciJobTraceUpdateIntervalWhenBeingWatched",
                        "ciLintApiRequireAuthentication",
                        "ciPartitionsInSecondsLimitHumanReadable",
                        "ciLintLimitPerUser",
                        "ciMaxIncludes",
                        "ciMaxCachesPerJob",
                        "ciMaxRunnerManagersPerRunner",
                        "ciRunnerManagerCapDeletionsPerRun",
                        "ciRunnerManagerCapCleanupBacklogLimit",
                        "ciRunnerManagerCreationCeiling",
                        "ciMaxTotalYamlSizeBytes",
                        "ciCdCatalogProjectsAllowlist",
                        "ciCdCatalogProjectsAllowlistRaw",
                        "ciTelemetryOtelEndpoint",
                        "ciJobTelemetrySamplingRate");
    }
}
