package io.github.piotr_janczukowicz.gitlab.api.usermoderation;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of user moderation. */
public final class GitLabUserModerationApi extends GitLabResourceApi {
    private static final PathTemplate CREATE_APPROVE = PathTemplate.of("/users/{id}/approve");
    private static final PathTemplate CREATE_REJECT = PathTemplate.of("/users/{id}/reject");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUserModerationApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create approve ({@code POST /users/{id}/approve}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createApprove(final long id) throws IOException {
        caller.send(post(CREATE_APPROVE, id));
    }

    /**
     * Create reject ({@code POST /users/{id}/reject}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createReject(final long id) throws IOException {
        caller.send(post(CREATE_REJECT, id));
    }
}
