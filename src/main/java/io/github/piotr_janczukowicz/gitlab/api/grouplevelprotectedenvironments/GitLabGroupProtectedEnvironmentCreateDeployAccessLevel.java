package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group protected environment create deploy access level of a GitLab resource.
 *
 * @param userId the user id
 * @param groupId the group id
 * @param groupInheritanceType the group inheritance type
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdProtectedEnvironments/requestBody/properties/deploy_access_levels/items")
public record GitLabGroupProtectedEnvironmentCreateDeployAccessLevel(
        @Nullable Long userId,
        @Nullable Long groupId,
        @Nullable GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType groupInheritanceType,
        @Nullable GitLabGroupProtectedEnvironmentCreateDeployAccessLevelAccessLevel accessLevel) {}
