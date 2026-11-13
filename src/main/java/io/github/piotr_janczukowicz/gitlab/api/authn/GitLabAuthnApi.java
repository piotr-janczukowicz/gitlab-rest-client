package io.github.piotr_janczukowicz.gitlab.api.authn;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of authn. */
public final class GitLabAuthnApi extends GitLabResourceApi {
    private static final PathTemplate CALL = PathTemplate.of("/iam/userinfo");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAuthnApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /iam/userinfo}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call() throws IOException {
        caller.send(get(CALL));
    }
}
