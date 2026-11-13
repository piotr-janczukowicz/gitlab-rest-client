package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
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

/** The GitLab operations of project emoji reactions. */
public final class GitLabProjectEmojiReactionsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_ISSUES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/award_emoji");
    private static final PathTemplate GET_ISSUES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/award_emoji/{award_id}");
    private static final PathTemplate LIST_ISSUES_NOTES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji");
    private static final PathTemplate GET_ISSUES_NOTES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji/{award_id}");
    private static final PathTemplate LIST_REQUESTS_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/award_emoji");
    private static final PathTemplate GET_REQUESTS_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/award_emoji/{award_id}");
    private static final PathTemplate LIST_REQUESTS_NOTES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji");
    private static final PathTemplate GET_REQUESTS_NOTES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji/{award_id}");
    private static final PathTemplate LIST_SNIPPETS_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/snippets/{snippet_id}/award_emoji");
    private static final PathTemplate GET_SNIPPETS_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/snippets/{snippet_id}/award_emoji/{award_id}");
    private static final PathTemplate LIST_SNIPPETS_NOTES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji");
    private static final PathTemplate GET_SNIPPETS_NOTES_AWARD_EMOJI =
            PathTemplate.of("/projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji/{award_id}");
    private static final JsonType<List<GitLabAwardEmoji>> AWARD_EMOJI_LIST_TYPE =
            JsonTypes.listOf(GitLabAwardEmoji.class);
    private static final GitLabListSpec<GitLabAwardEmoji> AWARD_EMOJI_SPEC =
            GitLabListSpec.offset(AWARD_EMOJI_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectEmojiReactionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List issues award emoji ({@code GET /projects/{id}/issues/{issue_iid}/award_emoji}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listIssuesAwardEmoji(final String id, final long issueIid) throws IOException {
        return listIssuesAwardEmoji(id, issueIid, GitLabPageRequest.byPage());
    }

    /**
     * List issues award emoji ({@code GET /projects/{id}/issues/{issue_iid}/award_emoji}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listIssuesAwardEmoji(
            final String id, final long issueIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_ISSUES_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, issueIid);
    }

    /**
     * Create issues award emoji ({@code POST /projects/{id}/issues/{issue_iid}/award_emoji}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAwardEmoji createIssuesAwardEmoji(
            final String id,
            final long issueIid,
            final GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_ISSUES_AWARD_EMOJI, id, issueIid), payload), GitLabAwardEmoji.class);
    }

    /**
     * Get issues award emoji ({@code GET /projects/{id}/issues/{issue_iid}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAwardEmoji> getIssuesAwardEmoji(final String id, final long issueIid, final long awardId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_ISSUES_AWARD_EMOJI, id, issueIid, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete issues award emoji ({@code DELETE /projects/{id}/issues/{issue_iid}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteIssuesAwardEmoji(final String id, final long issueIid, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_ISSUES_AWARD_EMOJI, id, issueIid, awardId));
    }

    /**
     * List issues notes award emoji ({@code GET /projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param noteId the note id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listIssuesNotesAwardEmoji(
            final String id, final long issueIid, final long noteId) throws IOException {
        return listIssuesNotesAwardEmoji(id, issueIid, noteId, GitLabPageRequest.byPage());
    }

    /**
     * List issues notes award emoji ({@code GET /projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param noteId the note id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listIssuesNotesAwardEmoji(
            final String id, final long issueIid, final long noteId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_ISSUES_NOTES_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, issueIid, noteId);
    }

    /**
     * Create issues notes award emoji ({@code POST /projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAwardEmoji createIssuesNotesAwardEmoji(
            final String id,
            final long issueIid,
            final long noteId,
            final GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_ISSUES_NOTES_AWARD_EMOJI, id, issueIid, noteId), payload),
                GitLabAwardEmoji.class);
    }

    /**
     * Get issues notes award emoji ({@code GET
     * /projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param noteId the note id
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAwardEmoji> getIssuesNotesAwardEmoji(
            final String id, final long issueIid, final long noteId, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_ISSUES_NOTES_AWARD_EMOJI, id, issueIid, noteId, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete issues notes award emoji ({@code DELETE
     * /projects/{id}/issues/{issue_iid}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param issueIid the issue iid
     * @param noteId the note id
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteIssuesNotesAwardEmoji(final String id, final long issueIid, final long noteId, final long awardId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_ISSUES_NOTES_AWARD_EMOJI, id, issueIid, noteId, awardId));
    }

    /**
     * List requests award emoji ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/award_emoji}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listRequestsAwardEmoji(final String id, final long mergeRequestIid)
            throws IOException {
        return listRequestsAwardEmoji(id, mergeRequestIid, GitLabPageRequest.byPage());
    }

    /**
     * List requests award emoji ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/award_emoji}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listRequestsAwardEmoji(
            final String id, final long mergeRequestIid, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REQUESTS_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, mergeRequestIid);
    }

    /**
     * Create requests award emoji ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/award_emoji}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAwardEmoji createRequestsAwardEmoji(
            final String id,
            final long mergeRequestIid,
            final GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REQUESTS_AWARD_EMOJI, id, mergeRequestIid), payload), GitLabAwardEmoji.class);
    }

    /**
     * Get requests award emoji ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAwardEmoji> getRequestsAwardEmoji(
            final String id, final long mergeRequestIid, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_REQUESTS_AWARD_EMOJI, id, mergeRequestIid, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete requests award emoji ({@code DELETE
     * /projects/{id}/merge_requests/{merge_request_iid}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteRequestsAwardEmoji(final String id, final long mergeRequestIid, final long awardId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_REQUESTS_AWARD_EMOJI, id, mergeRequestIid, awardId));
    }

    /**
     * List requests notes award emoji ({@code GET
     * /projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param noteId the note id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listRequestsNotesAwardEmoji(
            final String id, final long mergeRequestIid, final long noteId) throws IOException {
        return listRequestsNotesAwardEmoji(id, mergeRequestIid, noteId, GitLabPageRequest.byPage());
    }

    /**
     * List requests notes award emoji ({@code GET
     * /projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param noteId the note id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listRequestsNotesAwardEmoji(
            final String id, final long mergeRequestIid, final long noteId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(
                LIST_REQUESTS_NOTES_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, mergeRequestIid, noteId);
    }

    /**
     * Create requests notes award emoji ({@code POST
     * /projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAwardEmoji createRequestsNotesAwardEmoji(
            final String id,
            final long mergeRequestIid,
            final long noteId,
            final GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REQUESTS_NOTES_AWARD_EMOJI, id, mergeRequestIid, noteId), payload),
                GitLabAwardEmoji.class);
    }

    /**
     * Get requests notes award emoji ({@code GET
     * /projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param noteId the note id
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAwardEmoji> getRequestsNotesAwardEmoji(
            final String id, final long mergeRequestIid, final long noteId, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_REQUESTS_NOTES_AWARD_EMOJI, id, mergeRequestIid, noteId, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete requests notes award emoji ({@code DELETE
     * /projects/{id}/merge_requests/{merge_request_iid}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param noteId the note id
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteRequestsNotesAwardEmoji(
            final String id, final long mergeRequestIid, final long noteId, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_REQUESTS_NOTES_AWARD_EMOJI, id, mergeRequestIid, noteId, awardId));
    }

    /**
     * List snippets award emoji ({@code GET /projects/{id}/snippets/{snippet_id}/award_emoji}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listSnippetsAwardEmoji(final String id, final long snippetId)
            throws IOException {
        return listSnippetsAwardEmoji(id, snippetId, GitLabPageRequest.byPage());
    }

    /**
     * List snippets award emoji ({@code GET /projects/{id}/snippets/{snippet_id}/award_emoji}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listSnippetsAwardEmoji(
            final String id, final long snippetId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_SNIPPETS_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, snippetId);
    }

    /**
     * Create snippets award emoji ({@code POST /projects/{id}/snippets/{snippet_id}/award_emoji}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAwardEmoji createSnippetsAwardEmoji(
            final String id,
            final long snippetId,
            final GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_SNIPPETS_AWARD_EMOJI, id, snippetId), payload), GitLabAwardEmoji.class);
    }

    /**
     * Get snippets award emoji ({@code GET /projects/{id}/snippets/{snippet_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAwardEmoji> getSnippetsAwardEmoji(final String id, final long snippetId, final long awardId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_SNIPPETS_AWARD_EMOJI, id, snippetId, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete snippets award emoji ({@code DELETE /projects/{id}/snippets/{snippet_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteSnippetsAwardEmoji(final String id, final long snippetId, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_SNIPPETS_AWARD_EMOJI, id, snippetId, awardId));
    }

    /**
     * List snippets notes award emoji ({@code GET /projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param noteId the note id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listSnippetsNotesAwardEmoji(
            final String id, final long snippetId, final long noteId) throws IOException {
        return listSnippetsNotesAwardEmoji(id, snippetId, noteId, GitLabPageRequest.byPage());
    }

    /**
     * List snippets notes award emoji ({@code GET /projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param noteId the note id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabAwardEmoji> listSnippetsNotesAwardEmoji(
            final String id, final long snippetId, final long noteId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_SNIPPETS_NOTES_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, snippetId, noteId);
    }

    /**
     * Create snippets notes award emoji ({@code POST
     * /projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAwardEmoji createSnippetsNotesAwardEmoji(
            final String id,
            final long snippetId,
            final long noteId,
            final GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_SNIPPETS_NOTES_AWARD_EMOJI, id, snippetId, noteId), payload),
                GitLabAwardEmoji.class);
    }

    /**
     * Get snippets notes award emoji ({@code GET
     * /projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param noteId the note id
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAwardEmoji> getSnippetsNotesAwardEmoji(
            final String id, final long snippetId, final long noteId, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_SNIPPETS_NOTES_AWARD_EMOJI, id, snippetId, noteId, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete snippets notes award emoji ({@code DELETE
     * /projects/{id}/snippets/{snippet_id}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param snippetId the snippet id
     * @param noteId the note id
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteSnippetsNotesAwardEmoji(
            final String id, final long snippetId, final long noteId, final long awardId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_SNIPPETS_NOTES_AWARD_EMOJI, id, snippetId, noteId, awardId));
    }
}
