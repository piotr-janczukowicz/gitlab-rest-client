package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProtectedEnvironment;
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

/** The GitLab operations of group group level protected environments. */
public final class GitLabGroupGroupLevelProtectedEnvironmentsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_NAME = "name";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/protected_environments");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/protected_environments/{name}");
    private static final JsonType<List<GitLabProtectedEnvironment>> PROTECTED_ENVIRONMENT_LIST_TYPE =
            JsonTypes.listOf(GitLabProtectedEnvironment.class);
    private static final GitLabListSpec<GitLabProtectedEnvironment> PROTECTED_ENVIRONMENT_SPEC =
            GitLabListSpec.offset(PROTECTED_ENVIRONMENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupLevelProtectedEnvironmentsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/protected_environments}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabProtectedEnvironment> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/protected_environments}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabProtectedEnvironment> list(final String id, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdProtectedEnvironments");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, PROTECTED_ENVIRONMENT_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/protected_environments}).
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
    public GitLabProtectedEnvironment create(
            final String id, final GitLabGroupProtectedEnvironmentCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdProtectedEnvironments");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabProtectedEnvironment.class);
    }

    /**
     * Get ({@code GET /groups/{id}/protected_environments/{name}}).
     *
     * @param id the id
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code name} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabProtectedEnvironment> get(
            final String id, final GitLabGroupGroupLevelProtectedEnvironmentsGetName name) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdProtectedEnvironmentsName");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(name, PARAM_NAME);
        return caller.fetchOrEmpty(get(GET, id, name.wireValue()), GitLabProtectedEnvironment.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/protected_environments/{name}}).
     *
     * @param id the id
     * @param name the name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code name} or {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProtectedEnvironment update(
            final String id,
            final GitLabGroupProtectedEnvironmentUpdateName name,
            final GitLabGroupProtectedEnvironmentUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdProtectedEnvironmentsName");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(name, PARAM_NAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, name.wireValue()), payload), GitLabProtectedEnvironment.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/protected_environments/{name}}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final String name) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdProtectedEnvironmentsName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        caller.send(delete(GET, id, name));
    }
}
