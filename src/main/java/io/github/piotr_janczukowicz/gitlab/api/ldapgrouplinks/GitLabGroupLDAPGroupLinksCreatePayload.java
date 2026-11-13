package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdLdapGroupLinks}.
 *
 * @param cn the cn
 * @param filter the filter
 * @param groupAccess the group access
 * @param provider the provider
 * @param memberRoleId the member role id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdLdapGroupLinks/requestBody")
public record GitLabGroupLDAPGroupLinksCreatePayload(
        @Nullable String cn,
        @Nullable String filter,
        GitLabGroupLDAPGroupLinksCreateGroupAccess groupAccess,
        @Nullable String provider,
        @Nullable Long memberRoleId) {
    public GitLabGroupLDAPGroupLinksCreatePayload {
        requireNonNull(groupAccess, "groupAccess");
    }
}
