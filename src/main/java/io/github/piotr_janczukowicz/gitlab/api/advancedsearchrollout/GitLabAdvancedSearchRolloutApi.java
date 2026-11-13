package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of advanced search rollout. */
public final class GitLabAdvancedSearchRolloutApi extends GitLabResourceApi {
    private static final PathTemplate UPDATE_ROLLOUT = PathTemplate.of("/elasticsearch_indexed_namespaces/rollout");
    private static final PathTemplate UPDATE_ROLLBACK = PathTemplate.of("/elasticsearch_indexed_namespaces/rollback");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAdvancedSearchRolloutApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Update rollout ({@code PUT /elasticsearch_indexed_namespaces/rollout}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateRollout(final GitLabAdvancedSearchRolloutUpdateRolloutPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(UPDATE_ROLLOUT), payload));
    }

    /**
     * Update rollback ({@code PUT /elasticsearch_indexed_namespaces/rollback}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateRollback(final GitLabAdvancedSearchRolloutUpdateRollbackPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(UPDATE_ROLLBACK), payload));
    }
}
