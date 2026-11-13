package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of instance notification settings. */
public final class GitLabInstanceNotificationSettingsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/notification_settings");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceNotificationSettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /notification_settings}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGlobalNotificationSetting get() throws IOException {
        return caller.fetch(get(GET), GitLabGlobalNotificationSetting.class);
    }

    /**
     * Update ({@code PUT /notification_settings}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGlobalNotificationSetting update(final GitLabInstanceNotificationSettingsUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET), payload), GitLabGlobalNotificationSetting.class);
    }
}
