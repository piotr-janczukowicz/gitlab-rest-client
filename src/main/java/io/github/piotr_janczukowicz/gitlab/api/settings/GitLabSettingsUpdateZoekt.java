package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param zoektIndexingEnabled the zoekt indexing enabled
 * @param zoektSearchEnabled the zoekt search enabled
 * @param zoektIndexingPaused the zoekt indexing paused
 * @param zoektAutoIndexRootNamespace the zoekt auto index root namespace
 * @param zoektCacheResponse the zoekt cache response
 * @param zoektCpuToTasksRatio the zoekt cpu to tasks ratio
 * @param zoektForceReindexingPercentage the zoekt force reindexing percentage
 * @param zoektIndexingParallelism the zoekt indexing parallelism
 * @param zoektRolloutBatchSize the zoekt rollout batch size
 * @param zoektLostNodeThreshold the zoekt lost node threshold
 * @param zoektIndexingTimeout the zoekt indexing timeout
 * @param zoektMaximumFiles the zoekt maximum files
 * @param zoektIndexedFileSizeLimit the zoekt indexed file size limit
 * @param zoektTrigramMax the zoekt trigram max
 * @param zoektRolloutRetryInterval the zoekt rollout retry interval
 * @param zoektDefaultNumberOfReplicas the zoekt default number of replicas
 * @param zoektMaxProjectsForLegacySearch the zoekt max projects for legacy search
 * @param zoektMaxRestarts15m the zoekt max restarts 15m
 * @param zoektInitialIndexingLimit the zoekt initial indexing limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateZoekt(
        @Nullable String zoektIndexingEnabled,
        @Nullable String zoektSearchEnabled,
        @Nullable String zoektIndexingPaused,
        @Nullable String zoektAutoIndexRootNamespace,
        @Nullable String zoektCacheResponse,
        @Nullable String zoektCpuToTasksRatio,
        @Nullable String zoektForceReindexingPercentage,
        @Nullable String zoektIndexingParallelism,
        @Nullable String zoektRolloutBatchSize,
        @Nullable String zoektLostNodeThreshold,
        @Nullable String zoektIndexingTimeout,
        @Nullable String zoektMaximumFiles,
        @Nullable String zoektIndexedFileSizeLimit,
        @Nullable String zoektTrigramMax,
        @Nullable String zoektRolloutRetryInterval,
        @Nullable String zoektDefaultNumberOfReplicas,
        @Nullable String zoektMaxProjectsForLegacySearch,
        @Nullable @JsonProperty("zoekt_max_restarts_15m") String zoektMaxRestarts15m,
        @Nullable String zoektInitialIndexingLimit) {}
