package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;

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

/** The GitLab operations of group group level protected branches. */
public final class GitLabGroupGroupLevelProtectedBranchesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_NAME = "name";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/protected_branches");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/protected_branches/{name}");
    private static final JsonType<List<GitLabGroupProtectedBranch>> GROUP_PROTECTED_BRANCH_LIST_TYPE =
            JsonTypes.listOf(GitLabGroupProtectedBranch.class);
    private static final GitLabListSpec<GitLabGroupProtectedBranch> GROUP_PROTECTED_BRANCH_SPEC =
            GitLabListSpec.offset(GROUP_PROTECTED_BRANCH_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupLevelProtectedBranchesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/protected_branches}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupProtectedBranch> list(final String id) throws IOException {
        return list(id, GitLabGroupGroupLevelProtectedBranchesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/protected_branches}).
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
    public GitLabPage<GitLabGroupProtectedBranch> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabGroupGroupLevelProtectedBranchesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/protected_branches}).
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
    public GitLabPage<GitLabGroupProtectedBranch> list(
            final String id, final GitLabGroupGroupLevelProtectedBranchesListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/protected_branches}).
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
    public GitLabPage<GitLabGroupProtectedBranch> list(
            final String id,
            final GitLabGroupGroupLevelProtectedBranchesListFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdProtectedBranches");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, GROUP_PROTECTED_BRANCH_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/protected_branches}).
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
    public GitLabGroupProtectedBranch create(
            final String id, final GitLabGroupGroupLevelProtectedBranchesCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdProtectedBranches");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabGroupProtectedBranch.class);
    }

    /**
     * Get ({@code GET /groups/{id}/protected_branches/{name}}).
     *
     * @param id the id
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGroupProtectedBranch> get(final String id, final String name) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdProtectedBranchesName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        return caller.fetchOrEmpty(get(GET, id, name), GitLabGroupProtectedBranch.class);
    }

    /**
     * Update ({@code PATCH /groups/{id}/protected_branches/{name}}).
     *
     * @param id the id
     * @param name the name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGroupProtectedBranch update(
            final String id, final String name, final GitLabGroupGroupLevelProtectedBranchesUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "patchApiV4GroupsIdProtectedBranchesName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(patch(GET, id, name), payload), GitLabGroupProtectedBranch.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/protected_branches/{name}}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final String name) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdProtectedBranchesName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        caller.send(delete(GET, id, name));
    }
}
