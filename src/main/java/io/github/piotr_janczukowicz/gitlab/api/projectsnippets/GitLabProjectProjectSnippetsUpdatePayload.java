package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdSnippetsSnippetId}.
 *
 * @param content the content
 * @param description the description
 * @param fileName the file name
 * @param title the title
 * @param visibility the visibility
 * @param files the files
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdSnippetsSnippetId/requestBody")
public record GitLabProjectProjectSnippetsUpdatePayload(
        @Nullable String content,
        @Nullable String description,
        @Nullable String fileName,
        @Nullable String title,
        @Nullable GitLabProjectProjectSnippetsUpdateVisibility visibility,
        @Nullable List<GitLabProjectProjectSnippetsUpdateFile> files) {
    public GitLabProjectProjectSnippetsUpdatePayload {
        if (files != null) {
            files = List.copyOf(files);
        }
    }
}
