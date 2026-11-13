package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab code snippets update file of a GitLab resource.
 *
 * @param action the action
 * @param content the content
 * @param filePath the file path
 * @param previousPath the previous path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4SnippetsId/requestBody/properties/files/items")
public record GitLabCodeSnippetsUpdateFile(
        GitLabCodeSnippetsUpdateFileAction action,
        @Nullable String content,
        @Nullable String filePath,
        @Nullable String previousPath) {
    public GitLabCodeSnippetsUpdateFile {
        requireNonNull(action, "action");
    }
}
