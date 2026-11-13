package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdHooksHookId}.
 *
 * @param url the url
 * @param name the name
 * @param description the description
 * @param pushEvents the push events
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param mergeRequestsEvents the merge requests events
 * @param tagPushEvents the tag push events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param jobEvents the job events
 * @param pipelineEvents the pipeline events
 * @param wikiPageEvents the wiki page events
 * @param deploymentEvents the deployment events
 * @param featureFlagEvents the feature flag events
 * @param releasesEvents the releases events
 * @param milestoneEvents the milestone events
 * @param emojiEvents the emoji events
 * @param resourceAccessTokenEvents the resource access token events
 * @param resourceDeployTokenEvents the resource deploy token events
 * @param enableSslVerification the enable ssl verification
 * @param token the token
 * @param signingToken the signing token
 * @param pushEventsBranchFilter the push events branch filter
 * @param customWebhookTemplate the custom webhook template
 * @param branchFilterStrategy the branch filter strategy
 * @param vulnerabilityEvents the vulnerability events
 * @param duoFlowCallbackEnabled the duo flow callback enabled
 * @param urlVariables the url variables
 * @param customHeaders the custom headers
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdHooksHookId/requestBody")
public record GitLabProjectProjectWebhooksUpdatePayload(
        @Nullable String url,
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean pushEvents,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean jobEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean deploymentEvents,
        @Nullable Boolean featureFlagEvents,
        @Nullable Boolean releasesEvents,
        @Nullable Boolean milestoneEvents,
        @Nullable Boolean emojiEvents,
        @Nullable Boolean resourceAccessTokenEvents,
        @Nullable Boolean resourceDeployTokenEvents,
        @Nullable Boolean enableSslVerification,
        @Nullable String token,
        @Nullable String signingToken,
        @Nullable String pushEventsBranchFilter,
        @Nullable String customWebhookTemplate,
        @Nullable GitLabProjectProjectWebhooksUpdateBranchFilterStrategy branchFilterStrategy,
        @Nullable Boolean vulnerabilityEvents,
        @Nullable Boolean duoFlowCallbackEnabled,
        @Nullable List<GitLabProjectProjectWebhooksUpdateUrlVariable> urlVariables,
        @Nullable List<GitLabProjectProjectWebhooksUpdateCustomHeader> customHeaders) {
    public GitLabProjectProjectWebhooksUpdatePayload {
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
        return "GitLabProjectProjectWebhooksUpdatePayload[" + "url=" + url + ", name=" + name + ", description="
                + description + ", pushEvents=" + pushEvents + ", issuesEvents=" + issuesEvents
                + ", confidentialIssuesEvents=" + confidentialIssuesEvents + ", mergeRequestsEvents="
                + mergeRequestsEvents + ", tagPushEvents=" + tagPushEvents + ", noteEvents=" + noteEvents
                + ", confidentialNoteEvents=" + confidentialNoteEvents + ", jobEvents=" + jobEvents
                + ", pipelineEvents=" + pipelineEvents + ", wikiPageEvents=" + wikiPageEvents + ", deploymentEvents="
                + deploymentEvents + ", featureFlagEvents=" + featureFlagEvents + ", releasesEvents=" + releasesEvents
                + ", milestoneEvents=" + milestoneEvents + ", emojiEvents=" + emojiEvents
                + ", resourceAccessTokenEvents=" + resourceAccessTokenEvents + ", resourceDeployTokenEvents="
                + resourceDeployTokenEvents + ", enableSslVerification=" + enableSslVerification + ", token=<redacted>"
                + ", signingToken=<redacted>" + ", pushEventsBranchFilter=" + pushEventsBranchFilter
                + ", customWebhookTemplate=" + customWebhookTemplate + ", branchFilterStrategy=" + branchFilterStrategy
                + ", vulnerabilityEvents=" + vulnerabilityEvents + ", duoFlowCallbackEnabled=" + duoFlowCallbackEnabled
                + ", urlVariables=" + urlVariables + ", customHeaders=" + customHeaders + "]";
    }
}
