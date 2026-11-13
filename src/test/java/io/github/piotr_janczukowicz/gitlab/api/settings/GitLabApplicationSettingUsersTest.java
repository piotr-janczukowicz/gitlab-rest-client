package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingUsersTest {

    @Test
    void constructor_shouldAcceptNull_whenUsersGetByIdLimitIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersGetByIdLimit(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersGetByIdLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersGetByIdLimitAllowlistRawIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersGetByIdLimitAllowlistRaw(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersGetByIdLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitFollowersIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitFollowers(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitFollowers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitFollowingIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitFollowing(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitFollowing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitStatusIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitStatus(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitSshKeysIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitSshKeys(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitSshKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitSshKeyIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitSshKey(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitSshKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitGpgKeysIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitGpgKeys(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitGpgKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitGpgKeyIsNullable() {
        final GitLabApplicationSettingUsersBuilder builder = GitLabApplicationSettingUsersBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUsers())
                .usersApiLimitGpgKey(null);

        final GitLabApplicationSettingUsers built = builder.build();

        assertThat(built.usersApiLimitGpgKey()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingUsers value = SettingsCatalogFixtures.applicationSettingUsers();

        assertSoftly(softly -> {
            softly.assertThat(value.usersGetByIdLimit()).isEqualTo("users_get_by_id_limit");
            softly.assertThat(value.usersGetByIdLimitAllowlistRaw()).isEqualTo("users_get_by_id_limit_allowlist_raw");
            softly.assertThat(value.usersApiLimitFollowers()).isEqualTo("users_api_limit_followers");
            softly.assertThat(value.usersApiLimitFollowing()).isEqualTo("users_api_limit_following");
            softly.assertThat(value.usersApiLimitStatus()).isEqualTo("users_api_limit_status");
            softly.assertThat(value.usersApiLimitSshKeys()).isEqualTo("users_api_limit_ssh_keys");
            softly.assertThat(value.usersApiLimitSshKey()).isEqualTo("users_api_limit_ssh_key");
            softly.assertThat(value.usersApiLimitGpgKeys()).isEqualTo("users_api_limit_gpg_keys");
            softly.assertThat(value.usersApiLimitGpgKey()).isEqualTo("users_api_limit_gpg_key");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingUsers original = SettingsCatalogFixtures.applicationSettingUsers();

        final GitLabApplicationSettingUsers rebuilt =
                GitLabApplicationSettingUsersBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingUsers.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "usersGetByIdLimit",
                        "usersGetByIdLimitAllowlistRaw",
                        "usersApiLimitFollowers",
                        "usersApiLimitFollowing",
                        "usersApiLimitStatus",
                        "usersApiLimitSshKeys",
                        "usersApiLimitSshKey",
                        "usersApiLimitGpgKeys",
                        "usersApiLimitGpgKey");
    }
}
