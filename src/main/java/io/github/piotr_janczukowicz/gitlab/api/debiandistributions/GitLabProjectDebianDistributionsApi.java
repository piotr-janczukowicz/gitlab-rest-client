package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackageDebianDistribution;
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

/** The GitLab operations of project debian distributions. */
public final class GitLabProjectDebianDistributionsApi extends GitLabResourceApi {
    private static final String PARAM_CODENAME = "codename";
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/debian_distributions");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/debian_distributions/{codename}");
    private static final PathTemplate GET_KEY_ASC =
            PathTemplate.of("/projects/{id}/debian_distributions/{codename}/key.asc");
    private static final JsonType<List<GitLabPackageDebianDistribution>> PACKAGE_DEBIAN_DISTRIBUTION_LIST_TYPE =
            JsonTypes.listOf(GitLabPackageDebianDistribution.class);
    private static final GitLabListSpec<GitLabPackageDebianDistribution> PACKAGE_DEBIAN_DISTRIBUTION_SPEC =
            GitLabListSpec.offset(PACKAGE_DEBIAN_DISTRIBUTION_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDebianDistributionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/debian_distributions}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> list(final String id) throws IOException {
        return list(id, GitLabProjectDebianDistributionsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/debian_distributions}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabProjectDebianDistributionsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/debian_distributions}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> list(
            final String id, final GitLabProjectDebianDistributionsListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/debian_distributions}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> list(
            final String id, final GitLabProjectDebianDistributionsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PACKAGE_DEBIAN_DISTRIBUTION_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/debian_distributions}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageDebianDistribution create(
            final String id, final GitLabProjectDebianDistributionsCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabPackageDebianDistribution.class);
    }

    /**
     * Get ({@code GET /projects/{id}/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageDebianDistribution> get(final String id, final String codename) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        return caller.fetchOrEmpty(get(GET, id, codename), GitLabPackageDebianDistribution.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageDebianDistribution update(
            final String id, final String codename, final GitLabProjectDebianDistributionsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, codename), payload), GitLabPackageDebianDistribution.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String codename) throws IOException {
        delete(id, codename, GitLabProjectDebianDistributionsDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /projects/{id}/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(
            final String id, final String codename, final GitLabProjectDebianDistributionsDeleteFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(GET, id, codename).withQuery(queryParameters));
    }

    /**
     * Get key asc ({@code GET /projects/{id}/debian_distributions/{codename}/key.asc}).
     *
     * @param id the id
     * @param codename the codename
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageDebianDistribution> getKeyAsc(final String id, final String codename)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        return caller.fetchOrEmpty(get(GET_KEY_ASC, id, codename), GitLabPackageDebianDistribution.class);
    }
}
