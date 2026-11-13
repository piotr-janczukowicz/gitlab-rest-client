package io.github.piotr_janczukowicz.gitlab.api.integrations;

import java.util.List;
import java.util.Map;

public final class IntegrationsCatalogFixtures {

    private IntegrationsCatalogFixtures() {}

    public static GitLabProjectGoogleCloudArtifactRegistryPayload projectGoogleCloudArtifactRegistryPayload() {
        return GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder.builder()
                .artifactRegistryProjectId("artifact_registry_project_id")
                .artifactRegistryRepositories("artifact_registry_repositories")
                .artifactRegistryLocation("artifact_registry_location")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectGoogleCloudWorkloadIdentityFederationPayload
            projectGoogleCloudWorkloadIdentityFederationPayload() {
        return GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder()
                .workloadIdentityFederationProjectId("workload_identity_federation_project_id")
                .workloadIdentityFederationProjectNumber("workload_identity_federation_project_number")
                .workloadIdentityPoolId("workload_identity_pool_id")
                .workloadIdentityPoolProviderId("workload_identity_pool_provider_id")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsAppleAppStorePayload projectIntegrationsAppleAppStorePayload() {
        return GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder()
                .appStoreIssuerId("app_store_issuer_id")
                .appStoreKeyId("app_store_key_id")
                .appStorePrivateKeyFileName("app_store_private_key_file_name")
                .appStorePrivateKey("app_store_private_key")
                .appStoreProtectedRefs(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsAppleAppStoreServicePayload
            projectIntegrationsAppleAppStoreServicePayload() {
        return GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder()
                .appStoreIssuerId("app_store_issuer_id")
                .appStoreKeyId("app_store_key_id")
                .appStorePrivateKeyFileName("app_store_private_key_file_name")
                .appStorePrivateKey("app_store_private_key")
                .appStoreProtectedRefs(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsAsanaPayload projectIntegrationsAsanaPayload() {
        return GitLabProjectIntegrationsAsanaPayloadBuilder.builder()
                .apiKey("api_key")
                .restrictToBranch("restrict_to_branch")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsAsanaServicePayload projectIntegrationsAsanaServicePayload() {
        return GitLabProjectIntegrationsAsanaServicePayloadBuilder.builder()
                .apiKey("api_key")
                .restrictToBranch("restrict_to_branch")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsAssemblaPayload projectIntegrationsAssemblaPayload() {
        return GitLabProjectIntegrationsAssemblaPayloadBuilder.builder()
                .token("token")
                .subdomain("subdomain")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsAssemblaServicePayload projectIntegrationsAssemblaServicePayload() {
        return GitLabProjectIntegrationsAssemblaServicePayloadBuilder.builder()
                .token("token")
                .subdomain("subdomain")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsBambooPayload projectIntegrationsBambooPayload() {
        return GitLabProjectIntegrationsBambooPayloadBuilder.builder()
                .enableSslVerification(true)
                .bambooUrl("bamboo_url")
                .buildKey("build_key")
                .username("username")
                .password("password")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsBambooServicePayload projectIntegrationsBambooServicePayload() {
        return GitLabProjectIntegrationsBambooServicePayloadBuilder.builder()
                .enableSslVerification(true)
                .bambooUrl("bamboo_url")
                .buildKey("build_key")
                .username("username")
                .password("password")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsBugzillaPayload projectIntegrationsBugzillaPayload() {
        return GitLabProjectIntegrationsBugzillaPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsBugzillaServicePayload projectIntegrationsBugzillaServicePayload() {
        return GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsBuildkitePayload projectIntegrationsBuildkitePayload() {
        return GitLabProjectIntegrationsBuildkitePayloadBuilder.builder()
                .projectUrl("project_url")
                .token("token")
                .enableSslVerification(true)
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsBuildkiteServicePayload projectIntegrationsBuildkiteServicePayload() {
        return GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .token("token")
                .enableSslVerification(true)
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsCampfirePayload projectIntegrationsCampfirePayload() {
        return GitLabProjectIntegrationsCampfirePayloadBuilder.builder()
                .token("token")
                .subdomain("subdomain")
                .room("room")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsCampfireServicePayload projectIntegrationsCampfireServicePayload() {
        return GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder()
                .token("token")
                .subdomain("subdomain")
                .room("room")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsClickupPayload projectIntegrationsClickupPayload() {
        return GitLabProjectIntegrationsClickupPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsClickupServicePayload projectIntegrationsClickupServicePayload() {
        return GitLabProjectIntegrationsClickupServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsConfluencePayload projectIntegrationsConfluencePayload() {
        return GitLabProjectIntegrationsConfluencePayloadBuilder.builder()
                .confluenceUrl("confluence_url")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsConfluenceServicePayload projectIntegrationsConfluenceServicePayload() {
        return GitLabProjectIntegrationsConfluenceServicePayloadBuilder.builder()
                .confluenceUrl("confluence_url")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsCreateSlackEventPayload projectIntegrationsCreateSlackEventPayload() {
        return GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder()
                .token("token")
                .teamId("team_id")
                .apiAppId("api_app_id")
                .event(Map.of("key", "value"))
                .type("type")
                .eventId("event_id")
                .eventTime(1)
                .authedUsers(List.of("authed_users"))
                .build();
    }

    public static GitLabProjectIntegrationsCustomIssueTrackerPayload projectIntegrationsCustomIssueTrackerPayload() {
        return GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsCustomIssueTrackerServicePayload
            projectIntegrationsCustomIssueTrackerServicePayload() {
        return GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsDatadogPayload projectIntegrationsDatadogPayload() {
        return GitLabProjectIntegrationsDatadogPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsDatadogServicePayload projectIntegrationsDatadogServicePayload() {
        return GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsDiffblueCoverPayload projectIntegrationsDiffblueCoverPayload() {
        return GitLabProjectIntegrationsDiffblueCoverPayloadBuilder.builder()
                .diffblueLicenseKey("diffblue_license_key")
                .diffblueAccessTokenName("diffblue_access_token_name")
                .diffblueAccessTokenSecret("diffblue_access_token_secret")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsDiffblueCoverServicePayload
            projectIntegrationsDiffblueCoverServicePayload() {
        return GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder.builder()
                .diffblueLicenseKey("diffblue_license_key")
                .diffblueAccessTokenName("diffblue_access_token_name")
                .diffblueAccessTokenSecret("diffblue_access_token_secret")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsDiscordPayload projectIntegrationsDiscordPayload() {
        return GitLabProjectIntegrationsDiscordPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsDiscordServicePayload projectIntegrationsDiscordServicePayload() {
        return GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsDroneCiPayload projectIntegrationsDroneCiPayload() {
        return GitLabProjectIntegrationsDroneCiPayloadBuilder.builder()
                .enableSslVerification(true)
                .droneUrl("drone_url")
                .token("token")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsDroneCiServicePayload projectIntegrationsDroneCiServicePayload() {
        return GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder()
                .enableSslVerification(true)
                .droneUrl("drone_url")
                .token("token")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsEmailsOnPushPayload projectIntegrationsEmailsOnPushPayload() {
        return GitLabProjectIntegrationsEmailsOnPushPayloadBuilder.builder()
                .sendFromCommitterEmail(true)
                .disableDiffs(true)
                .branchesToBeNotified("branches_to_be_notified")
                .recipients("recipients")
                .pushEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsEmailsOnPushServicePayload projectIntegrationsEmailsOnPushServicePayload() {
        return GitLabProjectIntegrationsEmailsOnPushServicePayloadBuilder.builder()
                .sendFromCommitterEmail(true)
                .disableDiffs(true)
                .branchesToBeNotified("branches_to_be_notified")
                .recipients("recipients")
                .pushEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsEwmPayload projectIntegrationsEwmPayload() {
        return GitLabProjectIntegrationsEwmPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsEwmServicePayload projectIntegrationsEwmServicePayload() {
        return GitLabProjectIntegrationsEwmServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsExternalWikiPayload projectIntegrationsExternalWikiPayload() {
        return GitLabProjectIntegrationsExternalWikiPayloadBuilder.builder()
                .externalWikiUrl("external_wiki_url")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsExternalWikiServicePayload projectIntegrationsExternalWikiServicePayload() {
        return GitLabProjectIntegrationsExternalWikiServicePayloadBuilder.builder()
                .externalWikiUrl("external_wiki_url")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsGitGuardianPayload projectIntegrationsGitGuardianPayload() {
        return GitLabProjectIntegrationsGitGuardianPayloadBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsGitGuardianServicePayload projectIntegrationsGitGuardianServicePayload() {
        return GitLabProjectIntegrationsGitGuardianServicePayloadBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsGithubPayload projectIntegrationsGithubPayload() {
        return GitLabProjectIntegrationsGithubPayloadBuilder.builder()
                .token("token")
                .repositoryUrl("repository_url")
                .staticContext(true)
                .pipelineEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsGithubServicePayload projectIntegrationsGithubServicePayload() {
        return GitLabProjectIntegrationsGithubServicePayloadBuilder.builder()
                .token("token")
                .repositoryUrl("repository_url")
                .staticContext(true)
                .pipelineEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsGitlabSlackApplicationPayload
            projectIntegrationsGitlabSlackApplicationPayload() {
        return GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsGitlabSlackApplicationServicePayload
            projectIntegrationsGitlabSlackApplicationServicePayload() {
        return GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsGooglePlayPayload projectIntegrationsGooglePlayPayload() {
        return GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder()
                .packageName("package_name")
                .serviceAccountKeyFileName("service_account_key_file_name")
                .serviceAccountKey("service_account_key")
                .googlePlayProtectedRefs(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsGooglePlayServicePayload projectIntegrationsGooglePlayServicePayload() {
        return GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder()
                .packageName("package_name")
                .serviceAccountKeyFileName("service_account_key_file_name")
                .serviceAccountKey("service_account_key")
                .googlePlayProtectedRefs(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsHangoutsChatPayload projectIntegrationsHangoutsChatPayload() {
        return GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsHangoutsChatServicePayload projectIntegrationsHangoutsChatServicePayload() {
        return GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsHarborPayload projectIntegrationsHarborPayload() {
        return GitLabProjectIntegrationsHarborPayloadBuilder.builder()
                .url("url")
                .projectName("project_name")
                .username("username")
                .password("password")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsHarborServicePayload projectIntegrationsHarborServicePayload() {
        return GitLabProjectIntegrationsHarborServicePayloadBuilder.builder()
                .url("url")
                .projectName("project_name")
                .username("username")
                .password("password")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsIrkerPayload projectIntegrationsIrkerPayload() {
        return GitLabProjectIntegrationsIrkerPayloadBuilder.builder()
                .serverHost("server_host")
                .serverPort(1)
                .defaultIrcUri("default_irc_uri")
                .recipients("recipients")
                .colorizeMessages(true)
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsIrkerServicePayload projectIntegrationsIrkerServicePayload() {
        return GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder()
                .serverHost("server_host")
                .serverPort(1)
                .defaultIrcUri("default_irc_uri")
                .recipients("recipients")
                .colorizeMessages(true)
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsJiraCloudAppPayload projectIntegrationsJiraCloudAppPayload() {
        return GitLabProjectIntegrationsJiraCloudAppPayloadBuilder.builder()
                .jiraCloudAppServiceIds("jira_cloud_app_service_ids")
                .jiraCloudAppEnableDeploymentGating(true)
                .jiraCloudAppDeploymentGatingEnvironments("jira_cloud_app_deployment_gating_environments")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsJiraCloudAppServicePayload projectIntegrationsJiraCloudAppServicePayload() {
        return GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder.builder()
                .jiraCloudAppServiceIds("jira_cloud_app_service_ids")
                .jiraCloudAppEnableDeploymentGating(true)
                .jiraCloudAppDeploymentGatingEnvironments("jira_cloud_app_deployment_gating_environments")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsJiraPayload projectIntegrationsJiraPayload() {
        return GitLabProjectIntegrationsJiraPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsJiraServicePayload projectIntegrationsJiraServicePayload() {
        return GitLabProjectIntegrationsJiraServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsLinearPayload projectIntegrationsLinearPayload() {
        return GitLabProjectIntegrationsLinearPayloadBuilder.builder()
                .workspaceUrl("workspace_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsLinearServicePayload projectIntegrationsLinearServicePayload() {
        return GitLabProjectIntegrationsLinearServicePayloadBuilder.builder()
                .workspaceUrl("workspace_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsMatrixPayload projectIntegrationsMatrixPayload() {
        return GitLabProjectIntegrationsMatrixPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsMatrixServicePayload projectIntegrationsMatrixServicePayload() {
        return GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsMattermostPayload projectIntegrationsMattermostPayload() {
        return GitLabProjectIntegrationsMattermostPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsMattermostServicePayload projectIntegrationsMattermostServicePayload() {
        return GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsMockCiPayload projectIntegrationsMockCiPayload() {
        return GitLabProjectIntegrationsMockCiPayloadBuilder.builder()
                .enableSslVerification(true)
                .mockServiceUrl("mock_service_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsMockCiServicePayload projectIntegrationsMockCiServicePayload() {
        return GitLabProjectIntegrationsMockCiServicePayloadBuilder.builder()
                .enableSslVerification(true)
                .mockServiceUrl("mock_service_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsMockMonitoringPayload projectIntegrationsMockMonitoringPayload() {
        return GitLabProjectIntegrationsMockMonitoringPayloadBuilder.builder()
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsMockMonitoringServicePayload
            projectIntegrationsMockMonitoringServicePayload() {
        return GitLabProjectIntegrationsMockMonitoringServicePayloadBuilder.builder()
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPackagistPayload projectIntegrationsPackagistPayload() {
        return GitLabProjectIntegrationsPackagistPayloadBuilder.builder()
                .username("username")
                .token("token")
                .server("server")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPackagistServicePayload projectIntegrationsPackagistServicePayload() {
        return GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder()
                .username("username")
                .token("token")
                .server("server")
                .pushEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPhorgePayload projectIntegrationsPhorgePayload() {
        return GitLabProjectIntegrationsPhorgePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPhorgeServicePayload projectIntegrationsPhorgeServicePayload() {
        return GitLabProjectIntegrationsPhorgeServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPipelinesEmailPayload projectIntegrationsPipelinesEmailPayload() {
        return GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsPipelinesEmailServicePayload
            projectIntegrationsPipelinesEmailServicePayload() {
        return GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsPivotaltrackerPayload projectIntegrationsPivotaltrackerPayload() {
        return GitLabProjectIntegrationsPivotaltrackerPayloadBuilder.builder()
                .token("token")
                .restrictToBranch("restrict_to_branch")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPivotaltrackerServicePayload
            projectIntegrationsPivotaltrackerServicePayload() {
        return GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder.builder()
                .token("token")
                .restrictToBranch("restrict_to_branch")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPumblePayload projectIntegrationsPumblePayload() {
        return GitLabProjectIntegrationsPumblePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsPumbleServicePayload projectIntegrationsPumbleServicePayload() {
        return GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsPushoverPayload projectIntegrationsPushoverPayload() {
        return GitLabProjectIntegrationsPushoverPayloadBuilder.builder()
                .apiKey("api_key")
                .userKey("user_key")
                .device("device")
                .priority("priority")
                .sound("sound")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsPushoverServicePayload projectIntegrationsPushoverServicePayload() {
        return GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder()
                .apiKey("api_key")
                .userKey("user_key")
                .device("device")
                .priority("priority")
                .sound("sound")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsRedminePayload projectIntegrationsRedminePayload() {
        return GitLabProjectIntegrationsRedminePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsRedmineServicePayload projectIntegrationsRedmineServicePayload() {
        return GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .newIssueUrl("new_issue_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsSlackPayload projectIntegrationsSlackPayload() {
        return GitLabProjectIntegrationsSlackPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsSlackServicePayload projectIntegrationsSlackServicePayload() {
        return GitLabProjectIntegrationsSlackServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsSquashTmPayload projectIntegrationsSquashTmPayload() {
        return GitLabProjectIntegrationsSquashTmPayloadBuilder.builder()
                .url("url")
                .token("token")
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsSquashTmServicePayload projectIntegrationsSquashTmServicePayload() {
        return GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder()
                .url("url")
                .token("token")
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsTeamcityPayload projectIntegrationsTeamcityPayload() {
        return GitLabProjectIntegrationsTeamcityPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsTeamcityServicePayload projectIntegrationsTeamcityServicePayload() {
        return GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsTelegramPayload projectIntegrationsTelegramPayload() {
        return GitLabProjectIntegrationsTelegramPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsTelegramServicePayload projectIntegrationsTelegramServicePayload() {
        return GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload
            projectIntegrationsTriggerMattermostSlashCommandPayload() {
        return GitLabProjectIntegrationsTriggerMattermostSlashCommandPayloadBuilder.builder()
                .token("token")
                .build();
    }

    public static GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload
            projectIntegrationsTriggerServicesMattermostSlashCommandPayload() {
        return GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayloadBuilder.builder()
                .token("token")
                .build();
    }

    public static GitLabProjectIntegrationsTriggerSlackPayload projectIntegrationsTriggerSlackPayload() {
        return GitLabProjectIntegrationsTriggerSlackPayloadBuilder.builder()
                .text("text")
                .build();
    }

    public static GitLabProjectIntegrationsUnifyCircuitPayload projectIntegrationsUnifyCircuitPayload() {
        return GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUnifyCircuitServicePayload projectIntegrationsUnifyCircuitServicePayload() {
        return GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUpdateJenkinPayload projectIntegrationsUpdateJenkinPayload() {
        return GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload
            projectIntegrationsUpdateMattermostSlashCommandPayload() {
        return GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder()
                .token("token")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsUpdateMicrosoftTeamPayload projectIntegrationsUpdateMicrosoftTeamPayload() {
        return GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUpdateServicesJenkinPayload
            projectIntegrationsUpdateServicesJenkinPayload() {
        return GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload
            projectIntegrationsUpdateServicesMattermostSlashCommandPayload() {
        return GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadBuilder.builder()
                .token("token")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload
            projectIntegrationsUpdateServicesMicrosoftTeamPayload() {
        return GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUpdateServicesWebexTeamPayload
            projectIntegrationsUpdateServicesWebexTeamPayload() {
        return GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsUpdateWebexTeamPayload projectIntegrationsUpdateWebexTeamPayload() {
        return GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder()
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

    public static GitLabProjectIntegrationsYoutrackPayload projectIntegrationsYoutrackPayload() {
        return GitLabProjectIntegrationsYoutrackPayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsYoutrackServicePayload projectIntegrationsYoutrackServicePayload() {
        return GitLabProjectIntegrationsYoutrackServicePayloadBuilder.builder()
                .projectUrl("project_url")
                .issuesUrl("issues_url")
                .pushEvents(true)
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsZentaoPayload projectIntegrationsZentaoPayload() {
        return GitLabProjectIntegrationsZentaoPayloadBuilder.builder()
                .url("url")
                .apiUrl("api_url")
                .apiToken("api_token")
                .zentaoProductXid("zentao_product_xid")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectIntegrationsZentaoServicePayload projectIntegrationsZentaoServicePayload() {
        return GitLabProjectIntegrationsZentaoServicePayloadBuilder.builder()
                .url("url")
                .apiUrl("api_url")
                .apiToken("api_token")
                .zentaoProductXid("zentao_product_xid")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectServiceGoogleCloudArtifactRegistryPayload
            projectServiceGoogleCloudArtifactRegistryPayload() {
        return GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder.builder()
                .artifactRegistryProjectId("artifact_registry_project_id")
                .artifactRegistryRepositories("artifact_registry_repositories")
                .artifactRegistryLocation("artifact_registry_location")
                .useInheritedSettings(true)
                .build();
    }

    public static GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload
            projectServiceGoogleCloudWorkloadIdentityFederationPayload() {
        return GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder()
                .workloadIdentityFederationProjectId("workload_identity_federation_project_id")
                .workloadIdentityFederationProjectNumber("workload_identity_federation_project_number")
                .workloadIdentityPoolId("workload_identity_pool_id")
                .workloadIdentityPoolProviderId("workload_identity_pool_provider_id")
                .useInheritedSettings(true)
                .build();
    }
}
