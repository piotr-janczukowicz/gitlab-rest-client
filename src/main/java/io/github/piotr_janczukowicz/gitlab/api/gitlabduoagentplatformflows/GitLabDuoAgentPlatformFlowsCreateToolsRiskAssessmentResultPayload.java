package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsToolsRiskAssessmentResults}.
 *
 * @param projectId the project id
 * @param mergeRequestIid the merge request iid
 * @param diffSha the diff sha
 * @param workflowId the workflow id
 * @param claims the claims
 * @param summary the summary
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsToolsRiskAssessmentResults/requestBody")
public record GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload(
        @Nullable String projectId,
        @Nullable Long mergeRequestIid,
        @Nullable String diffSha,
        @Nullable Long workflowId,
        @Nullable List<GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim> claims,
        @Nullable String summary) {
    public GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload {
        if (claims != null) {
            claims = List.copyOf(claims);
        }
        requireMaxLengthIfPresent(summary, 2048, "summary");
    }
}
