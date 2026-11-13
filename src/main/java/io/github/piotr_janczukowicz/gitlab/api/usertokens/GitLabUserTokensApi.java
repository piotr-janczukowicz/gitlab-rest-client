package io.github.piotr_janczukowicz.gitlab.api.usertokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of user tokens. */
public final class GitLabUserTokensApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/users/{user_id}/personal_access_tokens");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUserTokensApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /users/{user_id}/personal_access_tokens}).
     *
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPersonalAccessTokenWithToken create(final long userId, final GitLabUserTokensCreatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE, userId), payload), GitLabPersonalAccessTokenWithToken.class);
    }
}
