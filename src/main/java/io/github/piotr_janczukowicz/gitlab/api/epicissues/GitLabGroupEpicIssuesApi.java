package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpicIssue;
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

/** The GitLab operations of group epic issues. */
public final class GitLabGroupEpicIssuesApi extends GitLabResourceApi {
    private static final String PARAM_EPICIID = "epicIid";
    private static final String PARAM_EPICISSUEID = "epicIssueId";
    private static final String PARAM_ID = "id";
    private static final PathTemplate CREATE = PathTemplate.of("/groups/{id}/epics/{epic_iid}/issues/{epic_issue_id}");
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epics/{epic_iid}/issues");
    private static final JsonType<List<GitLabEpicIssue>> EPIC_ISSUE_LIST_TYPE = JsonTypes.listOf(GitLabEpicIssue.class);
    private static final GitLabListSpec<GitLabEpicIssue> EPIC_ISSUE_SPEC = GitLabListSpec.offset(EPIC_ISSUE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupEpicIssuesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /groups/{id}/(-/)epics/{epic_iid}/issues/{epic_issue_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param epicIssueId the epic issue id
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code epicIid} or {@code epicIssueId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabEpicIssueLink create(final String id, final String epicIid, final String epicIssueId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdDashEpicsEpicIidIssuesIssueId");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(epicIid, PARAM_EPICIID);
        requireNotBlank(epicIssueId, PARAM_EPICISSUEID);
        return caller.fetch(post(CREATE, id, epicIid, epicIssueId), GitLabEpicIssueLink.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/(-/)epics/{epic_iid}/issues/{epic_issue_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param epicIssueId the epic issue id
     * @param payload the request body
     * @return the items
     * @throws IllegalArgumentException if {@code id}, {@code epicIid} or {@code epicIssueId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabEpicIssue> update(
            final String id,
            final String epicIid,
            final String epicIssueId,
            final GitLabGroupEpicIssuesUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdDashEpicsEpicIidIssuesEpicIssueId");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(epicIid, PARAM_EPICIID);
        requireNotBlank(epicIssueId, PARAM_EPICISSUEID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(CREATE, id, epicIid, epicIssueId), payload), EPIC_ISSUE_LIST_TYPE);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/(-/)epics/{epic_iid}/issues/{epic_issue_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param epicIssueId the epic issue id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id}, {@code epicIid} or {@code epicIssueId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabEpicIssueLink> delete(final String id, final String epicIid, final String epicIssueId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdDashEpicsEpicIidIssuesEpicIssueId");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(epicIid, PARAM_EPICIID);
        requireNotBlank(epicIssueId, PARAM_EPICISSUEID);
        return caller.fetchOptional(delete(CREATE, id, epicIid, epicIssueId), GitLabEpicIssueLink.class);
    }

    /**
     * List ({@code GET /groups/{id}/epics/{epic_iid}/issues}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code epicIid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicIssue> list(final String id, final String epicIid) throws IOException {
        return list(id, epicIid, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/epics/{epic_iid}/issues}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code epicIid} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicIssue> list(final String id, final String epicIid, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIidIssues");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(epicIid, PARAM_EPICIID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, EPIC_ISSUE_SPEC, id, epicIid);
    }
}
