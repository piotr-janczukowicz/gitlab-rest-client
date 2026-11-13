package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerController;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of runner controllers. */
public final class GitLabRunnerControllersApi extends GitLabResourceApi {
    private static final PathTemplate CALL_SCOPES = PathTemplate.of("/runner_controllers/{id}/scopes");
    private static final PathTemplate CREATE_SCOPES_INSTANCE =
            PathTemplate.of("/runner_controllers/{id}/scopes/instance");
    private static final PathTemplate CREATE_SCOPES_RUNNER =
            PathTemplate.of("/runner_controllers/{id}/scopes/runners/{runner_id}");
    private static final PathTemplate CREATE = PathTemplate.of("/runner_controllers");
    private static final PathTemplate GET = PathTemplate.of("/runner_controllers/{id}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabRunnerControllersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call scopes ({@code GET /runner_controllers/{id}/scopes}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void callScopes(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4RunnerControllersIdScopes");
        caller.send(get(CALL_SCOPES, id));
    }

    /**
     * Create scopes instance ({@code POST /runner_controllers/{id}/scopes/instance}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabCiRunnerControllerInstanceLevelScoping createScopesInstance(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4RunnerControllersIdScopesInstance");
        return caller.fetch(post(CREATE_SCOPES_INSTANCE, id), GitLabCiRunnerControllerInstanceLevelScoping.class);
    }

    /**
     * Delete scopes instance ({@code DELETE /runner_controllers/{id}/scopes/instance}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteScopesInstance(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4RunnerControllersIdScopesInstance");
        caller.send(delete(CREATE_SCOPES_INSTANCE, id));
    }

    /**
     * Create scopes runner ({@code POST /runner_controllers/{id}/scopes/runners/{runner_id}}).
     *
     * @param id the id
     * @param runnerId the runner id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabCiRunnerControllerRunnerLevelScoping createScopesRunner(final long id, final long runnerId)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4RunnerControllersIdScopesRunnersRunnerId");
        return caller.fetch(post(CREATE_SCOPES_RUNNER, id, runnerId), GitLabCiRunnerControllerRunnerLevelScoping.class);
    }

    /**
     * Delete scopes runner ({@code DELETE /runner_controllers/{id}/scopes/runners/{runner_id}}).
     *
     * @param id the id
     * @param runnerId the runner id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteScopesRunner(final long id, final long runnerId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4RunnerControllersIdScopesRunnersRunnerId");
        caller.send(delete(CREATE_SCOPES_RUNNER, id, runnerId));
    }

    /**
     * Create ({@code POST /runner_controllers}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabCiRunnerController create(final GitLabRunnerControllersCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4RunnerControllers");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE), payload), GitLabCiRunnerController.class);
    }

    /**
     * Get ({@code GET /runner_controllers/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabCiRunnerControllerDetail> get(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4RunnerControllersId");
        return caller.fetchOrEmpty(get(GET, id), GitLabCiRunnerControllerDetail.class);
    }

    /**
     * Update ({@code PUT /runner_controllers/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabCiRunnerController update(final long id, final GitLabRunnerControllersUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4RunnerControllersId");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabCiRunnerController.class);
    }

    /**
     * Delete ({@code DELETE /runner_controllers/{id}}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabCiRunnerController> delete(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4RunnerControllersId");
        return caller.fetchOptional(delete(GET, id), GitLabCiRunnerController.class);
    }
}
