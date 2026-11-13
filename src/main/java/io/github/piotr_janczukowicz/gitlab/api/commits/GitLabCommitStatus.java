package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab commit status.
 *
 * @param id the id
 * @param sha the sha
 * @param ref the ref
 * @param status the status
 * @param name the name
 * @param targetUrl the target url
 * @param description the description
 * @param createdAt the created at
 * @param startedAt the started at
 * @param finishedAt the finished at
 * @param allowFailure the allow failure
 * @param coverage the coverage
 * @param pipelineId the pipeline id
 * @param author the author
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCommitStatus")
public record GitLabCommitStatus(
        @Nullable Long id,
        @Nullable String sha,
        @Nullable String ref,
        @Nullable String status,
        @Nullable String name,
        @Nullable String targetUrl,
        @Nullable String description,
        @Nullable Instant createdAt,
        @Nullable Instant startedAt,
        @Nullable Instant finishedAt,
        @Nullable Boolean allowFailure,
        @Nullable Double coverage,
        @Nullable Long pipelineId,
        @Nullable GitLabUserBasic author) {}
