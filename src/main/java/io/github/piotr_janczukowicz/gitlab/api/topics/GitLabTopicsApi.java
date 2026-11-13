package io.github.piotr_janczukowicz.gitlab.api.topics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of topics. */
public final class GitLabTopicsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/topics");
    private static final PathTemplate GET = PathTemplate.of("/topics/{id}");
    private static final PathTemplate MERGE = PathTemplate.of("/topics/merge");
    private static final JsonType<List<GitLabProjectTopic>> PROJECT_TOPIC_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectTopic.class);
    private static final GitLabListSpec<GitLabProjectTopic> PROJECT_TOPIC_SPEC =
            GitLabListSpec.offset(PROJECT_TOPIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabTopicsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /topics}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectTopic> list() throws IOException {
        return list(GitLabTopicsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /topics}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectTopic> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabTopicsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /topics}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectTopic> list(final GitLabTopicsListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /topics}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectTopic> list(final GitLabTopicsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PROJECT_TOPIC_SPEC);
    }

    /**
     * Create ({@code POST /topics}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectTopic create(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST), form), GitLabProjectTopic.class);
    }

    /**
     * Get ({@code GET /topics/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectTopic> get(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET, id), GitLabProjectTopic.class);
    }

    /**
     * Update ({@code PUT /topics/{id}}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectTopic update(final long id, final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(put(GET, id), form), GitLabProjectTopic.class);
    }

    /**
     * Delete ({@code DELETE /topics/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long id) throws IOException {
        caller.send(delete(GET, id));
    }

    /**
     * Merge ({@code POST /topics/merge}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectTopic merge(final GitLabTopicsMergePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(MERGE), payload), GitLabProjectTopic.class);
    }
}
