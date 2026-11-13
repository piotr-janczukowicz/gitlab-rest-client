package io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings;

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

/** The GitLab operations of group group security settings. */
public final class GitLabGroupGroupSecuritySettingsApi extends GitLabResourceApi {
    private static final PathTemplate UPDATE = PathTemplate.of("/groups/{id}/security_settings");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupSecuritySettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Update ({@code PUT /groups/{id}/security_settings}).
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
    public void update(final String id, final GitLabGroupGroupSecuritySettingsUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4GroupsIdSecuritySettings");
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(UPDATE, id), payload));
    }
}
