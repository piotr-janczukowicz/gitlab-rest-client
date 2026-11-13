package io.github.piotr_janczukowicz.gitlab.api.databasemigrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of database migrations. */
public final class GitLabDatabaseMigrationsApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/admin/migrations/{timestamp}/mark");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDatabaseMigrationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /admin/migrations/{timestamp}/mark}).
     *
     * @param timestamp the timestamp
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final int timestamp, final GitLabDatabaseMigrationsCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE, timestamp), payload));
    }
}
