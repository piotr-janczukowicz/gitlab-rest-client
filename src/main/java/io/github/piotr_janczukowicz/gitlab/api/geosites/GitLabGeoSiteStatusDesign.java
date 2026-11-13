package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param designManagementActionUploadsCount the design management action uploads count
 * @param designManagementActionUploadsChecksumTotalCount the design management action uploads checksum total count
 * @param designManagementActionUploadsChecksummedCount the design management action uploads checksummed count
 * @param designManagementActionUploadsChecksumFailedCount the design management action uploads checksum failed count
 * @param designManagementActionUploadsSyncedCount the design management action uploads synced count
 * @param designManagementActionUploadsFailedCount the design management action uploads failed count
 * @param designManagementActionUploadsRegistryCount the design management action uploads registry count
 * @param designManagementActionUploadsVerificationTotalCount the design management action uploads verification total
 *     count
 * @param designManagementActionUploadsVerifiedCount the design management action uploads verified count
 * @param designManagementActionUploadsVerificationFailedCount the design management action uploads verification failed
 *     count
 * @param designManagementActionUploadsOldestUnsyncedTime the design management action uploads oldest unsynced time
 * @param designManagementRepositoriesCount the design management repositories count
 * @param designManagementRepositoriesChecksumTotalCount the design management repositories checksum total count
 * @param designManagementRepositoriesChecksummedCount the design management repositories checksummed count
 * @param designManagementRepositoriesChecksumFailedCount the design management repositories checksum failed count
 * @param designManagementRepositoriesSyncedCount the design management repositories synced count
 * @param designManagementRepositoriesFailedCount the design management repositories failed count
 * @param designManagementRepositoriesRegistryCount the design management repositories registry count
 * @param designManagementRepositoriesVerificationTotalCount the design management repositories verification total count
 * @param designManagementRepositoriesVerifiedCount the design management repositories verified count
 * @param designManagementRepositoriesVerificationFailedCount the design management repositories verification failed
 *     count
 * @param designManagementRepositoriesOldestUnsyncedTime the design management repositories oldest unsynced time
 * @param designManagementActionUploadsSyncedInPercentage the design management action uploads synced in percentage
 * @param designManagementActionUploadsVerifiedInPercentage the design management action uploads verified in percentage
 * @param designManagementRepositoriesSyncedInPercentage the design management repositories synced in percentage
 * @param designManagementRepositoriesVerifiedInPercentage the design management repositories verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusDesign(
        @Nullable String designManagementActionUploadsCount,
        @Nullable String designManagementActionUploadsChecksumTotalCount,
        @Nullable String designManagementActionUploadsChecksummedCount,
        @Nullable String designManagementActionUploadsChecksumFailedCount,
        @Nullable String designManagementActionUploadsSyncedCount,
        @Nullable String designManagementActionUploadsFailedCount,
        @Nullable String designManagementActionUploadsRegistryCount,
        @Nullable String designManagementActionUploadsVerificationTotalCount,
        @Nullable String designManagementActionUploadsVerifiedCount,
        @Nullable String designManagementActionUploadsVerificationFailedCount,
        @Nullable String designManagementActionUploadsOldestUnsyncedTime,
        @Nullable String designManagementRepositoriesCount,
        @Nullable String designManagementRepositoriesChecksumTotalCount,
        @Nullable String designManagementRepositoriesChecksummedCount,
        @Nullable String designManagementRepositoriesChecksumFailedCount,
        @Nullable String designManagementRepositoriesSyncedCount,
        @Nullable String designManagementRepositoriesFailedCount,
        @Nullable String designManagementRepositoriesRegistryCount,
        @Nullable String designManagementRepositoriesVerificationTotalCount,
        @Nullable String designManagementRepositoriesVerifiedCount,
        @Nullable String designManagementRepositoriesVerificationFailedCount,
        @Nullable String designManagementRepositoriesOldestUnsyncedTime,
        @Nullable String designManagementActionUploadsSyncedInPercentage,
        @Nullable String designManagementActionUploadsVerifiedInPercentage,
        @Nullable String designManagementRepositoriesSyncedInPercentage,
        @Nullable String designManagementRepositoriesVerifiedInPercentage) {}
