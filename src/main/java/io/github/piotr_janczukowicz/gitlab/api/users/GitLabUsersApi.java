package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerRegistrationDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployKey;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEmail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserWithAdmin;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of users. */
public final class GitLabUsersApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_USERID = "userId";
    private static final PathTemplate GET_USERS_SUPPORT_PIN = PathTemplate.of("/users/{id}/support_pin");
    private static final PathTemplate REVOKE_SUPPORT_PIN = PathTemplate.of("/users/{id}/support_pin/revoke");
    private static final PathTemplate LIST = PathTemplate.of("/users");
    private static final PathTemplate GET = PathTemplate.of("/users/{id}");
    private static final PathTemplate GET_USERS_STATUS = PathTemplate.of("/users/{user_id}/status");
    private static final PathTemplate LIST_FOLLOWING = PathTemplate.of("/users/{id}/following");
    private static final PathTemplate LIST_FOLLOWERS = PathTemplate.of("/users/{id}/followers");
    private static final PathTemplate DISABLE_TWO_FACTOR = PathTemplate.of("/users/{id}/disable_two_factor");
    private static final PathTemplate DELETE_IDENTITY = PathTemplate.of("/users/{id}/identities/{provider}");
    private static final PathTemplate LIST_PROJECT_DEPLOY_KEYS =
            PathTemplate.of("/users/{user_id}/project_deploy_keys");
    private static final PathTemplate LIST_EMAILS = PathTemplate.of("/users/{id}/emails");
    private static final PathTemplate DELETE_EMAIL = PathTemplate.of("/users/{id}/emails/{email_id}");
    private static final PathTemplate ACTIVATE = PathTemplate.of("/users/{id}/activate");
    private static final PathTemplate DEACTIVATE = PathTemplate.of("/users/{id}/deactivate");
    private static final PathTemplate BLOCK = PathTemplate.of("/users/{id}/block");
    private static final PathTemplate UNBLOCK = PathTemplate.of("/users/{id}/unblock");
    private static final PathTemplate BAN = PathTemplate.of("/users/{id}/ban");
    private static final PathTemplate UNBAN = PathTemplate.of("/users/{id}/unban");
    private static final PathTemplate LIST_MEMBERSHIPS = PathTemplate.of("/users/{user_id}/memberships");
    private static final PathTemplate GET_ASSOCIATIONS_COUNT = PathTemplate.of("/users/{id}/associations_count");
    private static final PathTemplate LIST_IMPERSONATION_TOKENS =
            PathTemplate.of("/users/{user_id}/impersonation_tokens");
    private static final PathTemplate GET_IMPERSONATION_TOKEN =
            PathTemplate.of("/users/{user_id}/impersonation_tokens/{impersonation_token_id}");
    private static final PathTemplate GET_USER = PathTemplate.of("/user");
    private static final PathTemplate CREDIT_CARD_VALIDATION =
            PathTemplate.of("/user/{user_id}/credit_card_validation");
    private static final PathTemplate GET_USER_SUPPORT_PIN = PathTemplate.of("/user/support_pin");
    private static final PathTemplate GET_PREFERENCES = PathTemplate.of("/user/preferences");
    private static final PathTemplate LIST_ACTIVITIES = PathTemplate.of("/user/activities");
    private static final PathTemplate GET_USER_STATUS = PathTemplate.of("/user/status");
    private static final PathTemplate CREATE_RUNNER = PathTemplate.of("/user/runners");
    private static final PathTemplate GET_USER_COUNTS = PathTemplate.of("/user_counts");
    private static final JsonType<List<GitLabUserBasic>> USER_BASIC_LIST_TYPE = JsonTypes.listOf(GitLabUserBasic.class);
    private static final JsonType<List<GitLabDeployKey>> DEPLOY_KEY_LIST_TYPE = JsonTypes.listOf(GitLabDeployKey.class);
    private static final JsonType<List<GitLabEmail>> EMAIL_LIST_TYPE = JsonTypes.listOf(GitLabEmail.class);
    private static final JsonType<List<GitLabMembership>> MEMBERSHIP_LIST_TYPE =
            JsonTypes.listOf(GitLabMembership.class);
    private static final JsonType<List<GitLabImpersonationToken>> IMPERSONATION_TOKEN_LIST_TYPE =
            JsonTypes.listOf(GitLabImpersonationToken.class);
    private static final JsonType<List<GitLabUserActivity>> USER_ACTIVITY_LIST_TYPE =
            JsonTypes.listOf(GitLabUserActivity.class);
    private static final GitLabListSpec<GitLabUserBasic> USER_BASIC_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(USER_BASIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabUserBasic> USER_BASIC_SPEC = GitLabListSpec.offset(USER_BASIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabDeployKey> DEPLOY_KEY_SPEC = GitLabListSpec.offset(DEPLOY_KEY_LIST_TYPE);
    private static final GitLabListSpec<GitLabEmail> EMAIL_SPEC = GitLabListSpec.offset(EMAIL_LIST_TYPE);
    private static final GitLabListSpec<GitLabMembership> MEMBERSHIP_SPEC = GitLabListSpec.offset(MEMBERSHIP_LIST_TYPE);
    private static final GitLabListSpec<GitLabImpersonationToken> IMPERSONATION_TOKEN_SPEC =
            GitLabListSpec.offset(IMPERSONATION_TOKEN_LIST_TYPE);
    private static final GitLabListSpec<GitLabUserActivity> USER_ACTIVITY_SPEC =
            GitLabListSpec.offset(USER_ACTIVITY_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUsersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get users support pin ({@code GET /users/{id}/support_pin}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserSupportPin> getUsersSupportPin(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET_USERS_SUPPORT_PIN, id), GitLabUserSupportPin.class);
    }

    /**
     * Revoke support pin ({@code POST /users/{id}/support_pin/revoke}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void revokeSupportPin(final long id) throws IOException {
        caller.send(post(REVOKE_SUPPORT_PIN, id));
    }

    /**
     * List ({@code GET /users}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list() throws IOException {
        return list(GitLabUsersListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /users}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabUsersListFilter.empty(), request);
    }

    /**
     * List ({@code GET /users}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list(final GitLabUsersListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /users}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> list(final GitLabUsersListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, USER_BASIC_KEYSET_SPEC);
    }

    /**
     * Create ({@code POST /users}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserWithAdmin create(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST), form), GitLabUserWithAdmin.class);
    }

    /**
     * Get ({@code GET /users/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserProfile> get(final long id) throws IOException {
        return get(id, GitLabUsersGetFilter.empty());
    }

    /**
     * Get ({@code GET /users/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserProfile> get(final long id, final GitLabUsersGetFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id).withQuery(queryParameters), GitLabUserProfile.class);
    }

    /**
     * Update ({@code PUT /users/{id}}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserWithAdmin update(final long id, final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(put(GET, id), form), GitLabUserWithAdmin.class);
    }

    /**
     * Delete ({@code DELETE /users/{id}}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEmail> delete(final long id) throws IOException {
        return delete(id, GitLabUsersDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /users/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEmail> delete(final long id, final GitLabUsersDeleteFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOptional(delete(GET, id).withQuery(queryParameters), GitLabEmail.class);
    }

    /**
     * Get users status ({@code GET /users/{user_id}/status}).
     *
     * @param userId the user id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserStatus> getUsersStatus(final String userId) throws IOException {
        requireNotBlank(userId, PARAM_USERID);
        return caller.fetchOrEmpty(get(GET_USERS_STATUS, userId), GitLabUserStatus.class);
    }

    /**
     * List following ({@code GET /users/{id}/following}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listFollowing(final long id) throws IOException {
        return listFollowing(id, GitLabPageRequest.byPage());
    }

    /**
     * List following ({@code GET /users/{id}/following}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listFollowing(final long id, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_FOLLOWING, Map.of(), request, USER_BASIC_SPEC, id);
    }

    /**
     * List followers ({@code GET /users/{id}/followers}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listFollowers(final long id) throws IOException {
        return listFollowers(id, GitLabPageRequest.byPage());
    }

    /**
     * List followers ({@code GET /users/{id}/followers}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserBasic> listFollowers(final long id, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_FOLLOWERS, Map.of(), request, USER_BASIC_SPEC, id);
    }

    /**
     * Disable two factor ({@code PATCH /users/{id}/disable_two_factor}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserWithAdmin disableTwoFactor(final long id) throws IOException {
        return caller.fetch(patch(DISABLE_TWO_FACTOR, id), GitLabUserWithAdmin.class);
    }

    /**
     * Delete identity ({@code DELETE /users/{id}/identities/{provider}}).
     *
     * @param id the id
     * @param provider the provider
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code provider} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserWithAdmin> deleteIdentity(final long id, final String provider) throws IOException {
        requireNotBlank(provider, "provider");
        return caller.fetchOptional(delete(DELETE_IDENTITY, id, provider), GitLabUserWithAdmin.class);
    }

    /**
     * List project deploy keys ({@code GET /users/{user_id}/project_deploy_keys}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKey> listProjectDeployKeys(final String userId) throws IOException {
        return listProjectDeployKeys(userId, GitLabPageRequest.byPage());
    }

    /**
     * List project deploy keys ({@code GET /users/{user_id}/project_deploy_keys}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKey> listProjectDeployKeys(final String userId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(userId, PARAM_USERID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_PROJECT_DEPLOY_KEYS, Map.of(), request, DEPLOY_KEY_SPEC, userId);
    }

    /**
     * List emails ({@code GET /users/{id}/emails}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEmail> listEmails(final long id) throws IOException {
        return listEmails(id, GitLabPageRequest.byPage());
    }

    /**
     * List emails ({@code GET /users/{id}/emails}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEmail> listEmails(final long id, final GitLabPageRequest request) throws IOException {
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_EMAILS, Map.of(), request, EMAIL_SPEC, id);
    }

    /**
     * Create email ({@code POST /users/{id}/emails}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabEmail createEmail(final long id, final GitLabUsersCreateEmailPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_EMAILS, id), payload), GitLabEmail.class);
    }

    /**
     * Delete email ({@code DELETE /users/{id}/emails/{email_id}}).
     *
     * @param id the id
     * @param emailId the email id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEmail> deleteEmail(final long id, final long emailId) throws IOException {
        return caller.fetchOptional(delete(DELETE_EMAIL, id, emailId), GitLabEmail.class);
    }

    /**
     * Activate ({@code POST /users/{id}/activate}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void activate(final long id) throws IOException {
        caller.send(post(ACTIVATE, id));
    }

    /**
     * Deactivate ({@code POST /users/{id}/deactivate}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deactivate(final long id) throws IOException {
        caller.send(post(DEACTIVATE, id));
    }

    /**
     * Block ({@code POST /users/{id}/block}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void block(final long id) throws IOException {
        caller.send(post(BLOCK, id));
    }

    /**
     * Unblock ({@code POST /users/{id}/unblock}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void unblock(final long id) throws IOException {
        caller.send(post(UNBLOCK, id));
    }

    /**
     * Ban ({@code POST /users/{id}/ban}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void ban(final long id) throws IOException {
        caller.send(post(BAN, id));
    }

    /**
     * Unban ({@code POST /users/{id}/unban}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void unban(final long id) throws IOException {
        caller.send(post(UNBAN, id));
    }

    /**
     * List memberships ({@code GET /users/{user_id}/memberships}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMembership> listMemberships(final long userId) throws IOException {
        return listMemberships(userId, GitLabUsersListMembershipsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List memberships ({@code GET /users/{user_id}/memberships}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMembership> listMemberships(final long userId, final GitLabPageRequest request)
            throws IOException {
        return listMemberships(userId, GitLabUsersListMembershipsFilter.empty(), request);
    }

    /**
     * List memberships ({@code GET /users/{user_id}/memberships}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMembership> listMemberships(
            final long userId, final GitLabUsersListMembershipsFilter filter) throws IOException {
        return listMemberships(userId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List memberships ({@code GET /users/{user_id}/memberships}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMembership> listMemberships(
            final long userId, final GitLabUsersListMembershipsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_MEMBERSHIPS, queryParameters, request, MEMBERSHIP_SPEC, userId);
    }

    /**
     * Get associations count ({@code GET /users/{id}/associations_count}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabUserAssociationsCount> getAssociationsCount(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET_ASSOCIATIONS_COUNT, id), GitLabUserAssociationsCount.class);
    }

    /**
     * List impersonation tokens ({@code GET /users/{user_id}/impersonation_tokens}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImpersonationToken> listImpersonationTokens(final long userId) throws IOException {
        return listImpersonationTokens(
                userId, GitLabUsersListImpersonationTokensFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List impersonation tokens ({@code GET /users/{user_id}/impersonation_tokens}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImpersonationToken> listImpersonationTokens(
            final long userId, final GitLabPageRequest request) throws IOException {
        return listImpersonationTokens(userId, GitLabUsersListImpersonationTokensFilter.empty(), request);
    }

    /**
     * List impersonation tokens ({@code GET /users/{user_id}/impersonation_tokens}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImpersonationToken> listImpersonationTokens(
            final long userId, final GitLabUsersListImpersonationTokensFilter filter) throws IOException {
        return listImpersonationTokens(userId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List impersonation tokens ({@code GET /users/{user_id}/impersonation_tokens}).
     *
     * @param userId the user id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImpersonationToken> listImpersonationTokens(
            final long userId, final GitLabUsersListImpersonationTokensFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_IMPERSONATION_TOKENS, queryParameters, request, IMPERSONATION_TOKEN_SPEC, userId);
    }

    /**
     * Create impersonation token ({@code POST /users/{user_id}/impersonation_tokens}).
     *
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabImpersonationTokenWithToken createImpersonationToken(
            final long userId, final GitLabUsersCreateImpersonationTokenPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_IMPERSONATION_TOKENS, userId), payload), GitLabImpersonationTokenWithToken.class);
    }

    /**
     * Get impersonation token ({@code GET /users/{user_id}/impersonation_tokens/{impersonation_token_id}}).
     *
     * @param userId the user id
     * @param impersonationTokenId the impersonation token id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabImpersonationToken> getImpersonationToken(final long userId, final long impersonationTokenId)
            throws IOException {
        return caller.fetchOrEmpty(
                get(GET_IMPERSONATION_TOKEN, userId, impersonationTokenId), GitLabImpersonationToken.class);
    }

    /**
     * Delete impersonation token ({@code DELETE /users/{user_id}/impersonation_tokens/{impersonation_token_id}}).
     *
     * @param userId the user id
     * @param impersonationTokenId the impersonation token id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteImpersonationToken(final long userId, final long impersonationTokenId) throws IOException {
        caller.send(delete(GET_IMPERSONATION_TOKEN, userId, impersonationTokenId));
    }

    /**
     * Get user ({@code GET /user}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserPublic getUser() throws IOException {
        return caller.fetch(get(GET_USER), GitLabUserPublic.class);
    }

    /**
     * Credit card validation ({@code PUT /user/{user_id}/credit_card_validation}).
     *
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public GitLabUserCreditCardValidations creditCardValidation(
            final String userId, final GitLabUsersCreditCardValidationPayload payload) throws IOException {
        requireNotBlank(userId, PARAM_USERID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(CREDIT_CARD_VALIDATION, userId), payload), GitLabUserCreditCardValidations.class);
    }

    /**
     * Get user support pin ({@code GET /user/support_pin}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserSupportPin getUserSupportPin() throws IOException {
        return caller.fetch(get(GET_USER_SUPPORT_PIN), GitLabUserSupportPin.class);
    }

    /**
     * Create support pin ({@code POST /user/support_pin}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserSupportPin createSupportPin() throws IOException {
        return caller.fetch(post(GET_USER_SUPPORT_PIN), GitLabUserSupportPin.class);
    }

    /**
     * Get preferences ({@code GET /user/preferences}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserPreferences getPreferences() throws IOException {
        return caller.fetch(get(GET_PREFERENCES), GitLabUserPreferences.class);
    }

    /**
     * Update preference ({@code PUT /user/preferences}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserPreferences updatePreference(final GitLabUsersUpdatePreferencePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_PREFERENCES), payload), GitLabUserPreferences.class);
    }

    /**
     * List activities ({@code GET /user/activities}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserActivity> listActivities() throws IOException {
        return listActivities(GitLabUsersListActivitiesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List activities ({@code GET /user/activities}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserActivity> listActivities(final GitLabPageRequest request) throws IOException {
        return listActivities(GitLabUsersListActivitiesFilter.empty(), request);
    }

    /**
     * List activities ({@code GET /user/activities}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserActivity> listActivities(final GitLabUsersListActivitiesFilter filter)
            throws IOException {
        return listActivities(filter, GitLabPageRequest.byPage());
    }

    /**
     * List activities ({@code GET /user/activities}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabUserActivity> listActivities(
            final GitLabUsersListActivitiesFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ACTIVITIES, queryParameters, request, USER_ACTIVITY_SPEC);
    }

    /**
     * Get user status ({@code GET /user/status}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserStatus getUserStatus() throws IOException {
        return caller.fetch(get(GET_USER_STATUS), GitLabUserStatus.class);
    }

    /**
     * Update status ({@code PUT /user/status}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserStatus updateStatus(final GitLabUsersUpdateStatusPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_USER_STATUS), payload), GitLabUserStatus.class);
    }

    /**
     * Patch status ({@code PATCH /user/status}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserStatus patchStatus(final GitLabUsersPatchStatusPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(patch(GET_USER_STATUS), payload), GitLabUserStatus.class);
    }

    /**
     * Create runner ({@code POST /user/runners}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiRunnerRegistrationDetails createRunner(final GitLabUsersCreateRunnerPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CREATE_RUNNER), payload), GitLabCiRunnerRegistrationDetails.class);
    }

    /**
     * Get user counts ({@code GET /user_counts}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserCounts getUserCounts() throws IOException {
        return caller.fetch(get(GET_USER_COUNTS), GitLabUserCounts.class);
    }
}
