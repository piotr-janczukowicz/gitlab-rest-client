package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabDuoAgentPlatformFlowsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createWorkflowsAuditEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/1/audit_events", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createWorkflowsAuditEvent(
                            1L,
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/audit_events");
    }

    @Test
    void createWorkflowsAuditEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/1/audit_events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWorkflowsAuditEvent(
                    1L,
                    GitlabduoagentplatformflowsCatalogFixtures
                            .duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/audit_events");
    }

    @Test
    void createToolsRiskAssessmentResult_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/tools/risk_assessment/results", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createToolsRiskAssessmentResult(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/tools/risk_assessment/results");
    }

    @Test
    void createToolsRiskAssessmentResult_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/tools/risk_assessment/results", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createToolsRiskAssessmentResult(
                    GitlabduoagentplatformflowsCatalogFixtures
                            .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/tools/risk_assessment/results");
    }

    @Test
    void createCodeReviewAddComment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/code_review/add_comments", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createCodeReviewAddComment(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/code_review/add_comments");
    }

    @Test
    void createCodeReviewAddComment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/code_review/add_comments", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createCodeReviewAddComment(
                    GitlabduoagentplatformflowsCatalogFixtures
                            .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/code_review/add_comments");
    }

    @Test
    void callCodeReviewCustomInstructions_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/code_review/custom_instructions", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .callCodeReviewCustomInstructions("project_id", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/code_review/custom_instructions");
    }

    @Test
    void callCodeReviewCustomInstructions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/code_review/custom_instructions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callCodeReviewCustomInstructions("project_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/code_review/custom_instructions");
    }

    @Test
    void createAgentWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/agent_workflows", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createAgentWorkflow(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateAgentWorkflowPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/agent_workflows");
    }

    @Test
    void createAgentWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/agent_workflows", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAgentWorkflow(
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/agent_workflows");
    }

    @Test
    void revokeToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/revoke_token", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .revokeToken(GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/revoke_token");
    }

    @Test
    void revokeToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/revoke_token", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.revokeToken(
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/revoke_token");
    }

    @Test
    void getWorkflow_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAiDuoWorkflowsWorkflow.class, "ai-duo-workflows-workflow.json")));

        final Optional<GitLabAiDuoWorkflowsWorkflow> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).getWorkflow(1L);
        }

        assertThat(result).contains(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow());
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1");
    }

    @Test
    void getWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .getWorkflow(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1");
    }

    @Test
    void updateWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PATCH, "/api/v4/ai/duo_workflows/workflows/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .updateWorkflow(
                            1L,
                            GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload());
        }

        HTTP.verifyRequested(PATCH, "/api/v4/ai/duo_workflows/workflows/1");
    }

    @Test
    void updateWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/ai/duo_workflows/workflows/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateWorkflow(
                    1L, GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/ai/duo_workflows/workflows/1");
    }

    @Test
    void callWorkflowsCatalogItems_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/1/catalog_items", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callWorkflowsCatalogItems(1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/catalog_items");
    }

    @Test
    void callWorkflowsCatalogItems_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/1/catalog_items", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callWorkflowsCatalogItems(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/catalog_items");
    }

    @Test
    void listWorkflowsCheckpoints_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/1/checkpoints",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")
                        + "]"));

        final List<GitLabAiDuoWorkflowsCheckpoint> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).listWorkflowsCheckpoints(1L);
        }

        assertThat(result).containsExactly(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint());
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints");
    }

    @Test
    void createWorkflowsCheckpoint_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/ai/duo_workflows/workflows/1/checkpoints",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiDuoWorkflowsBasicCheckpoint.class, "ai-duo-workflows-basic-checkpoint.json")));

        final GitLabAiDuoWorkflowsBasicCheckpoint result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createWorkflowsCheckpoint(
                            1L, GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload());
        }

        assertThat(result).isEqualTo(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint());
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoints");
    }

    @Test
    void createWorkflowsCheckpoint_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoints", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWorkflowsCheckpoint(
                    1L, GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoints");
    }

    @Test
    void getWorkflowsCheckpointsByThreadTs_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/1/checkpoints/by_thread_ts",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")));

        final Optional<GitLabAiDuoWorkflowsCheckpoint> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .getWorkflowsCheckpointsByThreadTs(1L, "thread_ts");
        }

        assertThat(result).contains(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint());
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints/by_thread_ts");
    }

    @Test
    void getWorkflowsCheckpointsByThreadTs_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints/by_thread_ts", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .getWorkflowsCheckpointsByThreadTs(1L, "thread_ts")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints/by_thread_ts");
    }

    @Test
    void getWorkflowsCheckpoint_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/1/checkpoints/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")));

        final Optional<GitLabAiDuoWorkflowsCheckpoint> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).getWorkflowsCheckpoint(1L, 1L);
        }

        assertThat(result).contains(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint());
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints/1");
    }

    @Test
    void getWorkflowsCheckpoint_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .getWorkflowsCheckpoint(1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/checkpoints/1");
    }

    @Test
    void checkpointWritesBatchWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoint_writes_batch", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .checkpointWritesBatchWorkflow(
                            1L,
                            GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoint_writes_batch");
    }

    @Test
    void checkpointWritesBatchWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoint_writes_batch", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.checkpointWritesBatchWorkflow(
                    1L, GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/checkpoint_writes_batch");
    }

    @Test
    void listWorkflowsEvents_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/1/events",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabAiDuoWorkflowsEvent.class, "ai-duo-workflows-event.json") + "]"));

        final List<GitLabAiDuoWorkflowsEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).listWorkflowsEvents(1L);
        }

        assertThat(result).containsExactly(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent());
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/events");
    }

    @Test
    void createWorkflowsEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/ai/duo_workflows/workflows/1/events",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAiDuoWorkflowsEvent.class, "ai-duo-workflows-event.json")));

        final GitLabAiDuoWorkflowsEvent result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createWorkflowsEvent(
                            1L,
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateWorkflowsEventPayload());
        }

        assertThat(result).isEqualTo(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent());
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/events");
    }

    @Test
    void createWorkflowsEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/1/events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWorkflowsEvent(
                    1L, GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/1/events");
    }

    @Test
    void updateWorkflowsEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/ai/duo_workflows/workflows/1/events/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAiDuoWorkflowsEvent.class, "ai-duo-workflows-event.json")));

        final GitLabAiDuoWorkflowsEvent result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .updateWorkflowsEvent(
                            1L,
                            1L,
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsUpdateWorkflowsEventPayload());
        }

        assertThat(result).isEqualTo(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent());
        HTTP.verifyRequested(PUT, "/api/v4/ai/duo_workflows/workflows/1/events/1");
    }

    @Test
    void updateWorkflowsEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/ai/duo_workflows/workflows/1/events/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateWorkflowsEvent(
                    1L,
                    1L,
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowsEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/ai/duo_workflows/workflows/1/events/1");
    }

    @Test
    void directAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/direct_access", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .directAccess(
                            GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/direct_access");
    }

    @Test
    void directAccess_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/direct_access", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.directAccess(
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/direct_access");
    }

    @Test
    void callListTools_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/list_tools", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callListTools();
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/list_tools");
    }

    @Test
    void callListTools_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/list_tools", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callListTools());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/list_tools");
    }

    @Test
    void callWs_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/ws", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callWs();
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/ws");
    }

    @Test
    void callWs_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/ws", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callWs());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/ws");
    }

    @Test
    void callWorkflowsTraceJsonl_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/1/trace.jsonl", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callWorkflowsTraceJsonl(1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/trace.jsonl");
    }

    @Test
    void callWorkflowsTraceJsonl_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/1/trace.jsonl", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callWorkflowsTraceJsonl(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/1/trace.jsonl");
    }

    @Test
    void createWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createWorkflow(
                            GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows");
    }

    @Test
    void createWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWorkflow(
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows");
    }

    @Test
    void callWorkflowsAgentPrivileges_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/agent_privileges", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callWorkflowsAgentPrivileges();
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/agent_privileges");
    }

    @Test
    void callWorkflowsAgentPrivileges_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/ai/duo_workflows/workflows/agent_privileges", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callWorkflowsAgentPrivileges());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/agent_privileges");
    }

    @Test
    void executeWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/execute", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .executeWorkflow(
                            "workflow_id",
                            GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsExecuteWorkflowPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/execute");
    }

    @Test
    void executeWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/execute", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.executeWorkflow(
                    "workflow_id",
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsExecuteWorkflowPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/execute");
    }

    @Test
    void authorizeWorkflowsSessionFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).authorizeWorkflowsSessionFile("workflow_id");
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/authorize");
    }

    @Test
    void authorizeWorkflowsSessionFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeWorkflowsSessionFile("workflow_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/authorize");
    }

    @Test
    void createWorkflowsSessionFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .createWorkflowsSessionFile(
                            "workflow_id",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files");
    }

    @Test
    void createWorkflowsSessionFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createWorkflowsSessionFile(
                    "workflow_id",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files");
    }

    @Test
    void callWorkflowsSessionFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callWorkflowsSessionFile("workflow_id", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1");
    }

    @Test
    void callWorkflowsSessionFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callWorkflowsSessionFile("workflow_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1");
    }

    @Test
    void callWorkflowsSessionFilesRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1/raw",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).callWorkflowsSessionFilesRaw("workflow_id", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1/raw");
    }

    @Test
    void callWorkflowsSessionFilesRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1/raw",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callWorkflowsSessionFilesRaw("workflow_id", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1/raw");
    }

    @Test
    void resumeWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/resume", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client))
                    .resumeWorkflow(
                            "workflow_id",
                            GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/resume");
    }

    @Test
    void resumeWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/resume", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resumeWorkflow(
                    "workflow_id",
                    GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/resume");
    }

    @Test
    void restartWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/restart", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client)).restartWorkflow("workflow_id");
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/restart");
    }

    @Test
    void restartWorkflow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/restart", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoAgentPlatformFlowsApi api = new GitLabDuoAgentPlatformFlowsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.restartWorkflow("workflow_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/duo_workflows/workflows/workflow_id/restart");
    }
}
