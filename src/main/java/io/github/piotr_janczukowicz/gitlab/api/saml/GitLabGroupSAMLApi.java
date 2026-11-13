package io.github.piotr_janczukowicz.gitlab.api.saml;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSamlGroupLink;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of group saml. */
public final class GitLabGroupSAMLApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/saml_group_links");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/saml_group_links/{saml_group_name}");
    private static final PathTemplate GET_IDENTITIES = PathTemplate.of("/groups/{id}/saml/identities");
    private static final JsonType<List<GitLabSamlGroupLink>> SAML_GROUP_LINK_LIST_TYPE =
            JsonTypes.listOf(GitLabSamlGroupLink.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupSAMLApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/saml_group_links}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabSamlGroupLink> list(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdSamlGroupLinks");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id), SAML_GROUP_LINK_LIST_TYPE);
    }

    /**
     * Create ({@code POST /groups/{id}/saml_group_links}).
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
    public GitLabSamlGroupLink create(final String id, final GitLabGroupSAMLCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdSamlGroupLinks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabSamlGroupLink.class);
    }

    /**
     * Get ({@code GET /groups/{id}/saml_group_links/{saml_group_name}}).
     *
     * @param id the id
     * @param samlGroupName the saml group name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code samlGroupName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabSamlGroupLink> get(final String id, final String samlGroupName) throws IOException {
        return get(id, samlGroupName, GitLabGroupSAMLGetFilter.empty());
    }

    /**
     * Get ({@code GET /groups/{id}/saml_group_links/{saml_group_name}}).
     *
     * @param id the id
     * @param samlGroupName the saml group name
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code samlGroupName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabSamlGroupLink> get(
            final String id, final String samlGroupName, final GitLabGroupSAMLGetFilter filter) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdSamlGroupLinksSamlGroupName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(samlGroupName, "samlGroupName");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, samlGroupName).withQuery(queryParameters), GitLabSamlGroupLink.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/saml_group_links/{saml_group_name}}).
     *
     * @param id the id
     * @param samlGroupName the saml group name
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code samlGroupName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabSamlGroupLink> delete(final String id, final String samlGroupName) throws IOException {
        return delete(id, samlGroupName, GitLabGroupSAMLDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /groups/{id}/saml_group_links/{saml_group_name}}).
     *
     * @param id the id
     * @param samlGroupName the saml group name
     * @param filter the optional query parameters
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code samlGroupName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabSamlGroupLink> delete(
            final String id, final String samlGroupName, final GitLabGroupSAMLDeleteFilter filter) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdSamlGroupLinksSamlGroupName");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(samlGroupName, "samlGroupName");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOptional(
                delete(GET, id, samlGroupName).withQuery(queryParameters), GitLabSamlGroupLink.class);
    }

    /**
     * Get identities ({@code GET /groups/{id}/saml/identities}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabIdentityDetail getIdentities(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdSamlIdentities");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_IDENTITIES, id), GitLabIdentityDetail.class);
    }
}
