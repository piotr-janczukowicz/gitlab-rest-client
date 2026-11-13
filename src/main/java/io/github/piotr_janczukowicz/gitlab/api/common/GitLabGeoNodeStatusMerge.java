package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param mergeRequestDiffsCount the merge request diffs count
 * @param mergeRequestDiffsChecksumTotalCount the merge request diffs checksum total count
 * @param mergeRequestDiffsChecksummedCount the merge request diffs checksummed count
 * @param mergeRequestDiffsChecksumFailedCount the merge request diffs checksum failed count
 * @param mergeRequestDiffsSyncedCount the merge request diffs synced count
 * @param mergeRequestDiffsFailedCount the merge request diffs failed count
 * @param mergeRequestDiffsRegistryCount the merge request diffs registry count
 * @param mergeRequestDiffsVerificationTotalCount the merge request diffs verification total count
 * @param mergeRequestDiffsVerifiedCount the merge request diffs verified count
 * @param mergeRequestDiffsVerificationFailedCount the merge request diffs verification failed count
 * @param mergeRequestDiffsOldestUnsyncedTime the merge request diffs oldest unsynced time
 * @param mergeRequestDiffsSyncedInPercentage the merge request diffs synced in percentage
 * @param mergeRequestDiffsVerifiedInPercentage the merge request diffs verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusMerge(
        @Nullable String mergeRequestDiffsCount,
        @Nullable String mergeRequestDiffsChecksumTotalCount,
        @Nullable String mergeRequestDiffsChecksummedCount,
        @Nullable String mergeRequestDiffsChecksumFailedCount,
        @Nullable String mergeRequestDiffsSyncedCount,
        @Nullable String mergeRequestDiffsFailedCount,
        @Nullable String mergeRequestDiffsRegistryCount,
        @Nullable String mergeRequestDiffsVerificationTotalCount,
        @Nullable String mergeRequestDiffsVerifiedCount,
        @Nullable String mergeRequestDiffsVerificationFailedCount,
        @Nullable String mergeRequestDiffsOldestUnsyncedTime,
        @Nullable String mergeRequestDiffsSyncedInPercentage,
        @Nullable String mergeRequestDiffsVerifiedInPercentage) {}
