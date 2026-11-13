package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner manager.
 *
 * @param id the id
 * @param systemId the system id
 * @param version the version
 * @param revision the revision
 * @param platform the platform
 * @param architecture the architecture
 * @param createdAt the created at
 * @param contactedAt the contacted at
 * @param ipAddress the ip address
 * @param status the status
 * @param jobExecutionStatus the job execution status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerManager")
public record GitLabCiRunnerManager(
        @Nullable Long id,
        @Nullable String systemId,
        @Nullable String version,
        @Nullable String revision,
        @Nullable String platform,
        @Nullable String architecture,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (contacted_at)")
        Instant contactedAt,

        @Nullable String ipAddress,
        @Nullable String status,
        @Nullable GitLabCiRunnerManagerJobExecutionStatus jobExecutionStatus) {}
