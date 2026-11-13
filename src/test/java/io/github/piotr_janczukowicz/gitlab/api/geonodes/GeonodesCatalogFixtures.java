package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import java.util.List;

public final class GeonodesCatalogFixtures {

    private GeonodesCatalogFixtures() {}

    public static GitLabGeoNode geoNode() {
        return GitLabGeoNodeBuilder.builder()
                .id(1L)
                .name("name")
                .url("url")
                .internalUrl("internal_url")
                .primary(true)
                .enabled(true)
                .current(true)
                .filesMaxCapacity(1)
                .reposMaxCapacity(1)
                .verificationMaxCapacity(1)
                .containerRepositoriesMaxCapacity(1)
                .selectiveSyncType("selective_sync_type")
                .selectiveSyncShards(List.of("selective_sync_shards"))
                .selectiveSyncNamespaceIds(List.of(1L))
                .selectiveSyncOrganizationIds(List.of(1L))
                .minimumReverificationInterval(1)
                .checksumMismatchReportThreshold(1)
                .checksumMismatchSelfHealCooldownMinutes(1)
                .syncObjectStorage(true)
                .cloneProtocol("clone_protocol")
                .webEditUrl("web_edit_url")
                .webGeoReplicationDetailsUrl("web_geo_replication_details_url")
                .links(GeonodesCatalogFixtures.geoNodeLinks())
                .build();
    }

    public static GitLabGeoNodeLinks geoNodeLinks() {
        return GitLabGeoNodeLinksBuilder.builder()
                .self("self")
                .status("status")
                .repair("repair")
                .build();
    }

    public static GitLabGeoNodesCreatePayload geoNodesCreatePayload() {
        return GitLabGeoNodesCreatePayloadBuilder.builder()
                .primary(true)
                .enabled(true)
                .name("name")
                .url("url")
                .internalUrl("internal_url")
                .filesMaxCapacity(1)
                .reposMaxCapacity(1)
                .verificationMaxCapacity(1)
                .containerRepositoriesMaxCapacity(1)
                .syncObjectStorage(true)
                .selectiveSyncType("selective_sync_type")
                .selectiveSyncShards(List.of("selective_sync_shards"))
                .selectiveSyncNamespaceIds(List.of(1L))
                .selectiveSyncOrganizationIds(List.of(1L))
                .minimumReverificationInterval(1)
                .checksumMismatchReportThreshold(1)
                .checksumMismatchSelfHealCooldownMinutes(1)
                .build();
    }

    public static GitLabGeoNodesUpdatePayload geoNodesUpdatePayload() {
        return GitLabGeoNodesUpdatePayloadBuilder.builder()
                .enabled(true)
                .name("name")
                .url("url")
                .internalUrl("internal_url")
                .filesMaxCapacity(1)
                .reposMaxCapacity(1)
                .verificationMaxCapacity(1)
                .containerRepositoriesMaxCapacity(1)
                .syncObjectStorage(true)
                .selectiveSyncType("selective_sync_type")
                .selectiveSyncShards(List.of("selective_sync_shards"))
                .selectiveSyncNamespaceIds(List.of(1L))
                .selectiveSyncOrganizationIds(List.of(1L))
                .minimumReverificationInterval(1)
                .checksumMismatchReportThreshold(1)
                .checksumMismatchSelfHealCooldownMinutes(1)
                .build();
    }
}
