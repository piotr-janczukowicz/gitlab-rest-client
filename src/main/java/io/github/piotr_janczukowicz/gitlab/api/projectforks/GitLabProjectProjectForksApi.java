package io.github.piotr_janczukowicz.gitlab.api.projectforks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
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

/** The GitLab operations of project project forks. */
public final class GitLabProjectProjectForksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate CREATE = PathTemplate.of("/projects/{id}/fork");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/forks");
    private static final PathTemplate CREATE_BY_FORKED_FROM_ID =
            PathTemplate.of("/projects/{id}/fork/{forked_from_id}");
    private static final JsonType<List<GitLabProject>> PROJECT_LIST_TYPE = JsonTypes.listOf(GitLabProject.class);
    private static final GitLabListSpec<GitLabProject> PROJECT_SPEC = GitLabListSpec.offset(PROJECT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectForksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /projects/{id}/fork}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject create(final String id, final GitLabProjectProjectForksCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE, id), payload), GitLabProject.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/fork}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(CREATE, id));
    }

    /**
     * List ({@code GET /projects/{id}/forks}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> list(final String id) throws IOException {
        return list(id, GitLabProjectProjectForksListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/forks}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectProjectForksListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/forks}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> list(final String id, final GitLabProjectProjectForksListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/forks}).
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
    public GitLabPage<GitLabProject> list(
            final String id, final GitLabProjectProjectForksListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PROJECT_SPEC, id);
    }

    /**
     * Create by forked from id ({@code POST /projects/{id}/fork/{forked_from_id}}).
     *
     * @param id the id
     * @param forkedFromId the forked from id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code forkedFromId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject createByForkedFromId(final String id, final String forkedFromId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(forkedFromId, "forkedFromId");
        return caller.fetch(post(CREATE_BY_FORKED_FROM_ID, id, forkedFromId), GitLabProject.class);
    }
}
