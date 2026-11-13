package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCluster;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of instance clusters. */
public final class GitLabInstanceClustersApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/admin/clusters");
    private static final PathTemplate GET = PathTemplate.of("/admin/clusters/{cluster_id}");
    private static final PathTemplate ADD = PathTemplate.of("/admin/clusters/add");
    private static final JsonType<List<GitLabCluster>> CLUSTER_LIST_TYPE = JsonTypes.listOf(GitLabCluster.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceClustersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /admin/clusters}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabCluster> list() throws IOException {
        return caller.fetch(get(LIST), CLUSTER_LIST_TYPE);
    }

    /**
     * Get ({@code GET /admin/clusters/{cluster_id}}).
     *
     * @param clusterId the cluster id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCluster> get(final long clusterId) throws IOException {
        return caller.fetchOrEmpty(get(GET, clusterId), GitLabCluster.class);
    }

    /**
     * Update ({@code PUT /admin/clusters/{cluster_id}}).
     *
     * @param clusterId the cluster id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCluster update(final long clusterId, final GitLabInstanceClustersUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, clusterId), payload), GitLabCluster.class);
    }

    /**
     * Delete ({@code DELETE /admin/clusters/{cluster_id}}).
     *
     * @param clusterId the cluster id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCluster> delete(final long clusterId) throws IOException {
        return caller.fetchOptional(delete(GET, clusterId), GitLabCluster.class);
    }

    /**
     * Add ({@code POST /admin/clusters/add}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCluster add(final GitLabInstanceClustersAddPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(ADD), payload), GitLabCluster.class);
    }
}
