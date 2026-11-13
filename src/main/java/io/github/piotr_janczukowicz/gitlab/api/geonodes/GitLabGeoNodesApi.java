package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGeoNodeStatus;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
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

/** The GitLab operations of geo nodes. */
public final class GitLabGeoNodesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/geo_nodes");
    private static final PathTemplate LIST_STATUS = PathTemplate.of("/geo_nodes/status");
    private static final PathTemplate GET = PathTemplate.of("/geo_nodes/{id}");
    private static final PathTemplate GET_STATUS = PathTemplate.of("/geo_nodes/{id}/status");
    private static final PathTemplate REPAIR = PathTemplate.of("/geo_nodes/{id}/repair");
    private static final JsonType<List<GitLabGeoNode>> GEO_NODE_LIST_TYPE = JsonTypes.listOf(GitLabGeoNode.class);
    private static final JsonType<List<GitLabGeoNodeStatus>> GEO_NODE_STATUS_LIST_TYPE =
            JsonTypes.listOf(GitLabGeoNodeStatus.class);
    private static final GitLabListSpec<GitLabGeoNode> GEO_NODE_SPEC = GitLabListSpec.offset(GEO_NODE_LIST_TYPE);
    private static final GitLabListSpec<GitLabGeoNodeStatus> GEO_NODE_STATUS_SPEC =
            GitLabListSpec.offset(GEO_NODE_STATUS_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGeoNodesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /geo_nodes}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoNode> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /geo_nodes}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoNode> list(final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoNodes");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, GEO_NODE_SPEC);
    }

    /**
     * Create ({@code POST /geo_nodes}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGeoNode create(final GitLabGeoNodesCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GeoNodes");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabGeoNode.class);
    }

    /**
     * List status ({@code GET /geo_nodes/status}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoNodeStatus> listStatus() throws IOException {
        return listStatus(GitLabPageRequest.byPage());
    }

    /**
     * List status ({@code GET /geo_nodes/status}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoNodeStatus> listStatus(final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoNodesStatus");
        requireNonNull(request, "request");
        return pageList(LIST_STATUS, Map.of(), request, GEO_NODE_STATUS_SPEC);
    }

    /**
     * Get ({@code GET /geo_nodes/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGeoNode> get(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoNodesId");
        return caller.fetchOrEmpty(get(GET, id), GitLabGeoNode.class);
    }

    /**
     * Update ({@code PUT /geo_nodes/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGeoNode update(final long id, final GitLabGeoNodesUpdatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GeoNodesId");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabGeoNode.class);
    }

    /**
     * Delete ({@code DELETE /geo_nodes/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GeoNodesId");
        caller.send(delete(GET, id));
    }

    /**
     * Get status ({@code GET /geo_nodes/{id}/status}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGeoNodeStatus> getStatus(final long id) throws IOException {
        return getStatus(id, GitLabGeoNodesGetStatusFilter.empty());
    }

    /**
     * Get status ({@code GET /geo_nodes/{id}/status}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGeoNodeStatus> getStatus(final long id, final GitLabGeoNodesGetStatusFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoNodesIdStatus");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET_STATUS, id).withQuery(queryParameters), GitLabGeoNodeStatus.class);
    }

    /**
     * Repair ({@code POST /geo_nodes/{id}/repair}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGeoNodeStatus repair(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GeoNodesIdRepair");
        return caller.fetch(post(REPAIR, id), GitLabGeoNodeStatus.class);
    }
}
