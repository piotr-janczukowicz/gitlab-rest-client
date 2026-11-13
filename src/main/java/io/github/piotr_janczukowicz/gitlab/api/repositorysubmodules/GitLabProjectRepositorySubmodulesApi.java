package io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommitDetail;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project repository submodules. */
public final class GitLabProjectRepositorySubmodulesApi extends GitLabResourceApi {
    private static final PathTemplate UPDATE = PathTemplate.of("/projects/{id}/repository/submodules/{submodule}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectRepositorySubmodulesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Update ({@code PUT /projects/{id}/repository/submodules/{submodule}}).
     *
     * @param id the id
     * @param submodule the submodule
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code submodule} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommitDetail update(
            final String id, final String submodule, final GitLabProjectRepositorySubmodulesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(submodule, "submodule");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(UPDATE, id, submodule), payload), GitLabCommitDetail.class);
    }
}
