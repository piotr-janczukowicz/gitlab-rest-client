package io.github.piotr_janczukowicz.gitlab.api.todos;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
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

/** The GitLab operations of to dos. */
public final class GitLabToDosApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/todos");
    private static final PathTemplate MARK_AS_DONE_BY_ID = PathTemplate.of("/todos/{id}/mark_as_done");
    private static final PathTemplate MARK_AS_DONE = PathTemplate.of("/todos/mark_as_done");
    private static final JsonType<List<GitLabTodo>> TODO_LIST_TYPE = JsonTypes.listOf(GitLabTodo.class);
    private static final GitLabListSpec<GitLabTodo> TODO_SPEC = GitLabListSpec.offset(TODO_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabToDosApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /todos}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTodo> list() throws IOException {
        return list(GitLabToDosListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /todos}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTodo> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabToDosListFilter.empty(), request);
    }

    /**
     * List ({@code GET /todos}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTodo> list(final GitLabToDosListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /todos}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTodo> list(final GitLabToDosListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, TODO_SPEC);
    }

    /**
     * Mark as done by id ({@code POST /todos/{id}/mark_as_done}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabTodo markAsDoneById(final long id) throws IOException {
        return caller.fetch(post(MARK_AS_DONE_BY_ID, id), GitLabTodo.class);
    }

    /**
     * Mark as done ({@code POST /todos/mark_as_done}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void markAsDone() throws IOException {
        caller.send(post(MARK_AS_DONE));
    }
}
