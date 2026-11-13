package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4Hooks}.
 *
 * @param url the url
 * @param name the name
 * @param description the description
 * @param token the token
 * @param signingToken the signing token
 * @param pushEvents the push events
 * @param tagPushEvents the tag push events
 * @param mergeRequestsEvents the merge requests events
 * @param repositoryUpdateEvents the repository update events
 * @param enableSslVerification the enable ssl verification
 * @param pushEventsBranchFilter the push events branch filter
 * @param branchFilterStrategy the branch filter strategy
 * @param customWebhookTemplate the custom webhook template
 * @param urlVariables the url variables
 * @param customHeaders the custom headers
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Hooks/requestBody")
public record GitLabSystemHooksCreatePayload(
        @Nullable String url,
        @Nullable String name,
        @Nullable String description,
        @Nullable String token,
        @Nullable String signingToken,
        @Nullable Boolean pushEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean repositoryUpdateEvents,
        @Nullable Boolean enableSslVerification,
        @Nullable String pushEventsBranchFilter,
        @Nullable GitLabSystemHooksCreateBranchFilterStrategy branchFilterStrategy,
        @Nullable String customWebhookTemplate,
        @Nullable List<GitLabSystemHooksCreateUrlVariable> urlVariables,
        @Nullable List<GitLabSystemHooksCreateCustomHeader> customHeaders) {
    public GitLabSystemHooksCreatePayload {
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
        return "GitLabSystemHooksCreatePayload[" + "url=" + url + ", name=" + name + ", description=" + description
                + ", token=<redacted>" + ", signingToken=<redacted>" + ", pushEvents=" + pushEvents + ", tagPushEvents="
                + tagPushEvents + ", mergeRequestsEvents=" + mergeRequestsEvents + ", repositoryUpdateEvents="
                + repositoryUpdateEvents + ", enableSslVerification=" + enableSslVerification
                + ", pushEventsBranchFilter=" + pushEventsBranchFilter + ", branchFilterStrategy="
                + branchFilterStrategy + ", customWebhookTemplate=" + customWebhookTemplate + ", urlVariables="
                + urlVariables + ", customHeaders=" + customHeaders + "]";
    }
}
