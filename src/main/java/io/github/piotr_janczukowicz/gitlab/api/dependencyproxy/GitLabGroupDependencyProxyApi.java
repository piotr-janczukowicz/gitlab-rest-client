package io.github.piotr_janczukowicz.gitlab.api.dependencyproxy;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of group dependency proxy. */
public final class GitLabGroupDependencyProxyApi extends GitLabResourceApi {
    private static final PathTemplate DELETE = PathTemplate.of("/groups/{id}/dependency_proxy/cache");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupDependencyProxyApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/dependency_proxy/cache}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id) throws IOException {
        requireNotBlank(id, "id");
        caller.send(delete(DELETE, id));
    }
}
