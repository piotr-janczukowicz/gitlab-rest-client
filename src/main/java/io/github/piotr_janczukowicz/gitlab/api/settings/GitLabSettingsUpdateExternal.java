package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param externalAuthClientCert the external auth client cert
 * @param externalAuthClientKey the external auth client key
 * @param externalAuthClientKeyPass the external auth client key pass
 * @param externalAuthorizationServiceDefaultLabel the external authorization service default label
 * @param externalAuthorizationServiceEnabled the external authorization service enabled
 * @param externalAuthorizationServiceTimeout the external authorization service timeout
 * @param externalAuthorizationServiceUrl the external authorization service url
 * @param externalPipelineValidationServiceTimeout the external pipeline validation service timeout
 * @param externalPipelineValidationServiceToken the external pipeline validation service token
 * @param externalPipelineValidationServiceUrl the external pipeline validation service url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateExternal(
        @Nullable String externalAuthClientCert,
        @Nullable String externalAuthClientKey,
        @Nullable String externalAuthClientKeyPass,
        @Nullable String externalAuthorizationServiceDefaultLabel,
        @Nullable String externalAuthorizationServiceEnabled,
        @Nullable String externalAuthorizationServiceTimeout,
        @Nullable String externalAuthorizationServiceUrl,
        @Nullable String externalPipelineValidationServiceTimeout,
        @Nullable String externalPipelineValidationServiceToken,
        @Nullable String externalPipelineValidationServiceUrl) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code externalPipelineValidationServiceToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateExternal[" + "externalAuthClientCert=" + externalAuthClientCert
                + ", externalAuthClientKey=" + externalAuthClientKey + ", externalAuthClientKeyPass="
                + externalAuthClientKeyPass + ", externalAuthorizationServiceDefaultLabel="
                + externalAuthorizationServiceDefaultLabel + ", externalAuthorizationServiceEnabled="
                + externalAuthorizationServiceEnabled + ", externalAuthorizationServiceTimeout="
                + externalAuthorizationServiceTimeout + ", externalAuthorizationServiceUrl="
                + externalAuthorizationServiceUrl + ", externalPipelineValidationServiceTimeout="
                + externalPipelineValidationServiceTimeout + ", externalPipelineValidationServiceToken=<redacted>"
                + ", externalPipelineValidationServiceUrl=" + externalPipelineValidationServiceUrl + "]";
    }
}
