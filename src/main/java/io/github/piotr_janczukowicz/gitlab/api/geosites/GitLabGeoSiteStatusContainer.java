package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param containerRepositoriesReplicationEnabled the container repositories replication enabled
 * @param containerRepositoriesCount the container repositories count
 * @param containerRepositoriesChecksumTotalCount the container repositories checksum total count
 * @param containerRepositoriesChecksummedCount the container repositories checksummed count
 * @param containerRepositoriesChecksumFailedCount the container repositories checksum failed count
 * @param containerRepositoriesSyncedCount the container repositories synced count
 * @param containerRepositoriesFailedCount the container repositories failed count
 * @param containerRepositoriesRegistryCount the container repositories registry count
 * @param containerRepositoriesVerificationTotalCount the container repositories verification total count
 * @param containerRepositoriesVerifiedCount the container repositories verified count
 * @param containerRepositoriesVerificationFailedCount the container repositories verification failed count
 * @param containerRepositoriesOldestUnsyncedTime the container repositories oldest unsynced time
 * @param containerRepositoriesSyncedInPercentage the container repositories synced in percentage
 * @param containerRepositoriesVerifiedInPercentage the container repositories verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusContainer(
        @Nullable String containerRepositoriesReplicationEnabled,
        @Nullable String containerRepositoriesCount,
        @Nullable String containerRepositoriesChecksumTotalCount,
        @Nullable String containerRepositoriesChecksummedCount,
        @Nullable String containerRepositoriesChecksumFailedCount,
        @Nullable String containerRepositoriesSyncedCount,
        @Nullable String containerRepositoriesFailedCount,
        @Nullable String containerRepositoriesRegistryCount,
        @Nullable String containerRepositoriesVerificationTotalCount,
        @Nullable String containerRepositoriesVerifiedCount,
        @Nullable String containerRepositoriesVerificationFailedCount,
        @Nullable String containerRepositoriesOldestUnsyncedTime,
        @Nullable String containerRepositoriesSyncedInPercentage,
        @Nullable String containerRepositoriesVerifiedInPercentage) {}
