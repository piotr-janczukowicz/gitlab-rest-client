package io.github.piotr_janczukowicz.gitlab.api.notes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsNoteableIdDiscussionsDiscussionIdNotes}.
 *
 * @param body the body
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsNoteableIdDiscussionsDiscussionIdNotes/requestBody")
public record GitLabProjectNotesCreateRequestsDiscussionsNotesPayload(
        @Nullable String body,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt) {}
