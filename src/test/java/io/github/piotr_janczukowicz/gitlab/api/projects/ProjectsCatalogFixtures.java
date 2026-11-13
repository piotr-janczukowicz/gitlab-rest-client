package io.github.piotr_janczukowicz.gitlab.api.projects;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class ProjectsCatalogFixtures {

    private ProjectsCatalogFixtures() {}

    public static GitLabAiExternalAgentsIdentity aiExternalAgentsIdentity() {
        return GitLabAiExternalAgentsIdentityBuilder.builder()
                .id(1L)
                .agentType("claude-code")
                .revokedAt("revoked_at")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabAiExternalAgentsSession aiExternalAgentsSession() {
        return GitLabAiExternalAgentsSessionBuilder.builder()
                .id(1L)
                .agentType("claude-code")
                .userId(1L)
                .status("running")
                .flowType("external_agent")
                .glabVersion("glab 1.121.0 (abc1234)")
                .agentVersion("2.1.295")
                .syncType("hook")
                .externalXid("uuid")
                .sessionStartedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .sessionFinishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabAnalyticsDeploymentFrequency analyticsDeploymentFrequency() {
        return GitLabAnalyticsDeploymentFrequencyBuilder.builder()
                .value(1)
                .fromValue(LocalDate.parse("2026-01-01"))
                .to(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabCiCatalogResourcesVersion ciCatalogResourcesVersion() {
        return GitLabCiCatalogResourcesVersionBuilder.builder()
                .catalogUrl("https://gitlab.example.com/explore/catalog/my-namespace/my-component-project")
                .build();
    }

    public static GitLabManagedLicense managedLicense() {
        return GitLabManagedLicenseBuilder.builder()
                .id(1L)
                .name("name")
                .approvalStatus("approval_status")
                .build();
    }

    public static GitLabMlMlflowExperiment mlMlflowExperiment() {
        return GitLabMlMlflowExperimentBuilder.builder()
                .experimentId("1")
                .name("my_experiment")
                .lifecycleStage("active")
                .artifactLocation("artifact_location")
                .tags(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()))
                .build();
    }

    public static GitLabMlMlflowGetDownload mlMlflowGetDownload() {
        return GitLabMlMlflowGetDownloadBuilder.builder()
                .artifactUri("artifact_uri")
                .build();
    }

    public static GitLabMlMlflowGetExperiment mlMlflowGetExperiment() {
        return GitLabMlMlflowGetExperimentBuilder.builder()
                .experiment(ProjectsCatalogFixtures.mlMlflowExperiment())
                .build();
    }

    public static GitLabMlMlflowGetMetricHistory mlMlflowGetMetricHistory() {
        return GitLabMlMlflowGetMetricHistoryBuilder.builder()
                .metrics(List.of(ProjectsCatalogFixtures.mlMlflowMetric()))
                .nextPageToken("next_page_token")
                .build();
    }

    public static GitLabMlMlflowKeyValue mlMlflowKeyValue() {
        return GitLabMlMlflowKeyValueBuilder.builder().key("key").value("value").build();
    }

    public static GitLabMlMlflowListExperiment mlMlflowListExperiment() {
        return GitLabMlMlflowListExperimentBuilder.builder()
                .experiments(List.of(ProjectsCatalogFixtures.mlMlflowExperiment()))
                .nextPageToken("next_page_token")
                .build();
    }

    public static GitLabMlMlflowListRegisteredModels mlMlflowListRegisteredModels() {
        return GitLabMlMlflowListRegisteredModelsBuilder.builder()
                .registeredModels(List.of(ProjectsCatalogFixtures.mlMlflowRegisteredModel()))
                .nextPageToken("next_page_token")
                .build();
    }

    public static GitLabMlMlflowMetric mlMlflowMetric() {
        return GitLabMlMlflowMetricBuilder.builder()
                .key("key")
                .value(1.5)
                .timestamp(1)
                .step(1)
                .build();
    }

    public static GitLabMlMlflowModelVersion mlMlflowModelVersion() {
        return GitLabMlMlflowModelVersionBuilder.builder()
                .name("name")
                .version("version")
                .creationTimestamp(1)
                .lastUpdatedTimestamp(1)
                .userId("user_id")
                .currentStage("development")
                .description("description")
                .source("source")
                .runId("run_id")
                .status("READY")
                .statusMessage("status_message")
                .tags(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()))
                .runLink("run_link")
                .aliases(List.of("aliases"))
                .build();
    }

    public static GitLabMlMlflowNewExperiment mlMlflowNewExperiment() {
        return GitLabMlMlflowNewExperimentBuilder.builder().experimentId("1").build();
    }

    public static GitLabMlMlflowRegisteredModel mlMlflowRegisteredModel() {
        return GitLabMlMlflowRegisteredModelBuilder.builder()
                .name("name")
                .creationTimestamp(1)
                .lastUpdatedTimestamp(1)
                .description("description")
                .userId("user_id")
                .tags(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()))
                .latestVersions(List.of(ProjectsCatalogFixtures.mlMlflowModelVersion()))
                .build();
    }

    public static GitLabMlMlflowRun mlMlflowRun() {
        return GitLabMlMlflowRunBuilder.builder()
                .info(ProjectsCatalogFixtures.mlMlflowRunInfo())
                .data(ProjectsCatalogFixtures.mlMlflowRunData())
                .build();
    }

    public static GitLabMlMlflowRunData mlMlflowRunData() {
        return GitLabMlMlflowRunDataBuilder.builder()
                .metrics(List.of(ProjectsCatalogFixtures.mlMlflowMetric()))
                .params(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()))
                .tags(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()))
                .build();
    }

    public static GitLabMlMlflowRunInfo mlMlflowRunInfo() {
        return GitLabMlMlflowRunInfoBuilder.builder()
                .runId("run_id")
                .runUuid("run_uuid")
                .experimentId("experiment_id")
                .startTime(1)
                .endTime(1)
                .runName("run_name")
                .status("FINISHED")
                .artifactUri("artifact_uri")
                .lifecycleStage("active")
                .userId("user_id")
                .build();
    }

    public static GitLabMlMlflowUpdateRun mlMlflowUpdateRun() {
        return GitLabMlMlflowUpdateRunBuilder.builder()
                .runInfo(ProjectsCatalogFixtures.mlMlflowRunInfo())
                .build();
    }

    public static GitLabProjectApprovalRule projectApprovalRule() {
        return GitLabProjectApprovalRuleBuilder.builder()
                .id(1L)
                .name("QA")
                .ruleType("regular")
                .eligibleApprovers(List.of(CommonCatalogFixtures.userBasic()))
                .approvalsRequired(1)
                .users(List.of(CommonCatalogFixtures.userBasic()))
                .groups(List.of(CommonCatalogFixtures.group()))
                .containsHiddenGroups(true)
                .reportType("report_type")
                .protectedBranches(List.of(CommonCatalogFixtures.protectedBranch()))
                .appliesToAllProtectedBranches(true)
                .coverageMinimumThreshold(1.5)
                .build();
    }

    public static GitLabProjectApprovalSettingRule projectApprovalSettingRule() {
        return GitLabProjectApprovalSettingRuleBuilder.builder()
                .id(1L)
                .name("QA")
                .ruleType("regular")
                .approvalsRequired(1)
                .users(List.of(CommonCatalogFixtures.userBasic()))
                .groups(List.of(CommonCatalogFixtures.group()))
                .containsHiddenGroups(true)
                .reportType("report_type")
                .protectedBranches(List.of(CommonCatalogFixtures.protectedBranch()))
                .appliesToAllProtectedBranches(true)
                .coverageMinimumThreshold(1.5)
                .approvers(List.of(CommonCatalogFixtures.userBasic()))
                .scanners(List.of("scanners"))
                .vulnerabilitiesAllowed(1)
                .severityLevels(List.of("severity_levels"))
                .vulnerabilityStates(List.of("vulnerability_states"))
                .build();
    }

    public static GitLabProjectApprovalSettings projectApprovalSettings() {
        return GitLabProjectApprovalSettingsBuilder.builder()
                .rules(List.of(ProjectsCatalogFixtures.projectApprovalSettingRule()))
                .fallbackApprovalsRequired(1)
                .build();
    }

    public static GitLabProjectGroupLink projectGroupLink() {
        return GitLabProjectGroupLinkBuilder.builder()
                .id(1L)
                .projectId(1L)
                .groupId(1L)
                .groupAccess(1)
                .expiresAt(LocalDate.parse("2026-01-01"))
                .memberRoleId(1L)
                .build();
    }

    public static GitLabProjectMlflowRegisteredModelLatestVersionsPayload
            projectMlflowRegisteredModelLatestVersionsPayload() {
        return GitLabProjectMlflowRegisteredModelLatestVersionsPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectProjectsCreateAiAgentAuditEventEvent projectProjectsCreateAiAgentAuditEventEvent() {
        return GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder()
                .eventName("event_name")
                .cloudEventId("123e4567-e89b-12d3-a456-426614174000")
                .occurredAt(Instant.parse("2026-01-01T00:00:00Z"))
                .details(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectProjectsCreateAiAgentAuditEventPayload projectProjectsCreateAiAgentAuditEventPayload() {
        return GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder.builder()
                .sessionId(1L)
                .events(List.of(ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent()))
                .build();
    }

    public static GitLabProjectProjectsCreateAiAgentIdentityPayload projectProjectsCreateAiAgentIdentityPayload() {
        return GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder.builder()
                .agentType(GitLabProjectProjectsCreateAiAgentIdentityAgentType.CLAUDE_CODE)
                .machineFingerprint("machine_fingerprint")
                .build();
    }

    public static GitLabProjectProjectsCreateAiAgentSessionPayload projectProjectsCreateAiAgentSessionPayload() {
        return GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder()
                .agentType(GitLabProjectProjectsCreateAiAgentSessionAgentType.CLAUDE_CODE)
                .agentIdentityId(1L)
                .syncType(GitLabProjectProjectsCreateAiAgentSessionSyncType.HOOK)
                .goal("goal")
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .idempotencyKey("idempotency_key")
                .workflowDefinition("workflow_definition")
                .glabVersion("glab_version")
                .agentVersion("agent_version")
                .build();
    }

    public static GitLabProjectProjectsCreateApprovalRulePayload projectProjectsCreateApprovalRulePayload() {
        return GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .ruleType("regular")
                .users(List.of(1))
                .userIds(List.of(1L))
                .groups(List.of(1))
                .groupIds(List.of(1L))
                .usernames(List.of("usernames"))
                .protectedBranchIds(List.of(1L))
                .appliesToAllProtectedBranches(true)
                .reportType(GitLabProjectProjectsCreateApprovalRuleReportType.CODE_COVERAGE)
                .coverageMinimumThreshold(1.5)
                .vulnerabilitiesAllowed(1)
                .scanners(List.of("scanners"))
                .severityLevels(List.of("severity_levels"))
                .vulnerabilityStates(List.of("vulnerability_states"))
                .build();
    }

    public static GitLabProjectProjectsCreateApprovalSettingsRulePayload
            projectProjectsCreateApprovalSettingsRulePayload() {
        return GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .ruleType("regular")
                .users(List.of(1))
                .userIds(List.of(1L))
                .groups(List.of(1))
                .groupIds(List.of(1L))
                .usernames(List.of("usernames"))
                .protectedBranchIds(List.of(1L))
                .appliesToAllProtectedBranches(true)
                .reportType(GitLabProjectProjectsCreateApprovalSettingsRuleReportType.CODE_COVERAGE)
                .coverageMinimumThreshold(1.5)
                .vulnerabilitiesAllowed(1)
                .scanners(List.of("scanners"))
                .severityLevels(List.of("severity_levels"))
                .vulnerabilityStates(List.of("vulnerability_states"))
                .build();
    }

    public static GitLabProjectProjectsCreateDependencyListExportPayload
            projectProjectsCreateDependencyListExportPayload() {
        return GitLabProjectProjectsCreateDependencyListExportPayloadBuilder.builder()
                .sendEmail(true)
                .exportType(GitLabProjectProjectsCreateDependencyListExportType.DEPENDENCY_LIST)
                .build();
    }

    public static GitLabProjectProjectsCreateManagedLicensePayload projectProjectsCreateManagedLicensePayload() {
        return GitLabProjectProjectsCreateManagedLicensePayloadBuilder.builder()
                .name("MIT")
                .approvalStatus(GitLabProjectProjectsCreateManagedLicenseApprovalStatus.ALLOWED)
                .build();
    }

    public static GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload
            projectProjectsCreateMlMlflowApiMlflowExperimentPayload() {
        return GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder.builder()
                .name("name")
                .tags(List.of(Map.of("key", "value")))
                .artifactLocation("artifact_location")
                .build();
    }

    public static GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload
            projectProjectsCreateMlMlflowApiMlflowModelVersionPayload() {
        return GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder()
                .name("name")
                .description("description")
                .tags(List.of(Map.of("key", "value")))
                .runId("run_id")
                .build();
    }

    public static GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload
            projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload() {
        return GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder()
                .name("name")
                .description("description")
                .tags(List.of(Map.of("key", "value")))
                .build();
    }

    public static GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload
            projectProjectsCreateMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder()
                .experimentId(1L)
                .startTime(1)
                .userId("user_id")
                .tags(List.of(Map.of("key", "value")))
                .runName("run_name")
                .build();
    }

    public static GitLabProjectProjectsCreateRepositoryStorageMovePayload
            projectProjectsCreateRepositoryStorageMovePayload() {
        return GitLabProjectProjectsCreateRepositoryStorageMovePayloadBuilder.builder()
                .destinationStorageName("destination_storage_name")
                .build();
    }

    public static GitLabProjectProjectsCreateSecurityScansSastPayload projectProjectsCreateSecurityScansSastPayload() {
        return GitLabProjectProjectsCreateSecurityScansSastPayloadBuilder.builder()
                .filePath("file_path")
                .content("content")
                .build();
    }

    public static GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload
            projectProjectsDeleteMlMlflowApiMlflowExperimentPayload() {
        return GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayloadBuilder.builder()
                .experimentId("experiment_id")
                .build();
    }

    public static GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload
            projectProjectsDeleteMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayloadBuilder.builder()
                .runId("run_id")
                .build();
    }

    public static GitLabProjectProjectsHousekeepingPayload projectProjectsHousekeepingPayload() {
        return GitLabProjectProjectsHousekeepingPayloadBuilder.builder()
                .task(GitLabProjectProjectsHousekeepingTask.EAGER)
                .build();
    }

    public static GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric
            projectProjectsLogBatchMlMlflowApiMlflowRunMetric() {
        return GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder.builder()
                .key("key")
                .value(1.5)
                .timestamp(1)
                .step(1)
                .build();
    }

    public static GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam
            projectProjectsLogBatchMlMlflowApiMlflowRunParam() {
        return GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamBuilder.builder()
                .key("key")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload
            projectProjectsLogBatchMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder()
                .runId("run_id")
                .metrics(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric()))
                .params(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam()))
                .tags(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag()))
                .build();
    }

    public static GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag
            projectProjectsLogBatchMlMlflowApiMlflowRunTag() {
        return GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagBuilder.builder()
                .key("key")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload
            projectProjectsLogMetricMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder()
                .runId("run_id")
                .key("key")
                .value(1.5)
                .timestamp(1)
                .step(1)
                .build();
    }

    public static GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload
            projectProjectsLogParameterMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder.builder()
                .runId("run_id")
                .key("key")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectsPipelineRefTriggerPayload projectProjectsPipelineRefTriggerPayload() {
        return GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder()
                .token("6d056f63e50fe6f8c5f8f4aa10edb7")
                .variables(Map.of("key", "value"))
                .inputs(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectProjectsPipelineTriggerPayload projectProjectsPipelineTriggerPayload() {
        return GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder()
                .token("6d056f63e50fe6f8c5f8f4aa10edb7")
                .variables(Map.of("key", "value"))
                .inputs(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectProjectsPublishCatalogPayload projectProjectsPublishCatalogPayload() {
        return GitLabProjectProjectsPublishCatalogPayloadBuilder.builder()
                .metadata(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload
            projectProjectsSearchMlMlflowApiMlflowExperimentPayload() {
        return GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder()
                .maxResults(1)
                .orderBy(List.of("text"))
                .pageToken("page_token")
                .filter("filter")
                .build();
    }

    public static GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload
            projectProjectsSearchMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder()
                .experimentIds(List.of("experiment_ids"))
                .maxResults(1)
                .orderBy(List.of("text"))
                .pageToken("page_token")
                .build();
    }

    public static GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload
            projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload() {
        return GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder.builder()
                .experimentId("experiment_id")
                .key("key")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload
            projectProjectsSetTagMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder.builder()
                .runId("run_id")
                .key("key")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectsSharePayload projectProjectsSharePayload() {
        return GitLabProjectProjectsSharePayloadBuilder.builder()
                .groupId(1L)
                .groupAccess(GitLabProjectProjectsShareGroupAccess.N_10)
                .expiresAt(LocalDate.parse("2026-01-01"))
                .memberRoleId(1L)
                .build();
    }

    public static GitLabProjectProjectsStatusComplianceExternalControlPayload
            projectProjectsStatusComplianceExternalControlPayload() {
        return GitLabProjectProjectsStatusComplianceExternalControlPayloadBuilder.builder()
                .status(GitLabProjectProjectsStatusComplianceExternalControlStatus.PASS)
                .build();
    }

    public static GitLabProjectProjectsTransferPayload projectProjectsTransferPayload() {
        return GitLabProjectProjectsTransferPayloadBuilder.builder()
                .namespace("gitlab")
                .build();
    }

    public static GitLabProjectProjectsUpdateAiAgentSessionPayload projectProjectsUpdateAiAgentSessionPayload() {
        return GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder.builder()
                .status(GitLabProjectProjectsUpdateAiAgentSessionStatus.COMPLETED)
                .jsonlSha256("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .build();
    }

    public static GitLabProjectProjectsUpdateApprovalRulePayload projectProjectsUpdateApprovalRulePayload() {
        return GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .users(List.of(1))
                .userIds(List.of(1L))
                .groups(List.of(1))
                .groupIds(List.of(1L))
                .usernames(List.of("usernames"))
                .protectedBranchIds(List.of(1L))
                .appliesToAllProtectedBranches(true)
                .removeHiddenGroups(true)
                .coverageMinimumThreshold(1.5)
                .vulnerabilitiesAllowed(1)
                .scanners(List.of("scanners"))
                .severityLevels(List.of("severity_levels"))
                .vulnerabilityStates(List.of("vulnerability_states"))
                .build();
    }

    public static GitLabProjectProjectsUpdateApprovalSettingsRulePayload
            projectProjectsUpdateApprovalSettingsRulePayload() {
        return GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .users(List.of(1))
                .userIds(List.of(1L))
                .groups(List.of(1))
                .groupIds(List.of(1L))
                .usernames(List.of("usernames"))
                .protectedBranchIds(List.of(1L))
                .appliesToAllProtectedBranches(true)
                .removeHiddenGroups(true)
                .coverageMinimumThreshold(1.5)
                .vulnerabilitiesAllowed(1)
                .scanners(List.of("scanners"))
                .severityLevels(List.of("severity_levels"))
                .vulnerabilityStates(List.of("vulnerability_states"))
                .build();
    }

    public static GitLabProjectProjectsUpdateManagedLicensePayload projectProjectsUpdateManagedLicensePayload() {
        return GitLabProjectProjectsUpdateManagedLicensePayloadBuilder.builder()
                .name("MIT")
                .approvalStatus(GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.ALLOWED)
                .build();
    }

    public static GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload
            projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload() {
        return GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadBuilder.builder()
                .name("name")
                .description("description")
                .build();
    }

    public static GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload
            projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload() {
        return GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder()
                .name("name")
                .description("description")
                .build();
    }

    public static GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload
            projectProjectsUpdateMlMlflowApiMlflowRunPayload() {
        return GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder.builder()
                .runId("run_id")
                .status(GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.RUNNING)
                .endTime(1)
                .build();
    }

    public static GitLabProjectRepositoryStorage projectRepositoryStorage() {
        return GitLabProjectRepositoryStorageBuilder.builder()
                .diskPath("@hashed/6b/86/6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b")
                .projectId(1L)
                .repositoryStorage("default")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectWithAccess projectWithAccess() {
        return GitLabProjectWithAccessBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .defaultBranch("main")
                .tagList(List.of("tag"))
                .topics(List.of("topic"))
                .sshUrlToRepo("git@gitlab.example.com:gitlab/gitlab.git")
                .httpUrlToRepo("https://gitlab.example.com/gitlab/gitlab.git")
                .webUrl("https://gitlab.example.com/gitlab/gitlab")
                .readmeUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md")
                .forksCount(1)
                .licenseUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE")
                .license(CommonCatalogFixtures.licenseBasic())
                .avatarUrl("http://example.com/uploads/project/avatar/3/uploads/avatar.png")
                .starCount(1)
                .lastActivityAt(Instant.parse("2026-01-01T00:00:00Z"))
                .visibility("public")
                .namespace(CommonCatalogFixtures.namespaceBasic())
                .customAttributes(CommonCatalogFixtures.customAttribute())
                .repositoryStorage("default")
                .forkedFromProject(CommonCatalogFixtures.basicProjectDetails())
                .containerRegistryImagePrefix("registry.gitlab.example.com/gitlab/gitlab-client")
                .links(ProjectsCatalogFixtures.projectWithAccessLinks())
                .markedForDeletionAt(Instant.parse("2026-01-01T00:00:00Z"))
                .markedForDeletionOn(Instant.parse("2026-01-01T00:00:00Z"))
                .packagesEnabled(true)
                .emptyRepo(true)
                .archived(true)
                .owner(CommonCatalogFixtures.userBasic())
                .resolveOutdatedDiffDiscussions(true)
                .containerExpirationPolicy(CommonCatalogFixtures.containerExpirationPolicy())
                .repositoryObjectFormat("sha1")
                .issuesEnabled(true)
                .mergeRequestsEnabled(true)
                .wikiEnabled(true)
                .jobsEnabled(true)
                .snippetsEnabled(true)
                .containerRegistryEnabled(true)
                .serviceDeskEnabled(true)
                .serviceDeskAddress("address@example.com")
                .canCreateMergeRequestIn(true)
                .issuesAccessLevel("enabled")
                .repositoryAccessLevel("enabled")
                .mergeRequestsAccessLevel("enabled")
                .forkingAccessLevel("enabled")
                .wikiAccessLevel("enabled")
                .buildsAccessLevel("enabled")
                .snippetsAccessLevel("enabled")
                .pagesAccessLevel("enabled")
                .analyticsAccessLevel("enabled")
                .containerRegistryAccessLevel("enabled")
                .securityAndComplianceAccessLevel("enabled")
                .releasesAccessLevel("enabled")
                .environmentsAccessLevel("enabled")
                .featureFlagsAccessLevel("enabled")
                .infrastructureAccessLevel("enabled")
                .monitorAccessLevel("enabled")
                .modelExperimentsAccessLevel("enabled")
                .modelRegistryAccessLevel("enabled")
                .packageRegistryAccessLevel("enabled")
                .emailsDisabled(true)
                .emailsEnabled(true)
                .showDiffPreviewInEmail(true)
                .sharedRunnersEnabled(true)
                .lfsEnabled(true)
                .creatorId(1L)
                .mrDefaultTargetSelf(true)
                .importUrl("https://gitlab.com/gitlab/gitlab.git")
                .importType("git")
                .importStatus("none")
                .importError("Import error")
                .openIssuesCount(1)
                .descriptionHtml("description_html")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .ciDefaultGitDepth(1)
                .ciDeletePipelinesInSeconds(1)
                .ciForwardDeploymentEnabled(true)
                .ciForwardDeploymentRollbackAllowed(true)
                .ciJobTokenScopeEnabled(true)
                .ciSeparatedCaches(true)
                .ciAllowForkPipelinesToRunInParentProject(true)
                .ciIdTokenSubClaimComponents(List.of("ci_id_token_sub_claim_components"))
                .buildGitStrategy("fetch")
                .keepLatestArtifact(true)
                .restrictUserDefinedVariables(true)
                .ciPipelineVariablesMinimumOverrideRole("ci_pipeline_variables_minimum_override_role")
                .runnerTokenExpirationInterval(1)
                .groupRunnersEnabled(true)
                .resourceGroupDefaultProcessMode("unordered")
                .autoCancelPendingPipelines("enabled")
                .buildTimeout(1)
                .autoDevopsEnabled(true)
                .autoDevopsDeployStrategy("continuous")
                .ciPushRepositoryForJobTokenAllowed(true)
                .protectMergeRequestPipelines(true)
                .ciDisplayPipelineVariables(true)
                .ciSkipBranchPipelinesForMrs(true)
                .runnersToken("b8547b1dc37721d05889db52fa2f02")
                .ciConfigPath("")
                .publicJobs(true)
                .sharedWithGroups(List.of(Map.of("key", "value")))
                .onlyAllowMergeIfPipelineSucceeds(true)
                .allowMergeOnSkippedPipeline(true)
                .requestAccessEnabled(true)
                .onlyAllowMergeIfAllDiscussionsAreResolved(true)
                .removeSourceBranchAfterMerge(true)
                .printingMergeRequestLinkEnabled(true)
                .mergeMethod("merge")
                .squashOption("default_off")
                .automaticRebaseEnabled(true)
                .enforceAuthChecksOnUploads(true)
                .suggestionCommitMessage("Suggestion message")
                .mergeCommitTemplate("%(title)")
                .squashCommitTemplate("%(source_branch)")
                .mrDefaultTitleTemplate("%(source_branch)")
                .issueBranchTemplate("%(title)")
                .statistics(CommonCatalogFixtures.projectStatistics())
                .warnAboutPotentiallyUnwantedCharacters(true)
                .autocloseReferencedIssues(true)
                .maxArtifactsSize(1L)
                .approvalsBeforeMerge("approvals_before_merge")
                .mirror("mirror")
                .mirrorUserId("mirror_user_id")
                .mirrorTriggerBuilds("mirror_trigger_builds")
                .onlyMirrorProtectedBranches("only_mirror_protected_branches")
                .mirrorOverwritesDivergedBranches("mirror_overwrites_diverged_branches")
                .externalAuthorizationClassificationLabel("external_authorization_classification_label")
                .requirementsEnabled("requirements_enabled")
                .requirementsAccessLevel("requirements_access_level")
                .securityAndComplianceEnabled("security_and_compliance_enabled")
                .secretPushProtectionEnabled(true)
                .preReceiveSecretDetectionEnabled(true)
                .complianceFrameworks("compliance_frameworks")
                .issuesTemplate("issues_template")
                .mergeRequestsTemplate("merge_requests_template")
                .ciRestrictPipelineCancellationRole("ci_restrict_pipeline_cancellation_role")
                .mergePipelinesEnabled("merge_pipelines_enabled")
                .mergeTrainsEnabled("merge_trains_enabled")
                .mergeTrainsSkipTrainAllowed("merge_trains_skip_train_allowed")
                .mergeTrainEnforcement("merge_train_enforcement")
                .maxPipelinesPerMergeTrain("max_pipelines_per_merge_train")
                .onlyAllowMergeIfAllStatusChecksPassed("only_allow_merge_if_all_status_checks_passed")
                .allowPipelineTriggerApproveDeployment(true)
                .preventMergeWithoutJiraIssue("prevent_merge_without_jira_issue")
                .autoDuoCodeReviewEnabled("auto_duo_code_review_enabled")
                .duoCodeReviewDecisionsEnabled("duo_code_review_decisions_enabled")
                .duoCodeReviewDepthAllowed(true)
                .duoCodeReviewDefaultDepth("standard")
                .reviewerAssignmentStrategy("code_owners")
                .duoRemoteFlowsEnabled("duo_remote_flows_enabled")
                .duoFoundationalFlowsEnabled("duo_foundational_flows_enabled")
                .duoScheduledAutomationsEnabled("duo_scheduled_automations_enabled")
                .duoSastFpDetectionEnabled("duo_sast_fp_detection_enabled")
                .duoSecretDetectionFpEnabled("duo_secret_detection_fp_enabled")
                .duoDependencyBumpBreakingChangesEnabled("duo_dependency_bump_breaking_changes_enabled")
                .duoSastVrWorkflowEnabled("duo_sast_vr_workflow_enabled")
                .webBasedCommitSigningEnabled("web_based_commit_signing_enabled")
                .sppRepositoryPipelineAccess(true)
                .securityPolicyPipelineMustSucceed(true)
                .mergeRequestTitleRegex("/Title of merge request/")
                .mergeRequestTitleRegexDescription("This requires the title to include a Jira label")
                .permissions(ProjectsCatalogFixtures.projectWithAccessPermissions())
                .build();
    }

    public static GitLabProjectWithAccessAndCatalog projectWithAccessAndCatalog() {
        return GitLabProjectWithAccessAndCatalogBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .defaultBranch("main")
                .tagList(List.of("tag"))
                .topics(List.of("topic"))
                .sshUrlToRepo("git@gitlab.example.com:gitlab/gitlab.git")
                .httpUrlToRepo("https://gitlab.example.com/gitlab/gitlab.git")
                .webUrl("https://gitlab.example.com/gitlab/gitlab")
                .readmeUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md")
                .forksCount(1)
                .licenseUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE")
                .license(CommonCatalogFixtures.licenseBasic())
                .avatarUrl("http://example.com/uploads/project/avatar/3/uploads/avatar.png")
                .starCount(1)
                .lastActivityAt(Instant.parse("2026-01-01T00:00:00Z"))
                .visibility("public")
                .namespace(CommonCatalogFixtures.namespaceBasic())
                .customAttributes(CommonCatalogFixtures.customAttribute())
                .repositoryStorage("default")
                .forkedFromProject(CommonCatalogFixtures.basicProjectDetails())
                .containerRegistryImagePrefix("registry.gitlab.example.com/gitlab/gitlab-client")
                .links(ProjectsCatalogFixtures.projectWithAccessAndCatalogLinks())
                .markedForDeletionAt(Instant.parse("2026-01-01T00:00:00Z"))
                .markedForDeletionOn(Instant.parse("2026-01-01T00:00:00Z"))
                .packagesEnabled(true)
                .emptyRepo(true)
                .archived(true)
                .owner(CommonCatalogFixtures.userBasic())
                .resolveOutdatedDiffDiscussions(true)
                .containerExpirationPolicy(CommonCatalogFixtures.containerExpirationPolicy())
                .repositoryObjectFormat("sha1")
                .issuesEnabled(true)
                .mergeRequestsEnabled(true)
                .wikiEnabled(true)
                .jobsEnabled(true)
                .snippetsEnabled(true)
                .containerRegistryEnabled(true)
                .serviceDeskEnabled(true)
                .serviceDeskAddress("address@example.com")
                .canCreateMergeRequestIn(true)
                .issuesAccessLevel("enabled")
                .repositoryAccessLevel("enabled")
                .mergeRequestsAccessLevel("enabled")
                .forkingAccessLevel("enabled")
                .wikiAccessLevel("enabled")
                .buildsAccessLevel("enabled")
                .snippetsAccessLevel("enabled")
                .pagesAccessLevel("enabled")
                .analyticsAccessLevel("enabled")
                .containerRegistryAccessLevel("enabled")
                .securityAndComplianceAccessLevel("enabled")
                .releasesAccessLevel("enabled")
                .environmentsAccessLevel("enabled")
                .featureFlagsAccessLevel("enabled")
                .infrastructureAccessLevel("enabled")
                .monitorAccessLevel("enabled")
                .modelExperimentsAccessLevel("enabled")
                .modelRegistryAccessLevel("enabled")
                .packageRegistryAccessLevel("enabled")
                .emailsDisabled(true)
                .emailsEnabled(true)
                .showDiffPreviewInEmail(true)
                .sharedRunnersEnabled(true)
                .lfsEnabled(true)
                .creatorId(1L)
                .mrDefaultTargetSelf(true)
                .importUrl("https://gitlab.com/gitlab/gitlab.git")
                .importType("git")
                .importStatus("none")
                .importError("Import error")
                .openIssuesCount(1)
                .descriptionHtml("description_html")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .ciDefaultGitDepth(1)
                .ciDeletePipelinesInSeconds(1)
                .ciForwardDeploymentEnabled(true)
                .ciForwardDeploymentRollbackAllowed(true)
                .ciJobTokenScopeEnabled(true)
                .ciSeparatedCaches(true)
                .ciAllowForkPipelinesToRunInParentProject(true)
                .ciIdTokenSubClaimComponents(List.of("ci_id_token_sub_claim_components"))
                .buildGitStrategy("fetch")
                .keepLatestArtifact(true)
                .restrictUserDefinedVariables(true)
                .ciPipelineVariablesMinimumOverrideRole("ci_pipeline_variables_minimum_override_role")
                .runnerTokenExpirationInterval(1)
                .groupRunnersEnabled(true)
                .resourceGroupDefaultProcessMode("unordered")
                .autoCancelPendingPipelines("enabled")
                .buildTimeout(1)
                .autoDevopsEnabled(true)
                .autoDevopsDeployStrategy("continuous")
                .ciPushRepositoryForJobTokenAllowed(true)
                .protectMergeRequestPipelines(true)
                .ciDisplayPipelineVariables(true)
                .ciSkipBranchPipelinesForMrs(true)
                .runnersToken("b8547b1dc37721d05889db52fa2f02")
                .ciConfigPath("")
                .publicJobs(true)
                .sharedWithGroups(List.of(Map.of("key", "value")))
                .onlyAllowMergeIfPipelineSucceeds(true)
                .allowMergeOnSkippedPipeline(true)
                .requestAccessEnabled(true)
                .onlyAllowMergeIfAllDiscussionsAreResolved(true)
                .removeSourceBranchAfterMerge(true)
                .printingMergeRequestLinkEnabled(true)
                .mergeMethod("merge")
                .squashOption("default_off")
                .automaticRebaseEnabled(true)
                .enforceAuthChecksOnUploads(true)
                .suggestionCommitMessage("Suggestion message")
                .mergeCommitTemplate("%(title)")
                .squashCommitTemplate("%(source_branch)")
                .mrDefaultTitleTemplate("%(source_branch)")
                .issueBranchTemplate("%(title)")
                .statistics(CommonCatalogFixtures.projectStatistics())
                .warnAboutPotentiallyUnwantedCharacters(true)
                .autocloseReferencedIssues(true)
                .maxArtifactsSize(1L)
                .approvalsBeforeMerge(1)
                .mirror(true)
                .mirrorUserId("mirror_user_id")
                .mirrorTriggerBuilds("mirror_trigger_builds")
                .onlyMirrorProtectedBranches("only_mirror_protected_branches")
                .mirrorOverwritesDivergedBranches("mirror_overwrites_diverged_branches")
                .externalAuthorizationClassificationLabel("external_authorization_classification_label")
                .requirementsEnabled(true)
                .requirementsAccessLevel("requirements_access_level")
                .securityAndComplianceEnabled(true)
                .secretPushProtectionEnabled(true)
                .preReceiveSecretDetectionEnabled(true)
                .complianceFrameworks(List.of("compliance_frameworks"))
                .issuesTemplate("issues_template")
                .mergeRequestsTemplate("merge_requests_template")
                .ciRestrictPipelineCancellationRole("ci_restrict_pipeline_cancellation_role")
                .mergePipelinesEnabled(true)
                .mergeTrainsEnabled(true)
                .mergeTrainsSkipTrainAllowed(true)
                .mergeTrainEnforcement("merge_train_enforcement")
                .maxPipelinesPerMergeTrain("max_pipelines_per_merge_train")
                .onlyAllowMergeIfAllStatusChecksPassed(true)
                .allowPipelineTriggerApproveDeployment(true)
                .preventMergeWithoutJiraIssue(true)
                .autoDuoCodeReviewEnabled(true)
                .duoCodeReviewDecisionsEnabled(true)
                .duoCodeReviewDepthAllowed(true)
                .duoCodeReviewDefaultDepth("standard")
                .reviewerAssignmentStrategy("code_owners")
                .duoRemoteFlowsEnabled(true)
                .duoFoundationalFlowsEnabled(true)
                .duoScheduledAutomationsEnabled("duo_scheduled_automations_enabled")
                .duoSastFpDetectionEnabled(true)
                .duoSecretDetectionFpEnabled(true)
                .duoDependencyBumpBreakingChangesEnabled(true)
                .duoSastVrWorkflowEnabled(true)
                .webBasedCommitSigningEnabled("web_based_commit_signing_enabled")
                .sppRepositoryPipelineAccess(true)
                .securityPolicyPipelineMustSucceed(true)
                .mergeRequestTitleRegex("/Title of merge request/")
                .mergeRequestTitleRegexDescription("This requires the title to include a Jira label")
                .permissions(ProjectsCatalogFixtures.projectWithAccessAndCatalogPermissions())
                .cicdCatalogEnabled(true)
                .build();
    }

    public static GitLabProjectWithAccessAndCatalogLinks projectWithAccessAndCatalogLinks() {
        return GitLabProjectWithAccessAndCatalogLinksBuilder.builder()
                .self("https://gitlab.example.com/api/v4/projects/4")
                .issues("https://gitlab.example.com/api/v4/projects/4/issues")
                .mergeRequests("https://gitlab.example.com/api/v4/projects/4/merge_requests")
                .repoBranches("https://gitlab.example.com/api/v4/projects/4/repository/branches")
                .labels("https://gitlab.example.com/api/v4/projects/4/labels")
                .events("https://gitlab.example.com/api/v4/projects/4/events")
                .members("https://gitlab.example.com/api/v4/projects/4/members")
                .clusterAgents("https://gitlab.example.com/api/v4/projects/4/cluster_agents")
                .build();
    }

    public static GitLabProjectWithAccessAndCatalogPermissions projectWithAccessAndCatalogPermissions() {
        return GitLabProjectWithAccessAndCatalogPermissionsBuilder.builder()
                .projectAccess(CommonCatalogFixtures.projectAccess())
                .groupAccess(CommonCatalogFixtures.groupAccess())
                .build();
    }

    public static GitLabProjectWithAccessLinks projectWithAccessLinks() {
        return GitLabProjectWithAccessLinksBuilder.builder()
                .self("https://gitlab.example.com/api/v4/projects/4")
                .issues("https://gitlab.example.com/api/v4/projects/4/issues")
                .mergeRequests("https://gitlab.example.com/api/v4/projects/4/merge_requests")
                .repoBranches("https://gitlab.example.com/api/v4/projects/4/repository/branches")
                .labels("https://gitlab.example.com/api/v4/projects/4/labels")
                .events("https://gitlab.example.com/api/v4/projects/4/events")
                .members("https://gitlab.example.com/api/v4/projects/4/members")
                .clusterAgents("https://gitlab.example.com/api/v4/projects/4/cluster_agents")
                .build();
    }

    public static GitLabProjectWithAccessPermissions projectWithAccessPermissions() {
        return GitLabProjectWithAccessPermissionsBuilder.builder()
                .projectAccess(CommonCatalogFixtures.projectAccess())
                .groupAccess(CommonCatalogFixtures.groupAccess())
                .build();
    }

    public static GitLabProjectWithCatalog projectWithCatalog() {
        return GitLabProjectWithCatalogBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .defaultBranch("main")
                .tagList(List.of("tag"))
                .topics(List.of("topic"))
                .sshUrlToRepo("git@gitlab.example.com:gitlab/gitlab.git")
                .httpUrlToRepo("https://gitlab.example.com/gitlab/gitlab.git")
                .webUrl("https://gitlab.example.com/gitlab/gitlab")
                .readmeUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md")
                .forksCount(1)
                .licenseUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE")
                .license(CommonCatalogFixtures.licenseBasic())
                .avatarUrl("http://example.com/uploads/project/avatar/3/uploads/avatar.png")
                .starCount(1)
                .lastActivityAt(Instant.parse("2026-01-01T00:00:00Z"))
                .visibility("public")
                .namespace(CommonCatalogFixtures.namespaceBasic())
                .customAttributes(CommonCatalogFixtures.customAttribute())
                .repositoryStorage("default")
                .forkedFromProject(CommonCatalogFixtures.basicProjectDetails())
                .containerRegistryImagePrefix("registry.gitlab.example.com/gitlab/gitlab-client")
                .links(ProjectsCatalogFixtures.projectWithCatalogLinks())
                .markedForDeletionAt(Instant.parse("2026-01-01T00:00:00Z"))
                .markedForDeletionOn(Instant.parse("2026-01-01T00:00:00Z"))
                .packagesEnabled(true)
                .emptyRepo(true)
                .archived(true)
                .owner(CommonCatalogFixtures.userBasic())
                .resolveOutdatedDiffDiscussions(true)
                .containerExpirationPolicy(CommonCatalogFixtures.containerExpirationPolicy())
                .repositoryObjectFormat("sha1")
                .issuesEnabled(true)
                .mergeRequestsEnabled(true)
                .wikiEnabled(true)
                .jobsEnabled(true)
                .snippetsEnabled(true)
                .containerRegistryEnabled(true)
                .serviceDeskEnabled(true)
                .serviceDeskAddress("address@example.com")
                .canCreateMergeRequestIn(true)
                .issuesAccessLevel("enabled")
                .repositoryAccessLevel("enabled")
                .mergeRequestsAccessLevel("enabled")
                .forkingAccessLevel("enabled")
                .wikiAccessLevel("enabled")
                .buildsAccessLevel("enabled")
                .snippetsAccessLevel("enabled")
                .pagesAccessLevel("enabled")
                .analyticsAccessLevel("enabled")
                .containerRegistryAccessLevel("enabled")
                .securityAndComplianceAccessLevel("enabled")
                .releasesAccessLevel("enabled")
                .environmentsAccessLevel("enabled")
                .featureFlagsAccessLevel("enabled")
                .infrastructureAccessLevel("enabled")
                .monitorAccessLevel("enabled")
                .modelExperimentsAccessLevel("enabled")
                .modelRegistryAccessLevel("enabled")
                .packageRegistryAccessLevel("enabled")
                .emailsDisabled(true)
                .emailsEnabled(true)
                .showDiffPreviewInEmail(true)
                .sharedRunnersEnabled(true)
                .lfsEnabled(true)
                .creatorId(1L)
                .mrDefaultTargetSelf(true)
                .importUrl("https://gitlab.com/gitlab/gitlab.git")
                .importType("git")
                .importStatus("none")
                .importError("Import error")
                .openIssuesCount(1)
                .descriptionHtml("description_html")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .ciDefaultGitDepth(1)
                .ciDeletePipelinesInSeconds(1)
                .ciForwardDeploymentEnabled(true)
                .ciForwardDeploymentRollbackAllowed(true)
                .ciJobTokenScopeEnabled(true)
                .ciSeparatedCaches(true)
                .ciAllowForkPipelinesToRunInParentProject(true)
                .ciIdTokenSubClaimComponents(List.of("ci_id_token_sub_claim_components"))
                .buildGitStrategy("fetch")
                .keepLatestArtifact(true)
                .restrictUserDefinedVariables(true)
                .ciPipelineVariablesMinimumOverrideRole("ci_pipeline_variables_minimum_override_role")
                .runnerTokenExpirationInterval(1)
                .groupRunnersEnabled(true)
                .resourceGroupDefaultProcessMode("unordered")
                .autoCancelPendingPipelines("enabled")
                .buildTimeout(1)
                .autoDevopsEnabled(true)
                .autoDevopsDeployStrategy("continuous")
                .ciPushRepositoryForJobTokenAllowed(true)
                .protectMergeRequestPipelines(true)
                .ciDisplayPipelineVariables(true)
                .ciSkipBranchPipelinesForMrs(true)
                .runnersToken("b8547b1dc37721d05889db52fa2f02")
                .ciConfigPath("")
                .publicJobs(true)
                .sharedWithGroups(List.of(Map.of("key", "value")))
                .onlyAllowMergeIfPipelineSucceeds(true)
                .allowMergeOnSkippedPipeline(true)
                .requestAccessEnabled(true)
                .onlyAllowMergeIfAllDiscussionsAreResolved(true)
                .removeSourceBranchAfterMerge(true)
                .printingMergeRequestLinkEnabled(true)
                .mergeMethod("merge")
                .squashOption("default_off")
                .automaticRebaseEnabled(true)
                .enforceAuthChecksOnUploads(true)
                .suggestionCommitMessage("Suggestion message")
                .mergeCommitTemplate("%(title)")
                .squashCommitTemplate("%(source_branch)")
                .mrDefaultTitleTemplate("%(source_branch)")
                .issueBranchTemplate("%(title)")
                .statistics(CommonCatalogFixtures.projectStatistics())
                .warnAboutPotentiallyUnwantedCharacters(true)
                .autocloseReferencedIssues(true)
                .maxArtifactsSize(1L)
                .approvalsBeforeMerge("approvals_before_merge")
                .mirror("mirror")
                .mirrorUserId("mirror_user_id")
                .mirrorTriggerBuilds("mirror_trigger_builds")
                .onlyMirrorProtectedBranches("only_mirror_protected_branches")
                .mirrorOverwritesDivergedBranches("mirror_overwrites_diverged_branches")
                .externalAuthorizationClassificationLabel("external_authorization_classification_label")
                .requirementsEnabled(true)
                .requirementsAccessLevel("requirements_access_level")
                .securityAndComplianceEnabled(true)
                .secretPushProtectionEnabled(true)
                .preReceiveSecretDetectionEnabled(true)
                .complianceFrameworks(List.of("compliance_frameworks"))
                .issuesTemplate("issues_template")
                .mergeRequestsTemplate("merge_requests_template")
                .ciRestrictPipelineCancellationRole("ci_restrict_pipeline_cancellation_role")
                .mergePipelinesEnabled("merge_pipelines_enabled")
                .mergeTrainsEnabled("merge_trains_enabled")
                .mergeTrainsSkipTrainAllowed("merge_trains_skip_train_allowed")
                .mergeTrainEnforcement("merge_train_enforcement")
                .maxPipelinesPerMergeTrain("max_pipelines_per_merge_train")
                .onlyAllowMergeIfAllStatusChecksPassed("only_allow_merge_if_all_status_checks_passed")
                .allowPipelineTriggerApproveDeployment(true)
                .preventMergeWithoutJiraIssue("prevent_merge_without_jira_issue")
                .autoDuoCodeReviewEnabled("auto_duo_code_review_enabled")
                .duoCodeReviewDecisionsEnabled("duo_code_review_decisions_enabled")
                .duoCodeReviewDepthAllowed(true)
                .duoCodeReviewDefaultDepth("standard")
                .reviewerAssignmentStrategy("code_owners")
                .duoRemoteFlowsEnabled("duo_remote_flows_enabled")
                .duoFoundationalFlowsEnabled("duo_foundational_flows_enabled")
                .duoScheduledAutomationsEnabled("duo_scheduled_automations_enabled")
                .duoSastFpDetectionEnabled("duo_sast_fp_detection_enabled")
                .duoSecretDetectionFpEnabled("duo_secret_detection_fp_enabled")
                .duoDependencyBumpBreakingChangesEnabled("duo_dependency_bump_breaking_changes_enabled")
                .duoSastVrWorkflowEnabled("duo_sast_vr_workflow_enabled")
                .webBasedCommitSigningEnabled(true)
                .sppRepositoryPipelineAccess(true)
                .securityPolicyPipelineMustSucceed(true)
                .mergeRequestTitleRegex("/Title of merge request/")
                .mergeRequestTitleRegexDescription("This requires the title to include a Jira label")
                .cicdCatalogEnabled(true)
                .build();
    }

    public static GitLabProjectWithCatalogLinks projectWithCatalogLinks() {
        return GitLabProjectWithCatalogLinksBuilder.builder()
                .self("https://gitlab.example.com/api/v4/projects/4")
                .issues("https://gitlab.example.com/api/v4/projects/4/issues")
                .mergeRequests("https://gitlab.example.com/api/v4/projects/4/merge_requests")
                .repoBranches("https://gitlab.example.com/api/v4/projects/4/repository/branches")
                .labels("https://gitlab.example.com/api/v4/projects/4/labels")
                .events("https://gitlab.example.com/api/v4/projects/4/events")
                .members("https://gitlab.example.com/api/v4/projects/4/members")
                .clusterAgents("https://gitlab.example.com/api/v4/projects/4/cluster_agents")
                .build();
    }

    public static GitLabPublicGroupDetails publicGroupDetails() {
        return GitLabPublicGroupDetailsBuilder.builder()
                .id(1L)
                .webUrl("http://gitlab.example.com/groups/diaspora")
                .name("Diaspora")
                .avatarUrl("http://gitlab.example.com/uploads/group/avatar/1/avatar.png")
                .fullName("Foobar Group")
                .fullPath("foo-bar")
                .build();
    }

    public static GitLabRelationImportTracker relationImportTracker() {
        return GitLabRelationImportTrackerBuilder.builder()
                .id(1L)
                .projectPath("namespace1/project1")
                .relation("issues")
                .status("pending")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }
}
