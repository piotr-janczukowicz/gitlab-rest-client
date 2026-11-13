package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoSiteStatus}, flattened into it in JSON.
 *
 * @param snippetRepositoriesCount the snippet repositories count
 * @param snippetRepositoriesChecksumTotalCount the snippet repositories checksum total count
 * @param snippetRepositoriesChecksummedCount the snippet repositories checksummed count
 * @param snippetRepositoriesChecksumFailedCount the snippet repositories checksum failed count
 * @param snippetRepositoriesSyncedCount the snippet repositories synced count
 * @param snippetRepositoriesFailedCount the snippet repositories failed count
 * @param snippetRepositoriesRegistryCount the snippet repositories registry count
 * @param snippetRepositoriesVerificationTotalCount the snippet repositories verification total count
 * @param snippetRepositoriesVerifiedCount the snippet repositories verified count
 * @param snippetRepositoriesVerificationFailedCount the snippet repositories verification failed count
 * @param snippetRepositoriesOldestUnsyncedTime the snippet repositories oldest unsynced time
 * @param snippetRepositoriesSyncedInPercentage the snippet repositories synced in percentage
 * @param snippetRepositoriesVerifiedInPercentage the snippet repositories verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoSiteStatusSnippet(
        @Nullable String snippetRepositoriesCount,
        @Nullable String snippetRepositoriesChecksumTotalCount,
        @Nullable String snippetRepositoriesChecksummedCount,
        @Nullable String snippetRepositoriesChecksumFailedCount,
        @Nullable String snippetRepositoriesSyncedCount,
        @Nullable String snippetRepositoriesFailedCount,
        @Nullable String snippetRepositoriesRegistryCount,
        @Nullable String snippetRepositoriesVerificationTotalCount,
        @Nullable String snippetRepositoriesVerifiedCount,
        @Nullable String snippetRepositoriesVerificationFailedCount,
        @Nullable String snippetRepositoriesOldestUnsyncedTime,
        @Nullable String snippetRepositoriesSyncedInPercentage,
        @Nullable String snippetRepositoriesVerifiedInPercentage) {}
