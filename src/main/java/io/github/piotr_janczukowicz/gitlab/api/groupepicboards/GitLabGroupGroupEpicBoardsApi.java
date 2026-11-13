package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of group group epic boards. */
public final class GitLabGroupGroupEpicBoardsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epic_boards");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/epic_boards/{board_id}");
    private static final PathTemplate LIST_LISTS = PathTemplate.of("/groups/{id}/epic_boards/{board_id}/lists");
    private static final PathTemplate GET_LIST = PathTemplate.of("/groups/{id}/epic_boards/{board_id}/lists/{list_id}");
    private static final JsonType<List<GitLabEpicBoard>> EPIC_BOARD_LIST_TYPE = JsonTypes.listOf(GitLabEpicBoard.class);
    private static final JsonType<List<GitLabEpicBoardsList>> EPIC_BOARDS_LIST_LIST_TYPE =
            JsonTypes.listOf(GitLabEpicBoardsList.class);
    private static final GitLabListSpec<GitLabEpicBoard> EPIC_BOARD_SPEC = GitLabListSpec.offset(EPIC_BOARD_LIST_TYPE);
    private static final GitLabListSpec<GitLabEpicBoardsList> EPIC_BOARDS_LIST_SPEC =
            GitLabListSpec.offset(EPIC_BOARDS_LIST_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupEpicBoardsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/epic_boards}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicBoard> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/epic_boards}).
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
    public GitLabPage<GitLabEpicBoard> list(final String id, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicBoards");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, EPIC_BOARD_SPEC, id);
    }

    /**
     * Get ({@code GET /groups/{id}/epic_boards/{board_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabEpicBoard> get(final String id, final long boardId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicBoardsBoardId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, boardId), GitLabEpicBoard.class);
    }

    /**
     * List lists ({@code GET /groups/{id}/epic_boards/{board_id}/lists}).
     *
     * @param id the id
     * @param boardId the board id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicBoardsList> listLists(final String id, final long boardId) throws IOException {
        return listLists(id, boardId, GitLabPageRequest.byPage());
    }

    /**
     * List lists ({@code GET /groups/{id}/epic_boards/{board_id}/lists}).
     *
     * @param id the id
     * @param boardId the board id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicBoardsList> listLists(
            final String id, final long boardId, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicBoardsBoardIdLists");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST_LISTS, Map.of(), request, EPIC_BOARDS_LIST_SPEC, id, boardId);
    }

    /**
     * Get list ({@code GET /groups/{id}/epic_boards/{board_id}/lists/{list_id}}).
     *
     * @param id the id
     * @param boardId the board id
     * @param listId the list id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabEpicBoardsList> getList(final String id, final long boardId, final long listId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicBoardsBoardIdListsListId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_LIST, id, boardId, listId), GitLabEpicBoardsList.class);
    }
}
