package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of settings. */
public final class GitLabSettingsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/application/settings");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /application/settings}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplicationSetting get() throws IOException {
        return caller.fetch(get(GET), GitLabApplicationSetting.class);
    }

    /**
     * Update ({@code PUT /application/settings}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplicationSetting update(final GitLabSettingsUpdatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET), payload), GitLabApplicationSetting.class);
    }
}
