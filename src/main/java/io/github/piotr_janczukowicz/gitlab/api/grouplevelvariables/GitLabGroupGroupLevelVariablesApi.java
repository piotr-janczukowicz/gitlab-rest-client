package io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables;

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

/** The GitLab operations of group group level variables. */
public final class GitLabGroupGroupLevelVariablesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_KEY = "key";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/variables");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/variables/{key}");
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
    public GitLabGroupGroupLevelVariablesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/variables}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiVariable> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/variables}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiVariable> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CI_VARIABLE_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/variables}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiVariable create(final String id, final GitLabGroupGroupLevelVariablesCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabCiVariable.class);
    }

    /**
     * Get ({@code GET /groups/{id}/variables/{key}}).
     *
     * @param id the id
     * @param key the key
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiVariable> get(final String id, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOrEmpty(get(GET, id, key), GitLabCiVariable.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/variables/{key}}).
     *
     * @param id the id
     * @param key the key
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiVariable update(
            final String id, final String key, final GitLabGroupGroupLevelVariablesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, key), payload), GitLabCiVariable.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/variables/{key}}).
     *
     * @param id the id
     * @param key the key
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiVariable> delete(final String id, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOptional(delete(GET, id, key), GitLabCiVariable.class);
    }
}
