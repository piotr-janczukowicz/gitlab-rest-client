package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * The git lab geo create status data of a GitLab resource.
 *
 * @param geoNodeId the geo node id
 * @param dbReplicationLagSeconds the db replication lag seconds
 * @param lastEventId the last event id
 * @param lastEventDate the last event date
 * @param cursorLastEventId the cursor last event id
 * @param cursorLastEventDate the cursor last event date
 * @param lastSuccessfulStatusCheckAt the last successful status check at
 * @param statusMessage the status message
 * @param replicationSlotsCount the replication slots count
 * @param replicationSlotsUsedCount the replication slots used count
 * @param replicationSlotsMaxRetainedWalBytes the replication slots max retained wal bytes
 * @param version the version
 * @param revision the revision
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoStatus/requestBody/properties/data")
public record GitLabGeoCreateStatusData(
        @Nullable Long geoNodeId,
        @Nullable Integer dbReplicationLagSeconds,
        @Nullable Long lastEventId,
        @Nullable Instant lastEventDate,
        @Nullable Long cursorLastEventId,
        @Nullable Instant cursorLastEventDate,
        @Nullable Instant lastSuccessfulStatusCheckAt,
        @Nullable String statusMessage,
        @Nullable Integer replicationSlotsCount,
        @Nullable Integer replicationSlotsUsedCount,
        @Nullable Long replicationSlotsMaxRetainedWalBytes,
        @Nullable String version,
        @Nullable String revision,
        @Nullable GitLabGeoCreateStatusDataStatus status) {}
