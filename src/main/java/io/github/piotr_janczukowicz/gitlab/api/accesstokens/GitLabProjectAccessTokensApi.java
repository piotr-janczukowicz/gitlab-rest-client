package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project access tokens. */
public final class GitLabProjectAccessTokensApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_TOKENID = "tokenId";
    private static final PathTemplate ROTATE_SELF = PathTemplate.of("/projects/{id}/access_tokens/self/rotate");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/access_tokens");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/access_tokens/{token_id}");
    private static final PathTemplate ROTATE = PathTemplate.of("/projects/{id}/access_tokens/{token_id}/rotate");
    private static final JsonType<List<GitLabResourceAccessToken>> RESOURCE_ACCESS_TOKEN_LIST_TYPE =
            JsonTypes.listOf(GitLabResourceAccessToken.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectAccessTokensApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Rotate self ({@code POST /projects/{id}/access_tokens/self/rotate}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabResourceAccessTokenWithToken rotateSelf(
            final String id, final GitLabProjectAccessTokensRotateSelfPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(ROTATE_SELF, id), payload), GitLabResourceAccessTokenWithToken.class);
    }

    /**
     * List ({@code GET /projects/{id}/access_tokens}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabResourceAccessToken> list(final String id) throws IOException {
        return list(id, GitLabProjectAccessTokensListFilter.empty());
    }

    /**
     * List ({@code GET /projects/{id}/access_tokens}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabResourceAccessToken> list(final String id, final GitLabProjectAccessTokensListFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST, id).withQuery(queryParameters), RESOURCE_ACCESS_TOKEN_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/access_tokens}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabResourceAccessTokenWithToken create(
            final String id, final GitLabProjectAccessTokensCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabResourceAccessTokenWithToken.class);
    }

    /**
     * Get ({@code GET /projects/{id}/access_tokens/{token_id}}).
     *
     * @param id the id
     * @param tokenId the token id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tokenId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabResourceAccessToken> get(final String id, final String tokenId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tokenId, PARAM_TOKENID);
        return caller.fetchOrEmpty(get(GET, id, tokenId), GitLabResourceAccessToken.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/access_tokens/{token_id}}).
     *
     * @param id the id
     * @param tokenId the token id
     * @throws IllegalArgumentException if {@code id} or {@code tokenId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String tokenId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tokenId, PARAM_TOKENID);
        caller.send(delete(GET, id, tokenId));
    }

    /**
     * Rotate ({@code POST /projects/{id}/access_tokens/{token_id}/rotate}).
     *
     * @param id the id
     * @param tokenId the token id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code tokenId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabResourceAccessTokenWithToken rotate(
            final String id, final String tokenId, final GitLabProjectAccessTokensRotatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tokenId, PARAM_TOKENID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(ROTATE, id, tokenId), payload), GitLabResourceAccessTokenWithToken.class);
    }
}
