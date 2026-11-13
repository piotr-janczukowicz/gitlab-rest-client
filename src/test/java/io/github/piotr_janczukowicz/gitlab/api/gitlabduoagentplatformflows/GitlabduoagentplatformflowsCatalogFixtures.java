package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class GitlabduoagentplatformflowsCatalogFixtures {

    private GitlabduoagentplatformflowsCatalogFixtures() {}

    public static GitLabAiDuoWorkflowsBasicCheckpoint aiDuoWorkflowsBasicCheckpoint() {
        return GitLabAiDuoWorkflowsBasicCheckpointBuilder.builder()
                .id(1L)
                .threadTs("thread_ts")
                .parentTs("parent_ts")
                .checkpointNs("checkpoint_ns")
                .build();
    }

    public static GitLabAiDuoWorkflowsCheckpoint aiDuoWorkflowsCheckpoint() {
        return GitLabAiDuoWorkflowsCheckpointBuilder.builder()
                .id(1L)
                .threadTs("thread_ts")
                .parentTs("parent_ts")
                .checkpointNs("checkpoint_ns")
                .checkpoint(Map.of("key", "value"))
                .compressedCheckpoint("compressed_checkpoint")
                .checkpointWrites(List.of(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite()))
                .currentThread(1)
                .metadata(Map.of("key", "value"))
                .build();
    }

    public static GitLabAiDuoWorkflowsCheckpointWrite aiDuoWorkflowsCheckpointWrite() {
        return GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder()
                .id(1L)
                .threadTs("thread_ts")
                .task("task")
                .idx(1)
                .channel("channel")
                .writeType("write_type")
                .data("data")
                .build();
    }

    public static GitLabAiDuoWorkflowsEvent aiDuoWorkflowsEvent() {
        return GitLabAiDuoWorkflowsEventBuilder.builder()
                .id(1L)
                .correlationId("correlation_id")
                .eventType("event_type")
                .eventStatus("event_status")
                .message("message")
                .build();
    }

    public static GitLabAiDuoWorkflowsWorkflow aiDuoWorkflowsWorkflow() {
        return GitLabAiDuoWorkflowsWorkflowBuilder.builder()
                .id(1L)
                .webUrl("https://gitlab.example.com/group/project/-/automate/agent-sessions/42")
                .projectId(1L)
                .namespaceId(1L)
                .agentPrivileges(List.of(1))
                .agentPrivilegesNames(List.of("agent_privileges_names"))
                .preApprovedAgentPrivileges(List.of(1))
                .preApprovedAgentPrivilegesNames(List.of("pre_approved_agent_privileges_names"))
                .workflowDefinition("workflow_definition")
                .status("status")
                .summary("summary")
                .title("title")
                .allowAgentToRequestUser(true)
                .image("image")
                .environment("environment")
                .aiCatalogItemVersionId(1L)
                .workload(Map.of("key", "value"))
                .mcpEnabled(true)
                .incrementalCheckpointsEnabled(true)
                .gitlabUrl("gitlab_url")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext
            duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext() {
        return GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextBuilder.builder()
                .category("Category")
                .content("Content")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload
            duoAgentPlatformFlowsCreateAgentWorkflowPayload() {
        return GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder()
                .projectId("1")
                .namespaceId("1")
                .aiCatalogItemConsumerId(1L)
                .startWorkflow(true)
                .goal("Fix pipeline for merge request 1 in project 1")
                .workflowDefinition("software_developer")
                .allowAgentToRequestUser(true)
                .image("registry.gitlab.com/gitlab-org/duo-workflow/custom-image:latest")
                .sourceBranch("main")
                .environment(GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment.IDE)
                .aiCatalogItemVersionId(1L)
                .additionalContext(List.of(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext()))
                .issueId(1L)
                .mergeRequestId(1L)
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload
            duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload() {
        return GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder.builder()
                .projectId("project_id")
                .mergeRequestIid(1L)
                .reviewOutput("review_output")
                .workflowId(1L)
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim
            duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim() {
        return GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder()
                .name("name")
                .value("value")
                .evidence("evidence")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload
            duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload() {
        return GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder()
                .projectId("project_id")
                .mergeRequestIid(1L)
                .diffSha("0123456789abcdef0123456789abcdef01234567")
                .workflowId(1L)
                .claims(List.of(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim()))
                .summary("summary")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext
            duoAgentPlatformFlowsCreateWorkflowAdditionalContext() {
        return GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextBuilder.builder()
                .category("Category")
                .content("Content")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateWorkflowPayload duoAgentPlatformFlowsCreateWorkflowPayload() {
        return GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder()
                .projectId("1")
                .namespaceId("1")
                .aiCatalogItemConsumerId(1L)
                .startWorkflow(true)
                .goal("Fix pipeline for merge request 1 in project 1")
                .agentPrivileges(List.of(1))
                .preApprovedAgentPrivileges(List.of(1))
                .workflowDefinition("software_developer")
                .allowAgentToRequestUser(true)
                .image("registry.gitlab.com/gitlab-org/duo-workflow/custom-image:latest")
                .sourceBranch("main")
                .environment(GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.IDE)
                .aiCatalogItemVersionId(1L)
                .additionalContext(List.of(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateWorkflowAdditionalContext()))
                .issueId(1L)
                .mergeRequestId(1L)
                .source(GitLabDuoAgentPlatformFlowsCreateWorkflowSource.MERGE_REQUEST_CODE_CONFLICT)
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent
            duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent() {
        return GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder()
                .id("id")
                .type("type")
                .source("source")
                .time(Instant.parse("2026-01-01T00:00:00Z"))
                .data(Map.of("key", "value"))
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload
            duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload() {
        return GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayloadBuilder.builder()
                .events(List.of(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent()))
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload
            duoAgentPlatformFlowsCreateWorkflowsEventPayload() {
        return GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder.builder()
                .eventType(GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType.PAUSE)
                .message("message")
                .correlationId("123e4567-e89b-12d3-a456-426614174000")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsDirectAccessPayload duoAgentPlatformFlowsDirectAccessPayload() {
        return GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder.builder()
                .workflowDefinition("software_developer")
                .rootNamespaceId("1")
                .projectId("1")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload duoAgentPlatformFlowsExecuteWorkflowPayload() {
        return GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder()
                .projectId("1")
                .namespaceId("1")
                .rootNamespaceId("1")
                .aiCatalogItemVersionId(1L)
                .clientType("browser")
                .userSelectedModelIdentifier("claude_sonnet_4_5")
                .detached(true)
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsResumeWorkflowPayload duoAgentPlatformFlowsResumeWorkflowPayload() {
        return GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder.builder()
                .humanApproval(true)
                .humanMessage("Looks good, please proceed")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsRevokeTokenPayload duoAgentPlatformFlowsRevokeTokenPayload() {
        return GitLabDuoAgentPlatformFlowsRevokeTokenPayloadBuilder.builder()
                .token("token")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload duoAgentPlatformFlowsUpdateWorkflowPayload() {
        return GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder.builder()
                .statusEvent("finish")
                .dropReason("token_rejected")
                .build();
    }

    public static GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload
            duoAgentPlatformFlowsUpdateWorkflowsEventPayload() {
        return GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayloadBuilder.builder()
                .eventStatus(GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.QUEUED)
                .build();
    }

    public static GitLabDuoWorkflowCheckpointCreateChannelBlob duoWorkflowCheckpointCreateChannelBlob() {
        return GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder()
                .channel("channel")
                .version("version")
                .writeType("write_type")
                .stepAction(GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.CONVERSATION)
                .data("data")
                .build();
    }

    public static GitLabDuoWorkflowCheckpointCreatePayload duoWorkflowCheckpointCreatePayload() {
        return GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder()
                .threadTs("thread_ts")
                .parentTs("parent_ts")
                .checkpointNs("checkpoint_ns")
                .checkpoint(Map.of("key", "value"))
                .compressedCheckpoint("compressed_checkpoint")
                .metadata(Map.of("key", "value"))
                .modelMetadataJson("model_metadata_json")
                .flowMetadataJson("flow_metadata_json")
                .currentThread(1)
                .channelKeys(List.of("channel_keys"))
                .channelBlobs(
                        List.of(GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob()))
                .build();
    }

    public static GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite
            duoWorkflowCheckpointWritesBatchCreateCheckpointWrite() {
        return GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder()
                .task("task")
                .idx(1)
                .channel("channel")
                .writeType("write_type")
                .data("data")
                .build();
    }

    public static GitLabDuoWorkflowCheckpointWritesBatchCreatePayload duoWorkflowCheckpointWritesBatchCreatePayload() {
        return GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder.builder()
                .threadTs("thread_ts")
                .checkpointWrites(List.of(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite()))
                .build();
    }
}
