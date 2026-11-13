package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab suggestion.
 *
 * @param id the id
 * @param fromLine the from line
 * @param toLine the to line
 * @param appliable the appliable
 * @param applied the applied
 * @param fromContent the from content
 * @param toContent the to content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSuggestion")
public record GitLabSuggestion(
        @Nullable Long id,
        @Nullable Integer fromLine,
        @Nullable Integer toLine,
        @Nullable Boolean appliable,
        @Nullable Boolean applied,
        @Nullable String fromContent,
        @Nullable String toContent) {}
