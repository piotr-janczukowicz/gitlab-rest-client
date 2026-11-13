package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectAliases}.
 *
 * @param projectId the project id
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectAliases/requestBody")
public record GitLabProjectAliasesCreatePayload(
        @Nullable String projectId, @Nullable String name) {}
