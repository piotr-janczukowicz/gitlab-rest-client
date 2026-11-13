package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job.
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
 * @param artifactsFile the artifacts file
 * @param artifacts the artifacts
 * @param runner the runner
 * @param runnerManager the runner manager
 * @param artifactsExpireAt the artifacts expire at
 * @param archived the archived
 * @param tagList the tag list
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJob")
public record GitLabCiJob(
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
        @Nullable GitLabCiJobProject project,
        @Nullable GitLabCiJobArtifactFile artifactsFile,
        @Nullable List<GitLabCiJobArtifact> artifacts,
        @Nullable GitLabCiRunner runner,
        @Nullable GitLabCiRunnerManager runnerManager,
        @Nullable Instant artifactsExpireAt,
        @Nullable Boolean archived,
        @Nullable List<String> tagList) {}
