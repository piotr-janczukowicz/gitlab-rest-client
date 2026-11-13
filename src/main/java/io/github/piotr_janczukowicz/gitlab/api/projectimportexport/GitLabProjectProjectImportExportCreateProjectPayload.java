package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdExport}.
 *
 * @param description the description
 * @param upload the upload
 * @param excludedRelations the excluded relations
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdExport/requestBody")
public record GitLabProjectProjectImportExportCreateProjectPayload(
        @Nullable String description,
        @Nullable GitLabProjectProjectImportExportCreateProjectUpload upload,
        @Nullable List<String> excludedRelations) {
    public GitLabProjectProjectImportExportCreateProjectPayload {
        if (excludedRelations != null) {
            excludedRelations = List.copyOf(excludedRelations);
        }
    }
}
