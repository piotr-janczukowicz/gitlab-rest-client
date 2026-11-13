package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner.
 *
 * @param id the id
 * @param description the description
 * @param ipAddress the ip address
 * @param active the active
 * @param paused the paused
 * @param isShared the is shared
 * @param runnerType the runner type
 * @param name the name
 * @param online the online
 * @param createdBy the created by
 * @param createdAt the created at
 * @param status the status
 * @param jobExecutionStatus the job execution status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunner")
public record GitLabCiRunner(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String ipAddress,
        @Nullable Boolean active,
        @Nullable Boolean paused,
        @Nullable Boolean isShared,
        @Nullable GitLabCiRunnerType runnerType,
        @Nullable String name,
        @Nullable Boolean online,
        @Nullable GitLabUserBasic createdBy,
        @Nullable Instant createdAt,
        @Nullable String status,
        @Nullable GitLabCiRunnerJobExecutionStatus jobExecutionStatus) {}
