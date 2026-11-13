package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of project pages domains. */
public final class GitLabProjectPagesDomainsApi extends GitLabResourceApi {
    private static final String PARAM_DOMAIN = "domain";
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/pages/domains");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/pages/domains/{domain}");
    private static final PathTemplate VERIFY = PathTemplate.of("/projects/{id}/pages/domains/{domain}/verify");
    private static final JsonType<List<GitLabPagesDomain>> PAGES_DOMAIN_LIST_TYPE =
            JsonTypes.listOf(GitLabPagesDomain.class);
    private static final GitLabListSpec<GitLabPagesDomain> PAGES_DOMAIN_SPEC =
            GitLabListSpec.offset(PAGES_DOMAIN_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectPagesDomainsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/pages/domains}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPagesDomain> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/pages/domains}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPagesDomain> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, PAGES_DOMAIN_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/pages/domains}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPagesDomain create(final String id, final GitLabProjectPagesDomainsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabPagesDomain.class);
    }

    /**
     * Get ({@code GET /projects/{id}/pages/domains/{domain}}).
     *
     * @param id the id
     * @param domain the domain
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code domain} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPagesDomain> get(final String id, final String domain) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(domain, PARAM_DOMAIN);
        return caller.fetchOrEmpty(get(GET, id, domain), GitLabPagesDomain.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/pages/domains/{domain}}).
     *
     * @param id the id
     * @param domain the domain
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code domain} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final String domain, final GitLabProjectPagesDomainsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(domain, PARAM_DOMAIN);
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(GET, id, domain), payload));
    }

    /**
     * Delete ({@code DELETE /projects/{id}/pages/domains/{domain}}).
     *
     * @param id the id
     * @param domain the domain
     * @throws IllegalArgumentException if {@code id} or {@code domain} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String domain) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(domain, PARAM_DOMAIN);
        caller.send(delete(GET, id, domain));
    }

    /**
     * Verify ({@code PUT /projects/{id}/pages/domains/{domain}/verify}).
     *
     * @param id the id
     * @param domain the domain
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code domain} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPagesDomain verify(final String id, final String domain) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(domain, PARAM_DOMAIN);
        return caller.fetch(put(VERIFY, id, domain), GitLabPagesDomain.class);
    }
}
