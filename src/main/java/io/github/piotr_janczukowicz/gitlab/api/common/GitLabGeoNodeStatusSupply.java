package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param supplyChainAttestationsCount the supply chain attestations count
 * @param supplyChainAttestationsChecksumTotalCount the supply chain attestations checksum total count
 * @param supplyChainAttestationsChecksummedCount the supply chain attestations checksummed count
 * @param supplyChainAttestationsChecksumFailedCount the supply chain attestations checksum failed count
 * @param supplyChainAttestationsSyncedCount the supply chain attestations synced count
 * @param supplyChainAttestationsFailedCount the supply chain attestations failed count
 * @param supplyChainAttestationsRegistryCount the supply chain attestations registry count
 * @param supplyChainAttestationsVerificationTotalCount the supply chain attestations verification total count
 * @param supplyChainAttestationsVerifiedCount the supply chain attestations verified count
 * @param supplyChainAttestationsVerificationFailedCount the supply chain attestations verification failed count
 * @param supplyChainAttestationsOldestUnsyncedTime the supply chain attestations oldest unsynced time
 * @param supplyChainAttestationsSyncedInPercentage the supply chain attestations synced in percentage
 * @param supplyChainAttestationsVerifiedInPercentage the supply chain attestations verified in percentage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusSupply(
        @Nullable String supplyChainAttestationsCount,
        @Nullable String supplyChainAttestationsChecksumTotalCount,
        @Nullable String supplyChainAttestationsChecksummedCount,
        @Nullable String supplyChainAttestationsChecksumFailedCount,
        @Nullable String supplyChainAttestationsSyncedCount,
        @Nullable String supplyChainAttestationsFailedCount,
        @Nullable String supplyChainAttestationsRegistryCount,
        @Nullable String supplyChainAttestationsVerificationTotalCount,
        @Nullable String supplyChainAttestationsVerifiedCount,
        @Nullable String supplyChainAttestationsVerificationFailedCount,
        @Nullable String supplyChainAttestationsOldestUnsyncedTime,
        @Nullable String supplyChainAttestationsSyncedInPercentage,
        @Nullable String supplyChainAttestationsVerifiedInPercentage) {}
