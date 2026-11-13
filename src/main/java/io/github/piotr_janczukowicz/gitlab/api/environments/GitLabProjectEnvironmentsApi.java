package io.github.piotr_janczukowicz.gitlab.api.environments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEnvironmentBasic;
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

/** The GitLab operations of project environments. */
public final class GitLabProjectEnvironmentsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/environments");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/environments/{environment_id}");
    private static final PathTemplate DELETE_REVIEW_APP = PathTemplate.of("/projects/{id}/environments/review_apps");
    private static final PathTemplate STOP = PathTemplate.of("/projects/{id}/environments/{environment_id}/stop");
    private static final PathTemplate STOP_STALE = PathTemplate.of("/projects/{id}/environments/stop_stale");
    private static final JsonType<List<GitLabEnvironment>> ENVIRONMENT_LIST_TYPE =
            JsonTypes.listOf(GitLabEnvironment.class);
    private static final GitLabListSpec<GitLabEnvironment> ENVIRONMENT_SPEC =
            GitLabListSpec.offset(ENVIRONMENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectEnvironmentsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/environments}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEnvironment> list(final String id) throws IOException {
        return list(id, GitLabProjectEnvironmentsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/environments}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEnvironment> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectEnvironmentsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/environments}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEnvironment> list(final String id, final GitLabProjectEnvironmentsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/environments}).
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
    public GitLabPage<GitLabEnvironment> list(
            final String id, final GitLabProjectEnvironmentsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, ENVIRONMENT_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/environments}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabEnvironment create(final String id, final GitLabProjectEnvironmentsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabEnvironment.class);
    }

    /**
     * Get ({@code GET /projects/{id}/environments/{environment_id}}).
     *
     * @param id the id
     * @param environmentId the environment id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEnvironment> get(final String id, final long environmentId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, environmentId), GitLabEnvironment.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/environments/{environment_id}}).
     *
     * @param id the id
     * @param environmentId the environment id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabEnvironment update(
            final String id, final long environmentId, final GitLabProjectEnvironmentsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, environmentId), payload), GitLabEnvironment.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/environments/{environment_id}}).
     *
     * @param id the id
     * @param environmentId the environment id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEnvironment> delete(final String id, final long environmentId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET, id, environmentId), GitLabEnvironment.class);
    }

    /**
     * Delete review app ({@code DELETE /projects/{id}/environments/review_apps}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEnvironmentBasic> deleteReviewApp(final String id) throws IOException {
        return deleteReviewApp(id, GitLabProjectEnvironmentsDeleteReviewAppFilter.empty());
    }

    /**
     * Delete review app ({@code DELETE /projects/{id}/environments/review_apps}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEnvironmentBasic> deleteReviewApp(
            final String id, final GitLabProjectEnvironmentsDeleteReviewAppFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOptional(
                delete(DELETE_REVIEW_APP, id).withQuery(queryParameters), GitLabEnvironmentBasic.class);
    }

    /**
     * Stop ({@code POST /projects/{id}/environments/{environment_id}/stop}).
     *
     * @param id the id
     * @param environmentId the environment id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabEnvironment stop(
            final String id, final long environmentId, final GitLabProjectEnvironmentsStopPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(STOP, id, environmentId), payload), GitLabEnvironment.class);
    }

    /**
     * Stop stale ({@code POST /projects/{id}/environments/stop_stale}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void stopStale(final String id, final GitLabProjectEnvironmentsStopStalePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(STOP_STALE, id), payload));
    }
}
