package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param personalSnippetUploadsCount the personal snippet uploads count
 * @param personalSnippetUploadsChecksumTotalCount the personal snippet uploads checksum total count
 * @param personalSnippetUploadsChecksummedCount the personal snippet uploads checksummed count
 * @param personalSnippetUploadsChecksumFailedCount the personal snippet uploads checksum failed count
 * @param personalSnippetUploadsSyncedCount the personal snippet uploads synced count
 * @param personalSnippetUploadsFailedCount the personal snippet uploads failed count
 * @param personalSnippetUploadsRegistryCount the personal snippet uploads registry count
 * @param personalSnippetUploadsVerificationTotalCount the personal snippet uploads verification total count
 * @param personalSnippetUploadsVerifiedCount the personal snippet uploads verified count
 * @param personalSnippetUploadsVerificationFailedCount the personal snippet uploads verification failed count
 * @param personalSnippetUploadsOldestUnsyncedTime the personal snippet uploads oldest unsynced time
 * @param personalSnippetUploadsSyncedInPercentage the personal snippet uploads synced in percentage
 * @param personalSnippetUploadsVerifiedInPercentage the personal snippet uploads verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusPersonal(
        @Nullable String personalSnippetUploadsCount,
        @Nullable String personalSnippetUploadsChecksumTotalCount,
        @Nullable String personalSnippetUploadsChecksummedCount,
        @Nullable String personalSnippetUploadsChecksumFailedCount,
        @Nullable String personalSnippetUploadsSyncedCount,
        @Nullable String personalSnippetUploadsFailedCount,
        @Nullable String personalSnippetUploadsRegistryCount,
        @Nullable String personalSnippetUploadsVerificationTotalCount,
        @Nullable String personalSnippetUploadsVerifiedCount,
        @Nullable String personalSnippetUploadsVerificationFailedCount,
        @Nullable String personalSnippetUploadsOldestUnsyncedTime,
        @Nullable String personalSnippetUploadsSyncedInPercentage,
        @Nullable String personalSnippetUploadsVerifiedInPercentage) {}
