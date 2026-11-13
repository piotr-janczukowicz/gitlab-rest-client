package io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSSHKey;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
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

/** The GitLab operations of user sshand gpgkeys. */
public final class GitLabUserSSHAndGPGKeysApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/user/keys");
    private static final PathTemplate GET = PathTemplate.of("/user/keys/{key_id}");
    private static final JsonType<List<GitLabSSHKey>> SSHKEY_LIST_TYPE = JsonTypes.listOf(GitLabSSHKey.class);
    private static final GitLabListSpec<GitLabSSHKey> SSHKEY_SPEC = GitLabListSpec.offset(SSHKEY_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUserSSHAndGPGKeysApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /user/keys}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSSHKey> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /user/keys}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSSHKey> list(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, SSHKEY_SPEC);
    }

    /**
     * Create ({@code POST /user/keys}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSSHKey create(final GitLabUserSSHAndGPGKeysCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabSSHKey.class);
    }

    /**
     * Get ({@code GET /user/keys/{key_id}}).
     *
     * @param keyId the key id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSSHKey> get(final long keyId) throws IOException {
        return caller.fetchOrEmpty(get(GET, keyId), GitLabSSHKey.class);
    }

    /**
     * Delete ({@code DELETE /user/keys/{key_id}}).
     *
     * @param keyId the key id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSSHKey> delete(final long keyId) throws IOException {
        return caller.fetchOptional(delete(GET, keyId), GitLabSSHKey.class);
    }
}
