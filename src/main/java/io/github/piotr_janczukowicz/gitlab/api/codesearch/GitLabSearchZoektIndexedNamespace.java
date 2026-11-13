package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab search zoekt indexed namespace.
 *
 * @param id the id
 * @param zoektShardId the zoekt shard id
 * @param zoektNodeId the zoekt node id
 * @param namespaceId the namespace id
 * @param numberOfReplicasOverride the number of replicas override
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSearchZoektIndexedNamespace")
public record GitLabSearchZoektIndexedNamespace(
        @Nullable Long id,
        @Nullable Long zoektShardId,
        @Nullable Long zoektNodeId,
        @Nullable Long namespaceId,
        @Nullable Integer numberOfReplicasOverride) {}
