package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesMatrix}.
 *
 * @param hostname the hostname
 * @param token the token
 * @param room the room
 * @param notifyOnlyBrokenPipelines the notify only broken pipelines
 * @param notifyOnlyWhenPipelineStatusChanges the notify only when pipeline status changes
 * @param branchesToBeNotified the branches to be notified
 * @param pushEvents the push events
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param mergeRequestsEvents the merge requests events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param tagPushEvents the tag push events
 * @param pipelineEvents the pipeline events
 * @param wikiPageEvents the wiki page events
 * @param incidentEvents the incident events
 * @param workItemEvents the work item events
 * @param confidentialWorkItemEvents the confidential work item events
 * @param vulnerabilityEvents the vulnerability events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesMatrix/requestBody")
public record GitLabProjectIntegrationsMatrixServicePayload(
        @Nullable String hostname,
        @Nullable String token,
        @Nullable String room,
        @Nullable Boolean notifyOnlyBrokenPipelines,
        @Nullable Boolean notifyOnlyWhenPipelineStatusChanges,
        @Nullable String branchesToBeNotified,
        @Nullable Boolean pushEvents,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean incidentEvents,
        @Nullable Boolean workItemEvents,
        @Nullable Boolean confidentialWorkItemEvents,
        @Nullable Boolean vulnerabilityEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsMatrixServicePayload[" + "hostname=" + hostname + ", token=<redacted>"
                + ", room=" + room + ", notifyOnlyBrokenPipelines=" + notifyOnlyBrokenPipelines
                + ", notifyOnlyWhenPipelineStatusChanges=" + notifyOnlyWhenPipelineStatusChanges
                + ", branchesToBeNotified=" + branchesToBeNotified + ", pushEvents=" + pushEvents + ", issuesEvents="
                + issuesEvents + ", confidentialIssuesEvents=" + confidentialIssuesEvents + ", mergeRequestsEvents="
                + mergeRequestsEvents + ", noteEvents=" + noteEvents + ", confidentialNoteEvents="
                + confidentialNoteEvents + ", tagPushEvents=" + tagPushEvents + ", pipelineEvents=" + pipelineEvents
                + ", wikiPageEvents=" + wikiPageEvents + ", incidentEvents=" + incidentEvents + ", workItemEvents="
                + workItemEvents + ", confidentialWorkItemEvents=" + confidentialWorkItemEvents
                + ", vulnerabilityEvents=" + vulnerabilityEvents + ", useInheritedSettings=" + useInheritedSettings
                + "]";
    }
}
