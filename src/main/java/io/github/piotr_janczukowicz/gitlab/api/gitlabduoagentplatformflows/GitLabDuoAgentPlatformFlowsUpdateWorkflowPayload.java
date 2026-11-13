package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4AiDuoWorkflowsWorkflowsId}.
 *
 * @param statusEvent the status event
 * @param dropReason the drop reason
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4AiDuoWorkflowsWorkflowsId/requestBody")
public record GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload(
        @Nullable String statusEvent, @Nullable String dropReason) {
    public GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload {
        requireMaxLengthIfPresent(dropReason, 64, "dropReason");
    }
}
