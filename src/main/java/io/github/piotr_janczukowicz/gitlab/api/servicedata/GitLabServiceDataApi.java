package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of service data. */
public final class GitLabServiceDataApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CALL_QUERIES = PathTemplate.of("/usage_data/queries");
    private static final PathTemplate CALL_NON_SQL_METRICS = PathTemplate.of("/usage_data/non_sql_metrics");
    private static final PathTemplate INCREMENT_COUNTER = PathTemplate.of("/usage_data/increment_counter");
    private static final PathTemplate CREATE_INCREMENT_UNIQUE_USER =
            PathTemplate.of("/usage_data/increment_unique_users");
    private static final PathTemplate CREATE_TRACK_EVENT = PathTemplate.of("/usage_data/track_events");
    private static final PathTemplate GET_METRIC_DEFINITIONS = PathTemplate.of("/usage_data/metric_definitions");
    private static final PathTemplate TRACK_EVENT = PathTemplate.of("/usage_data/track_event");
    private static final PathTemplate CALL_SERVICE_PING = PathTemplate.of("/usage_data/service_ping");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabServiceDataApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call queries ({@code GET /usage_data/queries}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callQueries() throws IOException {
        caller.send(get(CALL_QUERIES));
    }

    /**
     * Call non sql metrics ({@code GET /usage_data/non_sql_metrics}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callNonSqlMetrics() throws IOException {
        caller.send(get(CALL_NON_SQL_METRICS));
    }

    /**
     * Increment counter ({@code POST /usage_data/increment_counter}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void incrementCounter(final GitLabServiceDataIncrementCounterPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(INCREMENT_COUNTER), payload));
    }

    /**
     * Create increment unique user ({@code POST /usage_data/increment_unique_users}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createIncrementUniqueUser(final GitLabServiceDataCreateIncrementUniqueUserPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_INCREMENT_UNIQUE_USER), payload));
    }

    /**
     * Create track event ({@code POST /usage_data/track_events}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createTrackEvent(final GitLabServiceDataCreateTrackEventPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_TRACK_EVENT), payload));
    }

    /**
     * Get metric definitions ({@code GET /usage_data/metric_definitions}).
     *
     * @return the text of the body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getMetricDefinitions() throws IOException {
        return getMetricDefinitions(GitLabServiceDataGetMetricDefinitionsFilter.empty());
    }

    /**
     * Get metric definitions ({@code GET /usage_data/metric_definitions}).
     *
     * @param filter the optional query parameters
     * @return the text of the body
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getMetricDefinitions(final GitLabServiceDataGetMetricDefinitionsFilter filter) throws IOException {
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return fetchText(get(GET_METRIC_DEFINITIONS).withQuery(queryParameters));
    }

    /**
     * Track event ({@code POST /usage_data/track_event}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void trackEvent(final GitLabServiceDataTrackEventPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(TRACK_EVENT), payload));
    }

    /**
     * Call service ping ({@code GET /usage_data/service_ping}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callServicePing() throws IOException {
        caller.send(get(CALL_SERVICE_PING));
    }
}
