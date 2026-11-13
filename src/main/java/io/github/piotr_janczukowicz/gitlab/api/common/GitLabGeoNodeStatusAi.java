package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param aiVectorizableFileUploadsCount the ai vectorizable file uploads count
 * @param aiVectorizableFileUploadsChecksumTotalCount the ai vectorizable file uploads checksum total count
 * @param aiVectorizableFileUploadsChecksummedCount the ai vectorizable file uploads checksummed count
 * @param aiVectorizableFileUploadsChecksumFailedCount the ai vectorizable file uploads checksum failed count
 * @param aiVectorizableFileUploadsSyncedCount the ai vectorizable file uploads synced count
 * @param aiVectorizableFileUploadsFailedCount the ai vectorizable file uploads failed count
 * @param aiVectorizableFileUploadsRegistryCount the ai vectorizable file uploads registry count
 * @param aiVectorizableFileUploadsVerificationTotalCount the ai vectorizable file uploads verification total count
 * @param aiVectorizableFileUploadsVerifiedCount the ai vectorizable file uploads verified count
 * @param aiVectorizableFileUploadsVerificationFailedCount the ai vectorizable file uploads verification failed count
 * @param aiVectorizableFileUploadsOldestUnsyncedTime the ai vectorizable file uploads oldest unsynced time
 * @param aiVectorizableFileUploadsSyncedInPercentage the ai vectorizable file uploads synced in percentage
 * @param aiVectorizableFileUploadsVerifiedInPercentage the ai vectorizable file uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusAi(
        @Nullable Integer aiVectorizableFileUploadsCount,
        @Nullable Integer aiVectorizableFileUploadsChecksumTotalCount,
        @Nullable Integer aiVectorizableFileUploadsChecksummedCount,
        @Nullable Integer aiVectorizableFileUploadsChecksumFailedCount,
        @Nullable Integer aiVectorizableFileUploadsSyncedCount,
        @Nullable Integer aiVectorizableFileUploadsFailedCount,
        @Nullable Integer aiVectorizableFileUploadsRegistryCount,
        @Nullable Integer aiVectorizableFileUploadsVerificationTotalCount,
        @Nullable Integer aiVectorizableFileUploadsVerifiedCount,
        @Nullable Integer aiVectorizableFileUploadsVerificationFailedCount,
        @Nullable Integer aiVectorizableFileUploadsOldestUnsyncedTime,
        @Nullable String aiVectorizableFileUploadsSyncedInPercentage,
        @Nullable String aiVectorizableFileUploadsVerifiedInPercentage) {}
