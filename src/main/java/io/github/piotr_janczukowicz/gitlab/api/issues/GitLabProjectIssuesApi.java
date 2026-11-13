package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssuableTimeStats;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project issues. */
public final class GitLabProjectIssuesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate TODO = PathTemplate.of("/projects/{id}/issues/{issue_iid}/todo");
    private static final PathTemplate SUBSCRIBE = PathTemplate.of("/projects/{id}/issues/{subscribable_id}/subscribe");
    private static final PathTemplate UNSUBSCRIBE =
            PathTemplate.of("/projects/{id}/issues/{subscribable_id}/unsubscribe");
    private static final PathTemplate TIME_ESTIMATE =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/time_estimate");
    private static final PathTemplate RESET_TIME_ESTIMATE =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/reset_time_estimate");
    private static final PathTemplate ADD_SPENT_TIME =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/add_spent_time");
    private static final PathTemplate RESET_SPENT_TIME =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/reset_spent_time");
    private static final PathTemplate GET_TIME_STATS = PathTemplate.of("/projects/{id}/issues/{issue_iid}/time_stats");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/issues");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/issues/{issue_iid}");
    private static final PathTemplate REORDER = PathTemplate.of("/projects/{id}/issues/{issue_iid}/reorder");
    private static final PathTemplate MOVE = PathTemplate.of("/projects/{id}/issues/{issue_iid}/move");
    private static final PathTemplate DO_CLONE = PathTemplate.of("/projects/{id}/issues/{issue_iid}/clone");
    private static final PathTemplate LIST_RELATED_MERGE_REQUESTS =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/related_merge_requests");
    private static final PathTemplate LIST_CLOSED_BY = PathTemplate.of("/projects/{id}/issues/{issue_iid}/closed_by");
    private static final PathTemplate LIST_PARTICIPANTS =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/participants");
    private static final PathTemplate GET_USER_AGENT_DETAIL =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/user_agent_detail");
    private static final PathTemplate AUTHORIZE_METRIC_IMAGE =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/metric_images/authorize");
    private static final PathTemplate GET_METRIC_IMAGES =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/metric_images");
    private static final PathTemplate UPDATE_METRIC_IMAGE =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/metric_images/{metric_image_id}");
    private static final JsonType<List<GitLabIssue>> ISSUE_LIST_TYPE = JsonTypes.listOf(GitLabIssue.class);
    private static final JsonType<List<GitLabMergeRequestBasic>> MERGE_REQUEST_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestBasic.class);
    private static final JsonType<List<GitLabUserBasic>> USER_BASIC_LIST_TYPE = JsonTypes.listOf(GitLabUserBasic.class);
    private static final GitLabListSpec<GitLabIssue> ISSUE_KEYSET_SPEC = GitLabListSpec.offsetOrKeyset(ISSUE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectIssuesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Todo ({@code POST /projects/{id}/issues/{issue_iid}/todo}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabTodo todo(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(TODO, id, issueIid), GitLabTodo.class);
    }

    /**
     * Subscribe ({@code POST /projects/{id}/issues/{subscribable_id}/subscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue subscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(SUBSCRIBE, id, subscribableId), GitLabIssue.class);
    }

    /**
     * Unsubscribe ({@code POST /projects/{id}/issues/{subscribable_id}/unsubscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue unsubscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(UNSUBSCRIBE, id, subscribableId), GitLabIssue.class);
    }

    /**
     * Time estimate ({@code POST /projects/{id}/issues/{issue_iid}/time_estimate}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats timeEstimate(
            final String id, final long issueIid, final GitLabProjectIssuesTimeEstimatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(TIME_ESTIMATE, id, issueIid), payload), GitLabIssuableTimeStats.class);
    }

    /**
     * Reset time estimate ({@code POST /projects/{id}/issues/{issue_iid}/reset_time_estimate}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats resetTimeEstimate(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESET_TIME_ESTIMATE, id, issueIid), GitLabIssuableTimeStats.class);
    }

    /**
     * Add spent time ({@code POST /projects/{id}/issues/{issue_iid}/add_spent_time}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats addSpentTime(
            final String id, final long issueIid, final GitLabProjectIssuesAddSpentTimePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(ADD_SPENT_TIME, id, issueIid), payload), GitLabIssuableTimeStats.class);
    }

    /**
     * Reset spent time ({@code POST /projects/{id}/issues/{issue_iid}/reset_spent_time}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableTimeStats resetSpentTime(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESET_SPENT_TIME, id, issueIid), GitLabIssuableTimeStats.class);
    }

    /**
     * Get time stats ({@code GET /projects/{id}/issues/{issue_iid}/time_stats}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssuableTimeStats> getTimeStats(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_TIME_STATS, id, issueIid), GitLabIssuableTimeStats.class);
    }

    /**
     * List ({@code GET /projects/{id}/issues}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list(final String id) throws IOException {
        return list(id, GitLabProjectIssuesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/issues}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectIssuesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/issues}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list(final String id, final GitLabProjectIssuesListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/issues}).
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
    public GitLabPage<GitLabIssue> list(
            final String id, final GitLabProjectIssuesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, ISSUE_KEYSET_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/issues}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue create(final String id, final GitLabProjectIssuesCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabIssue.class);
    }

    /**
     * Get ({@code GET /projects/{id}/issues/{issue_iid}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssue> get(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, issueIid), GitLabIssue.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/issues/{issue_iid}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue update(final String id, final long issueIid, final GitLabProjectIssuesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, issueIid), payload), GitLabIssue.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/issues/{issue_iid}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, issueIid));
    }

    /**
     * Reorder ({@code PUT /projects/{id}/issues/{issue_iid}/reorder}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue reorder(final String id, final long issueIid, final GitLabProjectIssuesReorderPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(REORDER, id, issueIid), payload), GitLabIssue.class);
    }

    /**
     * Move ({@code POST /projects/{id}/issues/{issue_iid}/move}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue move(final String id, final long issueIid, final GitLabProjectIssuesMovePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(MOVE, id, issueIid), payload), GitLabIssue.class);
    }

    /**
     * Do clone ({@code POST /projects/{id}/issues/{issue_iid}/clone}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssue doClone(final String id, final long issueIid, final GitLabProjectIssuesDoClonePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(DO_CLONE, id, issueIid), payload), GitLabIssue.class);
    }

    /**
     * List related merge requests ({@code GET /projects/{id}/issues/{issue_iid}/related_merge_requests}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabMergeRequestBasic> listRelatedMergeRequests(final String id, final long issueIid)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_RELATED_MERGE_REQUESTS, id, issueIid), MERGE_REQUEST_BASIC_LIST_TYPE);
    }

    /**
     * List closed by ({@code GET /projects/{id}/issues/{issue_iid}/closed_by}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabMergeRequestBasic> listClosedBy(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_CLOSED_BY, id, issueIid), MERGE_REQUEST_BASIC_LIST_TYPE);
    }

    /**
     * List participants ({@code GET /projects/{id}/issues/{issue_iid}/participants}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabUserBasic> listParticipants(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_PARTICIPANTS, id, issueIid), USER_BASIC_LIST_TYPE);
    }

    /**
     * Get user agent detail ({@code GET /projects/{id}/issues/{issue_iid}/user_agent_detail}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserAgentDetail> getUserAgentDetail(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_USER_AGENT_DETAIL, id, issueIid), GitLabUserAgentDetail.class);
    }

    /**
     * Authorize metric image ({@code POST /projects/{id}/issues/{issue_iid}/metric_images/authorize}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeMetricImage(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(AUTHORIZE_METRIC_IMAGE, id, issueIid));
    }

    /**
     * Get metric images ({@code GET /projects/{id}/issues/{issue_iid}/metric_images}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssuableMetricImage> getMetricImages(final String id, final long issueIid)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_METRIC_IMAGES, id, issueIid), GitLabIssuableMetricImage.class);
    }

    /**
     * Create metric image ({@code POST /projects/{id}/issues/{issue_iid}/metric_images}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableMetricImage createMetricImage(
            final String id, final long issueIid, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(
                caller.multipart(post(GET_METRIC_IMAGES, id, issueIid), form), GitLabIssuableMetricImage.class);
    }

    /**
     * Update metric image ({@code PUT /projects/{id}/issues/{issue_iid}/metric_images/{metric_image_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param metricImageId the metric image id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIssuableMetricImage updateMetricImage(
            final String id,
            final long issueIid,
            final long metricImageId,
            final GitLabProjectIssuesUpdateMetricImagePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_METRIC_IMAGE, id, issueIid, metricImageId), payload),
                GitLabIssuableMetricImage.class);
    }

    /**
     * Delete metric image ({@code DELETE /projects/{id}/issues/{issue_iid}/metric_images/{metric_image_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param metricImageId the metric image id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssuableMetricImage> deleteMetricImage(
            final String id, final long issueIid, final long metricImageId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(
                delete(UPDATE_METRIC_IMAGE, id, issueIid, metricImageId), GitLabIssuableMetricImage.class);
    }
}
