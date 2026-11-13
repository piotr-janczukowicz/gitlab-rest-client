package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsTeamcity}.
 *
 * @param enableSslVerification the enable ssl verification
 * @param teamcityUrl the teamcity url
 * @param buildType the build type
 * @param username the username
 * @param password the password
 * @param pushEvents the push events
 * @param mergeRequestsEvents the merge requests events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsTeamcity/requestBody")
public record GitLabProjectIntegrationsTeamcityPayload(
        @Nullable Boolean enableSslVerification,
        @Nullable String teamcityUrl,
        @Nullable String buildType,
        @Nullable String username,
        @Nullable String password,
        @Nullable Boolean pushEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code password} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsTeamcityPayload[" + "enableSslVerification=" + enableSslVerification
                + ", teamcityUrl=" + teamcityUrl + ", buildType=" + buildType + ", username=" + username
                + ", password=<redacted>" + ", pushEvents=" + pushEvents + ", mergeRequestsEvents="
                + mergeRequestsEvents + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
