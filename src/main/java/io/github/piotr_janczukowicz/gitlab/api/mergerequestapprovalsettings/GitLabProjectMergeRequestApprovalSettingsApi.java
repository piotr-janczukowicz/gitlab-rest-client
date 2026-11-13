package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

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

/** The GitLab operations of project merge request approval settings. */
public final class GitLabProjectMergeRequestApprovalSettingsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/merge_request_approval_setting");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMergeRequestApprovalSettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/merge_request_approval_setting}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabMergeRequestApprovalSetting get(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdMergeRequestApprovalSetting");
        requireNotBlank(id, "id");
        return caller.fetch(get(GET, id), GitLabMergeRequestApprovalSetting.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/merge_request_approval_setting}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabMergeRequestApprovalSetting update(
            final String id, final GitLabProjectMergeRequestApprovalSettingsUpdatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4ProjectsIdMergeRequestApprovalSetting");
        requireNotBlank(id, "id");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabMergeRequestApprovalSetting.class);
    }
}
