package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsJenkins}.
 *
 * @param enableSslVerification the enable ssl verification
 * @param jenkinsUrl the jenkins url
 * @param projectName the project name
 * @param username the username
 * @param password the password
 * @param pushEvents the push events
 * @param mergeRequestsEvents the merge requests events
 * @param tagPushEvents the tag push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsJenkins/requestBody")
public record GitLabGroupGroupIntegrationsUpdateJenkinPayload(
        @Nullable Boolean enableSslVerification,
        @Nullable String jenkinsUrl,
        @Nullable String projectName,
        @Nullable String username,
        @Nullable String password,
        @Nullable Boolean pushEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code password} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupGroupIntegrationsUpdateJenkinPayload[" + "enableSslVerification=" + enableSslVerification
                + ", jenkinsUrl=" + jenkinsUrl + ", projectName=" + projectName + ", username=" + username
                + ", password=<redacted>" + ", pushEvents=" + pushEvents + ", mergeRequestsEvents="
                + mergeRequestsEvents + ", tagPushEvents=" + tagPushEvents + ", useInheritedSettings="
                + useInheritedSettings + "]";
    }
}
