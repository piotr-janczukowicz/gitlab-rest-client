package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param ciDeletePipelinesInSecondsLimitHumanReadable the ci delete pipelines in seconds limit human readable
 * @param ciJobLiveTraceEnabled the ci job live trace enabled
 * @param ciJobTraceUpdateInterval the ci job trace update interval
 * @param ciJobTraceUpdateIntervalWhenBeingWatched the ci job trace update interval when being watched
 * @param ciLintApiRequireAuthentication the ci lint api require authentication
 * @param ciPartitionsInSecondsLimitHumanReadable the ci partitions in seconds limit human readable
 * @param ciLintLimitPerUser the ci lint limit per user
 * @param ciMaxIncludes the ci max includes
 * @param ciMaxCachesPerJob the ci max caches per job
 * @param ciMaxRunnerManagersPerRunner the ci max runner managers per runner
 * @param ciRunnerManagerCapDeletionsPerRun the ci runner manager cap deletions per run
 * @param ciRunnerManagerCapCleanupBacklogLimit the ci runner manager cap cleanup backlog limit
 * @param ciRunnerManagerCreationCeiling the ci runner manager creation ceiling
 * @param ciMaxTotalYamlSizeBytes the ci max total yaml size bytes
 * @param ciCdCatalogProjectsAllowlist the ci cd catalog projects allowlist
 * @param ciCdCatalogProjectsAllowlistRaw the ci cd catalog projects allowlist raw
 * @param ciTelemetryOtelEndpoint the ci telemetry otel endpoint
 * @param ciJobTelemetrySamplingRate the ci job telemetry sampling rate
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingCi(
        @Nullable String ciDeletePipelinesInSecondsLimitHumanReadable,
        @Nullable String ciJobLiveTraceEnabled,
        @Nullable Integer ciJobTraceUpdateInterval,
        @Nullable Integer ciJobTraceUpdateIntervalWhenBeingWatched,
        @Nullable String ciLintApiRequireAuthentication,
        @Nullable String ciPartitionsInSecondsLimitHumanReadable,
        @Nullable String ciLintLimitPerUser,
        @Nullable String ciMaxIncludes,
        @Nullable String ciMaxCachesPerJob,
        @Nullable String ciMaxRunnerManagersPerRunner,
        @Nullable String ciRunnerManagerCapDeletionsPerRun,
        @Nullable String ciRunnerManagerCapCleanupBacklogLimit,
        @Nullable String ciRunnerManagerCreationCeiling,
        @Nullable String ciMaxTotalYamlSizeBytes,
        @Nullable String ciCdCatalogProjectsAllowlist,
        @Nullable String ciCdCatalogProjectsAllowlistRaw,
        @Nullable String ciTelemetryOtelEndpoint,
        @Nullable String ciJobTelemetrySamplingRate) {}
