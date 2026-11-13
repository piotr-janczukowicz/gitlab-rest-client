package io.github.piotr_janczukowicz.gitlab.api.sidekiqmetrics;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabSidekiqMetricsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callQueueMetrics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/queue_metrics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSidekiqMetricsApi(GitLabCaller.of(client)).callQueueMetrics();
        }

        HTTP.verifyRequested(GET, "/api/v4/sidekiq/queue_metrics");
    }

    @Test
    void callQueueMetrics_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/queue_metrics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqMetricsApi api = new GitLabSidekiqMetricsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callQueueMetrics());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/sidekiq/queue_metrics");
    }

    @Test
    void callProcessMetrics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/process_metrics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSidekiqMetricsApi(GitLabCaller.of(client)).callProcessMetrics();
        }

        HTTP.verifyRequested(GET, "/api/v4/sidekiq/process_metrics");
    }

    @Test
    void callProcessMetrics_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/process_metrics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqMetricsApi api = new GitLabSidekiqMetricsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProcessMetrics());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/sidekiq/process_metrics");
    }

    @Test
    void callJobStats_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/job_stats", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSidekiqMetricsApi(GitLabCaller.of(client)).callJobStats();
        }

        HTTP.verifyRequested(GET, "/api/v4/sidekiq/job_stats");
    }

    @Test
    void callJobStats_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/job_stats", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqMetricsApi api = new GitLabSidekiqMetricsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callJobStats());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/sidekiq/job_stats");
    }

    @Test
    void callCompoundMetrics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/compound_metrics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSidekiqMetricsApi(GitLabCaller.of(client)).callCompoundMetrics();
        }

        HTTP.verifyRequested(GET, "/api/v4/sidekiq/compound_metrics");
    }

    @Test
    void callCompoundMetrics_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/sidekiq/compound_metrics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqMetricsApi api = new GitLabSidekiqMetricsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callCompoundMetrics());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/sidekiq/compound_metrics");
    }
}
