package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsDiffblueCover}.
 *
 * @param diffblueLicenseKey the diffblue license key
 * @param diffblueAccessTokenName the diffblue access token name
 * @param diffblueAccessTokenSecret the diffblue access token secret
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsDiffblueCover/requestBody")
public record GitLabGroupGroupIntegrationsDiffblueCoverPayload(
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
        return "GitLabGroupGroupIntegrationsDiffblueCoverPayload[" + "diffblueLicenseKey=" + diffblueLicenseKey
                + ", diffblueAccessTokenName=" + diffblueAccessTokenName + ", diffblueAccessTokenSecret=<redacted>"
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
