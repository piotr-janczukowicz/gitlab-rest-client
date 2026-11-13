package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param projectImportExportRelationExportUploadUploadsCount the project import export relation export upload uploads
 *     count
 * @param projectImportExportRelationExportUploadUploadsChecksumTotalCount the project import export relation export
 *     upload uploads checksum total count
 * @param projectImportExportRelationExportUploadUploadsChecksummedCount the project import export relation export
 *     upload uploads checksummed count
 * @param projectImportExportRelationExportUploadUploadsChecksumFailedCount the project import export relation export
 *     upload uploads checksum failed count
 * @param projectImportExportRelationExportUploadUploadsSyncedCount the project import export relation export upload
 *     uploads synced count
 * @param projectImportExportRelationExportUploadUploadsFailedCount the project import export relation export upload
 *     uploads failed count
 * @param projectImportExportRelationExportUploadUploadsRegistryCount the project import export relation export upload
 *     uploads registry count
 * @param projectImportExportRelationExportUploadUploadsVerificationTotalCount the project import export relation export
 *     upload uploads verification total count
 * @param projectImportExportRelationExportUploadUploadsVerifiedCount the project import export relation export upload
 *     uploads verified count
 * @param projectImportExportRelationExportUploadUploadsVerificationFailedCount the project import export relation
 *     export upload uploads verification failed count
 * @param projectImportExportRelationExportUploadUploadsOldestUnsyncedTime the project import export relation export
 *     upload uploads oldest unsynced time
 * @param projectRepositoriesCount the project repositories count
 * @param projectRepositoriesChecksumTotalCount the project repositories checksum total count
 * @param projectRepositoriesChecksummedCount the project repositories checksummed count
 * @param projectRepositoriesChecksumFailedCount the project repositories checksum failed count
 * @param projectRepositoriesSyncedCount the project repositories synced count
 * @param projectRepositoriesFailedCount the project repositories failed count
 * @param projectRepositoriesRegistryCount the project repositories registry count
 * @param projectRepositoriesVerificationTotalCount the project repositories verification total count
 * @param projectRepositoriesVerifiedCount the project repositories verified count
 * @param projectRepositoriesVerificationFailedCount the project repositories verification failed count
 * @param projectRepositoriesOldestUnsyncedTime the project repositories oldest unsynced time
 * @param projectTopicUploadsCount the project topic uploads count
 * @param projectTopicUploadsChecksumTotalCount the project topic uploads checksum total count
 * @param projectTopicUploadsChecksummedCount the project topic uploads checksummed count
 * @param projectTopicUploadsChecksumFailedCount the project topic uploads checksum failed count
 * @param projectTopicUploadsSyncedCount the project topic uploads synced count
 * @param projectTopicUploadsFailedCount the project topic uploads failed count
 * @param projectTopicUploadsRegistryCount the project topic uploads registry count
 * @param projectTopicUploadsVerificationTotalCount the project topic uploads verification total count
 * @param projectTopicUploadsVerifiedCount the project topic uploads verified count
 * @param projectTopicUploadsVerificationFailedCount the project topic uploads verification failed count
 * @param projectTopicUploadsOldestUnsyncedTime the project topic uploads oldest unsynced time
 * @param projectUploadsCount the project uploads count
 * @param projectUploadsChecksumTotalCount the project uploads checksum total count
 * @param projectUploadsChecksummedCount the project uploads checksummed count
 * @param projectUploadsChecksumFailedCount the project uploads checksum failed count
 * @param projectUploadsSyncedCount the project uploads synced count
 * @param projectUploadsFailedCount the project uploads failed count
 * @param projectUploadsRegistryCount the project uploads registry count
 * @param projectUploadsVerificationTotalCount the project uploads verification total count
 * @param projectUploadsVerifiedCount the project uploads verified count
 * @param projectUploadsVerificationFailedCount the project uploads verification failed count
 * @param projectUploadsOldestUnsyncedTime the project uploads oldest unsynced time
 * @param projectWikiRepositoriesCount the project wiki repositories count
 * @param projectWikiRepositoriesChecksumTotalCount the project wiki repositories checksum total count
 * @param projectWikiRepositoriesChecksummedCount the project wiki repositories checksummed count
 * @param projectWikiRepositoriesChecksumFailedCount the project wiki repositories checksum failed count
 * @param projectWikiRepositoriesSyncedCount the project wiki repositories synced count
 * @param projectWikiRepositoriesFailedCount the project wiki repositories failed count
 * @param projectWikiRepositoriesRegistryCount the project wiki repositories registry count
 * @param projectWikiRepositoriesVerificationTotalCount the project wiki repositories verification total count
 * @param projectWikiRepositoriesVerifiedCount the project wiki repositories verified count
 * @param projectWikiRepositoriesVerificationFailedCount the project wiki repositories verification failed count
 * @param projectWikiRepositoriesOldestUnsyncedTime the project wiki repositories oldest unsynced time
 * @param projectImportExportRelationExportUploadUploadsSyncedInPercentage the project import export relation export
 *     upload uploads synced in percentage
 * @param projectImportExportRelationExportUploadUploadsVerifiedInPercentage the project import export relation export
 *     upload uploads verified in percentage
 * @param projectRepositoriesSyncedInPercentage the project repositories synced in percentage
 * @param projectRepositoriesVerifiedInPercentage the project repositories verified in percentage
 * @param projectTopicUploadsSyncedInPercentage the project topic uploads synced in percentage
 * @param projectTopicUploadsVerifiedInPercentage the project topic uploads verified in percentage
 * @param projectUploadsSyncedInPercentage the project uploads synced in percentage
 * @param projectUploadsVerifiedInPercentage the project uploads verified in percentage
 * @param projectWikiRepositoriesSyncedInPercentage the project wiki repositories synced in percentage
 * @param projectWikiRepositoriesVerifiedInPercentage the project wiki repositories verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusProject(
        @Nullable String projectImportExportRelationExportUploadUploadsCount,
        @Nullable String projectImportExportRelationExportUploadUploadsChecksumTotalCount,
        @Nullable String projectImportExportRelationExportUploadUploadsChecksummedCount,
        @Nullable String projectImportExportRelationExportUploadUploadsChecksumFailedCount,
        @Nullable String projectImportExportRelationExportUploadUploadsSyncedCount,
        @Nullable String projectImportExportRelationExportUploadUploadsFailedCount,
        @Nullable String projectImportExportRelationExportUploadUploadsRegistryCount,
        @Nullable String projectImportExportRelationExportUploadUploadsVerificationTotalCount,
        @Nullable String projectImportExportRelationExportUploadUploadsVerifiedCount,
        @Nullable String projectImportExportRelationExportUploadUploadsVerificationFailedCount,
        @Nullable String projectImportExportRelationExportUploadUploadsOldestUnsyncedTime,
        @Nullable String projectRepositoriesCount,
        @Nullable String projectRepositoriesChecksumTotalCount,
        @Nullable String projectRepositoriesChecksummedCount,
        @Nullable String projectRepositoriesChecksumFailedCount,
        @Nullable String projectRepositoriesSyncedCount,
        @Nullable String projectRepositoriesFailedCount,
        @Nullable String projectRepositoriesRegistryCount,
        @Nullable String projectRepositoriesVerificationTotalCount,
        @Nullable String projectRepositoriesVerifiedCount,
        @Nullable String projectRepositoriesVerificationFailedCount,
        @Nullable String projectRepositoriesOldestUnsyncedTime,
        @Nullable String projectTopicUploadsCount,
        @Nullable String projectTopicUploadsChecksumTotalCount,
        @Nullable String projectTopicUploadsChecksummedCount,
        @Nullable String projectTopicUploadsChecksumFailedCount,
        @Nullable String projectTopicUploadsSyncedCount,
        @Nullable String projectTopicUploadsFailedCount,
        @Nullable String projectTopicUploadsRegistryCount,
        @Nullable String projectTopicUploadsVerificationTotalCount,
        @Nullable String projectTopicUploadsVerifiedCount,
        @Nullable String projectTopicUploadsVerificationFailedCount,
        @Nullable String projectTopicUploadsOldestUnsyncedTime,
        @Nullable String projectUploadsCount,
        @Nullable String projectUploadsChecksumTotalCount,
        @Nullable String projectUploadsChecksummedCount,
        @Nullable String projectUploadsChecksumFailedCount,
        @Nullable String projectUploadsSyncedCount,
        @Nullable String projectUploadsFailedCount,
        @Nullable String projectUploadsRegistryCount,
        @Nullable String projectUploadsVerificationTotalCount,
        @Nullable String projectUploadsVerifiedCount,
        @Nullable String projectUploadsVerificationFailedCount,
        @Nullable String projectUploadsOldestUnsyncedTime,
        @Nullable String projectWikiRepositoriesCount,
        @Nullable String projectWikiRepositoriesChecksumTotalCount,
        @Nullable String projectWikiRepositoriesChecksummedCount,
        @Nullable String projectWikiRepositoriesChecksumFailedCount,
        @Nullable String projectWikiRepositoriesSyncedCount,
        @Nullable String projectWikiRepositoriesFailedCount,
        @Nullable String projectWikiRepositoriesRegistryCount,
        @Nullable String projectWikiRepositoriesVerificationTotalCount,
        @Nullable String projectWikiRepositoriesVerifiedCount,
        @Nullable String projectWikiRepositoriesVerificationFailedCount,
        @Nullable String projectWikiRepositoriesOldestUnsyncedTime,
        @Nullable String projectImportExportRelationExportUploadUploadsSyncedInPercentage,
        @Nullable String projectImportExportRelationExportUploadUploadsVerifiedInPercentage,
        @Nullable String projectRepositoriesSyncedInPercentage,
        @Nullable String projectRepositoriesVerifiedInPercentage,
        @Nullable String projectTopicUploadsSyncedInPercentage,
        @Nullable String projectTopicUploadsVerifiedInPercentage,
        @Nullable String projectUploadsSyncedInPercentage,
        @Nullable String projectUploadsVerifiedInPercentage,
        @Nullable String projectWikiRepositoriesSyncedInPercentage,
        @Nullable String projectWikiRepositoriesVerifiedInPercentage) {}
