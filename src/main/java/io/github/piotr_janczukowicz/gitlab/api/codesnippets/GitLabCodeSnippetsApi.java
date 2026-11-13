package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSnippetRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
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

/** The GitLab operations of code snippets. */
public final class GitLabCodeSnippetsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_REPOSITORY_STORAGE_MOVES =
            PathTemplate.of("/snippets/{id}/repository_storage_moves");
    private static final PathTemplate GET_REPOSITORY_STORAGE_MOVE =
            PathTemplate.of("/snippets/{id}/repository_storage_moves/{repository_storage_move_id}");
    private static final PathTemplate LIST = PathTemplate.of("/snippets");
    private static final PathTemplate LIST_PUBLIC = PathTemplate.of("/snippets/public");
    private static final PathTemplate LIST_ALL = PathTemplate.of("/snippets/all");
    private static final PathTemplate GET = PathTemplate.of("/snippets/{id}");
    private static final PathTemplate CALL_RAW = PathTemplate.of("/snippets/{id}/raw");
    private static final PathTemplate CALL_FILES_RAW = PathTemplate.of("/snippets/{id}/files/{ref}/{file_path}/raw");
    private static final PathTemplate GET_USER_AGENT_DETAIL = PathTemplate.of("/snippets/{id}/user_agent_detail");
    private static final JsonType<List<GitLabSnippetRepositoryStorageMove>> SNIPPET_REPOSITORY_STORAGE_MOVE_LIST_TYPE =
            JsonTypes.listOf(GitLabSnippetRepositoryStorageMove.class);
    private static final JsonType<List<GitLabSnippet>> SNIPPET_LIST_TYPE = JsonTypes.listOf(GitLabSnippet.class);
    private static final JsonType<List<GitLabPersonalSnippet>> PERSONAL_SNIPPET_LIST_TYPE =
            JsonTypes.listOf(GitLabPersonalSnippet.class);
    private static final GitLabListSpec<GitLabSnippetRepositoryStorageMove> SNIPPET_REPOSITORY_STORAGE_MOVE_SPEC =
            GitLabListSpec.offset(SNIPPET_REPOSITORY_STORAGE_MOVE_LIST_TYPE);
    private static final GitLabListSpec<GitLabSnippet> SNIPPET_SPEC = GitLabListSpec.offset(SNIPPET_LIST_TYPE);
    private static final GitLabListSpec<GitLabPersonalSnippet> PERSONAL_SNIPPET_SPEC =
            GitLabListSpec.offset(PERSONAL_SNIPPET_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabCodeSnippetsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List repository storage moves ({@code GET /snippets/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippetRepositoryStorageMove> listRepositoryStorageMoves(final String id)
            throws IOException {
        return listRepositoryStorageMoves(id, GitLabPageRequest.byPage());
    }

    /**
     * List repository storage moves ({@code GET /snippets/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippetRepositoryStorageMove> listRepositoryStorageMoves(
            final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REPOSITORY_STORAGE_MOVES, Map.of(), request, SNIPPET_REPOSITORY_STORAGE_MOVE_SPEC, id);
    }

    /**
     * Create repository storage move ({@code POST /snippets/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSnippetRepositoryStorageMove createRepositoryStorageMove(
            final String id, final GitLabCodeSnippetsCreateRepositoryStorageMovePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REPOSITORY_STORAGE_MOVES, id), payload),
                GitLabSnippetRepositoryStorageMove.class);
    }

    /**
     * Get repository storage move ({@code GET /snippets/{id}/repository_storage_moves/{repository_storage_move_id}}).
     *
     * @param id the id
     * @param repositoryStorageMoveId the repository storage move id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSnippetRepositoryStorageMove> getRepositoryStorageMove(
            final String id, final long repositoryStorageMoveId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_REPOSITORY_STORAGE_MOVE, id, repositoryStorageMoveId),
                GitLabSnippetRepositoryStorageMove.class);
    }

    /**
     * List ({@code GET /snippets}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> list() throws IOException {
        return list(GitLabCodeSnippetsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /snippets}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabCodeSnippetsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /snippets}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> list(final GitLabCodeSnippetsListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /snippets}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> list(final GitLabCodeSnippetsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, SNIPPET_SPEC);
    }

    /**
     * Create ({@code POST /snippets}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalSnippet create(final GitLabCodeSnippetsCreatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST), payload), GitLabPersonalSnippet.class);
    }

    /**
     * List public ({@code GET /snippets/public}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalSnippet> listPublic() throws IOException {
        return listPublic(GitLabCodeSnippetsListPublicFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List public ({@code GET /snippets/public}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalSnippet> listPublic(final GitLabPageRequest request) throws IOException {
        return listPublic(GitLabCodeSnippetsListPublicFilter.empty(), request);
    }

    /**
     * List public ({@code GET /snippets/public}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalSnippet> listPublic(final GitLabCodeSnippetsListPublicFilter filter)
            throws IOException {
        return listPublic(filter, GitLabPageRequest.byPage());
    }

    /**
     * List public ({@code GET /snippets/public}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalSnippet> listPublic(
            final GitLabCodeSnippetsListPublicFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PUBLIC, queryParameters, request, PERSONAL_SNIPPET_SPEC);
    }

    /**
     * List all ({@code GET /snippets/all}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> listAll() throws IOException {
        return listAll(GitLabCodeSnippetsListAllFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List all ({@code GET /snippets/all}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> listAll(final GitLabPageRequest request) throws IOException {
        return listAll(GitLabCodeSnippetsListAllFilter.empty(), request);
    }

    /**
     * List all ({@code GET /snippets/all}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> listAll(final GitLabCodeSnippetsListAllFilter filter) throws IOException {
        return listAll(filter, GitLabPageRequest.byPage());
    }

    /**
     * List all ({@code GET /snippets/all}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSnippet> listAll(
            final GitLabCodeSnippetsListAllFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ALL, queryParameters, request, SNIPPET_SPEC);
    }

    /**
     * Get ({@code GET /snippets/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPersonalSnippet> get(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET, id), GitLabPersonalSnippet.class);
    }

    /**
     * Update ({@code PUT /snippets/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalSnippet update(final long id, final GitLabCodeSnippetsUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id), payload), GitLabPersonalSnippet.class);
    }

    /**
     * Delete ({@code DELETE /snippets/{id}}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPersonalSnippet> delete(final long id) throws IOException {
        return caller.fetchOptional(delete(GET, id), GitLabPersonalSnippet.class);
    }

    /**
     * Call raw ({@code GET /snippets/{id}/raw}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callRaw(final long id) throws IOException {
        caller.send(get(CALL_RAW, id));
    }

    /**
     * Call files raw ({@code GET /snippets/{id}/files/{ref}/{file_path}/raw}).
     *
     * @param id the id
     * @param ref the ref
     * @param filePath the file path
     * @throws IllegalArgumentException if {@code id}, {@code ref} or {@code filePath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callFilesRaw(final String id, final String ref, final String filePath) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(ref, "ref");
        requireNotBlank(filePath, "filePath");
        caller.send(get(CALL_FILES_RAW, id, ref, filePath));
    }

    /**
     * Get user agent detail ({@code GET /snippets/{id}/user_agent_detail}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserAgentDetail> getUserAgentDetail(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET_USER_AGENT_DETAIL, id), GitLabUserAgentDetail.class);
    }
}
