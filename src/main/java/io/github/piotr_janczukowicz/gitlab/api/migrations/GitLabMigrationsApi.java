package io.github.piotr_janczukowicz.gitlab.api.migrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of migrations. */
public final class GitLabMigrationsApi extends GitLabResourceApi {
    private static final PathTemplate CALL_PENDING = PathTemplate.of("/admin/migrations/pending");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabMigrationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call pending ({@code GET /admin/migrations/pending}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPending() throws IOException {
        callPending(GitLabMigrationsCallPendingFilter.empty());
    }

    /**
     * Call pending ({@code GET /admin/migrations/pending}).
     *
     * @param filter the optional query parameters
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPending(final GitLabMigrationsCallPendingFilter filter) throws IOException {
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_PENDING).withQuery(queryParameters));
    }
}
