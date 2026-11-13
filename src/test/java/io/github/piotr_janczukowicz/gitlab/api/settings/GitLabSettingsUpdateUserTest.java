package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateUserTest {

    @Test
    void constructor_shouldAcceptNull_whenUserDeactivationEmailsEnabledIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userDeactivationEmailsEnabled(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userDeactivationEmailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserDefaultExternalIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userDefaultExternal(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userDefaultExternal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserDefaultInternalRegexIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userDefaultInternalRegex(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userDefaultInternalRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserDefaultsToPrivateProfileIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userDefaultsToPrivateProfile(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userDefaultsToPrivateProfile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserOauthApplicationsIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userOauthApplications(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userOauthApplications()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserShowAddSshKeyMessageIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userShowAddSshKeyMessage(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userShowAddSshKeyMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserContributedProjectsApiLimitIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userContributedProjectsApiLimit(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userContributedProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserProjectsApiLimitIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userProjectsApiLimit(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserStarredProjectsApiLimitIsNullable() {
        final GitLabSettingsUpdateUserBuilder builder = GitLabSettingsUpdateUserBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateUser())
                .userStarredProjectsApiLimit(null);

        final GitLabSettingsUpdateUser built = builder.build();

        assertThat(built.userStarredProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateUser value = SettingsCatalogFixtures.settingsUpdateUser();

        assertSoftly(softly -> {
            softly.assertThat(value.userDeactivationEmailsEnabled()).isEqualTo(true);
            softly.assertThat(value.userDefaultExternal()).isEqualTo("user_default_external");
            softly.assertThat(value.userDefaultInternalRegex()).isEqualTo("user_default_internal_regex");
            softly.assertThat(value.userDefaultsToPrivateProfile()).isEqualTo("user_defaults_to_private_profile");
            softly.assertThat(value.userOauthApplications()).isEqualTo("user_oauth_applications");
            softly.assertThat(value.userShowAddSshKeyMessage()).isEqualTo("user_show_add_ssh_key_message");
            softly.assertThat(value.userContributedProjectsApiLimit()).isEqualTo("user_contributed_projects_api_limit");
            softly.assertThat(value.userProjectsApiLimit()).isEqualTo("user_projects_api_limit");
            softly.assertThat(value.userStarredProjectsApiLimit()).isEqualTo("user_starred_projects_api_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateUser original = SettingsCatalogFixtures.settingsUpdateUser();

        final GitLabSettingsUpdateUser rebuilt =
                GitLabSettingsUpdateUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateUser.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "userDeactivationEmailsEnabled",
                        "userDefaultExternal",
                        "userDefaultInternalRegex",
                        "userDefaultsToPrivateProfile",
                        "userOauthApplications",
                        "userShowAddSshKeyMessage",
                        "userContributedProjectsApiLimit",
                        "userProjectsApiLimit",
                        "userStarredProjectsApiLimit");
    }
}
