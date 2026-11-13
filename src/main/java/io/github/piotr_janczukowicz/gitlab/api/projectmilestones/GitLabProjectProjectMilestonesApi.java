package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssueBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMilestone;
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

/** The GitLab operations of project project milestones. */
public final class GitLabProjectProjectMilestonesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/milestones");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/milestones/{milestone_id}");
    private static final PathTemplate LIST_ISSUES = PathTemplate.of("/projects/{id}/milestones/{milestone_id}/issues");
    private static final PathTemplate LIST_MERGE_REQUESTS =
            PathTemplate.of("/projects/{id}/milestones/{milestone_id}/merge_requests");
    private static final PathTemplate PROMOTE = PathTemplate.of("/projects/{id}/milestones/{milestone_id}/promote");
    private static final PathTemplate CALL_BURNDOWN_EVENTS =
            PathTemplate.of("/projects/{id}/milestones/{milestone_id}/burndown_events");
    private static final JsonType<List<GitLabMilestone>> MILESTONE_LIST_TYPE = JsonTypes.listOf(GitLabMilestone.class);
    private static final JsonType<List<GitLabIssueBasic>> ISSUE_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabIssueBasic.class);
    private static final JsonType<List<GitLabMergeRequestBasic>> MERGE_REQUEST_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestBasic.class);
    private static final GitLabListSpec<GitLabMilestone> MILESTONE_SPEC = GitLabListSpec.offset(MILESTONE_LIST_TYPE);
    private static final GitLabListSpec<GitLabIssueBasic> ISSUE_BASIC_SPEC =
            GitLabListSpec.offset(ISSUE_BASIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabMergeRequestBasic> MERGE_REQUEST_BASIC_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectMilestonesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/milestones}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMilestone> list(final String id) throws IOException {
        return list(id, GitLabProjectProjectMilestonesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/milestones}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMilestone> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectProjectMilestonesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/milestones}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMilestone> list(final String id, final GitLabProjectProjectMilestonesListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/milestones}).
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
    public GitLabPage<GitLabMilestone> list(
            final String id, final GitLabProjectProjectMilestonesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, MILESTONE_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/milestones}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMilestone create(final String id, final GitLabProjectProjectMilestonesCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabMilestone.class);
    }

    /**
     * Get ({@code GET /projects/{id}/milestones/{milestone_id}}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMilestone> get(final String id, final long milestoneId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, milestoneId), GitLabMilestone.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/milestones/{milestone_id}}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMilestone update(
            final String id, final long milestoneId, final GitLabProjectProjectMilestonesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, milestoneId), payload), GitLabMilestone.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/milestones/{milestone_id}}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long milestoneId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, milestoneId));
    }

    /**
     * List issues ({@code GET /projects/{id}/milestones/{milestone_id}/issues}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssueBasic> listIssues(final String id, final long milestoneId) throws IOException {
        return listIssues(id, milestoneId, GitLabPageRequest.byPage());
    }

    /**
     * List issues ({@code GET /projects/{id}/milestones/{milestone_id}/issues}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssueBasic> listIssues(
            final String id, final long milestoneId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_ISSUES, Map.of(), request, ISSUE_BASIC_SPEC, id, milestoneId);
    }

    /**
     * List merge requests ({@code GET /projects/{id}/milestones/{milestone_id}/merge_requests}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(final String id, final long milestoneId)
            throws IOException {
        return listMergeRequests(id, milestoneId, GitLabPageRequest.byPage());
    }

    /**
     * List merge requests ({@code GET /projects/{id}/milestones/{milestone_id}/merge_requests}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id, final long milestoneId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_MERGE_REQUESTS, Map.of(), request, MERGE_REQUEST_BASIC_SPEC, id, milestoneId);
    }

    /**
     * Promote ({@code POST /projects/{id}/milestones/{milestone_id}/promote}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void promote(final String id, final long milestoneId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(PROMOTE, id, milestoneId));
    }

    /**
     * Call burndown events ({@code GET /projects/{id}/milestones/{milestone_id}/burndown_events}).
     *
     * @param id the id
     * @param milestoneId the milestone id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void callBurndownEvents(final String id, final long milestoneId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMilestonesMilestoneIdBurndownEvents");
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_BURNDOWN_EVENTS, id, milestoneId));
    }
}
