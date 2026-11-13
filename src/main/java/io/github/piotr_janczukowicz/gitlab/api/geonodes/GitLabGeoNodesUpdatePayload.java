package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeastIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GeoNodesId}.
 *
 * @param enabled the enabled
 * @param name the name
 * @param url the url
 * @param internalUrl the internal url
 * @param filesMaxCapacity the files max capacity
 * @param reposMaxCapacity the repos max capacity
 * @param verificationMaxCapacity the verification max capacity
 * @param containerRepositoriesMaxCapacity the container repositories max capacity
 * @param syncObjectStorage the sync object storage
 * @param selectiveSyncType the selective sync type
 * @param selectiveSyncShards the selective sync shards
 * @param selectiveSyncNamespaceIds the selective sync namespace ids
 * @param selectiveSyncOrganizationIds the selective sync organization ids
 * @param minimumReverificationInterval the minimum reverification interval
 * @param checksumMismatchReportThreshold the checksum mismatch report threshold
 * @param checksumMismatchSelfHealCooldownMinutes the checksum mismatch self heal cooldown minutes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GeoNodesId/requestBody")
public record GitLabGeoNodesUpdatePayload(
        @Nullable Boolean enabled,
        @Nullable String name,
        @Nullable String url,
        @Nullable String internalUrl,
        @Nullable Integer filesMaxCapacity,
        @Nullable Integer reposMaxCapacity,
        @Nullable Integer verificationMaxCapacity,
        @Nullable Integer containerRepositoriesMaxCapacity,
        @Nullable Boolean syncObjectStorage,
        @Nullable String selectiveSyncType,
        @Nullable List<String> selectiveSyncShards,
        @Nullable List<Long> selectiveSyncNamespaceIds,
        @Nullable List<Long> selectiveSyncOrganizationIds,
        @Nullable Integer minimumReverificationInterval,
        @Nullable Integer checksumMismatchReportThreshold,
        @Nullable Integer checksumMismatchSelfHealCooldownMinutes) {
    public GitLabGeoNodesUpdatePayload {
        requireAtLeastIfPresent(filesMaxCapacity, 0, "filesMaxCapacity");
        requireAtLeastIfPresent(reposMaxCapacity, 0, "reposMaxCapacity");
        requireAtLeastIfPresent(verificationMaxCapacity, 0, "verificationMaxCapacity");
        requireAtLeastIfPresent(containerRepositoriesMaxCapacity, 0, "containerRepositoriesMaxCapacity");
        if (selectiveSyncShards != null) {
            selectiveSyncShards = List.copyOf(selectiveSyncShards);
        }
        if (selectiveSyncNamespaceIds != null) {
            selectiveSyncNamespaceIds = List.copyOf(selectiveSyncNamespaceIds);
        }
        if (selectiveSyncOrganizationIds != null) {
            selectiveSyncOrganizationIds = List.copyOf(selectiveSyncOrganizationIds);
        }
    }
}
