package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param appearanceUploadsCount the appearance uploads count
 * @param appearanceUploadsChecksumTotalCount the appearance uploads checksum total count
 * @param appearanceUploadsChecksummedCount the appearance uploads checksummed count
 * @param appearanceUploadsChecksumFailedCount the appearance uploads checksum failed count
 * @param appearanceUploadsSyncedCount the appearance uploads synced count
 * @param appearanceUploadsFailedCount the appearance uploads failed count
 * @param appearanceUploadsRegistryCount the appearance uploads registry count
 * @param appearanceUploadsVerificationTotalCount the appearance uploads verification total count
 * @param appearanceUploadsVerifiedCount the appearance uploads verified count
 * @param appearanceUploadsVerificationFailedCount the appearance uploads verification failed count
 * @param appearanceUploadsOldestUnsyncedTime the appearance uploads oldest unsynced time
 * @param appearanceUploadsSyncedInPercentage the appearance uploads synced in percentage
 * @param appearanceUploadsVerifiedInPercentage the appearance uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusAppearance(
        @Nullable String appearanceUploadsCount,
        @Nullable String appearanceUploadsChecksumTotalCount,
        @Nullable String appearanceUploadsChecksummedCount,
        @Nullable String appearanceUploadsChecksumFailedCount,
        @Nullable String appearanceUploadsSyncedCount,
        @Nullable String appearanceUploadsFailedCount,
        @Nullable String appearanceUploadsRegistryCount,
        @Nullable String appearanceUploadsVerificationTotalCount,
        @Nullable String appearanceUploadsVerifiedCount,
        @Nullable String appearanceUploadsVerificationFailedCount,
        @Nullable String appearanceUploadsOldestUnsyncedTime,
        @Nullable String appearanceUploadsSyncedInPercentage,
        @Nullable String appearanceUploadsVerifiedInPercentage) {}
