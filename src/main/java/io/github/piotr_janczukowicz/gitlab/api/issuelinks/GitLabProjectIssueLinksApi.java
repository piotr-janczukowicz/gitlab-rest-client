package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of project issue links. */
public final class GitLabProjectIssueLinksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/issues/{issue_iid}/links");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/issues/{issue_iid}/links/{issue_link_id}");
    private static final JsonType<List<GitLabRelatedIssue>> RELATED_ISSUE_LIST_TYPE =
            JsonTypes.listOf(GitLabRelatedIssue.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectIssueLinksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/issues/{issue_iid}/links}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabRelatedIssue> list(final String id, final long issueIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id, issueIid), RELATED_ISSUE_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/issues/{issue_iid}/links}).
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
    public GitLabIssueLink create(
            final String id, final long issueIid, final GitLabProjectIssueLinksCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id, issueIid), payload), GitLabIssueLink.class);
    }

    /**
     * Get ({@code GET /projects/{id}/issues/{issue_iid}/links/{issue_link_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param issueLinkId the issue link id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code issueLinkId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssueLink> get(final String id, final long issueIid, final String issueLinkId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(issueLinkId, "issueLinkId");
        return caller.fetchOrEmpty(get(GET, id, issueIid, issueLinkId), GitLabIssueLink.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/issues/{issue_iid}/links/{issue_link_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param issueLinkId the issue link id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code issueLinkId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssueLink> delete(final String id, final long issueIid, final String issueLinkId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(issueLinkId, "issueLinkId");
        return caller.fetchOptional(delete(GET, id, issueIid, issueLinkId), GitLabIssueLink.class);
    }
}
