package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of code search. */
public final class GitLabCodeSearchApi extends GitLabResourceApi {
    private static final PathTemplate INDEX_PROJECT = PathTemplate.of("/admin/zoekt/projects/{project_id}/index");
    private static final PathTemplate UPDATE_NAMESPACE = PathTemplate.of("/admin/zoekt/namespaces/{id}");
    private static final PathTemplate GET_SHARDS = PathTemplate.of("/admin/zoekt/shards");
    private static final PathTemplate GET_SHARDS_INDEXED_NAMESPACES =
            PathTemplate.of("/admin/zoekt/shards/{node_id}/indexed_namespaces");
    private static final PathTemplate UPDATE_SHARDS_INDEXED_NAMESPACE =
            PathTemplate.of("/admin/zoekt/shards/{node_id}/indexed_namespaces/{namespace_id}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabCodeSearchApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Index project ({@code PUT /admin/zoekt/projects/{project_id}/index}).
     *
     * @param projectId the project id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSearchZoektProjectIndexSuccess indexProject(final long projectId) throws IOException {
        return caller.fetch(put(INDEX_PROJECT, projectId), GitLabSearchZoektProjectIndexSuccess.class);
    }

    /**
     * Update namespace ({@code PATCH /admin/zoekt/namespaces/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSearchZoektIndexedNamespace updateNamespace(
            final String id, final GitLabCodeSearchUpdateNamespacePayload payload) throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(patch(UPDATE_NAMESPACE, id), payload), GitLabSearchZoektIndexedNamespace.class);
    }

    /**
     * Get shards ({@code GET /admin/zoekt/shards}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSearchZoektNode getShards() throws IOException {
        return caller.fetch(get(GET_SHARDS), GitLabSearchZoektNode.class);
    }

    /**
     * Get shards indexed namespaces ({@code GET /admin/zoekt/shards/{node_id}/indexed_namespaces}).
     *
     * @param nodeId the node id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSearchZoektIndexedNamespace> getShardsIndexedNamespaces(final long nodeId)
            throws IOException {
        return caller.fetchOrEmpty(get(GET_SHARDS_INDEXED_NAMESPACES, nodeId), GitLabSearchZoektIndexedNamespace.class);
    }

    /**
     * Update shards indexed namespace ({@code PUT /admin/zoekt/shards/{node_id}/indexed_namespaces/{namespace_id}}).
     *
     * @param nodeId the node id
     * @param namespaceId the namespace id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSearchZoektIndexedNamespace updateShardsIndexedNamespace(
            final long nodeId,
            final long namespaceId,
            final GitLabCodeSearchUpdateShardsIndexedNamespacePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(put(UPDATE_SHARDS_INDEXED_NAMESPACE, nodeId, namespaceId), payload),
                GitLabSearchZoektIndexedNamespace.class);
    }

    /**
     * Delete shards indexed namespace ({@code DELETE /admin/zoekt/shards/{node_id}/indexed_namespaces/{namespace_id}}).
     *
     * @param nodeId the node id
     * @param namespaceId the namespace id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteShardsIndexedNamespace(final long nodeId, final long namespaceId) throws IOException {
        caller.send(delete(UPDATE_SHARDS_INDEXED_NAMESPACE, nodeId, namespaceId));
    }
}
