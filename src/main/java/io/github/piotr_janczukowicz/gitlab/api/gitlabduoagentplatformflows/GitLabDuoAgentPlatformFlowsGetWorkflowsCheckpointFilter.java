package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AiDuoWorkflowsWorkflowsIdCheckpointsCheckpointId}, without
 * paging.
 *
 * @param acceptCompressed the accept compressed
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AiDuoWorkflowsWorkflowsIdCheckpointsCheckpointId/parameters")
public record GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter(
        @Nullable Boolean acceptCompressed) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter empty() {
        return GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("accept_compressed", acceptCompressed)
                .build();
    }
}
