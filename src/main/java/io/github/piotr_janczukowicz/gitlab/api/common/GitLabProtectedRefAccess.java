package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab protected ref access.
 *
 * @param id the id
 * @param accessLevel the access level
 * @param accessLevelDescription the access level description
 * @param deployKeyId the deploy key id
 * @param userId the user id
 * @param groupId the group id
 * @param memberRoleId the member role id
 * @param memberRoleName the member role name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProtectedRefAccess")
public record GitLabProtectedRefAccess(
        @Nullable Long id,
        @Nullable Integer accessLevel,
        @Nullable String accessLevelDescription,
        @Nullable Long deployKeyId,
        @Nullable Long userId,
        @Nullable Long groupId,
        @Nullable Long memberRoleId,
        @Nullable String memberRoleName) {}
