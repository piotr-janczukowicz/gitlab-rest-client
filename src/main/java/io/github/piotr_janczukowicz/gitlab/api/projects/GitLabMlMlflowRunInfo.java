package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow run info.
 *
 * @param runId the run id
 * @param runUuid the run uuid
 * @param experimentId the experiment id
 * @param startTime the start time
 * @param endTime the end time
 * @param runName the run name
 * @param status the status
 * @param artifactUri the artifact uri
 * @param lifecycleStage the lifecycle stage
 * @param userId the user id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowRunInfo")
public record GitLabMlMlflowRunInfo(
        @Nullable String runId,
        @Nullable String runUuid,
        @Nullable String experimentId,
        @Nullable Integer startTime,
        @Nullable Integer endTime,
        @Nullable String runName,
        @Nullable String status,
        @Nullable String artifactUri,
        @Nullable String lifecycleStage,
        @Nullable String userId) {}
