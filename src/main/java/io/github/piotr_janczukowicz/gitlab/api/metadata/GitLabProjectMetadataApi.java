package io.github.piotr_janczukowicz.gitlab.api.metadata;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project metadata. */
public final class GitLabProjectMetadataApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/metadata");
    private static final PathTemplate GET_VERSION = PathTemplate.of("/version");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMetadataApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /metadata}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMetadata get() throws IOException {
        return caller.fetch(get(GET), GitLabMetadata.class);
    }

    /**
     * Get version ({@code GET /version}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMetadata getVersion() throws IOException {
        return caller.fetch(get(GET_VERSION), GitLabMetadata.class);
    }
}
