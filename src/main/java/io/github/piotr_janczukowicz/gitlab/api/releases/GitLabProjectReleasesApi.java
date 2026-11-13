package io.github.piotr_janczukowicz.gitlab.api.releases;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelease;
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

/** The GitLab operations of project releases. */
public final class GitLabProjectReleasesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_TAGNAME = "tagName";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/releases");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/releases/{tag_name}");
    private static final PathTemplate CALL_DOWNLOAD =
            PathTemplate.of("/projects/{id}/releases/{tag_name}/downloads/{direct_asset_path}");
    private static final PathTemplate CALL_PERMALINK_LATEST =
            PathTemplate.of("/projects/{id}/releases/permalink/latest");
    private static final PathTemplate CALL_PERMALINK_LATEST_BY_SUFFIX_PATH =
            PathTemplate.of("/projects/{id}/releases/permalink/latest/{suffix_path}");
    private static final PathTemplate EVIDENCE = PathTemplate.of("/projects/{id}/releases/{tag_name}/evidence");
    private static final JsonType<List<GitLabRelease>> RELEASE_LIST_TYPE = JsonTypes.listOf(GitLabRelease.class);
    private static final GitLabListSpec<GitLabRelease> RELEASE_SPEC = GitLabListSpec.offset(RELEASE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectReleasesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/releases}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabRelease> list(final String id) throws IOException {
        return list(id, GitLabProjectReleasesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/releases}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabRelease> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectReleasesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/releases}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabRelease> list(final String id, final GitLabProjectReleasesListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/releases}).
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
    public GitLabPage<GitLabRelease> list(
            final String id, final GitLabProjectReleasesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, RELEASE_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/releases}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRelease create(final String id, final GitLabProjectReleasesCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabRelease.class);
    }

    /**
     * Get ({@code GET /projects/{id}/releases/{tag_name}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabRelease> get(final String id, final String tagName) throws IOException {
        return get(id, tagName, GitLabProjectReleasesGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}/releases/{tag_name}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabRelease> get(
            final String id, final String tagName, final GitLabProjectReleasesGetFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, tagName).withQuery(queryParameters), GitLabRelease.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/releases/{tag_name}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRelease update(final String id, final String tagName, final GitLabProjectReleasesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, tagName), payload), GitLabRelease.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/releases/{tag_name}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabRelease> delete(final String id, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        return caller.fetchOptional(delete(GET, id, tagName), GitLabRelease.class);
    }

    /**
     * Call download ({@code GET /projects/{id}/releases/{tag_name}/downloads/{direct_asset_path}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param directAssetPath the direct asset path
     * @throws IllegalArgumentException if {@code id}, {@code tagName} or {@code directAssetPath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDownload(final String id, final String tagName, final String directAssetPath) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        requireNotBlank(directAssetPath, "directAssetPath");
        caller.send(get(CALL_DOWNLOAD, id, tagName, directAssetPath));
    }

    /**
     * Call permalink latest ({@code GET /projects/{id}/releases/permalink/latest}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPermalinkLatest(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PERMALINK_LATEST, id));
    }

    /**
     * Call permalink latest by suffix path ({@code GET /projects/{id}/releases/permalink/latest/{suffix_path}}).
     *
     * @param id the id
     * @param suffixPath the suffix path
     * @throws IllegalArgumentException if {@code id} or {@code suffixPath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPermalinkLatestBySuffixPath(final String id, final String suffixPath) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(suffixPath, "suffixPath");
        caller.send(get(CALL_PERMALINK_LATEST_BY_SUFFIX_PATH, id, suffixPath));
    }

    /**
     * Evidence ({@code POST /projects/{id}/releases/{tag_name}/evidence}).
     *
     * @param id the id
     * @param tagName the tag name
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRelease evidence(final String id, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        return caller.fetch(post(EVIDENCE, id, tagName), GitLabRelease.class);
    }
}
