package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of project external status checks. */
public final class GitLabProjectExternalStatusChecksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/external_status_checks");
    private static final PathTemplate UPDATE = PathTemplate.of("/projects/{id}/external_status_checks/{check_id}");
    private static final PathTemplate LIST_MERGE_REQUESTS_STATUS_CHECKS =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/status_checks");
    private static final PathTemplate RETRY_MERGE_REQUESTS_STATUS_CHECK = PathTemplate.of(
            "/projects/{id}/merge_requests/{merge_request_iid}/status_checks/{external_status_check_id}/retry");
    private static final JsonType<List<GitLabExternalStatusCheck>> EXTERNAL_STATUS_CHECK_LIST_TYPE =
            JsonTypes.listOf(GitLabExternalStatusCheck.class);
    private static final JsonType<List<GitLabMergeRequestsStatusCheck>> MERGE_REQUESTS_STATUS_CHECK_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestsStatusCheck.class);
    private static final GitLabListSpec<GitLabExternalStatusCheck> EXTERNAL_STATUS_CHECK_SPEC =
            GitLabListSpec.offset(EXTERNAL_STATUS_CHECK_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectExternalStatusChecksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/external_status_checks}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabExternalStatusCheck> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/external_status_checks}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabExternalStatusCheck> list(final String id, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdExternalStatusChecks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, EXTERNAL_STATUS_CHECK_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/external_status_checks}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabExternalStatusCheck create(
            final String id, final GitLabProjectExternalStatusChecksCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdExternalStatusChecks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabExternalStatusCheck.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/external_status_checks/{check_id}}).
     *
     * @param id the id
     * @param checkId the check id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabExternalStatusCheck update(
            final String id, final long checkId, final GitLabProjectExternalStatusChecksUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4ProjectsIdExternalStatusChecksCheckId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(UPDATE, id, checkId), payload), GitLabExternalStatusCheck.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/external_status_checks/{check_id}}).
     *
     * @param id the id
     * @param checkId the check id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void delete(final String id, final long checkId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4ProjectsIdExternalStatusChecksCheckId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(UPDATE, id, checkId));
    }

    /**
     * List merge requests status checks ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/status_checks}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabMergeRequestsStatusCheck> listMergeRequestsStatusChecks(
            final String id, final long mergeRequestIid) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdMergeRequestsMergeRequestIidStatusChecks");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(
                get(LIST_MERGE_REQUESTS_STATUS_CHECKS, id, mergeRequestIid), MERGE_REQUESTS_STATUS_CHECK_LIST_TYPE);
    }

    /**
     * Retry merge requests status check ({@code POST
     * /projects/{id}/merge_requests/{merge_request_iid}/status_checks/{external_status_check_id}/retry}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param externalStatusCheckId the external status check id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void retryMergeRequestsStatusCheck(
            final String id, final long mergeRequestIid, final long externalStatusCheckId) throws IOException {
        caller.requireTier(
                GitLabTier.ULTIMATE,
                "postApiV4ProjectsIdMergeRequestsMergeRequestIidStatusChecksExternalStatusCheckIdRetry");
        requireNotBlank(id, PARAM_ID);
        caller.send(post(RETRY_MERGE_REQUESTS_STATUS_CHECK, id, mergeRequestIid, externalStatusCheckId));
    }
}
