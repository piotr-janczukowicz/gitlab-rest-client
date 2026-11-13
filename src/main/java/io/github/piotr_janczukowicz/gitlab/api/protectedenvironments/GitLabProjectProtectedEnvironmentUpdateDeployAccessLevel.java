package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project protected environment update deploy access level of a GitLab resource.
 *
 * @param userId the user id
 * @param groupId the group id
 * @param groupInheritanceType the group inheritance type
 * @param id the id
 * @param destroy the destroy
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/putApiV4ProjectsIdProtectedEnvironmentsName/requestBody/properties/deploy_access_levels/items")
public record GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel(
        @Nullable Long userId,
        @Nullable Long groupId,
        @Nullable GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelGroupInheritanceType groupInheritanceType,
        @Nullable Long id,
        @Nullable @JsonProperty("_destroy") Boolean destroy,
        @Nullable GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel accessLevel) {}
