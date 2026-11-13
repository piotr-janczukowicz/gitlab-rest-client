package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4CodeSuggestionsCompletions}.
 *
 * @param currentFile the current file
 * @param intent the intent
 * @param generationType the generation type
 * @param stream the stream
 * @param projectPath the project path
 * @param userInstruction the user instruction
 * @param context the context
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4CodeSuggestionsCompletions/requestBody")
public record GitLabCodeSuggestionsCreateCompletionPayload(
        @Nullable GitLabCodeSuggestionsCreateCompletionCurrentFile currentFile,
        @Nullable GitLabCodeSuggestionsCreateCompletionIntent intent,
        @Nullable GitLabCodeSuggestionsCreateCompletionGenerationType generationType,
        @Nullable Boolean stream,
        @Nullable String projectPath,
        @Nullable String userInstruction,
        @Nullable List<GitLabCodeSuggestionsCreateCompletionContext> context) {
    public GitLabCodeSuggestionsCreateCompletionPayload {
        requireMaxLengthIfPresent(userInstruction, 600_000, "userInstruction");
        if (context != null) {
            context = List.copyOf(context);
        }
    }
}
