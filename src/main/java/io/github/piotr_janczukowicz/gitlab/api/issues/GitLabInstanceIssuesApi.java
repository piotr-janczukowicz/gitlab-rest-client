package io.github.piotr_janczukowicz.gitlab.api.issues;

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

/** The GitLab operations of instance issues. */
public final class GitLabInstanceIssuesApi extends GitLabResourceApi {
    private static final PathTemplate CALL_ISSUES_STATISTICS = PathTemplate.of("/issues_statistics");
    private static final PathTemplate LIST = PathTemplate.of("/issues");
    private static final PathTemplate GET = PathTemplate.of("/issues/{id}");
    private static final JsonType<List<GitLabIssue>> ISSUE_LIST_TYPE = JsonTypes.listOf(GitLabIssue.class);
    private static final GitLabListSpec<GitLabIssue> ISSUE_SPEC = GitLabListSpec.offset(ISSUE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceIssuesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call issues statistics ({@code GET /issues_statistics}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callIssuesStatistics() throws IOException {
        callIssuesStatistics(GitLabInstanceIssuesCallIssuesStatisticsFilter.empty());
    }

    /**
     * Call issues statistics ({@code GET /issues_statistics}).
     *
     * @param filter the optional query parameters
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callIssuesStatistics(final GitLabInstanceIssuesCallIssuesStatisticsFilter filter) throws IOException {
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_ISSUES_STATISTICS).withQuery(queryParameters));
    }

    /**
     * List ({@code GET /issues}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list() throws IOException {
        return list(GitLabInstanceIssuesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /issues}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabInstanceIssuesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /issues}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list(final GitLabInstanceIssuesListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /issues}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabIssue> list(final GitLabInstanceIssuesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, ISSUE_SPEC);
    }

    /**
     * Get ({@code GET /issues/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIssue> get(final String id) throws IOException {
        requireNotBlank(id, "id");
        return caller.fetchOrEmpty(get(GET, id), GitLabIssue.class);
    }
}
