package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4Snippets}.
 *
 * @param title the title
 * @param description the description
 * @param visibility the visibility
 * @param files the files
 * @param content the content
 * @param fileName the file name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Snippets/requestBody")
public record GitLabCodeSnippetsCreatePayload(
        @Nullable String title,
        @Nullable String description,
        @Nullable GitLabCodeSnippetsCreateVisibility visibility,
        @Nullable List<GitLabCodeSnippetsCreateFile> files,
        @Nullable String content,
        @Nullable String fileName) {
    public GitLabCodeSnippetsCreatePayload {
        if (files != null) {
            files = List.copyOf(files);
        }
    }
}
