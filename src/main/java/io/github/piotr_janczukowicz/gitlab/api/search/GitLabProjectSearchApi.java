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

/** The GitLab operations of project search. */
public final class GitLabProjectSearchApi extends GitLabResourceApi {
    private static final PathTemplate GET_SEMANTIC = PathTemplate.of("/projects/{id}/search/semantic");
    private static final PathTemplate CALL = PathTemplate.of("/projects/{id}/search");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectSearchApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get semantic ({@code GET /projects/{id}/(-/)search/semantic}).
     *
     * @param id the id
     * @param q the q
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code q} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiSemanticCodeResponse getSemantic(final String id, final String q) throws IOException {
        return getSemantic(id, q, GitLabProjectSearchGetSemanticFilter.empty());
    }

    /**
     * Get semantic ({@code GET /projects/{id}/(-/)search/semantic}).
     *
     * @param id the id
     * @param q the q
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code q} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiSemanticCodeResponse getSemantic(
            final String id, final String q, final GitLabProjectSearchGetSemanticFilter filter) throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(q, "q");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("q", q)
                .build();
        return caller.fetch(get(GET_SEMANTIC, id).withQuery(queryParameters), GitLabAiSemanticCodeResponse.class);
    }

    /**
     * Call ({@code GET /projects/{id}/(-/)search}).
     *
     * @param id the id
     * @param search the search
     * @param scope the scope
     * @throws IllegalArgumentException if {@code id} or {@code search} is blank
     * @throws NullPointerException if {@code scope} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id, final String search, final GitLabProjectSearchCallScope scope)
            throws IOException {
        call(id, search, scope, GitLabProjectSearchCallFilter.empty());
    }

    /**
     * Call ({@code GET /projects/{id}/(-/)search}).
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
            final GitLabProjectSearchCallScope scope,
            final GitLabProjectSearchCallFilter filter)
            throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(search, "search");
        requireNonNull(scope, "scope");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("search", search)
                .wire("scope", scope, GitLabProjectSearchCallScope::wireValue)
                .build();
        caller.send(get(CALL, id).withQuery(queryParameters));
    }
}
