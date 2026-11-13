package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesJira}.
 *
 * @param url the url
 * @param apiUrl the api url
 * @param jiraAuthType the jira auth type
 * @param username the username
 * @param password the password
 * @param jiraIssueRegex the jira issue regex
 * @param jiraIssuePrefix the jira issue prefix
 * @param jiraIssueTransitionId the jira issue transition id
 * @param issuesEnabled the issues enabled
 * @param projectKeys the project keys
 * @param vulnerabilitiesEnabled the vulnerabilities enabled
 * @param vulnerabilitiesIssuetype the vulnerabilities issuetype
 * @param projectKey the project key
 * @param customizeJiraIssueEnabled the customize jira issue enabled
 * @param jiraCheckEnabled the jira check enabled
 * @param jiraExistsCheckEnabled the jira exists check enabled
 * @param jiraAssigneeCheckEnabled the jira assignee check enabled
 * @param jiraStatusCheckEnabled the jira status check enabled
 * @param jiraAllowedStatusesAsString the jira allowed statuses as string
 * @param commentOnEventEnabled the comment on event enabled
 * @param commitEvents the commit events
 * @param mergeRequestsEvents the merge requests events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesJira/requestBody")
public record GitLabProjectIntegrationsJiraServicePayload(
        @Nullable String url,
        @Nullable String apiUrl,
        @Nullable Integer jiraAuthType,
        @Nullable String username,
        @Nullable String password,
        @Nullable String jiraIssueRegex,
        @Nullable String jiraIssuePrefix,
        @Nullable String jiraIssueTransitionId,
        @Nullable String issuesEnabled,
        @Nullable List<String> projectKeys,
        @Nullable Boolean vulnerabilitiesEnabled,
        @Nullable String vulnerabilitiesIssuetype,
        @Nullable String projectKey,
        @Nullable Boolean customizeJiraIssueEnabled,
        @Nullable Boolean jiraCheckEnabled,
        @Nullable Boolean jiraExistsCheckEnabled,
        @Nullable Boolean jiraAssigneeCheckEnabled,
        @Nullable Boolean jiraStatusCheckEnabled,
        @Nullable String jiraAllowedStatusesAsString,
        @Nullable Boolean commentOnEventEnabled,
        @Nullable Boolean commitEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean useInheritedSettings) {
    public GitLabProjectIntegrationsJiraServicePayload {
        if (projectKeys != null) {
            projectKeys = List.copyOf(projectKeys);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code password} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsJiraServicePayload[" + "url=" + url + ", apiUrl=" + apiUrl + ", jiraAuthType="
                + jiraAuthType + ", username=" + username + ", password=<redacted>" + ", jiraIssueRegex="
                + jiraIssueRegex + ", jiraIssuePrefix=" + jiraIssuePrefix + ", jiraIssueTransitionId="
                + jiraIssueTransitionId + ", issuesEnabled=" + issuesEnabled + ", projectKeys=" + projectKeys
                + ", vulnerabilitiesEnabled=" + vulnerabilitiesEnabled + ", vulnerabilitiesIssuetype="
                + vulnerabilitiesIssuetype + ", projectKey=" + projectKey + ", customizeJiraIssueEnabled="
                + customizeJiraIssueEnabled + ", jiraCheckEnabled=" + jiraCheckEnabled + ", jiraExistsCheckEnabled="
                + jiraExistsCheckEnabled + ", jiraAssigneeCheckEnabled=" + jiraAssigneeCheckEnabled
                + ", jiraStatusCheckEnabled=" + jiraStatusCheckEnabled + ", jiraAllowedStatusesAsString="
                + jiraAllowedStatusesAsString + ", commentOnEventEnabled=" + commentOnEventEnabled + ", commitEvents="
                + commitEvents + ", mergeRequestsEvents=" + mergeRequestsEvents + ", useInheritedSettings="
                + useInheritedSettings + "]";
    }
}
