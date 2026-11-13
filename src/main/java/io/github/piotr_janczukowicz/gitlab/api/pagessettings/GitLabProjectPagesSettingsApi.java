package io.github.piotr_janczukowicz.gitlab.api.pagessettings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project pages settings. */
public final class GitLabProjectPagesSettingsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate CALL = PathTemplate.of("/projects/{id}/pages");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectPagesSettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /projects/{id}/pages}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL, id));
    }

    /**
     * Update ({@code PATCH /projects/{id}/pages}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final GitLabProjectPagesSettingsUpdatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(patch(CALL, id), payload));
    }

    /**
     * Delete ({@code DELETE /projects/{id}/pages}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(CALL, id));
    }
}
