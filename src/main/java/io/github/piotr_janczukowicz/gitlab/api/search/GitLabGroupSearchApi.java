package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of group search. */
public final class GitLabGroupSearchApi extends GitLabResourceApi {
    private static final PathTemplate CALL = PathTemplate.of("/groups/{id}/search");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupSearchApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /groups/{id}/(-/)search}).
     *
     * @param id the id
     * @param search the search
     * @param scope the scope
     * @throws IllegalArgumentException if {@code id} or {@code search} is blank
     * @throws NullPointerException if {@code scope} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id, final String search, final GitLabGroupSearchCallScope scope) throws IOException {
        call(id, search, scope, GitLabGroupSearchCallFilter.empty());
    }

    /**
     * Call ({@code GET /groups/{id}/(-/)search}).
     *
     * @param id the id
     * @param search the search
     * @param scope the scope
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code search} is blank
     * @throws NullPointerException if {@code scope} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(
            final String id,
            final String search,
            final GitLabGroupSearchCallScope scope,
            final GitLabGroupSearchCallFilter filter)
            throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(search, "search");
        requireNonNull(scope, "scope");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("search", search)
                .wire("scope", scope, GitLabGroupSearchCallScope::wireValue)
                .build();
        caller.send(get(CALL, id).withQuery(queryParameters));
    }
}
