package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdDependencyListExports}.
 *
 * @param sendEmail the send email
 * @param exportType the export type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdDependencyListExports/requestBody")
public record GitLabGroupGroupsCreateDependencyListExportPayload(
        @Nullable Boolean sendEmail, @Nullable GitLabGroupGroupsCreateDependencyListExportType exportType) {}
