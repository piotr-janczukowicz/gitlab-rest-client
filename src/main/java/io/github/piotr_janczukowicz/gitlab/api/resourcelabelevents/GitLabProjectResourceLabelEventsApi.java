package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

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

/** The GitLab operations of project resource label events. */
public final class GitLabProjectResourceLabelEventsApi extends GitLabResourceApi {
    private static final String PARAM_EVENTABLEID = "eventableId";
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST_ISSUES_RESOURCE_LABEL_EVENTS =
            PathTemplate.of("/projects/{id}/issues/{eventable_id}/resource_label_events");
    private static final PathTemplate GET_ISSUES_RESOURCE_LABEL_EVENTS =
            PathTemplate.of("/projects/{id}/issues/{eventable_id}/resource_label_events/{event_id}");
    private static final PathTemplate LIST_REQUESTS_RESOURCE_LABEL_EVENTS =
            PathTemplate.of("/projects/{id}/merge_requests/{eventable_id}/resource_label_events");
    private static final PathTemplate GET_REQUESTS_RESOURCE_LABEL_EVENTS =
            PathTemplate.of("/projects/{id}/merge_requests/{eventable_id}/resource_label_events/{event_id}");
    private static final JsonType<List<GitLabResourceLabelEvent>> RESOURCE_LABEL_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabResourceLabelEvent.class);
    private static final GitLabListSpec<GitLabResourceLabelEvent> RESOURCE_LABEL_EVENT_SPEC =
            GitLabListSpec.offset(RESOURCE_LABEL_EVENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectResourceLabelEventsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List issues resource label events ({@code GET /projects/{id}/issues/{eventable_id}/resource_label_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code eventableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceLabelEvent> listIssuesResourceLabelEvents(final String id, final String eventableId)
            throws IOException {
        return listIssuesResourceLabelEvents(id, eventableId, GitLabPageRequest.byPage());
    }

    /**
     * List issues resource label events ({@code GET /projects/{id}/issues/{eventable_id}/resource_label_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code eventableId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceLabelEvent> listIssuesResourceLabelEvents(
            final String id, final String eventableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(eventableId, PARAM_EVENTABLEID);
        requireNonNull(request, "request");
        return pageList(
                LIST_ISSUES_RESOURCE_LABEL_EVENTS, Map.of(), request, RESOURCE_LABEL_EVENT_SPEC, id, eventableId);
    }

    /**
     * Get issues resource label events ({@code GET
     * /projects/{id}/issues/{eventable_id}/resource_label_events/{event_id}}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param eventId the event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code eventableId} or {@code eventId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabResourceLabelEvent> getIssuesResourceLabelEvents(
            final String id, final String eventableId, final String eventId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(eventableId, PARAM_EVENTABLEID);
        requireNotBlank(eventId, "eventId");
        return caller.fetchOrEmpty(
                get(GET_ISSUES_RESOURCE_LABEL_EVENTS, id, eventableId, eventId), GitLabResourceLabelEvent.class);
    }

    /**
     * List requests resource label events ({@code GET
     * /projects/{id}/merge_requests/{eventable_id}/resource_label_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code eventableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceLabelEvent> listRequestsResourceLabelEvents(
            final String id, final String eventableId) throws IOException {
        return listRequestsResourceLabelEvents(id, eventableId, GitLabPageRequest.byPage());
    }

    /**
     * List requests resource label events ({@code GET
     * /projects/{id}/merge_requests/{eventable_id}/resource_label_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code eventableId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabResourceLabelEvent> listRequestsResourceLabelEvents(
            final String id, final String eventableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(eventableId, PARAM_EVENTABLEID);
        requireNonNull(request, "request");
        return pageList(
                LIST_REQUESTS_RESOURCE_LABEL_EVENTS, Map.of(), request, RESOURCE_LABEL_EVENT_SPEC, id, eventableId);
    }

    /**
     * Get requests resource label events ({@code GET
     * /projects/{id}/merge_requests/{eventable_id}/resource_label_events/{event_id}}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param eventId the event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code eventableId} or {@code eventId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabResourceLabelEvent> getRequestsResourceLabelEvents(
            final String id, final String eventableId, final String eventId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(eventableId, PARAM_EVENTABLEID);
        requireNotBlank(eventId, "eventId");
        return caller.fetchOrEmpty(
                get(GET_REQUESTS_RESOURCE_LABEL_EVENTS, id, eventableId, eventId), GitLabResourceLabelEvent.class);
    }
}
