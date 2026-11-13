package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param alertManagementMetricImageUploadsCount the alert management metric image uploads count
 * @param alertManagementMetricImageUploadsChecksumTotalCount the alert management metric image uploads checksum total
 *     count
 * @param alertManagementMetricImageUploadsChecksummedCount the alert management metric image uploads checksummed count
 * @param alertManagementMetricImageUploadsChecksumFailedCount the alert management metric image uploads checksum failed
 *     count
 * @param alertManagementMetricImageUploadsSyncedCount the alert management metric image uploads synced count
 * @param alertManagementMetricImageUploadsFailedCount the alert management metric image uploads failed count
 * @param alertManagementMetricImageUploadsRegistryCount the alert management metric image uploads registry count
 * @param alertManagementMetricImageUploadsVerificationTotalCount the alert management metric image uploads verification
 *     total count
 * @param alertManagementMetricImageUploadsVerifiedCount the alert management metric image uploads verified count
 * @param alertManagementMetricImageUploadsVerificationFailedCount the alert management metric image uploads
 *     verification failed count
 * @param alertManagementMetricImageUploadsOldestUnsyncedTime the alert management metric image uploads oldest unsynced
 *     time
 * @param alertManagementMetricImageUploadsSyncedInPercentage the alert management metric image uploads synced in
 *     percentage
 * @param alertManagementMetricImageUploadsVerifiedInPercentage the alert management metric image uploads verified in
 *     percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusAlert(
        @Nullable String alertManagementMetricImageUploadsCount,
        @Nullable String alertManagementMetricImageUploadsChecksumTotalCount,
        @Nullable String alertManagementMetricImageUploadsChecksummedCount,
        @Nullable String alertManagementMetricImageUploadsChecksumFailedCount,
        @Nullable String alertManagementMetricImageUploadsSyncedCount,
        @Nullable String alertManagementMetricImageUploadsFailedCount,
        @Nullable String alertManagementMetricImageUploadsRegistryCount,
        @Nullable String alertManagementMetricImageUploadsVerificationTotalCount,
        @Nullable String alertManagementMetricImageUploadsVerifiedCount,
        @Nullable String alertManagementMetricImageUploadsVerificationFailedCount,
        @Nullable String alertManagementMetricImageUploadsOldestUnsyncedTime,
        @Nullable String alertManagementMetricImageUploadsSyncedInPercentage,
        @Nullable String alertManagementMetricImageUploadsVerifiedInPercentage) {}
