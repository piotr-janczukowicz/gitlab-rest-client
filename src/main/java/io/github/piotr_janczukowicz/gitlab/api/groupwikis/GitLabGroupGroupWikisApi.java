package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiAttachment;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiPage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiPageBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of group group wikis. */
public final class GitLabGroupGroupWikisApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_SLUG = "slug";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/wikis");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/wikis/{slug}");
    private static final PathTemplate CREATE_ATTACHMENT = PathTemplate.of("/groups/{id}/wikis/attachments");
    private static final JsonType<List<GitLabWikiPageBasic>> WIKI_PAGE_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabWikiPageBasic.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupWikisApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/wikis}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabWikiPageBasic> list(final String id) throws IOException {
        return list(id, GitLabGroupGroupWikisListFilter.empty());
    }

    /**
     * List ({@code GET /groups/{id}/wikis}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabWikiPageBasic> list(final String id, final GitLabGroupGroupWikisListFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdWikis");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST, id).withQuery(queryParameters), WIKI_PAGE_BASIC_LIST_TYPE);
    }

    /**
     * Create ({@code POST /groups/{id}/wikis}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabWikiPage create(final String id, final GitLabGroupGroupWikisCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdWikis");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabWikiPage.class);
    }

    /**
     * Get ({@code GET /groups/{id}/wikis/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code slug} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabWikiPage> get(final String id, final String slug) throws IOException {
        return get(id, slug, GitLabGroupGroupWikisGetFilter.empty());
    }

    /**
     * Get ({@code GET /groups/{id}/wikis/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code slug} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabWikiPage> get(final String id, final String slug, final GitLabGroupGroupWikisGetFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdWikisSlug");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(slug, PARAM_SLUG);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, slug).withQuery(queryParameters), GitLabWikiPage.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/wikis/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code slug} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabWikiPage update(final String id, final String slug, final GitLabGroupGroupWikisUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdWikisSlug");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(slug, PARAM_SLUG);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, slug), payload), GitLabWikiPage.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/wikis/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @throws IllegalArgumentException if {@code id} or {@code slug} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final String slug) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdWikisSlug");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(slug, PARAM_SLUG);
        caller.send(delete(GET, id, slug));
    }

    /**
     * Create attachment ({@code POST /groups/{id}/wikis/attachments}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabWikiAttachment createAttachment(final String id, final MultipartFormData form) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdWikisAttachments");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(CREATE_ATTACHMENT, id), form), GitLabWikiAttachment.class);
    }
}
