package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdExportRelations}.
 *
 * @param batched the batched
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdExportRelations/requestBody")
public record GitLabGroupGroupImportAndExportCreateExportRelationPayload(
        @Nullable Boolean batched) {}
