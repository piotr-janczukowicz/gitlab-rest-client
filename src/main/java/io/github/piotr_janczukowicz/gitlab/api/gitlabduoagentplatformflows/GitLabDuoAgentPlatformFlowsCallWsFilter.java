package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AiDuoWorkflowsWs}, without paging.
 *
 * @param workflowId the workflow id
 * @param environment the environment
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AiDuoWorkflowsWs/parameters")
public record GitLabDuoAgentPlatformFlowsCallWsFilter(
        @Nullable String workflowId, @Nullable String environment) {
    public GitLabDuoAgentPlatformFlowsCallWsFilter {
        requireMaxLengthIfPresent(environment, 255, "environment");
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabDuoAgentPlatformFlowsCallWsFilter empty() {
        return GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("workflow_id", workflowId)
                .text("environment", environment)
                .build();
    }
}
