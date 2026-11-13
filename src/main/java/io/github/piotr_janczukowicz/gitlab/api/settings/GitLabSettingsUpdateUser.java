package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param userDeactivationEmailsEnabled the user deactivation emails enabled
 * @param userDefaultExternal the user default external
 * @param userDefaultInternalRegex the user default internal regex
 * @param userDefaultsToPrivateProfile the user defaults to private profile
 * @param userOauthApplications the user oauth applications
 * @param userShowAddSshKeyMessage the user show add ssh key message
 * @param userContributedProjectsApiLimit the user contributed projects api limit
 * @param userProjectsApiLimit the user projects api limit
 * @param userStarredProjectsApiLimit the user starred projects api limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateUser(
        @Nullable Boolean userDeactivationEmailsEnabled,
        @Nullable String userDefaultExternal,
        @Nullable String userDefaultInternalRegex,
        @Nullable String userDefaultsToPrivateProfile,
        @Nullable String userOauthApplications,
        @Nullable String userShowAddSshKeyMessage,
        @Nullable String userContributedProjectsApiLimit,
        @Nullable String userProjectsApiLimit,
        @Nullable String userStarredProjectsApiLimit) {}
