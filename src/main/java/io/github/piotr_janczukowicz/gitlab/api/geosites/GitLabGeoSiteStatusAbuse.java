package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param abuseReportUploadsCount the abuse report uploads count
 * @param abuseReportUploadsChecksumTotalCount the abuse report uploads checksum total count
 * @param abuseReportUploadsChecksummedCount the abuse report uploads checksummed count
 * @param abuseReportUploadsChecksumFailedCount the abuse report uploads checksum failed count
 * @param abuseReportUploadsSyncedCount the abuse report uploads synced count
 * @param abuseReportUploadsFailedCount the abuse report uploads failed count
 * @param abuseReportUploadsRegistryCount the abuse report uploads registry count
 * @param abuseReportUploadsVerificationTotalCount the abuse report uploads verification total count
 * @param abuseReportUploadsVerifiedCount the abuse report uploads verified count
 * @param abuseReportUploadsVerificationFailedCount the abuse report uploads verification failed count
 * @param abuseReportUploadsOldestUnsyncedTime the abuse report uploads oldest unsynced time
 * @param abuseReportUploadsSyncedInPercentage the abuse report uploads synced in percentage
 * @param abuseReportUploadsVerifiedInPercentage the abuse report uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusAbuse(
        @Nullable String abuseReportUploadsCount,
        @Nullable String abuseReportUploadsChecksumTotalCount,
        @Nullable String abuseReportUploadsChecksummedCount,
        @Nullable String abuseReportUploadsChecksumFailedCount,
        @Nullable String abuseReportUploadsSyncedCount,
        @Nullable String abuseReportUploadsFailedCount,
        @Nullable String abuseReportUploadsRegistryCount,
        @Nullable String abuseReportUploadsVerificationTotalCount,
        @Nullable String abuseReportUploadsVerifiedCount,
        @Nullable String abuseReportUploadsVerificationFailedCount,
        @Nullable String abuseReportUploadsOldestUnsyncedTime,
        @Nullable String abuseReportUploadsSyncedInPercentage,
        @Nullable String abuseReportUploadsVerifiedInPercentage) {}
