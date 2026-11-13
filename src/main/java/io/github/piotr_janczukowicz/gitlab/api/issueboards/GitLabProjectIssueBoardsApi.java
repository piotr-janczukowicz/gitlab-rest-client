package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBoard;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabList;
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
import java.util.Optional;

/** The GitLab operations of project issue boards. */
public final class GitLabProjectIssueBoardsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/boards");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/boards/{board_id}");
    private static final PathTemplate LIST_LISTS = PathTemplate.of("/projects/{id}/boards/{board_id}/lists");
    private static final PathTemplate GET_LIST = PathTemplate.of("/projects/{id}/boards/{board_id}/lists/{list_id}");
    private static final JsonType<List<GitLabBoard>> BOARD_LIST_TYPE = JsonTypes.listOf(GitLabBoard.class);
    private static final JsonType<List<GitLabList>> LIST_LIST_TYPE = JsonTypes.listOf(GitLabList.class);
    private static final GitLabListSpec<GitLabBoard> BOARD_SPEC = GitLabListSpec.offset(BOARD_LIST_TYPE);
    private static final GitLabListSpec<GitLabList> LIST_SPEC = GitLabListSpec.offset(LIST_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectIssueBoardsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/boards}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBoard> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/boards}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBoard> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, BOARD_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/boards}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBoard create(final String id, final GitLabProjectIssueBoardsCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabBoard.class);
    }

    /**
     * Get ({@code GET /projects/{id}/boards/{board_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBoard> get(final String id, final long boardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, boardId), GitLabBoard.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/boards/{board_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBoard update(final String id, final long boardId, final GitLabProjectIssueBoardsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, boardId), payload), GitLabBoard.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/boards/{board_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBoard> delete(final String id, final long boardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET, id, boardId), GitLabBoard.class);
    }

    /**
     * List lists ({@code GET /projects/{id}/boards/{board_id}/lists}).
     *
     * @param id the id
     * @param boardId the board id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabList> listLists(final String id, final long boardId) throws IOException {
        return listLists(id, boardId, GitLabPageRequest.byPage());
    }

    /**
     * List lists ({@code GET /projects/{id}/boards/{board_id}/lists}).
     *
     * @param id the id
     * @param boardId the board id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabList> listLists(final String id, final long boardId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST_LISTS, Map.of(), request, LIST_SPEC, id, boardId);
    }

    /**
     * Create list ({@code POST /projects/{id}/boards/{board_id}/lists}).
     *
     * @param id the id
     * @param boardId the board id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabList createList(
            final String id, final long boardId, final GitLabProjectIssueBoardsCreateListPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_LISTS, id, boardId), payload), GitLabList.class);
    }

    /**
     * Get list ({@code GET /projects/{id}/boards/{board_id}/lists/{list_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @param listId the list id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabList> getList(final String id, final long boardId, final long listId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_LIST, id, boardId, listId), GitLabList.class);
    }

    /**
     * Update list ({@code PUT /projects/{id}/boards/{board_id}/lists/{list_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @param listId the list id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabList updateList(
            final String id,
            final long boardId,
            final long listId,
            final GitLabProjectIssueBoardsUpdateListPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_LIST, id, boardId, listId), payload), GitLabList.class);
    }

    /**
     * Delete list ({@code DELETE /projects/{id}/boards/{board_id}/lists/{list_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @param listId the list id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabList> deleteList(final String id, final long boardId, final long listId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET_LIST, id, boardId, listId), GitLabList.class);
    }
}
