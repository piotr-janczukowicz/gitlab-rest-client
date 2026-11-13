package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab code suggestions create completion current file of a GitLab resource.
 *
 * @param fileName the file name
 * @param contentAboveCursor the content above cursor
 * @param contentBelowCursor the content below cursor
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4CodeSuggestionsCompletions/requestBody/properties/current_file")
public record GitLabCodeSuggestionsCreateCompletionCurrentFile(
        @Nullable String fileName,
        @Nullable String contentAboveCursor,
        @Nullable String contentBelowCursor) {
    public GitLabCodeSuggestionsCreateCompletionCurrentFile {
        requireMaxLengthIfPresent(fileName, 255, "fileName");
        requireMaxLengthIfPresent(contentAboveCursor, 400_000, "contentAboveCursor");
        requireMaxLengthIfPresent(contentBelowCursor, 400_000, "contentBelowCursor");
    }
}
