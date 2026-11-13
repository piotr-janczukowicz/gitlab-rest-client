package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

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

/** The GitLab operations of project remote mirrors. */
public final class GitLabProjectRemoteMirrorsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_MIRRORID = "mirrorId";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/remote_mirrors");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/remote_mirrors/{mirror_id}");
    private static final PathTemplate SYNC = PathTemplate.of("/projects/{id}/remote_mirrors/{mirror_id}/sync");
    private static final PathTemplate CALL_PUBLIC_KEY =
            PathTemplate.of("/projects/{id}/remote_mirrors/{mirror_id}/public_key");
    private static final JsonType<List<GitLabRemoteMirror>> REMOTE_MIRROR_LIST_TYPE =
            JsonTypes.listOf(GitLabRemoteMirror.class);
    private static final GitLabListSpec<GitLabRemoteMirror> REMOTE_MIRROR_SPEC =
            GitLabListSpec.offset(REMOTE_MIRROR_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectRemoteMirrorsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/remote_mirrors}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabRemoteMirror> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/remote_mirrors}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabRemoteMirror> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, REMOTE_MIRROR_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/remote_mirrors}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRemoteMirror create(final String id, final GitLabProjectRemoteMirrorsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabRemoteMirror.class);
    }

    /**
     * Get ({@code GET /projects/{id}/remote_mirrors/{mirror_id}}).
     *
     * @param id the id
     * @param mirrorId the mirror id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code mirrorId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabRemoteMirror> get(final String id, final String mirrorId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(mirrorId, PARAM_MIRRORID);
        return caller.fetchOrEmpty(get(GET, id, mirrorId), GitLabRemoteMirror.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/remote_mirrors/{mirror_id}}).
     *
     * @param id the id
     * @param mirrorId the mirror id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code mirrorId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRemoteMirror update(
            final String id, final String mirrorId, final GitLabProjectRemoteMirrorsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(mirrorId, PARAM_MIRRORID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, mirrorId), payload), GitLabRemoteMirror.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/remote_mirrors/{mirror_id}}).
     *
     * @param id the id
     * @param mirrorId the mirror id
     * @throws IllegalArgumentException if {@code id} or {@code mirrorId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String mirrorId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(mirrorId, PARAM_MIRRORID);
        caller.send(delete(GET, id, mirrorId));
    }

    /**
     * Sync ({@code POST /projects/{id}/remote_mirrors/{mirror_id}/sync}).
     *
     * @param id the id
     * @param mirrorId the mirror id
     * @throws IllegalArgumentException if {@code id} or {@code mirrorId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void sync(final String id, final String mirrorId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(mirrorId, PARAM_MIRRORID);
        caller.send(post(SYNC, id, mirrorId));
    }

    /**
     * Call public key ({@code GET /projects/{id}/remote_mirrors/{mirror_id}/public_key}).
     *
     * @param id the id
     * @param mirrorId the mirror id
     * @throws IllegalArgumentException if {@code id} or {@code mirrorId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPublicKey(final String id, final String mirrorId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(mirrorId, PARAM_MIRRORID);
        caller.send(get(CALL_PUBLIC_KEY, id, mirrorId));
    }
}
