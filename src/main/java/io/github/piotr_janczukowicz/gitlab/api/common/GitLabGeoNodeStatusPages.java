package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param pagesDeploymentsCount the pages deployments count
 * @param pagesDeploymentsChecksumTotalCount the pages deployments checksum total count
 * @param pagesDeploymentsChecksummedCount the pages deployments checksummed count
 * @param pagesDeploymentsChecksumFailedCount the pages deployments checksum failed count
 * @param pagesDeploymentsSyncedCount the pages deployments synced count
 * @param pagesDeploymentsFailedCount the pages deployments failed count
 * @param pagesDeploymentsRegistryCount the pages deployments registry count
 * @param pagesDeploymentsVerificationTotalCount the pages deployments verification total count
 * @param pagesDeploymentsVerifiedCount the pages deployments verified count
 * @param pagesDeploymentsVerificationFailedCount the pages deployments verification failed count
 * @param pagesDeploymentsOldestUnsyncedTime the pages deployments oldest unsynced time
 * @param pagesDeploymentsSyncedInPercentage the pages deployments synced in percentage
 * @param pagesDeploymentsVerifiedInPercentage the pages deployments verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusPages(
        @Nullable String pagesDeploymentsCount,
        @Nullable String pagesDeploymentsChecksumTotalCount,
        @Nullable String pagesDeploymentsChecksummedCount,
        @Nullable String pagesDeploymentsChecksumFailedCount,
        @Nullable String pagesDeploymentsSyncedCount,
        @Nullable String pagesDeploymentsFailedCount,
        @Nullable String pagesDeploymentsRegistryCount,
        @Nullable String pagesDeploymentsVerificationTotalCount,
        @Nullable String pagesDeploymentsVerifiedCount,
        @Nullable String pagesDeploymentsVerificationFailedCount,
        @Nullable String pagesDeploymentsOldestUnsyncedTime,
        @Nullable String pagesDeploymentsSyncedInPercentage,
        @Nullable String pagesDeploymentsVerifiedInPercentage) {}
