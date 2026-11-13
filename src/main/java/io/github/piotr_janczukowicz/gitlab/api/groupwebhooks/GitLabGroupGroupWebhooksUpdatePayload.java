package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdHooksHookId}.
 *
 * @param url the url
 * @param name the name
 * @param description the description
 * @param pushEvents the push events
 * @param pushEventsBranchFilter the push events branch filter
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param mergeRequestsEvents the merge requests events
 * @param tagPushEvents the tag push events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param jobEvents the job events
 * @param pipelineEvents the pipeline events
 * @param projectEvents the project events
 * @param wikiPageEvents the wiki page events
 * @param deploymentEvents the deployment events
 * @param featureFlagEvents the feature flag events
 * @param releasesEvents the releases events
 * @param milestoneEvents the milestone events
 * @param subgroupEvents the subgroup events
 * @param emojiEvents the emoji events
 * @param resourceAccessTokenEvents the resource access token events
 * @param memberEvents the member events
 * @param vulnerabilityEvents the vulnerability events
 * @param enableSslVerification the enable ssl verification
 * @param token the token
 * @param signingToken the signing token
 * @param customWebhookTemplate the custom webhook template
 * @param branchFilterStrategy the branch filter strategy
 * @param duoFlowCallbackEnabled the duo flow callback enabled
 * @param urlVariables the url variables
 * @param customHeaders the custom headers
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdHooksHookId/requestBody")
public record GitLabGroupGroupWebhooksUpdatePayload(
        @Nullable String url,
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean pushEvents,
        @Nullable String pushEventsBranchFilter,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean jobEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean projectEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean deploymentEvents,
        @Nullable Boolean featureFlagEvents,
        @Nullable Boolean releasesEvents,
        @Nullable Boolean milestoneEvents,
        @Nullable Boolean subgroupEvents,
        @Nullable Boolean emojiEvents,
        @Nullable Boolean resourceAccessTokenEvents,
        @Nullable Boolean memberEvents,
        @Nullable Boolean vulnerabilityEvents,
        @Nullable Boolean enableSslVerification,
        @Nullable String token,
        @Nullable String signingToken,
        @Nullable String customWebhookTemplate,
        @Nullable GitLabGroupGroupWebhooksUpdateBranchFilterStrategy branchFilterStrategy,
        @Nullable Boolean duoFlowCallbackEnabled,
        @Nullable List<GitLabGroupGroupWebhooksUpdateUrlVariable> urlVariables,
        @Nullable List<GitLabGroupGroupWebhooksUpdateCustomHeader> customHeaders) {
    public GitLabGroupGroupWebhooksUpdatePayload {
        if (urlVariables != null) {
            urlVariables = List.copyOf(urlVariables);
        }
        if (customHeaders != null) {
            customHeaders = List.copyOf(customHeaders);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token}, {@code signingToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupGroupWebhooksUpdatePayload[" + "url=" + url + ", name=" + name + ", description="
                + description + ", pushEvents=" + pushEvents + ", pushEventsBranchFilter=" + pushEventsBranchFilter
                + ", issuesEvents=" + issuesEvents + ", confidentialIssuesEvents=" + confidentialIssuesEvents
                + ", mergeRequestsEvents=" + mergeRequestsEvents + ", tagPushEvents=" + tagPushEvents + ", noteEvents="
                + noteEvents + ", confidentialNoteEvents=" + confidentialNoteEvents + ", jobEvents=" + jobEvents
                + ", pipelineEvents=" + pipelineEvents + ", projectEvents=" + projectEvents + ", wikiPageEvents="
                + wikiPageEvents + ", deploymentEvents=" + deploymentEvents + ", featureFlagEvents=" + featureFlagEvents
                + ", releasesEvents=" + releasesEvents + ", milestoneEvents=" + milestoneEvents + ", subgroupEvents="
                + subgroupEvents + ", emojiEvents=" + emojiEvents + ", resourceAccessTokenEvents="
                + resourceAccessTokenEvents + ", memberEvents=" + memberEvents + ", vulnerabilityEvents="
                + vulnerabilityEvents + ", enableSslVerification=" + enableSslVerification + ", token=<redacted>"
                + ", signingToken=<redacted>" + ", customWebhookTemplate=" + customWebhookTemplate
                + ", branchFilterStrategy=" + branchFilterStrategy + ", duoFlowCallbackEnabled="
                + duoFlowCallbackEnabled + ", urlVariables=" + urlVariables + ", customHeaders=" + customHeaders + "]";
    }
}
