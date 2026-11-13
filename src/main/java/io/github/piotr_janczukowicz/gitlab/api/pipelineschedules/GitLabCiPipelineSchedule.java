package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci pipeline schedule.
 *
 * @param id the id
 * @param description the description
 * @param ref the ref
 * @param cron the cron
 * @param cronTimezone the cron timezone
 * @param nextRunAt the next run at
 * @param active the active
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param owner the owner
 * @param inputs the inputs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiPipelineSchedule")
public record GitLabCiPipelineSchedule(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String ref,
        @Nullable String cron,
        @Nullable String cronTimezone,
        @Nullable Instant nextRunAt,
        @Nullable Boolean active,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable GitLabUserBasic owner,
        @Nullable List<GitLabCiInput> inputs) {}
