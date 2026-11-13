package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param ciLintLimitPerUser the ci lint limit per user
 * @param ciMaxIncludes the ci max includes
 * @param ciMaxCachesPerJob the ci max caches per job
 * @param ciMaxRunnerManagersPerRunner the ci max runner managers per runner
 * @param ciRunnerManagerCapDeletionsPerRun the ci runner manager cap deletions per run
 * @param ciRunnerManagerCapCleanupBacklogLimit the ci runner manager cap cleanup backlog limit
 * @param ciRunnerManagerCreationCeiling the ci runner manager creation ceiling
 * @param ciLintApiRequireAuthentication the ci lint api require authentication
 * @param ciJobLiveTraceEnabled the ci job live trace enabled
 * @param ciJobTraceUpdateInterval the ci job trace update interval
 * @param ciJobTraceUpdateIntervalWhenBeingWatched the ci job trace update interval when being watched
 * @param ciDeletePipelinesInSecondsLimitHumanReadable the ci delete pipelines in seconds limit human readable
 * @param ciMaxTotalYamlSizeBytes the ci max total yaml size bytes
 * @param ciPartitionsInSecondsLimit the ci partitions in seconds limit
 * @param ciPartitionsInSecondsLimitHumanReadable the ci partitions in seconds limit human readable
 * @param ciTelemetryOtelEndpoint the ci telemetry otel endpoint
 * @param ciJobTelemetrySamplingRate the ci job telemetry sampling rate
 * @param ciCdCatalogProjectsAllowlist the ci cd catalog projects allowlist
 * @param ciCdCatalogProjectsAllowlistRaw the ci cd catalog projects allowlist raw
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateCi(
        @Nullable Integer ciLintLimitPerUser,
        @Nullable Integer ciMaxIncludes,
        @Nullable Integer ciMaxCachesPerJob,
        @Nullable Integer ciMaxRunnerManagersPerRunner,
        @Nullable Integer ciRunnerManagerCapDeletionsPerRun,
        @Nullable Integer ciRunnerManagerCapCleanupBacklogLimit,
        @Nullable Integer ciRunnerManagerCreationCeiling,
        @Nullable Boolean ciLintApiRequireAuthentication,
        @Nullable Boolean ciJobLiveTraceEnabled,
        @Nullable Integer ciJobTraceUpdateInterval,
        @Nullable Integer ciJobTraceUpdateIntervalWhenBeingWatched,
        @Nullable String ciDeletePipelinesInSecondsLimitHumanReadable,
        @Nullable String ciMaxTotalYamlSizeBytes,
        @Nullable String ciPartitionsInSecondsLimit,
        @Nullable String ciPartitionsInSecondsLimitHumanReadable,
        @Nullable String ciTelemetryOtelEndpoint,
        @Nullable Double ciJobTelemetrySamplingRate,
        @Nullable String ciCdCatalogProjectsAllowlist,
        @Nullable String ciCdCatalogProjectsAllowlistRaw) {}
