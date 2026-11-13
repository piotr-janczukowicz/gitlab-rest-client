package io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiVariable;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
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

/** The GitLab operations of instance level cicdvariables. */
public final class GitLabInstanceLevelCICDVariablesApi extends GitLabResourceApi {
    private static final String PARAM_KEY = "key";
    private static final PathTemplate LIST = PathTemplate.of("/admin/ci/variables");
    private static final PathTemplate GET = PathTemplate.of("/admin/ci/variables/{key}");
    private static final JsonType<List<GitLabCiVariable>> CI_VARIABLE_LIST_TYPE =
            JsonTypes.listOf(GitLabCiVariable.class);
    private static final GitLabListSpec<GitLabCiVariable> CI_VARIABLE_SPEC =
            GitLabListSpec.offset(CI_VARIABLE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceLevelCICDVariablesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /admin/ci/variables}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiVariable> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /admin/ci/variables}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiVariable> list(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CI_VARIABLE_SPEC);
    }

    /**
     * Create ({@code POST /admin/ci/variables}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiVariable create(final GitLabInstanceLevelCICDVariablesCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabCiVariable.class);
    }

    /**
     * Get ({@code GET /admin/ci/variables/{key}}).
     *
     * @param key the key
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiVariable> get(final String key) throws IOException {
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOrEmpty(get(GET, key), GitLabCiVariable.class);
    }

    /**
     * Update ({@code PUT /admin/ci/variables/{key}}).
     *
     * @param key the key
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiVariable update(final String key, final GitLabInstanceLevelCICDVariablesUpdatePayload payload)
            throws IOException {
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, key), payload), GitLabCiVariable.class);
    }

    /**
     * Delete ({@code DELETE /admin/ci/variables/{key}}).
     *
     * @param key the key
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiVariable> delete(final String key) throws IOException {
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOptional(delete(GET, key), GitLabCiVariable.class);
    }
}
