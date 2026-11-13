package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployKey;
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

/** The GitLab operations of instance deploy keys. */
public final class GitLabInstanceDeployKeysApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/deploy_keys");
    private static final JsonType<List<GitLabDeployKey>> DEPLOY_KEY_LIST_TYPE = JsonTypes.listOf(GitLabDeployKey.class);
    private static final GitLabListSpec<GitLabDeployKey> DEPLOY_KEY_SPEC = GitLabListSpec.offset(DEPLOY_KEY_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceDeployKeysApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /deploy_keys}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKey> list() throws IOException {
        return list(GitLabInstanceDeployKeysListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /deploy_keys}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKey> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabInstanceDeployKeysListFilter.empty(), request);
    }

    /**
     * List ({@code GET /deploy_keys}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKey> list(final GitLabInstanceDeployKeysListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /deploy_keys}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKey> list(
            final GitLabInstanceDeployKeysListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, DEPLOY_KEY_SPEC);
    }

    /**
     * Create ({@code POST /deploy_keys}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDeployKey create(final GitLabInstanceDeployKeysCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabDeployKey.class);
    }
}
