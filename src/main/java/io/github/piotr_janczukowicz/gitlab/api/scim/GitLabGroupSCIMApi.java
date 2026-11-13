package io.github.piotr_janczukowicz.gitlab.api.scim;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of group scim. */
public final class GitLabGroupSCIMApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/scim/identities");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupSCIMApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /groups/{id}/scim/identities}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabIdentityDetail get(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdScimIdentities");
        requireNotBlank(id, "id");
        return caller.fetch(get(GET, id), GitLabIdentityDetail.class);
    }
}
