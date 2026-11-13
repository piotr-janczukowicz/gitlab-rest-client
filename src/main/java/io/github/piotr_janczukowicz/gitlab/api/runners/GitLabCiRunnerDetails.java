package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicGroupDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner details.
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
 * @param uuid the uuid
 * @param tagList the tag list
 * @param runUntagged the run untagged
 * @param locked the locked
 * @param maximumTimeout the maximum timeout
 * @param accessLevel the access level
 * @param tokenExpiresAt the token expires at
 * @param version the version
 * @param revision the revision
 * @param platform the platform
 * @param architecture the architecture
 * @param contactedAt the contacted at
 * @param maintenanceNote the maintenance note
 * @param projects the projects
 * @param groups the groups
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerDetails")
public record GitLabCiRunnerDetails(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String ipAddress,
        @Nullable Boolean active,
        @Nullable Boolean paused,
        @Nullable Boolean isShared,
        @Nullable GitLabCiRunnerDetailsRunnerType runnerType,
        @Nullable String name,
        @Nullable Boolean online,
        @Nullable GitLabUserBasic createdBy,
        @Nullable Instant createdAt,
        @Nullable String status,
        @Nullable GitLabCiRunnerDetailsJobExecutionStatus jobExecutionStatus,
        @Nullable String uuid,
        @Nullable String tagList,
        @Nullable String runUntagged,
        @Nullable String locked,
        @Nullable String maximumTimeout,
        @Nullable String accessLevel,
        @Nullable Instant tokenExpiresAt,
        @Nullable String version,
        @Nullable String revision,
        @Nullable String platform,
        @Nullable String architecture,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (contacted_at)")
        Instant contactedAt,

        @Nullable String maintenanceNote,
        @Nullable List<GitLabBasicProjectDetails> projects,
        @Nullable List<GitLabBasicGroupDetails> groups) {}
