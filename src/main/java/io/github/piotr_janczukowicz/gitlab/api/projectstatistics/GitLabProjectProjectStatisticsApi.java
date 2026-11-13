package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project project statistics. */
public final class GitLabProjectProjectStatisticsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/statistics");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectStatisticsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/statistics}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectDailyStatistics get(final String id) throws IOException {
        requireNotBlank(id, "id");
        return caller.fetch(get(GET, id), GitLabProjectDailyStatistics.class);
    }
}
