package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsGitGuardian}.
 *
 * @param apiUrl the api url
 * @param token the token
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsGitGuardian/requestBody")
public record GitLabProjectIntegrationsGitGuardianPayload(
        @Nullable String apiUrl,
        @Nullable String token,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsGitGuardianPayload[" + "apiUrl=" + apiUrl + ", token=<redacted>"
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
