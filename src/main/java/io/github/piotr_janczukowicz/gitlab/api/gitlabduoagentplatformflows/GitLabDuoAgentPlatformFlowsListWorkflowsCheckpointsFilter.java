package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AiDuoWorkflowsWorkflowsIdCheckpoints}, without paging.
 *
 * @param acceptCompressed the accept compressed
 * @param checkpointNs the checkpoint ns
 * @param channels the channels
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AiDuoWorkflowsWorkflowsIdCheckpoints/parameters")
public record GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter(
        @Nullable Boolean acceptCompressed,
        @Nullable String checkpointNs,
        @Nullable List<String> channels) {
    public GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter {
        requireMaxLengthIfPresent(checkpointNs, 4096, "checkpointNs");
        if (channels != null) {
            channels = List.copyOf(channels);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter empty() {
        return GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
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
                .text("checkpoint_ns", checkpointNs)
                .list("channels", channels)
                .build();
    }
}
