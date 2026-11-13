package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param issuableMetricImageUploadsCount the issuable metric image uploads count
 * @param issuableMetricImageUploadsChecksumTotalCount the issuable metric image uploads checksum total count
 * @param issuableMetricImageUploadsChecksummedCount the issuable metric image uploads checksummed count
 * @param issuableMetricImageUploadsChecksumFailedCount the issuable metric image uploads checksum failed count
 * @param issuableMetricImageUploadsSyncedCount the issuable metric image uploads synced count
 * @param issuableMetricImageUploadsFailedCount the issuable metric image uploads failed count
 * @param issuableMetricImageUploadsRegistryCount the issuable metric image uploads registry count
 * @param issuableMetricImageUploadsVerificationTotalCount the issuable metric image uploads verification total count
 * @param issuableMetricImageUploadsVerifiedCount the issuable metric image uploads verified count
 * @param issuableMetricImageUploadsVerificationFailedCount the issuable metric image uploads verification failed count
 * @param issuableMetricImageUploadsOldestUnsyncedTime the issuable metric image uploads oldest unsynced time
 * @param issuableMetricImageUploadsSyncedInPercentage the issuable metric image uploads synced in percentage
 * @param issuableMetricImageUploadsVerifiedInPercentage the issuable metric image uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusIssuable(
        @Nullable String issuableMetricImageUploadsCount,
        @Nullable String issuableMetricImageUploadsChecksumTotalCount,
        @Nullable String issuableMetricImageUploadsChecksummedCount,
        @Nullable String issuableMetricImageUploadsChecksumFailedCount,
        @Nullable String issuableMetricImageUploadsSyncedCount,
        @Nullable String issuableMetricImageUploadsFailedCount,
        @Nullable String issuableMetricImageUploadsRegistryCount,
        @Nullable String issuableMetricImageUploadsVerificationTotalCount,
        @Nullable String issuableMetricImageUploadsVerifiedCount,
        @Nullable String issuableMetricImageUploadsVerificationFailedCount,
        @Nullable String issuableMetricImageUploadsOldestUnsyncedTime,
        @Nullable String issuableMetricImageUploadsSyncedInPercentage,
        @Nullable String issuableMetricImageUploadsVerifiedInPercentage) {}
