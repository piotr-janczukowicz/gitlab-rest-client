package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceDataApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabServiceDataApi api() {
        return new GitLabServiceDataApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabServiceDataApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callQueries_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callQueries();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/usage_data/queries");
    }

    @Test
    void callQueries_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callQueries());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callNonSqlMetrics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callNonSqlMetrics();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/usage_data/non_sql_metrics");
    }

    @Test
    void callNonSqlMetrics_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callNonSqlMetrics());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void incrementCounter_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().incrementCounter(ServicedataCatalogFixtures.serviceDataIncrementCounterPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/usage_data/increment_counter");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"event\":");
        });
    }

    @Test
    void incrementCounter_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().incrementCounter(ServicedataCatalogFixtures.serviceDataIncrementCounterPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createIncrementUniqueUser_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createIncrementUniqueUser(ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/usage_data/increment_unique_users");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"event\":");
        });
    }

    @Test
    void createIncrementUniqueUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIncrementUniqueUser(
                        ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createTrackEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createTrackEvent(ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/usage_data/track_events");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"events\":");
        });
    }

    @Test
    void createTrackEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().createTrackEvent(ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMetricDefinitions_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getMetricDefinitions();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/usage_data/metric_definitions");
        });
    }

    @Test
    void trackEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().trackEvent(ServicedataCatalogFixtures.serviceDataTrackEventPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/usage_data/track_event");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"event\":");
        });
    }

    @Test
    void trackEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().trackEvent(ServicedataCatalogFixtures.serviceDataTrackEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callServicePing_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callServicePing();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/usage_data/service_ping");
    }

    @Test
    void callServicePing_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callServicePing());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
