package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab code suggestions create completion context of a GitLab resource.
 *
 * @param type the type
 * @param name the name
 * @param content the content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4CodeSuggestionsCompletions/requestBody/properties/context/items")
public record GitLabCodeSuggestionsCreateCompletionContext(
        GitLabCodeSuggestionsCreateCompletionContextType type,
        @Nullable String name,
        @Nullable String content) {
    public GitLabCodeSuggestionsCreateCompletionContext {
        requireNonNull(type, "type");
        requireMaxLengthIfPresent(name, 255, "name");
        requireMaxLengthIfPresent(content, 600_000, "content");
    }
}
