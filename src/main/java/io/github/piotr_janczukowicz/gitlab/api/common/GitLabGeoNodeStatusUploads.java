package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param uploadsCount the uploads count
 * @param uploadsChecksumTotalCount the uploads checksum total count
 * @param uploadsChecksummedCount the uploads checksummed count
 * @param uploadsChecksumFailedCount the uploads checksum failed count
 * @param uploadsSyncedCount the uploads synced count
 * @param uploadsFailedCount the uploads failed count
 * @param uploadsRegistryCount the uploads registry count
 * @param uploadsVerificationTotalCount the uploads verification total count
 * @param uploadsVerifiedCount the uploads verified count
 * @param uploadsVerificationFailedCount the uploads verification failed count
 * @param uploadsOldestUnsyncedTime the uploads oldest unsynced time
 * @param uploadsSyncedInPercentage the uploads synced in percentage
 * @param uploadsVerifiedInPercentage the uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusUploads(
        @Nullable String uploadsCount,
        @Nullable String uploadsChecksumTotalCount,
        @Nullable String uploadsChecksummedCount,
        @Nullable String uploadsChecksumFailedCount,
        @Nullable String uploadsSyncedCount,
        @Nullable String uploadsFailedCount,
        @Nullable String uploadsRegistryCount,
        @Nullable String uploadsVerificationTotalCount,
        @Nullable String uploadsVerifiedCount,
        @Nullable String uploadsVerificationFailedCount,
        @Nullable String uploadsOldestUnsyncedTime,
        @Nullable String uploadsSyncedInPercentage,
        @Nullable String uploadsVerifiedInPercentage) {}
