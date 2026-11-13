package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsJiraCloudApp}.
 *
 * @param jiraCloudAppServiceIds the jira cloud app service ids
 * @param jiraCloudAppEnableDeploymentGating the jira cloud app enable deployment gating
 * @param jiraCloudAppDeploymentGatingEnvironments the jira cloud app deployment gating environments
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsJiraCloudApp/requestBody")
public record GitLabGroupGroupIntegrationsJiraCloudAppPayload(
        @Nullable String jiraCloudAppServiceIds,
        @Nullable Boolean jiraCloudAppEnableDeploymentGating,
        @Nullable String jiraCloudAppDeploymentGatingEnvironments,
        @Nullable Boolean useInheritedSettings) {}
