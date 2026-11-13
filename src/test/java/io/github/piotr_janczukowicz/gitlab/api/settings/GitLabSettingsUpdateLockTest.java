package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateLockTest {

    @Test
    void constructor_shouldAcceptNull_whenLockRequireShaForMergeIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockRequireShaForMerge(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockRequireShaForMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoFeaturesEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockDuoFeaturesEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockDuoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoCustomAgentsEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockDuoCustomAgentsEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockDuoCustomAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoCustomFlowsEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockDuoCustomFlowsEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockDuoCustomFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoExternalAgentsEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockDuoExternalAgentsEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockDuoExternalAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoRemoteFlowsEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockDuoRemoteFlowsEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockDuoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockDuoScheduledAutomationsEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockDuoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockBuiltInProjectTemplatesEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockBuiltInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockMembershipsToSamlIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockMembershipsToSaml(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockMembershipsToSaml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockResourceAccessTokenNotifyInherited(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockResourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockMembershipsToLdapIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockMembershipsToLdap(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockMembershipsToLdap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockModelPromptCacheEnabledIsNullable() {
        final GitLabSettingsUpdateLockBuilder builder = GitLabSettingsUpdateLockBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateLock())
                .lockModelPromptCacheEnabled(null);

        final GitLabSettingsUpdateLock built = builder.build();

        assertThat(built.lockModelPromptCacheEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateLock value = SettingsCatalogFixtures.settingsUpdateLock();

        assertSoftly(softly -> {
            softly.assertThat(value.lockRequireShaForMerge()).isEqualTo("lock_require_sha_for_merge");
            softly.assertThat(value.lockDuoFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoCustomAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoCustomFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoExternalAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoRemoteFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoScheduledAutomationsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockBuiltInProjectTemplatesEnabled()).isEqualTo(true);
            softly.assertThat(value.lockMembershipsToSaml()).isEqualTo("lock_memberships_to_saml");
            softly.assertThat(value.lockResourceAccessTokenNotifyInherited())
                    .isEqualTo("lock_resource_access_token_notify_inherited");
            softly.assertThat(value.lockMembershipsToLdap()).isEqualTo("lock_memberships_to_ldap");
            softly.assertThat(value.lockModelPromptCacheEnabled()).isEqualTo("lock_model_prompt_cache_enabled");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateLock original = SettingsCatalogFixtures.settingsUpdateLock();

        final GitLabSettingsUpdateLock rebuilt =
                GitLabSettingsUpdateLockBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenLockResourceAccessTokenNotifyInheritedIsACredential() {
        final GitLabSettingsUpdateLock value = SettingsCatalogFixtures.settingsUpdateLock();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateLock.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "lockRequireShaForMerge",
                        "lockDuoFeaturesEnabled",
                        "lockDuoCustomAgentsEnabled",
                        "lockDuoCustomFlowsEnabled",
                        "lockDuoExternalAgentsEnabled",
                        "lockDuoRemoteFlowsEnabled",
                        "lockDuoScheduledAutomationsEnabled",
                        "lockBuiltInProjectTemplatesEnabled",
                        "lockMembershipsToSaml",
                        "lockResourceAccessTokenNotifyInherited",
                        "lockMembershipsToLdap",
                        "lockModelPromptCacheEnabled");
    }
}
