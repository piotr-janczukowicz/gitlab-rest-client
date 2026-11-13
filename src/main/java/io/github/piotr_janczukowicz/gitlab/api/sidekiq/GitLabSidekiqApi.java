package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of sidekiq. */
public final class GitLabSidekiqApi extends GitLabResourceApi {
    private static final String PARAM_WORKERCLASS = "workerClass";
    private static final PathTemplate GET_CONCURRENCY_LIMIT =
            PathTemplate.of("/admin/sidekiq/concurrency_limits/{worker_class}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSidekiqApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get concurrency limit ({@code GET /admin/sidekiq/concurrency_limits/{worker_class}}).
     *
     * @param workerClass the worker class
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code workerClass} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSidekiqConcurrencyLimit> getConcurrencyLimit(final String workerClass) throws IOException {
        requireNotBlank(workerClass, PARAM_WORKERCLASS);
        return caller.fetchOrEmpty(get(GET_CONCURRENCY_LIMIT, workerClass), GitLabSidekiqConcurrencyLimit.class);
    }

    /**
     * Update concurrency limit ({@code PUT /admin/sidekiq/concurrency_limits/{worker_class}}).
     *
     * @param workerClass the worker class
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code workerClass} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSidekiqConcurrencyLimit updateConcurrencyLimit(
            final String workerClass, final GitLabSidekiqUpdateConcurrencyLimitPayload payload) throws IOException {
        requireNotBlank(workerClass, PARAM_WORKERCLASS);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(put(GET_CONCURRENCY_LIMIT, workerClass), payload), GitLabSidekiqConcurrencyLimit.class);
    }

    /**
     * Delete concurrency limit ({@code DELETE /admin/sidekiq/concurrency_limits/{worker_class}}).
     *
     * @param workerClass the worker class
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code workerClass} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSidekiqConcurrencyLimit> deleteConcurrencyLimit(final String workerClass) throws IOException {
        requireNotBlank(workerClass, PARAM_WORKERCLASS);
        return caller.fetchOptional(delete(GET_CONCURRENCY_LIMIT, workerClass), GitLabSidekiqConcurrencyLimit.class);
    }
}
