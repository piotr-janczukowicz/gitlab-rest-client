package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectEntity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportEntity;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of import repository from git hub. */
public final class GitLabImportRepositoryFromGitHubApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CREATE = PathTemplate.of("/import/github");
    private static final PathTemplate CANCEL = PathTemplate.of("/import/github/cancel");
    private static final PathTemplate CREATE_GIST = PathTemplate.of("/import/github/gists");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabImportRepositoryFromGitHubApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /import/github}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectEntity create(final GitLabImportRepositoryFromGitHubCreatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CREATE), payload), GitLabProjectEntity.class);
    }

    /**
     * Cancel ({@code POST /import/github/cancel}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectImportEntity cancel(final GitLabImportRepositoryFromGitHubCancelPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CANCEL), payload), GitLabProjectImportEntity.class);
    }

    /**
     * Create gist ({@code POST /import/github/gists}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createGist(final GitLabImportRepositoryFromGitHubCreateGistPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_GIST), payload));
    }
}
