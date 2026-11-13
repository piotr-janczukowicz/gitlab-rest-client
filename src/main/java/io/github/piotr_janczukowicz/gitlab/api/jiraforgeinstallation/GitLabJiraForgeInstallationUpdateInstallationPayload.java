package io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4IntegrationsJiraForgeInstallation}.
 *
 * @param instanceUrl the instance url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4IntegrationsJiraForgeInstallation/requestBody")
public record GitLabJiraForgeInstallationUpdateInstallationPayload(
        @Nullable String instanceUrl) {
    public GitLabJiraForgeInstallationUpdateInstallationPayload {
        requireMaxLengthIfPresent(instanceUrl, 1024, "instanceUrl");
    }
}
