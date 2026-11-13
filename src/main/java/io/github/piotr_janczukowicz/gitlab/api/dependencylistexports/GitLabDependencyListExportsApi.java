package io.github.piotr_janczukowicz.gitlab.api.dependencylistexports;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of dependency list exports. */
public final class GitLabDependencyListExportsApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/pipelines/{id}/dependency_list_exports");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDependencyListExportsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /pipelines/{id}/dependency_list_exports}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void create(final String id, final GitLabDependencyListExportsCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4PipelinesIdDependencyListExports");
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE, id), payload));
    }
}
