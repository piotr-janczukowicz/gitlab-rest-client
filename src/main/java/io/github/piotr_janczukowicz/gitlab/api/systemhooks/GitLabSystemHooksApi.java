package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of system hooks. */
public final class GitLabSystemHooksApi extends GitLabResourceApi {
    private static final String PARAM_KEY = "key";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate UPDATE_URL_VARIABLE = PathTemplate.of("/hooks/{hook_id}/url_variables/{key}");
    private static final PathTemplate UPDATE_CUSTOM_HEADER = PathTemplate.of("/hooks/{hook_id}/custom_headers/{key}");
    private static final PathTemplate LIST = PathTemplate.of("/hooks");
    private static final PathTemplate GET = PathTemplate.of("/hooks/{hook_id}");
    private static final JsonType<List<GitLabHook>> HOOK_LIST_TYPE = JsonTypes.listOf(GitLabHook.class);
    private static final GitLabListSpec<GitLabHook> HOOK_SPEC = GitLabListSpec.offset(HOOK_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSystemHooksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Update url variable ({@code PUT /hooks/{hook_id}/url_variables/{key}}).
     *
     * @param hookId the hook id
     * @param key the key
     * @param payload the request body
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateUrlVariable(
            final long hookId, final String key, final GitLabSystemHooksUpdateUrlVariablePayload payload)
            throws IOException {
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE_URL_VARIABLE, hookId, key), payload));
    }

    /**
     * Delete url variable ({@code DELETE /hooks/{hook_id}/url_variables/{key}}).
     *
     * @param hookId the hook id
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteUrlVariable(final long hookId, final String key) throws IOException {
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(UPDATE_URL_VARIABLE, hookId, key));
    }

    /**
     * Update custom header ({@code PUT /hooks/{hook_id}/custom_headers/{key}}).
     *
     * @param hookId the hook id
     * @param key the key
     * @param payload the request body
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateCustomHeader(
            final long hookId, final String key, final GitLabSystemHooksUpdateCustomHeaderPayload payload)
            throws IOException {
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE_CUSTOM_HEADER, hookId, key), payload));
    }

    /**
     * Delete custom header ({@code DELETE /hooks/{hook_id}/custom_headers/{key}}).
     *
     * @param hookId the hook id
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteCustomHeader(final long hookId, final String key) throws IOException {
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(UPDATE_CUSTOM_HEADER, hookId, key));
    }

    /**
     * List ({@code GET /hooks}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabHook> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /hooks}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabHook> list(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, HOOK_SPEC);
    }

    /**
     * Create ({@code POST /hooks}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabHook create(final GitLabSystemHooksCreatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST), payload), GitLabHook.class);
    }

    /**
     * Get ({@code GET /hooks/{hook_id}}).
     *
     * @param hookId the hook id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabHook> get(final long hookId) throws IOException {
        return caller.fetchOrEmpty(get(GET, hookId), GitLabHook.class);
    }

    /**
     * Create by hook id ({@code POST /hooks/{hook_id}}).
     *
     * @param hookId the hook id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createByHookId(final long hookId) throws IOException {
        caller.send(post(GET, hookId));
    }

    /**
     * Update ({@code PUT /hooks/{hook_id}}).
     *
     * @param hookId the hook id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabHook update(final long hookId, final GitLabSystemHooksUpdatePayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, hookId), payload), GitLabHook.class);
    }

    /**
     * Delete ({@code DELETE /hooks/{hook_id}}).
     *
     * @param hookId the hook id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabHook> delete(final long hookId) throws IOException {
        return caller.fetchOptional(delete(GET, hookId), GitLabHook.class);
    }
}
