package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of compliance and policy settings. */
public final class GitLabComplianceAndPolicySettingsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/admin/security/compliance_policy_settings");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabComplianceAndPolicySettingsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /admin/security/compliance_policy_settings}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabAdminSecurityPolicySetting get() throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4AdminSecurityCompliancePolicySettings");
        return caller.fetch(get(GET), GitLabAdminSecurityPolicySetting.class);
    }

    /**
     * Update ({@code PUT /admin/security/compliance_policy_settings}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabAdminSecurityPolicySetting update(final GitLabComplianceAndPolicySettingsUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4AdminSecurityCompliancePolicySettings");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET), payload), GitLabAdminSecurityPolicySetting.class);
    }
}
