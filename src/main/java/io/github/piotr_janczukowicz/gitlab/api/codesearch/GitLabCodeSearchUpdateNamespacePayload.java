package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeastIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4AdminZoektNamespacesId}.
 *
 * @param numberOfReplicasOverride the number of replicas override
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4AdminZoektNamespacesId/requestBody")
public record GitLabCodeSearchUpdateNamespacePayload(
        @Nullable Integer numberOfReplicasOverride) {
    public GitLabCodeSearchUpdateNamespacePayload {
        requireAtLeastIfPresent(numberOfReplicasOverride, 1, "numberOfReplicasOverride");
    }
}
