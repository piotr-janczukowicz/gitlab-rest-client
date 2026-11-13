package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectEntity;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of import repository from bitbucket server. */
public final class GitLabImportRepositoryFromBitbucketServerApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/import/bitbucket_server");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabImportRepositoryFromBitbucketServerApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /import/bitbucket_server}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectEntity create(final GitLabImportRepositoryFromBitbucketServerCreatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE), payload), GitLabProjectEntity.class);
    }
}
