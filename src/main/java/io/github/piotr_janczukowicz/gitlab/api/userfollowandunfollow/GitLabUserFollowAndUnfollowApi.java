package io.github.piotr_janczukowicz.gitlab.api.userfollowandunfollow;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUser;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of user follow and unfollow. */
public final class GitLabUserFollowAndUnfollowApi extends GitLabResourceApi {
    private static final PathTemplate CREATE_FOLLOW = PathTemplate.of("/users/{id}/follow");
    private static final PathTemplate CREATE_UNFOLLOW = PathTemplate.of("/users/{id}/unfollow");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUserFollowAndUnfollowApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create follow ({@code POST /users/{id}/follow}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUser createFollow(final long id) throws IOException {
        return caller.fetch(post(CREATE_FOLLOW, id), GitLabUser.class);
    }

    /**
     * Create unfollow ({@code POST /users/{id}/unfollow}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabUser createUnfollow(final long id) throws IOException {
        return caller.fetch(post(CREATE_UNFOLLOW, id), GitLabUser.class);
    }
}
