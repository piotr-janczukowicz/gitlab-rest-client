package io.github.piotr_janczukowicz.gitlab.api.applications;

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

/** The GitLab operations of applications. */
public final class GitLabApplicationsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/applications");
    private static final PathTemplate DELETE = PathTemplate.of("/applications/{id}");
    private static final PathTemplate RENEW_SECRET = PathTemplate.of("/applications/{id}/renew-secret");
    private static final JsonType<List<GitLabApplication>> APPLICATION_LIST_TYPE =
            JsonTypes.listOf(GitLabApplication.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabApplicationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /applications}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabApplication> list() throws IOException {
        return caller.fetch(get(LIST), APPLICATION_LIST_TYPE);
    }

    /**
     * Create ({@code POST /applications}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplicationWithSecret create(final GitLabApplicationsCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabApplicationWithSecret.class);
    }

    /**
     * Delete ({@code DELETE /applications/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long id) throws IOException {
        caller.send(delete(DELETE, id));
    }

    /**
     * Renew secret ({@code POST /applications/{id}/renew-secret}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplicationWithSecret renewSecret(final long id) throws IOException {
        return caller.fetch(post(RENEW_SECRET, id), GitLabApplicationWithSecret.class);
    }
}
