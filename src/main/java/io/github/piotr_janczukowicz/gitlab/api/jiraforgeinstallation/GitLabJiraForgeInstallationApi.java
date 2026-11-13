package io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of jira forge installation. */
public final class GitLabJiraForgeInstallationApi extends GitLabResourceApi {
    private static final PathTemplate UPDATE_INSTALLATION = PathTemplate.of("/integrations/jira_forge/installation");
    private static final PathTemplate FORGE_TOKEN_INSTALLATION =
            PathTemplate.of("/integrations/jira_forge/installation/forge_token");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabJiraForgeInstallationApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Update installation ({@code PUT /integrations/jira_forge/installation}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicSuccess updateInstallation(final GitLabJiraForgeInstallationUpdateInstallationPayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(UPDATE_INSTALLATION), payload), GitLabBasicSuccess.class);
    }

    /**
     * Delete installation ({@code DELETE /integrations/jira_forge/installation}).
     *
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBasicSuccess> deleteInstallation() throws IOException {
        return caller.fetchOptional(delete(UPDATE_INSTALLATION), GitLabBasicSuccess.class);
    }

    /**
     * Forge token installation ({@code POST /integrations/jira_forge/installation/forge_token}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicSuccess forgeTokenInstallation() throws IOException {
        return caller.fetch(post(FORGE_TOKEN_INSTALLATION), GitLabBasicSuccess.class);
    }
}
