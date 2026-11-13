package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdImportGit}.
 *
 * @param importUrl the import url
 * @param importUrlUser the import url user
 * @param importUrlPassword the import url password
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdImportGit/requestBody")
public record GitLabProjectProjectImportExportGitPayload(
        @Nullable String importUrl,
        @Nullable String importUrlUser,
        @Nullable String importUrlPassword) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code importUrlPassword} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectProjectImportExportGitPayload[" + "importUrl=" + importUrl + ", importUrlUser="
                + importUrlUser + ", importUrlPassword=<redacted>" + "]";
    }
}
