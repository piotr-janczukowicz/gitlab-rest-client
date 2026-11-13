package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingUserTest {

    @Test
    void constructor_shouldAcceptNull_whenUserDefaultExternalIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userDefaultExternal(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userDefaultExternal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserShowAddSshKeyMessageIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userShowAddSshKeyMessage(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userShowAddSshKeyMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserDefaultInternalRegexIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userDefaultInternalRegex(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userDefaultInternalRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserOauthApplicationsIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userOauthApplications(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userOauthApplications()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserDeactivationEmailsEnabledIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userDeactivationEmailsEnabled(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userDeactivationEmailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserDefaultsToPrivateProfileIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userDefaultsToPrivateProfile(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userDefaultsToPrivateProfile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserContributedProjectsApiLimitIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userContributedProjectsApiLimit(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userContributedProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserProjectsApiLimitIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userProjectsApiLimit(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserStarredProjectsApiLimitIsNullable() {
        final GitLabApplicationSettingUserBuilder builder = GitLabApplicationSettingUserBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingUser())
                .userStarredProjectsApiLimit(null);

        final GitLabApplicationSettingUser built = builder.build();

        assertThat(built.userStarredProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingUser value = SettingsCatalogFixtures.applicationSettingUser();

        assertSoftly(softly -> {
            softly.assertThat(value.userDefaultExternal()).isEqualTo("user_default_external");
            softly.assertThat(value.userShowAddSshKeyMessage()).isEqualTo("user_show_add_ssh_key_message");
            softly.assertThat(value.userDefaultInternalRegex()).isEqualTo("user_default_internal_regex");
            softly.assertThat(value.userOauthApplications()).isEqualTo("user_oauth_applications");
            softly.assertThat(value.userDeactivationEmailsEnabled()).isEqualTo("user_deactivation_emails_enabled");
            softly.assertThat(value.userDefaultsToPrivateProfile()).isEqualTo("user_defaults_to_private_profile");
            softly.assertThat(value.userContributedProjectsApiLimit()).isEqualTo("user_contributed_projects_api_limit");
            softly.assertThat(value.userProjectsApiLimit()).isEqualTo("user_projects_api_limit");
            softly.assertThat(value.userStarredProjectsApiLimit()).isEqualTo("user_starred_projects_api_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingUser original = SettingsCatalogFixtures.applicationSettingUser();

        final GitLabApplicationSettingUser rebuilt =
                GitLabApplicationSettingUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingUser.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "userDefaultExternal",
                        "userShowAddSshKeyMessage",
                        "userDefaultInternalRegex",
                        "userOauthApplications",
                        "userDeactivationEmailsEnabled",
                        "userDefaultsToPrivateProfile",
                        "userContributedProjectsApiLimit",
                        "userProjectsApiLimit",
                        "userStarredProjectsApiLimit");
    }
}
