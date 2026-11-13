package io.github.piotr_janczukowicz.gitlab.api.ldap;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** The GitLab operations of ldap. */
public final class GitLabLDAPApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/ldap/groups");
    private static final PathTemplate LIST_BY_PROVIDER = PathTemplate.of("/ldap/{provider}/groups");
    private static final JsonType<List<GitLabLdapGroup>> LDAP_GROUP_LIST_TYPE = JsonTypes.listOf(GitLabLdapGroup.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabLDAPApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /ldap/groups}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabLdapGroup> list() throws IOException {
        return list(GitLabLDAPListFilter.empty());
    }

    /**
     * List ({@code GET /ldap/groups}).
     *
     * @param filter the optional query parameters
     * @return the items
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabLdapGroup> list(final GitLabLDAPListFilter filter) throws IOException {
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST).withQuery(queryParameters), LDAP_GROUP_LIST_TYPE);
    }

    /**
     * List by provider ({@code GET /ldap/{provider}/groups}).
     *
     * @param provider the provider
     * @return the items
     * @throws IllegalArgumentException if {@code provider} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabLdapGroup> listByProvider(final String provider) throws IOException {
        return listByProvider(provider, GitLabLDAPListByProviderFilter.empty());
    }

    /**
     * List by provider ({@code GET /ldap/{provider}/groups}).
     *
     * @param provider the provider
     * @param filter the optional query parameters
     * @return the items
     * @throws IllegalArgumentException if {@code provider} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabLdapGroup> listByProvider(final String provider, final GitLabLDAPListByProviderFilter filter)
            throws IOException {
        requireNotBlank(provider, "provider");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST_BY_PROVIDER, provider).withQuery(queryParameters), LDAP_GROUP_LIST_TYPE);
    }
}
