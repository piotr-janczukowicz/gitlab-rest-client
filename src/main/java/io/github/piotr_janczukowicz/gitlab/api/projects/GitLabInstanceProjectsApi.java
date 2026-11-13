package io.github.piotr_janczukowicz.gitlab.api.projects;

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

/** The GitLab operations of instance projects. */
public final class GitLabInstanceProjectsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_USERID = "userId";
    private static final PathTemplate LIST = PathTemplate.of("/users/{user_id}/projects");
    private static final PathTemplate LIST_USERS_CONTRIBUTED_PROJECTS =
            PathTemplate.of("/users/{user_id}/contributed_projects");
    private static final PathTemplate LIST_USERS_STARRED_PROJECTS =
            PathTemplate.of("/users/{user_id}/starred_projects");
    private static final JsonType<List<GitLabProjectWithAccess>> PROJECT_WITH_ACCESS_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectWithAccess.class);
    private static final GitLabListSpec<GitLabProjectWithAccess> PROJECT_WITH_ACCESS_SPEC =
            GitLabListSpec.offset(PROJECT_WITH_ACCESS_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceProjectsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /users/{user_id}/projects}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(final String userId) throws IOException {
        return list(userId, GitLabInstanceProjectsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /users/{user_id}/projects}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(final String userId, final GitLabPageRequest request)
            throws IOException {
        return list(userId, GitLabInstanceProjectsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /users/{user_id}/projects}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(final String userId, final GitLabInstanceProjectsListFilter filter)
            throws IOException {
        return list(userId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /users/{user_id}/projects}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> list(
            final String userId, final GitLabInstanceProjectsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(userId, PARAM_USERID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PROJECT_WITH_ACCESS_SPEC, userId);
    }

    /**
     * List users contributed projects ({@code GET /users/{user_id}/contributed_projects}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersContributedProjects(final String userId) throws IOException {
        return listUsersContributedProjects(
                userId, GitLabInstanceProjectsListUsersContributedProjectsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List users contributed projects ({@code GET /users/{user_id}/contributed_projects}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersContributedProjects(
            final String userId, final GitLabPageRequest request) throws IOException {
        return listUsersContributedProjects(
                userId, GitLabInstanceProjectsListUsersContributedProjectsFilter.empty(), request);
    }

    /**
     * List users contributed projects ({@code GET /users/{user_id}/contributed_projects}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersContributedProjects(
            final String userId, final GitLabInstanceProjectsListUsersContributedProjectsFilter filter)
            throws IOException {
        return listUsersContributedProjects(userId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List users contributed projects ({@code GET /users/{user_id}/contributed_projects}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersContributedProjects(
            final String userId,
            final GitLabInstanceProjectsListUsersContributedProjectsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(userId, PARAM_USERID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_USERS_CONTRIBUTED_PROJECTS, queryParameters, request, PROJECT_WITH_ACCESS_SPEC, userId);
    }

    /**
     * List users starred projects ({@code GET /users/{user_id}/starred_projects}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersStarredProjects(final String userId) throws IOException {
        return listUsersStarredProjects(
                userId, GitLabInstanceProjectsListUsersStarredProjectsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List users starred projects ({@code GET /users/{user_id}/starred_projects}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersStarredProjects(
            final String userId, final GitLabPageRequest request) throws IOException {
        return listUsersStarredProjects(userId, GitLabInstanceProjectsListUsersStarredProjectsFilter.empty(), request);
    }

    /**
     * List users starred projects ({@code GET /users/{user_id}/starred_projects}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersStarredProjects(
            final String userId, final GitLabInstanceProjectsListUsersStarredProjectsFilter filter) throws IOException {
        return listUsersStarredProjects(userId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List users starred projects ({@code GET /users/{user_id}/starred_projects}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectWithAccess> listUsersStarredProjects(
            final String userId,
            final GitLabInstanceProjectsListUsersStarredProjectsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(userId, PARAM_USERID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_USERS_STARRED_PROJECTS, queryParameters, request, PROJECT_WITH_ACCESS_SPEC, userId);
    }
}
