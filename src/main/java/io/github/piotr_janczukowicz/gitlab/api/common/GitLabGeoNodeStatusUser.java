package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param userPermissionExportUploadUploadsCount the user permission export upload uploads count
 * @param userPermissionExportUploadUploadsChecksumTotalCount the user permission export upload uploads checksum total
 *     count
 * @param userPermissionExportUploadUploadsChecksummedCount the user permission export upload uploads checksummed count
 * @param userPermissionExportUploadUploadsChecksumFailedCount the user permission export upload uploads checksum failed
 *     count
 * @param userPermissionExportUploadUploadsSyncedCount the user permission export upload uploads synced count
 * @param userPermissionExportUploadUploadsFailedCount the user permission export upload uploads failed count
 * @param userPermissionExportUploadUploadsRegistryCount the user permission export upload uploads registry count
 * @param userPermissionExportUploadUploadsVerificationTotalCount the user permission export upload uploads verification
 *     total count
 * @param userPermissionExportUploadUploadsVerifiedCount the user permission export upload uploads verified count
 * @param userPermissionExportUploadUploadsVerificationFailedCount the user permission export upload uploads
 *     verification failed count
 * @param userPermissionExportUploadUploadsOldestUnsyncedTime the user permission export upload uploads oldest unsynced
 *     time
 * @param userUploadsCount the user uploads count
 * @param userUploadsChecksumTotalCount the user uploads checksum total count
 * @param userUploadsChecksummedCount the user uploads checksummed count
 * @param userUploadsChecksumFailedCount the user uploads checksum failed count
 * @param userUploadsSyncedCount the user uploads synced count
 * @param userUploadsFailedCount the user uploads failed count
 * @param userUploadsRegistryCount the user uploads registry count
 * @param userUploadsVerificationTotalCount the user uploads verification total count
 * @param userUploadsVerifiedCount the user uploads verified count
 * @param userUploadsVerificationFailedCount the user uploads verification failed count
 * @param userUploadsOldestUnsyncedTime the user uploads oldest unsynced time
 * @param userPermissionExportUploadUploadsSyncedInPercentage the user permission export upload uploads synced in
 *     percentage
 * @param userPermissionExportUploadUploadsVerifiedInPercentage the user permission export upload uploads verified in
 *     percentage
 * @param userUploadsSyncedInPercentage the user uploads synced in percentage
 * @param userUploadsVerifiedInPercentage the user uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusUser(
        @Nullable String userPermissionExportUploadUploadsCount,
        @Nullable String userPermissionExportUploadUploadsChecksumTotalCount,
        @Nullable String userPermissionExportUploadUploadsChecksummedCount,
        @Nullable String userPermissionExportUploadUploadsChecksumFailedCount,
        @Nullable String userPermissionExportUploadUploadsSyncedCount,
        @Nullable String userPermissionExportUploadUploadsFailedCount,
        @Nullable String userPermissionExportUploadUploadsRegistryCount,
        @Nullable String userPermissionExportUploadUploadsVerificationTotalCount,
        @Nullable String userPermissionExportUploadUploadsVerifiedCount,
        @Nullable String userPermissionExportUploadUploadsVerificationFailedCount,
        @Nullable String userPermissionExportUploadUploadsOldestUnsyncedTime,
        @Nullable String userUploadsCount,
        @Nullable String userUploadsChecksumTotalCount,
        @Nullable String userUploadsChecksummedCount,
        @Nullable String userUploadsChecksumFailedCount,
        @Nullable String userUploadsSyncedCount,
        @Nullable String userUploadsFailedCount,
        @Nullable String userUploadsRegistryCount,
        @Nullable String userUploadsVerificationTotalCount,
        @Nullable String userUploadsVerifiedCount,
        @Nullable String userUploadsVerificationFailedCount,
        @Nullable String userUploadsOldestUnsyncedTime,
        @Nullable String userPermissionExportUploadUploadsSyncedInPercentage,
        @Nullable String userPermissionExportUploadUploadsVerifiedInPercentage,
        @Nullable String userUploadsSyncedInPercentage,
        @Nullable String userUploadsVerifiedInPercentage) {}
