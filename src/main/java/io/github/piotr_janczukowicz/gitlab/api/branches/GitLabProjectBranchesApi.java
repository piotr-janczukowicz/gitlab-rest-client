package io.github.piotr_janczukowicz.gitlab.api.branches;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.HttpMethod;
import io.github.piotr_janczukowicz.http.client.HttpCall;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project branches. */
public final class GitLabProjectBranchesApi extends GitLabResourceApi {
    private static final String PARAM_BRANCH = "branch";
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/repository/branches");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/repository/branches/{branch}");
    private static final PathTemplate PROTECT = PathTemplate.of("/projects/{id}/repository/branches/{branch}/protect");
    private static final PathTemplate UNPROTECT =
            PathTemplate.of("/projects/{id}/repository/branches/{branch}/unprotect");
    private static final PathTemplate DELETE_MERGED_BRANCHES =
            PathTemplate.of("/projects/{id}/repository/merged_branches");
    private static final JsonType<List<GitLabBranch>> BRANCH_LIST_TYPE = JsonTypes.listOf(GitLabBranch.class);
    private static final GitLabListSpec<GitLabBranch> BRANCH_SPEC = GitLabListSpec.offset(BRANCH_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectBranchesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/repository/branches}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBranch> list(final String id) throws IOException {
        return list(id, GitLabProjectBranchesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/repository/branches}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBranch> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectBranchesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/repository/branches}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBranch> list(final String id, final GitLabProjectBranchesListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/repository/branches}).
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
    public GitLabPage<GitLabBranch> list(
            final String id, final GitLabProjectBranchesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, BRANCH_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/repository/branches}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBranch create(final String id, final GitLabProjectBranchesCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabBranch.class);
    }

    /**
     * Get ({@code GET /projects/{id}/repository/branches/{branch}}).
     *
     * @param id the id
     * @param branch the branch
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code branch} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBranch> get(final String id, final String branch) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(branch, PARAM_BRANCH);
        return caller.fetchOrEmpty(get(GET, id, branch), GitLabBranch.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/repository/branches/{branch}}).
     *
     * @param id the id
     * @param branch the branch
     * @throws IllegalArgumentException if {@code id} or {@code branch} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String branch) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(branch, PARAM_BRANCH);
        caller.send(delete(GET, id, branch));
    }

    /**
     * Head ({@code HEAD /projects/{id}/repository/branches/{branch}}).
     *
     * @param id the id
     * @param branch the branch
     * @return whether the resource exists
     * @throws IllegalArgumentException if {@code id} or {@code branch} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public boolean head(final String id, final String branch) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(branch, PARAM_BRANCH);
        return caller.isExisting(HttpCall.of(HttpMethod.HEAD, GET.expand(id, branch)));
    }

    /**
     * Protect ({@code PUT /projects/{id}/repository/branches/{branch}/protect}).
     *
     * @param id the id
     * @param branch the branch
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code branch} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBranch protect(final String id, final String branch, final GitLabProjectBranchesProtectPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(branch, PARAM_BRANCH);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(PROTECT, id, branch), payload), GitLabBranch.class);
    }

    /**
     * Unprotect ({@code PUT /projects/{id}/repository/branches/{branch}/unprotect}).
     *
     * @param id the id
     * @param branch the branch
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code branch} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBranch unprotect(final String id, final String branch) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(branch, PARAM_BRANCH);
        return caller.fetch(put(UNPROTECT, id, branch), GitLabBranch.class);
    }

    /**
     * Delete merged branches ({@code DELETE /projects/{id}/repository/merged_branches}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteMergedBranches(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_MERGED_BRANCHES, id));
    }
}
