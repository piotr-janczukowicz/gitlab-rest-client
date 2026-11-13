package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdBoardsBoardIdLists}.
 *
 * @param labelId the label id
 * @param milestoneId the milestone id
 * @param iterationId the iteration id
 * @param assigneeId the assignee id
 * @param statusId the status id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdBoardsBoardIdLists/requestBody")
public record GitLabGroupGroupIssueBoardsCreateListPayload(
        @Nullable Long labelId,
        @Nullable Long milestoneId,
        @Nullable Long iterationId,
        @Nullable Long assigneeId,
        @Nullable Long statusId) {}
