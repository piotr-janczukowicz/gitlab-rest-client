package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param jobArtifactsCount the job artifacts count
 * @param jobArtifactsChecksumTotalCount the job artifacts checksum total count
 * @param jobArtifactsChecksummedCount the job artifacts checksummed count
 * @param jobArtifactsChecksumFailedCount the job artifacts checksum failed count
 * @param jobArtifactsSyncedCount the job artifacts synced count
 * @param jobArtifactsFailedCount the job artifacts failed count
 * @param jobArtifactsRegistryCount the job artifacts registry count
 * @param jobArtifactsVerificationTotalCount the job artifacts verification total count
 * @param jobArtifactsVerifiedCount the job artifacts verified count
 * @param jobArtifactsVerificationFailedCount the job artifacts verification failed count
 * @param jobArtifactsOldestUnsyncedTime the job artifacts oldest unsynced time
 * @param jobArtifactsSyncedInPercentage the job artifacts synced in percentage
 * @param jobArtifactsVerifiedInPercentage the job artifacts verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusJob(
        @Nullable String jobArtifactsCount,
        @Nullable String jobArtifactsChecksumTotalCount,
        @Nullable String jobArtifactsChecksummedCount,
        @Nullable String jobArtifactsChecksumFailedCount,
        @Nullable String jobArtifactsSyncedCount,
        @Nullable String jobArtifactsFailedCount,
        @Nullable String jobArtifactsRegistryCount,
        @Nullable String jobArtifactsVerificationTotalCount,
        @Nullable String jobArtifactsVerifiedCount,
        @Nullable String jobArtifactsVerificationFailedCount,
        @Nullable String jobArtifactsOldestUnsyncedTime,
        @Nullable String jobArtifactsSyncedInPercentage,
        @Nullable String jobArtifactsVerifiedInPercentage) {}
