package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsPumble}.
 *
 * @param webhook the webhook
 * @param notifyOnlyBrokenPipelines the notify only broken pipelines
 * @param notifyOnlyWhenPipelineStatusChanges the notify only when pipeline status changes
 * @param branchesToBeNotified the branches to be notified
 * @param pushEvents the push events
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param workItemEvents the work item events
 * @param confidentialWorkItemEvents the confidential work item events
 * @param mergeRequestsEvents the merge requests events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param tagPushEvents the tag push events
 * @param pipelineEvents the pipeline events
 * @param wikiPageEvents the wiki page events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsPumble/requestBody")
public record GitLabGroupGroupIntegrationsPumblePayload(
        @Nullable String webhook,
        @Nullable Boolean notifyOnlyBrokenPipelines,
        @Nullable Boolean notifyOnlyWhenPipelineStatusChanges,
        @Nullable String branchesToBeNotified,
        @Nullable Boolean pushEvents,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean workItemEvents,
        @Nullable Boolean confidentialWorkItemEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean useInheritedSettings) {}
