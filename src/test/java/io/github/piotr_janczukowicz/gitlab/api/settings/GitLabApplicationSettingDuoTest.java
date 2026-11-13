package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingDuoTest {

    @Test
    void constructor_shouldAcceptNull_whenDuoChatExpirationColumnIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoChatExpirationColumn(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoChatExpirationColumn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoChatExpirationDaysIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoChatExpirationDays(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoChatExpirationDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFeaturesEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoFeaturesEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAgentPlatformEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoAgentPlatformEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoAgentPlatformEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCliEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCliEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCliEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoTokenUsageTrackingEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoTokenUsageTrackingEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoTokenUsageTrackingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowFileAttachmentsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoWorkflowFileAttachmentsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoWorkflowFileAttachmentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoNamespaceAccessRulesIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoNamespaceAccessRules(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoNamespaceAccessRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoRemoteFlowsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoRemoteFlowsAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoRemoteFlowsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoFoundationalFlowsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoFoundationalFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoFoundationalFlowsAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoFoundationalFlowsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoScheduledAutomationsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoScheduledAutomationsAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoScheduledAutomationsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomAgentsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCustomAgentsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCustomAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomAgentsAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCustomAgentsAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCustomAgentsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomFlowsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCustomFlowsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCustomFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCustomFlowsAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCustomFlowsAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCustomFlowsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoExternalAgentsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoExternalAgentsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoExternalAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoExternalAgentsAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoExternalAgentsAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoExternalAgentsAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAutoModeEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoAutoModeEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoAutoModeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoAutoModeAvailabilityIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoAutoModeAvailability(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoAutoModeAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowOauthApplicationIdIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoWorkflowOauthApplicationId(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoWorkflowOauthApplicationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowsDefaultImageRegistryIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoWorkflowsDefaultImageRegistry(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoWorkflowsDefaultImageRegistry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoTemplateProjectIdIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoTemplateProjectId(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCodeReviewDecisionsEnabled(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCodeReviewDepthAllowed(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabApplicationSettingDuoBuilder builder = GitLabApplicationSettingDuoBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDuo())
                .duoCodeReviewDefaultDepth(null);

        final GitLabApplicationSettingDuo built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingDuo value = SettingsCatalogFixtures.applicationSettingDuo();

        assertSoftly(softly -> {
            softly.assertThat(value.duoChatExpirationColumn()).isEqualTo("duo_chat_expiration_column");
            softly.assertThat(value.duoChatExpirationDays()).isEqualTo("duo_chat_expiration_days");
            softly.assertThat(value.duoFeaturesEnabled()).isEqualTo("duo_features_enabled");
            softly.assertThat(value.duoAvailability()).isEqualTo("duo_availability");
            softly.assertThat(value.duoAgentPlatformEnabled()).isEqualTo("duo_agent_platform_enabled");
            softly.assertThat(value.duoCliEnabled()).isEqualTo("duo_cli_enabled");
            softly.assertThat(value.duoTokenUsageTrackingEnabled()).isEqualTo(true);
            softly.assertThat(value.duoWorkflowFileAttachmentsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoNamespaceAccessRules()).isEqualTo("duo_namespace_access_rules");
            softly.assertThat(value.duoRemoteFlowsEnabled()).isEqualTo("duo_remote_flows_enabled");
            softly.assertThat(value.duoRemoteFlowsAvailability()).isEqualTo("duo_remote_flows_availability");
            softly.assertThat(value.duoFoundationalFlowsEnabled()).isEqualTo("duo_foundational_flows_enabled");
            softly.assertThat(value.duoFoundationalFlowsAvailability())
                    .isEqualTo("duo_foundational_flows_availability");
            softly.assertThat(value.duoScheduledAutomationsEnabled()).isEqualTo("duo_scheduled_automations_enabled");
            softly.assertThat(value.duoScheduledAutomationsAvailability())
                    .isEqualTo("duo_scheduled_automations_availability");
            softly.assertThat(value.duoCustomAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCustomAgentsAvailability()).isEqualTo("duo_custom_agents_availability");
            softly.assertThat(value.duoCustomFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCustomFlowsAvailability()).isEqualTo("duo_custom_flows_availability");
            softly.assertThat(value.duoExternalAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoExternalAgentsAvailability()).isEqualTo("duo_external_agents_availability");
            softly.assertThat(value.duoAutoModeEnabled()).isEqualTo("duo_auto_mode_enabled");
            softly.assertThat(value.duoAutoModeAvailability()).isEqualTo("duo_auto_mode_availability");
            softly.assertThat(value.duoWorkflowOauthApplicationId()).isEqualTo("duo_workflow_oauth_application_id");
            softly.assertThat(value.duoWorkflowsDefaultImageRegistry())
                    .isEqualTo("duo_workflows_default_image_registry");
            softly.assertThat(value.duoTemplateProjectId()).isEqualTo("duo_template_project_id");
            softly.assertThat(value.duoCodeReviewDecisionsEnabled()).isEqualTo("duo_code_review_decisions_enabled");
            softly.assertThat(value.duoCodeReviewDepthAllowed()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDefaultDepth()).isEqualTo("standard");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingDuo original = SettingsCatalogFixtures.applicationSettingDuo();

        final GitLabApplicationSettingDuo rebuilt =
                GitLabApplicationSettingDuoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingDuo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "duoChatExpirationColumn",
                        "duoChatExpirationDays",
                        "duoFeaturesEnabled",
                        "duoAvailability",
                        "duoAgentPlatformEnabled",
                        "duoCliEnabled",
                        "duoTokenUsageTrackingEnabled",
                        "duoWorkflowFileAttachmentsEnabled",
                        "duoNamespaceAccessRules",
                        "duoRemoteFlowsEnabled",
                        "duoRemoteFlowsAvailability",
                        "duoFoundationalFlowsEnabled",
                        "duoFoundationalFlowsAvailability",
                        "duoScheduledAutomationsEnabled",
                        "duoScheduledAutomationsAvailability",
                        "duoCustomAgentsEnabled",
                        "duoCustomAgentsAvailability",
                        "duoCustomFlowsEnabled",
                        "duoCustomFlowsAvailability",
                        "duoExternalAgentsEnabled",
                        "duoExternalAgentsAvailability",
                        "duoAutoModeEnabled",
                        "duoAutoModeAvailability",
                        "duoWorkflowOauthApplicationId",
                        "duoWorkflowsDefaultImageRegistry",
                        "duoTemplateProjectId",
                        "duoCodeReviewDecisionsEnabled",
                        "duoCodeReviewDepthAllowed",
                        "duoCodeReviewDefaultDepth");
    }
}
