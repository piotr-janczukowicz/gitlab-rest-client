package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of project validate gitlab ci yml file. */
public final class GitLabProjectValidateGitlabCiYmlFileApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/ci/lint");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectValidateGitlabCiYmlFileApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/ci/lint}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiLintResult get(final String id) throws IOException {
        return get(id, GitLabProjectValidateGitlabCiYmlFileGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}/ci/lint}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiLintResult get(final String id, final GitLabProjectValidateGitlabCiYmlFileGetFilter filter)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(GET, id).withQuery(queryParameters), GitLabCiLintResult.class);
    }

    /**
     * Create ({@code POST /projects/{id}/ci/lint}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiLintResult create(final String id, final GitLabProjectValidateGitlabCiYmlFileCreatePayload payload)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(GET, id), payload), GitLabCiLintResult.class);
    }
}
