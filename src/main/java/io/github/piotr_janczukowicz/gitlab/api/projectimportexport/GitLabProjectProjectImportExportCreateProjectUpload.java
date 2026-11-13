package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project project import export create project upload of a GitLab resource.
 *
 * @param url the url
 * @param httpMethod the http method
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdExport/requestBody/properties/upload")
public record GitLabProjectProjectImportExportCreateProjectUpload(
        @Nullable String url, @Nullable GitLabProjectProjectImportExportCreateProjectUploadHttpMethod httpMethod) {}
