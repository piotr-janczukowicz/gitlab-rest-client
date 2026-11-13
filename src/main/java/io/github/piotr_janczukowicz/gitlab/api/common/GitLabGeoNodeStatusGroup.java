package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param groupUploadsCount the group uploads count
 * @param groupUploadsChecksumTotalCount the group uploads checksum total count
 * @param groupUploadsChecksummedCount the group uploads checksummed count
 * @param groupUploadsChecksumFailedCount the group uploads checksum failed count
 * @param groupUploadsSyncedCount the group uploads synced count
 * @param groupUploadsFailedCount the group uploads failed count
 * @param groupUploadsRegistryCount the group uploads registry count
 * @param groupUploadsVerificationTotalCount the group uploads verification total count
 * @param groupUploadsVerifiedCount the group uploads verified count
 * @param groupUploadsVerificationFailedCount the group uploads verification failed count
 * @param groupUploadsOldestUnsyncedTime the group uploads oldest unsynced time
 * @param groupWikiRepositoriesCount the group wiki repositories count
 * @param groupWikiRepositoriesChecksumTotalCount the group wiki repositories checksum total count
 * @param groupWikiRepositoriesChecksummedCount the group wiki repositories checksummed count
 * @param groupWikiRepositoriesChecksumFailedCount the group wiki repositories checksum failed count
 * @param groupWikiRepositoriesSyncedCount the group wiki repositories synced count
 * @param groupWikiRepositoriesFailedCount the group wiki repositories failed count
 * @param groupWikiRepositoriesRegistryCount the group wiki repositories registry count
 * @param groupWikiRepositoriesVerificationTotalCount the group wiki repositories verification total count
 * @param groupWikiRepositoriesVerifiedCount the group wiki repositories verified count
 * @param groupWikiRepositoriesVerificationFailedCount the group wiki repositories verification failed count
 * @param groupWikiRepositoriesOldestUnsyncedTime the group wiki repositories oldest unsynced time
 * @param groupUploadsSyncedInPercentage the group uploads synced in percentage
 * @param groupUploadsVerifiedInPercentage the group uploads verified in percentage
 * @param groupWikiRepositoriesSyncedInPercentage the group wiki repositories synced in percentage
 * @param groupWikiRepositoriesVerifiedInPercentage the group wiki repositories verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusGroup(
        @Nullable String groupUploadsCount,
        @Nullable String groupUploadsChecksumTotalCount,
        @Nullable String groupUploadsChecksummedCount,
        @Nullable String groupUploadsChecksumFailedCount,
        @Nullable String groupUploadsSyncedCount,
        @Nullable String groupUploadsFailedCount,
        @Nullable String groupUploadsRegistryCount,
        @Nullable String groupUploadsVerificationTotalCount,
        @Nullable String groupUploadsVerifiedCount,
        @Nullable String groupUploadsVerificationFailedCount,
        @Nullable String groupUploadsOldestUnsyncedTime,
        @Nullable String groupWikiRepositoriesCount,
        @Nullable String groupWikiRepositoriesChecksumTotalCount,
        @Nullable String groupWikiRepositoriesChecksummedCount,
        @Nullable String groupWikiRepositoriesChecksumFailedCount,
        @Nullable String groupWikiRepositoriesSyncedCount,
        @Nullable String groupWikiRepositoriesFailedCount,
        @Nullable String groupWikiRepositoriesRegistryCount,
        @Nullable String groupWikiRepositoriesVerificationTotalCount,
        @Nullable String groupWikiRepositoriesVerifiedCount,
        @Nullable String groupWikiRepositoriesVerificationFailedCount,
        @Nullable String groupWikiRepositoriesOldestUnsyncedTime,
        @Nullable String groupUploadsSyncedInPercentage,
        @Nullable String groupUploadsVerifiedInPercentage,
        @Nullable String groupWikiRepositoriesSyncedInPercentage,
        @Nullable String groupWikiRepositoriesVerifiedInPercentage) {}
