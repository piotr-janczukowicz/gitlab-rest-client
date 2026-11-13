package io.github.piotr_janczukowicz.gitlab.api.labels;

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

/** The GitLab operations of project labels. */
public final class GitLabProjectLabelsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate SUBSCRIBE = PathTemplate.of("/projects/{id}/labels/{subscribable_id}/subscribe");
    private static final PathTemplate UNSUBSCRIBE =
            PathTemplate.of("/projects/{id}/labels/{subscribable_id}/unsubscribe");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/labels");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/labels/{name}");
    private static final PathTemplate PROMOTE = PathTemplate.of("/projects/{id}/labels/promote");
    private static final PathTemplate PROMOTE_BY_NAME = PathTemplate.of("/projects/{id}/labels/{name}/promote");
    private static final JsonType<List<GitLabProjectLabel>> PROJECT_LABEL_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectLabel.class);
    private static final GitLabListSpec<GitLabProjectLabel> PROJECT_LABEL_SPEC =
            GitLabListSpec.offset(PROJECT_LABEL_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectLabelsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Subscribe ({@code POST /projects/{id}/labels/{subscribable_id}/subscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectLabel subscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(SUBSCRIBE, id, subscribableId), GitLabProjectLabel.class);
    }

    /**
     * Unsubscribe ({@code POST /projects/{id}/labels/{subscribable_id}/unsubscribe}).
     *
     * @param id the id
     * @param subscribableId the subscribable id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code subscribableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectLabel unsubscribe(final String id, final String subscribableId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(subscribableId, "subscribableId");
        return caller.fetch(post(UNSUBSCRIBE, id, subscribableId), GitLabProjectLabel.class);
    }

    /**
     * List ({@code GET /projects/{id}/labels}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectLabel> list(final String id) throws IOException {
        return list(id, GitLabProjectLabelsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/labels}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectLabel> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectLabelsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/labels}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectLabel> list(final String id, final GitLabProjectLabelsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/labels}).
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
    public GitLabPage<GitLabProjectLabel> list(
            final String id, final GitLabProjectLabelsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PROJECT_LABEL_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/labels}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectLabel create(final String id, final GitLabProjectLabelsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabProjectLabel.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/labels}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabProjectLabel update(final String id, final GitLabProjectLabelsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(LIST, id), payload), GitLabProjectLabel.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/labels}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public void delete(final String id) throws IOException {
        delete(id, GitLabProjectLabelsDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /projects/{id}/labels}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public void delete(final String id, final GitLabProjectLabelsDeleteFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(LIST, id).withQuery(queryParameters));
    }

    /**
     * Get ({@code GET /projects/{id}/labels/{name}}).
     *
     * @param id the id
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectLabel> get(final String id, final String name) throws IOException {
        return get(id, name, GitLabProjectLabelsGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}/labels/{name}}).
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
    public Optional<GitLabProjectLabel> get(
            final String id, final String name, final GitLabProjectLabelsGetFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, name).withQuery(queryParameters), GitLabProjectLabel.class);
    }

    /**
     * Update by name ({@code PUT /projects/{id}/labels/{name}}).
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
    public GitLabProjectLabel updateByName(
            final String id, final String name, final GitLabProjectLabelsUpdateByNamePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, name), payload), GitLabProjectLabel.class);
    }

    /**
     * Delete by name ({@code DELETE /projects/{id}/labels/{name}}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteByName(final String id, final String name) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        caller.send(delete(GET, id, name));
    }

    /**
     * Promote ({@code PUT /projects/{id}/labels/promote}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabGroupLabel promote(final String id, final GitLabProjectLabelsPromotePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PROMOTE, id), payload), GitLabGroupLabel.class);
    }

    /**
     * Promote by name ({@code PUT /projects/{id}/labels/{name}/promote}).
     *
     * @param id the id
     * @param name the name
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupLabel promoteByName(final String id, final String name) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        return caller.fetch(put(PROMOTE_BY_NAME, id, name), GitLabGroupLabel.class);
    }
}
