package io.github.piotr_janczukowicz.gitlab.api.userapplications;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabApplication;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabApplicationWithSecret;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of user applications. */
public final class GitLabUserApplicationsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/user/applications");
    private static final PathTemplate GET = PathTemplate.of("/user/applications/{id}");
    private static final JsonType<List<GitLabApplication>> APPLICATION_LIST_TYPE =
            JsonTypes.listOf(GitLabApplication.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUserApplicationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /user/applications}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabApplication> list() throws IOException {
        return caller.fetch(get(LIST), APPLICATION_LIST_TYPE);
    }

    /**
     * Create ({@code POST /user/applications}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplicationWithSecret create(final GitLabUserApplicationsCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabApplicationWithSecret.class);
    }

    /**
     * Get ({@code GET /user/applications/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabApplication> get(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET, id), GitLabApplication.class);
    }

    /**
     * Update ({@code PUT /user/applications/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplication update(final long id, final GitLabUserApplicationsUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabApplication.class);
    }

    /**
     * Delete ({@code DELETE /user/applications/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long id) throws IOException {
        caller.send(delete(GET, id));
    }
}
