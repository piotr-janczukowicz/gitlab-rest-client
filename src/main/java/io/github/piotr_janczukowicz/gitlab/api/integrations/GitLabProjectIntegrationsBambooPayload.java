package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsBamboo}.
 *
 * @param enableSslVerification the enable ssl verification
 * @param bambooUrl the bamboo url
 * @param buildKey the build key
 * @param username the username
 * @param password the password
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsBamboo/requestBody")
public record GitLabProjectIntegrationsBambooPayload(
        @Nullable Boolean enableSslVerification,
        @Nullable String bambooUrl,
        @Nullable String buildKey,
        @Nullable String username,
        @Nullable String password,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code password} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsBambooPayload[" + "enableSslVerification=" + enableSslVerification
                + ", bambooUrl=" + bambooUrl + ", buildKey=" + buildKey + ", username=" + username
                + ", password=<redacted>" + ", pushEvents=" + pushEvents + ", useInheritedSettings="
                + useInheritedSettings + "]";
    }
}
