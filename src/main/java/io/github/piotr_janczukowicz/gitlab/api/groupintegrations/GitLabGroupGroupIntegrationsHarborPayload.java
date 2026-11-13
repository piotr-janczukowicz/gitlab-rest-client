package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsHarbor}.
 *
 * @param url the url
 * @param projectName the project name
 * @param username the username
 * @param password the password
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsHarbor/requestBody")
public record GitLabGroupGroupIntegrationsHarborPayload(
        @Nullable String url,
        @Nullable String projectName,
        @Nullable String username,
        @Nullable String password,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code password} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupGroupIntegrationsHarborPayload[" + "url=" + url + ", projectName=" + projectName
                + ", username=" + username + ", password=<redacted>" + ", useInheritedSettings=" + useInheritedSettings
                + "]";
    }
}
