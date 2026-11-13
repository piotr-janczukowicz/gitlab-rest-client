package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project draft notes create position line range end of a GitLab resource.
 *
 * @param lineCode the line code
 * @param type the type
 * @param oldLine the old line
 * @param newLine the new line
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotes/requestBody/properties/position/properties/line_range/properties/end")
public record GitLabProjectDraftNotesCreatePositionLineRangeEnd(
        @Nullable String lineCode,
        @Nullable String type,
        @Nullable Integer oldLine,
        @Nullable Integer newLine) {}
