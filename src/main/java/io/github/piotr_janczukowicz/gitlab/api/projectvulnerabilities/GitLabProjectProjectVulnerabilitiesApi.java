package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabVulnerability;
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

/** The GitLab operations of project project vulnerabilities. */
public final class GitLabProjectProjectVulnerabilitiesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/vulnerabilities");
    private static final PathTemplate LIST_NOTES =
            PathTemplate.of("/projects/{id}/vulnerabilities/{noteable_id}/notes");
    private static final PathTemplate GET_NOTE =
            PathTemplate.of("/projects/{id}/vulnerabilities/{noteable_id}/notes/{note_id}");
    private static final JsonType<List<GitLabVulnerability>> VULNERABILITY_LIST_TYPE =
            JsonTypes.listOf(GitLabVulnerability.class);
    private static final JsonType<List<GitLabNote>> NOTE_LIST_TYPE = JsonTypes.listOf(GitLabNote.class);
    private static final GitLabListSpec<GitLabVulnerability> VULNERABILITY_SPEC =
            GitLabListSpec.offset(VULNERABILITY_LIST_TYPE);
    private static final GitLabListSpec<GitLabNote> NOTE_SPEC = GitLabListSpec.offset(NOTE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectVulnerabilitiesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/vulnerabilities}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabVulnerability> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/vulnerabilities}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabVulnerability> list(final String id, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdVulnerabilities");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, VULNERABILITY_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/vulnerabilities}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerability create(final String id, final GitLabProjectProjectVulnerabilitiesCreatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdVulnerabilities");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabVulnerability.class);
    }

    /**
     * List notes ({@code GET /projects/{id}/vulnerabilities/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabNote> listNotes(final String id, final long noteableId) throws IOException {
        return listNotes(
                id, noteableId, GitLabProjectProjectVulnerabilitiesListNotesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List notes ({@code GET /projects/{id}/vulnerabilities/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabNote> listNotes(final String id, final long noteableId, final GitLabPageRequest request)
            throws IOException {
        return listNotes(id, noteableId, GitLabProjectProjectVulnerabilitiesListNotesFilter.empty(), request);
    }

    /**
     * List notes ({@code GET /projects/{id}/vulnerabilities/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabNote> listNotes(
            final String id, final long noteableId, final GitLabProjectProjectVulnerabilitiesListNotesFilter filter)
            throws IOException {
        return listNotes(id, noteableId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List notes ({@code GET /projects/{id}/vulnerabilities/{noteable_id}/notes}).
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
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabNote> listNotes(
            final String id,
            final long noteableId,
            final GitLabProjectProjectVulnerabilitiesListNotesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdVulnerabilitiesNoteableIdNotes");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_NOTES, queryParameters, request, NOTE_SPEC, id, noteableId);
    }

    /**
     * Create note ({@code POST /projects/{id}/vulnerabilities/{noteable_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabNote createNote(
            final String id, final long noteableId, final GitLabProjectProjectVulnerabilitiesCreateNotePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdVulnerabilitiesNoteableIdNotes");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_NOTES, id, noteableId), payload), GitLabNote.class);
    }

    /**
     * Get note ({@code GET /projects/{id}/vulnerabilities/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabNote> getNote(final String id, final long noteableId, final long noteId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdVulnerabilitiesNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_NOTE, id, noteableId, noteId), GitLabNote.class);
    }

    /**
     * Update note ({@code PUT /projects/{id}/vulnerabilities/{noteable_id}/notes/{note_id}}).
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
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabNote updateNote(
            final String id,
            final long noteableId,
            final long noteId,
            final GitLabProjectProjectVulnerabilitiesUpdateNotePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4ProjectsIdVulnerabilitiesNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_NOTE, id, noteableId, noteId), payload), GitLabNote.class);
    }

    /**
     * Delete note ({@code DELETE /projects/{id}/vulnerabilities/{noteable_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabNote> deleteNote(final String id, final long noteableId, final long noteId)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4ProjectsIdVulnerabilitiesNoteableIdNotesNoteId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET_NOTE, id, noteableId, noteId), GitLabNote.class);
    }
}
