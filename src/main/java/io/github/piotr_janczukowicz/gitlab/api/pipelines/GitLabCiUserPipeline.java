package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDetailedStatusEntity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectIdentity;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci user pipeline.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param sha the sha
 * @param ref the ref
 * @param status the status
 * @param source the source
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param webUrl the web url
 * @param name the name
 * @param project the project
 * @param startedAt the started at
 * @param finishedAt the finished at
 * @param duration the duration
 * @param queuedDuration the queued duration
 * @param detailedStatus the detailed status
 * @param mergeRequest the merge request
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiUserPipeline")
public record GitLabCiUserPipeline(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String sha,
        @Nullable String ref,
        @Nullable String status,
        @Nullable String source,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String webUrl,
        @Nullable String name,
        @Nullable GitLabProjectIdentity project,
        @Nullable Instant startedAt,
        @Nullable Instant finishedAt,
        @Nullable Integer duration,
        @Nullable Integer queuedDuration,
        @Nullable GitLabDetailedStatusEntity detailedStatus,
        @Nullable GitLabCiPipelineMergeRequest mergeRequest) {}
