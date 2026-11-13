package io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupRepositoryStorageMove;
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

/** The GitLab operations of group repository storage moves. */
public final class GitLabGroupRepositoryStorageMovesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/group_repository_storage_moves");
    private static final PathTemplate GET =
            PathTemplate.of("/group_repository_storage_moves/{repository_storage_move_id}");
    private static final JsonType<List<GitLabGroupRepositoryStorageMove>> GROUP_REPOSITORY_STORAGE_MOVE_LIST_TYPE =
            JsonTypes.listOf(GitLabGroupRepositoryStorageMove.class);
    private static final GitLabListSpec<GitLabGroupRepositoryStorageMove> GROUP_REPOSITORY_STORAGE_MOVE_SPEC =
            GitLabListSpec.offset(GROUP_REPOSITORY_STORAGE_MOVE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupRepositoryStorageMovesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /group_repository_storage_moves}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupRepositoryStorageMove> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /group_repository_storage_moves}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupRepositoryStorageMove> list(final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupRepositoryStorageMoves");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, GROUP_REPOSITORY_STORAGE_MOVE_SPEC);
    }

    /**
     * Create ({@code POST /group_repository_storage_moves}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void create(final GitLabGroupRepositoryStorageMovesCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupRepositoryStorageMoves");
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(LIST), payload));
    }

    /**
     * Get ({@code GET /group_repository_storage_moves/{repository_storage_move_id}}).
     *
     * @param repositoryStorageMoveId the repository storage move id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGroupRepositoryStorageMove> get(final long repositoryStorageMoveId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupRepositoryStorageMovesRepositoryStorageMoveId");
        return caller.fetchOrEmpty(get(GET, repositoryStorageMoveId), GitLabGroupRepositoryStorageMove.class);
    }
}
