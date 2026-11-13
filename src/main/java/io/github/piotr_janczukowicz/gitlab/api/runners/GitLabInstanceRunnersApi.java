package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunner;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerController;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerManager;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerRegistrationDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerWithUuid;
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
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of instance runners. */
public final class GitLabInstanceRunnersApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_TOKEN = "token";
    private static final PathTemplate LIST_RUNNER_CONTROLLERS = PathTemplate.of("/runner_controllers");
    private static final PathTemplate LIST = PathTemplate.of("/runners");
    private static final PathTemplate LIST_ALL = PathTemplate.of("/runners/all");
    private static final PathTemplate GET = PathTemplate.of("/runners/{id}");
    private static final PathTemplate LIST_MANAGERS = PathTemplate.of("/runners/{id}/managers");
    private static final PathTemplate LIST_PROJECTS = PathTemplate.of("/runners/{id}/projects");
    private static final PathTemplate LIST_JOBS = PathTemplate.of("/runners/{id}/jobs");
    private static final PathTemplate RESET_AUTHENTICATION_TOKEN_BY_ID =
            PathTemplate.of("/runners/{id}/reset_authentication_token");
    private static final PathTemplate RESET_REGISTRATION_TOKEN = PathTemplate.of("/runners/reset_registration_token");
    private static final PathTemplate DELETE_MANAGER = PathTemplate.of("/runners/managers");
    private static final PathTemplate VERIFY = PathTemplate.of("/runners/verify");
    private static final PathTemplate RESET_AUTHENTICATION_TOKEN =
            PathTemplate.of("/runners/reset_authentication_token");
    private static final PathTemplate GET_ROUTER_DISCOVERY = PathTemplate.of("/runners/router/discovery");
    private static final JsonType<List<GitLabCiRunnerController>> CI_RUNNER_CONTROLLER_LIST_TYPE =
            JsonTypes.listOf(GitLabCiRunnerController.class);
    private static final JsonType<List<GitLabCiRunnerWithUuid>> CI_RUNNER_WITH_UUID_LIST_TYPE =
            JsonTypes.listOf(GitLabCiRunnerWithUuid.class);
    private static final JsonType<List<GitLabCiRunnerManager>> CI_RUNNER_MANAGER_LIST_TYPE =
            JsonTypes.listOf(GitLabCiRunnerManager.class);
    private static final JsonType<List<GitLabBasicProjectDetails>> BASIC_PROJECT_DETAILS_LIST_TYPE =
            JsonTypes.listOf(GitLabBasicProjectDetails.class);
    private static final JsonType<List<GitLabCiJobBasicWithProject>> CI_JOB_BASIC_WITH_PROJECT_LIST_TYPE =
            JsonTypes.listOf(GitLabCiJobBasicWithProject.class);
    private static final GitLabListSpec<GitLabCiRunnerController> CI_RUNNER_CONTROLLER_SPEC =
            GitLabListSpec.offset(CI_RUNNER_CONTROLLER_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiRunnerWithUuid> CI_RUNNER_WITH_UUID_SPEC =
            GitLabListSpec.offset(CI_RUNNER_WITH_UUID_LIST_TYPE);
    private static final GitLabListSpec<GitLabBasicProjectDetails> BASIC_PROJECT_DETAILS_SPEC =
            GitLabListSpec.offset(BASIC_PROJECT_DETAILS_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiJobBasicWithProject> CI_JOB_BASIC_WITH_PROJECT_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(CI_JOB_BASIC_WITH_PROJECT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceRunnersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List runner controllers ({@code GET /runner_controllers}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabCiRunnerController> listRunnerControllers() throws IOException {
        return listRunnerControllers(GitLabPageRequest.byPage());
    }

    /**
     * List runner controllers ({@code GET /runner_controllers}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabCiRunnerController> listRunnerControllers(final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4RunnerControllers");
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_RUNNER_CONTROLLERS, Map.of(), request, CI_RUNNER_CONTROLLER_SPEC);
    }

    /**
     * List ({@code GET /runners}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list() throws IOException {
        return list(GitLabInstanceRunnersListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /runners}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabInstanceRunnersListFilter.empty(), request);
    }

    /**
     * List ({@code GET /runners}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(final GitLabInstanceRunnersListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /runners}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(
            final GitLabInstanceRunnersListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, CI_RUNNER_WITH_UUID_SPEC);
    }

    /**
     * Create ({@code POST /runners}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiRunnerRegistrationDetails create(final GitLabInstanceRunnersCreatePayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST), payload), GitLabCiRunnerRegistrationDetails.class);
    }

    /**
     * Delete ({@code DELETE /runners}).
     *
     * @param token the token
     * @throws IllegalArgumentException if {@code token} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String token) throws IOException {
        requireNotBlank(token, PARAM_TOKEN);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_TOKEN, token).build();
        caller.send(delete(LIST).withQuery(queryParameters));
    }

    /**
     * List all ({@code GET /runners/all}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listAll() throws IOException {
        return listAll(GitLabInstanceRunnersListAllFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List all ({@code GET /runners/all}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listAll(final GitLabPageRequest request) throws IOException {
        return listAll(GitLabInstanceRunnersListAllFilter.empty(), request);
    }

    /**
     * List all ({@code GET /runners/all}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listAll(final GitLabInstanceRunnersListAllFilter filter)
            throws IOException {
        return listAll(filter, GitLabPageRequest.byPage());
    }

    /**
     * List all ({@code GET /runners/all}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listAll(
            final GitLabInstanceRunnersListAllFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ALL, queryParameters, request, CI_RUNNER_WITH_UUID_SPEC);
    }

    /**
     * Get ({@code GET /runners/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiRunnerDetails> get(final long id) throws IOException {
        return get(id, GitLabInstanceRunnersGetFilter.empty());
    }

    /**
     * Get ({@code GET /runners/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiRunnerDetails> get(final long id, final GitLabInstanceRunnersGetFilter filter)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id).withQuery(queryParameters), GitLabCiRunnerDetails.class);
    }

    /**
     * Update ({@code PUT /runners/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiRunnerDetails update(final long id, final GitLabInstanceRunnersUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id), payload), GitLabCiRunnerDetails.class);
    }

    /**
     * Delete by id ({@code DELETE /runners/{id}}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiRunner> deleteById(final long id) throws IOException {
        return caller.fetchOptional(delete(GET, id), GitLabCiRunner.class);
    }

    /**
     * List managers ({@code GET /runners/{id}/managers}).
     *
     * @param id the id
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabCiRunnerManager> listManagers(final long id) throws IOException {
        return caller.fetch(get(LIST_MANAGERS, id), CI_RUNNER_MANAGER_LIST_TYPE);
    }

    /**
     * List projects ({@code GET /runners/{id}/projects}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicProjectDetails> listProjects(final long id) throws IOException {
        return listProjects(id, GitLabPageRequest.byPage());
    }

    /**
     * List projects ({@code GET /runners/{id}/projects}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicProjectDetails> listProjects(final long id, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_PROJECTS, Map.of(), request, BASIC_PROJECT_DETAILS_SPEC, id);
    }

    /**
     * List jobs ({@code GET /runners/{id}/jobs}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobBasicWithProject> listJobs(final long id) throws IOException {
        return listJobs(id, GitLabInstanceRunnersListJobsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List jobs ({@code GET /runners/{id}/jobs}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobBasicWithProject> listJobs(final long id, final GitLabPageRequest request)
            throws IOException {
        return listJobs(id, GitLabInstanceRunnersListJobsFilter.empty(), request);
    }

    /**
     * List jobs ({@code GET /runners/{id}/jobs}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobBasicWithProject> listJobs(
            final long id, final GitLabInstanceRunnersListJobsFilter filter) throws IOException {
        return listJobs(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List jobs ({@code GET /runners/{id}/jobs}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobBasicWithProject> listJobs(
            final long id, final GitLabInstanceRunnersListJobsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_JOBS, queryParameters, request, CI_JOB_BASIC_WITH_PROJECT_KEYSET_SPEC, id);
    }

    /**
     * Reset authentication token by id ({@code POST /runners/{id}/reset_authentication_token}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiResetTokenResult resetAuthenticationTokenById(final long id) throws IOException {
        return caller.fetch(post(RESET_AUTHENTICATION_TOKEN_BY_ID, id), GitLabCiResetTokenResult.class);
    }

    /**
     * Reset registration token ({@code POST /runners/reset_registration_token}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiResetTokenResult resetRegistrationToken() throws IOException {
        return caller.fetch(post(RESET_REGISTRATION_TOKEN), GitLabCiResetTokenResult.class);
    }

    /**
     * Delete manager ({@code DELETE /runners/managers}).
     *
     * @param token the token
     * @param systemId the system id
     * @throws IllegalArgumentException if {@code token} or {@code systemId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteManager(final String token, final String systemId) throws IOException {
        requireNotBlank(token, PARAM_TOKEN);
        requireNotBlank(systemId, "systemId");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_TOKEN, token)
                .text("system_id", systemId)
                .build();
        caller.send(delete(DELETE_MANAGER).withQuery(queryParameters));
    }

    /**
     * Verify ({@code POST /runners/verify}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiRunnerRegistrationDetails verify(final GitLabInstanceRunnersVerifyPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(VERIFY), payload), GitLabCiRunnerRegistrationDetails.class);
    }

    /**
     * Reset authentication token ({@code POST /runners/reset_authentication_token}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiResetTokenResult resetAuthenticationToken(
            final GitLabInstanceRunnersResetAuthenticationTokenPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(RESET_AUTHENTICATION_TOKEN), payload), GitLabCiResetTokenResult.class);
    }

    /**
     * Get router discovery ({@code GET /runners/router/discovery}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiJobRouterDiscoveryInformation getRouterDiscovery() throws IOException {
        return caller.fetch(get(GET_ROUTER_DISCOVERY), GitLabCiJobRouterDiscoveryInformation.class);
    }
}
