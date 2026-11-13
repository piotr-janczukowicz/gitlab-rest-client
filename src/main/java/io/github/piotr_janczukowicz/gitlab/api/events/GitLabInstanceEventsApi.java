package io.github.piotr_janczukowicz.gitlab.api.events;

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

/** The GitLab operations of instance events. */
public final class GitLabInstanceEventsApi extends GitLabResourceApi {
    private static final PathTemplate LIST_EVENTS = PathTemplate.of("/events");
    private static final PathTemplate LIST_USERS_EVENTS = PathTemplate.of("/users/{id}/events");
    private static final JsonType<List<GitLabEvent>> EVENT_LIST_TYPE = JsonTypes.listOf(GitLabEvent.class);
    private static final GitLabListSpec<GitLabEvent> EVENT_SPEC = GitLabListSpec.offset(EVENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceEventsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List events ({@code GET /events}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listEvents() throws IOException {
        return listEvents(GitLabInstanceEventsListEventsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List events ({@code GET /events}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listEvents(final GitLabPageRequest request) throws IOException {
        return listEvents(GitLabInstanceEventsListEventsFilter.empty(), request);
    }

    /**
     * List events ({@code GET /events}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listEvents(final GitLabInstanceEventsListEventsFilter filter) throws IOException {
        return listEvents(filter, GitLabPageRequest.byPage());
    }

    /**
     * List events ({@code GET /events}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listEvents(
            final GitLabInstanceEventsListEventsFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_EVENTS, queryParameters, request, EVENT_SPEC);
    }

    /**
     * List users events ({@code GET /users/{id}/events}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listUsersEvents(final String id) throws IOException {
        return listUsersEvents(id, GitLabInstanceEventsListUsersEventsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List users events ({@code GET /users/{id}/events}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listUsersEvents(final String id, final GitLabPageRequest request)
            throws IOException {
        return listUsersEvents(id, GitLabInstanceEventsListUsersEventsFilter.empty(), request);
    }

    /**
     * List users events ({@code GET /users/{id}/events}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listUsersEvents(
            final String id, final GitLabInstanceEventsListUsersEventsFilter filter) throws IOException {
        return listUsersEvents(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List users events ({@code GET /users/{id}/events}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEvent> listUsersEvents(
            final String id, final GitLabInstanceEventsListUsersEventsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_USERS_EVENTS, queryParameters, request, EVENT_SPEC, id);
    }
}
