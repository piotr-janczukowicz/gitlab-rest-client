package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param packageFilesCount the package files count
 * @param packageFilesChecksumTotalCount the package files checksum total count
 * @param packageFilesChecksummedCount the package files checksummed count
 * @param packageFilesChecksumFailedCount the package files checksum failed count
 * @param packageFilesSyncedCount the package files synced count
 * @param packageFilesFailedCount the package files failed count
 * @param packageFilesRegistryCount the package files registry count
 * @param packageFilesVerificationTotalCount the package files verification total count
 * @param packageFilesVerifiedCount the package files verified count
 * @param packageFilesVerificationFailedCount the package files verification failed count
 * @param packageFilesOldestUnsyncedTime the package files oldest unsynced time
 * @param packageFilesSyncedInPercentage the package files synced in percentage
 * @param packageFilesVerifiedInPercentage the package files verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusPackage(
        @Nullable String packageFilesCount,
        @Nullable String packageFilesChecksumTotalCount,
        @Nullable String packageFilesChecksummedCount,
        @Nullable String packageFilesChecksumFailedCount,
        @Nullable String packageFilesSyncedCount,
        @Nullable String packageFilesFailedCount,
        @Nullable String packageFilesRegistryCount,
        @Nullable String packageFilesVerificationTotalCount,
        @Nullable String packageFilesVerifiedCount,
        @Nullable String packageFilesVerificationFailedCount,
        @Nullable String packageFilesOldestUnsyncedTime,
        @Nullable String packageFilesSyncedInPercentage,
        @Nullable String packageFilesVerifiedInPercentage) {}
