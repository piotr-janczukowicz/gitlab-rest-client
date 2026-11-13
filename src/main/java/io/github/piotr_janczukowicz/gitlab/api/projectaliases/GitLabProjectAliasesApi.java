package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of project aliases. */
public final class GitLabProjectAliasesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/project_aliases");
    private static final PathTemplate GET = PathTemplate.of("/project_aliases/{name}");
    private static final JsonType<List<GitLabProjectAlias>> PROJECT_ALIAS_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectAlias.class);
    private static final GitLabListSpec<GitLabProjectAlias> PROJECT_ALIAS_SPEC =
            GitLabListSpec.offset(PROJECT_ALIAS_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectAliasesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /project_aliases}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabProjectAlias> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /project_aliases}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabProjectAlias> list(final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectAliases");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, PROJECT_ALIAS_SPEC);
    }

    /**
     * Create ({@code POST /project_aliases}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabProjectAlias create(final GitLabProjectAliasesCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4ProjectAliases");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabProjectAlias.class);
    }

    /**
     * Get ({@code GET /project_aliases/{name}}).
     *
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabProjectAlias> get(final String name) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectAliasesName");
        requireNotBlank(name, "name");
        return caller.fetchOrEmpty(get(GET, name), GitLabProjectAlias.class);
    }

    /**
     * Delete ({@code DELETE /project_aliases/{name}}).
     *
     * @param name the name
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String name) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4ProjectAliasesName");
        requireNotBlank(name, "name");
        caller.send(delete(GET, name));
    }
}
