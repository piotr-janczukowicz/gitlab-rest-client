package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
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

/** The GitLab operations of group group enterprise users. */
public final class GitLabGroupGroupEnterpriseUsersApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/enterprise_users");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/enterprise_users/{user_id}");
    private static final PathTemplate DISABLE_TWO_FACTOR =
            PathTemplate.of("/groups/{id}/enterprise_users/{user_id}/disable_two_factor");
    private static final JsonType<List<GitLabUserPublic>> USER_PUBLIC_LIST_TYPE =
            JsonTypes.listOf(GitLabUserPublic.class);
    private static final GitLabListSpec<GitLabUserPublic> USER_PUBLIC_SPEC =
            GitLabListSpec.offset(USER_PUBLIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupEnterpriseUsersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/enterprise_users}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> list(final String id) throws IOException {
        return list(id, GitLabGroupGroupEnterpriseUsersListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/enterprise_users}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabGroupGroupEnterpriseUsersListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/enterprise_users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> list(final String id, final GitLabGroupGroupEnterpriseUsersListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/enterprise_users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> list(
            final String id, final GitLabGroupGroupEnterpriseUsersListFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEnterpriseUsers");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, USER_PUBLIC_SPEC, id);
    }

    /**
     * Get ({@code GET /groups/{id}/enterprise_users/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabUserPublic> get(final String id, final long userId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEnterpriseUsersUserId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, userId), GitLabUserPublic.class);
    }

    /**
     * Update ({@code PATCH /groups/{id}/enterprise_users/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabUserPublic update(
            final String id, final long userId, final GitLabGroupGroupEnterpriseUsersUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "patchApiV4GroupsIdEnterpriseUsersUserId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(patch(GET, id, userId), payload), GitLabUserPublic.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/enterprise_users/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final long userId) throws IOException {
        delete(id, userId, GitLabGroupGroupEnterpriseUsersDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /groups/{id}/enterprise_users/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final long userId, final GitLabGroupGroupEnterpriseUsersDeleteFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdEnterpriseUsersUserId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(GET, id, userId).withQuery(queryParameters));
    }

    /**
     * Disable two factor ({@code PATCH /groups/{id}/enterprise_users/{user_id}/disable_two_factor}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void disableTwoFactor(final String id, final long userId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "patchApiV4GroupsIdEnterpriseUsersUserIdDisableTwoFactor");
        requireNotBlank(id, PARAM_ID);
        caller.send(patch(DISABLE_TWO_FACTOR, id, userId));
    }
}
