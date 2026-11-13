package io.github.piotr_janczukowicz.gitlab.api.organizations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab organization user.
 *
 * @param id the id
 * @param username the username
 * @param bot the bot
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrganizationsOrganizationUser")
public record GitLabOrganizationUser(
        @Nullable Long id,
        @Nullable String username,
        @Nullable Boolean bot,
        @Nullable String accessLevel) {}
