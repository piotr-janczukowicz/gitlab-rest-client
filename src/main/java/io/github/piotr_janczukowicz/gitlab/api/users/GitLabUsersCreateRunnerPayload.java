package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UserRunners}.
 *
 * @param runnerType the runner type
 * @param groupId the group id
 * @param projectId the project id
 * @param description the description
 * @param maintenanceNote the maintenance note
 * @param paused the paused
 * @param locked the locked
 * @param accessLevel the access level
 * @param runUntagged the run untagged
 * @param tagList the tag list
 * @param maximumTimeout the maximum timeout
 * @param tokenExpiresAt the token expires at
 * @param tokenRotationDeadline the token rotation deadline
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UserRunners/requestBody")
public record GitLabUsersCreateRunnerPayload(
        GitLabUsersCreateRunnerType runnerType,
        @Nullable Long groupId,
        @Nullable Long projectId,
        @Nullable String description,
        @Nullable String maintenanceNote,
        @Nullable Boolean paused,
        @Nullable Boolean locked,
        @Nullable GitLabUsersCreateRunnerAccessLevel accessLevel,
        @Nullable Boolean runUntagged,
        @Nullable List<String> tagList,
        @Nullable Integer maximumTimeout,
        @Nullable Instant tokenExpiresAt,
        @Nullable Instant tokenRotationDeadline) {
    public GitLabUsersCreateRunnerPayload {
        requireNonNull(runnerType, "runnerType");
        if (tagList != null) {
            tagList = List.copyOf(tagList);
        }
    }
}
