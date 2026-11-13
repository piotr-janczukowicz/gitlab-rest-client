package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsSquashTm}.
 *
 * @param url the url
 * @param token the token
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsSquashTm/requestBody")
public record GitLabProjectIntegrationsSquashTmPayload(
        @Nullable String url,
        @Nullable String token,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsSquashTmPayload[" + "url=" + url + ", token=<redacted>" + ", issuesEvents="
                + issuesEvents + ", confidentialIssuesEvents=" + confidentialIssuesEvents + ", useInheritedSettings="
                + useInheritedSettings + "]";
    }
}
