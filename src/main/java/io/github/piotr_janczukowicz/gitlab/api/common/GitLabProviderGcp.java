package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab provider gcp.
 *
 * @param clusterId the cluster id
 * @param statusName the status name
 * @param gcpProjectId the gcp project id
 * @param zone the zone
 * @param machineType the machine type
 * @param numNodes the num nodes
 * @param endpoint the endpoint
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProviderGcp")
public record GitLabProviderGcp(
        @Nullable String clusterId,
        @Nullable String statusName,
        @Nullable String gcpProjectId,
        @Nullable String zone,
        @Nullable String machineType,
        @Nullable String numNodes,
        @Nullable String endpoint) {}
