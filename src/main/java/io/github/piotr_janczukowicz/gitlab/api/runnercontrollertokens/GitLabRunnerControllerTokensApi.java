package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of runner controller tokens. */
public final class GitLabRunnerControllerTokensApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/runner_controllers/{runner_controller_id}/tokens");
    private static final PathTemplate GET = PathTemplate.of("/runner_controllers/{runner_controller_id}/tokens/{id}");
    private static final PathTemplate ROTATE =
            PathTemplate.of("/runner_controllers/{runner_controller_id}/tokens/{id}/rotate");
    private static final JsonType<List<GitLabCiRunnerControllerToken>> CI_RUNNER_CONTROLLER_TOKEN_LIST_TYPE =
            JsonTypes.listOf(GitLabCiRunnerControllerToken.class);
    private static final GitLabListSpec<GitLabCiRunnerControllerToken> CI_RUNNER_CONTROLLER_TOKEN_SPEC =
            GitLabListSpec.offset(CI_RUNNER_CONTROLLER_TOKEN_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabRunnerControllerTokensApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /runner_controllers/{runner_controller_id}/tokens}).
     *
     * @param runnerControllerId the runner controller id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabCiRunnerControllerToken> list(final long runnerControllerId) throws IOException {
        return list(runnerControllerId, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /runner_controllers/{runner_controller_id}/tokens}).
     *
     * @param runnerControllerId the runner controller id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabCiRunnerControllerToken> list(
            final long runnerControllerId, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4RunnerControllersRunnerControllerIdTokens");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CI_RUNNER_CONTROLLER_TOKEN_SPEC, runnerControllerId);
    }

    /**
     * Create ({@code POST /runner_controllers/{runner_controller_id}/tokens}).
     *
     * @param runnerControllerId the runner controller id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabCiRunnerControllerToken create(
            final long runnerControllerId, final GitLabRunnerControllerTokensCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4RunnerControllersRunnerControllerIdTokens");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, runnerControllerId), payload), GitLabCiRunnerControllerToken.class);
    }

    /**
     * Get ({@code GET /runner_controllers/{runner_controller_id}/tokens/{id}}).
     *
     * @param runnerControllerId the runner controller id
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabCiRunnerControllerToken> get(final long runnerControllerId, final long id)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4RunnerControllersRunnerControllerIdTokensId");
        return caller.fetchOrEmpty(get(GET, runnerControllerId, id), GitLabCiRunnerControllerToken.class);
    }

    /**
     * Delete ({@code DELETE /runner_controllers/{runner_controller_id}/tokens/{id}}).
     *
     * @param runnerControllerId the runner controller id
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void delete(final long runnerControllerId, final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4RunnerControllersRunnerControllerIdTokensId");
        caller.send(delete(GET, runnerControllerId, id));
    }

    /**
     * Rotate ({@code POST /runner_controllers/{runner_controller_id}/tokens/{id}/rotate}).
     *
     * @param runnerControllerId the runner controller id
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabCiRunnerControllerTokenWithToken rotate(final long runnerControllerId, final long id)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4RunnerControllersRunnerControllerIdTokensIdRotate");
        return caller.fetch(post(ROTATE, runnerControllerId, id), GitLabCiRunnerControllerTokenWithToken.class);
    }
}
