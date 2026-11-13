package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

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

/** The GitLab operations of project project push rules. */
public final class GitLabProjectProjectPushRulesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/push_rule");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectPushRulesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/push_rule}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectPushRule get(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdPushRule");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET, id), GitLabProjectPushRule.class);
    }

    /**
     * Create ({@code POST /projects/{id}/push_rule}).
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
    public GitLabProjectPushRule create(final String id, final GitLabProjectProjectPushRulesCreatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectsIdPushRule");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(GET, id), payload), GitLabProjectPushRule.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/push_rule}).
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
    public GitLabProjectPushRule update(final String id, final GitLabProjectProjectPushRulesUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4ProjectsIdPushRule");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabProjectPushRule.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/push_rule}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4ProjectsIdPushRule");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id));
    }
}
