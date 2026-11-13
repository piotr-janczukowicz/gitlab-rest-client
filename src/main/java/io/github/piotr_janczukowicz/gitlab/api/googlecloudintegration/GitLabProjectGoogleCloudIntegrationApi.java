package io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of project google cloud integration. */
public final class GitLabProjectGoogleCloudIntegrationApi extends GitLabResourceApi {
    private static final PathTemplate GET_INTEGRATIONS_SH =
            PathTemplate.of("/projects/{id}/google_cloud/setup/integrations.sh");
    private static final PathTemplate GET_RUNNER_DEPLOYMENT_PROJECT_SH =
            PathTemplate.of("/projects/{id}/google_cloud/setup/runner_deployment_project.sh");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectGoogleCloudIntegrationApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get integrations sh ({@code GET /projects/{id}/google_cloud/setup/integrations.sh}).
     *
     * @param id the id
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getIntegrationsSh(final String id) throws IOException {
        return getIntegrationsSh(id, GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter.empty());
    }

    /**
     * Get integrations sh ({@code GET /projects/{id}/google_cloud/setup/integrations.sh}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getIntegrationsSh(
            final String id, final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter filter)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return fetchText(get(GET_INTEGRATIONS_SH, id).withQuery(queryParameters));
    }

    /**
     * Get runner deployment project sh ({@code GET /projects/{id}/google_cloud/setup/runner_deployment_project.sh}).
     *
     * @param id the id
     * @param googleCloudProjectId the google cloud project id
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id} or {@code googleCloudProjectId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getRunnerDeploymentProjectSh(final String id, final String googleCloudProjectId) throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(googleCloudProjectId, "googleCloudProjectId");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text("google_cloud_project_id", googleCloudProjectId)
                .build();
        return fetchText(get(GET_RUNNER_DEPLOYMENT_PROJECT_SH, id).withQuery(queryParameters));
    }
}
