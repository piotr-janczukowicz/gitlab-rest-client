package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge trains car.
 *
 * @param id the id
 * @param mergeRequest the merge request
 * @param user the user
 * @param pipeline the pipeline
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param targetBranch the target branch
 * @param status the status
 * @param mergedAt the merged at
 * @param duration the duration
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeTrainsCar")
public record GitLabMergeTrainsCar(
        @Nullable Long id,
        @Nullable GitLabMergeRequestSimple mergeRequest,
        @Nullable GitLabUserBasic user,
        @Nullable GitLabCiPipelineBasic pipeline,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String targetBranch,
        @Nullable GitLabMergeTrainsCarStatus status,
        @Nullable Instant mergedAt,
        @Nullable Integer duration) {}
