package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
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

/** The GitLab operations of project discussions. */
public final class GitLabProjectDiscussionsApi extends GitLabResourceApi {
    private static final String PARAM_DISCUSSIONID = "discussionId";
    private static final String PARAM_ID = "id";
    private static final String PARAM_NOTEABLEID = "noteableId";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_ISSUES_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/issues/{noteable_id}/discussions");
    private static final PathTemplate GET_ISSUES_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/issues/{noteable_id}/discussions/{discussion_id}");
    private static final PathTemplate LIST_SNIPPETS_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/snippets/{noteable_id}/discussions");
    private static final PathTemplate GET_SNIPPETS_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}");
    private static final PathTemplate LIST_REQUESTS_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/merge_requests/{noteable_id}/discussions");
    private static final PathTemplate GET_REQUESTS_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}");
    private static final PathTemplate LIST_REPOSITORY_COMMITS_DISCUSSIONS =
            PathTemplate.of("/projects/{id}/repository/commits/{noteable_id}/discussions");
    private static final PathTemplate GET_REPOSITORY_COMMITS_DISCUSSION =
            PathTemplate.of("/projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}");
    private static final PathTemplate LIST_REPOSITORY_COMMITS_DISCUSSIONS_NOTE =
            PathTemplate.of("/projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes");
    private static final PathTemplate GET_REPOSITORY_COMMITS_DISCUSSIONS_NOTE = PathTemplate.of(
            "/projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes/{note_id}");
    private static final JsonType<List<GitLabDiscussion>> DISCUSSION_LIST_TYPE =
            JsonTypes.listOf(GitLabDiscussion.class);
    private static final JsonType<List<GitLabNote>> NOTE_LIST_TYPE = JsonTypes.listOf(GitLabNote.class);
    private static final GitLabListSpec<GitLabDiscussion> DISCUSSION_SPEC = GitLabListSpec.offset(DISCUSSION_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDiscussionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List issues discussions ({@code GET /projects/{id}/issues/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiscussion> listIssuesDiscussions(final String id, final long noteableId)
            throws IOException {
        return listIssuesDiscussions(id, noteableId, GitLabPageRequest.byPage());
    }

    /**
     * List issues discussions ({@code GET /projects/{id}/issues/{noteable_id}/discussions}).
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
    public GitLabPage<GitLabDiscussion> listIssuesDiscussions(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_ISSUES_DISCUSSIONS, Map.of(), request, DISCUSSION_SPEC, id, noteableId);
    }

    /**
     * Create issues discussions ({@code POST /projects/{id}/issues/{noteable_id}/discussions}).
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
    public GitLabDiscussion createIssuesDiscussions(
            final String id,
            final long noteableId,
            final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_ISSUES_DISCUSSIONS, id, noteableId), payload), GitLabDiscussion.class);
    }

    /**
     * Get issues discussions ({@code GET /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDiscussion> getIssuesDiscussions(
            final String id, final long noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(get(GET_ISSUES_DISCUSSIONS, id, noteableId, discussionId), GitLabDiscussion.class);
    }

    /**
     * Update issues discussions ({@code PUT /projects/{id}/issues/{noteable_id}/discussions/{discussion_id}}).
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
    public GitLabDiscussion updateIssuesDiscussions(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_ISSUES_DISCUSSIONS, id, noteableId, discussionId), payload),
                GitLabDiscussion.class);
    }

    /**
     * List snippets discussions ({@code GET /projects/{id}/snippets/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiscussion> listSnippetsDiscussions(final String id, final long noteableId)
            throws IOException {
        return listSnippetsDiscussions(id, noteableId, GitLabPageRequest.byPage());
    }

    /**
     * List snippets discussions ({@code GET /projects/{id}/snippets/{noteable_id}/discussions}).
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
    public GitLabPage<GitLabDiscussion> listSnippetsDiscussions(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_SNIPPETS_DISCUSSIONS, Map.of(), request, DISCUSSION_SPEC, id, noteableId);
    }

    /**
     * Create snippets discussions ({@code POST /projects/{id}/snippets/{noteable_id}/discussions}).
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
    public GitLabDiscussion createSnippetsDiscussions(
            final String id,
            final long noteableId,
            final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_SNIPPETS_DISCUSSIONS, id, noteableId), payload), GitLabDiscussion.class);
    }

    /**
     * Get snippets discussions ({@code GET /projects/{id}/snippets/{noteable_id}/discussions/{discussion_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDiscussion> getSnippetsDiscussions(
            final String id, final long noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(get(GET_SNIPPETS_DISCUSSIONS, id, noteableId, discussionId), GitLabDiscussion.class);
    }

    /**
     * List requests discussions ({@code GET /projects/{id}/merge_requests/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiscussion> listRequestsDiscussions(final String id, final long noteableId)
            throws IOException {
        return listRequestsDiscussions(id, noteableId, GitLabPageRequest.byPage());
    }

    /**
     * List requests discussions ({@code GET /projects/{id}/merge_requests/{noteable_id}/discussions}).
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
    public GitLabPage<GitLabDiscussion> listRequestsDiscussions(
            final String id, final long noteableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REQUESTS_DISCUSSIONS, Map.of(), request, DISCUSSION_SPEC, id, noteableId);
    }

    /**
     * Create requests discussions ({@code POST /projects/{id}/merge_requests/{noteable_id}/discussions}).
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
    public GitLabDiscussion createRequestsDiscussions(
            final String id,
            final long noteableId,
            final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REQUESTS_DISCUSSIONS, id, noteableId), payload), GitLabDiscussion.class);
    }

    /**
     * Get requests discussions ({@code GET /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDiscussion> getRequestsDiscussions(
            final String id, final long noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(get(GET_REQUESTS_DISCUSSIONS, id, noteableId, discussionId), GitLabDiscussion.class);
    }

    /**
     * Update requests discussions ({@code PUT
     * /projects/{id}/merge_requests/{noteable_id}/discussions/{discussion_id}}).
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
    public GitLabDiscussion updateRequestsDiscussions(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_REQUESTS_DISCUSSIONS, id, noteableId, discussionId), payload),
                GitLabDiscussion.class);
    }

    /**
     * List repository commits discussions ({@code GET /projects/{id}/repository/commits/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code noteableId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiscussion> listRepositoryCommitsDiscussions(final String id, final String noteableId)
            throws IOException {
        return listRepositoryCommitsDiscussions(id, noteableId, GitLabPageRequest.byPage());
    }

    /**
     * List repository commits discussions ({@code GET /projects/{id}/repository/commits/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code noteableId} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiscussion> listRepositoryCommitsDiscussions(
            final String id, final String noteableId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REPOSITORY_COMMITS_DISCUSSIONS, Map.of(), request, DISCUSSION_SPEC, id, noteableId);
    }

    /**
     * Create repository commits discussion ({@code POST /projects/{id}/repository/commits/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code noteableId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDiscussion createRepositoryCommitsDiscussion(
            final String id, final String noteableId, final GitLabProjectCommitDiscussionCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REPOSITORY_COMMITS_DISCUSSIONS, id, noteableId), payload),
                GitLabDiscussion.class);
    }

    /**
     * Get repository commits discussion ({@code GET
     * /projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code noteableId} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDiscussion> getRepositoryCommitsDiscussion(
            final String id, final String noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(
                get(GET_REPOSITORY_COMMITS_DISCUSSION, id, noteableId, discussionId), GitLabDiscussion.class);
    }

    /**
     * List repository commits discussions notes ({@code GET
     * /projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the items
     * @throws IllegalArgumentException if {@code id}, {@code noteableId} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabNote> listRepositoryCommitsDiscussionsNotes(
            final String id, final String noteableId, final String discussionId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetch(
                get(LIST_REPOSITORY_COMMITS_DISCUSSIONS_NOTE, id, noteableId, discussionId), NOTE_LIST_TYPE);
    }

    /**
     * Create repository commits discussions note ({@code POST
     * /projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code noteableId} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote createRepositoryCommitsDiscussionsNote(
            final String id,
            final String noteableId,
            final String discussionId,
            final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REPOSITORY_COMMITS_DISCUSSIONS_NOTE, id, noteableId, discussionId), payload),
                GitLabNote.class);
    }

    /**
     * Get repository commits discussions note ({@code GET
     * /projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code noteableId} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> getRepositoryCommitsDiscussionsNote(
            final String id, final String noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOrEmpty(
                get(GET_REPOSITORY_COMMITS_DISCUSSIONS_NOTE, id, noteableId, discussionId, noteId), GitLabNote.class);
    }

    /**
     * Update repository commits discussions note ({@code PUT
     * /projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code noteableId} or {@code discussionId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNote updateRepositoryCommitsDiscussionsNote(
            final String id,
            final String noteableId,
            final String discussionId,
            final long noteId,
            final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(
                        put(GET_REPOSITORY_COMMITS_DISCUSSIONS_NOTE, id, noteableId, discussionId, noteId), payload),
                GitLabNote.class);
    }

    /**
     * Delete repository commits discussions note ({@code DELETE
     * /projects/{id}/repository/commits/{noteable_id}/discussions/{discussion_id}/notes/{note_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @param noteId the note id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id}, {@code noteableId} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNote> deleteRepositoryCommitsDiscussionsNote(
            final String id, final String noteableId, final String discussionId, final long noteId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(noteableId, PARAM_NOTEABLEID);
        requireNotBlank(discussionId, PARAM_DISCUSSIONID);
        return caller.fetchOptional(
                delete(GET_REPOSITORY_COMMITS_DISCUSSIONS_NOTE, id, noteableId, discussionId, noteId),
                GitLabNote.class);
    }
}
