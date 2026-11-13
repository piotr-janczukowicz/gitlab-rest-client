package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
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

/** The GitLab operations of project project snippets. */
public final class GitLabProjectProjectSnippetsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/snippets");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/snippets/{snippet_id}");
    private static final PathTemplate GET_RAW = PathTemplate.of("/projects/{id}/snippets/{snippet_id}/raw");
    private static final PathTemplate GET_FILES_RAW =
            PathTemplate.of("/projects/{id}/snippets/{snippet_id}/files/{ref}/{file_path}/raw");
    private static final PathTemplate GET_USER_AGENT_DETAIL =
            PathTemplate.of("/projects/{id}/snippets/{snippet_id}/user_agent_detail");
    private static final JsonType<List<GitLabProjectSnippet>> PROJECT_SNIPPET_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectSnippet.class);
    private static final GitLabListSpec<GitLabProjectSnippet> PROJECT_SNIPPET_SPEC =
            GitLabListSpec.offset(PROJECT_SNIPPET_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectSnippetsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/snippets}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectSnippet> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/snippets}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectSnippet> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, PROJECT_SNIPPET_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/snippets}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectSnippet create(final String id, final GitLabProjectProjectSnippetsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabProjectSnippet.class);
    }

    /**
     * Get ({@code GET /projects/{id}/snippets/{snippet_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectSnippet> get(final String id, final long snippetId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, snippetId), GitLabProjectSnippet.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/snippets/{snippet_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectSnippet update(
            final String id, final long snippetId, final GitLabProjectProjectSnippetsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, snippetId), payload), GitLabProjectSnippet.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/snippets/{snippet_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long snippetId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, snippetId));
    }

    /**
     * Get raw ({@code GET /projects/{id}/snippets/{snippet_id}/raw}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectSnippet> getRaw(final String id, final long snippetId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_RAW, id, snippetId), GitLabProjectSnippet.class);
    }

    /**
     * Get files raw ({@code GET /projects/{id}/snippets/{snippet_id}/files/{ref}/{file_path}/raw}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param ref the ref
     * @param filePath the file path
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code ref} or {@code filePath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectSnippet> getFilesRaw(
            final String id, final long snippetId, final String ref, final String filePath) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(ref, "ref");
        requireNotBlank(filePath, "filePath");
        return caller.fetchOrEmpty(get(GET_FILES_RAW, id, snippetId, ref, filePath), GitLabProjectSnippet.class);
    }

    /**
     * Get user agent detail ({@code GET /projects/{id}/snippets/{snippet_id}/user_agent_detail}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserAgentDetail> getUserAgentDetail(final String id, final long snippetId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_USER_AGENT_DETAIL, id, snippetId), GitLabUserAgentDetail.class);
    }
}
