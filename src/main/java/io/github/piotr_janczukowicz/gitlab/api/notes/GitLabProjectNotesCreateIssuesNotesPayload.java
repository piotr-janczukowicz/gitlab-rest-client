package io.github.piotr_janczukowicz.gitlab.api.notes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdIssuesNoteableIdNotes}.
 *
 * @param body the body
 * @param confidential the confidential
 * @param internal the internal
 * @param createdAt the created at
 * @param mergeRequestDiffHeadSha the merge request diff head sha
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdIssuesNoteableIdNotes/requestBody")
public record GitLabProjectNotesCreateIssuesNotesPayload(
        @Nullable String body,
        @Nullable Boolean confidential,
        @Nullable Boolean internal,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String mergeRequestDiffHeadSha) {}
