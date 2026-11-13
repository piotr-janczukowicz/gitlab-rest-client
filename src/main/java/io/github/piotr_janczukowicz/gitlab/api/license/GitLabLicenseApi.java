package io.github.piotr_janczukowicz.gitlab.api.license;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of license. */
public final class GitLabLicenseApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/license");
    private static final PathTemplate CALL_USAGE_EXPORT = PathTemplate.of("/license/usage_export");
    private static final PathTemplate GET_BY_ID = PathTemplate.of("/license/{id}");
    private static final PathTemplate UPDATE_REFRESH_BILLABLE_USER =
            PathTemplate.of("/license/{id}/refresh_billable_users");
    private static final PathTemplate LIST_LICENSES = PathTemplate.of("/licenses");
    private static final JsonType<List<GitLabGitlabLicense>> GITLAB_LICENSE_LIST_TYPE =
            JsonTypes.listOf(GitLabGitlabLicense.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabLicenseApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /license}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGitlabLicenseWithActiveUsers get() throws IOException {
        return caller.fetch(get(GET), GitLabGitlabLicenseWithActiveUsers.class);
    }

    /**
     * Create ({@code POST /license}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGitlabLicenseWithActiveUsers create(final GitLabLicenseCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(GET), payload), GitLabGitlabLicenseWithActiveUsers.class);
    }

    /**
     * Call usage export ({@code GET /license/usage_export}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callUsageExport() throws IOException {
        caller.send(get(CALL_USAGE_EXPORT));
    }

    /**
     * Get by id ({@code GET /license/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGitlabLicenseWithActiveUsers> getById(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET_BY_ID, id), GitLabGitlabLicenseWithActiveUsers.class);
    }

    /**
     * Delete ({@code DELETE /license/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long id) throws IOException {
        caller.send(delete(GET_BY_ID, id));
    }

    /**
     * Update refresh billable user ({@code PUT /license/{id}/refresh_billable_users}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicSuccess updateRefreshBillableUser(final long id) throws IOException {
        return caller.fetch(put(UPDATE_REFRESH_BILLABLE_USER, id), GitLabBasicSuccess.class);
    }

    /**
     * List licenses ({@code GET /licenses}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabGitlabLicense> listLicenses() throws IOException {
        return caller.fetch(get(LIST_LICENSES), GITLAB_LICENSE_LIST_TYPE);
    }
}
