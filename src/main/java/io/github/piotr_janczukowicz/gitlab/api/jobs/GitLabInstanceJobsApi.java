package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of instance jobs. */
public final class GitLabInstanceJobsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate REQUEST = PathTemplate.of("/jobs/request");
    private static final PathTemplate UPDATE = PathTemplate.of("/jobs/{id}");
    private static final PathTemplate GET_RUNTIME_ENVIRONMENT_KEY =
            PathTemplate.of("/jobs/{id}/runtime_environment_key");
    private static final PathTemplate TRACE = PathTemplate.of("/jobs/{id}/trace");
    private static final PathTemplate AUTHORIZE_ARTIFACT = PathTemplate.of("/jobs/{id}/artifacts/authorize");
    private static final PathTemplate GET_ARTIFACTS = PathTemplate.of("/jobs/{id}/artifacts");
    private static final PathTemplate GET = PathTemplate.of("/job");
    private static final PathTemplate GET_ALLOWED_AGENTS = PathTemplate.of("/job/allowed_agents");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceJobsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Request ({@code POST /jobs/request}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJobRequestResponse request(final GitLabInstanceJobsRequestPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(REQUEST), payload), GitLabCiJobRequestResponse.class);
    }

    /**
     * Update ({@code PUT /jobs/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final long id, final GitLabInstanceJobsUpdatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE, id), payload));
    }

    /**
     * Get runtime environment key ({@code GET /jobs/{id}/runtime_environment_key}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiRuntimeEnvironmentKey> getRuntimeEnvironmentKey(final long id) throws IOException {
        return getRuntimeEnvironmentKey(id, GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter.empty());
    }

    /**
     * Get runtime environment key ({@code GET /jobs/{id}/runtime_environment_key}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiRuntimeEnvironmentKey> getRuntimeEnvironmentKey(
            final long id, final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET_RUNTIME_ENVIRONMENT_KEY, id).withQuery(queryParameters), GitLabCiRuntimeEnvironmentKey.class);
    }

    /**
     * Trace ({@code PATCH /jobs/{id}/trace}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void trace(final long id, final GitLabInstanceJobsTracePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(patch(TRACE, id), payload));
    }

    /**
     * Authorize artifact ({@code POST /jobs/{id}/artifacts/authorize}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeArtifact(final long id, final GitLabInstanceJobsAuthorizeArtifactPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(AUTHORIZE_ARTIFACT, id), payload));
    }

    /**
     * Get artifacts ({@code GET /jobs/{id}/artifacts}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getArtifacts(final long id, final OutputStream out) throws IOException {
        return getArtifacts(id, GitLabInstanceJobsGetArtifactsFilter.empty(), out);
    }

    /**
     * Get artifacts ({@code GET /jobs/{id}/artifacts}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getArtifacts(final long id, final Path target) throws IOException {
        return getArtifacts(id, GitLabInstanceJobsGetArtifactsFilter.empty(), target);
    }

    /**
     * Get artifacts ({@code GET /jobs/{id}/artifacts}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getArtifacts(final long id, final GitLabInstanceJobsGetArtifactsFilter filter, final OutputStream out)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, "out");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_ARTIFACTS, id).withQuery(queryParameters), out);
    }

    /**
     * Get artifacts ({@code GET /jobs/{id}/artifacts}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getArtifacts(final long id, final GitLabInstanceJobsGetArtifactsFilter filter, final Path target)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, "target");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_ARTIFACTS, id).withQuery(queryParameters), target);
    }

    /**
     * Create artifact ({@code POST /jobs/{id}/artifacts}).
     *
     * @param id the id
     * @param form the form to send
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createArtifact(final long id, final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        caller.send(caller.multipart(post(GET_ARTIFACTS, id), form));
    }

    /**
     * Get ({@code GET /job}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJob get() throws IOException {
        return caller.fetch(get(GET), GitLabCiJob.class);
    }

    /**
     * Get allowed agents ({@code GET /job/allowed_agents}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJob getAllowedAgents() throws IOException {
        return caller.fetch(get(GET_ALLOWED_AGENTS), GitLabCiJob.class);
    }
}
