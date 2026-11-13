package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo workflow checkpoint create channel blob of a GitLab resource.
 *
 * @param channel the channel
 * @param version the version
 * @param writeType the write type
 * @param stepAction the step action
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdCheckpoints/requestBody/properties/channel_blobs/items")
public record GitLabDuoWorkflowCheckpointCreateChannelBlob(
        @Nullable String channel,
        @Nullable String version,
        @Nullable String writeType,
        GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction stepAction,
        @Nullable String data) {
    public GitLabDuoWorkflowCheckpointCreateChannelBlob {
        requireMaxLengthIfPresent(channel, 255, "channel");
        requireMaxLengthIfPresent(version, 255, "version");
        requireMaxLengthIfPresent(writeType, 255, "writeType");
        requireNonNull(stepAction, "stepAction");
        requireMaxLengthIfPresent(data, 1_398_104, "data");
    }
}
