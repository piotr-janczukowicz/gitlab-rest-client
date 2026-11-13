package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

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

/** The GitLab operations of project resource state events. */
public final class GitLabProjectResourceStateEventsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST_ISSUES_RESOURCE_STATE_EVENTS =
            PathTemplate.of("/projects/{id}/issues/{eventable_id}/resource_state_events");
    private static final PathTemplate GET_ISSUES_RESOURCE_STATE_EVENTS =
            PathTemplate.of("/projects/{id}/issues/{eventable_id}/resource_state_events/{event_id}");
    private static final PathTemplate LIST_REQUESTS_RESOURCE_STATE_EVENTS =
            PathTemplate.of("/projects/{id}/merge_requests/{eventable_id}/resource_state_events");
    private static final PathTemplate GET_REQUESTS_RESOURCE_STATE_EVENTS =
            PathTemplate.of("/projects/{id}/merge_requests/{eventable_id}/resource_state_events/{event_id}");
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
    public GitLabProjectResourceStateEventsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List issues resource state events ({@code GET /projects/{id}/issues/{eventable_id}/resource_state_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceStateEvent> listIssuesResourceStateEvents(final String id, final long eventableId)
            throws IOException {
        return listIssuesResourceStateEvents(id, eventableId, GitLabPageRequest.byPage());
    }

    /**
     * List issues resource state events ({@code GET /projects/{id}/issues/{eventable_id}/resource_state_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceStateEvent> listIssuesResourceStateEvents(
            final String id, final long eventableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(
                LIST_ISSUES_RESOURCE_STATE_EVENTS, Map.of(), request, RESOURCE_STATE_EVENT_SPEC, id, eventableId);
    }

    /**
     * Get issues resource state events ({@code GET
     * /projects/{id}/issues/{eventable_id}/resource_state_events/{event_id}}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param eventId the event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabResourceStateEvent> getIssuesResourceStateEvents(
            final String id, final long eventableId, final long eventId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_ISSUES_RESOURCE_STATE_EVENTS, id, eventableId, eventId), GitLabResourceStateEvent.class);
    }

    /**
     * List requests resource state events ({@code GET
     * /projects/{id}/merge_requests/{eventable_id}/resource_state_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceStateEvent> listRequestsResourceStateEvents(final String id, final long eventableId)
            throws IOException {
        return listRequestsResourceStateEvents(id, eventableId, GitLabPageRequest.byPage());
    }

    /**
     * List requests resource state events ({@code GET
     * /projects/{id}/merge_requests/{eventable_id}/resource_state_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceStateEvent> listRequestsResourceStateEvents(
            final String id, final long eventableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(
                LIST_REQUESTS_RESOURCE_STATE_EVENTS, Map.of(), request, RESOURCE_STATE_EVENT_SPEC, id, eventableId);
    }

    /**
     * Get requests resource state events ({@code GET
     * /projects/{id}/merge_requests/{eventable_id}/resource_state_events/{event_id}}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param eventId the event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabResourceStateEvent> getRequestsResourceStateEvents(
            final String id, final long eventableId, final long eventId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_REQUESTS_RESOURCE_STATE_EVENTS, id, eventableId, eventId), GitLabResourceStateEvent.class);
    }
}
