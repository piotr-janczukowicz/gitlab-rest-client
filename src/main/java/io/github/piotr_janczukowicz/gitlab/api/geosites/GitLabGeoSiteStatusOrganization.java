package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param organizationDetailUploadsCount the organization detail uploads count
 * @param organizationDetailUploadsChecksumTotalCount the organization detail uploads checksum total count
 * @param organizationDetailUploadsChecksummedCount the organization detail uploads checksummed count
 * @param organizationDetailUploadsChecksumFailedCount the organization detail uploads checksum failed count
 * @param organizationDetailUploadsSyncedCount the organization detail uploads synced count
 * @param organizationDetailUploadsFailedCount the organization detail uploads failed count
 * @param organizationDetailUploadsRegistryCount the organization detail uploads registry count
 * @param organizationDetailUploadsVerificationTotalCount the organization detail uploads verification total count
 * @param organizationDetailUploadsVerifiedCount the organization detail uploads verified count
 * @param organizationDetailUploadsVerificationFailedCount the organization detail uploads verification failed count
 * @param organizationDetailUploadsOldestUnsyncedTime the organization detail uploads oldest unsynced time
 * @param organizationDetailUploadsSyncedInPercentage the organization detail uploads synced in percentage
 * @param organizationDetailUploadsVerifiedInPercentage the organization detail uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusOrganization(
        @Nullable String organizationDetailUploadsCount,
        @Nullable String organizationDetailUploadsChecksumTotalCount,
        @Nullable String organizationDetailUploadsChecksummedCount,
        @Nullable String organizationDetailUploadsChecksumFailedCount,
        @Nullable String organizationDetailUploadsSyncedCount,
        @Nullable String organizationDetailUploadsFailedCount,
        @Nullable String organizationDetailUploadsRegistryCount,
        @Nullable String organizationDetailUploadsVerificationTotalCount,
        @Nullable String organizationDetailUploadsVerifiedCount,
        @Nullable String organizationDetailUploadsVerificationFailedCount,
        @Nullable String organizationDetailUploadsOldestUnsyncedTime,
        @Nullable String organizationDetailUploadsSyncedInPercentage,
        @Nullable String organizationDetailUploadsVerifiedInPercentage) {}
