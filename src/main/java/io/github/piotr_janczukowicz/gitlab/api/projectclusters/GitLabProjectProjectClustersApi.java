package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCluster;
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

/** The GitLab operations of project project clusters. */
public final class GitLabProjectProjectClustersApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/clusters");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/clusters/{cluster_id}");
    private static final PathTemplate USER = PathTemplate.of("/projects/{id}/clusters/user");
    private static final JsonType<List<GitLabCluster>> CLUSTER_LIST_TYPE = JsonTypes.listOf(GitLabCluster.class);
    private static final GitLabListSpec<GitLabCluster> CLUSTER_SPEC = GitLabListSpec.offset(CLUSTER_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectClustersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/clusters}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCluster> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/clusters}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCluster> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CLUSTER_SPEC, id);
    }

    /**
     * Get ({@code GET /projects/{id}/clusters/{cluster_id}}).
     *
     * @param id the id
     * @param clusterId the cluster id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabClusterProject> get(final String id, final long clusterId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, clusterId), GitLabClusterProject.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/clusters/{cluster_id}}).
     *
     * @param id the id
     * @param clusterId the cluster id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabClusterProject update(
            final String id, final long clusterId, final GitLabProjectProjectClustersUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, clusterId), payload), GitLabClusterProject.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/clusters/{cluster_id}}).
     *
     * @param id the id
     * @param clusterId the cluster id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabClusterProject> delete(final String id, final long clusterId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET, id, clusterId), GitLabClusterProject.class);
    }

    /**
     * User ({@code POST /projects/{id}/clusters/user}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabClusterProject user(final String id, final GitLabProjectClusterUserCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(USER, id), payload), GitLabClusterProject.class);
    }
}
