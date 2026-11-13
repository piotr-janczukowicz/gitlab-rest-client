package io.github.piotr_janczukowicz.gitlab.api.databasemigrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AdminMigrationsTimestampMark}.
 *
 * @param database the database
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AdminMigrationsTimestampMark/requestBody")
public record GitLabDatabaseMigrationsCreatePayload(
        @Nullable GitLabDatabaseMigrationsCreateDatabase database) {}
