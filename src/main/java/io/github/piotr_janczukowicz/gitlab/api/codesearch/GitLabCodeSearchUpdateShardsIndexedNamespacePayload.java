package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminZoektShardsNodeIdIndexedNamespacesNamespaceId}.
 *
 * @param search the search
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminZoektShardsNodeIdIndexedNamespacesNamespaceId/requestBody")
public record GitLabCodeSearchUpdateShardsIndexedNamespacePayload(
        @Nullable Boolean search) {}
