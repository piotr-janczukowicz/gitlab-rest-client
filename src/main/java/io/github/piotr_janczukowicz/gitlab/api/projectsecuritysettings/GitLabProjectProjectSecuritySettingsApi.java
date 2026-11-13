package io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project project security settings. */
public final class GitLabProjectProjectSecuritySettingsApi extends GitLabResourceApi {
    private static final PathTemplate CALL = PathTemplate.of("/projects/{id}/security_settings");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectSecuritySettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /projects/{id}/security_settings}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void call(final String id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdSecuritySettings");
        requireNotBlank(id, "id");
        caller.send(get(CALL, id));
    }

    /**
     * Update ({@code PUT /projects/{id}/security_settings}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void update(final String id, final GitLabProjectProjectSecuritySettingsUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4ProjectsIdSecuritySettings");
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(CALL, id), payload));
    }
}
