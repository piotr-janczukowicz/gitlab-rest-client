package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param userDefaultExternal the user default external
 * @param userShowAddSshKeyMessage the user show add ssh key message
 * @param userDefaultInternalRegex the user default internal regex
 * @param userOauthApplications the user oauth applications
 * @param userDeactivationEmailsEnabled the user deactivation emails enabled
 * @param userDefaultsToPrivateProfile the user defaults to private profile
 * @param userContributedProjectsApiLimit the user contributed projects api limit
 * @param userProjectsApiLimit the user projects api limit
 * @param userStarredProjectsApiLimit the user starred projects api limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingUser(
        @Nullable String userDefaultExternal,
        @Nullable String userShowAddSshKeyMessage,
        @Nullable String userDefaultInternalRegex,
        @Nullable String userOauthApplications,
        @Nullable String userDeactivationEmailsEnabled,
        @Nullable String userDefaultsToPrivateProfile,
        @Nullable String userContributedProjectsApiLimit,
        @Nullable String userProjectsApiLimit,
        @Nullable String userStarredProjectsApiLimit) {}
