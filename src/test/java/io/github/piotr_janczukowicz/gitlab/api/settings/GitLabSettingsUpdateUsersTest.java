package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateUsersTest {

    @Test
    void constructor_shouldAcceptNull_whenUsersGetByIdLimitIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersGetByIdLimit(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersGetByIdLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitFollowersIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitFollowers(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitFollowers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitFollowingIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitFollowing(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitFollowing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitGpgKeyIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitGpgKey(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitGpgKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitGpgKeysIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitGpgKeys(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitGpgKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitStatusIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitStatus(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersGetByIdLimitAllowlistRawIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersGetByIdLimitAllowlistRaw(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersGetByIdLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitSshKeysIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitSshKeys(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitSshKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersApiLimitSshKeyIsNullable() {
        final GitLabSettingsUpdateUsersBuilder builder = GitLabSettingsUpdateUsersBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUsers())
                .usersApiLimitSshKey(null);

        final GitLabSettingsUpdateUsers built = builder.build();

        assertThat(built.usersApiLimitSshKey()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateUsers value = SettingsCatalogFixtures.settingsUpdateUsers();

        assertSoftly(softly -> {
            softly.assertThat(value.usersGetByIdLimit()).isEqualTo(1);
            softly.assertThat(value.usersApiLimitFollowers()).isEqualTo("users_api_limit_followers");
            softly.assertThat(value.usersApiLimitFollowing()).isEqualTo("users_api_limit_following");
            softly.assertThat(value.usersApiLimitGpgKey()).isEqualTo("users_api_limit_gpg_key");
            softly.assertThat(value.usersApiLimitGpgKeys()).isEqualTo("users_api_limit_gpg_keys");
            softly.assertThat(value.usersApiLimitStatus()).isEqualTo("users_api_limit_status");
            softly.assertThat(value.usersGetByIdLimitAllowlistRaw()).isEqualTo("users_get_by_id_limit_allowlist_raw");
            softly.assertThat(value.usersApiLimitSshKeys()).isEqualTo("users_api_limit_ssh_keys");
            softly.assertThat(value.usersApiLimitSshKey()).isEqualTo("users_api_limit_ssh_key");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateUsers original = SettingsCatalogFixtures.settingsUpdateUsers();

        final GitLabSettingsUpdateUsers rebuilt =
                GitLabSettingsUpdateUsersBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateUsers.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "usersGetByIdLimit",
                        "usersApiLimitFollowers",
                        "usersApiLimitFollowing",
                        "usersApiLimitGpgKey",
                        "usersApiLimitGpgKeys",
                        "usersApiLimitStatus",
                        "usersGetByIdLimitAllowlistRaw",
                        "usersApiLimitSshKeys",
                        "usersApiLimitSshKey");
    }
}
