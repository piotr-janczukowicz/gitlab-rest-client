package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

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

/** The GitLab operations of broadcast messages. */
public final class GitLabBroadcastMessagesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/broadcast_messages");
    private static final PathTemplate GET = PathTemplate.of("/broadcast_messages/{id}");
    private static final JsonType<List<GitLabSystemBroadcastMessage>> SYSTEM_BROADCAST_MESSAGE_LIST_TYPE =
            JsonTypes.listOf(GitLabSystemBroadcastMessage.class);
    private static final GitLabListSpec<GitLabSystemBroadcastMessage> SYSTEM_BROADCAST_MESSAGE_SPEC =
            GitLabListSpec.offset(SYSTEM_BROADCAST_MESSAGE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabBroadcastMessagesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /broadcast_messages}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSystemBroadcastMessage> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /broadcast_messages}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabSystemBroadcastMessage> list(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, SYSTEM_BROADCAST_MESSAGE_SPEC);
    }

    /**
     * Create ({@code POST /broadcast_messages}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSystemBroadcastMessage create(final GitLabBroadcastMessagesCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabSystemBroadcastMessage.class);
    }

    /**
     * Get ({@code GET /broadcast_messages/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSystemBroadcastMessage> get(final long id) throws IOException {
        return caller.fetchOrEmpty(get(GET, id), GitLabSystemBroadcastMessage.class);
    }

    /**
     * Update ({@code PUT /broadcast_messages/{id}}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSystemBroadcastMessage update(final long id, final GitLabBroadcastMessagesUpdatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id), payload), GitLabSystemBroadcastMessage.class);
    }

    /**
     * Delete ({@code DELETE /broadcast_messages/{id}}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabSystemBroadcastMessage> delete(final long id) throws IOException {
        return caller.fetchOptional(delete(GET, id), GitLabSystemBroadcastMessage.class);
    }
}
