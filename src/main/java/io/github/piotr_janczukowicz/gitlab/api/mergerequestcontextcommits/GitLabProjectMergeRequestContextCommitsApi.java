package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** The GitLab operations of project merge request context commits. */
public final class GitLabProjectMergeRequestContextCommitsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/context_commits");
    private static final JsonType<List<GitLabCommitWithLink>> COMMIT_WITH_LINK_LIST_TYPE =
            JsonTypes.listOf(GitLabCommitWithLink.class);
    private static final JsonType<List<GitLabCommit>> COMMIT_LIST_TYPE = JsonTypes.listOf(GitLabCommit.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMergeRequestContextCommitsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/context_commits}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabCommitWithLink> list(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id, mergeRequestIid), COMMIT_WITH_LINK_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/context_commits}).
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
    public List<GitLabCommit> create(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectMergeRequestContextCommitsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id, mergeRequestIid), payload), COMMIT_LIST_TYPE);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/merge_requests/{merge_request_iid}/context_commits}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param commits the commits
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code commits} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long mergeRequestIid, final List<String> commits) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(commits, "commits");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().list("commits", commits).build();
        caller.send(delete(LIST, id, mergeRequestIid).withQuery(queryParameters));
    }
}
