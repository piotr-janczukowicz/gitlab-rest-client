package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
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

/** The GitLab operations of group notes. */
public final class GitLabGroupNotesApi extends GitLabResourceApi {
    private static final String PARAM_DISCUSSIONID = "discussionId";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_EPICS_NOTES = PathTemplate.of("/groups/{id}/epics/{noteable_id}/notes");
    private static final PathTemplate GET_EPICS_NOTES =
            PathTemplate.of("/groups/{id}/epics/{noteable_id}/notes/{note_id}");
    private static final PathTemplate LIST_WIKI_PAGES_NOTES =
            PathTemplate.of("/groups/{id}/wiki_pages/{noteable_id}/notes");
    private static final PathTemplate GET_WIKI_PAGES_NOTE =
            PathTemplate.of("/groups/{id}/wiki_pages/{noteable_id}/notes/{note_id}");
    private static final PathTemplate LIST_DISCUSSIONS_NOTES =
            PathTemplate.of("/groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes");
    private static final PathTemplate GET_DISCUSSIONS_NOTES =
            PathTemplate.of("/groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes/{note_id}");
    private static final PathTemplate LIST_AWARD_EMOJI =
            PathTemplate.of("/groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji");
    private static final PathTemplate GET_AWARD_EMOJI =
            PathTemplate.of("/groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji/{award_id}");
    private static final JsonType<List<GitLabNote>> NOTE_LIST_TYPE = JsonTypes.listOf(GitLabNote.class);
    private static final JsonType<List<GitLabAwardEmoji>> AWARD_EMOJI_LIST_TYPE =
            JsonTypes.listOf(GitLabAwardEmoji.class);
    private static final GitLabListSpec<GitLabNote> NOTE_SPEC = GitLabListSpec.offset(NOTE_LIST_TYPE);
    private static final GitLabListSpec<GitLabAwardEmoji> AWARD_EMOJI_SPEC =
            GitLabListSpec.offset(AWARD_EMOJI_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupNotesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List epics notes ({@code GET /groups/{id}/epics/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listEpicsNotes(final String id, final long noteableId) throws IOException {
        return listEpicsNotes(id, noteableId, GitLabGroupNotesListEpicsNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List epics notes ({@code GET /groups/{id}/epics/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listEpicsNotes(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        return listEpicsNotes(id, noteableId, GitLabGroupNotesListEpicsNotesFilter.empty(), request);
    }

    /**
     * List epics notes ({@code GET /groups/{id}/epics/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listEpicsNotes(
            final String id, final long noteableId, final GitLabGroupNotesListEpicsNotesFilter filter)
            throws IOException {
        return listEpicsNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List epics notes ({@code GET /groups/{id}/epics/{noteable_id}/notes}).
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
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listEpicsNotes(
            final String id,
            final long noteableId,
            final GitLabGroupNotesListEpicsNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsNoteableIdNotes");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_EPICS_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create epics notes ({@code POST /groups/{id}/epics/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabNote createEpicsNotes(
            final String id, final long noteableId, final GitLabGroupNotesCreateEpicsNotesPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdEpicsNoteableIdNotes");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_EPICS_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get epics notes ({@code GET /groups/{id}/epics/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabNote> getEpicsNotes(final String id, final long noteableId, final long noteId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_EPICS_NOTES, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update epics notes ({@code PUT /groups/{id}/epics/{noteable_id}/notes/{note_id}}).
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
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabNote updateEpicsNotes(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabGroupNotesUpdateEpicsNotesPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdEpicsNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_EPICS_NOTES, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete epics notes ({@code DELETE /groups/{id}/epics/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabNote> deleteEpicsNotes(final String id, final long noteableId, final long noteId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdEpicsNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET_EPICS_NOTES, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * List wiki pages notes ({@code GET /groups/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listWikiPagesNotes(final String id, final long noteableId) throws IOException {
        return listWikiPagesNotes(
                id, noteableId, GitLabGroupNotesListWikiPagesNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List wiki pages notes ({@code GET /groups/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listWikiPagesNotes(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        return listWikiPagesNotes(id, noteableId, GitLabGroupNotesListWikiPagesNotesFilter.empty(), request);
    }

    /**
     * List wiki pages notes ({@code GET /groups/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listWikiPagesNotes(
            final String id, final long noteableId, final GitLabGroupNotesListWikiPagesNotesFilter filter)
            throws IOException {
        return listWikiPagesNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List wiki pages notes ({@code GET /groups/{id}/wiki_pages/{noteable_id}/notes}).
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
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabNote> listWikiPagesNotes(
            final String id,
            final long noteableId,
            final GitLabGroupNotesListWikiPagesNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdWikiPagesNoteableIdNotes");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_WIKI_PAGES_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create wiki pages note ({@code POST /groups/{id}/wiki_pages/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabNote createWikiPagesNote(
            final String id, final long noteableId, final GitLabGroupNotesCreateWikiPagesNotePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdWikiPagesNoteableIdNotes");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_WIKI_PAGES_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get wiki pages note ({@code GET /groups/{id}/wiki_pages/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabNote> getWikiPagesNote(final String id, final long noteableId, final long noteId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdWikiPagesNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_WIKI_PAGES_NOTE, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update wiki pages note ({@code PUT /groups/{id}/wiki_pages/{noteable_id}/notes/{note_id}}).
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
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabNote updateWikiPagesNote(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabGroupNotesUpdateWikiPagesNotePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdWikiPagesNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_WIKI_PAGES_NOTE, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete wiki pages note ({@code DELETE /groups/{id}/wiki_pages/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabNote> deleteWikiPagesNote(final String id, final long noteableId, final long noteId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdWikiPagesNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET_WIKI_PAGES_NOTE, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * List discussions notes ({@code GET /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabNote> listDiscussionsNotes(final String id, final long noteableId, final String discussionId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetch(get(LIST_DISCUSSIONS_NOTES, id, noteableId, discussionId), NOTE_LIST_TYPE);
    }

    /**
     * Create discussions notes ({@code POST /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes}).
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
    public GitLabNote createDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabGroupNotesCreateDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_DISCUSSIONS_NOTES, id, noteableId, discussionId), payload), GitLabNote.class);
    }

    /**
     * Get discussions notes ({@code GET /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
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
    public Optional<GitLabNote> getDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(get(GET_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * Update discussions notes ({@code PUT
     * /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
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
    public GitLabNote updateDiscussionsNotes(
            final String id,
            final long noteableId,
            final String discussionId,
            final long noteId,
            final GitLabGroupNotesUpdateDiscussionsNotesPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), payload),
                GitLabNote.class);
    }

    /**
     * Delete discussions notes ({@code DELETE
     * /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
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
    public Optional<GitLabNote> deleteDiscussionsNotes(
            final String id, final long noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOptional(
                delete(GET_DISCUSSIONS_NOTES, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * List award emoji ({@code GET /groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param noteId the note id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAwardEmoji> listAwardEmoji(final String id, final long epicIid, final long noteId)
            throws IOException {
        return listAwardEmoji(id, epicIid, noteId, GitLabPageRequest.byPage());
    }

    /**
     * List award emoji ({@code GET /groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param noteId the note id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAwardEmoji> listAwardEmoji(
            final String id, final long epicIid, final long noteId, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIidNotesNoteIdAwardEmoji");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, epicIid, noteId);
    }

    /**
     * Create award emoji ({@code POST /groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAwardEmoji createAwardEmoji(
            final String id,
            final long epicIid,
            final long noteId,
            final GitLabGroupNotesCreateAwardEmojiPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdEpicsEpicIidNotesNoteIdAwardEmoji");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_AWARD_EMOJI, id, epicIid, noteId), payload), GitLabAwardEmoji.class);
    }

    /**
     * Get award emoji ({@code GET /groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param noteId the note id
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabAwardEmoji> getAwardEmoji(
            final String id, final long epicIid, final long noteId, final long awardId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIidNotesNoteIdAwardEmojiAwardId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_AWARD_EMOJI, id, epicIid, noteId, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete award emoji ({@code DELETE /groups/{id}/epics/{epic_iid}/notes/{note_id}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param noteId the note id
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteAwardEmoji(final String id, final long epicIid, final long noteId, final long awardId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdEpicsEpicIidNotesNoteIdAwardEmojiAwardId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_AWARD_EMOJI, id, epicIid, noteId, awardId));
    }
}
