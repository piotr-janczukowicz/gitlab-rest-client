package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab cd rollout.
 *
 * @param id the id
 * @param iid the iid
 * @param state the state
 * @param workflowRef the workflow ref
 * @param startedAt the started at
 * @param finishedAt the finished at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCdRollout")
public record GitLabCdRollout(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable String state,
        @Nullable String workflowRef,
        @Nullable Instant startedAt,
        @Nullable Instant finishedAt) {}
