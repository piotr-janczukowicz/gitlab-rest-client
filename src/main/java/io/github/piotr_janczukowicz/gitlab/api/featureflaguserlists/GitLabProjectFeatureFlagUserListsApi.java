package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
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

/** The GitLab operations of project feature flag user lists. */
public final class GitLabProjectFeatureFlagUserListsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_IID = "iid";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/feature_flags_user_lists");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/feature_flags_user_lists/{iid}");
    private static final JsonType<List<GitLabFeatureFlagUserList>> FEATURE_FLAG_USER_LIST_LIST_TYPE =
            JsonTypes.listOf(GitLabFeatureFlagUserList.class);
    private static final GitLabListSpec<GitLabFeatureFlagUserList> FEATURE_FLAG_USER_LIST_SPEC =
            GitLabListSpec.offset(FEATURE_FLAG_USER_LIST_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectFeatureFlagUserListsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags_user_lists}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlagUserList> list(final String id) throws IOException {
        return list(id, GitLabProjectFeatureFlagUserListsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags_user_lists}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlagUserList> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabProjectFeatureFlagUserListsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags_user_lists}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlagUserList> list(
            final String id, final GitLabProjectFeatureFlagUserListsListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags_user_lists}).
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
    public GitLabPage<GitLabFeatureFlagUserList> list(
            final String id, final GitLabProjectFeatureFlagUserListsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, FEATURE_FLAG_USER_LIST_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/feature_flags_user_lists}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeatureFlagUserList create(
            final String id, final GitLabProjectFeatureFlagUserListsCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabFeatureFlagUserList.class);
    }

    /**
     * Get ({@code GET /projects/{id}/feature_flags_user_lists/{iid}}).
     *
     * @param id the id
     * @param iid the iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code iid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabFeatureFlagUserList> get(final String id, final String iid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(iid, PARAM_IID);
        return caller.fetchOrEmpty(get(GET, id, iid), GitLabFeatureFlagUserList.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/feature_flags_user_lists/{iid}}).
     *
     * @param id the id
     * @param iid the iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code iid} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeatureFlagUserList update(
            final String id, final String iid, final GitLabProjectFeatureFlagUserListsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(iid, PARAM_IID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, iid), payload), GitLabFeatureFlagUserList.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/feature_flags_user_lists/{iid}}).
     *
     * @param id the id
     * @param iid the iid
     * @throws IllegalArgumentException if {@code id} or {@code iid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String iid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(iid, PARAM_IID);
        caller.send(delete(GET, id, iid));
    }
}
