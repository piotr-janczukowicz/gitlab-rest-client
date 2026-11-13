package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai duo workflows checkpoint.
 *
 * @param id the id
 * @param threadTs the thread ts
 * @param parentTs the parent ts
 * @param checkpointNs the checkpoint ns
 * @param checkpoint the checkpoint
 * @param compressedCheckpoint the compressed checkpoint
 * @param checkpointWrites the checkpoint writes
 * @param currentThread the current thread
 * @param metadata the metadata
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiDuoWorkflowsCheckpoint")
public record GitLabAiDuoWorkflowsCheckpoint(
        @Nullable Long id,
        @Nullable String threadTs,
        @Nullable String parentTs,
        @Nullable String checkpointNs,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> checkpoint,

        @Nullable String compressedCheckpoint,
        @Nullable List<GitLabAiDuoWorkflowsCheckpointWrite> checkpointWrites,
        @Nullable Integer currentThread,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> metadata) {}
