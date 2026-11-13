package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of project draft notes. */
public final class GitLabProjectDraftNotesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/draft_notes");
    private static final PathTemplate GET =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/draft_notes/{draft_note_id}");
    private static final PathTemplate PUBLISH =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/draft_notes/{draft_note_id}/publish");
    private static final PathTemplate BULK_PUBLISH =
            PathTemplate.of("/projects/{id}/merge_requests/{merge_request_iid}/draft_notes/bulk_publish");
    private static final JsonType<List<GitLabDraftNote>> DRAFT_NOTE_LIST_TYPE = JsonTypes.listOf(GitLabDraftNote.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDraftNotesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/draft_notes}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabDraftNote> list(final String id, final long mergeRequestIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id, mergeRequestIid), DRAFT_NOTE_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/draft_notes}).
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
    public GitLabDraftNote create(
            final String id, final long mergeRequestIid, final GitLabProjectDraftNotesCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id, mergeRequestIid), payload), GitLabDraftNote.class);
    }

    /**
     * Get ({@code GET /projects/{id}/merge_requests/{merge_request_iid}/draft_notes/{draft_note_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param draftNoteId the draft note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDraftNote> get(final String id, final long mergeRequestIid, final long draftNoteId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, mergeRequestIid, draftNoteId), GitLabDraftNote.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/merge_requests/{merge_request_iid}/draft_notes/{draft_note_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param draftNoteId the draft note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDraftNote update(
            final String id,
            final long mergeRequestIid,
            final long draftNoteId,
            final GitLabProjectDraftNotesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, mergeRequestIid, draftNoteId), payload), GitLabDraftNote.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/merge_requests/{merge_request_iid}/draft_notes/{draft_note_id}}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param draftNoteId the draft note id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long mergeRequestIid, final long draftNoteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, mergeRequestIid, draftNoteId));
    }

    /**
     * Publish ({@code PUT /projects/{id}/merge_requests/{merge_request_iid}/draft_notes/{draft_note_id}/publish}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param draftNoteId the draft note id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void publish(final String id, final long mergeRequestIid, final long draftNoteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(put(PUBLISH, id, mergeRequestIid, draftNoteId));
    }

    /**
     * Bulk publish ({@code POST /projects/{id}/merge_requests/{merge_request_iid}/draft_notes/bulk_publish}).
     *
     * @param id the id
     * @param mergeRequestIid the merge request iid
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void bulkPublish(
            final String id, final long mergeRequestIid, final GitLabProjectDraftNotesBulkPublishPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(BULK_PUBLISH, id, mergeRequestIid), payload));
    }
}
