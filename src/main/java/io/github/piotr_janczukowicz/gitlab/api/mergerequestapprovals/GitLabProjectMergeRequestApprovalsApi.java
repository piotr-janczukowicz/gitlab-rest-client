package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestApprovals;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
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

/** The GitLab operations of project merge request approvals. */
public final class GitLabProjectMergeRequestApprovalsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST_MERGE_REQUESTS_APPROVAL_RULES =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/approval_rules");
    private static final PathTemplate GET_MERGE_REQUESTS_APPROVAL_RULE =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/approval_rules/{approval_rule_id}");
    private static final PathTemplate GET_APPROVALS = PathTemplate.of("/projects/{id}/approvals");
    private static final PathTemplate GET_REQUESTS_APPROVALS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/approvals");
    private static final JsonType<List<GitLabMergeRequestApprovalRule>> MERGE_REQUEST_APPROVAL_RULE_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestApprovalRule.class);
    private static final GitLabListSpec<GitLabMergeRequestApprovalRule> MERGE_REQUEST_APPROVAL_RULE_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_APPROVAL_RULE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMergeRequestApprovalsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List merge requests approval rules ({@code GET
     * /projects/{id}/merge_requests/{merge_request_iid}/approval_rules}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeRequestApprovalRule> listMergeRequestsApprovalRules(
            final String id, final long mergeRequestIid) throws IOException {
        return listMergeRequestsApprovalRules(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List merge requests approval rules ({@code GET
     * /projects/{id}/merge_requests/{merge_request_iid}/approval_rules}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabMergeRequestApprovalRule> listMergeRequestsApprovalRules(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(
                LIST_MERGE_REQUESTS_APPROVAL_RULES,
                Map.of(),
                request,
                MERGE_REQUEST_APPROVAL_RULE_SPEC,
                id,
                mergeRequestIid);
    }

    /**
     * Create merge requests approval rule ({@code POST
     * /projects/{id}/merge_requests/{merge_request_iid}/approval_rules}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabMergeRequestApprovalRule createMergeRequestsApprovalRule(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_MERGE_REQUESTS_APPROVAL_RULES, id, mergeRequestIid), payload),
                GitLabMergeRequestApprovalRule.class);
    }

    /**
     * Get merge requests approval rule ({@code GET
     * /projects/{id}/merge_requests/{merge_request_iid}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param approvalRuleId the approval rule id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabMergeRequestApprovalRule> getMergeRequestsApprovalRule(
            final String id, final long mergeRequestIid, final long approvalRuleId) throws IOException {
        caller.requireTier(
                GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_MERGE_REQUESTS_APPROVAL_RULE, id, mergeRequestIid, approvalRuleId),
                GitLabMergeRequestApprovalRule.class);
    }

    /**
     * Update merge requests approval rule ({@code PUT
     * /projects/{id}/merge_requests/{merge_request_iid}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
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
    public GitLabMergeRequestApprovalRule updateMergeRequestsApprovalRule(
            final String id,
            final long mergeRequestIid,
            final long approvalRuleId,
            final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload payload)
            throws IOException {
        caller.requireTier(
                GitLabTier.PREMIUM, "putApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_MERGE_REQUESTS_APPROVAL_RULE, id, mergeRequestIid, approvalRuleId), payload),
                GitLabMergeRequestApprovalRule.class);
    }

    /**
     * Delete merge requests approval rule ({@code DELETE
     * /projects/{id}/merge_requests/{merge_request_iid}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param approvalRuleId the approval rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteMergeRequestsApprovalRule(final String id, final long mergeRequestIid, final long approvalRuleId)
            throws IOException {
        caller.requireTier(
                GitLabTier.PREMIUM, "deleteApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_MERGE_REQUESTS_APPROVAL_RULE, id, mergeRequestIid, approvalRuleId));
    }

    /**
     * Get approvals ({@code GET /projects/{id}/approvals}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabApprovalSettings getApprovals(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdApprovals");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_APPROVALS, id), GitLabApprovalSettings.class);
    }

    /**
     * Create approvals ({@code POST /projects/{id}/approvals}).
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
    public GitLabApprovalSettings createApprovals(
            final String id, final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdApprovals");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(GET_APPROVALS, id), payload), GitLabApprovalSettings.class);
    }

    /**
     * Get requests approvals ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/approvals}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMergeRequestApprovals> getRequestsApprovals(final String id, final long mergeRequestIid)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_REQUESTS_APPROVALS, id, mergeRequestIid), GitLabMergeRequestApprovals.class);
    }

    /**
     * Create requests approvals ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/approvals}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabApprovalState createRequestsApprovals(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdMergeRequestsMergeRequestIidApprovals");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(GET_REQUESTS_APPROVALS, id, mergeRequestIid), payload), GitLabApprovalState.class);
    }
}
