package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJobBasic;
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
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project jobs. */
public final class GitLabProjectJobsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_JOB = "job";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REFNAME = "refName";
    private static final PathTemplate LIST_PIPELINES_JOBS =
            PathTemplate.of("/projects/{id}/pipelines/{pipeline_id}/jobs");
    private static final PathTemplate LIST_JOBS = PathTemplate.of("/projects/{id}/jobs");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/jobs/{job_id}");
    private static final PathTemplate GET_TRACE = PathTemplate.of("/projects/{id}/jobs/{job_id}/trace");
    private static final PathTemplate CANCEL = PathTemplate.of("/projects/{id}/jobs/{job_id}/cancel");
    private static final PathTemplate RETRY = PathTemplate.of("/projects/{id}/jobs/{job_id}/retry");
    private static final PathTemplate ERASE = PathTemplate.of("/projects/{id}/jobs/{job_id}/erase");
    private static final PathTemplate PLAY = PathTemplate.of("/projects/{id}/jobs/{job_id}/play");
    private static final PathTemplate GET_ARTIFACTS_DOWNLOAD =
            PathTemplate.of("/projects/{id}/jobs/artifacts/{ref_name}/download");
    private static final PathTemplate CALL_ARTIFACTS_RAW =
            PathTemplate.of("/projects/{id}/jobs/artifacts/{ref_name}/raw/{artifact_path}");
    private static final JsonType<List<GitLabCiJob>> CI_JOB_LIST_TYPE = JsonTypes.listOf(GitLabCiJob.class);
    private static final GitLabListSpec<GitLabCiJob> CI_JOB_SPEC = GitLabListSpec.offset(CI_JOB_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiJob> CI_JOB_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(CI_JOB_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectJobsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List pipelines jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/jobs}).
     *
     * @param id the id
     * @param pipelineId the pipeline id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJob> listPipelinesJobs(final String id, final long pipelineId) throws IOException {
        return listPipelinesJobs(
                id, pipelineId, GitLabProjectJobsListPipelinesJobsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List pipelines jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/jobs}).
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
    public GitLabPage<GitLabCiJob> listPipelinesJobs(
            final String id, final long pipelineId, final GitLabPageRequest request) throws IOException {
        return listPipelinesJobs(id, pipelineId, GitLabProjectJobsListPipelinesJobsFilter.empty(), request);
    }

    /**
     * List pipelines jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/jobs}).
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
    public GitLabPage<GitLabCiJob> listPipelinesJobs(
            final String id, final long pipelineId, final GitLabProjectJobsListPipelinesJobsFilter filter)
            throws IOException {
        return listPipelinesJobs(id, pipelineId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List pipelines jobs ({@code GET /projects/{id}/pipelines/{pipeline_id}/jobs}).
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
    public GitLabPage<GitLabCiJob> listPipelinesJobs(
            final String id,
            final long pipelineId,
            final GitLabProjectJobsListPipelinesJobsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PIPELINES_JOBS, queryParameters, request, CI_JOB_SPEC, id, pipelineId);
    }

    /**
     * List jobs ({@code GET /projects/{id}/jobs}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJob> listJobs(final String id) throws IOException {
        return listJobs(id, GitLabProjectJobsListJobsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List jobs ({@code GET /projects/{id}/jobs}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJob> listJobs(final String id, final GitLabPageRequest request) throws IOException {
        return listJobs(id, GitLabProjectJobsListJobsFilter.empty(), request);
    }

    /**
     * List jobs ({@code GET /projects/{id}/jobs}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJob> listJobs(final String id, final GitLabProjectJobsListJobsFilter filter)
            throws IOException {
        return listJobs(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List jobs ({@code GET /projects/{id}/jobs}).
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
    public GitLabPage<GitLabCiJob> listJobs(
            final String id, final GitLabProjectJobsListJobsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_JOBS, queryParameters, request, CI_JOB_KEYSET_SPEC, id);
    }

    /**
     * Get ({@code GET /projects/{id}/jobs/{job_id}}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiJob> get(final String id, final long jobId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, jobId), GitLabCiJob.class);
    }

    /**
     * Get trace ({@code GET /projects/{id}/jobs/{job_id}/trace}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiJob> getTrace(final String id, final long jobId) throws IOException {
        return getTrace(id, jobId, GitLabProjectJobsGetTraceFilter.empty());
    }

    /**
     * Get trace ({@code GET /projects/{id}/jobs/{job_id}/trace}).
     *
     * @param id the id
     * @param jobId the job id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiJob> getTrace(
            final String id, final long jobId, final GitLabProjectJobsGetTraceFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET_TRACE, id, jobId).withQuery(queryParameters), GitLabCiJob.class);
    }

    /**
     * Cancel ({@code POST /projects/{id}/jobs/{job_id}/cancel}).
     *
     * @param id the id
     * @param jobId the job id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJob cancel(final String id, final long jobId, final GitLabProjectJobsCancelPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CANCEL, id, jobId), payload), GitLabCiJob.class);
    }

    /**
     * Retry ({@code POST /projects/{id}/jobs/{job_id}/retry}).
     *
     * @param id the id
     * @param jobId the job id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJob retry(final String id, final long jobId, final GitLabProjectJobsRetryPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(RETRY, id, jobId), payload), GitLabCiJob.class);
    }

    /**
     * Erase ({@code POST /projects/{id}/jobs/{job_id}/erase}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJob erase(final String id, final long jobId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(ERASE, id, jobId), GitLabCiJob.class);
    }

    /**
     * Play ({@code POST /projects/{id}/jobs/{job_id}/play}).
     *
     * @param id the id
     * @param jobId the job id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJobBasic play(final String id, final long jobId, final GitLabProjectJobsPlayPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(PLAY, id, jobId), payload), GitLabCiJobBasic.class);
    }

    /**
     * Get artifacts download ({@code GET /projects/{id}/jobs/artifacts/{ref_name}/download}).
     *
     * @param id the id
     * @param refName the ref name
     * @param job the job
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code refName} or {@code job} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getArtifactsDownload(final String id, final String refName, final String job, final OutputStream out)
            throws IOException {
        return getArtifactsDownload(id, refName, job, GitLabProjectJobsGetArtifactsDownloadFilter.empty(), out);
    }

    /**
     * Get artifacts download ({@code GET /projects/{id}/jobs/artifacts/{ref_name}/download}).
     *
     * @param id the id
     * @param refName the ref name
     * @param job the job
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code refName} or {@code job} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getArtifactsDownload(final String id, final String refName, final String job, final Path target)
            throws IOException {
        return getArtifactsDownload(id, refName, job, GitLabProjectJobsGetArtifactsDownloadFilter.empty(), target);
    }

    /**
     * Get artifacts download ({@code GET /projects/{id}/jobs/artifacts/{ref_name}/download}).
     *
     * @param id the id
     * @param refName the ref name
     * @param job the job
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code refName} or {@code job} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getArtifactsDownload(
            final String id,
            final String refName,
            final String job,
            final GitLabProjectJobsGetArtifactsDownloadFilter filter,
            final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(refName, PARAM_REFNAME);
        requireNotBlank(job, PARAM_JOB);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, "out");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_JOB, job)
                .build();
        return caller.download(get(GET_ARTIFACTS_DOWNLOAD, id, refName).withQuery(queryParameters), out);
    }

    /**
     * Get artifacts download ({@code GET /projects/{id}/jobs/artifacts/{ref_name}/download}).
     *
     * @param id the id
     * @param refName the ref name
     * @param job the job
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code refName} or {@code job} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getArtifactsDownload(
            final String id,
            final String refName,
            final String job,
            final GitLabProjectJobsGetArtifactsDownloadFilter filter,
            final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(refName, PARAM_REFNAME);
        requireNotBlank(job, PARAM_JOB);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, "target");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_JOB, job)
                .build();
        return caller.download(get(GET_ARTIFACTS_DOWNLOAD, id, refName).withQuery(queryParameters), target);
    }

    /**
     * Call artifacts raw ({@code GET /projects/{id}/jobs/artifacts/{ref_name}/raw/{artifact_path}}).
     *
     * @param id the id
     * @param refName the ref name
     * @param artifactPath the artifact path
     * @param job the job
     * @throws IllegalArgumentException if {@code id}, {@code refName}, {@code artifactPath} or {@code job} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callArtifactsRaw(final String id, final String refName, final String artifactPath, final String job)
            throws IOException {
        callArtifactsRaw(id, refName, artifactPath, job, GitLabProjectJobsCallArtifactsRawFilter.empty());
    }

    /**
     * Call artifacts raw ({@code GET /projects/{id}/jobs/artifacts/{ref_name}/raw/{artifact_path}}).
     *
     * @param id the id
     * @param refName the ref name
     * @param artifactPath the artifact path
     * @param job the job
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code refName}, {@code artifactPath} or {@code job} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callArtifactsRaw(
            final String id,
            final String refName,
            final String artifactPath,
            final String job,
            final GitLabProjectJobsCallArtifactsRawFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(refName, PARAM_REFNAME);
        requireNotBlank(artifactPath, "artifactPath");
        requireNotBlank(job, PARAM_JOB);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_JOB, job)
                .build();
        caller.send(get(CALL_ARTIFACTS_RAW, id, refName, artifactPath).withQuery(queryParameters));
    }
}
