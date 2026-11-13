package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDuoTest {

    @Test
    void constructor_shouldAcceptNull_whenDuoFeaturesEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoFeaturesEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCodeReviewDecisionsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCodeReviewDepthAllowed(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCodeReviewDefaultDepth(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomAgentsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCustomAgentsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCustomAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomFlowsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCustomFlowsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCustomFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoExternalAgentsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoExternalAgentsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoExternalAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoRemoteFlowsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoScheduledAutomationsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowsDefaultImageRegistryIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoWorkflowsDefaultImageRegistry(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoWorkflowsDefaultImageRegistry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoNamespaceAccessRulesIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoNamespaceAccessRules(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoNamespaceAccessRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoTemplateProjectIdIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoTemplateProjectId(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoChatExpirationColumnIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoChatExpirationColumn(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoChatExpirationColumn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoChatExpirationDaysIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoChatExpirationDays(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoChatExpirationDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAgentPlatformEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoAgentPlatformEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoAgentPlatformEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCliEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCliEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCliEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoTokenUsageTrackingEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoTokenUsageTrackingEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoTokenUsageTrackingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowFileAttachmentsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoWorkflowFileAttachmentsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoWorkflowFileAttachmentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoRemoteFlowsAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoRemoteFlowsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoFoundationalFlowsEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoFoundationalFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoFoundationalFlowsAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoFoundationalFlowsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoScheduledAutomationsAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoScheduledAutomationsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomAgentsAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCustomAgentsAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCustomAgentsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomFlowsAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoCustomFlowsAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoCustomFlowsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoExternalAgentsAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoExternalAgentsAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoExternalAgentsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAutoModeEnabledIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoAutoModeEnabled(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoAutoModeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAutoModeAvailabilityIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoAutoModeAvailability(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoAutoModeAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowOauthApplicationIdIsNullable() {
        final GitLabSettingsUpdateDuoBuilder builder = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoWorkflowOauthApplicationId(null);

        final GitLabSettingsUpdateDuo built = builder.build();

        assertThat(built.duoWorkflowOauthApplicationId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDuo value = SettingsCatalogFixtures.settingsUpdateDuo();

        assertSoftly(softly -> {
            softly.assertThat(value.duoFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDecisionsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDepthAllowed()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDefaultDepth())
                    .isEqualTo(GitLabSettingsUpdateDuoCodeReviewDefaultDepth.STANDARD);
            softly.assertThat(value.duoCustomAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCustomFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoExternalAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoRemoteFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoScheduledAutomationsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoWorkflowsDefaultImageRegistry())
                    .isEqualTo("duo_workflows_default_image_registry");
            softly.assertThat(value.duoNamespaceAccessRules())
                    .isEqualTo(List.of(SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule()));
            softly.assertThat(value.duoTemplateProjectId()).isEqualTo(1L);
            softly.assertThat(value.duoChatExpirationColumn()).isEqualTo("duo_chat_expiration_column");
            softly.assertThat(value.duoChatExpirationDays()).isEqualTo("duo_chat_expiration_days");
            softly.assertThat(value.duoAvailability()).isEqualTo("duo_availability");
            softly.assertThat(value.duoAgentPlatformEnabled()).isEqualTo("duo_agent_platform_enabled");
            softly.assertThat(value.duoCliEnabled()).isEqualTo("duo_cli_enabled");
            softly.assertThat(value.duoTokenUsageTrackingEnabled()).isEqualTo("duo_token_usage_tracking_enabled");
            softly.assertThat(value.duoWorkflowFileAttachmentsEnabled())
                    .isEqualTo("duo_workflow_file_attachments_enabled");
            softly.assertThat(value.duoRemoteFlowsAvailability()).isEqualTo("duo_remote_flows_availability");
            softly.assertThat(value.duoFoundationalFlowsEnabled()).isEqualTo("duo_foundational_flows_enabled");
            softly.assertThat(value.duoFoundationalFlowsAvailability())
                    .isEqualTo("duo_foundational_flows_availability");
            softly.assertThat(value.duoScheduledAutomationsAvailability())
                    .isEqualTo("duo_scheduled_automations_availability");
            softly.assertThat(value.duoCustomAgentsAvailability()).isEqualTo("duo_custom_agents_availability");
            softly.assertThat(value.duoCustomFlowsAvailability()).isEqualTo("duo_custom_flows_availability");
            softly.assertThat(value.duoExternalAgentsAvailability()).isEqualTo("duo_external_agents_availability");
            softly.assertThat(value.duoAutoModeEnabled()).isEqualTo("duo_auto_mode_enabled");
            softly.assertThat(value.duoAutoModeAvailability()).isEqualTo("duo_auto_mode_availability");
            softly.assertThat(value.duoWorkflowOauthApplicationId()).isEqualTo("duo_workflow_oauth_application_id");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDuo original = SettingsCatalogFixtures.settingsUpdateDuo();

        final GitLabSettingsUpdateDuo rebuilt =
                GitLabSettingsUpdateDuoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenDuoNamespaceAccessRulesSourceChangesLater() {
        final List<GitLabSettingsUpdateDuoNamespaceAccessRule> source =
                new ArrayList<>(List.of(SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule()));
        final GitLabSettingsUpdateDuo built = GitLabSettingsUpdateDuoBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDuo())
                .duoNamespaceAccessRules(source)
                .build();
        source.clear();

        assertThat(built.duoNamespaceAccessRules()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDuoNamespaceAccessRulesIsRead() {
        final GitLabSettingsUpdateDuo built = SettingsCatalogFixtures.settingsUpdateDuo();
        final List<GitLabSettingsUpdateDuoNamespaceAccessRule> values = built.duoNamespaceAccessRules();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateDuo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "duoFeaturesEnabled",
                        "duoCodeReviewDecisionsEnabled",
                        "duoCodeReviewDepthAllowed",
                        "duoCodeReviewDefaultDepth",
                        "duoCustomAgentsEnabled",
                        "duoCustomFlowsEnabled",
                        "duoExternalAgentsEnabled",
                        "duoRemoteFlowsEnabled",
                        "duoScheduledAutomationsEnabled",
                        "duoWorkflowsDefaultImageRegistry",
                        "duoNamespaceAccessRules",
                        "duoTemplateProjectId",
                        "duoChatExpirationColumn",
                        "duoChatExpirationDays",
                        "duoAvailability",
                        "duoAgentPlatformEnabled",
                        "duoCliEnabled",
                        "duoTokenUsageTrackingEnabled",
                        "duoWorkflowFileAttachmentsEnabled",
                        "duoRemoteFlowsAvailability",
                        "duoFoundationalFlowsEnabled",
                        "duoFoundationalFlowsAvailability",
                        "duoScheduledAutomationsAvailability",
                        "duoCustomAgentsAvailability",
                        "duoCustomFlowsAvailability",
                        "duoExternalAgentsAvailability",
                        "duoAutoModeEnabled",
                        "duoAutoModeAvailability",
                        "duoWorkflowOauthApplicationId");
    }
}
