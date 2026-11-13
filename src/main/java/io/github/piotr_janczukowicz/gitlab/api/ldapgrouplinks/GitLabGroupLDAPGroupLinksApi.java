package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLdapGroupLink;
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

/** The GitLab operations of group ldapgroup links. */
public final class GitLabGroupLDAPGroupLinksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PROVIDER = "provider";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/ldap_group_links");
    private static final PathTemplate DELETE_BY_CN = PathTemplate.of("/groups/{id}/ldap_group_links/{cn}");
    private static final PathTemplate DELETE_BY_PROVIDER_AND_CN =
            PathTemplate.of("/groups/{id}/ldap_group_links/{provider}/{cn}");
    private static final JsonType<List<GitLabLdapGroupLink>> LDAP_GROUP_LINK_LIST_TYPE =
            JsonTypes.listOf(GitLabLdapGroupLink.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupLDAPGroupLinksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/ldap_group_links}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabLdapGroupLink> list(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdLdapGroupLinks");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id), LDAP_GROUP_LINK_LIST_TYPE);
    }

    /**
     * Create ({@code POST /groups/{id}/ldap_group_links}).
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
    public GitLabLdapGroupLink create(final String id, final GitLabGroupLDAPGroupLinksCreatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdLdapGroupLinks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabLdapGroupLink.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/ldap_group_links}).
     *
     * @param id the id
     * @param provider the provider
     * @throws IllegalArgumentException if {@code id} or {@code provider} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final String provider) throws IOException {
        delete(id, provider, GitLabGroupLDAPGroupLinksDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /groups/{id}/ldap_group_links}).
     *
     * @param id the id
     * @param provider the provider
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code provider} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final String provider, final GitLabGroupLDAPGroupLinksDeleteFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdLdapGroupLinks");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(provider, PARAM_PROVIDER);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_PROVIDER, provider)
                .build();
        caller.send(delete(LIST, id).withQuery(queryParameters));
    }

    /**
     * Delete by cn ({@code DELETE /groups/{id}/ldap_group_links/{cn}}).
     *
     * @param id the id
     * @param cn the cn
     * @throws IllegalArgumentException if {@code id} or {@code cn} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteByCn(final String id, final String cn) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdLdapGroupLinksCn");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(cn, "cn");
        caller.send(delete(DELETE_BY_CN, id, cn));
    }

    /**
     * Delete by provider and cn ({@code DELETE /groups/{id}/ldap_group_links/{provider}/{cn}}).
     *
     * @param id the id
     * @param provider the provider
     * @param cn the cn
     * @throws IllegalArgumentException if {@code id}, {@code provider} or {@code cn} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteByProviderAndCn(final String id, final String provider, final String cn) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdLdapGroupLinksProviderCn");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(provider, PARAM_PROVIDER);
        requireNotBlank(cn, "cn");
        caller.send(delete(DELETE_BY_PROVIDER_AND_CN, id, provider, cn));
    }
}
