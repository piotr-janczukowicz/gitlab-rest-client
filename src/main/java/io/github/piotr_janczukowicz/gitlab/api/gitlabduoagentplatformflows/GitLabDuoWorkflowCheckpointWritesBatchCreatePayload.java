package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflowsIdCheckpointWritesBatch}.
 *
 * @param threadTs the thread ts
 * @param checkpointWrites the checkpoint writes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdCheckpointWritesBatch/requestBody")
public record GitLabDuoWorkflowCheckpointWritesBatchCreatePayload(
        @Nullable String threadTs,
        @Nullable List<GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite> checkpointWrites) {
    public GitLabDuoWorkflowCheckpointWritesBatchCreatePayload {
        if (checkpointWrites != null) {
            checkpointWrites = List.copyOf(checkpointWrites);
        }
    }
}
