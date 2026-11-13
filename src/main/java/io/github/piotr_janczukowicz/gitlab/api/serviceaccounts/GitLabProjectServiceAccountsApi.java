package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessToken;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
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

/** The GitLab operations of project service accounts. */
public final class GitLabProjectServiceAccountsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/service_accounts");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/service_accounts/{user_id}");
    private static final PathTemplate LIST_PERSONAL_ACCESS_TOKENS =
            PathTemplate.of("/projects/{id}/service_accounts/{user_id}/personal_access_tokens");
    private static final PathTemplate DELETE_PERSONAL_ACCESS_TOKEN =
            PathTemplate.of("/projects/{id}/service_accounts/{user_id}/personal_access_tokens/{token_id}");
    private static final PathTemplate ROTATE_PERSONAL_ACCESS_TOKEN =
            PathTemplate.of("/projects/{id}/service_accounts/{user_id}/personal_access_tokens/{token_id}/rotate");
    private static final JsonType<List<GitLabServiceAccount>> SERVICE_ACCOUNT_LIST_TYPE =
            JsonTypes.listOf(GitLabServiceAccount.class);
    private static final JsonType<List<GitLabPersonalAccessToken>> PERSONAL_ACCESS_TOKEN_LIST_TYPE =
            JsonTypes.listOf(GitLabPersonalAccessToken.class);
    private static final GitLabListSpec<GitLabServiceAccount> SERVICE_ACCOUNT_SPEC =
            GitLabListSpec.offset(SERVICE_ACCOUNT_LIST_TYPE);
    private static final GitLabListSpec<GitLabPersonalAccessToken> PERSONAL_ACCESS_TOKEN_SPEC =
            GitLabListSpec.offset(PERSONAL_ACCESS_TOKEN_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectServiceAccountsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/service_accounts}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list(final String id) throws IOException {
        return list(id, GitLabProjectServiceAccountsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/service_accounts}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectServiceAccountsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/service_accounts}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list(final String id, final GitLabProjectServiceAccountsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/service_accounts}).
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
    public GitLabPage<GitLabServiceAccount> list(
            final String id, final GitLabProjectServiceAccountsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, SERVICE_ACCOUNT_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/service_accounts}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabServiceAccount create(final String id, final GitLabProjectServiceAccountsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabServiceAccount.class);
    }

    /**
     * Get ({@code GET /projects/{id}/service_accounts/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabServiceAccount> get(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, userId), GitLabServiceAccount.class);
    }

    /**
     * Update ({@code PATCH /projects/{id}/service_accounts/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabServiceAccount update(
            final String id, final long userId, final GitLabProjectServiceAccountsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(patch(GET, id, userId), payload), GitLabServiceAccount.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/service_accounts/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long userId) throws IOException {
        delete(id, userId, GitLabProjectServiceAccountsDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /projects/{id}/service_accounts/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long userId, final GitLabProjectServiceAccountsDeleteFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(GET, id, userId).withQuery(queryParameters));
    }

    /**
     * List personal access tokens ({@code GET /projects/{id}/service_accounts/{user_id}/personal_access_tokens}).
     *
     * @param id the id
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listPersonalAccessTokens(final String id, final long userId)
            throws IOException {
        return listPersonalAccessTokens(
                id,
                userId,
                GitLabProjectServiceAccountsListPersonalAccessTokensFilter.empty(),
                GitLabPageRequest.byPage());
    }

    /**
     * List personal access tokens ({@code GET /projects/{id}/service_accounts/{user_id}/personal_access_tokens}).
     *
     * @param id the id
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listPersonalAccessTokens(
            final String id, final long userId, final GitLabPageRequest request) throws IOException {
        return listPersonalAccessTokens(
                id, userId, GitLabProjectServiceAccountsListPersonalAccessTokensFilter.empty(), request);
    }

    /**
     * List personal access tokens ({@code GET /projects/{id}/service_accounts/{user_id}/personal_access_tokens}).
     *
     * @param id the id
     * @param userId the user id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listPersonalAccessTokens(
            final String id, final long userId, final GitLabProjectServiceAccountsListPersonalAccessTokensFilter filter)
            throws IOException {
        return listPersonalAccessTokens(id, userId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List personal access tokens ({@code GET /projects/{id}/service_accounts/{user_id}/personal_access_tokens}).
     *
     * @param id the id
     * @param userId the user id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listPersonalAccessTokens(
            final String id,
            final long userId,
            final GitLabProjectServiceAccountsListPersonalAccessTokensFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PERSONAL_ACCESS_TOKENS, queryParameters, request, PERSONAL_ACCESS_TOKEN_SPEC, id, userId);
    }

    /**
     * Create personal access token ({@code POST /projects/{id}/service_accounts/{user_id}/personal_access_tokens}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessTokenWithToken createPersonalAccessToken(
            final String id,
            final long userId,
            final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_PERSONAL_ACCESS_TOKENS, id, userId), payload),
                GitLabPersonalAccessTokenWithToken.class);
    }

    /**
     * Delete personal access token ({@code DELETE
     * /projects/{id}/service_accounts/{user_id}/personal_access_tokens/{token_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param tokenId the token id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deletePersonalAccessToken(final String id, final long userId, final long tokenId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_PERSONAL_ACCESS_TOKEN, id, userId, tokenId));
    }

    /**
     * Rotate personal access token ({@code POST
     * /projects/{id}/service_accounts/{user_id}/personal_access_tokens/{token_id}/rotate}).
     *
     * @param id the id
     * @param userId the user id
     * @param tokenId the token id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessTokenWithToken rotatePersonalAccessToken(
            final String id,
            final long userId,
            final long tokenId,
            final GitLabProjectServiceAccountsRotatePersonalAccessTokenPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(ROTATE_PERSONAL_ACCESS_TOKEN, id, userId, tokenId), payload),
                GitLabPersonalAccessTokenWithToken.class);
    }
}
