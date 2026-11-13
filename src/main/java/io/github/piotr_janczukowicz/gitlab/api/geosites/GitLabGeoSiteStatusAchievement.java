package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param achievementUploadsCount the achievement uploads count
 * @param achievementUploadsChecksumTotalCount the achievement uploads checksum total count
 * @param achievementUploadsChecksummedCount the achievement uploads checksummed count
 * @param achievementUploadsChecksumFailedCount the achievement uploads checksum failed count
 * @param achievementUploadsSyncedCount the achievement uploads synced count
 * @param achievementUploadsFailedCount the achievement uploads failed count
 * @param achievementUploadsRegistryCount the achievement uploads registry count
 * @param achievementUploadsVerificationTotalCount the achievement uploads verification total count
 * @param achievementUploadsVerifiedCount the achievement uploads verified count
 * @param achievementUploadsVerificationFailedCount the achievement uploads verification failed count
 * @param achievementUploadsOldestUnsyncedTime the achievement uploads oldest unsynced time
 * @param achievementUploadsSyncedInPercentage the achievement uploads synced in percentage
 * @param achievementUploadsVerifiedInPercentage the achievement uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusAchievement(
        @Nullable String achievementUploadsCount,
        @Nullable String achievementUploadsChecksumTotalCount,
        @Nullable String achievementUploadsChecksummedCount,
        @Nullable String achievementUploadsChecksumFailedCount,
        @Nullable String achievementUploadsSyncedCount,
        @Nullable String achievementUploadsFailedCount,
        @Nullable String achievementUploadsRegistryCount,
        @Nullable String achievementUploadsVerificationTotalCount,
        @Nullable String achievementUploadsVerifiedCount,
        @Nullable String achievementUploadsVerificationFailedCount,
        @Nullable String achievementUploadsOldestUnsyncedTime,
        @Nullable String achievementUploadsSyncedInPercentage,
        @Nullable String achievementUploadsVerifiedInPercentage) {}
