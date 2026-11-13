package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai duo workflows checkpoint write.
 *
 * @param id the id
 * @param threadTs the thread ts
 * @param task the task
 * @param idx the idx
 * @param channel the channel
 * @param writeType the write type
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiDuoWorkflowsCheckpointWrite")
public record GitLabAiDuoWorkflowsCheckpointWrite(
        @Nullable Long id,
        @Nullable String threadTs,
        @Nullable String task,
        @Nullable Integer idx,
        @Nullable String channel,
        @Nullable String writeType,
        @Nullable String data) {}
