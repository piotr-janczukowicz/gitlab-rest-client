package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of project merge trains. */
public final class GitLabProjectMergeTrainsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/merge_trains");
    private static final PathTemplate LIST_BY_TARGET_BRANCH =
            PathTemplate.of("/projects/{id}/merge_trains/{target_branch}");
    private static final PathTemplate GET_MERGE_REQUEST =
            PathTemplate.of("/projects/{id}/merge_trains/merge_requests/{merge_request_iid}");
    private static final JsonType<List<GitLabMergeTrainsCar>> MERGE_TRAINS_CAR_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeTrainsCar.class);
    private static final GitLabListSpec<GitLabMergeTrainsCar> MERGE_TRAINS_CAR_SPEC =
            GitLabListSpec.offset(MERGE_TRAINS_CAR_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMergeTrainsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/merge_trains}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeTrainsCar> list(final String id) throws IOException {
        return list(id, GitLabProjectMergeTrainsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/merge_trains}).
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
    public GitLabPage<GitLabMergeTrainsCar> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectMergeTrainsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/merge_trains}).
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
    public GitLabPage<GitLabMergeTrainsCar> list(final String id, final GitLabProjectMergeTrainsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/merge_trains}).
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
    public GitLabPage<GitLabMergeTrainsCar> list(
            final String id, final GitLabProjectMergeTrainsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeTrains");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, MERGE_TRAINS_CAR_SPEC, id);
    }

    /**
     * List by target branch ({@code GET /projects/{id}/merge_trains/{target_branch}}).
     *
     * @param id the id
     * @param targetBranch the target branch
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code targetBranch} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeTrainsCar> listByTargetBranch(final String id, final String targetBranch)
            throws IOException {
        return listByTargetBranch(
                id, targetBranch, GitLabProjectMergeTrainsListByTargetBranchFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List by target branch ({@code GET /projects/{id}/merge_trains/{target_branch}}).
     *
     * @param id the id
     * @param targetBranch the target branch
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code targetBranch} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeTrainsCar> listByTargetBranch(
            final String id, final String targetBranch, final GitLabPageRequest request) throws IOException {
        return listByTargetBranch(id, targetBranch, GitLabProjectMergeTrainsListByTargetBranchFilter.empty(), request);
    }

    /**
     * List by target branch ({@code GET /projects/{id}/merge_trains/{target_branch}}).
     *
     * @param id the id
     * @param targetBranch the target branch
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code targetBranch} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeTrainsCar> listByTargetBranch(
            final String id, final String targetBranch, final GitLabProjectMergeTrainsListByTargetBranchFilter filter)
            throws IOException {
        return listByTargetBranch(id, targetBranch, filter, GitLabPageRequest.byPage());
    }

    /**
     * List by target branch ({@code GET /projects/{id}/merge_trains/{target_branch}}).
     *
     * @param id the id
     * @param targetBranch the target branch
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code targetBranch} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeTrainsCar> listByTargetBranch(
            final String id,
            final String targetBranch,
            final GitLabProjectMergeTrainsListByTargetBranchFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeTrainsTargetBranch");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(targetBranch, "targetBranch");
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_BY_TARGET_BRANCH, queryParameters, request, MERGE_TRAINS_CAR_SPEC, id, targetBranch);
    }

    /**
     * Get merge request ({@code GET /projects/{id}/merge_trains/merge_requests/{merge_request_iid}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabMergeTrainsCar> getMergeRequest(final String id, final long mergeRequestIid)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeTrainsMergeRequestsMergeRequestIid");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_MERGE_REQUEST, id, mergeRequestIid), GitLabMergeTrainsCar.class);
    }

    /**
     * Create merge request ({@code POST /projects/{id}/merge_trains/merge_requests/{merge_request_iid}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabMergeTrainsCar> createMergeRequest(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectMergeTrainsCreateMergeRequestPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdMergeTrainsMergeRequestsMergeRequestIid");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(post(GET_MERGE_REQUEST, id, mergeRequestIid), payload), MERGE_TRAINS_CAR_LIST_TYPE);
    }
}
