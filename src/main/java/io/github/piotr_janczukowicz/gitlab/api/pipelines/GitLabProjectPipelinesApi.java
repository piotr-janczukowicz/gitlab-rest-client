package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiVariable;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project pipelines. */
public final class GitLabProjectPipelinesApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST = PathTemplate.of("/pipelines");
    private static final PathTemplate LIST_PROJECT = PathTemplate.of("/projects/{id}/pipelines");
    private static final PathTemplate CREATE = PathTemplate.of("/projects/{id}/pipeline");
    private static final PathTemplate GET_LATEST = PathTemplate.of("/projects/{id}/pipelines/latest");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}");
    private static final PathTemplate LIST_BRIDGES = PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/bridges");
    private static final PathTemplate LIST_TRIGGER_JOBS =
            PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/trigger_jobs");
    private static final PathTemplate LIST_VARIABLES =
            PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/variables");
    private static final PathTemplate GET_TEST_REPORT =
            PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/test_report");
    private static final PathTemplate GET_TEST_REPORT_SUMMARY =
            PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/test_report_summary");
    private static final PathTemplate METADATA = PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/metadata");
    private static final PathTemplate RETRY = PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/retry");
    private static final PathTemplate CANCEL = PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/cancel");
    private static final JsonType<List<GitLabCiUserPipeline>> CI_USER_PIPELINE_LIST_TYPE =
            JsonTypes.listOf(GitLabCiUserPipeline.class);
    private static final JsonType<List<GitLabCiPipelineBasic>> CI_PIPELINE_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabCiPipelineBasic.class);
    private static final JsonType<List<GitLabCiBridge>> CI_BRIDGE_LIST_TYPE = JsonTypes.listOf(GitLabCiBridge.class);
    private static final JsonType<List<GitLabCiVariable>> CI_VARIABLE_LIST_TYPE =
            JsonTypes.listOf(GitLabCiVariable.class);
    private static final GitLabListSpec<GitLabCiUserPipeline> CI_USER_PIPELINE_SPEC =
            GitLabListSpec.offset(CI_USER_PIPELINE_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiPipelineBasic> CI_PIPELINE_BASIC_SPEC =
            GitLabListSpec.offset(CI_PIPELINE_BASIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiBridge> CI_BRIDGE_SPEC = GitLabListSpec.offset(CI_BRIDGE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectPipelinesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /pipelines}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiUserPipeline> list() throws IOException {
        return list(GitLabProjectPipelinesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /pipelines}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiUserPipeline> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabProjectPipelinesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /pipelines}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiUserPipeline> list(final GitLabProjectPipelinesListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /pipelines}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiUserPipeline> list(
            final GitLabProjectPipelinesListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, CI_USER_PIPELINE_SPEC);
    }

    /**
     * List project ({@code GET /projects/{id}/pipelines}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listProject(final String id) throws IOException {
        return listProject(id, GitLabProjectPipelinesListProjectFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List project ({@code GET /projects/{id}/pipelines}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listProject(final String id, final GitLabPageRequest request)
            throws IOException {
        return listProject(id, GitLabProjectPipelinesListProjectFilter.empty(), request);
    }

    /**
     * List project ({@code GET /projects/{id}/pipelines}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listProject(
            final String id, final GitLabProjectPipelinesListProjectFilter filter) throws IOException {
        return listProject(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List project ({@code GET /projects/{id}/pipelines}).
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
    public GitLabPage<GitLabCiPipelineBasic> listProject(
            final String id, final GitLabProjectPipelinesListProjectFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PROJECT, queryParameters, request, CI_PIPELINE_BASIC_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/pipeline}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipeline create(final String id, final GitLabProjectPipelinesCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE, id), payload), GitLabCiPipeline.class);
    }

    /**
     * Get latest ({@code GET /projects/{id}/pipelines/latest}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipelineWithMetadata getLatest(final String id) throws IOException {
        return getLatest(id, GitLabProjectPipelinesGetLatestFilter.empty());
    }

    /**
     * Get latest ({@code GET /projects/{id}/pipelines/latest}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipelineWithMetadata getLatest(final String id, final GitLabProjectPipelinesGetLatestFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(GET_LATEST, id).withQuery(queryParameters), GitLabCiPipelineWithMetadata.class);
    }

    /**
     * Get ({@code GET /projects/{id}/pipelines/{pipeline_id}}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiPipelineWithMetadata> get(final String id, final long pipelineId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, pipelineId), GitLabCiPipelineWithMetadata.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/pipelines/{pipeline_id}}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long pipelineId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, pipelineId));
    }

    /**
     * List bridges ({@code GET /projects/{id}/pipelines/{pipeline_id}/bridges}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabPage<GitLabCiBridge> listBridges(final String id, final long pipelineId) throws IOException {
        return listBridges(id, pipelineId, GitLabProjectPipelinesListBridgesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List bridges ({@code GET /projects/{id}/pipelines/{pipeline_id}/bridges}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabPage<GitLabCiBridge> listBridges(
            final String id, final long pipelineId, final GitLabPageRequest request) throws IOException {
        return listBridges(id, pipelineId, GitLabProjectPipelinesListBridgesFilter.empty(), request);
    }

    /**
     * List bridges ({@code GET /projects/{id}/pipelines/{pipeline_id}/bridges}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabPage<GitLabCiBridge> listBridges(
            final String id, final long pipelineId, final GitLabProjectPipelinesListBridgesFilter filter)
            throws IOException {
        return listBridges(id, pipelineId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List bridges ({@code GET /projects/{id}/pipelines/{pipeline_id}/bridges}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabPage<GitLabCiBridge> listBridges(
            final String id,
            final long pipelineId,
            final GitLabProjectPipelinesListBridgesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_BRIDGES, queryParameters, request, CI_BRIDGE_SPEC, id, pipelineId);
    }

    /**
     * List trigger jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/trigger_jobs}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiBridge> listTriggerJobs(final String id, final long pipelineId) throws IOException {
        return listTriggerJobs(
                id, pipelineId, GitLabProjectPipelinesListTriggerJobsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List trigger jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/trigger_jobs}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiBridge> listTriggerJobs(
            final String id, final long pipelineId, final GitLabPageRequest request) throws IOException {
        return listTriggerJobs(id, pipelineId, GitLabProjectPipelinesListTriggerJobsFilter.empty(), request);
    }

    /**
     * List trigger jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/trigger_jobs}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiBridge> listTriggerJobs(
            final String id, final long pipelineId, final GitLabProjectPipelinesListTriggerJobsFilter filter)
            throws IOException {
        return listTriggerJobs(id, pipelineId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List trigger jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/trigger_jobs}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiBridge> listTriggerJobs(
            final String id,
            final long pipelineId,
            final GitLabProjectPipelinesListTriggerJobsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_TRIGGER_JOBS, queryParameters, request, CI_BRIDGE_SPEC, id, pipelineId);
    }

    /**
     * List variables ({@code GET /projects/{id}/pipelines/{pipeline_id}/variables}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabCiVariable> listVariables(final String id, final long pipelineId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_VARIABLES, id, pipelineId), CI_VARIABLE_LIST_TYPE);
    }

    /**
     * Get test report ({@code GET /projects/{id}/pipelines/{pipeline_id}/test_report}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTestReportEntity> getTestReport(final String id, final long pipelineId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_TEST_REPORT, id, pipelineId), GitLabTestReportEntity.class);
    }

    /**
     * Get test report summary ({@code GET /projects/{id}/pipelines/{pipeline_id}/test_report_summary}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTestReportSummaryEntity> getTestReportSummary(final String id, final long pipelineId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_TEST_REPORT_SUMMARY, id, pipelineId), GitLabTestReportSummaryEntity.class);
    }

    /**
     * Metadata ({@code PUT /projects/{id}/pipelines/{pipeline_id}/metadata}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipelineWithMetadata metadata(
            final String id, final long pipelineId, final GitLabProjectPipelinesMetadataPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(METADATA, id, pipelineId), payload), GitLabCiPipelineWithMetadata.class);
    }

    /**
     * Retry ({@code POST /projects/{id}/pipelines/{pipeline_id}/retry}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipeline retry(final String id, final long pipelineId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RETRY, id, pipelineId), GitLabCiPipeline.class);
    }

    /**
     * Cancel ({@code POST /projects/{id}/pipelines/{pipeline_id}/cancel}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipeline cancel(final String id, final long pipelineId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CANCEL, id, pipelineId), GitLabCiPipeline.class);
    }
}
