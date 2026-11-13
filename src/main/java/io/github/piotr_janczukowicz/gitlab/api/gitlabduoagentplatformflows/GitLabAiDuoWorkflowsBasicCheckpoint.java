package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai duo workflows basic checkpoint.
 *
 * @param id the id
 * @param threadTs the thread ts
 * @param parentTs the parent ts
 * @param checkpointNs the checkpoint ns
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiDuoWorkflowsBasicCheckpoint")
public record GitLabAiDuoWorkflowsBasicCheckpoint(
        @Nullable Long id,
        @Nullable String threadTs,
        @Nullable String parentTs,
        @Nullable String checkpointNs) {}
