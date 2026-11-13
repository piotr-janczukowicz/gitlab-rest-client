package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingLockTest {

    @Test
    void constructor_shouldAcceptNull_whenLockRequireShaForMergeIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockRequireShaForMerge(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockRequireShaForMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockResourceAccessTokenNotifyInherited(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockResourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockMembershipsToLdapIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockMembershipsToLdap(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockMembershipsToLdap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockMembershipsToSamlIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockMembershipsToSaml(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockMembershipsToSaml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockModelPromptCacheEnabledIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockModelPromptCacheEnabled(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockModelPromptCacheEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoFeaturesEnabledIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockDuoFeaturesEnabled(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockDuoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoCustomAgentsEnabledIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockDuoCustomAgentsEnabled(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockDuoCustomAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoCustomFlowsEnabledIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockDuoCustomFlowsEnabled(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockDuoCustomFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoExternalAgentsEnabledIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockDuoExternalAgentsEnabled(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockDuoExternalAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabApplicationSettingLockBuilder builder = GitLabApplicationSettingLockBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingLock())
                .lockBuiltInProjectTemplatesEnabled(null);

        final GitLabApplicationSettingLock built = builder.build();

        assertThat(built.lockBuiltInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingLock value = SettingsCatalogFixtures.applicationSettingLock();

        assertSoftly(softly -> {
            softly.assertThat(value.lockRequireShaForMerge()).isEqualTo("lock_require_sha_for_merge");
            softly.assertThat(value.lockResourceAccessTokenNotifyInherited())
                    .isEqualTo("lock_resource_access_token_notify_inherited");
            softly.assertThat(value.lockMembershipsToLdap()).isEqualTo("lock_memberships_to_ldap");
            softly.assertThat(value.lockMembershipsToSaml()).isEqualTo("lock_memberships_to_saml");
            softly.assertThat(value.lockModelPromptCacheEnabled()).isEqualTo("lock_model_prompt_cache_enabled");
            softly.assertThat(value.lockDuoFeaturesEnabled()).isEqualTo("lock_duo_features_enabled");
            softly.assertThat(value.lockDuoCustomAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoCustomFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoExternalAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockBuiltInProjectTemplatesEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingLock original = SettingsCatalogFixtures.applicationSettingLock();

        final GitLabApplicationSettingLock rebuilt =
                GitLabApplicationSettingLockBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenLockResourceAccessTokenNotifyInheritedIsACredential() {
        final GitLabApplicationSettingLock value = SettingsCatalogFixtures.applicationSettingLock();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingLock.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "lockRequireShaForMerge",
                        "lockResourceAccessTokenNotifyInherited",
                        "lockMembershipsToLdap",
                        "lockMembershipsToSaml",
                        "lockModelPromptCacheEnabled",
                        "lockDuoFeaturesEnabled",
                        "lockDuoCustomAgentsEnabled",
                        "lockDuoCustomFlowsEnabled",
                        "lockDuoExternalAgentsEnabled",
                        "lockBuiltInProjectTemplatesEnabled");
    }
}
