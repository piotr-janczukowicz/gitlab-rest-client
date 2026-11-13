package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesAssembla}.
 *
 * @param token the token
 * @param subdomain the subdomain
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesAssembla/requestBody")
public record GitLabProjectIntegrationsAssemblaServicePayload(
        @Nullable String token,
        @Nullable String subdomain,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsAssemblaServicePayload[" + "token=<redacted>" + ", subdomain=" + subdomain
                + ", pushEvents=" + pushEvents + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
