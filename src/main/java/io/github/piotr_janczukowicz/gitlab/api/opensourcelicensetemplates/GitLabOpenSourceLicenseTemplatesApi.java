package io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLicense;
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

/** The GitLab operations of open source license templates. */
public final class GitLabOpenSourceLicenseTemplatesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/templates/licenses");
    private static final PathTemplate GET = PathTemplate.of("/templates/licenses/{name}");
    private static final JsonType<List<GitLabLicense>> LICENSE_LIST_TYPE = JsonTypes.listOf(GitLabLicense.class);
    private static final GitLabListSpec<GitLabLicense> LICENSE_SPEC = GitLabListSpec.offset(LICENSE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabOpenSourceLicenseTemplatesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /templates/licenses}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabLicense> list() throws IOException {
        return list(GitLabOpenSourceLicenseTemplatesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /templates/licenses}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabLicense> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabOpenSourceLicenseTemplatesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /templates/licenses}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabLicense> list(final GitLabOpenSourceLicenseTemplatesListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /templates/licenses}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabLicense> list(
            final GitLabOpenSourceLicenseTemplatesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, LICENSE_SPEC);
    }

    /**
     * Get ({@code GET /templates/licenses/{name}}).
     *
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabLicense> get(final String name) throws IOException {
        return get(name, GitLabOpenSourceLicenseTemplatesGetFilter.empty());
    }

    /**
     * Get ({@code GET /templates/licenses/{name}}).
     *
     * @param name the name
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabLicense> get(final String name, final GitLabOpenSourceLicenseTemplatesGetFilter filter)
            throws IOException {
        requireNotBlank(name, "name");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, name).withQuery(queryParameters), GitLabLicense.class);
    }
}
