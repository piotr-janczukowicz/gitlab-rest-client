package io.github.piotr_janczukowicz.gitlab.api.tags;

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

/** The GitLab operations of project tags. */
public final class GitLabProjectTagsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_TAGNAME = "tagName";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/repository/tags");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/repository/tags/{tag_name}");
    private static final PathTemplate GET_SIGNATURE =
            PathTemplate.of("/projects/{id}/repository/tags/{tag_name}/signature");
    private static final JsonType<List<GitLabTag>> TAG_LIST_TYPE = JsonTypes.listOf(GitLabTag.class);
    private static final GitLabListSpec<GitLabTag> TAG_SPEC = GitLabListSpec.offset(TAG_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectTagsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/repository/tags}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTag> list(final String id) throws IOException {
        return list(id, GitLabProjectTagsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/repository/tags}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTag> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectTagsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/repository/tags}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTag> list(final String id, final GitLabProjectTagsListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/repository/tags}).
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
    public GitLabPage<GitLabTag> list(
            final String id, final GitLabProjectTagsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, TAG_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/repository/tags}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabTag create(final String id, final GitLabProjectTagsCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabTag.class);
    }

    /**
     * Get ({@code GET /projects/{id}/repository/tags/{tag_name}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTag> get(final String id, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        return caller.fetchOrEmpty(get(GET, id, tagName), GitLabTag.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/repository/tags/{tag_name}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        caller.send(delete(GET, id, tagName));
    }

    /**
     * Get signature ({@code GET /projects/{id}/repository/tags/{tag_name}/signature}).
     *
     * @param id the id
     * @param tagName the tag name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTagSignature> getSignature(final String id, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        return caller.fetchOrEmpty(get(GET_SIGNATURE, id, tagName), GitLabTagSignature.class);
    }
}
