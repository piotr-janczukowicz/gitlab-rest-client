package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

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

/** The GitLab operations of personal access tokens. */
public final class GitLabPersonalAccessTokensApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CREATE_USER_PERSONAL_ACCESS_TOKEN =
            PathTemplate.of("/user/personal_access_tokens");
    private static final PathTemplate ROTATE_SELF = PathTemplate.of("/personal_access_tokens/self/rotate");
    private static final PathTemplate GET_SELF = PathTemplate.of("/personal_access_tokens/self");
    private static final PathTemplate LIST_SELF_ASSOCIATIONS =
            PathTemplate.of("/personal_access_tokens/self/associations");
    private static final PathTemplate LIST = PathTemplate.of("/personal_access_tokens");
    private static final PathTemplate GET = PathTemplate.of("/personal_access_tokens/{id}");
    private static final PathTemplate ROTATE = PathTemplate.of("/personal_access_tokens/{id}/rotate");
    private static final JsonType<List<GitLabPersonalAccessToken>> PERSONAL_ACCESS_TOKEN_LIST_TYPE =
            JsonTypes.listOf(GitLabPersonalAccessToken.class);
    private static final GitLabListSpec<GitLabPersonalAccessToken> PERSONAL_ACCESS_TOKEN_SPEC =
            GitLabListSpec.offset(PERSONAL_ACCESS_TOKEN_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabPersonalAccessTokensApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create user personal access token ({@code POST /user/personal_access_tokens}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessTokenWithToken createUserPersonalAccessToken(
            final GitLabPersonalAccessTokenCreatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_USER_PERSONAL_ACCESS_TOKEN), payload),
                GitLabPersonalAccessTokenWithToken.class);
    }

    /**
     * Rotate self ({@code POST /personal_access_tokens/self/rotate}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessTokenWithToken rotateSelf(final GitLabPersonalAccessTokensRotateSelfPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(ROTATE_SELF), payload), GitLabPersonalAccessTokenWithToken.class);
    }

    /**
     * Get self ({@code GET /personal_access_tokens/self}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessToken getSelf() throws IOException {
        return caller.fetch(get(GET_SELF), GitLabPersonalAccessToken.class);
    }

    /**
     * Delete self ({@code DELETE /personal_access_tokens/self}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteSelf() throws IOException {
        caller.send(delete(GET_SELF));
    }

    /**
     * List self associations ({@code GET /personal_access_tokens/self/associations}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listSelfAssociations() throws IOException {
        return listSelfAssociations(
                GitLabPersonalAccessTokensListSelfAssociationsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List self associations ({@code GET /personal_access_tokens/self/associations}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listSelfAssociations(final GitLabPageRequest request)
            throws IOException {
        return listSelfAssociations(GitLabPersonalAccessTokensListSelfAssociationsFilter.empty(), request);
    }

    /**
     * List self associations ({@code GET /personal_access_tokens/self/associations}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listSelfAssociations(
            final GitLabPersonalAccessTokensListSelfAssociationsFilter filter) throws IOException {
        return listSelfAssociations(filter, GitLabPageRequest.byPage());
    }

    /**
     * List self associations ({@code GET /personal_access_tokens/self/associations}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> listSelfAssociations(
            final GitLabPersonalAccessTokensListSelfAssociationsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_SELF_ASSOCIATIONS, queryParameters, request, PERSONAL_ACCESS_TOKEN_SPEC);
    }

    /**
     * List ({@code GET /personal_access_tokens}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> list() throws IOException {
        return list(GitLabPersonalAccessTokensListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /personal_access_tokens}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabPersonalAccessTokensListFilter.empty(), request);
    }

    /**
     * List ({@code GET /personal_access_tokens}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> list(final GitLabPersonalAccessTokensListFilter filter)
            throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /personal_access_tokens}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPersonalAccessToken> list(
            final GitLabPersonalAccessTokensListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PERSONAL_ACCESS_TOKEN_SPEC);
    }

    /**
     * Get ({@code GET /personal_access_tokens/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPersonalAccessToken> get(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET, id), GitLabPersonalAccessToken.class);
    }

    /**
     * Delete ({@code DELETE /personal_access_tokens/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long id) throws IOException {
        caller.send(delete(GET, id));
    }

    /**
     * Rotate ({@code POST /personal_access_tokens/{id}/rotate}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessTokenWithToken rotate(
            final long id, final GitLabPersonalAccessTokensRotatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(ROTATE, id), payload), GitLabPersonalAccessTokenWithToken.class);
    }
}
