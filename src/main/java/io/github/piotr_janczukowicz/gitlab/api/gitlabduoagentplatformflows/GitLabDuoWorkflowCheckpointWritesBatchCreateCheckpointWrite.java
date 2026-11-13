package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo workflow checkpoint writes batch create checkpoint write of a GitLab resource.
 *
 * @param task the task
 * @param idx the idx
 * @param channel the channel
 * @param writeType the write type
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/postApiV4AiDuoWorkflowsWorkflowsIdCheckpointWritesBatch/requestBody/properties/checkpoint_writes/items")
public record GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite(
        @Nullable String task,
        @Nullable Integer idx,
        @Nullable String channel,
        @Nullable String writeType,
        @Nullable String data) {}
