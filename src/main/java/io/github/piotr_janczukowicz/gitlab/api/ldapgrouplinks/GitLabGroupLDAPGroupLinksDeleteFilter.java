package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4GroupsIdLdapGroupLinks}, without paging.
 *
 * @param cn the cn
 * @param filter the filter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4GroupsIdLdapGroupLinks/parameters")
public record GitLabGroupLDAPGroupLinksDeleteFilter(
        @Nullable String cn, @Nullable String filter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupLDAPGroupLinksDeleteFilter empty() {
        return GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("cn", cn)
                .text("filter", filter)
                .build();
    }
}
