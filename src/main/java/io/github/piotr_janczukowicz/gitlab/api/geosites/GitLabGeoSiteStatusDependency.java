package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param dependencyListExportPartUploadsCount the dependency list export part uploads count
 * @param dependencyListExportPartUploadsChecksumTotalCount the dependency list export part uploads checksum total count
 * @param dependencyListExportPartUploadsChecksummedCount the dependency list export part uploads checksummed count
 * @param dependencyListExportPartUploadsChecksumFailedCount the dependency list export part uploads checksum failed
 *     count
 * @param dependencyListExportPartUploadsSyncedCount the dependency list export part uploads synced count
 * @param dependencyListExportPartUploadsFailedCount the dependency list export part uploads failed count
 * @param dependencyListExportPartUploadsRegistryCount the dependency list export part uploads registry count
 * @param dependencyListExportPartUploadsVerificationTotalCount the dependency list export part uploads verification
 *     total count
 * @param dependencyListExportPartUploadsVerifiedCount the dependency list export part uploads verified count
 * @param dependencyListExportPartUploadsVerificationFailedCount the dependency list export part uploads verification
 *     failed count
 * @param dependencyListExportPartUploadsOldestUnsyncedTime the dependency list export part uploads oldest unsynced time
 * @param dependencyListExportUploadsCount the dependency list export uploads count
 * @param dependencyListExportUploadsChecksumTotalCount the dependency list export uploads checksum total count
 * @param dependencyListExportUploadsChecksummedCount the dependency list export uploads checksummed count
 * @param dependencyListExportUploadsChecksumFailedCount the dependency list export uploads checksum failed count
 * @param dependencyListExportUploadsSyncedCount the dependency list export uploads synced count
 * @param dependencyListExportUploadsFailedCount the dependency list export uploads failed count
 * @param dependencyListExportUploadsRegistryCount the dependency list export uploads registry count
 * @param dependencyListExportUploadsVerificationTotalCount the dependency list export uploads verification total count
 * @param dependencyListExportUploadsVerifiedCount the dependency list export uploads verified count
 * @param dependencyListExportUploadsVerificationFailedCount the dependency list export uploads verification failed
 *     count
 * @param dependencyListExportUploadsOldestUnsyncedTime the dependency list export uploads oldest unsynced time
 * @param dependencyProxyBlobsCount the dependency proxy blobs count
 * @param dependencyProxyBlobsChecksumTotalCount the dependency proxy blobs checksum total count
 * @param dependencyProxyBlobsChecksummedCount the dependency proxy blobs checksummed count
 * @param dependencyProxyBlobsChecksumFailedCount the dependency proxy blobs checksum failed count
 * @param dependencyProxyBlobsSyncedCount the dependency proxy blobs synced count
 * @param dependencyProxyBlobsFailedCount the dependency proxy blobs failed count
 * @param dependencyProxyBlobsRegistryCount the dependency proxy blobs registry count
 * @param dependencyProxyBlobsVerificationTotalCount the dependency proxy blobs verification total count
 * @param dependencyProxyBlobsVerifiedCount the dependency proxy blobs verified count
 * @param dependencyProxyBlobsVerificationFailedCount the dependency proxy blobs verification failed count
 * @param dependencyProxyBlobsOldestUnsyncedTime the dependency proxy blobs oldest unsynced time
 * @param dependencyProxyManifestsCount the dependency proxy manifests count
 * @param dependencyProxyManifestsChecksumTotalCount the dependency proxy manifests checksum total count
 * @param dependencyProxyManifestsChecksummedCount the dependency proxy manifests checksummed count
 * @param dependencyProxyManifestsChecksumFailedCount the dependency proxy manifests checksum failed count
 * @param dependencyProxyManifestsSyncedCount the dependency proxy manifests synced count
 * @param dependencyProxyManifestsFailedCount the dependency proxy manifests failed count
 * @param dependencyProxyManifestsRegistryCount the dependency proxy manifests registry count
 * @param dependencyProxyManifestsVerificationTotalCount the dependency proxy manifests verification total count
 * @param dependencyProxyManifestsVerifiedCount the dependency proxy manifests verified count
 * @param dependencyProxyManifestsVerificationFailedCount the dependency proxy manifests verification failed count
 * @param dependencyProxyManifestsOldestUnsyncedTime the dependency proxy manifests oldest unsynced time
 * @param dependencyListExportPartUploadsSyncedInPercentage the dependency list export part uploads synced in percentage
 * @param dependencyListExportPartUploadsVerifiedInPercentage the dependency list export part uploads verified in
 *     percentage
 * @param dependencyListExportUploadsSyncedInPercentage the dependency list export uploads synced in percentage
 * @param dependencyListExportUploadsVerifiedInPercentage the dependency list export uploads verified in percentage
 * @param dependencyProxyBlobsSyncedInPercentage the dependency proxy blobs synced in percentage
 * @param dependencyProxyBlobsVerifiedInPercentage the dependency proxy blobs verified in percentage
 * @param dependencyProxyManifestsSyncedInPercentage the dependency proxy manifests synced in percentage
 * @param dependencyProxyManifestsVerifiedInPercentage the dependency proxy manifests verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusDependency(
        @Nullable String dependencyListExportPartUploadsCount,
        @Nullable String dependencyListExportPartUploadsChecksumTotalCount,
        @Nullable String dependencyListExportPartUploadsChecksummedCount,
        @Nullable String dependencyListExportPartUploadsChecksumFailedCount,
        @Nullable String dependencyListExportPartUploadsSyncedCount,
        @Nullable String dependencyListExportPartUploadsFailedCount,
        @Nullable String dependencyListExportPartUploadsRegistryCount,
        @Nullable String dependencyListExportPartUploadsVerificationTotalCount,
        @Nullable String dependencyListExportPartUploadsVerifiedCount,
        @Nullable String dependencyListExportPartUploadsVerificationFailedCount,
        @Nullable String dependencyListExportPartUploadsOldestUnsyncedTime,
        @Nullable String dependencyListExportUploadsCount,
        @Nullable String dependencyListExportUploadsChecksumTotalCount,
        @Nullable String dependencyListExportUploadsChecksummedCount,
        @Nullable String dependencyListExportUploadsChecksumFailedCount,
        @Nullable String dependencyListExportUploadsSyncedCount,
        @Nullable String dependencyListExportUploadsFailedCount,
        @Nullable String dependencyListExportUploadsRegistryCount,
        @Nullable String dependencyListExportUploadsVerificationTotalCount,
        @Nullable String dependencyListExportUploadsVerifiedCount,
        @Nullable String dependencyListExportUploadsVerificationFailedCount,
        @Nullable String dependencyListExportUploadsOldestUnsyncedTime,
        @Nullable String dependencyProxyBlobsCount,
        @Nullable String dependencyProxyBlobsChecksumTotalCount,
        @Nullable String dependencyProxyBlobsChecksummedCount,
        @Nullable String dependencyProxyBlobsChecksumFailedCount,
        @Nullable String dependencyProxyBlobsSyncedCount,
        @Nullable String dependencyProxyBlobsFailedCount,
        @Nullable String dependencyProxyBlobsRegistryCount,
        @Nullable String dependencyProxyBlobsVerificationTotalCount,
        @Nullable String dependencyProxyBlobsVerifiedCount,
        @Nullable String dependencyProxyBlobsVerificationFailedCount,
        @Nullable String dependencyProxyBlobsOldestUnsyncedTime,
        @Nullable String dependencyProxyManifestsCount,
        @Nullable String dependencyProxyManifestsChecksumTotalCount,
        @Nullable String dependencyProxyManifestsChecksummedCount,
        @Nullable String dependencyProxyManifestsChecksumFailedCount,
        @Nullable String dependencyProxyManifestsSyncedCount,
        @Nullable String dependencyProxyManifestsFailedCount,
        @Nullable String dependencyProxyManifestsRegistryCount,
        @Nullable String dependencyProxyManifestsVerificationTotalCount,
        @Nullable String dependencyProxyManifestsVerifiedCount,
        @Nullable String dependencyProxyManifestsVerificationFailedCount,
        @Nullable String dependencyProxyManifestsOldestUnsyncedTime,
        @Nullable String dependencyListExportPartUploadsSyncedInPercentage,
        @Nullable String dependencyListExportPartUploadsVerifiedInPercentage,
        @Nullable String dependencyListExportUploadsSyncedInPercentage,
        @Nullable String dependencyListExportUploadsVerifiedInPercentage,
        @Nullable String dependencyProxyBlobsSyncedInPercentage,
        @Nullable String dependencyProxyBlobsVerifiedInPercentage,
        @Nullable String dependencyProxyManifestsSyncedInPercentage,
        @Nullable String dependencyProxyManifestsVerifiedInPercentage) {}
