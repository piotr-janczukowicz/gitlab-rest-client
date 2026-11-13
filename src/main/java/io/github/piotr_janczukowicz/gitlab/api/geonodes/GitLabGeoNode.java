package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab geo node.
 *
 * @param id the id
 * @param name the name
 * @param url the url
 * @param internalUrl the internal url
 * @param primary the primary
 * @param enabled the enabled
 * @param current the current
 * @param filesMaxCapacity the files max capacity
 * @param reposMaxCapacity the repos max capacity
 * @param verificationMaxCapacity the verification max capacity
 * @param containerRepositoriesMaxCapacity the container repositories max capacity
 * @param selectiveSyncType the selective sync type
 * @param selectiveSyncShards the selective sync shards
 * @param selectiveSyncNamespaceIds the selective sync namespace ids
 * @param selectiveSyncOrganizationIds the selective sync organization ids
 * @param minimumReverificationInterval the minimum reverification interval
 * @param checksumMismatchReportThreshold the checksum mismatch report threshold
 * @param checksumMismatchSelfHealCooldownMinutes the checksum mismatch self heal cooldown minutes
 * @param syncObjectStorage the sync object storage
 * @param cloneProtocol the clone protocol
 * @param webEditUrl the web edit url
 * @param webGeoReplicationDetailsUrl the web geo replication details url
 * @param links the links
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGeoNode")
public record GitLabGeoNode(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String url,
        @Nullable String internalUrl,
        @Nullable Boolean primary,
        @Nullable Boolean enabled,
        @Nullable Boolean current,
        @Nullable Integer filesMaxCapacity,
        @Nullable Integer reposMaxCapacity,
        @Nullable Integer verificationMaxCapacity,
        @Nullable Integer containerRepositoriesMaxCapacity,
        @Nullable String selectiveSyncType,
        @Nullable List<String> selectiveSyncShards,
        @Nullable List<Long> selectiveSyncNamespaceIds,
        @Nullable List<Long> selectiveSyncOrganizationIds,
        @Nullable Integer minimumReverificationInterval,
        @Nullable Integer checksumMismatchReportThreshold,
        @Nullable Integer checksumMismatchSelfHealCooldownMinutes,
        @Nullable Boolean syncObjectStorage,
        @Nullable String cloneProtocol,
        @Nullable String webEditUrl,
        @Nullable String webGeoReplicationDetailsUrl,
        @Nullable @JsonProperty("_links") GitLabGeoNodeLinks links) {}
