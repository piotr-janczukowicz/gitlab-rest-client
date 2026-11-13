package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

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

/** The GitLab operations of group resource state events. */
public final class GitLabGroupResourceStateEventsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epics/{eventable_id}/resource_state_events");
    private static final PathTemplate GET =
            PathTemplate.of("/groups/{id}/epics/{eventable_id}/resource_state_events/{event_id}");
    private static final JsonType<List<GitLabResourceStateEvent>> RESOURCE_STATE_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabResourceStateEvent.class);
    private static final GitLabListSpec<GitLabResourceStateEvent> RESOURCE_STATE_EVENT_SPEC =
            GitLabListSpec.offset(RESOURCE_STATE_EVENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupResourceStateEventsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/epics/{eventable_id}/resource_state_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabResourceStateEvent> list(final String id, final long eventableId) throws IOException {
        return list(id, eventableId, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/epics/{eventable_id}/resource_state_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabResourceStateEvent> list(
            final String id, final long eventableId, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEventableIdResourceStateEvents");
        requireNotBlank(id, "id");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, RESOURCE_STATE_EVENT_SPEC, id, eventableId);
    }

    /**
     * Get ({@code GET /groups/{id}/epics/{eventable_id}/resource_state_events/{event_id}}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param eventId the event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabResourceStateEvent> get(final String id, final long eventableId, final long eventId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEventableIdResourceStateEventsEventId");
        requireNotBlank(id, "id");
        return caller.fetchOrEmpty(get(GET, id, eventableId, eventId), GitLabResourceStateEvent.class);
    }
}
