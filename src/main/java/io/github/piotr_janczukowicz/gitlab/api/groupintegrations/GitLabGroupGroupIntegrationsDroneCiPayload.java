package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsDroneCi}.
 *
 * @param enableSslVerification the enable ssl verification
 * @param droneUrl the drone url
 * @param token the token
 * @param pushEvents the push events
 * @param mergeRequestsEvents the merge requests events
 * @param tagPushEvents the tag push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsDroneCi/requestBody")
public record GitLabGroupGroupIntegrationsDroneCiPayload(
        @Nullable Boolean enableSslVerification,
        @Nullable String droneUrl,
        @Nullable String token,
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
        return "GitLabGroupGroupIntegrationsDroneCiPayload[" + "enableSslVerification=" + enableSslVerification
                + ", droneUrl=" + droneUrl + ", token=<redacted>" + ", pushEvents=" + pushEvents
                + ", mergeRequestsEvents=" + mergeRequestsEvents + ", tagPushEvents=" + tagPushEvents
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
