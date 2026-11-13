package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo chat completions create current file of a GitLab resource.
 *
 * @param fileName the file name
 * @param contentAboveCursor the content above cursor
 * @param contentBelowCursor the content below cursor
 * @param selectedText the selected text
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ChatCompletions/requestBody/properties/current_file")
public record GitLabDuoChatCompletionsCreateCurrentFile(
        @Nullable String fileName,
        @Nullable String contentAboveCursor,
        @Nullable String contentBelowCursor,
        @Nullable String selectedText) {
    public GitLabDuoChatCompletionsCreateCurrentFile {
        requireMaxLengthIfPresent(fileName, 1000, "fileName");
        requireMaxLengthIfPresent(contentAboveCursor, 400_000, "contentAboveCursor");
        requireMaxLengthIfPresent(contentBelowCursor, 400_000, "contentBelowCursor");
        requireMaxLengthIfPresent(selectedText, 400_000, "selectedText");
    }
}
