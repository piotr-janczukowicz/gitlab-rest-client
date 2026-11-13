package io.github.piotr_janczukowicz.gitlab.api.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai semantic code snippet range.
 *
 * @param startLine the start line
 * @param endLine the end line
 * @param content the content
 * @param score the score
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiSemanticCodeSnippetRange")
public record GitLabAiSemanticCodeSnippetRange(
        @Nullable Integer startLine,
        @Nullable Integer endLine,
        @Nullable String content,
        @Nullable Double score) {}
