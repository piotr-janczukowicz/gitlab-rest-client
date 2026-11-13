package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param ciSecureFilesCount the ci secure files count
 * @param ciSecureFilesChecksumTotalCount the ci secure files checksum total count
 * @param ciSecureFilesChecksummedCount the ci secure files checksummed count
 * @param ciSecureFilesChecksumFailedCount the ci secure files checksum failed count
 * @param ciSecureFilesSyncedCount the ci secure files synced count
 * @param ciSecureFilesFailedCount the ci secure files failed count
 * @param ciSecureFilesRegistryCount the ci secure files registry count
 * @param ciSecureFilesVerificationTotalCount the ci secure files verification total count
 * @param ciSecureFilesVerifiedCount the ci secure files verified count
 * @param ciSecureFilesVerificationFailedCount the ci secure files verification failed count
 * @param ciSecureFilesOldestUnsyncedTime the ci secure files oldest unsynced time
 * @param ciSecureFilesSyncedInPercentage the ci secure files synced in percentage
 * @param ciSecureFilesVerifiedInPercentage the ci secure files verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusCi(
        @Nullable String ciSecureFilesCount,
        @Nullable String ciSecureFilesChecksumTotalCount,
        @Nullable String ciSecureFilesChecksummedCount,
        @Nullable String ciSecureFilesChecksumFailedCount,
        @Nullable String ciSecureFilesSyncedCount,
        @Nullable String ciSecureFilesFailedCount,
        @Nullable String ciSecureFilesRegistryCount,
        @Nullable String ciSecureFilesVerificationTotalCount,
        @Nullable String ciSecureFilesVerifiedCount,
        @Nullable String ciSecureFilesVerificationFailedCount,
        @Nullable String ciSecureFilesOldestUnsyncedTime,
        @Nullable String ciSecureFilesSyncedInPercentage,
        @Nullable String ciSecureFilesVerifiedInPercentage) {}
