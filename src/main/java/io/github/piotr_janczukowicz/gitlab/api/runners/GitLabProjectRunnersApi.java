package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunner;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerWithUuid;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
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

/** The GitLab operations of project runners. */
public final class GitLabProjectRunnersApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/runners");
    private static final PathTemplate DELETE = PathTemplate.of("/projects/{id}/runners/{runner_id}");
    private static final PathTemplate RESET_REGISTRATION_TOKEN =
            PathTemplate.of("/projects/{id}/runners/reset_registration_token");
    private static final JsonType<List<GitLabCiRunnerWithUuid>> CI_RUNNER_WITH_UUID_LIST_TYPE =
            JsonTypes.listOf(GitLabCiRunnerWithUuid.class);
    private static final GitLabListSpec<GitLabCiRunnerWithUuid> CI_RUNNER_WITH_UUID_SPEC =
            GitLabListSpec.offset(CI_RUNNER_WITH_UUID_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectRunnersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/runners}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(final String id) throws IOException {
        return list(id, GitLabProjectRunnersListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/runners}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabProjectRunnersListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/runners}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(final String id, final GitLabProjectRunnersListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/runners}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> list(
            final String id, final GitLabProjectRunnersListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, CI_RUNNER_WITH_UUID_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/runners}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiRunnerWithUuid create(final String id, final GitLabProjectRunnersCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabCiRunnerWithUuid.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/runners/{runner_id}}).
     *
     * @param id the id
     * @param runnerId the runner id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiRunner> delete(final String id, final long runnerId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(DELETE, id, runnerId), GitLabCiRunner.class);
    }

    /**
     * Reset registration token ({@code POST /projects/{id}/runners/reset_registration_token}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiResetTokenResult resetRegistrationToken(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESET_REGISTRATION_TOKEN, id), GitLabCiResetTokenResult.class);
    }
}
