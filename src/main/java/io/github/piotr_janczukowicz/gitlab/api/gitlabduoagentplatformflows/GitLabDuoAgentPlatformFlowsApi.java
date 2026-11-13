package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of duo agent platform flows. */
public final class GitLabDuoAgentPlatformFlowsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_WORKFLOWID = "workflowId";
    private static final PathTemplate CREATE_WORKFLOWS_AUDIT_EVENT =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/audit_events");
    private static final PathTemplate CREATE_TOOLS_RISK_ASSESSMENT_RESULT =
            PathTemplate.of("/ai/duo_workflows/tools/risk_assessment/results");
    private static final PathTemplate CREATE_CODE_REVIEW_ADD_COMMENT =
            PathTemplate.of("/ai/duo_workflows/code_review/add_comments");
    private static final PathTemplate CALL_CODE_REVIEW_CUSTOM_INSTRUCTIONS =
            PathTemplate.of("/ai/duo_workflows/code_review/custom_instructions");
    private static final PathTemplate CREATE_AGENT_WORKFLOW = PathTemplate.of("/ai/duo_workflows/agent_workflows");
    private static final PathTemplate REVOKE_TOKEN = PathTemplate.of("/ai/duo_workflows/revoke_token");
    private static final PathTemplate GET_WORKFLOW = PathTemplate.of("/ai/duo_workflows/workflows/{id}");
    private static final PathTemplate CALL_WORKFLOWS_CATALOG_ITEMS =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/catalog_items");
    private static final PathTemplate LIST_WORKFLOWS_CHECKPOINTS =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/checkpoints");
    private static final PathTemplate GET_WORKFLOWS_CHECKPOINTS_BY_THREAD_TS =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/checkpoints/by_thread_ts");
    private static final PathTemplate GET_WORKFLOWS_CHECKPOINT =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/checkpoints/{checkpoint_id}");
    private static final PathTemplate CHECKPOINT_WRITES_BATCH_WORKFLOW =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/checkpoint_writes_batch");
    private static final PathTemplate LIST_WORKFLOWS_EVENTS =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/events");
    private static final PathTemplate UPDATE_WORKFLOWS_EVENT =
            PathTemplate.of("/ai/duo_workflows/workflows/{id}/events/{event_id}");
    private static final PathTemplate DIRECT_ACCESS = PathTemplate.of("/ai/duo_workflows/direct_access");
    private static final PathTemplate CALL_LIST_TOOLS = PathTemplate.of("/ai/duo_workflows/list_tools");
    private static final PathTemplate CALL_WS = PathTemplate.of("/ai/duo_workflows/ws");
    private static final PathTemplate CALL_WORKFLOWS_TRACE_JSONL =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/trace.jsonl");
    private static final PathTemplate CREATE_WORKFLOW = PathTemplate.of("/ai/duo_workflows/workflows");
    private static final PathTemplate CALL_WORKFLOWS_AGENT_PRIVILEGES =
            PathTemplate.of("/ai/duo_workflows/workflows/agent_privileges");
    private static final PathTemplate EXECUTE_WORKFLOW =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/execute");
    private static final PathTemplate AUTHORIZE_WORKFLOWS_SESSION_FILE =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/session_files/authorize");
    private static final PathTemplate CREATE_WORKFLOWS_SESSION_FILE =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/session_files");
    private static final PathTemplate CALL_WORKFLOWS_SESSION_FILE =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/session_files/{file_id}");
    private static final PathTemplate CALL_WORKFLOWS_SESSION_FILES_RAW =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/session_files/{file_id}/raw");
    private static final PathTemplate RESUME_WORKFLOW =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/resume");
    private static final PathTemplate RESTART_WORKFLOW =
            PathTemplate.of("/ai/duo_workflows/workflows/{workflow_id}/restart");
    private static final JsonType<List<GitLabAiDuoWorkflowsCheckpoint>> AI_DUO_WORKFLOWS_CHECKPOINT_LIST_TYPE =
            JsonTypes.listOf(GitLabAiDuoWorkflowsCheckpoint.class);
    private static final JsonType<List<GitLabAiDuoWorkflowsEvent>> AI_DUO_WORKFLOWS_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabAiDuoWorkflowsEvent.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDuoAgentPlatformFlowsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create workflows audit event ({@code POST /ai/duo_workflows/workflows/{id}/audit_events}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createWorkflowsAuditEvent(
            final long id, final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_WORKFLOWS_AUDIT_EVENT, id), payload));
    }

    /**
     * Create tools risk assessment result ({@code POST /ai/duo_workflows/tools/risk_assessment/results}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createToolsRiskAssessmentResult(
            final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_TOOLS_RISK_ASSESSMENT_RESULT), payload));
    }

    /**
     * Create code review add comment ({@code POST /ai/duo_workflows/code_review/add_comments}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createCodeReviewAddComment(final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_CODE_REVIEW_ADD_COMMENT), payload));
    }

    /**
     * Call code review custom instructions ({@code GET /ai/duo_workflows/code_review/custom_instructions}).
     *
     * @param projectId the project id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws NullPointerException if {@code mergeRequestIid} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callCodeReviewCustomInstructions(final String projectId, final Long mergeRequestIid)
            throws IOException {
        requireNotBlank(projectId, "projectId");
        requireNonNull(mergeRequestIid, "mergeRequestIid");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text("project_id", projectId)
                .value("merge_request_iid", mergeRequestIid)
                .build();
        caller.send(get(CALL_CODE_REVIEW_CUSTOM_INSTRUCTIONS).withQuery(queryParameters));
    }

    /**
     * Create agent workflow ({@code POST /ai/duo_workflows/agent_workflows}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createAgentWorkflow(final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_AGENT_WORKFLOW), payload));
    }

    /**
     * Revoke token ({@code POST /ai/duo_workflows/revoke_token}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void revokeToken(final GitLabDuoAgentPlatformFlowsRevokeTokenPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(REVOKE_TOKEN), payload));
    }

    /**
     * Get workflow ({@code GET /ai/duo_workflows/workflows/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAiDuoWorkflowsWorkflow> getWorkflow(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET_WORKFLOW, id), GitLabAiDuoWorkflowsWorkflow.class);
    }

    /**
     * Update workflow ({@code PATCH /ai/duo_workflows/workflows/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateWorkflow(final long id, final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(patch(GET_WORKFLOW, id), payload));
    }

    /**
     * Call workflows catalog items ({@code GET /ai/duo_workflows/workflows/{id}/catalog_items}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWorkflowsCatalogItems(final long id) throws IOException {
        caller.send(get(CALL_WORKFLOWS_CATALOG_ITEMS, id));
    }

    /**
     * List workflows checkpoints ({@code GET /ai/duo_workflows/workflows/{id}/checkpoints}).
     *
     * @param id the id
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabAiDuoWorkflowsCheckpoint> listWorkflowsCheckpoints(final long id) throws IOException {
        return listWorkflowsCheckpoints(id, GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter.empty());
    }

    /**
     * List workflows checkpoints ({@code GET /ai/duo_workflows/workflows/{id}/checkpoints}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the items
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabAiDuoWorkflowsCheckpoint> listWorkflowsCheckpoints(
            final long id, final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(LIST_WORKFLOWS_CHECKPOINTS, id).withQuery(queryParameters), AI_DUO_WORKFLOWS_CHECKPOINT_LIST_TYPE);
    }

    /**
     * Create workflows checkpoint ({@code POST /ai/duo_workflows/workflows/{id}/checkpoints}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiDuoWorkflowsBasicCheckpoint createWorkflowsCheckpoint(
            final long id, final GitLabDuoWorkflowCheckpointCreatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_WORKFLOWS_CHECKPOINTS, id), payload), GitLabAiDuoWorkflowsBasicCheckpoint.class);
    }

    /**
     * Get workflows checkpoints by thread ts ({@code GET /ai/duo_workflows/workflows/{id}/checkpoints/by_thread_ts}).
     *
     * @param id the id
     * @param threadTs the thread ts
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code threadTs} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAiDuoWorkflowsCheckpoint> getWorkflowsCheckpointsByThreadTs(
            final long id, final String threadTs) throws IOException {
        return getWorkflowsCheckpointsByThreadTs(
                id, threadTs, GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointsByThreadTsFilter.empty());
    }

    /**
     * Get workflows checkpoints by thread ts ({@code GET /ai/duo_workflows/workflows/{id}/checkpoints/by_thread_ts}).
     *
     * @param id the id
     * @param threadTs the thread ts
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code threadTs} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAiDuoWorkflowsCheckpoint> getWorkflowsCheckpointsByThreadTs(
            final long id,
            final String threadTs,
            final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointsByThreadTsFilter filter)
            throws IOException {
        requireNotBlank(threadTs, "threadTs");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("thread_ts", threadTs)
                .build();
        return caller.fetchOrEmpty(
                get(GET_WORKFLOWS_CHECKPOINTS_BY_THREAD_TS, id).withQuery(queryParameters),
                GitLabAiDuoWorkflowsCheckpoint.class);
    }

    /**
     * Get workflows checkpoint ({@code GET /ai/duo_workflows/workflows/{id}/checkpoints/{checkpoint_id}}).
     *
     * @param id the id
     * @param checkpointId the checkpoint id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAiDuoWorkflowsCheckpoint> getWorkflowsCheckpoint(final long id, final long checkpointId)
            throws IOException {
        return getWorkflowsCheckpoint(
                id, checkpointId, GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter.empty());
    }

    /**
     * Get workflows checkpoint ({@code GET /ai/duo_workflows/workflows/{id}/checkpoints/{checkpoint_id}}).
     *
     * @param id the id
     * @param checkpointId the checkpoint id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAiDuoWorkflowsCheckpoint> getWorkflowsCheckpoint(
            final long id,
            final long checkpointId,
            final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter filter)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET_WORKFLOWS_CHECKPOINT, id, checkpointId).withQuery(queryParameters),
                GitLabAiDuoWorkflowsCheckpoint.class);
    }

    /**
     * Checkpoint writes batch workflow ({@code POST /ai/duo_workflows/workflows/{id}/checkpoint_writes_batch}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void checkpointWritesBatchWorkflow(
            final long id, final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CHECKPOINT_WRITES_BATCH_WORKFLOW, id), payload));
    }

    /**
     * List workflows events ({@code GET /ai/duo_workflows/workflows/{id}/events}).
     *
     * @param id the id
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabAiDuoWorkflowsEvent> listWorkflowsEvents(final long id) throws IOException {
        return caller.fetch(get(LIST_WORKFLOWS_EVENTS, id), AI_DUO_WORKFLOWS_EVENT_LIST_TYPE);
    }

    /**
     * Create workflows event ({@code POST /ai/duo_workflows/workflows/{id}/events}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiDuoWorkflowsEvent createWorkflowsEvent(
            final long id, final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_WORKFLOWS_EVENTS, id), payload), GitLabAiDuoWorkflowsEvent.class);
    }

    /**
     * Update workflows event ({@code PUT /ai/duo_workflows/workflows/{id}/events/{event_id}}).
     *
     * @param id the id
     * @param eventId the event id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiDuoWorkflowsEvent updateWorkflowsEvent(
            final long id, final long eventId, final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_WORKFLOWS_EVENT, id, eventId), payload), GitLabAiDuoWorkflowsEvent.class);
    }

    /**
     * Direct access ({@code POST /ai/duo_workflows/direct_access}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void directAccess(final GitLabDuoAgentPlatformFlowsDirectAccessPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(DIRECT_ACCESS), payload));
    }

    /**
     * Call list tools ({@code GET /ai/duo_workflows/list_tools}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callListTools() throws IOException {
        callListTools(GitLabDuoAgentPlatformFlowsCallListToolsFilter.empty());
    }

    /**
     * Call list tools ({@code GET /ai/duo_workflows/list_tools}).
     *
     * @param filter the optional query parameters
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callListTools(final GitLabDuoAgentPlatformFlowsCallListToolsFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_LIST_TOOLS).withQuery(queryParameters));
    }

    /**
     * Call ws ({@code GET /ai/duo_workflows/ws}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWs() throws IOException {
        callWs(GitLabDuoAgentPlatformFlowsCallWsFilter.empty());
    }

    /**
     * Call ws ({@code GET /ai/duo_workflows/ws}).
     *
     * @param filter the optional query parameters
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWs(final GitLabDuoAgentPlatformFlowsCallWsFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_WS).withQuery(queryParameters));
    }

    /**
     * Call workflows trace jsonl ({@code GET /ai/duo_workflows/workflows/{workflow_id}/trace.jsonl}).
     *
     * @param workflowId the workflow id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWorkflowsTraceJsonl(final long workflowId) throws IOException {
        callWorkflowsTraceJsonl(workflowId, GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter.empty());
    }

    /**
     * Call workflows trace jsonl ({@code GET /ai/duo_workflows/workflows/{workflow_id}/trace.jsonl}).
     *
     * @param workflowId the workflow id
     * @param filter the optional query parameters
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWorkflowsTraceJsonl(
            final long workflowId, final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter filter)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_WORKFLOWS_TRACE_JSONL, workflowId).withQuery(queryParameters));
    }

    /**
     * Create workflow ({@code POST /ai/duo_workflows/workflows}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createWorkflow(final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_WORKFLOW), payload));
    }

    /**
     * Call workflows agent privileges ({@code GET /ai/duo_workflows/workflows/agent_privileges}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWorkflowsAgentPrivileges() throws IOException {
        caller.send(get(CALL_WORKFLOWS_AGENT_PRIVILEGES));
    }

    /**
     * Execute workflow ({@code POST /ai/duo_workflows/workflows/{workflow_id}/execute}).
     *
     * @param workflowId the workflow id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void executeWorkflow(
            final String workflowId, final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload payload)
            throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(EXECUTE_WORKFLOW, workflowId), payload));
    }

    /**
     * Authorize workflows session file ({@code POST
     * /ai/duo_workflows/workflows/{workflow_id}/session_files/authorize}).
     *
     * @param workflowId the workflow id
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeWorkflowsSessionFile(final String workflowId) throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        caller.send(post(AUTHORIZE_WORKFLOWS_SESSION_FILE, workflowId));
    }

    /**
     * Create workflows session file ({@code POST /ai/duo_workflows/workflows/{workflow_id}/session_files}).
     *
     * @param workflowId the workflow id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createWorkflowsSessionFile(final String workflowId, final MultipartFormData form) throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        requireNonNull(form, "form");
        caller.send(caller.multipart(post(CREATE_WORKFLOWS_SESSION_FILE, workflowId), form));
    }

    /**
     * Call workflows session file ({@code GET /ai/duo_workflows/workflows/{workflow_id}/session_files/{file_id}}).
     *
     * @param workflowId the workflow id
     * @param fileId the file id
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWorkflowsSessionFile(final String workflowId, final long fileId) throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        caller.send(get(CALL_WORKFLOWS_SESSION_FILE, workflowId, fileId));
    }

    /**
     * Call workflows session files raw ({@code GET
     * /ai/duo_workflows/workflows/{workflow_id}/session_files/{file_id}/raw}).
     *
     * @param workflowId the workflow id
     * @param fileId the file id
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callWorkflowsSessionFilesRaw(final String workflowId, final long fileId) throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        caller.send(get(CALL_WORKFLOWS_SESSION_FILES_RAW, workflowId, fileId));
    }

    /**
     * Resume workflow ({@code POST /ai/duo_workflows/workflows/{workflow_id}/resume}).
     *
     * @param workflowId the workflow id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void resumeWorkflow(final String workflowId, final GitLabDuoAgentPlatformFlowsResumeWorkflowPayload payload)
            throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(RESUME_WORKFLOW, workflowId), payload));
    }

    /**
     * Restart workflow ({@code POST /ai/duo_workflows/workflows/{workflow_id}/restart}).
     *
     * @param workflowId the workflow id
     * @throws IllegalArgumentException if {@code workflowId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void restartWorkflow(final String workflowId) throws IOException {
        requireNotBlank(workflowId, PARAM_WORKFLOWID);
        caller.send(post(RESTART_WORKFLOW, workflowId));
    }
}
