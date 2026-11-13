package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import java.util.List;

public final class GroupintegrationsCatalogFixtures {

    private GroupintegrationsCatalogFixtures() {}

    public static GitLabGroupGoogleCloudArtifactRegistryPayload groupGoogleCloudArtifactRegistryPayload() {
        return GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder.builder()
                .artifactRegistryProjectId("artifact_registry_project_id")
                .artifactRegistryRepositories("artifact_registry_repositories")
                .artifactRegistryLocation("artifact_registry_location")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGoogleCloudWorkloadIdentityFederationPayload
            groupGoogleCloudWorkloadIdentityFederationPayload() {
        return GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder()
                .workloadIdentityFederationProjectId("workload_identity_federation_project_id")
                .workloadIdentityFederationProjectNumber("workload_identity_federation_project_number")
                .workloadIdentityPoolId("workload_identity_pool_id")
                .workloadIdentityPoolProviderId("workload_identity_pool_provider_id")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsAppleAppStorePayload groupGroupIntegrationsAppleAppStorePayload() {
        return GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder()
                .appStoreIssuerId("app_store_issuer_id")
                .appStoreKeyId("app_store_key_id")
                .appStorePrivateKeyFileName("app_store_private_key_file_name")
                .appStorePrivateKey("app_store_private_key")
                .appStoreProtectedRefs(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsAsanaPayload groupGroupIntegrationsAsanaPayload() {
        return GitLabGroupGroupIntegrationsAsanaPayloadBuilder.builder()
                .apiKey("api_key")
                .restrictToBranch("restrict_to_branch")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsAssemblaPayload groupGroupIntegrationsAssemblaPayload() {
        return GitLabGroupGroupIntegrationsAssemblaPayloadBuilder.builder()
                .token("token")
                .subdomain("subdomain")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsBambooPayload groupGroupIntegrationsBambooPayload() {
        return GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder()
                .enableSslVerification(true)
                .bambooUrl("bamboo_url")
                .buildKey("build_key")
                .username("username")
                .password("password")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsBugzillaPayload groupGroupIntegrationsBugzillaPayload() {
        return GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsBuildkitePayload groupGroupIntegrationsBuildkitePayload() {
        return GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder()
                .projectUrl("project_url")
                .token("token")
                .enableSslVerification(true)
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsCampfirePayload groupGroupIntegrationsCampfirePayload() {
        return GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder()
                .token("token")
                .subdomain("subdomain")
                .room("room")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsClickupPayload groupGroupIntegrationsClickupPayload() {
        return GitLabGroupGroupIntegrationsClickupPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsConfluencePayload groupGroupIntegrationsConfluencePayload() {
        return GitLabGroupGroupIntegrationsConfluencePayloadBuilder.builder()
                .confluenceUrl("confluence_url")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsCustomIssueTrackerPayload
            groupGroupIntegrationsCustomIssueTrackerPayload() {
        return GitLabGroupGroupIntegrationsCustomIssueTrackerPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsDatadogPayload groupGroupIntegrationsDatadogPayload() {
        return GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder()
                .datadogSite("datadog_site")
                .apiUrl("api_url")
                .apiKey("api_key")
                .datadogCiVisibility(true)
                .archiveTraceEvents(true)
                .datadogService("datadog_service")
                .datadogEnv("datadog_env")
                .datadogTags("datadog_tags")
                .pipelineEvents(true)
                .buildEvents(true)
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .tagPushEvents(true)
                .subgroupEvents(true)
                .projectEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsDiffblueCoverPayload groupGroupIntegrationsDiffblueCoverPayload() {
        return GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder.builder()
                .diffblueLicenseKey("diffblue_license_key")
                .diffblueAccessTokenName("diffblue_access_token_name")
                .diffblueAccessTokenSecret("diffblue_access_token_secret")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsDiscordPayload groupGroupIntegrationsDiscordPayload() {
        return GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder()
                .webhook("webhook")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushChannel("push_channel")
                .issueChannel("issue_channel")
                .incidentChannel("incident_channel")
                .alertChannel("alert_channel")
                .confidentialIssueChannel("confidential_issue_channel")
                .mergeRequestChannel("merge_request_channel")
                .noteChannel("note_channel")
                .confidentialNoteChannel("confidential_note_channel")
                .tagPushChannel("tag_push_channel")
                .deploymentChannel("deployment_channel")
                .pipelineChannel("pipeline_channel")
                .wikiPageChannel("wiki_page_channel")
                .vulnerabilityChannel("vulnerability_channel")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsDroneCiPayload groupGroupIntegrationsDroneCiPayload() {
        return GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder()
                .enableSslVerification(true)
                .droneUrl("drone_url")
                .token("token")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsEmailsOnPushPayload groupGroupIntegrationsEmailsOnPushPayload() {
        return GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder()
                .sendFromCommitterEmail(true)
                .disableDiffs(true)
                .branchesToBeNotified("branches_to_be_notified")
                .recipients("recipients")
                .pushEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsEwmPayload groupGroupIntegrationsEwmPayload() {
        return GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsExternalWikiPayload groupGroupIntegrationsExternalWikiPayload() {
        return GitLabGroupGroupIntegrationsExternalWikiPayloadBuilder.builder()
                .externalWikiUrl("external_wiki_url")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsGitGuardianPayload groupGroupIntegrationsGitGuardianPayload() {
        return GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsGithubPayload groupGroupIntegrationsGithubPayload() {
        return GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder()
                .token("token")
                .repositoryUrl("repository_url")
                .staticContext(true)
                .pipelineEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload
            groupGroupIntegrationsGitlabSlackApplicationPayload() {
        return GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder()
                .channel("channel")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .labelsToBeNotified("labels_to_be_notified")
                .labelsToBeNotifiedBehavior("labels_to_be_notified_behavior")
                .pushChannel("push_channel")
                .issueChannel("issue_channel")
                .incidentChannel("incident_channel")
                .alertChannel("alert_channel")
                .confidentialIssueChannel("confidential_issue_channel")
                .mergeRequestChannel("merge_request_channel")
                .noteChannel("note_channel")
                .confidentialNoteChannel("confidential_note_channel")
                .tagPushChannel("tag_push_channel")
                .deploymentChannel("deployment_channel")
                .pipelineChannel("pipeline_channel")
                .wikiPageChannel("wiki_page_channel")
                .vulnerabilityChannel("vulnerability_channel")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .incidentEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .vulnerabilityEvents(true)
                .alertEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsGooglePlayPayload groupGroupIntegrationsGooglePlayPayload() {
        return GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder()
                .packageName("package_name")
                .serviceAccountKeyFileName("service_account_key_file_name")
                .serviceAccountKey("service_account_key")
                .googlePlayProtectedRefs(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsHangoutsChatPayload groupGroupIntegrationsHangoutsChatPayload() {
        return GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder()
                .webhook("webhook")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsHarborPayload groupGroupIntegrationsHarborPayload() {
        return GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder()
                .url("url")
                .projectName("project_name")
                .username("username")
                .password("password")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsIrkerPayload groupGroupIntegrationsIrkerPayload() {
        return GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder()
                .serverHost("server_host")
                .serverPort(1)
                .defaultIrcUri("default_irc_uri")
                .recipients("recipients")
                .colorizeMessages(true)
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsJiraCloudAppPayload groupGroupIntegrationsJiraCloudAppPayload() {
        return GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder.builder()
                .jiraCloudAppServiceIds("jira_cloud_app_service_ids")
                .jiraCloudAppEnableDeploymentGating(true)
                .jiraCloudAppDeploymentGatingEnvironments("jira_cloud_app_deployment_gating_environments")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsJiraPayload groupGroupIntegrationsJiraPayload() {
        return GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder()
                .url("url")
                .apiUrl("api_url")
                .jiraAuthType(1)
                .username("username")
                .password("password")
                .jiraIssueRegex("jira_issue_regex")
                .jiraIssuePrefix("jira_issue_prefix")
                .jiraIssueTransitionId("jira_issue_transition_id")
                .issuesEnabled("issues_enabled")
                .projectKeys(List.of("project_keys"))
                .vulnerabilitiesEnabled(true)
                .vulnerabilitiesIssuetype("vulnerabilities_issuetype")
                .projectKey("project_key")
                .customizeJiraIssueEnabled(true)
                .jiraCheckEnabled(true)
                .jiraExistsCheckEnabled(true)
                .jiraAssigneeCheckEnabled(true)
                .jiraStatusCheckEnabled(true)
                .jiraAllowedStatusesAsString("jira_allowed_statuses_as_string")
                .commentOnEventEnabled(true)
                .commitEvents(true)
                .mergeRequestsEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsLinearPayload groupGroupIntegrationsLinearPayload() {
        return GitLabGroupGroupIntegrationsLinearPayloadBuilder.builder()
                .workspaceUrl("workspace_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsMatrixPayload groupGroupIntegrationsMatrixPayload() {
        return GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder()
                .hostname("hostname")
                .token("token")
                .room("room")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .incidentEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .vulnerabilityEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsMattermostPayload groupGroupIntegrationsMattermostPayload() {
        return GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder()
                .webhook("webhook")
                .username("username")
                .channel("channel")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .labelsToBeNotified("labels_to_be_notified")
                .labelsToBeNotifiedBehavior("labels_to_be_notified_behavior")
                .pushChannel("push_channel")
                .issueChannel("issue_channel")
                .incidentChannel("incident_channel")
                .alertChannel("alert_channel")
                .confidentialIssueChannel("confidential_issue_channel")
                .mergeRequestChannel("merge_request_channel")
                .noteChannel("note_channel")
                .confidentialNoteChannel("confidential_note_channel")
                .tagPushChannel("tag_push_channel")
                .deploymentChannel("deployment_channel")
                .pipelineChannel("pipeline_channel")
                .wikiPageChannel("wiki_page_channel")
                .vulnerabilityChannel("vulnerability_channel")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .incidentEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .vulnerabilityEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsMockCiPayload groupGroupIntegrationsMockCiPayload() {
        return GitLabGroupGroupIntegrationsMockCiPayloadBuilder.builder()
                .enableSslVerification(true)
                .mockServiceUrl("mock_service_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsMockMonitoringPayload groupGroupIntegrationsMockMonitoringPayload() {
        return GitLabGroupGroupIntegrationsMockMonitoringPayloadBuilder.builder()
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsPackagistPayload groupGroupIntegrationsPackagistPayload() {
        return GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder()
                .username("username")
                .token("token")
                .server("server")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsPhorgePayload groupGroupIntegrationsPhorgePayload() {
        return GitLabGroupGroupIntegrationsPhorgePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsPipelinesEmailPayload groupGroupIntegrationsPipelinesEmailPayload() {
        return GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder()
                .recipients("recipients")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .notifyOnlyDefaultBranch(true)
                .branchesToBeNotified("branches_to_be_notified")
                .notifyChildPipelines(true)
                .pipelineEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsPivotaltrackerPayload groupGroupIntegrationsPivotaltrackerPayload() {
        return GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder.builder()
                .token("token")
                .restrictToBranch("restrict_to_branch")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsPumblePayload groupGroupIntegrationsPumblePayload() {
        return GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder()
                .webhook("webhook")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsPushoverPayload groupGroupIntegrationsPushoverPayload() {
        return GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder()
                .apiKey("api_key")
                .userKey("user_key")
                .device("device")
                .priority("priority")
                .sound("sound")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsRedminePayload groupGroupIntegrationsRedminePayload() {
        return GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsSlackPayload groupGroupIntegrationsSlackPayload() {
        return GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder()
                .webhook("webhook")
                .username("username")
                .channel("channel")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .labelsToBeNotified("labels_to_be_notified")
                .labelsToBeNotifiedBehavior("labels_to_be_notified_behavior")
                .pushChannel("push_channel")
                .issueChannel("issue_channel")
                .incidentChannel("incident_channel")
                .alertChannel("alert_channel")
                .confidentialIssueChannel("confidential_issue_channel")
                .mergeRequestChannel("merge_request_channel")
                .noteChannel("note_channel")
                .confidentialNoteChannel("confidential_note_channel")
                .tagPushChannel("tag_push_channel")
                .deploymentChannel("deployment_channel")
                .pipelineChannel("pipeline_channel")
                .wikiPageChannel("wiki_page_channel")
                .vulnerabilityChannel("vulnerability_channel")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .incidentEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .vulnerabilityEvents(true)
                .alertEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsSquashTmPayload groupGroupIntegrationsSquashTmPayload() {
        return GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder()
                .url("url")
                .token("token")
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsTeamcityPayload groupGroupIntegrationsTeamcityPayload() {
        return GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder()
                .enableSslVerification(true)
                .teamcityUrl("teamcity_url")
                .buildType("build_type")
                .username("username")
                .password("password")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsTelegramPayload groupGroupIntegrationsTelegramPayload() {
        return GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder()
                .hostname("hostname")
                .token("token")
                .room("room")
                .thread("thread")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .incidentEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .vulnerabilityEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsUnifyCircuitPayload groupGroupIntegrationsUnifyCircuitPayload() {
        return GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder()
                .webhook("webhook")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsUpdateJenkinPayload groupGroupIntegrationsUpdateJenkinPayload() {
        return GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder()
                .enableSslVerification(true)
                .jenkinsUrl("jenkins_url")
                .projectName("project_name")
                .username("username")
                .password("password")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload
            groupGroupIntegrationsUpdateMattermostSlashCommandPayload() {
        return GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder()
                .token("token")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload
            groupGroupIntegrationsUpdateMicrosoftTeamPayload() {
        return GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder()
                .webhook("webhook")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsUpdateWebexTeamPayload groupGroupIntegrationsUpdateWebexTeamPayload() {
        return GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder()
                .webhook("webhook")
                .notifyOnlyBrokenPipelines(true)
                .notifyOnlyWhenPipelineStatusChanges(true)
                .branchesToBeNotified("branches_to_be_notified")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .workItemEvents(true)
                .confidentialWorkItemEvents(true)
                .mergeRequestsEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .tagPushEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsYoutrackPayload groupGroupIntegrationsYoutrackPayload() {
        return GitLabGroupGroupIntegrationsYoutrackPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabGroupGroupIntegrationsZentaoPayload groupGroupIntegrationsZentaoPayload() {
        return GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder()
                .url("url")
                .apiUrl("api_url")
                .apiToken("api_token")
                .zentaoProductXid("zentao_product_xid")
                .useInheritedSettings(true)
                .build();
    }
}
