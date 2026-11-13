package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of duo chat completions. */
public final class GitLabDuoChatCompletionsApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/chat/completions");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDuoChatCompletionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /chat/completions}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final GitLabDuoChatCompletionsCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE), payload));
    }
}
