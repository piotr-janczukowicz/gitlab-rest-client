package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdExportRelations}.
 *
 * @param batched the batched
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdExportRelations/requestBody")
public record GitLabProjectProjectRelationsExportCreatePayload(
        @Nullable Boolean batched) {}
