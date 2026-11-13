package io.github.piotr_janczukowicz.gitlab.api.notes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdSnippetsNoteableIdNotesNoteId}.
 *
 * @param body the body
 * @param confidential the confidential
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdSnippetsNoteableIdNotesNoteId/requestBody")
public record GitLabProjectNotesUpdateSnippetsNotesPayload(
        @Nullable String body, @Nullable Boolean confidential) {}
