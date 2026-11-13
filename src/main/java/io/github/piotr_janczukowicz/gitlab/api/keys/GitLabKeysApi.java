package io.github.piotr_janczukowicz.gitlab.api.keys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSSHKey;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserWithAdmin;
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

/** The GitLab operations of keys. */
public final class GitLabKeysApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_USERS_KEYS = PathTemplate.of("/users/{user_id}/keys");
    private static final PathTemplate GET_USERS_KEY = PathTemplate.of("/users/{id}/keys/{key_id}");
    private static final PathTemplate LIST_USERS_GPG_KEYS = PathTemplate.of("/users/{id}/gpg_keys");
    private static final PathTemplate GET_USERS_GPG_KEY = PathTemplate.of("/users/{id}/gpg_keys/{key_id}");
    private static final PathTemplate REVOKE_USERS_GPG_KEY = PathTemplate.of("/users/{id}/gpg_keys/{key_id}/revoke");
    private static final PathTemplate LIST_USER_GPG_KEYS = PathTemplate.of("/user/gpg_keys");
    private static final PathTemplate GET_USER_GPG_KEY = PathTemplate.of("/user/gpg_keys/{key_id}");
    private static final PathTemplate REVOKE_USER_GPG_KEY = PathTemplate.of("/user/gpg_keys/{key_id}/revoke");
    private static final PathTemplate GET_BY_ID = PathTemplate.of("/keys/{id}");
    private static final PathTemplate GET = PathTemplate.of("/keys");
    private static final JsonType<List<GitLabSSHKey>> SSHKEY_LIST_TYPE = JsonTypes.listOf(GitLabSSHKey.class);
    private static final JsonType<List<GitLabGpgKey>> GPG_KEY_LIST_TYPE = JsonTypes.listOf(GitLabGpgKey.class);
    private static final GitLabListSpec<GitLabSSHKey> SSHKEY_SPEC = GitLabListSpec.offset(SSHKEY_LIST_TYPE);
    private static final GitLabListSpec<GitLabGpgKey> GPG_KEY_SPEC = GitLabListSpec.offset(GPG_KEY_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabKeysApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List users keys ({@code GET /users/{user_id}/keys}).
     *
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSSHKey> listUsersKeys(final String userId) throws IOException {
        return listUsersKeys(userId, GitLabPageRequest.byPage());
    }

    /**
     * List users keys ({@code GET /users/{user_id}/keys}).
     *
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code userId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSSHKey> listUsersKeys(final String userId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(userId, "userId");
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_USERS_KEYS, Map.of(), request, SSHKEY_SPEC, userId);
    }

    /**
     * Create users key ({@code POST /users/{user_id}/keys}).
     *
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSSHKey createUsersKey(final long userId, final GitLabKeysCreateUsersKeyPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_USERS_KEYS, userId), payload), GitLabSSHKey.class);
    }

    /**
     * Get users key ({@code GET /users/{id}/keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSSHKey> getUsersKey(final long id, final long keyId) throws IOException {
        return caller.fetchOrEmpty(get(GET_USERS_KEY, id, keyId), GitLabSSHKey.class);
    }

    /**
     * Delete users key ({@code DELETE /users/{id}/keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSSHKey> deleteUsersKey(final long id, final long keyId) throws IOException {
        return caller.fetchOptional(delete(GET_USERS_KEY, id, keyId), GitLabSSHKey.class);
    }

    /**
     * List users gpg keys ({@code GET /users/{id}/gpg_keys}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGpgKey> listUsersGpgKeys(final long id) throws IOException {
        return listUsersGpgKeys(id, GitLabPageRequest.byPage());
    }

    /**
     * List users gpg keys ({@code GET /users/{id}/gpg_keys}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGpgKey> listUsersGpgKeys(final long id, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_USERS_GPG_KEYS, Map.of(), request, GPG_KEY_SPEC, id);
    }

    /**
     * Create users gpg key ({@code POST /users/{id}/gpg_keys}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGpgKey createUsersGpgKey(final long id, final GitLabKeysCreateUsersGpgKeyPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_USERS_GPG_KEYS, id), payload), GitLabGpgKey.class);
    }

    /**
     * Get users gpg key ({@code GET /users/{id}/gpg_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGpgKey> getUsersGpgKey(final long id, final long keyId) throws IOException {
        return caller.fetchOrEmpty(get(GET_USERS_GPG_KEY, id, keyId), GitLabGpgKey.class);
    }

    /**
     * Delete users gpg key ({@code DELETE /users/{id}/gpg_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteUsersGpgKey(final long id, final long keyId) throws IOException {
        caller.send(delete(GET_USERS_GPG_KEY, id, keyId));
    }

    /**
     * Revoke users gpg key ({@code POST /users/{id}/gpg_keys/{key_id}/revoke}).
     *
     * @param id the id
     * @param keyId the key id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void revokeUsersGpgKey(final long id, final long keyId) throws IOException {
        caller.send(post(REVOKE_USERS_GPG_KEY, id, keyId));
    }

    /**
     * List user gpg keys ({@code GET /user/gpg_keys}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGpgKey> listUserGpgKeys() throws IOException {
        return listUserGpgKeys(GitLabPageRequest.byPage());
    }

    /**
     * List user gpg keys ({@code GET /user/gpg_keys}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGpgKey> listUserGpgKeys(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_USER_GPG_KEYS, Map.of(), request, GPG_KEY_SPEC);
    }

    /**
     * Create user gpg key ({@code POST /user/gpg_keys}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGpgKey createUserGpgKey(final GitLabKeysCreateUserGpgKeyPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_USER_GPG_KEYS), payload), GitLabGpgKey.class);
    }

    /**
     * Get user gpg key ({@code GET /user/gpg_keys/{key_id}}).
     *
     * @param keyId the key id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGpgKey> getUserGpgKey(final long keyId) throws IOException {
        return caller.fetchOrEmpty(get(GET_USER_GPG_KEY, keyId), GitLabGpgKey.class);
    }

    /**
     * Delete user gpg key ({@code DELETE /user/gpg_keys/{key_id}}).
     *
     * @param keyId the key id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteUserGpgKey(final long keyId) throws IOException {
        caller.send(delete(GET_USER_GPG_KEY, keyId));
    }

    /**
     * Revoke user gpg key ({@code POST /user/gpg_keys/{key_id}/revoke}).
     *
     * @param keyId the key id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void revokeUserGpgKey(final long keyId) throws IOException {
        caller.send(post(REVOKE_USER_GPG_KEY, keyId));
    }

    /**
     * Get by id ({@code GET /keys/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSSHKeyWithUser> getById(final String id) throws IOException {
        requireNotBlank(id, "id");
        return caller.fetchOrEmpty(get(GET_BY_ID, id), GitLabSSHKeyWithUser.class);
    }

    /**
     * Get ({@code GET /keys}).
     *
     * @param fingerprint the fingerprint
     * @return the resource
     * @throws IllegalArgumentException if {@code fingerprint} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUserWithAdmin get(final String fingerprint) throws IOException {
        requireNotBlank(fingerprint, "fingerprint");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text("fingerprint", fingerprint).build();
        return caller.fetch(get(GET).withQuery(queryParameters), GitLabUserWithAdmin.class);
    }
}
