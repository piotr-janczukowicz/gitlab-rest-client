package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsWorkflowsIdCheckpoints}.
 *
 * @param threadTs the thread ts
 * @param parentTs the parent ts
 * @param checkpointNs the checkpoint ns
 * @param checkpoint the checkpoint
 * @param compressedCheckpoint the compressed checkpoint
 * @param metadata the metadata
 * @param modelMetadataJson the model metadata json
 * @param flowMetadataJson the flow metadata json
 * @param currentThread the current thread
 * @param channelKeys the channel keys
 * @param channelBlobs the channel blobs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdCheckpoints/requestBody")
public record GitLabDuoWorkflowCheckpointCreatePayload(
        @Nullable String threadTs,
        @Nullable String parentTs,
        @Nullable String checkpointNs,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> checkpoint,

        @Nullable String compressedCheckpoint,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> metadata,

        @Nullable String modelMetadataJson,
        @Nullable String flowMetadataJson,
        @Nullable Integer currentThread,
        @Nullable List<String> channelKeys,
        @Nullable List<GitLabDuoWorkflowCheckpointCreateChannelBlob> channelBlobs) {
    public GitLabDuoWorkflowCheckpointCreatePayload {
        requireMaxLengthIfPresent(checkpointNs, 4096, "checkpointNs");
        if (checkpoint != null) {
            checkpoint = Map.copyOf(checkpoint);
        }
        if (metadata != null) {
            metadata = Map.copyOf(metadata);
        }
        if (channelKeys != null) {
            channelKeys = List.copyOf(channelKeys);
        }
        if (channelBlobs != null) {
            channelBlobs = List.copyOf(channelBlobs);
        }
    }
}
