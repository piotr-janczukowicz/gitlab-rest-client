package io.github.piotr_janczukowicz.gitlab.api.sidekiqmetrics;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of sidekiq metrics. */
public final class GitLabSidekiqMetricsApi extends GitLabResourceApi {
    private static final PathTemplate CALL_QUEUE_METRICS = PathTemplate.of("/sidekiq/queue_metrics");
    private static final PathTemplate CALL_PROCESS_METRICS = PathTemplate.of("/sidekiq/process_metrics");
    private static final PathTemplate CALL_JOB_STATS = PathTemplate.of("/sidekiq/job_stats");
    private static final PathTemplate CALL_COMPOUND_METRICS = PathTemplate.of("/sidekiq/compound_metrics");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSidekiqMetricsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call queue metrics ({@code GET /sidekiq/queue_metrics}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callQueueMetrics() throws IOException {
        caller.send(get(CALL_QUEUE_METRICS));
    }

    /**
     * Call process metrics ({@code GET /sidekiq/process_metrics}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProcessMetrics() throws IOException {
        caller.send(get(CALL_PROCESS_METRICS));
    }

    /**
     * Call job stats ({@code GET /sidekiq/job_stats}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callJobStats() throws IOException {
        caller.send(get(CALL_JOB_STATS));
    }

    /**
     * Call compound metrics ({@code GET /sidekiq/compound_metrics}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callCompoundMetrics() throws IOException {
        caller.send(get(CALL_COMPOUND_METRICS));
    }
}
