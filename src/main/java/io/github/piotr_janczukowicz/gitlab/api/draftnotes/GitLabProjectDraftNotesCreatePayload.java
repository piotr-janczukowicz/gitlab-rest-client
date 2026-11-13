package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotes}.
 *
 * @param note the note
 * @param inReplyToDiscussionId the in reply to discussion id
 * @param commitId the commit id
 * @param resolveDiscussion the resolve discussion
 * @param position the position
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotes/requestBody")
public record GitLabProjectDraftNotesCreatePayload(
        @Nullable String note,
        @Nullable String inReplyToDiscussionId,
        @Nullable String commitId,
        @Nullable Boolean resolveDiscussion,
        @Nullable GitLabProjectDraftNotesCreatePosition position) {}
