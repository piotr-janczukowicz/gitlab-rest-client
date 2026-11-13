package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdSnippets}.
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
@CatalogSchema("operations/postApiV4ProjectsIdSnippets/requestBody")
public record GitLabProjectProjectSnippetsCreatePayload(
        @Nullable String title,
        @Nullable String description,
        GitLabProjectProjectSnippetsCreateVisibility visibility,
        @Nullable List<GitLabProjectProjectSnippetsCreateFile> files,
        @Nullable String content,
        @Nullable String fileName) {
    public GitLabProjectProjectSnippetsCreatePayload {
        requireNonNull(visibility, "visibility");
        if (files != null) {
            files = List.copyOf(files);
        }
    }
}
