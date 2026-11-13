package io.github.piotr_janczukowicz.gitlab.api.discussions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project commit discussion create position line range of a GitLab resource.
 *
 * @param start the start
 * @param end the end
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/postApiV4ProjectsIdRepositoryCommitsNoteableIdDiscussions/requestBody/properties/position/properties/line_range")
public record GitLabProjectCommitDiscussionCreatePositionLineRange(
        @Nullable GitLabProjectCommitDiscussionCreatePositionLineRangeStart start,
        @Nullable GitLabProjectCommitDiscussionCreatePositionLineRangeEnd end) {}
