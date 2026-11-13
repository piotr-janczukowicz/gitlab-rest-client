package io.github.piotr_janczukowicz.gitlab.api.dependencymanagement;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Map;

/** The GitLab operations of dependency management. */
public final class GitLabDependencyManagementApi extends GitLabResourceApi {
    private static final String PARAM_EXPORTID = "exportId";
    private static final PathTemplate CALL = PathTemplate.of("/dependency_list_exports/{export_id}");
    private static final PathTemplate GET = PathTemplate.of("/dependency_list_exports/{export_id}/download");
    private static final PathTemplate CALL_VULNERABILITIES = PathTemplate.of("/occurrences/vulnerabilities");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDependencyManagementApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /dependency_list_exports/{export_id}}).
     *
     * @param exportId the export id
     * @throws IllegalArgumentException if {@code exportId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void call(final String exportId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4DependencyListExportsExportId");
        requireNotBlank(exportId, PARAM_EXPORTID);
        caller.send(get(CALL, exportId));
    }

    /**
     * Get ({@code GET /dependency_list_exports/{export_id}/download}).
     *
     * @param exportId the export id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code exportId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public long get(final String exportId, final OutputStream out) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4DependencyListExportsExportIdDownload");
        requireNotBlank(exportId, PARAM_EXPORTID);
        requireNonNull(out, "out");
        return caller.download(get(GET, exportId), out);
    }

    /**
     * Get ({@code GET /dependency_list_exports/{export_id}/download}).
     *
     * @param exportId the export id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code exportId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Path get(final String exportId, final Path target) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4DependencyListExportsExportIdDownload");
        requireNotBlank(exportId, PARAM_EXPORTID);
        requireNonNull(target, "target");
        return caller.download(get(GET, exportId), target);
    }

    /**
     * Call vulnerabilities ({@code GET /occurrences/vulnerabilities}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void callVulnerabilities(final String id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4OccurrencesVulnerabilities");
        requireNotBlank(id, "id");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text("id", id).build();
        caller.send(get(CALL_VULNERABILITIES).withQuery(queryParameters));
    }
}
