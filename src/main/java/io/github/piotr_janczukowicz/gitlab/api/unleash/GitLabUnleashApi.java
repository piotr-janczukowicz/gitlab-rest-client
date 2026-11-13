package io.github.piotr_janczukowicz.gitlab.api.unleash;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of unleash. */
public final class GitLabUnleashApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_PROJECTID = "projectId";
    private static final PathTemplate CALL = PathTemplate.of("/feature_flags/unleash/{project_id}");
    private static final PathTemplate CALL_FEATURES = PathTemplate.of("/feature_flags/unleash/{project_id}/features");
    private static final PathTemplate CALL_CLIENT_FEATURES =
            PathTemplate.of("/feature_flags/unleash/{project_id}/client/features");
    private static final PathTemplate REGISTER_CLIENT =
            PathTemplate.of("/feature_flags/unleash/{project_id}/client/register");
    private static final PathTemplate CREATE_CLIENT_METRIC =
            PathTemplate.of("/feature_flags/unleash/{project_id}/client/metrics");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUnleashApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /feature_flags/unleash/{project_id}}).
     *
     * @param projectId the project id
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String projectId) throws IOException {
        call(projectId, GitLabUnleashCallFilter.empty());
    }

    /**
     * Call ({@code GET /feature_flags/unleash/{project_id}}).
     *
     * @param projectId the project id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String projectId, final GitLabUnleashCallFilter filter) throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL, projectId).withQuery(queryParameters));
    }

    /**
     * Call features ({@code GET /feature_flags/unleash/{project_id}/features}).
     *
     * @param projectId the project id
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public void callFeatures(final String projectId) throws IOException {
        callFeatures(projectId, GitLabUnleashCallFeaturesFilter.empty());
    }

    /**
     * Call features ({@code GET /feature_flags/unleash/{project_id}/features}).
     *
     * @param projectId the project id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @deprecated GitLab marks this operation as deprecated
     */
    @Deprecated
    public void callFeatures(final String projectId, final GitLabUnleashCallFeaturesFilter filter) throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_FEATURES, projectId).withQuery(queryParameters));
    }

    /**
     * Call client features ({@code GET /feature_flags/unleash/{project_id}/client/features}).
     *
     * @param projectId the project id
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callClientFeatures(final String projectId) throws IOException {
        callClientFeatures(projectId, GitLabUnleashCallClientFeaturesFilter.empty());
    }

    /**
     * Call client features ({@code GET /feature_flags/unleash/{project_id}/client/features}).
     *
     * @param projectId the project id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callClientFeatures(final String projectId, final GitLabUnleashCallClientFeaturesFilter filter)
            throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_CLIENT_FEATURES, projectId).withQuery(queryParameters));
    }

    /**
     * Register client ({@code POST /feature_flags/unleash/{project_id}/client/register}).
     *
     * @param projectId the project id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void registerClient(final String projectId, final GitLabUnleashRegisterClientPayload payload)
            throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(REGISTER_CLIENT, projectId), payload));
    }

    /**
     * Create client metric ({@code POST /feature_flags/unleash/{project_id}/client/metrics}).
     *
     * @param projectId the project id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code projectId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createClientMetric(final String projectId, final GitLabUnleashCreateClientMetricPayload payload)
            throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE_CLIENT_METRIC, projectId), payload));
    }
}
