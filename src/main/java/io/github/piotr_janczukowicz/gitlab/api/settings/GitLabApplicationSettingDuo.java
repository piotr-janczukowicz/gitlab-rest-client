package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param duoChatExpirationColumn the duo chat expiration column
 * @param duoChatExpirationDays the duo chat expiration days
 * @param duoFeaturesEnabled the duo features enabled
 * @param duoAvailability the duo availability
 * @param duoAgentPlatformEnabled the duo agent platform enabled
 * @param duoCliEnabled the duo cli enabled
 * @param duoTokenUsageTrackingEnabled the duo token usage tracking enabled
 * @param duoWorkflowFileAttachmentsEnabled the duo workflow file attachments enabled
 * @param duoNamespaceAccessRules the duo namespace access rules
 * @param duoRemoteFlowsEnabled the duo remote flows enabled
 * @param duoRemoteFlowsAvailability the duo remote flows availability
 * @param duoFoundationalFlowsEnabled the duo foundational flows enabled
 * @param duoFoundationalFlowsAvailability the duo foundational flows availability
 * @param duoScheduledAutomationsEnabled the duo scheduled automations enabled
 * @param duoScheduledAutomationsAvailability the duo scheduled automations availability
 * @param duoCustomAgentsEnabled the duo custom agents enabled
 * @param duoCustomAgentsAvailability the duo custom agents availability
 * @param duoCustomFlowsEnabled the duo custom flows enabled
 * @param duoCustomFlowsAvailability the duo custom flows availability
 * @param duoExternalAgentsEnabled the duo external agents enabled
 * @param duoExternalAgentsAvailability the duo external agents availability
 * @param duoAutoModeEnabled the duo auto mode enabled
 * @param duoAutoModeAvailability the duo auto mode availability
 * @param duoWorkflowOauthApplicationId the duo workflow oauth application id
 * @param duoWorkflowsDefaultImageRegistry the duo workflows default image registry
 * @param duoTemplateProjectId the duo template project id
 * @param duoCodeReviewDecisionsEnabled the duo code review decisions enabled
 * @param duoCodeReviewDepthAllowed the duo code review depth allowed
 * @param duoCodeReviewDefaultDepth the duo code review default depth
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingDuo(
        @Nullable String duoChatExpirationColumn,
        @Nullable String duoChatExpirationDays,
        @Nullable String duoFeaturesEnabled,
        @Nullable String duoAvailability,
        @Nullable String duoAgentPlatformEnabled,
        @Nullable String duoCliEnabled,
        @Nullable Boolean duoTokenUsageTrackingEnabled,
        @Nullable Boolean duoWorkflowFileAttachmentsEnabled,
        @Nullable String duoNamespaceAccessRules,
        @Nullable String duoRemoteFlowsEnabled,
        @Nullable String duoRemoteFlowsAvailability,
        @Nullable String duoFoundationalFlowsEnabled,
        @Nullable String duoFoundationalFlowsAvailability,
        @Nullable String duoScheduledAutomationsEnabled,
        @Nullable String duoScheduledAutomationsAvailability,
        @Nullable Boolean duoCustomAgentsEnabled,
        @Nullable String duoCustomAgentsAvailability,
        @Nullable Boolean duoCustomFlowsEnabled,
        @Nullable String duoCustomFlowsAvailability,
        @Nullable Boolean duoExternalAgentsEnabled,
        @Nullable String duoExternalAgentsAvailability,
        @Nullable String duoAutoModeEnabled,
        @Nullable String duoAutoModeAvailability,
        @Nullable String duoWorkflowOauthApplicationId,
        @Nullable String duoWorkflowsDefaultImageRegistry,
        @Nullable String duoTemplateProjectId,
        @Nullable String duoCodeReviewDecisionsEnabled,
        @Nullable Boolean duoCodeReviewDepthAllowed,
        @Nullable String duoCodeReviewDefaultDepth) {}
