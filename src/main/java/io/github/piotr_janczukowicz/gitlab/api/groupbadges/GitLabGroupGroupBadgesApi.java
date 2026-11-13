package io.github.piotr_janczukowicz.gitlab.api.groupbadges;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBadge;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicBadgeDetails;
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

/** The GitLab operations of group group badges. */
public final class GitLabGroupGroupBadgesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/badges");
    private static final PathTemplate GET_RENDER = PathTemplate.of("/groups/{id}/badges/render");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/badges/{badge_id}");
    private static final JsonType<List<GitLabBadge>> BADGE_LIST_TYPE = JsonTypes.listOf(GitLabBadge.class);
    private static final GitLabListSpec<GitLabBadge> BADGE_SPEC = GitLabListSpec.offset(BADGE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupBadgesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/badges}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBadge> list(final String id) throws IOException {
        return list(id, GitLabGroupGroupBadgesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/badges}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBadge> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabGroupGroupBadgesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/badges}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBadge> list(final String id, final GitLabGroupGroupBadgesListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/badges}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBadge> list(
            final String id, final GitLabGroupGroupBadgesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, BADGE_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/badges}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBadge create(final String id, final GitLabGroupGroupBadgesCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabBadge.class);
    }

    /**
     * Get render ({@code GET /groups/{id}/badges/render}).
     *
     * @param id the id
     * @param linkUrl the link url
     * @param imageUrl the image url
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code linkUrl} or {@code imageUrl} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicBadgeDetails getRender(final String id, final String linkUrl, final String imageUrl)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(linkUrl, "linkUrl");
        requireNotBlank(imageUrl, "imageUrl");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text("link_url", linkUrl)
                .text("image_url", imageUrl)
                .build();
        return caller.fetch(get(GET_RENDER, id).withQuery(queryParameters), GitLabBasicBadgeDetails.class);
    }

    /**
     * Get ({@code GET /groups/{id}/badges/{badge_id}}).
     *
     * @param id the id
     * @param badgeId the badge id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBadge> get(final String id, final long badgeId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, badgeId), GitLabBadge.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/badges/{badge_id}}).
     *
     * @param id the id
     * @param badgeId the badge id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBadge update(final String id, final long badgeId, final GitLabGroupGroupBadgesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, badgeId), payload), GitLabBadge.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/badges/{badge_id}}).
     *
     * @param id the id
     * @param badgeId the badge id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long badgeId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, badgeId));
    }
}
