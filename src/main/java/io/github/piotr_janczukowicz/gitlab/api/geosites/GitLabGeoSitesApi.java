package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

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

/** The GitLab operations of geo sites. */
public final class GitLabGeoSitesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/geo_sites");
    private static final PathTemplate LIST_STATUS = PathTemplate.of("/geo_sites/status");
    private static final PathTemplate GET = PathTemplate.of("/geo_sites/{id}");
    private static final PathTemplate GET_STATUS = PathTemplate.of("/geo_sites/{id}/status");
    private static final PathTemplate REPAIR = PathTemplate.of("/geo_sites/{id}/repair");
    private static final JsonType<List<GitLabGeoSite>> GEO_SITE_LIST_TYPE = JsonTypes.listOf(GitLabGeoSite.class);
    private static final JsonType<List<GitLabGeoSiteStatus>> GEO_SITE_STATUS_LIST_TYPE =
            JsonTypes.listOf(GitLabGeoSiteStatus.class);
    private static final GitLabListSpec<GitLabGeoSite> GEO_SITE_SPEC = GitLabListSpec.offset(GEO_SITE_LIST_TYPE);
    private static final GitLabListSpec<GitLabGeoSiteStatus> GEO_SITE_STATUS_SPEC =
            GitLabListSpec.offset(GEO_SITE_STATUS_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGeoSitesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /geo_sites}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoSite> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /geo_sites}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoSite> list(final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoSites");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, GEO_SITE_SPEC);
    }

    /**
     * Create ({@code POST /geo_sites}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGeoSite create(final GitLabGeoSitesCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GeoSites");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabGeoSite.class);
    }

    /**
     * List status ({@code GET /geo_sites/status}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoSiteStatus> listStatus() throws IOException {
        return listStatus(GitLabPageRequest.byPage());
    }

    /**
     * List status ({@code GET /geo_sites/status}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGeoSiteStatus> listStatus(final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoSitesStatus");
        requireNonNull(request, "request");
        return pageList(LIST_STATUS, Map.of(), request, GEO_SITE_STATUS_SPEC);
    }

    /**
     * Get ({@code GET /geo_sites/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGeoSite> get(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoSitesId");
        return caller.fetchOrEmpty(get(GET, id), GitLabGeoSite.class);
    }

    /**
     * Update ({@code PUT /geo_sites/{id}}).
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
    public GitLabGeoSite update(final long id, final GitLabGeoSitesUpdatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GeoSitesId");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabGeoSite.class);
    }

    /**
     * Delete ({@code DELETE /geo_sites/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GeoSitesId");
        caller.send(delete(GET, id));
    }

    /**
     * Get status ({@code GET /geo_sites/{id}/status}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGeoSiteStatus> getStatus(final long id) throws IOException {
        return getStatus(id, GitLabGeoSitesGetStatusFilter.empty());
    }

    /**
     * Get status ({@code GET /geo_sites/{id}/status}).
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
    public Optional<GitLabGeoSiteStatus> getStatus(final long id, final GitLabGeoSitesGetStatusFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GeoSitesIdStatus");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET_STATUS, id).withQuery(queryParameters), GitLabGeoSiteStatus.class);
    }

    /**
     * Repair ({@code POST /geo_sites/{id}/repair}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGeoSiteStatus repair(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GeoSitesIdRepair");
        return caller.fetch(post(REPAIR, id), GitLabGeoSiteStatus.class);
    }
}
