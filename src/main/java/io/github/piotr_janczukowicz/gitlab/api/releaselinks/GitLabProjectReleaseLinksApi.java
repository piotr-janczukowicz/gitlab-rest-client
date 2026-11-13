package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

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

/** The GitLab operations of project release links. */
public final class GitLabProjectReleaseLinksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_TAGNAME = "tagName";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/releases/{tag_name}/assets/links");
    private static final PathTemplate GET =
            PathTemplate.of("/projects/{id}/releases/{tag_name}/assets/links/{link_id}");
    private static final JsonType<List<GitLabReleaseLink>> RELEASE_LINK_LIST_TYPE =
            JsonTypes.listOf(GitLabReleaseLink.class);
    private static final GitLabListSpec<GitLabReleaseLink> RELEASE_LINK_SPEC =
            GitLabListSpec.offset(RELEASE_LINK_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectReleaseLinksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/releases/{tag_name}/assets/links}).
     *
     * @param id the id
     * @param tagName the tag name
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabReleaseLink> list(final String id, final String tagName) throws IOException {
        return list(id, tagName, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/releases/{tag_name}/assets/links}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabReleaseLink> list(final String id, final String tagName, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, RELEASE_LINK_SPEC, id, tagName);
    }

    /**
     * Create ({@code POST /projects/{id}/releases/{tag_name}/assets/links}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabReleaseLink create(
            final String id, final String tagName, final GitLabProjectReleaseLinksCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id, tagName), payload), GitLabReleaseLink.class);
    }

    /**
     * Get ({@code GET /projects/{id}/releases/{tag_name}/assets/links/{link_id}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param linkId the link id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabReleaseLink> get(final String id, final String tagName, final long linkId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        return caller.fetchOrEmpty(get(GET, id, tagName, linkId), GitLabReleaseLink.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/releases/{tag_name}/assets/links/{link_id}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param linkId the link id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabReleaseLink update(
            final String id,
            final String tagName,
            final long linkId,
            final GitLabProjectReleaseLinksUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, tagName, linkId), payload), GitLabReleaseLink.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/releases/{tag_name}/assets/links/{link_id}}).
     *
     * @param id the id
     * @param tagName the tag name
     * @param linkId the link id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabReleaseLink> delete(final String id, final String tagName, final long linkId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, PARAM_TAGNAME);
        return caller.fetchOptional(delete(GET, id, tagName, linkId), GitLabReleaseLink.class);
    }
}
