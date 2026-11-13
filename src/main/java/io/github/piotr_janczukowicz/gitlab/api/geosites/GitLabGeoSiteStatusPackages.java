package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param packagesDebianProjectComponentFilesCount the packages debian project component files count
 * @param packagesDebianProjectComponentFilesChecksumTotalCount the packages debian project component files checksum
 *     total count
 * @param packagesDebianProjectComponentFilesChecksummedCount the packages debian project component files checksummed
 *     count
 * @param packagesDebianProjectComponentFilesChecksumFailedCount the packages debian project component files checksum
 *     failed count
 * @param packagesDebianProjectComponentFilesSyncedCount the packages debian project component files synced count
 * @param packagesDebianProjectComponentFilesFailedCount the packages debian project component files failed count
 * @param packagesDebianProjectComponentFilesRegistryCount the packages debian project component files registry count
 * @param packagesDebianProjectComponentFilesVerificationTotalCount the packages debian project component files
 *     verification total count
 * @param packagesDebianProjectComponentFilesVerifiedCount the packages debian project component files verified count
 * @param packagesDebianProjectComponentFilesVerificationFailedCount the packages debian project component files
 *     verification failed count
 * @param packagesDebianProjectComponentFilesOldestUnsyncedTime the packages debian project component files oldest
 *     unsynced time
 * @param packagesHelmMetadataCachesCount the packages helm metadata caches count
 * @param packagesHelmMetadataCachesChecksumTotalCount the packages helm metadata caches checksum total count
 * @param packagesHelmMetadataCachesChecksummedCount the packages helm metadata caches checksummed count
 * @param packagesHelmMetadataCachesChecksumFailedCount the packages helm metadata caches checksum failed count
 * @param packagesHelmMetadataCachesSyncedCount the packages helm metadata caches synced count
 * @param packagesHelmMetadataCachesFailedCount the packages helm metadata caches failed count
 * @param packagesHelmMetadataCachesRegistryCount the packages helm metadata caches registry count
 * @param packagesHelmMetadataCachesVerificationTotalCount the packages helm metadata caches verification total count
 * @param packagesHelmMetadataCachesVerifiedCount the packages helm metadata caches verified count
 * @param packagesHelmMetadataCachesVerificationFailedCount the packages helm metadata caches verification failed count
 * @param packagesHelmMetadataCachesOldestUnsyncedTime the packages helm metadata caches oldest unsynced time
 * @param packagesNugetSymbolsCount the packages nuget symbols count
 * @param packagesNugetSymbolsChecksumTotalCount the packages nuget symbols checksum total count
 * @param packagesNugetSymbolsChecksummedCount the packages nuget symbols checksummed count
 * @param packagesNugetSymbolsChecksumFailedCount the packages nuget symbols checksum failed count
 * @param packagesNugetSymbolsSyncedCount the packages nuget symbols synced count
 * @param packagesNugetSymbolsFailedCount the packages nuget symbols failed count
 * @param packagesNugetSymbolsRegistryCount the packages nuget symbols registry count
 * @param packagesNugetSymbolsVerificationTotalCount the packages nuget symbols verification total count
 * @param packagesNugetSymbolsVerifiedCount the packages nuget symbols verified count
 * @param packagesNugetSymbolsVerificationFailedCount the packages nuget symbols verification failed count
 * @param packagesNugetSymbolsOldestUnsyncedTime the packages nuget symbols oldest unsynced time
 * @param packagesDebianProjectComponentFilesSyncedInPercentage the packages debian project component files synced in
 *     percentage
 * @param packagesDebianProjectComponentFilesVerifiedInPercentage the packages debian project component files verified
 *     in percentage
 * @param packagesHelmMetadataCachesSyncedInPercentage the packages helm metadata caches synced in percentage
 * @param packagesHelmMetadataCachesVerifiedInPercentage the packages helm metadata caches verified in percentage
 * @param packagesNugetSymbolsSyncedInPercentage the packages nuget symbols synced in percentage
 * @param packagesNugetSymbolsVerifiedInPercentage the packages nuget symbols verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusPackages(
        @Nullable String packagesDebianProjectComponentFilesCount,
        @Nullable String packagesDebianProjectComponentFilesChecksumTotalCount,
        @Nullable String packagesDebianProjectComponentFilesChecksummedCount,
        @Nullable String packagesDebianProjectComponentFilesChecksumFailedCount,
        @Nullable String packagesDebianProjectComponentFilesSyncedCount,
        @Nullable String packagesDebianProjectComponentFilesFailedCount,
        @Nullable String packagesDebianProjectComponentFilesRegistryCount,
        @Nullable String packagesDebianProjectComponentFilesVerificationTotalCount,
        @Nullable String packagesDebianProjectComponentFilesVerifiedCount,
        @Nullable String packagesDebianProjectComponentFilesVerificationFailedCount,
        @Nullable String packagesDebianProjectComponentFilesOldestUnsyncedTime,
        @Nullable String packagesHelmMetadataCachesCount,
        @Nullable String packagesHelmMetadataCachesChecksumTotalCount,
        @Nullable String packagesHelmMetadataCachesChecksummedCount,
        @Nullable String packagesHelmMetadataCachesChecksumFailedCount,
        @Nullable String packagesHelmMetadataCachesSyncedCount,
        @Nullable String packagesHelmMetadataCachesFailedCount,
        @Nullable String packagesHelmMetadataCachesRegistryCount,
        @Nullable String packagesHelmMetadataCachesVerificationTotalCount,
        @Nullable String packagesHelmMetadataCachesVerifiedCount,
        @Nullable String packagesHelmMetadataCachesVerificationFailedCount,
        @Nullable String packagesHelmMetadataCachesOldestUnsyncedTime,
        @Nullable String packagesNugetSymbolsCount,
        @Nullable String packagesNugetSymbolsChecksumTotalCount,
        @Nullable String packagesNugetSymbolsChecksummedCount,
        @Nullable String packagesNugetSymbolsChecksumFailedCount,
        @Nullable String packagesNugetSymbolsSyncedCount,
        @Nullable String packagesNugetSymbolsFailedCount,
        @Nullable String packagesNugetSymbolsRegistryCount,
        @Nullable String packagesNugetSymbolsVerificationTotalCount,
        @Nullable String packagesNugetSymbolsVerifiedCount,
        @Nullable String packagesNugetSymbolsVerificationFailedCount,
        @Nullable String packagesNugetSymbolsOldestUnsyncedTime,
        @Nullable String packagesDebianProjectComponentFilesSyncedInPercentage,
        @Nullable String packagesDebianProjectComponentFilesVerifiedInPercentage,
        @Nullable String packagesHelmMetadataCachesSyncedInPercentage,
        @Nullable String packagesHelmMetadataCachesVerifiedInPercentage,
        @Nullable String packagesNugetSymbolsSyncedInPercentage,
        @Nullable String packagesNugetSymbolsVerifiedInPercentage) {}
