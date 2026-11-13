package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUser;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci bridge.
 *
 * @param id the id
 * @param status the status
 * @param stage the stage
 * @param name the name
 * @param ref the ref
 * @param tag the tag
 * @param coverage the coverage
 * @param allowFailure the allow failure
 * @param createdAt the created at
 * @param startedAt the started at
 * @param finishedAt the finished at
 * @param erasedAt the erased at
 * @param duration the duration
 * @param queuedDuration the queued duration
 * @param user the user
 * @param commit the commit
 * @param pipeline the pipeline
 * @param failureReason the failure reason
 * @param webUrl the web url
 * @param project the project
 * @param downstreamPipeline the downstream pipeline
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiBridge")
public record GitLabCiBridge(
        @Nullable Long id,
        @Nullable String status,
        @Nullable String stage,
        @Nullable String name,
        @Nullable String ref,
        @Nullable Boolean tag,
        @Nullable Double coverage,
        @Nullable Boolean allowFailure,
        @Nullable Instant createdAt,
        @Nullable Instant startedAt,
        @Nullable Instant finishedAt,
        @Nullable Instant erasedAt,
        @Nullable Double duration,
        @Nullable Double queuedDuration,
        @Nullable GitLabUser user,
        @Nullable GitLabCommit commit,
        @Nullable GitLabCiPipelineBasic pipeline,
        @Nullable String failureReason,
        @Nullable String webUrl,
        @Nullable GitLabCiBridgeProject project,
        @Nullable GitLabCiPipelineBasic downstreamPipeline) {}
