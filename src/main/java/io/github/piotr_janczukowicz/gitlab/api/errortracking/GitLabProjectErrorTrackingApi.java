package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of project error tracking. */
public final class GitLabProjectErrorTrackingApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/error_tracking/settings");
    private static final PathTemplate LIST_CLIENT_KEYS = PathTemplate.of("/projects/{id}/error_tracking/client_keys");
    private static final PathTemplate DELETE_CLIENT_KEY =
            PathTemplate.of("/projects/{id}/error_tracking/client_keys/{key_id}");
    private static final JsonType<List<GitLabErrorTrackingClientKey>> ERROR_TRACKING_CLIENT_KEY_LIST_TYPE =
            JsonTypes.listOf(GitLabErrorTrackingClientKey.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectErrorTrackingApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/error_tracking/settings}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabErrorTrackingProjectSetting get(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET, id), GitLabErrorTrackingProjectSetting.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/error_tracking/settings}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabErrorTrackingProjectSetting update(
            final String id, final GitLabProjectErrorTrackingUpdatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabErrorTrackingProjectSetting.class);
    }

    /**
     * Patch ({@code PATCH /projects/{id}/error_tracking/settings}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabErrorTrackingProjectSetting patch(
            final String id, final GitLabProjectErrorTrackingPatchPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(patch(GET, id), payload), GitLabErrorTrackingProjectSetting.class);
    }

    /**
     * List client keys ({@code GET /projects/{id}/error_tracking/client_keys}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabErrorTrackingClientKey> listClientKeys(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_CLIENT_KEYS, id), ERROR_TRACKING_CLIENT_KEY_LIST_TYPE);
    }

    /**
     * Create client key ({@code POST /projects/{id}/error_tracking/client_keys}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabErrorTrackingClientKey createClientKey(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(LIST_CLIENT_KEYS, id), GitLabErrorTrackingClientKey.class);
    }

    /**
     * Delete client key ({@code DELETE /projects/{id}/error_tracking/client_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabErrorTrackingClientKey> deleteClientKey(final String id, final long keyId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(DELETE_CLIENT_KEY, id, keyId), GitLabErrorTrackingClientKey.class);
    }
}
