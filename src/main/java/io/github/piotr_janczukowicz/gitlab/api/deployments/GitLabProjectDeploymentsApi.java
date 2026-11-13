package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployment;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
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

/** The GitLab operations of project deployments. */
public final class GitLabProjectDeploymentsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/deployments");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/deployments/{deployment_id}");
    private static final PathTemplate LIST_MERGE_REQUESTS =
            PathTemplate.of("/projects/{id}/deployments/{deployment_id}/merge_requests");
    private static final PathTemplate APPROVAL = PathTemplate.of("/projects/{id}/deployments/{deployment_id}/approval");
    private static final JsonType<List<GitLabDeployment>> DEPLOYMENT_LIST_TYPE =
            JsonTypes.listOf(GitLabDeployment.class);
    private static final JsonType<List<GitLabMergeRequestBasic>> MERGE_REQUEST_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestBasic.class);
    private static final GitLabListSpec<GitLabDeployment> DEPLOYMENT_SPEC = GitLabListSpec.offset(DEPLOYMENT_LIST_TYPE);
    private static final GitLabListSpec<GitLabMergeRequestBasic> MERGE_REQUEST_BASIC_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDeploymentsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/deployments}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployment> list(final String id) throws IOException {
        return list(id, GitLabProjectDeploymentsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/deployments}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployment> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectDeploymentsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/deployments}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployment> list(final String id, final GitLabProjectDeploymentsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/deployments}).
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
    public GitLabPage<GitLabDeployment> list(
            final String id, final GitLabProjectDeploymentsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, DEPLOYMENT_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/deployments}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDeploymentExtended create(final String id, final GitLabProjectDeploymentsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabDeploymentExtended.class);
    }

    /**
     * Get ({@code GET /projects/{id}/deployments/{deployment_id}}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDeploymentExtended> get(final String id, final long deploymentId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, deploymentId), GitLabDeploymentExtended.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/deployments/{deployment_id}}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDeploymentExtended update(
            final String id, final long deploymentId, final GitLabProjectDeploymentsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, deploymentId), payload), GitLabDeploymentExtended.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/deployments/{deployment_id}}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long deploymentId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, deploymentId));
    }

    /**
     * List merge requests ({@code GET /projects/{id}/deployments/{deployment_id}/merge_requests}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(final String id, final long deploymentId)
            throws IOException {
        return listMergeRequests(
                id, deploymentId, GitLabProjectDeploymentsListMergeRequestsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List merge requests ({@code GET /projects/{id}/deployments/{deployment_id}/merge_requests}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id, final long deploymentId, final GitLabPageRequest request) throws IOException {
        return listMergeRequests(id, deploymentId, GitLabProjectDeploymentsListMergeRequestsFilter.empty(), request);
    }

    /**
     * List merge requests ({@code GET /projects/{id}/deployments/{deployment_id}/merge_requests}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id, final long deploymentId, final GitLabProjectDeploymentsListMergeRequestsFilter filter)
            throws IOException {
        return listMergeRequests(id, deploymentId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List merge requests ({@code GET /projects/{id}/deployments/{deployment_id}/merge_requests}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id,
            final long deploymentId,
            final GitLabProjectDeploymentsListMergeRequestsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_MERGE_REQUESTS, queryParameters, request, MERGE_REQUEST_BASIC_SPEC, id, deploymentId);
    }

    /**
     * Approval ({@code POST /projects/{id}/deployments/{deployment_id}/approval}).
     *
     * @param id the id
     * @param deploymentId the deployment id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabDeploymentApproval approval(
            final String id, final long deploymentId, final GitLabProjectDeploymentsApprovalPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdDeploymentsDeploymentIdApproval");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(APPROVAL, id, deploymentId), payload), GitLabDeploymentApproval.class);
    }
}
