package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of namespaces. */
public final class GitLabNamespacesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate GET = PathTemplate.of("/namespaces/{id}");
    private static final PathTemplate GET_GITLAB_SUBSCRIPTION = PathTemplate.of("/namespaces/{id}/gitlab_subscription");
    private static final PathTemplate CREATE_STORAGE_LIMIT_EXCLUSION =
            PathTemplate.of("/namespaces/{id}/storage/limit_exclusion");
    private static final PathTemplate LIST_STORAGE_LIMIT_EXCLUSIONS =
            PathTemplate.of("/namespaces/storage/limit_exclusions");
    private static final PathTemplate LIST = PathTemplate.of("/namespaces");
    private static final PathTemplate GET_EXISTS = PathTemplate.of("/namespaces/{id}/exists");
    private static final JsonType<List<GitLabNamespaceStorageLimitExclusion>>
            NAMESPACE_STORAGE_LIMIT_EXCLUSION_LIST_TYPE = JsonTypes.listOf(GitLabNamespaceStorageLimitExclusion.class);
    private static final JsonType<List<GitLabNamespace>> NAMESPACE_LIST_TYPE = JsonTypes.listOf(GitLabNamespace.class);
    private static final GitLabListSpec<GitLabNamespaceStorageLimitExclusion> NAMESPACE_STORAGE_LIMIT_EXCLUSION_SPEC =
            GitLabListSpec.offset(NAMESPACE_STORAGE_LIMIT_EXCLUSION_LIST_TYPE);
    private static final GitLabListSpec<GitLabNamespace> NAMESPACE_SPEC = GitLabListSpec.offset(NAMESPACE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabNamespacesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /namespaces/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNamespace> get(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id), GitLabNamespace.class);
    }

    /**
     * Update ({@code PUT /namespaces/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNamespace update(final String id, final GitLabNamespacesUpdatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabNamespace.class);
    }

    /**
     * Get gitlab subscription ({@code GET /namespaces/{id}/gitlab_subscription}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGitlabSubscription> getGitlabSubscription(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_GITLAB_SUBSCRIPTION, id), GitLabGitlabSubscription.class);
    }

    /**
     * Create storage limit exclusion ({@code POST /namespaces/{id}/storage/limit_exclusion}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNamespaceStorageLimitExclusion createStorageLimitExclusion(
            final String id, final GitLabNamespacesCreateStorageLimitExclusionPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(post(CREATE_STORAGE_LIMIT_EXCLUSION, id), payload),
                GitLabNamespaceStorageLimitExclusion.class);
    }

    /**
     * Delete storage limit exclusion ({@code DELETE /namespaces/{id}/storage/limit_exclusion}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteStorageLimitExclusion(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(CREATE_STORAGE_LIMIT_EXCLUSION, id));
    }

    /**
     * List storage limit exclusions ({@code GET /namespaces/storage/limit_exclusions}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNamespaceStorageLimitExclusion> listStorageLimitExclusions() throws IOException {
        return listStorageLimitExclusions(GitLabPageRequest.byPage());
    }

    /**
     * List storage limit exclusions ({@code GET /namespaces/storage/limit_exclusions}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNamespaceStorageLimitExclusion> listStorageLimitExclusions(final GitLabPageRequest request)
            throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST_STORAGE_LIMIT_EXCLUSIONS, Map.of(), request, NAMESPACE_STORAGE_LIMIT_EXCLUSION_SPEC);
    }

    /**
     * List ({@code GET /namespaces}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNamespace> list() throws IOException {
        return list(GitLabNamespacesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /namespaces}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNamespace> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabNamespacesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /namespaces}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNamespace> list(final GitLabNamespacesListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /namespaces}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNamespace> list(final GitLabNamespacesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, NAMESPACE_SPEC);
    }

    /**
     * Get exists ({@code GET /namespaces/{id}/exists}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNamespaceExistence> getExists(final String id) throws IOException {
        return getExists(id, GitLabNamespacesGetExistsFilter.empty());
    }

    /**
     * Get exists ({@code GET /namespaces/{id}/exists}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNamespaceExistence> getExists(final String id, final GitLabNamespacesGetExistsFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET_EXISTS, id).withQuery(queryParameters), GitLabNamespaceExistence.class);
    }
}
