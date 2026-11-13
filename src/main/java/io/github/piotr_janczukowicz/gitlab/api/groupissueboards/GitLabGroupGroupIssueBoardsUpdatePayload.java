package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdBoardsBoardId}.
 *
 * @param name the name
 * @param hideBacklogList the hide backlog list
 * @param hideClosedList the hide closed list
 * @param assigneeId the assignee id
 * @param milestoneId the milestone id
 * @param labels the labels
 * @param weight the weight
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdBoardsBoardId/requestBody")
public record GitLabGroupGroupIssueBoardsUpdatePayload(
        @Nullable String name,
        @Nullable Boolean hideBacklogList,
        @Nullable Boolean hideClosedList,
        @Nullable Long assigneeId,
        @Nullable Long milestoneId,
        @Nullable String labels,
        @Nullable Integer weight) {}
