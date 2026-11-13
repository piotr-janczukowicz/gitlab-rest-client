package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param usersGetByIdLimit the users get by id limit
 * @param usersGetByIdLimitAllowlistRaw the users get by id limit allowlist raw
 * @param usersApiLimitFollowers the users api limit followers
 * @param usersApiLimitFollowing the users api limit following
 * @param usersApiLimitStatus the users api limit status
 * @param usersApiLimitSshKeys the users api limit ssh keys
 * @param usersApiLimitSshKey the users api limit ssh key
 * @param usersApiLimitGpgKeys the users api limit gpg keys
 * @param usersApiLimitGpgKey the users api limit gpg key
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingUsers(
        @Nullable String usersGetByIdLimit,
        @Nullable String usersGetByIdLimitAllowlistRaw,
        @Nullable String usersApiLimitFollowers,
        @Nullable String usersApiLimitFollowing,
        @Nullable String usersApiLimitStatus,
        @Nullable String usersApiLimitSshKeys,
        @Nullable String usersApiLimitSshKey,
        @Nullable String usersApiLimitGpgKeys,
        @Nullable String usersApiLimitGpgKey) {}
