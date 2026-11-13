package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project draft notes create position of a GitLab resource.
 *
 * @param baseSha the base sha
 * @param startSha the start sha
 * @param headSha the head sha
 * @param positionType the position type
 * @param newPath the new path
 * @param newLine the new line
 * @param oldPath the old path
 * @param oldLine the old line
 * @param width the width
 * @param height the height
 * @param x the x
 * @param y the y
 * @param lineRange the line range
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotes/requestBody/properties/position")
public record GitLabProjectDraftNotesCreatePosition(
        @Nullable String baseSha,
        @Nullable String startSha,
        @Nullable String headSha,
        GitLabProjectDraftNotesCreatePositionType positionType,
        @Nullable String newPath,
        @Nullable Integer newLine,
        @Nullable String oldPath,
        @Nullable Integer oldLine,
        @Nullable Integer width,
        @Nullable Integer height,
        @Nullable Integer x,
        @Nullable Integer y,
        @Nullable GitLabProjectDraftNotesCreatePositionLineRange lineRange) {
    public GitLabProjectDraftNotesCreatePosition {
        requireNonNull(positionType, "positionType");
    }
}
