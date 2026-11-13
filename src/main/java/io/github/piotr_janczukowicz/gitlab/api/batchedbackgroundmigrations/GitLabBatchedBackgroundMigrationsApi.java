package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of batched background migrations. */
public final class GitLabBatchedBackgroundMigrationsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST_ADMIN_BATCHED_BACKGROUND_OPERATIONS =
            PathTemplate.of("/admin/batched_background_operations");
    private static final PathTemplate GET_ADMIN_BATCHED_BACKGROUND_OPERATION =
            PathTemplate.of("/admin/batched_background_operations/{id}");
    private static final PathTemplate STOP_ADMIN_BATCHED_BACKGROUND_OPERATION =
            PathTemplate.of("/admin/batched_background_operations/{id}/stop");
    private static final PathTemplate RESTART_ADMIN_BATCHED_BACKGROUND_OPERATI =
            PathTemplate.of("/admin/batched_background_operations/{id}/restart");
    private static final PathTemplate GET = PathTemplate.of("/admin/batched_background_migrations/{id}");
    private static final PathTemplate LIST = PathTemplate.of("/admin/batched_background_migrations");
    private static final PathTemplate RESUME = PathTemplate.of("/admin/batched_background_migrations/{id}/resume");
    private static final PathTemplate PAUSE = PathTemplate.of("/admin/batched_background_migrations/{id}/pause");
    private static final JsonType<List<GitLabBatchedBackgroundOperation>> BATCHED_BACKGROUND_OPERATION_LIST_TYPE =
            JsonTypes.listOf(GitLabBatchedBackgroundOperation.class);
    private static final JsonType<List<GitLabBatchedBackgroundMigration>> BATCHED_BACKGROUND_MIGRATION_LIST_TYPE =
            JsonTypes.listOf(GitLabBatchedBackgroundMigration.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabBatchedBackgroundMigrationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List admin batched background operations ({@code GET /admin/batched_background_operations}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBatchedBackgroundOperation> listAdminBatchedBackgroundOperations() throws IOException {
        return listAdminBatchedBackgroundOperations(GitLabBatchedMigrationListFilter.empty());
    }

    /**
     * List admin batched background operations ({@code GET /admin/batched_background_operations}).
     *
     * @param filter the optional query parameters
     * @return the items
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBatchedBackgroundOperation> listAdminBatchedBackgroundOperations(
            final GitLabBatchedMigrationListFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(LIST_ADMIN_BATCHED_BACKGROUND_OPERATIONS).withQuery(queryParameters),
                BATCHED_BACKGROUND_OPERATION_LIST_TYPE);
    }

    /**
     * Get admin batched background operation ({@code GET /admin/batched_background_operations/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBatchedBackgroundOperation> getAdminBatchedBackgroundOperation(final long id)
            throws IOException {
        return getAdminBatchedBackgroundOperation(id, GitLabBatchedMigrationGetFilter.empty());
    }

    /**
     * Get admin batched background operation ({@code GET /admin/batched_background_operations/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBatchedBackgroundOperation> getAdminBatchedBackgroundOperation(
            final long id, final GitLabBatchedMigrationGetFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET_ADMIN_BATCHED_BACKGROUND_OPERATION, id).withQuery(queryParameters),
                GitLabBatchedBackgroundOperation.class);
    }

    /**
     * Stop admin batched background operation ({@code PUT /admin/batched_background_operations/{id}/stop}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBatchedBackgroundOperation stopAdminBatchedBackgroundOperation(
            final long id, final GitLabBatchedMigrationStopPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(STOP_ADMIN_BATCHED_BACKGROUND_OPERATION, id), payload),
                GitLabBatchedBackgroundOperation.class);
    }

    /**
     * Restart admin batched background operation ({@code PUT /admin/batched_background_operations/{id}/restart}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBatchedBackgroundOperation restartAdminBatchedBackgroundOperation(
            final long id, final GitLabBatchedMigrationRestartPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(RESTART_ADMIN_BATCHED_BACKGROUND_OPERATI, id), payload),
                GitLabBatchedBackgroundOperation.class);
    }

    /**
     * Get ({@code GET /admin/batched_background_migrations/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBatchedBackgroundMigration> get(final long id) throws IOException {
        return get(id, GitLabBatchedBackgroundMigrationsGetFilter.empty());
    }

    /**
     * Get ({@code GET /admin/batched_background_migrations/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBatchedBackgroundMigration> get(
            final long id, final GitLabBatchedBackgroundMigrationsGetFilter filter) throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id).withQuery(queryParameters), GitLabBatchedBackgroundMigration.class);
    }

    /**
     * List ({@code GET /admin/batched_background_migrations}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBatchedBackgroundMigration> list() throws IOException {
        return list(GitLabBatchedBackgroundMigrationsListFilter.empty());
    }

    /**
     * List ({@code GET /admin/batched_background_migrations}).
     *
     * @param filter the optional query parameters
     * @return the items
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBatchedBackgroundMigration> list(final GitLabBatchedBackgroundMigrationsListFilter filter)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST).withQuery(queryParameters), BATCHED_BACKGROUND_MIGRATION_LIST_TYPE);
    }

    /**
     * Resume ({@code PUT /admin/batched_background_migrations/{id}/resume}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBatchedBackgroundMigration resume(
            final long id, final GitLabBatchedBackgroundMigrationsResumePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(RESUME, id), payload), GitLabBatchedBackgroundMigration.class);
    }

    /**
     * Pause ({@code PUT /admin/batched_background_migrations/{id}/pause}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBatchedBackgroundMigration pause(
            final long id, final GitLabBatchedBackgroundMigrationsPausePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PAUSE, id), payload), GitLabBatchedBackgroundMigration.class);
    }
}
