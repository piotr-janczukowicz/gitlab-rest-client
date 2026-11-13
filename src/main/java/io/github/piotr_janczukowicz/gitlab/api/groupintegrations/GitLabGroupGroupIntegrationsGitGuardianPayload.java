package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsGitGuardian}.
 *
 * @param apiUrl the api url
 * @param token the token
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsGitGuardian/requestBody")
public record GitLabGroupGroupIntegrationsGitGuardianPayload(
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
        return "GitLabGroupGroupIntegrationsGitGuardianPayload[" + "apiUrl=" + apiUrl + ", token=<redacted>"
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
