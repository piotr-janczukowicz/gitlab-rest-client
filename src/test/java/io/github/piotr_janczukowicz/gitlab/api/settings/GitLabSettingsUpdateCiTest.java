package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateCiTest {

    @Test
    void constructor_shouldAcceptNull_whenCiLintLimitPerUserIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciLintLimitPerUser(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciLintLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxIncludesIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciMaxIncludes(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciMaxIncludes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxCachesPerJobIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciMaxCachesPerJob(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciMaxCachesPerJob()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxRunnerManagersPerRunnerIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciMaxRunnerManagersPerRunner(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciMaxRunnerManagersPerRunner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRunnerManagerCapDeletionsPerRunIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciRunnerManagerCapDeletionsPerRun(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciRunnerManagerCapDeletionsPerRun()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRunnerManagerCapCleanupBacklogLimitIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciRunnerManagerCapCleanupBacklogLimit(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciRunnerManagerCapCleanupBacklogLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRunnerManagerCreationCeilingIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciRunnerManagerCreationCeiling(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciRunnerManagerCreationCeiling()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiLintApiRequireAuthenticationIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciLintApiRequireAuthentication(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciLintApiRequireAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobLiveTraceEnabledIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciJobLiveTraceEnabled(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciJobLiveTraceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTraceUpdateIntervalIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciJobTraceUpdateInterval(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciJobTraceUpdateInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTraceUpdateIntervalWhenBeingWatchedIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciJobTraceUpdateIntervalWhenBeingWatched(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciJobTraceUpdateIntervalWhenBeingWatched()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDeletePipelinesInSecondsLimitHumanReadableIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciDeletePipelinesInSecondsLimitHumanReadable(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciDeletePipelinesInSecondsLimitHumanReadable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMaxTotalYamlSizeBytesIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciMaxTotalYamlSizeBytes(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciMaxTotalYamlSizeBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPartitionsInSecondsLimitIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciPartitionsInSecondsLimit(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciPartitionsInSecondsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPartitionsInSecondsLimitHumanReadableIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciPartitionsInSecondsLimitHumanReadable(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciPartitionsInSecondsLimitHumanReadable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiTelemetryOtelEndpointIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciTelemetryOtelEndpoint(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciTelemetryOtelEndpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTelemetrySamplingRateIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciJobTelemetrySamplingRate(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciJobTelemetrySamplingRate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiCdCatalogProjectsAllowlistIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciCdCatalogProjectsAllowlist(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciCdCatalogProjectsAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiCdCatalogProjectsAllowlistRawIsNullable() {
        final GitLabSettingsUpdateCiBuilder builder = GitLabSettingsUpdateCiBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateCi())
                .ciCdCatalogProjectsAllowlistRaw(null);

        final GitLabSettingsUpdateCi built = builder.build();

        assertThat(built.ciCdCatalogProjectsAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateCi value = SettingsCatalogFixtures.settingsUpdateCi();

        assertSoftly(softly -> {
            softly.assertThat(value.ciLintLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.ciMaxIncludes()).isEqualTo(1);
            softly.assertThat(value.ciMaxCachesPerJob()).isEqualTo(1);
            softly.assertThat(value.ciMaxRunnerManagersPerRunner()).isEqualTo(1);
            softly.assertThat(value.ciRunnerManagerCapDeletionsPerRun()).isEqualTo(1);
            softly.assertThat(value.ciRunnerManagerCapCleanupBacklogLimit()).isEqualTo(1);
            softly.assertThat(value.ciRunnerManagerCreationCeiling()).isEqualTo(1);
            softly.assertThat(value.ciLintApiRequireAuthentication()).isEqualTo(true);
            softly.assertThat(value.ciJobLiveTraceEnabled()).isEqualTo(true);
            softly.assertThat(value.ciJobTraceUpdateInterval()).isEqualTo(1);
            softly.assertThat(value.ciJobTraceUpdateIntervalWhenBeingWatched()).isEqualTo(1);
            softly.assertThat(value.ciDeletePipelinesInSecondsLimitHumanReadable())
                    .isEqualTo("ci_delete_pipelines_in_seconds_limit_human_readable");
            softly.assertThat(value.ciMaxTotalYamlSizeBytes()).isEqualTo("ci_max_total_yaml_size_bytes");
            softly.assertThat(value.ciPartitionsInSecondsLimit()).isEqualTo("ci_partitions_in_seconds_limit");
            softly.assertThat(value.ciPartitionsInSecondsLimitHumanReadable())
                    .isEqualTo("ci_partitions_in_seconds_limit_human_readable");
            softly.assertThat(value.ciTelemetryOtelEndpoint()).isEqualTo("ci_telemetry_otel_endpoint");
            softly.assertThat(value.ciJobTelemetrySamplingRate()).isEqualTo(1.5);
            softly.assertThat(value.ciCdCatalogProjectsAllowlist()).isEqualTo("ci_cd_catalog_projects_allowlist");
            softly.assertThat(value.ciCdCatalogProjectsAllowlistRaw())
                    .isEqualTo("ci_cd_catalog_projects_allowlist_raw");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateCi original = SettingsCatalogFixtures.settingsUpdateCi();

        final GitLabSettingsUpdateCi rebuilt =
                GitLabSettingsUpdateCiBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateCi.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "ciLintLimitPerUser",
                        "ciMaxIncludes",
                        "ciMaxCachesPerJob",
                        "ciMaxRunnerManagersPerRunner",
                        "ciRunnerManagerCapDeletionsPerRun",
                        "ciRunnerManagerCapCleanupBacklogLimit",
                        "ciRunnerManagerCreationCeiling",
                        "ciLintApiRequireAuthentication",
                        "ciJobLiveTraceEnabled",
                        "ciJobTraceUpdateInterval",
                        "ciJobTraceUpdateIntervalWhenBeingWatched",
                        "ciDeletePipelinesInSecondsLimitHumanReadable",
                        "ciMaxTotalYamlSizeBytes",
                        "ciPartitionsInSecondsLimit",
                        "ciPartitionsInSecondsLimitHumanReadable",
                        "ciTelemetryOtelEndpoint",
                        "ciJobTelemetrySamplingRate",
                        "ciCdCatalogProjectsAllowlist",
                        "ciCdCatalogProjectsAllowlistRaw");
    }
}
