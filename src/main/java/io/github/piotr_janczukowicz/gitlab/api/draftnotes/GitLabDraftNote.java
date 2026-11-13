package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab draft note.
 *
 * @param id the id
 * @param authorId the author id
 * @param mergeRequestId the merge request id
 * @param resolveDiscussion the resolve discussion
 * @param discussionId the discussion id
 * @param note the note
 * @param commitId the commit id
 * @param lineCode the line code
 * @param position the position
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDraftNote")
public record GitLabDraftNote(
        @Nullable Long id,
        @Nullable Long authorId,
        @Nullable Long mergeRequestId,
        @Nullable Boolean resolveDiscussion,
        @Nullable String discussionId,
        @Nullable String note,
        @Nullable String commitId,
        @Nullable String lineCode,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> position) {}
