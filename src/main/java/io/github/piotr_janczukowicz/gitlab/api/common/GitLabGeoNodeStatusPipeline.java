package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param pipelineArtifactsCount the pipeline artifacts count
 * @param pipelineArtifactsChecksumTotalCount the pipeline artifacts checksum total count
 * @param pipelineArtifactsChecksummedCount the pipeline artifacts checksummed count
 * @param pipelineArtifactsChecksumFailedCount the pipeline artifacts checksum failed count
 * @param pipelineArtifactsSyncedCount the pipeline artifacts synced count
 * @param pipelineArtifactsFailedCount the pipeline artifacts failed count
 * @param pipelineArtifactsRegistryCount the pipeline artifacts registry count
 * @param pipelineArtifactsVerificationTotalCount the pipeline artifacts verification total count
 * @param pipelineArtifactsVerifiedCount the pipeline artifacts verified count
 * @param pipelineArtifactsVerificationFailedCount the pipeline artifacts verification failed count
 * @param pipelineArtifactsOldestUnsyncedTime the pipeline artifacts oldest unsynced time
 * @param pipelineArtifactsSyncedInPercentage the pipeline artifacts synced in percentage
 * @param pipelineArtifactsVerifiedInPercentage the pipeline artifacts verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusPipeline(
        @Nullable String pipelineArtifactsCount,
        @Nullable String pipelineArtifactsChecksumTotalCount,
        @Nullable String pipelineArtifactsChecksummedCount,
        @Nullable String pipelineArtifactsChecksumFailedCount,
        @Nullable String pipelineArtifactsSyncedCount,
        @Nullable String pipelineArtifactsFailedCount,
        @Nullable String pipelineArtifactsRegistryCount,
        @Nullable String pipelineArtifactsVerificationTotalCount,
        @Nullable String pipelineArtifactsVerifiedCount,
        @Nullable String pipelineArtifactsVerificationFailedCount,
        @Nullable String pipelineArtifactsOldestUnsyncedTime,
        @Nullable String pipelineArtifactsSyncedInPercentage,
        @Nullable String pipelineArtifactsVerifiedInPercentage) {}
