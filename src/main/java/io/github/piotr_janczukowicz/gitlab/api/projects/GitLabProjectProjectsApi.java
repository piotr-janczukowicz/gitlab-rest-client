package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequest;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportStatus;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project projects. */
public final class GitLabProjectProjectsApi extends GitLabResourceApi {
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_FORM = "form";
    private static final String PARAM_ID = "id";
    private static final String PARAM_MANAGEDLICENSEID = "managedLicenseId";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_OUT = "out";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_TARGET = "target";
    private static final String PARAM_VERSION = "version";
    private static final PathTemplate STATUS_COMPLIANCE_EXTERNAL_CONTROL =
            PathTemplate.of("/projects/{id}/compliance_external_controls/{control_id}/status");
    private static final PathTemplate CREATE_SECURITY_SCANS_SAST =
            PathTemplate.of("/projects/{id}/security_scans/sast/{sast_endpoint}");
    private static final PathTemplate LIST_AI_AGENT_SESSIONS = PathTemplate.of("/projects/{id}/ai_agent/sessions");
    private static final PathTemplate UPDATE_AI_AGENT_SESSION =
            PathTemplate.of("/projects/{id}/ai_agent/sessions/{session_id}");
    private static final PathTemplate CREATE_AI_AGENT_IDENTITY = PathTemplate.of("/projects/{id}/ai_agent/identities");
    private static final PathTemplate CREATE_AI_AGENT_AUDIT_EVENT =
            PathTemplate.of("/projects/{id}/ai_agent/audit_events");
    private static final PathTemplate CREATE_DEPENDENCY_LIST_EXPORT =
            PathTemplate.of("/projects/{id}/dependency_list_exports");
    private static final PathTemplate LIST_ANALYTICS_DEPLOYMENT_FREQUENCY =
            PathTemplate.of("/projects/{id}/analytics/deployment_frequency");
    private static final PathTemplate LIST_MANAGED_LICENSES = PathTemplate.of("/projects/{id}/managed_licenses");
    private static final PathTemplate GET_MANAGED_LICENSE =
            PathTemplate.of("/projects/{id}/managed_licenses/{managed_license_id}");
    private static final PathTemplate CALL_DEPENDENCY_PROXY_PACKAGES_NPM =
            PathTemplate.of("/projects/{id}/dependency_proxy/packages/npm/{package_name}/-/{file_name}");
    private static final PathTemplate GET_DEPENDENCY_PROXY_PACKAGES_MAVEN =
            PathTemplate.of("/projects/{id}/dependency_proxy/packages/maven/{path}/{file_name}");
    private static final PathTemplate GET_APPROVAL_SETTINGS = PathTemplate.of("/projects/{id}/approval_settings");
    private static final PathTemplate CREATE_APPROVAL_SETTINGS_RULE =
            PathTemplate.of("/projects/{id}/approval_settings/rules");
    private static final PathTemplate UPDATE_APPROVAL_SETTINGS_RULE =
            PathTemplate.of("/projects/{id}/approval_settings/rules/{approval_rule_id}");
    private static final PathTemplate LIST_APPROVAL_RULES = PathTemplate.of("/projects/{id}/approval_rules");
    private static final PathTemplate GET_APPROVAL_RULE =
            PathTemplate.of("/projects/{id}/approval_rules/{approval_rule_id}");
    private static final PathTemplate CALL_ML_MLFLOW_API_MLFLOW_ARTIFACTS_ARTI =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow-artifacts/artifacts");
    private static final PathTemplate CALL_ML_MLFLOW_API_MLFLOW_ARTIFACTS_AR_2 =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/{model_version}/{file_path}");
    private static final PathTemplate CREATE_ML_MLFLOW_API_MLFLOW_REGISTERED_M =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/create");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_REGISTERED_MODE =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/get");
    private static final PathTemplate UPDATE_ML_MLFLOW_API_MLFLOW_REGISTERED_M =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/update");
    private static final PathTemplate CREATE_ML_MLFLOW_API_MLFLOW_REGISTERED_2 =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions");
    private static final PathTemplate DELETE_ML_MLFLOW_API_MLFLOW_REGISTERED_M =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/delete");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_REGISTERED_MO_2 =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/search");
    private static final PathTemplate CALL_ML_MLFLOW_API_MLFLOW_REGISTERED_MOD =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/alias");
    private static final PathTemplate CREATE_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/create");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_RUNS_GET =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/get");
    private static final PathTemplate SEARCH_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/search");
    private static final PathTemplate UPDATE_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/update");
    private static final PathTemplate LOG_METRIC_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/log-metric");
    private static final PathTemplate LOG_PARAMETER_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/log-parameter");
    private static final PathTemplate SET_TAG_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/set-tag");
    private static final PathTemplate LOG_BATCH_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/log-batch");
    private static final PathTemplate DELETE_ML_MLFLOW_API_MLFLOW_RUN =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/runs/delete");
    private static final PathTemplate CREATE_ML_MLFLOW_API_MLFLOW_MODEL_VERSIO =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/create");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_MODEL_VERSIONS =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_MODEL_VERSION_2 =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/get");
    private static final PathTemplate UPDATE_ML_MLFLOW_API_MLFLOW_MODEL_VERSIO =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/update");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_METRICS_GET_HIS =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/metrics/get-history");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_EXPERIMENTS_GET =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/get");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_EXPERIMENTS_G_2 =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/get-by-name");
    private static final PathTemplate GET_ML_MLFLOW_API_MLFLOW_EXPERIMENTS_LIS =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/list");
    private static final PathTemplate SEARCH_ML_MLFLOW_API_MLFLOW_EXPERIMENT =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/search");
    private static final PathTemplate CREATE_ML_MLFLOW_API_MLFLOW_EXPERIMENT =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/create");
    private static final PathTemplate SET_EXPERIMENT_TAG_ML_MLFLOW_API_MLFLOW =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag");
    private static final PathTemplate DELETE_ML_MLFLOW_API_MLFLOW_EXPERIMENT =
            PathTemplate.of("/projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/delete");
    private static final PathTemplate LIST_REPOSITORY_STORAGE_MOVES =
            PathTemplate.of("/projects/{id}/repository_storage_moves");
    private static final PathTemplate GET_REPOSITORY_STORAGE_MOVE =
            PathTemplate.of("/projects/{id}/repository_storage_moves/{repository_storage_move_id}");
    private static final PathTemplate RESTORE = PathTemplate.of("/projects/{id}/restore");
    private static final PathTemplate LIST = PathTemplate.of("/projects");
    private static final PathTemplate CREATE_USER = PathTemplate.of("/projects/user/{user_id}");
    private static final PathTemplate LIST_SHARE_LOCATIONS = PathTemplate.of("/projects/{id}/share_locations");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}");
    private static final PathTemplate CALL_PAGES_ACCESS = PathTemplate.of("/projects/{id}/pages_access");
    private static final PathTemplate ARCHIVE = PathTemplate.of("/projects/{id}/archive");
    private static final PathTemplate UNARCHIVE = PathTemplate.of("/projects/{id}/unarchive");
    private static final PathTemplate GET_LANGUAGES = PathTemplate.of("/projects/{id}/languages");
    private static final PathTemplate SHARE = PathTemplate.of("/projects/{id}/share");
    private static final PathTemplate DELETE_SHARE = PathTemplate.of("/projects/{id}/share/{group_id}");
    private static final PathTemplate CREATE_IMPORT_PROJECT_MEMBER =
            PathTemplate.of("/projects/{id}/import_project_members/{project_id}");
    private static final PathTemplate LIST_USERS = PathTemplate.of("/projects/{id}/users");
    private static final PathTemplate LIST_GROUPS = PathTemplate.of("/projects/{id}/groups");
    private static final PathTemplate LIST_INVITED_GROUPS = PathTemplate.of("/projects/{id}/invited_groups");
    private static final PathTemplate HOUSEKEEPING = PathTemplate.of("/projects/{id}/housekeeping");
    private static final PathTemplate REPOSITORY_SIZE = PathTemplate.of("/projects/{id}/repository_size");
    private static final PathTemplate TRANSFER = PathTemplate.of("/projects/{id}/transfer");
    private static final PathTemplate LIST_TRANSFER_LOCATIONS = PathTemplate.of("/projects/{id}/transfer_locations");
    private static final PathTemplate GET_STORAGE = PathTemplate.of("/projects/{id}/storage");
    private static final PathTemplate LIST_AUDIT_EVENTS = PathTemplate.of("/projects/{id}/audit_events");
    private static final PathTemplate GET_AUDIT_EVENT = PathTemplate.of("/projects/{id}/audit_events/{audit_event_id}");
    private static final PathTemplate GET_SNAPSHOT = PathTemplate.of("/projects/{id}/snapshot");
    private static final PathTemplate REMOTE_IMPORT = PathTemplate.of("/projects/remote-import");
    private static final PathTemplate AUTHORIZE_IMPORT_RELATION =
            PathTemplate.of("/projects/import-relation/authorize");
    private static final PathTemplate IMPORT_RELATION = PathTemplate.of("/projects/import-relation");
    private static final PathTemplate LIST_RELATION_IMPORTS = PathTemplate.of("/projects/{id}/relation-imports");
    private static final PathTemplate REMOTE_IMPORT_S3 = PathTemplate.of("/projects/remote-import-s3");
    private static final PathTemplate GET_AVATAR = PathTemplate.of("/projects/{id}/avatar");
    private static final PathTemplate CREATE_CI_CONFIG = PathTemplate.of("/projects/{id}/create_ci_config");
    private static final PathTemplate CREATE_GITHUB_WEBHOOK = PathTemplate.of("/projects/{id}/github/webhooks");
    private static final PathTemplate PIPELINE_TRIGGER = PathTemplate.of("/projects/{id}/trigger/pipeline");
    private static final PathTemplate PIPELINE_REF_TRIGGER =
            PathTemplate.of("/projects/{id}/ref/{ref}/trigger/pipeline");
    private static final PathTemplate DELETE_ARTIFACT = PathTemplate.of("/projects/{id}/artifacts");
    private static final PathTemplate PUBLISH_CATALOG = PathTemplate.of("/projects/{id}/catalog/publish");
    private static final JsonType<List<GitLabAiExternalAgentsSession>> AI_EXTERNAL_AGENTS_SESSION_LIST_TYPE =
            JsonTypes.listOf(GitLabAiExternalAgentsSession.class);
    private static final JsonType<List<GitLabAnalyticsDeploymentFrequency>> ANALYTICS_DEPLOYMENT_FREQUENCY_LIST_TYPE =
            JsonTypes.listOf(GitLabAnalyticsDeploymentFrequency.class);
    private static final JsonType<List<GitLabManagedLicense>> MANAGED_LICENSE_LIST_TYPE =
            JsonTypes.listOf(GitLabManagedLicense.class);
    private static final JsonType<List<GitLabProjectApprovalRule>> PROJECT_APPROVAL_RULE_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectApprovalRule.class);
    private static final JsonType<List<GitLabProjectRepositoryStorageMove>> PROJECT_REPOSITORY_STORAGE_MOVE_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectRepositoryStorageMove.class);
    private static final JsonType<List<GitLabProjectWithAccess>> PROJECT_WITH_ACCESS_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectWithAccess.class);
    private static final JsonType<List<GitLabPublicGroupDetails>> PUBLIC_GROUP_DETAILS_LIST_TYPE =
            JsonTypes.listOf(GitLabPublicGroupDetails.class);
    private static final JsonType<Map<String, Double>> DOUBLE_MAP_TYPE = JsonTypes.mapOf(Double.class);
    private static final JsonType<List<GitLabUserBasic>> USER_BASIC_LIST_TYPE = JsonTypes.listOf(GitLabUserBasic.class);
    private static final JsonType<List<GitLabAuditEvent>> AUDIT_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabAuditEvent.class);
    private static final JsonType<List<GitLabRelationImportTracker>> RELATION_IMPORT_TRACKER_LIST_TYPE =
            JsonTypes.listOf(GitLabRelationImportTracker.class);
    private static final GitLabListSpec<GitLabAiExternalAgentsSession> AI_EXTERNAL_AGENTS_SESSION_SPEC =
            GitLabListSpec.offset(AI_EXTERNAL_AGENTS_SESSION_LIST_TYPE);
    private static final GitLabListSpec<GitLabManagedLicense> MANAGED_LICENSE_SPEC =
            GitLabListSpec.offset(MANAGED_LICENSE_LIST_TYPE);
    private static final GitLabListSpec<GitLabProjectApprovalRule> PROJECT_APPROVAL_RULE_SPEC =
            GitLabListSpec.offset(PROJECT_APPROVAL_RULE_LIST_TYPE);
    private static final GitLabListSpec<GitLabProjectRepositoryStorageMove> PROJECT_REPOSITORY_STORAGE_MOVE_SPEC =
            GitLabListSpec.offset(PROJECT_REPOSITORY_STORAGE_MOVE_LIST_TYPE);
    private static final GitLabListSpec<GitLabProjectWithAccess> PROJECT_WITH_ACCESS_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(PROJECT_WITH_ACCESS_LIST_TYPE);
    private static final GitLabListSpec<GitLabUserBasic> USER_BASIC_SPEC = GitLabListSpec.offset(USER_BASIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabPublicGroupDetails> PUBLIC_GROUP_DETAILS_SPEC =
            GitLabListSpec.offset(PUBLIC_GROUP_DETAILS_LIST_TYPE);
    private static final GitLabListSpec<GitLabAuditEvent> AUDIT_EVENT_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(AUDIT_EVENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Status compliance external control ({@code PATCH
     * /projects/{id}/compliance_external_controls/{control_id}/status}).
     *
     * @param id the id
     * @param controlId the control id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void statusComplianceExternalControl(
            final String id,
            final long controlId,
            final GitLabProjectProjectsStatusComplianceExternalControlPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(patch(STATUS_COMPLIANCE_EXTERNAL_CONTROL, id, controlId), payload));
    }

    /**
     * Create security scans sast ({@code POST /projects/{id}/security_scans/sast/{sast_endpoint}}).
     *
     * @param id the id
     * @param sastEndpoint the sast endpoint
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code sastEndpoint} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void createSecurityScansSast(
            final String id,
            final String sastEndpoint,
            final GitLabProjectProjectsCreateSecurityScansSastPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdSecurityScansSastSastEndpoint");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sastEndpoint, "sastEndpoint");
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_SECURITY_SCANS_SAST, id, sastEndpoint), payload));
    }

    /**
     * List ai agent sessions ({@code GET /projects/{id}/ai_agent/sessions}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAiExternalAgentsSession> listAiAgentSessions(final String id) throws IOException {
        return listAiAgentSessions(
                id, GitLabProjectProjectsListAiAgentSessionsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ai agent sessions ({@code GET /projects/{id}/ai_agent/sessions}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAiExternalAgentsSession> listAiAgentSessions(
            final String id, final GitLabPageRequest request) throws IOException {
        return listAiAgentSessions(id, GitLabProjectProjectsListAiAgentSessionsFilter.empty(), request);
    }

    /**
     * List ai agent sessions ({@code GET /projects/{id}/ai_agent/sessions}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAiExternalAgentsSession> listAiAgentSessions(
            final String id, final GitLabProjectProjectsListAiAgentSessionsFilter filter) throws IOException {
        return listAiAgentSessions(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ai agent sessions ({@code GET /projects/{id}/ai_agent/sessions}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAiExternalAgentsSession> listAiAgentSessions(
            final String id,
            final GitLabProjectProjectsListAiAgentSessionsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdAiAgentSessions");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_AI_AGENT_SESSIONS, queryParameters, request, AI_EXTERNAL_AGENTS_SESSION_SPEC, id);
    }

    /**
     * Create ai agent session ({@code POST /projects/{id}/ai_agent/sessions}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAiExternalAgentsSession createAiAgentSession(
            final String id, final GitLabProjectProjectsCreateAiAgentSessionPayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdAiAgentSessions");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_AI_AGENT_SESSIONS, id), payload), GitLabAiExternalAgentsSession.class);
    }

    /**
     * Update ai agent session ({@code PATCH /projects/{id}/ai_agent/sessions/{session_id}}).
     *
     * @param id the id
     * @param sessionId the session id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAiExternalAgentsSession updateAiAgentSession(
            final String id, final long sessionId, final GitLabProjectProjectsUpdateAiAgentSessionPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "patchApiV4ProjectsIdAiAgentSessionsSessionId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(patch(UPDATE_AI_AGENT_SESSION, id, sessionId), payload),
                GitLabAiExternalAgentsSession.class);
    }

    /**
     * Create ai agent identity ({@code POST /projects/{id}/ai_agent/identities}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAiExternalAgentsIdentity createAiAgentIdentity(
            final String id, final GitLabProjectProjectsCreateAiAgentIdentityPayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdAiAgentIdentities");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_AI_AGENT_IDENTITY, id), payload), GitLabAiExternalAgentsIdentity.class);
    }

    /**
     * Create ai agent audit event ({@code POST /projects/{id}/ai_agent/audit_events}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void createAiAgentAuditEvent(
            final String id, final GitLabProjectProjectsCreateAiAgentAuditEventPayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdAiAgentAuditEvents");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_AI_AGENT_AUDIT_EVENT, id), payload));
    }

    /**
     * Create dependency list export ({@code POST /projects/{id}/dependency_list_exports}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void createDependencyListExport(
            final String id, final GitLabProjectProjectsCreateDependencyListExportPayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdDependencyListExports");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_DEPENDENCY_LIST_EXPORT, id), payload));
    }

    /**
     * List analytics deployment frequency ({@code GET /projects/{id}/analytics/deployment_frequency}).
     *
     * @param id the id
     * @param environment the environment
     * @param fromValue the from
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code environment} is blank
     * @throws NullPointerException if {@code fromValue} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabAnalyticsDeploymentFrequency> listAnalyticsDeploymentFrequency(
            final String id, final String environment, final Instant fromValue) throws IOException {
        return listAnalyticsDeploymentFrequency(
                id, environment, fromValue, GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter.empty());
    }

    /**
     * List analytics deployment frequency ({@code GET /projects/{id}/analytics/deployment_frequency}).
     *
     * @param id the id
     * @param environment the environment
     * @param fromValue the from
     * @param filter the optional query parameters
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code environment} is blank
     * @throws NullPointerException if {@code fromValue} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabAnalyticsDeploymentFrequency> listAnalyticsDeploymentFrequency(
            final String id,
            final String environment,
            final Instant fromValue,
            final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdAnalyticsDeploymentFrequency");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(environment, "environment");
        requireNonNull(fromValue, "fromValue");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("environment", environment)
                .value("from", fromValue)
                .build();
        return caller.fetch(
                get(LIST_ANALYTICS_DEPLOYMENT_FREQUENCY, id).withQuery(queryParameters),
                ANALYTICS_DEPLOYMENT_FREQUENCY_LIST_TYPE);
    }

    /**
     * List managed licenses ({@code GET /projects/{id}/managed_licenses}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabManagedLicense> listManagedLicenses(final String id) throws IOException {
        return listManagedLicenses(id, GitLabPageRequest.byPage());
    }

    /**
     * List managed licenses ({@code GET /projects/{id}/managed_licenses}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabManagedLicense> listManagedLicenses(final String id, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_MANAGED_LICENSES, Map.of(), request, MANAGED_LICENSE_SPEC, id);
    }

    /**
     * Create managed license ({@code POST /projects/{id}/managed_licenses}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabManagedLicense createManagedLicense(
            final String id, final GitLabProjectProjectsCreateManagedLicensePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_MANAGED_LICENSES, id), payload), GitLabManagedLicense.class);
    }

    /**
     * Get managed license ({@code GET /projects/{id}/managed_licenses/{managed_license_id}}).
     *
     * @param id the id
     * @param managedLicenseId the managed license id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code managedLicenseId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabManagedLicense> getManagedLicense(final String id, final String managedLicenseId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(managedLicenseId, PARAM_MANAGEDLICENSEID);
        return caller.fetchOrEmpty(get(GET_MANAGED_LICENSE, id, managedLicenseId), GitLabManagedLicense.class);
    }

    /**
     * Update managed license ({@code PATCH /projects/{id}/managed_licenses/{managed_license_id}}).
     *
     * @param id the id
     * @param managedLicenseId the managed license id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code managedLicenseId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabManagedLicense updateManagedLicense(
            final String id,
            final String managedLicenseId,
            final GitLabProjectProjectsUpdateManagedLicensePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(managedLicenseId, PARAM_MANAGEDLICENSEID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(patch(GET_MANAGED_LICENSE, id, managedLicenseId), payload), GitLabManagedLicense.class);
    }

    /**
     * Delete managed license ({@code DELETE /projects/{id}/managed_licenses/{managed_license_id}}).
     *
     * @param id the id
     * @param managedLicenseId the managed license id
     * @throws IllegalArgumentException if {@code id} or {@code managedLicenseId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteManagedLicense(final String id, final String managedLicenseId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(managedLicenseId, PARAM_MANAGEDLICENSEID);
        caller.send(delete(GET_MANAGED_LICENSE, id, managedLicenseId));
    }

    /**
     * Call dependency proxy packages npm ({@code GET
     * /projects/{id}/dependency_proxy/packages/npm/{package_name}/-/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void callDependencyProxyPackagesNpm(final String id, final String packageName, final String fileName)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdDependencyProxyPackagesNpmPackageNameDashFileName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, "packageName");
        requireNotBlank(fileName, PARAM_FILENAME);
        caller.send(get(CALL_DEPENDENCY_PROXY_PACKAGES_NPM, id, packageName, fileName));
    }

    /**
     * Get dependency proxy packages maven ({@code GET
     * /projects/{id}/dependency_proxy/packages/maven/{path}/{file_name}}).
     *
     * @param id the id
     * @param path the path
     * @param fileName the file name
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public long getDependencyProxyPackagesMaven(
            final String id, final String path, final String fileName, final OutputStream out) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdDependencyProxyPackagesMavenPathFileName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(path, "path");
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET_DEPENDENCY_PROXY_PACKAGES_MAVEN, id, path, fileName), out);
    }

    /**
     * Get dependency proxy packages maven ({@code GET
     * /projects/{id}/dependency_proxy/packages/maven/{path}/{file_name}}).
     *
     * @param id the id
     * @param path the path
     * @param fileName the file name
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Path getDependencyProxyPackagesMaven(
            final String id, final String path, final String fileName, final Path target) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdDependencyProxyPackagesMavenPathFileName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(path, "path");
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET_DEPENDENCY_PROXY_PACKAGES_MAVEN, id, path, fileName), target);
    }

    /**
     * Get approval settings ({@code GET /projects/{id}/approval_settings}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectApprovalSettings getApprovalSettings(final String id) throws IOException {
        return getApprovalSettings(id, GitLabProjectProjectsGetApprovalSettingsFilter.empty());
    }

    /**
     * Get approval settings ({@code GET /projects/{id}/approval_settings}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectApprovalSettings getApprovalSettings(
            final String id, final GitLabProjectProjectsGetApprovalSettingsFilter filter) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdApprovalSettings");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_APPROVAL_SETTINGS, id).withQuery(queryParameters), GitLabProjectApprovalSettings.class);
    }

    /**
     * Create approval settings rule ({@code POST /projects/{id}/approval_settings/rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectApprovalSettingRule createApprovalSettingsRule(
            final String id, final GitLabProjectProjectsCreateApprovalSettingsRulePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdApprovalSettingsRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_APPROVAL_SETTINGS_RULE, id), payload), GitLabProjectApprovalSettingRule.class);
    }

    /**
     * Update approval settings rule ({@code PUT /projects/{id}/approval_settings/rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param approvalRuleId the approval rule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectApprovalSettingRule updateApprovalSettingsRule(
            final String id,
            final long approvalRuleId,
            final GitLabProjectProjectsUpdateApprovalSettingsRulePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4ProjectsIdApprovalSettingsRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_APPROVAL_SETTINGS_RULE, id, approvalRuleId), payload),
                GitLabProjectApprovalSettingRule.class);
    }

    /**
     * Delete approval settings rule ({@code DELETE /projects/{id}/approval_settings/rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param approvalRuleId the approval rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteApprovalSettingsRule(final String id, final long approvalRuleId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4ProjectsIdApprovalSettingsRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(UPDATE_APPROVAL_SETTINGS_RULE, id, approvalRuleId));
    }

    /**
     * List approval rules ({@code GET /projects/{id}/approval_rules}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabProjectApprovalRule> listApprovalRules(final String id) throws IOException {
        return listApprovalRules(id, GitLabPageRequest.byPage());
    }

    /**
     * List approval rules ({@code GET /projects/{id}/approval_rules}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabProjectApprovalRule> listApprovalRules(final String id, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdApprovalRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_APPROVAL_RULES, Map.of(), request, PROJECT_APPROVAL_RULE_SPEC, id);
    }

    /**
     * Create approval rule ({@code POST /projects/{id}/approval_rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectApprovalRule createApprovalRule(
            final String id, final GitLabProjectProjectsCreateApprovalRulePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdApprovalRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_APPROVAL_RULES, id), payload), GitLabProjectApprovalRule.class);
    }

    /**
     * Get approval rule ({@code GET /projects/{id}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param approvalRuleId the approval rule id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabProjectApprovalRule> getApprovalRule(final String id, final long approvalRuleId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_APPROVAL_RULE, id, approvalRuleId), GitLabProjectApprovalRule.class);
    }

    /**
     * Update approval rule ({@code PUT /projects/{id}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param approvalRuleId the approval rule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectApprovalRule updateApprovalRule(
            final String id, final long approvalRuleId, final GitLabProjectProjectsUpdateApprovalRulePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4ProjectsIdApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_APPROVAL_RULE, id, approvalRuleId), payload), GitLabProjectApprovalRule.class);
    }

    /**
     * Delete approval rule ({@code DELETE /projects/{id}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param approvalRuleId the approval rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteApprovalRule(final String id, final long approvalRuleId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4ProjectsIdApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_APPROVAL_RULE, id, approvalRuleId));
    }

    /**
     * Call ml mlflow api mlflow artifacts artifacts ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow-artifacts/artifacts}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMlMlflowApiMlflowArtifactsArtifacts(final String id) throws IOException {
        callMlMlflowApiMlflowArtifactsArtifacts(
                id, GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter.empty());
    }

    /**
     * Call ml mlflow api mlflow artifacts artifacts ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow-artifacts/artifacts}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMlMlflowApiMlflowArtifactsArtifacts(
            final String id, final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_ML_MLFLOW_API_MLFLOW_ARTIFACTS_ARTI, id).withQuery(queryParameters));
    }

    /**
     * Call ml mlflow api mlflow artifacts artifact ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/{model_version}/{file_path}}).
     *
     * @param id the id
     * @param modelVersion the model version
     * @param filePath the file path
     * @throws IllegalArgumentException if {@code id}, {@code modelVersion} or {@code filePath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMlMlflowApiMlflowArtifactsArtifact(
            final String id, final String modelVersion, final String filePath) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersion, "modelVersion");
        requireNotBlank(filePath, "filePath");
        caller.send(get(CALL_ML_MLFLOW_API_MLFLOW_ARTIFACTS_AR_2, id, modelVersion, filePath));
    }

    /**
     * Create ml mlflow api mlflow registered model ({@code POST
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/create}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRegisteredModel createMlMlflowApiMlflowRegisteredModel(
            final String id, final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_ML_MLFLOW_API_MLFLOW_REGISTERED_M, id), payload),
                GitLabMlMlflowRegisteredModel.class);
    }

    /**
     * Get ml mlflow api mlflow registered models get ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/get}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRegisteredModel getMlMlflowApiMlflowRegisteredModelsGet(final String id) throws IOException {
        return getMlMlflowApiMlflowRegisteredModelsGet(
                id, GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsGetFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow registered models get ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/get}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRegisteredModel getMlMlflowApiMlflowRegisteredModelsGet(
            final String id, final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsGetFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_REGISTERED_MODE, id).withQuery(queryParameters),
                GitLabMlMlflowRegisteredModel.class);
    }

    /**
     * Update ml mlflow api mlflow registered model ({@code PATCH
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/update}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRegisteredModel updateMlMlflowApiMlflowRegisteredModel(
            final String id, final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(patch(UPDATE_ML_MLFLOW_API_MLFLOW_REGISTERED_M, id), payload),
                GitLabMlMlflowRegisteredModel.class);
    }

    /**
     * Create ml mlflow api mlflow registered models get latest version ({@code POST
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowModelVersion createMlMlflowApiMlflowRegisteredModelsGetLatestVersion(
            final String id, final GitLabProjectMlflowRegisteredModelLatestVersionsPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_ML_MLFLOW_API_MLFLOW_REGISTERED_2, id), payload),
                GitLabMlMlflowModelVersion.class);
    }

    /**
     * Delete ml mlflow api mlflow registered models delete ({@code DELETE
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/delete}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMlMlflowRegisteredModel> deleteMlMlflowApiMlflowRegisteredModelsDelete(final String id)
            throws IOException {
        return deleteMlMlflowApiMlflowRegisteredModelsDelete(
                id, GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter.empty());
    }

    /**
     * Delete ml mlflow api mlflow registered models delete ({@code DELETE
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/delete}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMlMlflowRegisteredModel> deleteMlMlflowApiMlflowRegisteredModelsDelete(
            final String id, final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOptional(
                delete(DELETE_ML_MLFLOW_API_MLFLOW_REGISTERED_M, id).withQuery(queryParameters),
                GitLabMlMlflowRegisteredModel.class);
    }

    /**
     * Get ml mlflow api mlflow registered models search ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/search}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowListRegisteredModels getMlMlflowApiMlflowRegisteredModelsSearch(final String id)
            throws IOException {
        return getMlMlflowApiMlflowRegisteredModelsSearch(
                id, GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow registered models search ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/search}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowListRegisteredModels getMlMlflowApiMlflowRegisteredModelsSearch(
            final String id, final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_REGISTERED_MO_2, id).withQuery(queryParameters),
                GitLabMlMlflowListRegisteredModels.class);
    }

    /**
     * Call ml mlflow api mlflow registered models alias ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/alias}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMlMlflowApiMlflowRegisteredModelsAlias(final String id) throws IOException {
        callMlMlflowApiMlflowRegisteredModelsAlias(
                id, GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter.empty());
    }

    /**
     * Call ml mlflow api mlflow registered models alias ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/registered-models/alias}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMlMlflowApiMlflowRegisteredModelsAlias(
            final String id, final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_ML_MLFLOW_API_MLFLOW_REGISTERED_MOD, id).withQuery(queryParameters));
    }

    /**
     * Create ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/create}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRun createMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CREATE_ML_MLFLOW_API_MLFLOW_RUN, id), payload), GitLabMlMlflowRun.class);
    }

    /**
     * Get ml mlflow api mlflow runs get ({@code GET /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/get}).
     *
     * @param id the id
     * @param runId the run id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code runId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRun getMlMlflowApiMlflowRunsGet(final String id, final String runId) throws IOException {
        return getMlMlflowApiMlflowRunsGet(id, runId, GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow runs get ({@code GET /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/get}).
     *
     * @param id the id
     * @param runId the run id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code runId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRun getMlMlflowApiMlflowRunsGet(
            final String id, final String runId, final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(runId, "runId");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("run_id", runId)
                .build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_RUNS_GET, id).withQuery(queryParameters), GitLabMlMlflowRun.class);
    }

    /**
     * Search ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/search}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowRun searchMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(SEARCH_ML_MLFLOW_API_MLFLOW_RUN, id), payload), GitLabMlMlflowRun.class);
    }

    /**
     * Update ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/update}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowUpdateRun updateMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(UPDATE_ML_MLFLOW_API_MLFLOW_RUN, id), payload), GitLabMlMlflowUpdateRun.class);
    }

    /**
     * Log metric ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/log-metric}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void logMetricMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(LOG_METRIC_ML_MLFLOW_API_MLFLOW_RUN, id), payload));
    }

    /**
     * Log parameter ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/log-parameter}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void logParameterMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(LOG_PARAMETER_ML_MLFLOW_API_MLFLOW_RUN, id), payload));
    }

    /**
     * Set tag ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/set-tag}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void setTagMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(SET_TAG_ML_MLFLOW_API_MLFLOW_RUN, id), payload));
    }

    /**
     * Log batch ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/log-batch}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void logBatchMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(LOG_BATCH_ML_MLFLOW_API_MLFLOW_RUN, id), payload));
    }

    /**
     * Delete ml mlflow api mlflow run ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/runs/delete}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteMlMlflowApiMlflowRun(
            final String id, final GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(DELETE_ML_MLFLOW_API_MLFLOW_RUN, id), payload));
    }

    /**
     * Create ml mlflow api mlflow model version ({@code POST
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/create}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowModelVersion createMlMlflowApiMlflowModelVersion(
            final String id, final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_ML_MLFLOW_API_MLFLOW_MODEL_VERSIO, id), payload),
                GitLabMlMlflowModelVersion.class);
    }

    /**
     * Get ml mlflow api mlflow model versions get download uri ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri}).
     *
     * @param id the id
     * @param name the name
     * @param version the version
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code version} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetDownload getMlMlflowApiMlflowModelVersionsGetDownloadUri(
            final String id, final String name, final Integer version) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(version, PARAM_VERSION);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_NAME, name)
                .value(PARAM_VERSION, version)
                .build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_MODEL_VERSIONS, id).withQuery(queryParameters),
                GitLabMlMlflowGetDownload.class);
    }

    /**
     * Get ml mlflow api mlflow model versions get ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/get}).
     *
     * @param id the id
     * @param name the name
     * @param version the version
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code name} or {@code version} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowModelVersion getMlMlflowApiMlflowModelVersionsGet(
            final String id, final String name, final String version) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNotBlank(version, PARAM_VERSION);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_NAME, name)
                .text(PARAM_VERSION, version)
                .build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_MODEL_VERSION_2, id).withQuery(queryParameters),
                GitLabMlMlflowModelVersion.class);
    }

    /**
     * Update ml mlflow api mlflow model version ({@code PATCH
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/model-versions/update}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowModelVersion updateMlMlflowApiMlflowModelVersion(
            final String id, final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(patch(UPDATE_ML_MLFLOW_API_MLFLOW_MODEL_VERSIO, id), payload),
                GitLabMlMlflowModelVersion.class);
    }

    /**
     * Get ml mlflow api mlflow metrics get history ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/metrics/get-history}).
     *
     * @param id the id
     * @param runId the run id
     * @param metricKey the metric key
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code runId} or {@code metricKey} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetMetricHistory getMlMlflowApiMlflowMetricsGetHistory(
            final String id, final String runId, final String metricKey) throws IOException {
        return getMlMlflowApiMlflowMetricsGetHistory(
                id, runId, metricKey, GitLabProjectProjectsGetMlMlflowApiMlflowMetricsGetHistoryFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow metrics get history ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/metrics/get-history}).
     *
     * @param id the id
     * @param runId the run id
     * @param metricKey the metric key
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code runId} or {@code metricKey} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetMetricHistory getMlMlflowApiMlflowMetricsGetHistory(
            final String id,
            final String runId,
            final String metricKey,
            final GitLabProjectProjectsGetMlMlflowApiMlflowMetricsGetHistoryFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(runId, "runId");
        requireNotBlank(metricKey, "metricKey");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("run_id", runId)
                .text("metric_key", metricKey)
                .build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_METRICS_GET_HIS, id).withQuery(queryParameters),
                GitLabMlMlflowGetMetricHistory.class);
    }

    /**
     * Get ml mlflow api mlflow experiments get ({@code GET /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/get}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetExperiment getMlMlflowApiMlflowExperimentsGet(final String id) throws IOException {
        return getMlMlflowApiMlflowExperimentsGet(
                id, GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow experiments get ({@code GET /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/get}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetExperiment getMlMlflowApiMlflowExperimentsGet(
            final String id, final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_EXPERIMENTS_GET, id).withQuery(queryParameters),
                GitLabMlMlflowGetExperiment.class);
    }

    /**
     * Get ml mlflow api mlflow experiments get by name ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/get-by-name}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetExperiment getMlMlflowApiMlflowExperimentsGetByName(final String id) throws IOException {
        return getMlMlflowApiMlflowExperimentsGetByName(
                id, GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow experiments get by name ({@code GET
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/get-by-name}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowGetExperiment getMlMlflowApiMlflowExperimentsGetByName(
            final String id, final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_EXPERIMENTS_G_2, id).withQuery(queryParameters),
                GitLabMlMlflowGetExperiment.class);
    }

    /**
     * Get ml mlflow api mlflow experiments list ({@code GET /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/list}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowListExperiment getMlMlflowApiMlflowExperimentsList(final String id) throws IOException {
        return getMlMlflowApiMlflowExperimentsList(
                id, GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter.empty());
    }

    /**
     * Get ml mlflow api mlflow experiments list ({@code GET /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/list}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowListExperiment getMlMlflowApiMlflowExperimentsList(
            final String id, final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_ML_MLFLOW_API_MLFLOW_EXPERIMENTS_LIS, id).withQuery(queryParameters),
                GitLabMlMlflowListExperiment.class);
    }

    /**
     * Search ml mlflow api mlflow experiment ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/search}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowListExperiment searchMlMlflowApiMlflowExperiment(
            final String id, final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(SEARCH_ML_MLFLOW_API_MLFLOW_EXPERIMENT, id), payload),
                GitLabMlMlflowListExperiment.class);
    }

    /**
     * Create ml mlflow api mlflow experiment ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/create}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMlMlflowNewExperiment createMlMlflowApiMlflowExperiment(
            final String id, final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_ML_MLFLOW_API_MLFLOW_EXPERIMENT, id), payload),
                GitLabMlMlflowNewExperiment.class);
    }

    /**
     * Set experiment tag ml mlflow api mlflow experiment ({@code POST
     * /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void setExperimentTagMlMlflowApiMlflowExperiment(
            final String id, final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(SET_EXPERIMENT_TAG_ML_MLFLOW_API_MLFLOW, id), payload));
    }

    /**
     * Delete ml mlflow api mlflow experiment ({@code POST /projects/{id}/ml/mlflow/api/2.0/mlflow/experiments/delete}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteMlMlflowApiMlflowExperiment(
            final String id, final GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(DELETE_ML_MLFLOW_API_MLFLOW_EXPERIMENT, id), payload));
    }

    /**
     * List repository storage moves ({@code GET /projects/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectRepositoryStorageMove> listRepositoryStorageMoves(final String id)
            throws IOException {
        return listRepositoryStorageMoves(id, GitLabPageRequest.byPage());
    }

    /**
     * List repository storage moves ({@code GET /projects/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectRepositoryStorageMove> listRepositoryStorageMoves(
            final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REPOSITORY_STORAGE_MOVES, Map.of(), request, PROJECT_REPOSITORY_STORAGE_MOVE_SPEC, id);
    }

    /**
     * Create repository storage move ({@code POST /projects/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectRepositoryStorageMove createRepositoryStorageMove(
            final String id, final GitLabProjectProjectsCreateRepositoryStorageMovePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REPOSITORY_STORAGE_MOVES, id), payload),
                GitLabProjectRepositoryStorageMove.class);
    }

    /**
     * Get repository storage move ({@code GET /projects/{id}/repository_storage_moves/{repository_storage_move_id}}).
     *
     * @param id the id
     * @param repositoryStorageMoveId the repository storage move id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectRepositoryStorageMove> getRepositoryStorageMove(
            final String id, final long repositoryStorageMoveId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_REPOSITORY_STORAGE_MOVE, id, repositoryStorageMoveId),
                GitLabProjectRepositoryStorageMove.class);
    }

    /**
     * Restore ({@code POST /projects/{id}/restore}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject restore(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESTORE, id), GitLabProject.class);
    }

    /**
     * List ({@code GET /projects}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list() throws IOException {
        return list(GitLabProjectProjectsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabProjectProjectsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(final GitLabProjectProjectsListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(
            final GitLabProjectProjectsListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PROJECT_WITH_ACCESS_KEYSET_SPEC);
    }

    /**
     * Create ({@code POST /projects}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject create(final MultipartFormData form) throws IOException {
        requireNonNull(form, PARAM_FORM);
        return caller.fetch(caller.multipart(post(LIST), form), GitLabProject.class);
    }

    /**
     * Create user ({@code POST /projects/user/{user_id}}).
     *
     * @param userId the user id
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject createUser(final long userId, final MultipartFormData form) throws IOException {
        requireNonNull(form, PARAM_FORM);
        return caller.fetch(caller.multipart(post(CREATE_USER, userId), form), GitLabProject.class);
    }

    /**
     * List share locations ({@code GET /projects/{id}/share_locations}).
     *
     * @param id the id
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabPublicGroupDetails> listShareLocations(final long id) throws IOException {
        return listShareLocations(id, GitLabProjectProjectsListShareLocationsFilter.empty());
    }

    /**
     * List share locations ({@code GET /projects/{id}/share_locations}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the items
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabPublicGroupDetails> listShareLocations(
            final long id, final GitLabProjectProjectsListShareLocationsFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST_SHARE_LOCATIONS, id).withQuery(queryParameters), PUBLIC_GROUP_DETAILS_LIST_TYPE);
    }

    /**
     * Get ({@code GET /projects/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectWithAccessAndCatalog> get(final String id) throws IOException {
        return get(id, GitLabProjectProjectsGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectWithAccessAndCatalog> get(final String id, final GitLabProjectProjectsGetFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id).withQuery(queryParameters), GitLabProjectWithAccessAndCatalog.class);
    }

    /**
     * Update ({@code PUT /projects/{id}}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectWithCatalog update(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, PARAM_FORM);
        return caller.fetch(caller.multipart(put(GET, id), form), GitLabProjectWithCatalog.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id));
    }

    /**
     * Call pages access ({@code GET /projects/{id}/pages_access}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPagesAccess(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PAGES_ACCESS, id));
    }

    /**
     * Archive ({@code POST /projects/{id}/archive}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject archive(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(ARCHIVE, id), GitLabProject.class);
    }

    /**
     * Unarchive ({@code POST /projects/{id}/unarchive}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject unarchive(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(UNARCHIVE, id), GitLabProject.class);
    }

    /**
     * Get languages ({@code GET /projects/{id}/languages}).
     *
     * @param id the id
     * @return the values by name
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Map<String, Double> getLanguages(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_LANGUAGES, id), DOUBLE_MAP_TYPE);
    }

    /**
     * Share ({@code POST /projects/{id}/share}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectGroupLink share(final String id, final GitLabProjectProjectsSharePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(SHARE, id), payload), GitLabProjectGroupLink.class);
    }

    /**
     * Delete share ({@code DELETE /projects/{id}/share/{group_id}}).
     *
     * @param id the id
     * @param groupId the group id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteShare(final String id, final long groupId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_SHARE, id, groupId));
    }

    /**
     * Create import project member ({@code POST /projects/{id}/import_project_members/{project_id}}).
     *
     * @param id the id
     * @param projectId the project id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createImportProjectMember(final String id, final long projectId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(CREATE_IMPORT_PROJECT_MEMBER, id, projectId));
    }

    /**
     * List users ({@code GET /projects/{id}/users}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listUsers(final String id) throws IOException {
        return listUsers(id, GitLabProjectProjectsListUsersFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List users ({@code GET /projects/{id}/users}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listUsers(final String id, final GitLabPageRequest request) throws IOException {
        return listUsers(id, GitLabProjectProjectsListUsersFilter.empty(), request);
    }

    /**
     * List users ({@code GET /projects/{id}/users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listUsers(final String id, final GitLabProjectProjectsListUsersFilter filter)
            throws IOException {
        return listUsers(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List users ({@code GET /projects/{id}/users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listUsers(
            final String id, final GitLabProjectProjectsListUsersFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_USERS, queryParameters, request, USER_BASIC_SPEC, id);
    }

    /**
     * List groups ({@code GET /projects/{id}/groups}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listGroups(final String id) throws IOException {
        return listGroups(id, GitLabProjectProjectsListGroupsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List groups ({@code GET /projects/{id}/groups}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listGroups(final String id, final GitLabPageRequest request)
            throws IOException {
        return listGroups(id, GitLabProjectProjectsListGroupsFilter.empty(), request);
    }

    /**
     * List groups ({@code GET /projects/{id}/groups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listGroups(
            final String id, final GitLabProjectProjectsListGroupsFilter filter) throws IOException {
        return listGroups(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List groups ({@code GET /projects/{id}/groups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listGroups(
            final String id, final GitLabProjectProjectsListGroupsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_GROUPS, queryParameters, request, PUBLIC_GROUP_DETAILS_SPEC, id);
    }

    /**
     * List invited groups ({@code GET /projects/{id}/invited_groups}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listInvitedGroups(final String id) throws IOException {
        return listInvitedGroups(id, GitLabProjectProjectsListInvitedGroupsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List invited groups ({@code GET /projects/{id}/invited_groups}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listInvitedGroups(final String id, final GitLabPageRequest request)
            throws IOException {
        return listInvitedGroups(id, GitLabProjectProjectsListInvitedGroupsFilter.empty(), request);
    }

    /**
     * List invited groups ({@code GET /projects/{id}/invited_groups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listInvitedGroups(
            final String id, final GitLabProjectProjectsListInvitedGroupsFilter filter) throws IOException {
        return listInvitedGroups(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List invited groups ({@code GET /projects/{id}/invited_groups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listInvitedGroups(
            final String id, final GitLabProjectProjectsListInvitedGroupsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_INVITED_GROUPS, queryParameters, request, PUBLIC_GROUP_DETAILS_SPEC, id);
    }

    /**
     * Housekeeping ({@code POST /projects/{id}/housekeeping}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void housekeeping(final String id, final GitLabProjectProjectsHousekeepingPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(HOUSEKEEPING, id), payload));
    }

    /**
     * Repository size ({@code POST /projects/{id}/repository_size}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void repositorySize(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(REPOSITORY_SIZE, id));
    }

    /**
     * Transfer ({@code PUT /projects/{id}/transfer}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject transfer(final String id, final GitLabProjectProjectsTransferPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TRANSFER, id), payload), GitLabProject.class);
    }

    /**
     * List transfer locations ({@code GET /projects/{id}/transfer_locations}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listTransferLocations(final String id) throws IOException {
        return listTransferLocations(
                id, GitLabProjectProjectsListTransferLocationsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List transfer locations ({@code GET /projects/{id}/transfer_locations}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listTransferLocations(final String id, final GitLabPageRequest request)
            throws IOException {
        return listTransferLocations(id, GitLabProjectProjectsListTransferLocationsFilter.empty(), request);
    }

    /**
     * List transfer locations ({@code GET /projects/{id}/transfer_locations}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listTransferLocations(
            final String id, final GitLabProjectProjectsListTransferLocationsFilter filter) throws IOException {
        return listTransferLocations(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List transfer locations ({@code GET /projects/{id}/transfer_locations}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPublicGroupDetails> listTransferLocations(
            final String id,
            final GitLabProjectProjectsListTransferLocationsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_TRANSFER_LOCATIONS, queryParameters, request, PUBLIC_GROUP_DETAILS_SPEC, id);
    }

    /**
     * Get storage ({@code GET /projects/{id}/storage}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectRepositoryStorage getStorage(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_STORAGE, id), GitLabProjectRepositoryStorage.class);
    }

    /**
     * List audit events ({@code GET /projects/{id}/audit_events}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(final String id) throws IOException {
        return listAuditEvents(id, GitLabProjectProjectsListAuditEventsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List audit events ({@code GET /projects/{id}/audit_events}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(final String id, final GitLabPageRequest request)
            throws IOException {
        return listAuditEvents(id, GitLabProjectProjectsListAuditEventsFilter.empty(), request);
    }

    /**
     * List audit events ({@code GET /projects/{id}/audit_events}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(
            final String id, final GitLabProjectProjectsListAuditEventsFilter filter) throws IOException {
        return listAuditEvents(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List audit events ({@code GET /projects/{id}/audit_events}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(
            final String id, final GitLabProjectProjectsListAuditEventsFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdAuditEvents");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_AUDIT_EVENTS, queryParameters, request, AUDIT_EVENT_KEYSET_SPEC, id);
    }

    /**
     * Get audit event ({@code GET /projects/{id}/audit_events/{audit_event_id}}).
     *
     * @param id the id
     * @param auditEventId the audit event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabAuditEvent> getAuditEvent(final String id, final long auditEventId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdAuditEventsAuditEventId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_AUDIT_EVENT, id, auditEventId), GitLabAuditEvent.class);
    }

    /**
     * Get snapshot ({@code GET /projects/{id}/snapshot}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getSnapshot(final String id, final OutputStream out) throws IOException {
        return getSnapshot(id, GitLabProjectProjectsGetSnapshotFilter.empty(), out);
    }

    /**
     * Get snapshot ({@code GET /projects/{id}/snapshot}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getSnapshot(final String id, final Path target) throws IOException {
        return getSnapshot(id, GitLabProjectProjectsGetSnapshotFilter.empty(), target);
    }

    /**
     * Get snapshot ({@code GET /projects/{id}/snapshot}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getSnapshot(
            final String id, final GitLabProjectProjectsGetSnapshotFilter filter, final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, PARAM_OUT);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_SNAPSHOT, id).withQuery(queryParameters), out);
    }

    /**
     * Get snapshot ({@code GET /projects/{id}/snapshot}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getSnapshot(final String id, final GitLabProjectProjectsGetSnapshotFilter filter, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, PARAM_TARGET);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_SNAPSHOT, id).withQuery(queryParameters), target);
    }

    /**
     * Remote import ({@code POST /projects/remote-import}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectImportStatus remoteImport(final MultipartFormData form) throws IOException {
        requireNonNull(form, PARAM_FORM);
        return caller.fetch(caller.multipart(post(REMOTE_IMPORT), form), GitLabProjectImportStatus.class);
    }

    /**
     * Authorize import relation ({@code POST /projects/import-relation/authorize}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeImportRelation() throws IOException {
        caller.send(post(AUTHORIZE_IMPORT_RELATION));
    }

    /**
     * Import relation ({@code POST /projects/import-relation}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRelationImportTracker importRelation(final MultipartFormData form) throws IOException {
        requireNonNull(form, PARAM_FORM);
        return caller.fetch(caller.multipart(post(IMPORT_RELATION), form), GitLabRelationImportTracker.class);
    }

    /**
     * List relation imports ({@code GET /projects/{id}/relation-imports}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabRelationImportTracker> listRelationImports(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_RELATION_IMPORTS, id), RELATION_IMPORT_TRACKER_LIST_TYPE);
    }

    /**
     * Remote import s3 ({@code POST /projects/remote-import-s3}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectImportStatus remoteImportS3(final MultipartFormData form) throws IOException {
        requireNonNull(form, PARAM_FORM);
        return caller.fetch(caller.multipart(post(REMOTE_IMPORT_S3), form), GitLabProjectImportStatus.class);
    }

    /**
     * Get avatar ({@code GET /projects/{id}/avatar}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getAvatar(final String id, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET_AVATAR, id), out);
    }

    /**
     * Get avatar ({@code GET /projects/{id}/avatar}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getAvatar(final String id, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET_AVATAR, id), target);
    }

    /**
     * Create ci config ({@code POST /projects/{id}/create_ci_config}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest createCiConfig(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CREATE_CI_CONFIG, id), GitLabMergeRequest.class);
    }

    /**
     * Create github webhook ({@code POST /projects/{id}/github/webhooks}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createGithubWebhook(final long id) throws IOException {
        caller.send(post(CREATE_GITHUB_WEBHOOK, id));
    }

    /**
     * Pipeline trigger ({@code POST /projects/{id}/trigger/pipeline}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipeline pipelineTrigger(final String id, final GitLabProjectProjectsPipelineTriggerPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(PIPELINE_TRIGGER, id), payload), GitLabCiPipeline.class);
    }

    /**
     * Pipeline ref trigger ({@code POST /projects/{id}/ref/{ref}/trigger/pipeline}).
     *
     * @param id the id
     * @param ref the ref
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code ref} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipeline pipelineRefTrigger(
            final String id, final String ref, final GitLabProjectProjectsPipelineRefTriggerPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(ref, "ref");
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(PIPELINE_REF_TRIGGER, id, ref), payload), GitLabCiPipeline.class);
    }

    /**
     * Delete artifact ({@code DELETE /projects/{id}/artifacts}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteArtifact(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_ARTIFACT, id));
    }

    /**
     * Publish catalog ({@code POST /projects/{id}/catalog/publish}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiCatalogResourcesVersion publishCatalog(
            final String id, final GitLabProjectProjectsPublishCatalogPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(PUBLISH_CATALOG, id), payload), GitLabCiCatalogResourcesVersion.class);
    }
}
