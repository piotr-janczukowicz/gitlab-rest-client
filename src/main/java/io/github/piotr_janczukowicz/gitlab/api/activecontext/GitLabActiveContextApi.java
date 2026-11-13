package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of active context. */
public final class GitLabActiveContextApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate GET_CONNECTIONS = PathTemplate.of("/admin/active_context/connections");
    private static final PathTemplate ACTIVATE_CONNECTION =
            PathTemplate.of("/admin/active_context/connections/activate");
    private static final PathTemplate DEACTIVATE_CONNECTION =
            PathTemplate.of("/admin/active_context/connections/deactivate");
    private static final PathTemplate UPDATE_COLLECTION = PathTemplate.of("/admin/active_context/collections/{id}");
    private static final PathTemplate DELETE_DEAD_QUEUE = PathTemplate.of("/admin/active_context/dead_queue");
    private static final PathTemplate REPLAY_DEAD_QUEUE = PathTemplate.of("/admin/active_context/dead_queue/replay");
    private static final PathTemplate UPDATE_CODE_ENABLED_NAMESPACE =
            PathTemplate.of("/admin/active_context/code/enabled_namespaces");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabActiveContextApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get connections ({@code GET /admin/active_context/connections}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiActiveContextConnection getConnections() throws IOException {
        return caller.fetch(get(GET_CONNECTIONS), GitLabAiActiveContextConnection.class);
    }

    /**
     * Activate connection ({@code PUT /admin/active_context/connections/activate}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiActiveContextConnection activateConnection(
            final GitLabActiveContextActivateConnectionPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ACTIVATE_CONNECTION), payload), GitLabAiActiveContextConnection.class);
    }

    /**
     * Deactivate connection ({@code PUT /admin/active_context/connections/deactivate}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiActiveContextConnection deactivateConnection(
            final GitLabActiveContextDeactivateConnectionPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DEACTIVATE_CONNECTION), payload), GitLabAiActiveContextConnection.class);
    }

    /**
     * Update collection ({@code PUT /admin/active_context/collections/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiActiveContextCollection updateCollection(
            final String id, final GitLabActiveContextUpdateCollectionPayload payload) throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_COLLECTION, id), payload), GitLabAiActiveContextCollection.class);
    }

    /**
     * Delete dead queue ({@code DELETE /admin/active_context/dead_queue}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteDeadQueue() throws IOException {
        caller.send(delete(DELETE_DEAD_QUEUE));
    }

    /**
     * Replay dead queue ({@code POST /admin/active_context/dead_queue/replay}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void replayDeadQueue(final GitLabActiveContextReplayDeadQueuePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(REPLAY_DEAD_QUEUE), payload));
    }

    /**
     * Update code enabled namespace ({@code PUT /admin/active_context/code/enabled_namespaces}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAiActiveContextCodeEnabledNamespace updateCodeEnabledNamespace(
            final GitLabActiveContextUpdateCodeEnabledNamespacePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_CODE_ENABLED_NAMESPACE), payload),
                GitLabAiActiveContextCodeEnabledNamespace.class);
    }
}
