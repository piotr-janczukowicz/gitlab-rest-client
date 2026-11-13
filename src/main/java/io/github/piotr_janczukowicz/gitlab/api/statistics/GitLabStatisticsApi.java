package io.github.piotr_janczukowicz.gitlab.api.statistics;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of statistics. */
public final class GitLabStatisticsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/application/statistics");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabStatisticsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /application/statistics}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabApplicationStatistics get() throws IOException {
        return caller.fetch(get(GET), GitLabApplicationStatistics.class);
    }
}
