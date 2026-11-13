package io.github.piotr_janczukowicz.gitlab.api.searchadmin;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of search admin. */
public final class GitLabSearchAdminApi extends GitLabResourceApi {
    private static final PathTemplate CALL = PathTemplate.of("/admin/search/migrations");
    private static final PathTemplate GET = PathTemplate.of("/admin/search/migrations/{migration_id}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSearchAdminApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /admin/search/migrations}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void call() throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AdminSearchMigrations");
        caller.send(get(CALL));
    }

    /**
     * Get ({@code GET /admin/search/migrations/{migration_id}}).
     *
     * @param migrationId the migration id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code migrationId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabSearchMigration> get(final String migrationId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AdminSearchMigrationsMigrationId");
        requireNotBlank(migrationId, "migrationId");
        return caller.fetchOrEmpty(get(GET, migrationId), GitLabSearchMigration.class);
    }
}
