package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
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

/** The GitLab operations of project jobs artifacts. */
public final class GitLabProjectJobsArtifactsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/jobs/{job_id}/artifacts");
    private static final PathTemplate LIST_TREE = PathTemplate.of("/projects/{id}/jobs/{job_id}/artifacts/tree");
    private static final PathTemplate CALL = PathTemplate.of("/projects/{id}/jobs/{job_id}/artifacts/{artifact_path}");
    private static final PathTemplate KEEP = PathTemplate.of("/projects/{id}/jobs/{job_id}/artifacts/keep");
    private static final JsonType<List<GitLabCiJobArtifactEntry>> CI_JOB_ARTIFACT_ENTRY_LIST_TYPE =
            JsonTypes.listOf(GitLabCiJobArtifactEntry.class);
    private static final GitLabListSpec<GitLabCiJobArtifactEntry> CI_JOB_ARTIFACT_ENTRY_SPEC =
            GitLabListSpec.offset(CI_JOB_ARTIFACT_ENTRY_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectJobsArtifactsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/jobs/{job_id}/artifacts}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long get(final String id, final long jobId, final OutputStream out) throws IOException {
        return get(id, jobId, GitLabProjectJobsArtifactsGetFilter.empty(), out);
    }

    /**
     * Get ({@code GET /projects/{id}/jobs/{job_id}/artifacts}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path get(final String id, final long jobId, final Path target) throws IOException {
        return get(id, jobId, GitLabProjectJobsArtifactsGetFilter.empty(), target);
    }

    /**
     * Get ({@code GET /projects/{id}/jobs/{job_id}/artifacts}).
     *
     * @param id the id
     * @param jobId the job id
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long get(
            final String id, final long jobId, final GitLabProjectJobsArtifactsGetFilter filter, final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, "out");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET, id, jobId).withQuery(queryParameters), out);
    }

    /**
     * Get ({@code GET /projects/{id}/jobs/{job_id}/artifacts}).
     *
     * @param id the id
     * @param jobId the job id
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path get(
            final String id, final long jobId, final GitLabProjectJobsArtifactsGetFilter filter, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, "target");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET, id, jobId).withQuery(queryParameters), target);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/jobs/{job_id}/artifacts}).
     *
     * @param id the id
     * @param jobId the job id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long jobId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, jobId));
    }

    /**
     * List tree ({@code GET /projects/{id}/jobs/{job_id}/artifacts/tree}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobArtifactEntry> listTree(final String id, final long jobId) throws IOException {
        return listTree(id, jobId, GitLabProjectJobsArtifactsListTreeFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List tree ({@code GET /projects/{id}/jobs/{job_id}/artifacts/tree}).
     *
     * @param id the id
     * @param jobId the job id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobArtifactEntry> listTree(
            final String id, final long jobId, final GitLabPageRequest request) throws IOException {
        return listTree(id, jobId, GitLabProjectJobsArtifactsListTreeFilter.empty(), request);
    }

    /**
     * List tree ({@code GET /projects/{id}/jobs/{job_id}/artifacts/tree}).
     *
     * @param id the id
     * @param jobId the job id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobArtifactEntry> listTree(
            final String id, final long jobId, final GitLabProjectJobsArtifactsListTreeFilter filter)
            throws IOException {
        return listTree(id, jobId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List tree ({@code GET /projects/{id}/jobs/{job_id}/artifacts/tree}).
     *
     * @param id the id
     * @param jobId the job id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobArtifactEntry> listTree(
            final String id,
            final long jobId,
            final GitLabProjectJobsArtifactsListTreeFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_TREE, queryParameters, request, CI_JOB_ARTIFACT_ENTRY_SPEC, id, jobId);
    }

    /**
     * Call ({@code GET /projects/{id}/jobs/{job_id}/artifacts/{artifact_path}}).
     *
     * @param id the id
     * @param jobId the job id
     * @param artifactPath the artifact path
     * @throws IllegalArgumentException if {@code id} or {@code artifactPath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id, final long jobId, final String artifactPath) throws IOException {
        call(id, jobId, artifactPath, GitLabProjectJobsArtifactsCallFilter.empty());
    }

    /**
     * Call ({@code GET /projects/{id}/jobs/{job_id}/artifacts/{artifact_path}}).
     *
     * @param id the id
     * @param jobId the job id
     * @param artifactPath the artifact path
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code artifactPath} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(
            final String id,
            final long jobId,
            final String artifactPath,
            final GitLabProjectJobsArtifactsCallFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(artifactPath, "artifactPath");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL, id, jobId, artifactPath).withQuery(queryParameters));
    }

    /**
     * Keep ({@code POST /projects/{id}/jobs/{job_id}/artifacts/keep}).
     *
     * @param id the id
     * @param jobId the job id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJob keep(final String id, final long jobId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(KEEP, id, jobId), GitLabCiJob.class);
    }
}
