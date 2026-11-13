package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4BulkImports}.
 *
 * @param configuration the configuration
 * @param entities the entities
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4BulkImports/requestBody")
public record GitLabGroupAndProjectMigrationByDirectTransferCreatePayload(
        @Nullable GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration configuration,
        @Nullable List<GitLabGroupAndProjectMigrationByDirectTransferCreateEntity> entities) {
    public GitLabGroupAndProjectMigrationByDirectTransferCreatePayload {
        if (entities != null) {
            entities = List.copyOf(entities);
        }
    }
}
