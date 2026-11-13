package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsPivotaltracker}.
 *
 * @param token the token
 * @param restrictToBranch the restrict to branch
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsPivotaltracker/requestBody")
public record GitLabProjectIntegrationsPivotaltrackerPayload(
        @Nullable String token,
        @Nullable String restrictToBranch,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsPivotaltrackerPayload[" + "token=<redacted>" + ", restrictToBranch="
                + restrictToBranch + ", pushEvents=" + pushEvents + ", useInheritedSettings=" + useInheritedSettings
                + "]";
    }
}
