package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param lfsObjectsCount the lfs objects count
 * @param lfsObjectsChecksumTotalCount the lfs objects checksum total count
 * @param lfsObjectsChecksummedCount the lfs objects checksummed count
 * @param lfsObjectsChecksumFailedCount the lfs objects checksum failed count
 * @param lfsObjectsSyncedCount the lfs objects synced count
 * @param lfsObjectsFailedCount the lfs objects failed count
 * @param lfsObjectsRegistryCount the lfs objects registry count
 * @param lfsObjectsVerificationTotalCount the lfs objects verification total count
 * @param lfsObjectsVerifiedCount the lfs objects verified count
 * @param lfsObjectsVerificationFailedCount the lfs objects verification failed count
 * @param lfsObjectsOldestUnsyncedTime the lfs objects oldest unsynced time
 * @param lfsObjectsSyncedInPercentage the lfs objects synced in percentage
 * @param lfsObjectsVerifiedInPercentage the lfs objects verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusLfs(
        @Nullable String lfsObjectsCount,
        @Nullable String lfsObjectsChecksumTotalCount,
        @Nullable String lfsObjectsChecksummedCount,
        @Nullable String lfsObjectsChecksumFailedCount,
        @Nullable String lfsObjectsSyncedCount,
        @Nullable String lfsObjectsFailedCount,
        @Nullable String lfsObjectsRegistryCount,
        @Nullable String lfsObjectsVerificationTotalCount,
        @Nullable String lfsObjectsVerifiedCount,
        @Nullable String lfsObjectsVerificationFailedCount,
        @Nullable String lfsObjectsOldestUnsyncedTime,
        @Nullable String lfsObjectsSyncedInPercentage,
        @Nullable String lfsObjectsVerifiedInPercentage) {}
