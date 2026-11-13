package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of duo. */
public final class GitLabDuoApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/duo_code_review/evaluations");
    private static final PathTemplate DIRECT_ACCESS = PathTemplate.of("/ai/third_party_agents/direct_access");
    private static final PathTemplate GIT_COMMAND = PathTemplate.of("/ai/llm/git_command");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDuoApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /duo_code_review/evaluations}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final GitLabDuoCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE), payload));
    }

    /**
     * Direct access ({@code POST /ai/third_party_agents/direct_access}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void directAccess() throws IOException {
        caller.send(post(DIRECT_ACCESS));
    }

    /**
     * Git command ({@code POST /ai/llm/git_command}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void gitCommand(final GitLabDuoGitCommandPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(GIT_COMMAND), payload));
    }
}
