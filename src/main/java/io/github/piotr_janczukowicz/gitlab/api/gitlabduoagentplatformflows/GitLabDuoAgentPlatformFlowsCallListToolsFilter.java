package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AiDuoWorkflowsListTools}, without paging.
 *
 * @param workflowDefinition the workflow definition
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AiDuoWorkflowsListTools/parameters")
public record GitLabDuoAgentPlatformFlowsCallListToolsFilter(
        @Nullable String workflowDefinition) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabDuoAgentPlatformFlowsCallListToolsFilter empty() {
        return GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("workflow_definition", workflowDefinition)
                .build();
    }
}
