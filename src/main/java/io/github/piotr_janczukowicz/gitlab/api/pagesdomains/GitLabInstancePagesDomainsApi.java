package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

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

/** The GitLab operations of instance pages domains. */
public final class GitLabInstancePagesDomainsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/pages/domains");
    private static final JsonType<List<GitLabPagesDomainBasic>> PAGES_DOMAIN_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabPagesDomainBasic.class);
    private static final GitLabListSpec<GitLabPagesDomainBasic> PAGES_DOMAIN_BASIC_SPEC =
            GitLabListSpec.offset(PAGES_DOMAIN_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstancePagesDomainsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /pages/domains}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPagesDomainBasic> list() throws IOException {
        return list(GitLabInstancePagesDomainsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /pages/domains}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPagesDomainBasic> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabInstancePagesDomainsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /pages/domains}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPagesDomainBasic> list(final GitLabInstancePagesDomainsListFilter filter)
            throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /pages/domains}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPagesDomainBasic> list(
            final GitLabInstancePagesDomainsListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PAGES_DOMAIN_BASIC_SPEC);
    }
}
