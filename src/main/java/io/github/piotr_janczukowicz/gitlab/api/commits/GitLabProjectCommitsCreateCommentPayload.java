package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRepositoryCommitsShaComments}.
 *
 * @param note the note
 * @param path the path
 * @param line the line
 * @param lineType the line type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryCommitsShaComments/requestBody")
public record GitLabProjectCommitsCreateCommentPayload(
        @Nullable String note,
        @Nullable String path,
        @Nullable Integer line,
        GitLabProjectCommitsCreateCommentLineType lineType) {
    public GitLabProjectCommitsCreateCommentPayload {
        requireNonNull(lineType, "lineType");
    }
}
