package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param importExportUploadUploadsCount the import export upload uploads count
 * @param importExportUploadUploadsChecksumTotalCount the import export upload uploads checksum total count
 * @param importExportUploadUploadsChecksummedCount the import export upload uploads checksummed count
 * @param importExportUploadUploadsChecksumFailedCount the import export upload uploads checksum failed count
 * @param importExportUploadUploadsSyncedCount the import export upload uploads synced count
 * @param importExportUploadUploadsFailedCount the import export upload uploads failed count
 * @param importExportUploadUploadsRegistryCount the import export upload uploads registry count
 * @param importExportUploadUploadsVerificationTotalCount the import export upload uploads verification total count
 * @param importExportUploadUploadsVerifiedCount the import export upload uploads verified count
 * @param importExportUploadUploadsVerificationFailedCount the import export upload uploads verification failed count
 * @param importExportUploadUploadsOldestUnsyncedTime the import export upload uploads oldest unsynced time
 * @param importExportUploadUploadsSyncedInPercentage the import export upload uploads synced in percentage
 * @param importExportUploadUploadsVerifiedInPercentage the import export upload uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusImport(
        @Nullable String importExportUploadUploadsCount,
        @Nullable String importExportUploadUploadsChecksumTotalCount,
        @Nullable String importExportUploadUploadsChecksummedCount,
        @Nullable String importExportUploadUploadsChecksumFailedCount,
        @Nullable String importExportUploadUploadsSyncedCount,
        @Nullable String importExportUploadUploadsFailedCount,
        @Nullable String importExportUploadUploadsRegistryCount,
        @Nullable String importExportUploadUploadsVerificationTotalCount,
        @Nullable String importExportUploadUploadsVerifiedCount,
        @Nullable String importExportUploadUploadsVerificationFailedCount,
        @Nullable String importExportUploadUploadsOldestUnsyncedTime,
        @Nullable String importExportUploadUploadsSyncedInPercentage,
        @Nullable String importExportUploadUploadsVerifiedInPercentage) {}
