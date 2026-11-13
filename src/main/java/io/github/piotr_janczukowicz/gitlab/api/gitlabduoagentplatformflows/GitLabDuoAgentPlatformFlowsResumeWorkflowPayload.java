package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflowsWorkflowIdResume}.
 *
 * @param humanApproval the human approval
 * @param humanMessage the human message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsWorkflowIdResume/requestBody")
public record GitLabDuoAgentPlatformFlowsResumeWorkflowPayload(
        @Nullable Boolean humanApproval, @Nullable String humanMessage) {
    public GitLabDuoAgentPlatformFlowsResumeWorkflowPayload {
        requireMaxLengthIfPresent(humanMessage, 2000, "humanMessage");
    }
}
