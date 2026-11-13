package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

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

/** The GitLab operations of instance deploy tokens. */
public final class GitLabInstanceDeployTokensApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/deploy_tokens");
    private static final JsonType<List<GitLabDeployToken>> DEPLOY_TOKEN_LIST_TYPE =
            JsonTypes.listOf(GitLabDeployToken.class);
    private static final GitLabListSpec<GitLabDeployToken> DEPLOY_TOKEN_SPEC =
            GitLabListSpec.offset(DEPLOY_TOKEN_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceDeployTokensApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /deploy_tokens}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployToken> list() throws IOException {
        return list(GitLabInstanceDeployTokensListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /deploy_tokens}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployToken> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabInstanceDeployTokensListFilter.empty(), request);
    }

    /**
     * List ({@code GET /deploy_tokens}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployToken> list(final GitLabInstanceDeployTokensListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /deploy_tokens}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployToken> list(
            final GitLabInstanceDeployTokensListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, DEPLOY_TOKEN_SPEC);
    }
}
