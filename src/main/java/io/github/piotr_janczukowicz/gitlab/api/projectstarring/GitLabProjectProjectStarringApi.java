package io.github.piotr_janczukowicz.gitlab.api.projectstarring;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
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

/** The GitLab operations of project project starring. */
public final class GitLabProjectProjectStarringApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate CREATE_STAR = PathTemplate.of("/projects/{id}/star");
    private static final PathTemplate CREATE_UNSTAR = PathTemplate.of("/projects/{id}/unstar");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/starrers");
    private static final JsonType<List<GitLabUserBasic>> USER_BASIC_LIST_TYPE = JsonTypes.listOf(GitLabUserBasic.class);
    private static final GitLabListSpec<GitLabUserBasic> USER_BASIC_SPEC = GitLabListSpec.offset(USER_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectStarringApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create star ({@code POST /projects/{id}/star}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject createStar(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CREATE_STAR, id), GitLabProject.class);
    }

    /**
     * Create unstar ({@code POST /projects/{id}/unstar}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProject createUnstar(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CREATE_UNSTAR, id), GitLabProject.class);
    }

    /**
     * List ({@code GET /projects/{id}/starrers}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list(final String id) throws IOException {
        return list(id, GitLabProjectProjectStarringListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/starrers}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectProjectStarringListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/starrers}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list(final String id, final GitLabProjectProjectStarringListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/starrers}).
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
    public GitLabPage<GitLabUserBasic> list(
            final String id, final GitLabProjectProjectStarringListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, USER_BASIC_SPEC, id);
    }
}
