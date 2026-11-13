package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminActiveContextCollectionsId}.
 *
 * @param queueShardCount the queue shard count
 * @param queueShardLimit the queue shard limit
 * @param connectionId the connection id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminActiveContextCollectionsId/requestBody")
public record GitLabActiveContextUpdateCollectionPayload(
        @Nullable Integer queueShardCount,
        @Nullable Integer queueShardLimit,
        @Nullable Long connectionId) {}
