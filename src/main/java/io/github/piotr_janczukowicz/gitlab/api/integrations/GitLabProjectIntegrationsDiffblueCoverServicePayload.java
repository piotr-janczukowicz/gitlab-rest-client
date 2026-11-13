package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesDiffblueCover}.
 *
 * @param diffblueLicenseKey the diffblue license key
 * @param diffblueAccessTokenName the diffblue access token name
 * @param diffblueAccessTokenSecret the diffblue access token secret
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesDiffblueCover/requestBody")
public record GitLabProjectIntegrationsDiffblueCoverServicePayload(
        @Nullable String diffblueLicenseKey,
        @Nullable String diffblueAccessTokenName,
        @Nullable String diffblueAccessTokenSecret,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code diffblueAccessTokenSecret} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsDiffblueCoverServicePayload[" + "diffblueLicenseKey=" + diffblueLicenseKey
                + ", diffblueAccessTokenName=" + diffblueAccessTokenName + ", diffblueAccessTokenSecret=<redacted>"
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
