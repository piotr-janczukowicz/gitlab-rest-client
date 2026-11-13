package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param usersGetByIdLimit the users get by id limit
 * @param usersApiLimitFollowers the users api limit followers
 * @param usersApiLimitFollowing the users api limit following
 * @param usersApiLimitGpgKey the users api limit gpg key
 * @param usersApiLimitGpgKeys the users api limit gpg keys
 * @param usersApiLimitStatus the users api limit status
 * @param usersGetByIdLimitAllowlistRaw the users get by id limit allowlist raw
 * @param usersApiLimitSshKeys the users api limit ssh keys
 * @param usersApiLimitSshKey the users api limit ssh key
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateUsers(
        @Nullable Integer usersGetByIdLimit,
        @Nullable String usersApiLimitFollowers,
        @Nullable String usersApiLimitFollowing,
        @Nullable String usersApiLimitGpgKey,
        @Nullable String usersApiLimitGpgKeys,
        @Nullable String usersApiLimitStatus,
        @Nullable String usersGetByIdLimitAllowlistRaw,
        @Nullable String usersApiLimitSshKeys,
        @Nullable String usersApiLimitSshKey) {}
