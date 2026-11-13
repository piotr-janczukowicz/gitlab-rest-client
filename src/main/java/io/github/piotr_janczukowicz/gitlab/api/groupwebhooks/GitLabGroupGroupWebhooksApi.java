package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
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

/** The GitLab operations of group group webhooks. */
public final class GitLabGroupGroupWebhooksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_KEY = "key";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/hooks");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/hooks/{hook_id}");
    private static final PathTemplate CALL_EVENTS = PathTemplate.of("/groups/{id}/hooks/{hook_id}/events");
    private static final PathTemplate UPDATE_URL_VARIABLE =
            PathTemplate.of("/groups/{id}/hooks/{hook_id}/url_variables/{key}");
    private static final PathTemplate UPDATE_CUSTOM_HEADER =
            PathTemplate.of("/groups/{id}/hooks/{hook_id}/custom_headers/{key}");
    private static final PathTemplate CREATE_TEST = PathTemplate.of("/groups/{id}/hooks/{hook_id}/test/{trigger}");
    private static final PathTemplate RESEND_EVENT =
            PathTemplate.of("/groups/{id}/hooks/{hook_id}/events/{hook_log_id}/resend");
    private static final JsonType<List<GitLabGroupHook>> GROUP_HOOK_LIST_TYPE = JsonTypes.listOf(GitLabGroupHook.class);
    private static final GitLabListSpec<GitLabGroupHook> GROUP_HOOK_SPEC = GitLabListSpec.offset(GROUP_HOOK_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupWebhooksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/hooks}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupHook> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/hooks}).
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
    public GitLabPage<GitLabGroupHook> list(final String id, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdHooks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, GROUP_HOOK_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/hooks}).
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
    public GitLabGroupHook create(final String id, final GitLabGroupGroupWebhooksCreatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdHooks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabGroupHook.class);
    }

    /**
     * Get ({@code GET /groups/{id}/hooks/{hook_id}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGroupHook> get(final String id, final long hookId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdHooksHookId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, hookId), GitLabGroupHook.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/hooks/{hook_id}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGroupHook update(
            final String id, final long hookId, final GitLabGroupGroupWebhooksUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdHooksHookId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, hookId), payload), GitLabGroupHook.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/hooks/{hook_id}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final long hookId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdHooksHookId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, hookId));
    }

    /**
     * Call events ({@code GET /groups/{id}/hooks/{hook_id}/events}).
     *
     * @param id the id
     * @param hookId the hook id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void callEvents(final String id, final long hookId) throws IOException {
        callEvents(id, hookId, GitLabGroupGroupWebhooksCallEventsFilter.empty());
    }

    /**
     * Call events ({@code GET /groups/{id}/hooks/{hook_id}/events}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void callEvents(final String id, final long hookId, final GitLabGroupGroupWebhooksCallEventsFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdHooksHookIdEvents");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_EVENTS, id, hookId).withQuery(queryParameters));
    }

    /**
     * Update url variable ({@code PUT /groups/{id}/hooks/{hook_id}/url_variables/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void updateUrlVariable(
            final String id,
            final long hookId,
            final String key,
            final GitLabGroupGroupWebhooksUpdateUrlVariablePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdHooksHookIdUrlVariablesKey");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE_URL_VARIABLE, id, hookId, key), payload));
    }

    /**
     * Delete url variable ({@code DELETE /groups/{id}/hooks/{hook_id}/url_variables/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteUrlVariable(final String id, final long hookId, final String key) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdHooksHookIdUrlVariablesKey");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(UPDATE_URL_VARIABLE, id, hookId, key));
    }

    /**
     * Update custom header ({@code PUT /groups/{id}/hooks/{hook_id}/custom_headers/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void updateCustomHeader(
            final String id,
            final long hookId,
            final String key,
            final GitLabGroupGroupWebhooksUpdateCustomHeaderPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdHooksHookIdCustomHeadersKey");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(UPDATE_CUSTOM_HEADER, id, hookId, key), payload));
    }

    /**
     * Delete custom header ({@code DELETE /groups/{id}/hooks/{hook_id}/custom_headers/{key}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param key the key
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteCustomHeader(final String id, final long hookId, final String key) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdHooksHookIdCustomHeadersKey");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(UPDATE_CUSTOM_HEADER, id, hookId, key));
    }

    /**
     * Create test ({@code POST /groups/{id}/hooks/{hook_id}/test/{trigger}}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param trigger the trigger
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code trigger} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void createTest(final String id, final long hookId, final GitLabGroupGroupWebhooksCreateTestTrigger trigger)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdHooksHookIdTestTrigger");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(trigger, "trigger");
        caller.send(post(CREATE_TEST, id, hookId, trigger.wireValue()));
    }

    /**
     * Resend event ({@code POST /groups/{id}/hooks/{hook_id}/events/{hook_log_id}/resend}).
     *
     * @param id the id
     * @param hookId the hook id
     * @param hookLogId the hook log id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void resendEvent(final String id, final long hookId, final long hookLogId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdHooksHookIdEventsHookLogIdResend");
        requireNotBlank(id, PARAM_ID);
        caller.send(post(RESEND_EVENT, id, hookId, hookLogId));
    }
}
