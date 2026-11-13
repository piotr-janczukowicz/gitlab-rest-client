package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabServiceDataApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callQueries_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/queries", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client)).callQueries();
        }

        HTTP.verifyRequested(GET, "/api/v4/usage_data/queries");
    }

    @Test
    void callQueries_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/queries", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callQueries());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/usage_data/queries");
    }

    @Test
    void callNonSqlMetrics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/non_sql_metrics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client)).callNonSqlMetrics();
        }

        HTTP.verifyRequested(GET, "/api/v4/usage_data/non_sql_metrics");
    }

    @Test
    void callNonSqlMetrics_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/non_sql_metrics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callNonSqlMetrics());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/usage_data/non_sql_metrics");
    }

    @Test
    void incrementCounter_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/increment_counter", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client))
                    .incrementCounter(ServicedataCatalogFixtures.serviceDataIncrementCounterPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/usage_data/increment_counter");
    }

    @Test
    void incrementCounter_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/increment_counter", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.incrementCounter(ServicedataCatalogFixtures.serviceDataIncrementCounterPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/usage_data/increment_counter");
    }

    @Test
    void createIncrementUniqueUser_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/increment_unique_users", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client))
                    .createIncrementUniqueUser(
                            ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/usage_data/increment_unique_users");
    }

    @Test
    void createIncrementUniqueUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/increment_unique_users", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIncrementUniqueUser(
                    ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/usage_data/increment_unique_users");
    }

    @Test
    void createTrackEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/track_events", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client))
                    .createTrackEvent(ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/usage_data/track_events");
    }

    @Test
    void createTrackEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/track_events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.createTrackEvent(ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/usage_data/track_events");
    }

    @Test
    void getMetricDefinitions_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/metric_definitions", GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabServiceDataApi(GitLabCaller.of(client)).getMetricDefinitions();
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/usage_data/metric_definitions");
    }

    @Test
    void trackEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/track_event", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client))
                    .trackEvent(ServicedataCatalogFixtures.serviceDataTrackEventPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/usage_data/track_event");
    }

    @Test
    void trackEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/usage_data/track_event", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.trackEvent(ServicedataCatalogFixtures.serviceDataTrackEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/usage_data/track_event");
    }

    @Test
    void callServicePing_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/service_ping", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabServiceDataApi(GitLabCaller.of(client)).callServicePing();
        }

        HTTP.verifyRequested(GET, "/api/v4/usage_data/service_ping");
    }

    @Test
    void callServicePing_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/usage_data/service_ping", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabServiceDataApi api = new GitLabServiceDataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callServicePing());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/usage_data/service_ping");
    }
}
