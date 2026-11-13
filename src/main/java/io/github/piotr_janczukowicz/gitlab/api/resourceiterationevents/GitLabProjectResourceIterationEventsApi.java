package io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents;

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

/** The GitLab operations of project resource iteration events. */
public final class GitLabProjectResourceIterationEventsApi extends GitLabResourceApi {
    private static final PathTemplate LIST =
            PathTemplate.of("/projects/{id}/issues/{eventable_id}/resource_iteration_events");
    private static final PathTemplate GET =
            PathTemplate.of("/projects/{id}/issues/{eventable_id}/resource_iteration_events/{event_id}");
    private static final JsonType<List<GitLabResourceIterationEvent>> RESOURCE_ITERATION_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabResourceIterationEvent.class);
    private static final GitLabListSpec<GitLabResourceIterationEvent> RESOURCE_ITERATION_EVENT_SPEC =
            GitLabListSpec.offset(RESOURCE_ITERATION_EVENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectResourceIterationEventsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/issues/{eventable_id}/resource_iteration_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code eventableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabResourceIterationEvent> list(final String id, final String eventableId) throws IOException {
        return list(id, eventableId, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/issues/{eventable_id}/resource_iteration_events}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code eventableId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabResourceIterationEvent> list(
            final String id, final String eventableId, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdIssuesEventableIdResourceIterationEvents");
        requireNotBlank(id, "id");
        requireNotBlank(eventableId, "eventableId");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, RESOURCE_ITERATION_EVENT_SPEC, id, eventableId);
    }

    /**
     * Get ({@code GET /projects/{id}/issues/{eventable_id}/resource_iteration_events/{event_id}}).
     *
     * @param id the id
     * @param eventableId the eventable id
     * @param eventId the event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code eventableId} or {@code eventId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabResourceIterationEvent> get(final String id, final String eventableId, final String eventId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4ProjectsIdIssuesEventableIdResourceIterationEventsEventId");
        requireNotBlank(id, "id");
        requireNotBlank(eventableId, "eventableId");
        requireNotBlank(eventId, "eventId");
        return caller.fetchOrEmpty(get(GET, id, eventableId, eventId), GitLabResourceIterationEvent.class);
    }
}
