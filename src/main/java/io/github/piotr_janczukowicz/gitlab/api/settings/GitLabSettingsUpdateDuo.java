package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param duoFeaturesEnabled the duo features enabled
 * @param duoCodeReviewDecisionsEnabled the duo code review decisions enabled
 * @param duoCodeReviewDepthAllowed the duo code review depth allowed
 * @param duoCodeReviewDefaultDepth the duo code review default depth
 * @param duoCustomAgentsEnabled the duo custom agents enabled
 * @param duoCustomFlowsEnabled the duo custom flows enabled
 * @param duoExternalAgentsEnabled the duo external agents enabled
 * @param duoRemoteFlowsEnabled the duo remote flows enabled
 * @param duoScheduledAutomationsEnabled the duo scheduled automations enabled
 * @param duoWorkflowsDefaultImageRegistry the duo workflows default image registry
 * @param duoNamespaceAccessRules the duo namespace access rules
 * @param duoTemplateProjectId the duo template project id
 * @param duoChatExpirationColumn the duo chat expiration column
 * @param duoChatExpirationDays the duo chat expiration days
 * @param duoAvailability the duo availability
 * @param duoAgentPlatformEnabled the duo agent platform enabled
 * @param duoCliEnabled the duo cli enabled
 * @param duoTokenUsageTrackingEnabled the duo token usage tracking enabled
 * @param duoWorkflowFileAttachmentsEnabled the duo workflow file attachments enabled
 * @param duoRemoteFlowsAvailability the duo remote flows availability
 * @param duoFoundationalFlowsEnabled the duo foundational flows enabled
 * @param duoFoundationalFlowsAvailability the duo foundational flows availability
 * @param duoScheduledAutomationsAvailability the duo scheduled automations availability
 * @param duoCustomAgentsAvailability the duo custom agents availability
 * @param duoCustomFlowsAvailability the duo custom flows availability
 * @param duoExternalAgentsAvailability the duo external agents availability
 * @param duoAutoModeEnabled the duo auto mode enabled
 * @param duoAutoModeAvailability the duo auto mode availability
 * @param duoWorkflowOauthApplicationId the duo workflow oauth application id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateDuo(
        @Nullable Boolean duoFeaturesEnabled,
        @Nullable Boolean duoCodeReviewDecisionsEnabled,
        @Nullable Boolean duoCodeReviewDepthAllowed,
        @Nullable GitLabSettingsUpdateDuoCodeReviewDefaultDepth duoCodeReviewDefaultDepth,
        @Nullable Boolean duoCustomAgentsEnabled,
        @Nullable Boolean duoCustomFlowsEnabled,
        @Nullable Boolean duoExternalAgentsEnabled,
        @Nullable Boolean duoRemoteFlowsEnabled,
        @Nullable Boolean duoScheduledAutomationsEnabled,
        @Nullable String duoWorkflowsDefaultImageRegistry,
        @Nullable List<GitLabSettingsUpdateDuoNamespaceAccessRule> duoNamespaceAccessRules,
        @Nullable Long duoTemplateProjectId,
        @Nullable String duoChatExpirationColumn,
        @Nullable String duoChatExpirationDays,
        @Nullable String duoAvailability,
        @Nullable String duoAgentPlatformEnabled,
        @Nullable String duoCliEnabled,
        @Nullable String duoTokenUsageTrackingEnabled,
        @Nullable String duoWorkflowFileAttachmentsEnabled,
        @Nullable String duoRemoteFlowsAvailability,
        @Nullable String duoFoundationalFlowsEnabled,
        @Nullable String duoFoundationalFlowsAvailability,
        @Nullable String duoScheduledAutomationsAvailability,
        @Nullable String duoCustomAgentsAvailability,
        @Nullable String duoCustomFlowsAvailability,
        @Nullable String duoExternalAgentsAvailability,
        @Nullable String duoAutoModeEnabled,
        @Nullable String duoAutoModeAvailability,
        @Nullable String duoWorkflowOauthApplicationId) {
    public GitLabSettingsUpdateDuo {
        if (duoNamespaceAccessRules != null) {
            duoNamespaceAccessRules = List.copyOf(duoNamespaceAccessRules);
        }
    }
}
