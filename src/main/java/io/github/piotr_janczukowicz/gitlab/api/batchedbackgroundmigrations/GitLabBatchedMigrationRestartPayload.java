package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminBatchedBackgroundOperationsIdRestart}.
 *
 * @param database the database
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminBatchedBackgroundOperationsIdRestart/requestBody")
public record GitLabBatchedMigrationRestartPayload(@Nullable GitLabBatchedMigrationRestartDatabase database) {}
