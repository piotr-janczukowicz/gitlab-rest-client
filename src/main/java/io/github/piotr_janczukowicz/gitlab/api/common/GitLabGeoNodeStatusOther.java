package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabGeoNodeStatus}, flattened into it in JSON.
 *
 * @param geoNodeId the geo node id
 * @param projectsCount the projects count
 * @param gitFetchEventCountWeekly the git fetch event count weekly
 * @param gitPushEventCountWeekly the git push event count weekly
 * @param proxyRemoteRequestsEventCountWeekly the proxy remote requests event count weekly
 * @param proxyLocalRequestsEventCountWeekly the proxy local requests event count weekly
 * @param repositoriesCheckedInPercentage the repositories checked in percentage
 * @param repositoriesCount the repositories count
 * @param repositoriesCheckedCount the repositories checked count
 * @param repositoriesCheckedFailedCount the repositories checked failed count
 * @param replicationSlotsUsedInPercentage the replication slots used in percentage
 * @param replicationSlotsCount the replication slots count
 * @param replicationSlotsUsedCount the replication slots used count
 * @param replicationSlotsMaxRetainedWalBytes the replication slots max retained wal bytes
 * @param healthy the healthy
 * @param health the health
 * @param healthStatus the health status
 * @param missingOauthApplication the missing oauth application
 * @param dbReplicationLagSeconds the db replication lag seconds
 * @param lastEventId the last event id
 * @param lastEventTimestamp the last event timestamp
 * @param lastSuccessfulStatusCheckTimestamp the last successful status check timestamp
 * @param cursorLastEventId the cursor last event id
 * @param cursorLastEventTimestamp the cursor last event timestamp
 * @param version the version
 * @param revision the revision
 * @param selectiveSyncType the selective sync type
 * @param namespaces the namespaces
 * @param updatedAt the updated at
 * @param storageShards the storage shards
 * @param storageShardsMatch the storage shards match
 * @param links the links
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabGeoNodeStatusOther(
        @Nullable String geoNodeId,
        @Nullable String projectsCount,
        @Nullable String gitFetchEventCountWeekly,
        @Nullable String gitPushEventCountWeekly,
        @Nullable String proxyRemoteRequestsEventCountWeekly,
        @Nullable String proxyLocalRequestsEventCountWeekly,
        @Nullable String repositoriesCheckedInPercentage,
        @Nullable String repositoriesCount,
        @Nullable String repositoriesCheckedCount,
        @Nullable String repositoriesCheckedFailedCount,
        @Nullable String replicationSlotsUsedInPercentage,
        @Nullable String replicationSlotsCount,
        @Nullable String replicationSlotsUsedCount,
        @Nullable String replicationSlotsMaxRetainedWalBytes,
        @Nullable String healthy,
        @Nullable String health,
        @Nullable String healthStatus,
        @Nullable String missingOauthApplication,
        @Nullable String dbReplicationLagSeconds,
        @Nullable String lastEventId,
        @Nullable String lastEventTimestamp,
        @Nullable String lastSuccessfulStatusCheckTimestamp,
        @Nullable String cursorLastEventId,
        @Nullable String cursorLastEventTimestamp,
        @Nullable String version,
        @Nullable String revision,
        @Nullable String selectiveSyncType,
        @Nullable GitLabNamespaceBasic namespaces,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (updated_at)")
        Instant updatedAt,

        @Nullable GitLabStorageShardEntity storageShards,
        @Nullable String storageShardsMatch,
        @Nullable @JsonProperty("_links") GitLabGeoNodeStatusLinks links) {}
