package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssuableTimeStats;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssueBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequest;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestApprovals;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
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
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project merge requests. */
public final class GitLabProjectMergeRequestsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_BLOCKS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/blocks");
    private static final PathTemplate CALL_BLOCK =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/blocks/{block_id}");
    private static final PathTemplate LIST_BLOCKEES =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/blockees");
    private static final PathTemplate CREATE_STATUS_CHECK_RESPONSE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/status_check_responses");
    private static final PathTemplate CREATE_SUGGESTED_REVIEWER =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/suggested_reviewers");
    private static final PathTemplate TODO = PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/todo");
    private static final PathTemplate SUBSCRIBE =
            PathTemplate.of("/projects/{id}/merge_requests/{subscribable_id}/subscribe");
    private static final PathTemplate UNSUBSCRIBE =
            PathTemplate.of("/projects/{id}/merge_requests/{subscribable_id}/unsubscribe");
    private static final PathTemplate LIST_VERSIONS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/versions");
    private static final PathTemplate GET_VERSION =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/versions/{version_id}");
    private static final PathTemplate APPROVE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/approve");
    private static final PathTemplate UNAPPROVE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/unapprove");
    private static final PathTemplate UPDATE_RESET_APPROVAL =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/reset_approvals");
    private static final PathTemplate GET_APPROVAL_STATE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/approval_state");
    private static final PathTemplate TIME_ESTIMATE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/time_estimate");
    private static final PathTemplate RESET_TIME_ESTIMATE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/reset_time_estimate");
    private static final PathTemplate ADD_SPENT_TIME =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/add_spent_time");
    private static final PathTemplate RESET_SPENT_TIME =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/reset_spent_time");
    private static final PathTemplate GET_TIME_STATS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/time_stats");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/merge_requests");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}");
    private static final PathTemplate LIST_PARTICIPANTS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/participants");
    private static final PathTemplate LIST_REVIEWERS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/reviewers");
    private static final PathTemplate LIST_COMMITS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/commits");
    private static final PathTemplate GET_CHANGES =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/changes");
    private static final PathTemplate LIST_DIFFS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/diffs");
    private static final PathTemplate CALL_RAW_DIFFS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/raw_diffs");
    private static final PathTemplate LIST_PIPELINES =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/pipelines");
    private static final PathTemplate MERGE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/merge");
    private static final PathTemplate CALL_MERGE_REF =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/merge_ref");
    private static final PathTemplate CREATE_CANCEL_MERGE_WHEN_PIPELINE_SUCCEE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/cancel_merge_when_pipeline_succeeds");
    private static final PathTemplate CANCEL_AUTO_MERGE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/cancel_auto_merge");
    private static final PathTemplate REBASE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/rebase");
    private static final PathTemplate LIST_CLOSES_ISSUES =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/closes_issues");
    private static final PathTemplate CALL_RELATED_ISSUES =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/related_issues");
    private static final JsonType<List<GitLabMergeRequestDependency>> MERGE_REQUEST_DEPENDENCY_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestDependency.class);
    private static final JsonType<List<GitLabAiSuggestedReviewer>> AI_SUGGESTED_REVIEWER_LIST_TYPE =
            JsonTypes.listOf(GitLabAiSuggestedReviewer.class);
    private static final JsonType<List<GitLabMergeRequestDiff>> MERGE_REQUEST_DIFF_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestDiff.class);
    private static final JsonType<List<GitLabMergeRequestBasic>> MERGE_REQUEST_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestBasic.class);
    private static final JsonType<List<GitLabUserBasic>> USER_BASIC_LIST_TYPE = JsonTypes.listOf(GitLabUserBasic.class);
    private static final JsonType<List<GitLabMergeRequestReviewer>> MERGE_REQUEST_REVIEWER_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestReviewer.class);
    private static final JsonType<List<GitLabCommit>> COMMIT_LIST_TYPE = JsonTypes.listOf(GitLabCommit.class);
    private static final JsonType<List<GitLabDiff>> DIFF_LIST_TYPE = JsonTypes.listOf(GitLabDiff.class);
    private static final JsonType<List<GitLabCiPipelineBasic>> CI_PIPELINE_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabCiPipelineBasic.class);
    private static final JsonType<List<GitLabIssueBasic>> ISSUE_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabIssueBasic.class);
    private static final GitLabListSpec<GitLabMergeRequestDependency> MERGE_REQUEST_DEPENDENCY_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_DEPENDENCY_LIST_TYPE);
    private static final GitLabListSpec<GitLabMergeRequestDiff> MERGE_REQUEST_DIFF_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_DIFF_LIST_TYPE);
    private static final GitLabListSpec<GitLabMergeRequestBasic> MERGE_REQUEST_BASIC_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_BASIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabCommit> COMMIT_SPEC = GitLabListSpec.offset(COMMIT_LIST_TYPE);
    private static final GitLabListSpec<GitLabDiff> DIFF_SPEC = GitLabListSpec.offset(DIFF_LIST_TYPE);
    private static final GitLabListSpec<GitLabIssueBasic> ISSUE_BASIC_SPEC =
            GitLabListSpec.offset(ISSUE_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMergeRequestsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List blocks ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/blocks}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestDependency> listBlocks(final String id, final long mergeRequestIid)
            throws IOException {
        return listBlocks(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List blocks ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/blocks}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestDependency> listBlocks(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_BLOCKS, Map.of(), request, MERGE_REQUEST_DEPENDENCY_SPEC, id, mergeRequestIid);
    }

    /**
     * Create block ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/blocks}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createBlock(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsCreateBlockPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(LIST_BLOCKS, id, mergeRequestIid), payload));
    }

    /**
     * Call block ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/blocks/{block_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param blockId the block id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callBlock(final String id, final long mergeRequestIid, final long blockId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_BLOCK, id, mergeRequestIid, blockId));
    }

    /**
     * Delete block ({@code DELETE /projects/{id}/merge_requests/{merge_request_iid}/blocks/{block_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param blockId the block id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteBlock(final String id, final long mergeRequestIid, final long blockId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(CALL_BLOCK, id, mergeRequestIid, blockId));
    }

    /**
     * List blockees ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/blockees}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestDependency> listBlockees(final String id, final long mergeRequestIid)
            throws IOException {
        return listBlockees(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List blockees ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/blockees}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestDependency> listBlockees(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_BLOCKEES, Map.of(), request, MERGE_REQUEST_DEPENDENCY_SPEC, id, mergeRequestIid);
    }

    /**
     * Create status check response ({@code POST
     * /projects/{id}/merge_requests/{merge_request_iid}/status_check_responses}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabMergeRequestsStatusCheckResponse createStatusCheckResponse(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectMergeRequestsCreateStatusCheckResponsePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdMergeRequestsMergeRequestIidStatusCheckResponses");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_STATUS_CHECK_RESPONSE, id, mergeRequestIid), payload),
                GitLabMergeRequestsStatusCheckResponse.class);
    }

    /**
     * Create suggested reviewer ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/suggested_reviewers}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabAiSuggestedReviewer> createSuggestedReviewer(
            final String id, final long mergeRequestIid, final GitLabProjectSuggestedReviewerCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_SUGGESTED_REVIEWER, id, mergeRequestIid), payload),
                AI_SUGGESTED_REVIEWER_LIST_TYPE);
    }

    /**
     * Todo ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/todo}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabTodo todo(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(TODO, id, mergeRequestIid), GitLabTodo.class);
    }

    /**
     * Subscribe ({@code POST /projects/{id}/merge_requests/{subscribable_id}/subscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest subscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(SUBSCRIBE, id, subscribableId), GitLabMergeRequest.class);
    }

    /**
     * Unsubscribe ({@code POST /projects/{id}/merge_requests/{subscribable_id}/unsubscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest unsubscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(UNSUBSCRIBE, id, subscribableId), GitLabMergeRequest.class);
    }

    /**
     * List versions ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/versions}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestDiff> listVersions(final String id, final long mergeRequestIid)
            throws IOException {
        return listVersions(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List versions ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/versions}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestDiff> listVersions(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_VERSIONS, Map.of(), request, MERGE_REQUEST_DIFF_SPEC, id, mergeRequestIid);
    }

    /**
     * Get version ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/versions/{version_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param versionId the version id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMergeRequestDiffFull> getVersion(
            final String id, final long mergeRequestIid, final long versionId) throws IOException {
        return getVersion(id, mergeRequestIid, versionId, GitLabProjectMergeRequestsGetVersionFilter.empty());
    }

    /**
     * Get version ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/versions/{version_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param versionId the version id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMergeRequestDiffFull> getVersion(
            final String id,
            final long mergeRequestIid,
            final long versionId,
            final GitLabProjectMergeRequestsGetVersionFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET_VERSION, id, mergeRequestIid, versionId).withQuery(queryParameters),
                GitLabMergeRequestDiffFull.class);
    }

    /**
     * Approve ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/approve}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequestApprovals approve(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsApprovePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(APPROVE, id, mergeRequestIid), payload), GitLabMergeRequestApprovals.class);
    }

    /**
     * Unapprove ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/unapprove}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequestApprovals unapprove(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(UNAPPROVE, id, mergeRequestIid), GitLabMergeRequestApprovals.class);
    }

    /**
     * Update reset approval ({@code PUT /projects/{id}/merge_requests/{merge_request_iid}/reset_approvals}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateResetApproval(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(put(UPDATE_RESET_APPROVAL, id, mergeRequestIid));
    }

    /**
     * Get approval state ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/approval_state}).
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
    public Optional<GitLabMergeRequestApprovalState> getApprovalState(final String id, final long mergeRequestIid)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalState");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_APPROVAL_STATE, id, mergeRequestIid), GitLabMergeRequestApprovalState.class);
    }

    /**
     * Time estimate ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/time_estimate}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats timeEstimate(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsTimeEstimatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(TIME_ESTIMATE, id, mergeRequestIid), payload), GitLabIssuableTimeStats.class);
    }

    /**
     * Reset time estimate ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/reset_time_estimate}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats resetTimeEstimate(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESET_TIME_ESTIMATE, id, mergeRequestIid), GitLabIssuableTimeStats.class);
    }

    /**
     * Add spent time ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/add_spent_time}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats addSpentTime(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsAddSpentTimePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(ADD_SPENT_TIME, id, mergeRequestIid), payload), GitLabIssuableTimeStats.class);
    }

    /**
     * Reset spent time ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/reset_spent_time}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats resetSpentTime(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESET_SPENT_TIME, id, mergeRequestIid), GitLabIssuableTimeStats.class);
    }

    /**
     * Get time stats ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/time_stats}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssuableTimeStats> getTimeStats(final String id, final long mergeRequestIid)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_TIME_STATS, id, mergeRequestIid), GitLabIssuableTimeStats.class);
    }

    /**
     * List ({@code GET /projects/{id}/merge_requests}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> list(final String id) throws IOException {
        return list(id, GitLabProjectMergeRequestsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/merge_requests}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabProjectMergeRequestsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/merge_requests}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> list(final String id, final GitLabProjectMergeRequestsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/merge_requests}).
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
    public GitLabPage<GitLabMergeRequestBasic> list(
            final String id, final GitLabProjectMergeRequestsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, MERGE_REQUEST_BASIC_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/merge_requests}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest create(final String id, final GitLabProjectMergeRequestsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabMergeRequest.class);
    }

    /**
     * Get ({@code GET /projects/{id}/merge_requests/{merge_request_iid}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMergeRequest> get(final String id, final long mergeRequestIid) throws IOException {
        return get(id, mergeRequestIid, GitLabProjectMergeRequestsGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}/merge_requests/{merge_request_iid}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMergeRequest> get(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsGetFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, mergeRequestIid).withQuery(queryParameters), GitLabMergeRequest.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/merge_requests/{merge_request_iid}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest update(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, mergeRequestIid), payload), GitLabMergeRequest.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/merge_requests/{merge_request_iid}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, mergeRequestIid));
    }

    /**
     * List participants ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/participants}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabUserBasic> listParticipants(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_PARTICIPANTS, id, mergeRequestIid), USER_BASIC_LIST_TYPE);
    }

    /**
     * List reviewers ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/reviewers}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabMergeRequestReviewer> listReviewers(final String id, final long mergeRequestIid)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_REVIEWERS, id, mergeRequestIid), MERGE_REQUEST_REVIEWER_LIST_TYPE);
    }

    /**
     * List commits ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/commits}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommit> listCommits(final String id, final long mergeRequestIid) throws IOException {
        return listCommits(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List commits ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/commits}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommit> listCommits(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_COMMITS, Map.of(), request, COMMIT_SPEC, id, mergeRequestIid);
    }

    /**
     * Get changes ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/changes}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public Optional<GitLabMergeRequestChanges> getChanges(final String id, final long mergeRequestIid)
            throws IOException {
        return getChanges(id, mergeRequestIid, GitLabProjectMergeRequestsGetChangesFilter.empty());
    }

    /**
     * Get changes ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/changes}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public Optional<GitLabMergeRequestChanges> getChanges(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsGetChangesFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET_CHANGES, id, mergeRequestIid).withQuery(queryParameters), GitLabMergeRequestChanges.class);
    }

    /**
     * List diffs ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/diffs}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiffs(final String id, final long mergeRequestIid) throws IOException {
        return listDiffs(
                id, mergeRequestIid, GitLabProjectMergeRequestsListDiffsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List diffs ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/diffs}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiffs(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        return listDiffs(id, mergeRequestIid, GitLabProjectMergeRequestsListDiffsFilter.empty(), request);
    }

    /**
     * List diffs ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/diffs}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiffs(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsListDiffsFilter filter)
            throws IOException {
        return listDiffs(id, mergeRequestIid, filter, GitLabPageRequest.byPage());
    }

    /**
     * List diffs ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/diffs}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiffs(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectMergeRequestsListDiffsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_DIFFS, queryParameters, request, DIFF_SPEC, id, mergeRequestIid);
    }

    /**
     * Call raw diffs ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/raw_diffs}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callRawDiffs(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_RAW_DIFFS, id, mergeRequestIid));
    }

    /**
     * List pipelines ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/pipelines}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabCiPipelineBasic> listPipelines(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_PIPELINES, id, mergeRequestIid), CI_PIPELINE_BASIC_LIST_TYPE);
    }

    /**
     * Create pipeline ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/pipelines}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipeline createPipeline(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsCreatePipelinePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_PIPELINES, id, mergeRequestIid), payload), GitLabCiPipeline.class);
    }

    /**
     * Merge ({@code PUT /projects/{id}/merge_requests/{merge_request_iid}/merge}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest merge(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsMergePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MERGE, id, mergeRequestIid), payload), GitLabMergeRequest.class);
    }

    /**
     * Call merge ref ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/merge_ref}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMergeRef(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_MERGE_REF, id, mergeRequestIid));
    }

    /**
     * Create cancel merge when pipeline succeed ({@code POST
     * /projects/{id}/merge_requests/{merge_request_iid}/cancel_merge_when_pipeline_succeeds}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public void createCancelMergeWhenPipelineSucceed(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(CREATE_CANCEL_MERGE_WHEN_PIPELINE_SUCCEE, id, mergeRequestIid));
    }

    /**
     * Cancel auto merge ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/cancel_auto_merge}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMergeRequest cancelAutoMerge(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CANCEL_AUTO_MERGE, id, mergeRequestIid), GitLabMergeRequest.class);
    }

    /**
     * Rebase ({@code PUT /projects/{id}/merge_requests/{merge_request_iid}/rebase}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void rebase(
            final String id, final long mergeRequestIid, final GitLabProjectMergeRequestsRebasePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(REBASE, id, mergeRequestIid), payload));
    }

    /**
     * List closes issues ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/closes_issues}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssueBasic> listClosesIssues(final String id, final long mergeRequestIid)
            throws IOException {
        return listClosesIssues(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List closes issues ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/closes_issues}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssueBasic> listClosesIssues(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_CLOSES_ISSUES, Map.of(), request, ISSUE_BASIC_SPEC, id, mergeRequestIid);
    }

    /**
     * Call related issues ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/related_issues}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callRelatedIssues(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_RELATED_ISSUES, id, mergeRequestIid));
    }
}
