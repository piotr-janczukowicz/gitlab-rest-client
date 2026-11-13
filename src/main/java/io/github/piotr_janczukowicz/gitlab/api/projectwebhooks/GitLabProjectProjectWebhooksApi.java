package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of project project webhooks. */
public final class GitLabProjectProjectWebhooksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_KEY = "key";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate UPDATE_URL_VARIABLE =
            PathTemplate.of("/projects/{id}/hooks/{hook_id}/url_variables/{key}");
    private static final PathTemplate UPDATE_CUSTOM_HEADER =
            PathTemplate.of("/projects/{id}/hooks/{hook_id}/custom_headers/{key}");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/hooks");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/hooks/{hook_id}");
    private static final PathTemplate CALL_EVENTS = PathTemplate.of("/projects/{id}/hooks/{hook_id}/events");
    private static final PathTemplate CREATE_TEST = PathTemplate.of("/projects/{id}/hooks/{hook_id}/test/{trigger}");
    private static final PathTemplate RESEND_EVENT =
            PathTemplate.of("/projects/{id}/hooks/{hook_id}/events/{hook_log_id}/resend");
    private static final JsonType<List<GitLabProjectHook>> PROJECT_HOOK_LIST_TYPE =
            JsonTypes.listOf(GitLabProjectHook.class);
    private static final GitLabListSpec<GitLabProjectHook> PROJECT_HOOK_SPEC =
            GitLabListSpec.offset(PROJECT_HOOK_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectWebhooksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Update url variable ({@code PUT /projects/{id}/hooks/{hook_id}/url_variables/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateUrlVariable(
            final String id,
            final long hookId,
            final String key,
            final GitLabProjectProjectWebhooksUpdateUrlVariablePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE_URL_VARIABLE, id, hookId, key), payload));
    }

    /**
     * Delete url variable ({@code DELETE /projects/{id}/hooks/{hook_id}/url_variables/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteUrlVariable(final String id, final long hookId, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(UPDATE_URL_VARIABLE, id, hookId, key));
    }

    /**
     * Update custom header ({@code PUT /projects/{id}/hooks/{hook_id}/custom_headers/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateCustomHeader(
            final String id,
            final long hookId,
            final String key,
            final GitLabProjectProjectWebhooksUpdateCustomHeaderPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE_CUSTOM_HEADER, id, hookId, key), payload));
    }

    /**
     * Delete custom header ({@code DELETE /projects/{id}/hooks/{hook_id}/custom_headers/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteCustomHeader(final String id, final long hookId, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(UPDATE_CUSTOM_HEADER, id, hookId, key));
    }

    /**
     * List ({@code GET /projects/{id}/hooks}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectHook> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/hooks}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProjectHook> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, PROJECT_HOOK_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/hooks}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectHook create(final String id, final GitLabProjectProjectWebhooksCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabProjectHook.class);
    }

    /**
     * Get ({@code GET /projects/{id}/hooks/{hook_id}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectHook> get(final String id, final long hookId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, hookId), GitLabProjectHook.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/hooks/{hook_id}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectHook update(
            final String id, final long hookId, final GitLabProjectProjectWebhooksUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, hookId), payload), GitLabProjectHook.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/hooks/{hook_id}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectHook> delete(final String id, final long hookId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET, id, hookId), GitLabProjectHook.class);
    }

    /**
     * Call events ({@code GET /projects/{id}/hooks/{hook_id}/events}).
     *
     * @param id the id
     * @param hookId the hook id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callEvents(final String id, final long hookId) throws IOException {
        callEvents(id, hookId, GitLabProjectProjectWebhooksCallEventsFilter.empty());
    }

    /**
     * Call events ({@code GET /projects/{id}/hooks/{hook_id}/events}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callEvents(
            final String id, final long hookId, final GitLabProjectProjectWebhooksCallEventsFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_EVENTS, id, hookId).withQuery(queryParameters));
    }

    /**
     * Create test ({@code POST /projects/{id}/hooks/{hook_id}/test/{trigger}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param trigger the trigger
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code trigger} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createTest(
            final String id, final long hookId, final GitLabProjectProjectWebhooksCreateTestTrigger trigger)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(trigger, "trigger");
        caller.send(post(CREATE_TEST, id, hookId, trigger.wireValue()));
    }

    /**
     * Resend event ({@code POST /projects/{id}/hooks/{hook_id}/events/{hook_log_id}/resend}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param hookLogId the hook log id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void resendEvent(final String id, final long hookId, final long hookLogId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(RESEND_EVENT, id, hookId, hookLogId));
    }
}
