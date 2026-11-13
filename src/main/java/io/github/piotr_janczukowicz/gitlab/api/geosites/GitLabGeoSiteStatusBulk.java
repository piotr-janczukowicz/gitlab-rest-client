package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param bulkImportExportUploadUploadsCount the bulk import export upload uploads count
 * @param bulkImportExportUploadUploadsChecksumTotalCount the bulk import export upload uploads checksum total count
 * @param bulkImportExportUploadUploadsChecksummedCount the bulk import export upload uploads checksummed count
 * @param bulkImportExportUploadUploadsChecksumFailedCount the bulk import export upload uploads checksum failed count
 * @param bulkImportExportUploadUploadsSyncedCount the bulk import export upload uploads synced count
 * @param bulkImportExportUploadUploadsFailedCount the bulk import export upload uploads failed count
 * @param bulkImportExportUploadUploadsRegistryCount the bulk import export upload uploads registry count
 * @param bulkImportExportUploadUploadsVerificationTotalCount the bulk import export upload uploads verification total
 *     count
 * @param bulkImportExportUploadUploadsVerifiedCount the bulk import export upload uploads verified count
 * @param bulkImportExportUploadUploadsVerificationFailedCount the bulk import export upload uploads verification failed
 *     count
 * @param bulkImportExportUploadUploadsOldestUnsyncedTime the bulk import export upload uploads oldest unsynced time
 * @param bulkImportExportUploadUploadsSyncedInPercentage the bulk import export upload uploads synced in percentage
 * @param bulkImportExportUploadUploadsVerifiedInPercentage the bulk import export upload uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusBulk(
        @Nullable String bulkImportExportUploadUploadsCount,
        @Nullable String bulkImportExportUploadUploadsChecksumTotalCount,
        @Nullable String bulkImportExportUploadUploadsChecksummedCount,
        @Nullable String bulkImportExportUploadUploadsChecksumFailedCount,
        @Nullable String bulkImportExportUploadUploadsSyncedCount,
        @Nullable String bulkImportExportUploadUploadsFailedCount,
        @Nullable String bulkImportExportUploadUploadsRegistryCount,
        @Nullable String bulkImportExportUploadUploadsVerificationTotalCount,
        @Nullable String bulkImportExportUploadUploadsVerifiedCount,
        @Nullable String bulkImportExportUploadUploadsVerificationFailedCount,
        @Nullable String bulkImportExportUploadUploadsOldestUnsyncedTime,
        @Nullable String bulkImportExportUploadUploadsSyncedInPercentage,
        @Nullable String bulkImportExportUploadUploadsVerifiedInPercentage) {}
