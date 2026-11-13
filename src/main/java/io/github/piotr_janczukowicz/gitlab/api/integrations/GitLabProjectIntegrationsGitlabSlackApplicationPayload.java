package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsGitlabSlackApplication}.
 *
 * @param channel the channel
 * @param notifyOnlyBrokenPipelines the notify only broken pipelines
 * @param notifyOnlyWhenPipelineStatusChanges the notify only when pipeline status changes
 * @param branchesToBeNotified the branches to be notified
 * @param labelsToBeNotified the labels to be notified
 * @param labelsToBeNotifiedBehavior the labels to be notified behavior
 * @param pushChannel the push channel
 * @param issueChannel the issue channel
 * @param incidentChannel the incident channel
 * @param alertChannel the alert channel
 * @param confidentialIssueChannel the confidential issue channel
 * @param mergeRequestChannel the merge request channel
 * @param noteChannel the note channel
 * @param confidentialNoteChannel the confidential note channel
 * @param tagPushChannel the tag push channel
 * @param deploymentChannel the deployment channel
 * @param pipelineChannel the pipeline channel
 * @param wikiPageChannel the wiki page channel
 * @param vulnerabilityChannel the vulnerability channel
 * @param pushEvents the push events
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param mergeRequestsEvents the merge requests events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param tagPushEvents the tag push events
 * @param pipelineEvents the pipeline events
 * @param wikiPageEvents the wiki page events
 * @param deploymentEvents the deployment events
 * @param incidentEvents the incident events
 * @param workItemEvents the work item events
 * @param confidentialWorkItemEvents the confidential work item events
 * @param vulnerabilityEvents the vulnerability events
 * @param alertEvents the alert events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsGitlabSlackApplication/requestBody")
public record GitLabProjectIntegrationsGitlabSlackApplicationPayload(
        @Nullable String channel,
        @Nullable Boolean notifyOnlyBrokenPipelines,
        @Nullable Boolean notifyOnlyWhenPipelineStatusChanges,
        @Nullable String branchesToBeNotified,
        @Nullable String labelsToBeNotified,
        @Nullable String labelsToBeNotifiedBehavior,
        @Nullable String pushChannel,
        @Nullable String issueChannel,
        @Nullable String incidentChannel,
        @Nullable String alertChannel,
        @Nullable String confidentialIssueChannel,
        @Nullable String mergeRequestChannel,
        @Nullable String noteChannel,
        @Nullable String confidentialNoteChannel,
        @Nullable String tagPushChannel,
        @Nullable String deploymentChannel,
        @Nullable String pipelineChannel,
        @Nullable String wikiPageChannel,
        @Nullable String vulnerabilityChannel,
        @Nullable Boolean pushEvents,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean deploymentEvents,
        @Nullable Boolean incidentEvents,
        @Nullable Boolean workItemEvents,
        @Nullable Boolean confidentialWorkItemEvents,
        @Nullable Boolean vulnerabilityEvents,
        @Nullable Boolean alertEvents,
        @Nullable Boolean useInheritedSettings) {}
