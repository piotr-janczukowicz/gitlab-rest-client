package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ldap group link.
 *
 * @param cn the cn
 * @param groupAccess the group access
 * @param provider the provider
 * @param filter the filter
 * @param memberRoleId the member role id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesLdapGroupLink")
public record GitLabLdapGroupLink(
        @Nullable String cn,
        @Nullable Integer groupAccess,
        @Nullable String provider,
        @Nullable String filter,
        @Nullable Long memberRoleId) {}
