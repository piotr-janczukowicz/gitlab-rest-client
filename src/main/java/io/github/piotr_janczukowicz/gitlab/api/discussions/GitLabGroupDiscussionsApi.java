package io.github.piotr_janczukowicz.gitlab.api.discussions;

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

/** The GitLab operations of group discussions. */
public final class GitLabGroupDiscussionsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epics/{noteable_id}/discussions");
    private static final PathTemplate GET =
            PathTemplate.of("/groups/{id}/epics/{noteable_id}/discussions/{discussion_id}");
    private static final JsonType<List<GitLabDiscussion>> DISCUSSION_LIST_TYPE =
            JsonTypes.listOf(GitLabDiscussion.class);
    private static final GitLabListSpec<GitLabDiscussion> DISCUSSION_SPEC = GitLabListSpec.offset(DISCUSSION_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupDiscussionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/epics/{noteable_id}/discussions}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiscussion> list(final String id, final long noteableId) throws IOException {
        return list(id, noteableId, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/epics/{noteable_id}/discussions}).
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
    public GitLabPage<GitLabDiscussion> list(final String id, final long noteableId, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, DISCUSSION_SPEC, id, noteableId);
    }

    /**
     * Create ({@code POST /groups/{id}/epics/{noteable_id}/discussions}).
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
    public GitLabDiscussion create(
            final String id, final long noteableId, final GitLabGroupDiscussionsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id, noteableId), payload), GitLabDiscussion.class);
    }

    /**
     * Get ({@code GET /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}}).
     *
     * @param id the id
     * @param noteableId the noteable id
     * @param discussionId the discussion id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code discussionId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDiscussion> get(final String id, final long noteableId, final String discussionId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, "discussionId");
        return caller.fetchOrEmpty(get(GET, id, noteableId, discussionId), GitLabDiscussion.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/epics/{noteable_id}/discussions/{discussion_id}}).
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
    public GitLabDiscussion update(
            final String id,
            final long noteableId,
            final String discussionId,
            final GitLabGroupDiscussionsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(discussionId, "discussionId");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, noteableId, discussionId), payload), GitLabDiscussion.class);
    }
}
