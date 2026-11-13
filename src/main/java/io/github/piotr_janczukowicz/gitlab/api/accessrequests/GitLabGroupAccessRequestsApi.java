package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
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

/** The GitLab operations of group access requests. */
public final class GitLabGroupAccessRequestsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/access_requests");
    private static final PathTemplate APPROVE = PathTemplate.of("/groups/{id}/access_requests/{user_id}/approve");
    private static final PathTemplate DELETE = PathTemplate.of("/groups/{id}/access_requests/{user_id}");
    private static final JsonType<List<GitLabAccessRequester>> ACCESS_REQUESTER_LIST_TYPE =
            JsonTypes.listOf(GitLabAccessRequester.class);
    private static final GitLabListSpec<GitLabAccessRequester> ACCESS_REQUESTER_SPEC =
            GitLabListSpec.offset(ACCESS_REQUESTER_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupAccessRequestsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/access_requests}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAccessRequester> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/access_requests}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAccessRequester> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, ACCESS_REQUESTER_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/access_requests}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAccessRequester create(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(LIST, id), GitLabAccessRequester.class);
    }

    /**
     * Approve ({@code PUT /groups/{id}/access_requests/{user_id}/approve}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMember approve(
            final String id, final long userId, final GitLabGroupAccessRequestsApprovePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(APPROVE, id, userId), payload), GitLabMember.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/access_requests/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE, id, userId));
    }
}
