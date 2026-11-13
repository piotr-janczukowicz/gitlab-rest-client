package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabDuoAgentPlatformFlowsApi api() {
        return new GitLabDuoAgentPlatformFlowsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabDuoAgentPlatformFlowsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void createWorkflowsAuditEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createWorkflowsAuditEvent(
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/1/audit_events");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"events\":");
        });
    }

    @Test
    void createWorkflowsAuditEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWorkflowsAuditEvent(
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createToolsRiskAssessmentResult_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createToolsRiskAssessmentResult(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/tools/risk_assessment/results");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_id\":");
        });
    }

    @Test
    void createToolsRiskAssessmentResult_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createToolsRiskAssessmentResult(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createCodeReviewAddComment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createCodeReviewAddComment(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/code_review/add_comments");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_id\":");
        });
    }

    @Test
    void createCodeReviewAddComment_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createCodeReviewAddComment(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callCodeReviewCustomInstructions_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callCodeReviewCustomInstructions("project_id", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/ai/duo_workflows/code_review/custom_instructions");
            softly.assertThat(request.uri()).hasParameter("project_id", "project_id");
        });
    }

    @Test
    void callCodeReviewCustomInstructions_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callCodeReviewCustomInstructions("project_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createAgentWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createAgentWorkflow(
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/agent_workflows");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_id\":");
        });
    }

    @Test
    void createAgentWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAgentWorkflow(
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void revokeToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().revokeToken(GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/revoke_token");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void revokeToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().revokeToken(
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getWorkflow_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabAiDuoWorkflowsWorkflow.class, "ai-duo-workflows-workflow.json")));

        final Optional<GitLabAiDuoWorkflowsWorkflow> result = api().getWorkflow(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1");
        });
    }

    @Test
    void getWorkflow_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAiDuoWorkflowsWorkflow> result = api().getWorkflow(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateWorkflow(
                        1L, GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/ai/duo_workflows/workflows/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status_event\":");
        });
    }

    @Test
    void updateWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateWorkflow(
                        1L, GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callWorkflowsCatalogItems_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWorkflowsCatalogItems(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1/catalog_items");
    }

    @Test
    void callWorkflowsCatalogItems_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callWorkflowsCatalogItems(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listWorkflowsCheckpoints_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")
                                + "]"));

        final List<GitLabAiDuoWorkflowsCheckpoint> result = api().listWorkflowsCheckpoints(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1/checkpoints");
        });
    }

    @Test
    void createWorkflowsCheckpoint_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiDuoWorkflowsBasicCheckpoint.class, "ai-duo-workflows-basic-checkpoint.json")));

        final GitLabAiDuoWorkflowsBasicCheckpoint result = api().createWorkflowsCheckpoint(
                        1L, GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/1/checkpoints");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"thread_ts\":");
        });
    }

    @Test
    void createWorkflowsCheckpoint_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWorkflowsCheckpoint(
                        1L, GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getWorkflowsCheckpointsByThreadTs_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")));

        final Optional<GitLabAiDuoWorkflowsCheckpoint> result =
                api().getWorkflowsCheckpointsByThreadTs(1L, "thread_ts");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1/checkpoints/by_thread_ts");
            softly.assertThat(request.uri()).hasParameter("thread_ts", "thread_ts");
        });
    }

    @Test
    void getWorkflowsCheckpointsByThreadTs_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAiDuoWorkflowsCheckpoint> result =
                api().getWorkflowsCheckpointsByThreadTs(1L, "thread_ts");

        assertThat(result).isEmpty();
    }

    @Test
    void getWorkflowsCheckpointsByThreadTs_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")));

        api().getWorkflowsCheckpointsByThreadTs(
                        1L,
                        "thread_ts",
                        GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointsByThreadTsFilterBuilder.builder()
                                .acceptCompressed(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("accept_compressed", "true");
    }

    @Test
    void getWorkflowsCheckpoint_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")));

        final Optional<GitLabAiDuoWorkflowsCheckpoint> result = api().getWorkflowsCheckpoint(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1/checkpoints/1");
        });
    }

    @Test
    void getWorkflowsCheckpoint_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAiDuoWorkflowsCheckpoint> result = api().getWorkflowsCheckpoint(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getWorkflowsCheckpoint_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiDuoWorkflowsCheckpoint.class, "ai-duo-workflows-checkpoint.json")));

        api().getWorkflowsCheckpoint(
                        1L,
                        1L,
                        GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                                .acceptCompressed(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("accept_compressed", "true");
    }

    @Test
    void checkpointWritesBatchWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().checkpointWritesBatchWorkflow(
                        1L, GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/1/checkpoint_writes_batch");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"thread_ts\":");
        });
    }

    @Test
    void checkpointWritesBatchWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().checkpointWritesBatchWorkflow(
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listWorkflowsEvents_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabAiDuoWorkflowsEvent.class, "ai-duo-workflows-event.json")
                                + "]"));

        final List<GitLabAiDuoWorkflowsEvent> result = api().listWorkflowsEvents(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1/events");
        });
    }

    @Test
    void createWorkflowsEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabAiDuoWorkflowsEvent.class, "ai-duo-workflows-event.json")));

        final GitLabAiDuoWorkflowsEvent result = api().createWorkflowsEvent(
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsEventPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/1/events");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"event_type\":");
        });
    }

    @Test
    void createWorkflowsEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWorkflowsEvent(
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateWorkflowsEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabAiDuoWorkflowsEvent.class, "ai-duo-workflows-event.json")));

        final GitLabAiDuoWorkflowsEvent result = api().updateWorkflowsEvent(
                        1L,
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowsEventPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/ai/duo_workflows/workflows/1/events/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"event_status\":");
        });
    }

    @Test
    void updateWorkflowsEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateWorkflowsEvent(
                        1L,
                        1L,
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowsEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void directAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().directAccess(GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/direct_access");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"workflow_definition\":");
        });
    }

    @Test
    void directAccess_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().directAccess(
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callListTools_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callListTools();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/ai/duo_workflows/list_tools");
    }

    @Test
    void callListTools_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callListTools());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callListTools_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callListTools(GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                .workflowDefinition("workflow_definition")
                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("workflow_definition", "workflow_definition");
    }

    @Test
    void callWs_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWs();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/ai/duo_workflows/ws");
    }

    @Test
    void callWs_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callWs());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callWs_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWs(GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                .workflowId("workflow_id")
                .environment("environment")
                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("workflow_id", "workflow_id");
    }

    @Test
    void callWorkflowsTraceJsonl_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWorkflowsTraceJsonl(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/1/trace.jsonl");
    }

    @Test
    void callWorkflowsTraceJsonl_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callWorkflowsTraceJsonl(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callWorkflowsTraceJsonl_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWorkflowsTraceJsonl(
                        1L,
                        GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                                .full(true)
                                .thread("thread")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("full", "true");
    }

    @Test
    void createWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createWorkflow(GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/ai/duo_workflows/workflows");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_id\":");
        });
    }

    @Test
    void createWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWorkflow(
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callWorkflowsAgentPrivileges_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWorkflowsAgentPrivileges();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/agent_privileges");
    }

    @Test
    void callWorkflowsAgentPrivileges_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callWorkflowsAgentPrivileges());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void executeWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().executeWorkflow(
                        "workflow_id",
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsExecuteWorkflowPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/workflow_id/execute");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_id\":");
        });
    }

    @Test
    void executeWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().executeWorkflow(
                        "workflow_id",
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsExecuteWorkflowPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeWorkflowsSessionFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeWorkflowsSessionFile("workflow_id");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/workflow_id/session_files/authorize");
    }

    @Test
    void authorizeWorkflowsSessionFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeWorkflowsSessionFile("workflow_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createWorkflowsSessionFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createWorkflowsSessionFile(
                        "workflow_id",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/workflow_id/session_files");
    }

    @Test
    void createWorkflowsSessionFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createWorkflowsSessionFile(
                        "workflow_id",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callWorkflowsSessionFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWorkflowsSessionFile("workflow_id", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1");
    }

    @Test
    void callWorkflowsSessionFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callWorkflowsSessionFile("workflow_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callWorkflowsSessionFilesRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callWorkflowsSessionFilesRaw("workflow_id", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/ai/duo_workflows/workflows/workflow_id/session_files/1/raw");
    }

    @Test
    void callWorkflowsSessionFilesRaw_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callWorkflowsSessionFilesRaw("workflow_id", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void resumeWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().resumeWorkflow(
                        "workflow_id",
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/workflow_id/resume");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"human_approval\":");
        });
    }

    @Test
    void resumeWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resumeWorkflow(
                        "workflow_id",
                        GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void restartWorkflow_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().restartWorkflow("workflow_id");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/ai/duo_workflows/workflows/workflow_id/restart");
    }

    @Test
    void restartWorkflow_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().restartWorkflow("workflow_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
