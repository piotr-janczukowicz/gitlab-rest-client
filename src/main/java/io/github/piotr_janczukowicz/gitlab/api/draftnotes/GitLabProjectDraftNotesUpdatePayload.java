package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotesDraftNoteId}.
 *
 * @param note the note
 * @param position the position
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotesDraftNoteId/requestBody")
public record GitLabProjectDraftNotesUpdatePayload(
        @Nullable String note, @Nullable GitLabProjectDraftNotesUpdatePosition position) {}
