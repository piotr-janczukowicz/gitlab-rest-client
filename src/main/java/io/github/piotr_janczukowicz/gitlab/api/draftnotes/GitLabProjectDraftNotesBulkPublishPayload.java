package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotesBulkPublish}.
 *
 * @param reviewerState the reviewer state
 * @param note the note
 * @param internal the internal
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotesBulkPublish/requestBody")
public record GitLabProjectDraftNotesBulkPublishPayload(
        @Nullable GitLabProjectDraftNotesBulkPublishReviewerState reviewerState,
        @Nullable String note,
        @Nullable Boolean internal) {}
