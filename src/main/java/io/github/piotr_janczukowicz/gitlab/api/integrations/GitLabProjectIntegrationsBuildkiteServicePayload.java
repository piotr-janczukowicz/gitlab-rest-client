package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesBuildkite}.
 *
 * @param projectUrl the project url
 * @param token the token
 * @param enableSslVerification the enable ssl verification
 * @param pushEvents the push events
 * @param mergeRequestsEvents the merge requests events
 * @param tagPushEvents the tag push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesBuildkite/requestBody")
public record GitLabProjectIntegrationsBuildkiteServicePayload(
        @Nullable String projectUrl,
        @Nullable String token,
        @Nullable Boolean enableSslVerification,
        @Nullable Boolean pushEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsBuildkiteServicePayload[" + "projectUrl=" + projectUrl + ", token=<redacted>"
                + ", enableSslVerification=" + enableSslVerification + ", pushEvents=" + pushEvents
                + ", mergeRequestsEvents=" + mergeRequestsEvents + ", tagPushEvents=" + tagPushEvents
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
