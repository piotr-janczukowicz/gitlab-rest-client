package io.github.piotr_janczukowicz.gitlab.api.ldap;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4LdapGroups}, without paging.
 *
 * @param search the search
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4LdapGroups/parameters")
public record GitLabLDAPListFilter(@Nullable String search) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabLDAPListFilter empty() {
        return GitLabLDAPListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("search", search).build();
    }
}
