package io.github.piotr_janczukowicz.gitlab.api.ldap;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ldap group.
 *
 * @param cn the cn
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesLdapGroup")
public record GitLabLdapGroup(@Nullable String cn) {}
