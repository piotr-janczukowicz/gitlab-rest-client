package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdIssuesIssueIidNotesNoteIdAwardEmoji}.
 *
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdIssuesIssueIidNotesNoteIdAwardEmoji/requestBody")
public record GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload(
        @Nullable String name) {}
