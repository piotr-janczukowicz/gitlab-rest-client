package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab saml group link.
 *
 * @param name the name
 * @param accessLevel the access level
 * @param memberRoleId the member role id
 * @param provider the provider
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSamlGroupLink")
public record GitLabSamlGroupLink(
        @Nullable String name,
        @Nullable Integer accessLevel,
        @Nullable Long memberRoleId,
        @Nullable String provider) {}
