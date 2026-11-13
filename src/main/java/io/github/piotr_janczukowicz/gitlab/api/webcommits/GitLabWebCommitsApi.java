package io.github.piotr_janczukowicz.gitlab.api.webcommits;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of web commits. */
public final class GitLabWebCommitsApi extends GitLabResourceApi {
    private static final PathTemplate CALL = PathTemplate.of("/web_commits/public_key");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabWebCommitsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /web_commits/public_key}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call() throws IOException {
        caller.send(get(CALL));
    }
}
