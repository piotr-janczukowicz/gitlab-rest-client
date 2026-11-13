package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
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

/** The GitLab operations of project notes. */
public final class GitLabProjectNotesApi extends GitLabResourceApi {
    private static final String PARAM_DISCUSSIONID = "discussionId";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_ISSUES_NOTES = PathTemplate.of("/projects/{id}/issues/{noteable_id}/notes");
    private static final PathTemplate GET_ISSUES_NOTES =
            PathTemplate.of("/projects/{id}/issues/{noteable_id}/notes/{note_id}");
    private static final PathTemplate LIST_REQUESTS_NOTES =
            PathTemplate.of("/projects/{id}/merge_requests/{noteable_id}/notes");
    private static final PathTemplate GET_REQUESTS_NOTES =
            PathTemplate.of("/projects/{id}/merge_requests/{noteable_id}/notes/{note_id}");
    private static final PathTemplate LIST_SNIPPETS_NOTES =
            PathTemplate.of("/projects/{id}/snippets/{noteable_id}/notes");
    private static final PathTemplate GET_SNIPPETS_NOTES =
            PathTemplate.of("/projects/{id}/snippets/{noteable_id}/notes/{note_id}");
    private static final PathTemplate LIST_WIKI_PAGES_NOTES =
            PathTemplate.of("/projects/{id}/wiki_pages/{noteable_id}/notes");
    private static final PathTemplate GET_WIKI_PAGES_NOTE =
            PathTemplate.of("/projects/{id}/wiki_pages/{noteable_id}/notes/{note_id}");
    private static final PathTemplate LIST_ISSUES_DISCUSSIONS_NOTES =
            PathTemplate.of("/projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes");
    private static final PathTemplate GET_ISSUES_DISCUSSIONS_NOTES =
            PathTemplate.of("/projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes/{note_id}");
    private static final PathTemplate LIST_SNIPPETS_DISCUSSIONS_NOTES =
            PathTemplate.of("/projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes");
    private static final PathTemplate GET_SNIPPETS_DISCUSSIONS_NOTES =
            PathTemplate.of("/projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes/{note_id}");
    private static final PathTemplate LIST_REQUESTS_DISCUSSIONS_NOTES =
            PathTemplate.of("/projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes");
    private static final PathTemplate GET_REQUESTS_DISCUSSIONS_NOTES =
            PathTemplate.of("/projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes/{note_id}");
    private static final JsonType<List<GitLabNote>> NOTE_LIST_TYPE = JsonTypes.listOf(GitLabNote.class);
    private static final GitLabListSpec<GitLabNote> NOTE_SPEC = GitLabListSpec.offset(NOTE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectNotesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List issues notes ({@code GET /projects/{id}/issues/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listIssuesNotes(final String id, final long noteableId) throws IOException {
        return listIssuesNotes(
                id, noteableId, GitLabProjectNotesListIssuesNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List issues notes ({@code GET /projects/{id}/issues/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listIssuesNotes(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        return listIssuesNotes(id, noteableId, GitLabProjectNotesListIssuesNotesFilter.empty(), request);
    }

    /**
     * List issues notes ({@code GET /projects/{id}/issues/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listIssuesNotes(
            final String id, final long noteableId, final GitLabProjectNotesListIssuesNotesFilter filter)
            throws IOException {
        return listIssuesNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List issues notes ({@code GET /projects/{id}/issues/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listIssuesNotes(
            final String id,
            final long noteableId,
            final GitLabProjectNotesListIssuesNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ISSUES_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create issues notes ({@code POST /projects/{id}/issues/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createIssuesNotes(
            final String id, final long noteableId, final GitLabProjectNotesCreateIssuesNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_ISSUES_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get issues notes ({@code GET /projects/{id}/issues/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getIssuesNotes(final String id, final long noteableId, final long noteId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_ISSUES_NOTES, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update issues notes ({@code PUT /projects/{id}/issues/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateIssuesNotes(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabProjectNotesUpdateIssuesNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_ISSUES_NOTES, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete issues notes ({@code DELETE /projects/{id}/issues/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteIssuesNotes(final String id, final long noteableId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_ISSUES_NOTES, id, noteableId, noteId));
    }

    /**
     * List requests notes ({@code GET /projects/{id}/merge_requests/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listRequestsNotes(final String id, final long noteableId) throws IOException {
        return listRequestsNotes(
                id, noteableId, GitLabProjectNotesListRequestsNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List requests notes ({@code GET /projects/{id}/merge_requests/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listRequestsNotes(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        return listRequestsNotes(id, noteableId, GitLabProjectNotesListRequestsNotesFilter.empty(), request);
    }

    /**
     * List requests notes ({@code GET /projects/{id}/merge_requests/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listRequestsNotes(
            final String id, final long noteableId, final GitLabProjectNotesListRequestsNotesFilter filter)
            throws IOException {
        return listRequestsNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List requests notes ({@code GET /projects/{id}/merge_requests/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listRequestsNotes(
            final String id,
            final long noteableId,
            final GitLabProjectNotesListRequestsNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_REQUESTS_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create requests notes ({@code POST /projects/{id}/merge_requests/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createRequestsNotes(
            final String id, final long noteableId, final GitLabProjectNotesCreateRequestsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_REQUESTS_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get requests notes ({@code GET /projects/{id}/merge_requests/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getRequestsNotes(final String id, final long noteableId, final long noteId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_REQUESTS_NOTES, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update requests notes ({@code PUT /projects/{id}/merge_requests/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateRequestsNotes(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabProjectNotesUpdateRequestsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_REQUESTS_NOTES, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete requests notes ({@code DELETE /projects/{id}/merge_requests/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteRequestsNotes(final String id, final long noteableId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_REQUESTS_NOTES, id, noteableId, noteId));
    }

    /**
     * List snippets notes ({@code GET /projects/{id}/snippets/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listSnippetsNotes(final String id, final long noteableId) throws IOException {
        return listSnippetsNotes(
                id, noteableId, GitLabProjectNotesListSnippetsNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List snippets notes ({@code GET /projects/{id}/snippets/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listSnippetsNotes(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        return listSnippetsNotes(id, noteableId, GitLabProjectNotesListSnippetsNotesFilter.empty(), request);
    }

    /**
     * List snippets notes ({@code GET /projects/{id}/snippets/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listSnippetsNotes(
            final String id, final long noteableId, final GitLabProjectNotesListSnippetsNotesFilter filter)
            throws IOException {
        return listSnippetsNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List snippets notes ({@code GET /projects/{id}/snippets/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listSnippetsNotes(
            final String id,
            final long noteableId,
            final GitLabProjectNotesListSnippetsNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_SNIPPETS_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create snippets notes ({@code POST /projects/{id}/snippets/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createSnippetsNotes(
            final String id, final long noteableId, final GitLabProjectNotesCreateSnippetsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_SNIPPETS_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get snippets notes ({@code GET /projects/{id}/snippets/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getSnippetsNotes(final String id, final long noteableId, final long noteId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_SNIPPETS_NOTES, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update snippets notes ({@code PUT /projects/{id}/snippets/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateSnippetsNotes(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabProjectNotesUpdateSnippetsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_SNIPPETS_NOTES, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete snippets notes ({@code DELETE /projects/{id}/snippets/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteSnippetsNotes(final String id, final long noteableId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_SNIPPETS_NOTES, id, noteableId, noteId));
    }

    /**
     * List wiki pages notes ({@code GET /projects/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listWikiPagesNotes(final String id, final long noteableId) throws IOException {
        return listWikiPagesNotes(
                id, noteableId, GitLabProjectNotesListWikiPagesNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List wiki pages notes ({@code GET /projects/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listWikiPagesNotes(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        return listWikiPagesNotes(id, noteableId, GitLabProjectNotesListWikiPagesNotesFilter.empty(), request);
    }

    /**
     * List wiki pages notes ({@code GET /projects/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listWikiPagesNotes(
            final String id, final long noteableId, final GitLabProjectNotesListWikiPagesNotesFilter filter)
            throws IOException {
        return listWikiPagesNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List wiki pages notes ({@code GET /projects/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabNote> listWikiPagesNotes(
            final String id,
            final long noteableId,
            final GitLabProjectNotesListWikiPagesNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_WIKI_PAGES_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create wiki pages note ({@code POST /projects/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createWikiPagesNote(
            final String id, final long noteableId, final GitLabProjectNotesCreateWikiPagesNotePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_WIKI_PAGES_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get wiki pages note ({@code GET /projects/{id}/wiki_pages/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getWikiPagesNote(final String id, final long noteableId, final long noteId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_WIKI_PAGES_NOTE, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update wiki pages note ({@code PUT /projects/{id}/wiki_pages/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateWikiPagesNote(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabProjectNotesUpdateWikiPagesNotePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_WIKI_PAGES_NOTE, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete wiki pages note ({@code DELETE /projects/{id}/wiki_pages/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> deleteWikiPagesNote(final String id, final long noteableId, final long noteId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET_WIKI_PAGES_NOTE, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * List issues discussions notes ({@code GET
     * /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabNote> listIssuesDiscussionsNotes(
            final String id, final long noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetch(get(LIST_ISSUES_DISCUSSIONS_NOTES, id, noteableId, discussionId), NOTE_LIST_TYPE);
    }

    /**
     * Create issues discussions notes ({@code POST
     * /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createIssuesDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabProjectNotesCreateIssuesDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_ISSUES_DISCUSSIONS_NOTES, id, noteableId, discussionId), payload),
                GitLabNote.class);
    }

    /**
     * Get issues discussions notes ({@code GET
     * /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getIssuesDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(
                get(GET_ISSUES_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * Update issues discussions notes ({@code PUT
     * /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateIssuesDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final long noteId,
            final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_ISSUES_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), payload),
                GitLabNote.class);
    }

    /**
     * Delete issues discussions notes ({@code DELETE
     * /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteIssuesDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        caller.send(delete(GET_ISSUES_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId));
    }

    /**
     * List snippets discussions notes ({@code GET
     * /projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabNote> listSnippetsDiscussionsNotes(
            final String id, final long noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetch(get(LIST_SNIPPETS_DISCUSSIONS_NOTES, id, noteableId, discussionId), NOTE_LIST_TYPE);
    }

    /**
     * Create snippets discussions notes ({@code POST
     * /projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createSnippetsDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_SNIPPETS_DISCUSSIONS_NOTES, id, noteableId, discussionId), payload),
                GitLabNote.class);
    }

    /**
     * Get snippets discussions notes ({@code GET
     * /projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getSnippetsDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(
                get(GET_SNIPPETS_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * Update snippets discussions notes ({@code PUT
     * /projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateSnippetsDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final long noteId,
            final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_SNIPPETS_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), payload),
                GitLabNote.class);
    }

    /**
     * Delete snippets discussions notes ({@code DELETE
     * /projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> deleteSnippetsDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOptional(
                delete(GET_SNIPPETS_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * List requests discussions notes ({@code GET
     * /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabNote> listRequestsDiscussionsNotes(
            final String id, final long noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetch(get(LIST_REQUESTS_DISCUSSIONS_NOTES, id, noteableId, discussionId), NOTE_LIST_TYPE);
    }

    /**
     * Create requests discussions notes ({@code POST
     * /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createRequestsDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabProjectNotesCreateRequestsDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REQUESTS_DISCUSSIONS_NOTES, id, noteableId, discussionId), payload),
                GitLabNote.class);
    }

    /**
     * Get requests discussions notes ({@code GET
     * /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getRequestsDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(
                get(GET_REQUESTS_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * Update requests discussions notes ({@code PUT
     * /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateRequestsDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final long noteId,
            final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_REQUESTS_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), payload),
                GitLabNote.class);
    }

    /**
     * Delete requests discussions notes ({@code DELETE
     * /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> deleteRequestsDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOptional(
                delete(GET_REQUESTS_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }
}
