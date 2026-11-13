package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

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

/** The GitLab operations of instance service accounts. */
public final class GitLabInstanceServiceAccountsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/service_accounts");
    private static final PathTemplate UPDATE = PathTemplate.of("/service_accounts/{user_id}");
    private static final JsonType<List<GitLabServiceAccount>> SERVICE_ACCOUNT_LIST_TYPE =
            JsonTypes.listOf(GitLabServiceAccount.class);
    private static final GitLabListSpec<GitLabServiceAccount> SERVICE_ACCOUNT_SPEC =
            GitLabListSpec.offset(SERVICE_ACCOUNT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceServiceAccountsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /service_accounts}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list() throws IOException {
        return list(GitLabInstanceServiceAccountsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /service_accounts}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabInstanceServiceAccountsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /service_accounts}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list(final GitLabInstanceServiceAccountsListFilter filter)
            throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /service_accounts}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabServiceAccount> list(
            final GitLabInstanceServiceAccountsListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, SERVICE_ACCOUNT_SPEC);
    }

    /**
     * Create ({@code POST /service_accounts}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabServiceAccount create(final GitLabInstanceServiceAccountsCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabServiceAccount.class);
    }

    /**
     * Update ({@code PATCH /service_accounts/{user_id}}).
     *
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabServiceAccount update(final long userId, final GitLabInstanceServiceAccountsUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(patch(UPDATE, userId), payload), GitLabServiceAccount.class);
    }
}
