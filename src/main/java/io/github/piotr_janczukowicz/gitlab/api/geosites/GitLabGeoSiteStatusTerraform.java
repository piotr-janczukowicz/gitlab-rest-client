package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param terraformStateVersionsCount the terraform state versions count
 * @param terraformStateVersionsChecksumTotalCount the terraform state versions checksum total count
 * @param terraformStateVersionsChecksummedCount the terraform state versions checksummed count
 * @param terraformStateVersionsChecksumFailedCount the terraform state versions checksum failed count
 * @param terraformStateVersionsSyncedCount the terraform state versions synced count
 * @param terraformStateVersionsFailedCount the terraform state versions failed count
 * @param terraformStateVersionsRegistryCount the terraform state versions registry count
 * @param terraformStateVersionsVerificationTotalCount the terraform state versions verification total count
 * @param terraformStateVersionsVerifiedCount the terraform state versions verified count
 * @param terraformStateVersionsVerificationFailedCount the terraform state versions verification failed count
 * @param terraformStateVersionsOldestUnsyncedTime the terraform state versions oldest unsynced time
 * @param terraformStateVersionsSyncedInPercentage the terraform state versions synced in percentage
 * @param terraformStateVersionsVerifiedInPercentage the terraform state versions verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusTerraform(
        @Nullable String terraformStateVersionsCount,
        @Nullable String terraformStateVersionsChecksumTotalCount,
        @Nullable String terraformStateVersionsChecksummedCount,
        @Nullable String terraformStateVersionsChecksumFailedCount,
        @Nullable String terraformStateVersionsSyncedCount,
        @Nullable String terraformStateVersionsFailedCount,
        @Nullable String terraformStateVersionsRegistryCount,
        @Nullable String terraformStateVersionsVerificationTotalCount,
        @Nullable String terraformStateVersionsVerifiedCount,
        @Nullable String terraformStateVersionsVerificationFailedCount,
        @Nullable String terraformStateVersionsOldestUnsyncedTime,
        @Nullable String terraformStateVersionsSyncedInPercentage,
        @Nullable String terraformStateVersionsVerifiedInPercentage) {}
