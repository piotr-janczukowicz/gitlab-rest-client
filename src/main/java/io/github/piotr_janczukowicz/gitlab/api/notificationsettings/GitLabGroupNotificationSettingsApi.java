package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of group notification settings. */
public final class GitLabGroupNotificationSettingsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/notification_settings");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupNotificationSettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /groups/{id}/notification_settings}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNotificationSetting get(final String id) throws IOException {
        requireNotBlank(id, "id");
        return caller.fetch(get(GET, id), GitLabNotificationSetting.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/notification_settings}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNotificationSetting update(final String id, final GitLabGroupNotificationSettingsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabNotificationSetting.class);
    }
}
