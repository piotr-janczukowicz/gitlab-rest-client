package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDetailedStatusEntity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci pipeline with metadata.
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
 * @param beforeSha the before sha
 * @param tag the tag
 * @param yamlErrors the yaml errors
 * @param user the user
 * @param startedAt the started at
 * @param finishedAt the finished at
 * @param committedAt the committed at
 * @param duration the duration
 * @param queuedDuration the queued duration
 * @param coverage the coverage
 * @param detailedStatus the detailed status
 * @param archived the archived
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiPipelineWithMetadata")
public record GitLabCiPipelineWithMetadata(
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
        @Nullable String beforeSha,
        @Nullable Boolean tag,
        @Nullable String yamlErrors,
        @Nullable GitLabUserBasic user,
        @Nullable Instant startedAt,
        @Nullable Instant finishedAt,
        @Nullable Instant committedAt,
        @Nullable Integer duration,
        @Nullable Integer queuedDuration,
        @Nullable String coverage,
        @Nullable GitLabDetailedStatusEntity detailedStatus,
        @Nullable Boolean archived,
        @Nullable String name) {}
