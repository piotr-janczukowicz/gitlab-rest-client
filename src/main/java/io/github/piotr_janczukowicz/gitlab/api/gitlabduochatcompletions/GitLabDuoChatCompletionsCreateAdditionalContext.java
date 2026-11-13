package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo chat completions create additional context of a GitLab resource.
 *
 * @param category the category
 * @param id the id
 * @param content the content
 * @param metadata the metadata
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ChatCompletions/requestBody/properties/additional_context/items")
public record GitLabDuoChatCompletionsCreateAdditionalContext(
        GitLabDuoChatCompletionsCreateAdditionalContextCategory category,
        @Nullable String id,
        @Nullable String content,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> metadata) {
    public GitLabDuoChatCompletionsCreateAdditionalContext {
        requireNonNull(category, "category");
        requireMaxLengthIfPresent(id, 255, "id");
        requireMaxLengthIfPresent(content, 1000, "content");
        if (metadata != null) {
            metadata = Map.copyOf(metadata);
        }
    }
}
