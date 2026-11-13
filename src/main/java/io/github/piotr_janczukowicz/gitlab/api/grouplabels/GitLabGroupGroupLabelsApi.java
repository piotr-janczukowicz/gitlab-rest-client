package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupLabel;
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

/** The GitLab operations of group group labels. */
public final class GitLabGroupGroupLabelsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate SUBSCRIBE = PathTemplate.of("/groups/{id}/labels/{subscribable_id}/subscribe");
    private static final PathTemplate UNSUBSCRIBE =
            PathTemplate.of("/groups/{id}/labels/{subscribable_id}/unsubscribe");
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/labels");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/labels/{name}");
    private static final JsonType<List<GitLabGroupLabel>> GROUP_LABEL_LIST_TYPE =
            JsonTypes.listOf(GitLabGroupLabel.class);
    private static final GitLabListSpec<GitLabGroupLabel> GROUP_LABEL_SPEC =
            GitLabListSpec.offset(GROUP_LABEL_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupLabelsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Subscribe ({@code POST /groups/{id}/labels/{subscribable_id}/subscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupLabel subscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(SUBSCRIBE, id, subscribableId), GitLabGroupLabel.class);
    }

    /**
     * Unsubscribe ({@code POST /groups/{id}/labels/{subscribable_id}/unsubscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupLabel unsubscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(UNSUBSCRIBE, id, subscribableId), GitLabGroupLabel.class);
    }

    /**
     * List ({@code GET /groups/{id}/labels}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroupLabel> list(final String id) throws IOException {
        return list(id, GitLabGroupGroupLabelsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/labels}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroupLabel> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabGroupGroupLabelsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/labels}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroupLabel> list(final String id, final GitLabGroupGroupLabelsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/labels}).
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
    public GitLabPage<GitLabGroupLabel> list(
            final String id, final GitLabGroupGroupLabelsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, GROUP_LABEL_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/labels}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupLabel create(final String id, final GitLabGroupGroupLabelsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabGroupLabel.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/labels}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupLabel update(final String id, final GitLabGroupGroupLabelsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(LIST, id), payload), GitLabGroupLabel.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/labels}).
     *
     * @param id the id
     * @param name the name
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGroupLabel> delete(final String id, final String name) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_NAME, name).build();
        return caller.fetchOptional(delete(LIST, id).withQuery(queryParameters), GitLabGroupLabel.class);
    }

    /**
     * Get ({@code GET /groups/{id}/labels/{name}}).
     *
     * @param id the id
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGroupLabel> get(final String id, final String name) throws IOException {
        return get(id, name, GitLabGroupGroupLabelsGetFilter.empty());
    }

    /**
     * Get ({@code GET /groups/{id}/labels/{name}}).
     *
     * @param id the id
     * @param name the name
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGroupLabel> get(
            final String id, final String name, final GitLabGroupGroupLabelsGetFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, name).withQuery(queryParameters), GitLabGroupLabel.class);
    }

    /**
     * Update by name ({@code PUT /groups/{id}/labels/{name}}).
     *
     * @param id the id
     * @param name the name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupLabel updateByName(
            final String id, final String name, final GitLabGroupGroupLabelsUpdateByNamePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, name), payload), GitLabGroupLabel.class);
    }

    /**
     * Delete by name ({@code DELETE /groups/{id}/labels/{name}}).
     *
     * @param id the id
     * @param name the name
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGroupLabel> deleteByName(final String id, final String name) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        return caller.fetchOptional(delete(GET, id, name), GitLabGroupLabel.class);
    }
}
