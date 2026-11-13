package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsCodeReviewAddComments}.
 *
 * @param projectId the project id
 * @param mergeRequestIid the merge request iid
 * @param reviewOutput the review output
 * @param workflowId the workflow id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsCodeReviewAddComments/requestBody")
public record GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload(
        @Nullable String projectId,
        @Nullable Long mergeRequestIid,
        @Nullable String reviewOutput,
        @Nullable Long workflowId) {}
