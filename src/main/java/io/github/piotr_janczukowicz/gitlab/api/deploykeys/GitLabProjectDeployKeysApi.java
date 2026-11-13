package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployKey;
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

/** The GitLab operations of project deploy keys. */
public final class GitLabProjectDeployKeysApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/deploy_keys");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/deploy_keys/{key_id}");
    private static final PathTemplate ENABLE = PathTemplate.of("/projects/{id}/deploy_keys/{key_id}/enable");
    private static final JsonType<List<GitLabDeployKeysProject>> DEPLOY_KEYS_PROJECT_LIST_TYPE =
            JsonTypes.listOf(GitLabDeployKeysProject.class);
    private static final GitLabListSpec<GitLabDeployKeysProject> DEPLOY_KEYS_PROJECT_SPEC =
            GitLabListSpec.offset(DEPLOY_KEYS_PROJECT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDeployKeysApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/deploy_keys}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKeysProject> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/deploy_keys}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDeployKeysProject> list(final String id, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, DEPLOY_KEYS_PROJECT_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/deploy_keys}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDeployKeysProject create(final String id, final GitLabProjectDeployKeysCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabDeployKeysProject.class);
    }

    /**
     * Get ({@code GET /projects/{id}/deploy_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDeployKeysProject> get(final String id, final long keyId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, keyId), GitLabDeployKeysProject.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/deploy_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDeployKey update(final String id, final long keyId, final GitLabProjectDeployKeysUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, keyId), payload), GitLabDeployKey.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/deploy_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long keyId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, keyId));
    }

    /**
     * Enable ({@code POST /projects/{id}/deploy_keys/{key_id}/enable}).
     *
     * @param id the id
     * @param keyId the key id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDeployKey enable(final String id, final long keyId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(ENABLE, id, keyId), GitLabDeployKey.class);
    }
}
